package org.egov.integration.consumer;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.egov.integration.model.AuditDetails;
import org.egov.integration.model.FireNoc;
import org.egov.integration.model.FireNocApplicationData;
import org.egov.integration.model.FireNocApplicationDetail;
import org.egov.integration.model.FireNocDaoApplication;
import org.egov.integration.model.FireNocDaoApplicationTasks;
import org.egov.integration.model.FireNocExecutionData;
import org.egov.integration.repository.fireRepository;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class NotificationListener {

	@Autowired
	private ObjectMapper objectMapper;

	@Autowired
	private fireRepository fireRepo;

	private String UNDERPROCESS_STATUS = "UNDERPROCESS";
	private String DELIVERED_STATUS = "DELIVERED";
	private String REJECTED_STATUS = "REJECTED";

	private String DELIVERED_VALUE = "DELIVERED";
	private String REJECTED_VALUE = "REJECTED";

	private Stream<String> typeOfOccupancyUse = Stream.of("RESIDENTIAL", "EDUCATIONAL", "INSTITUTIONAL", "ASSEMBLY",
			"BUSINESS", "MERCANTILE", "INDUSTRIAL", "STORAGE", "HAZARDOUS", "BOOTH", "PLACE OF WORSHIP",
			"APARTMENT HOUSES", "PAYING GUEST BUILDING");

	@KafkaListener(topics = "${notification.firenoc.application.process.topic}")
	public void processingNewApplications(ConsumerRecord<String, Object> data)
			throws InterruptedException, ParseException, JsonParseException, JsonMappingException, IOException {
		Thread.sleep(10000L);
		log.info("Topic : " + data);
		FireNoc executionData = objectMapper.readValue(data.value().toString(), FireNoc.class);
		List<FireNoc> fireExecutionDetailsData = fireRepo.getFireExecutionDetailsData(executionData.getUuid());
		if (fireExecutionDetailsData != null && !fireExecutionDetailsData.isEmpty()) {
			JSONObject data2 = fireExecutionDetailsData.get(0).getData();
			if (data2 != null) {
				FireNocApplicationDetail applicationDetail = objectMapper.readValue(data2.toJSONString(),
						FireNocApplicationDetail.class);
				if ((applicationDetail.getExecutionData() != null && !applicationDetail.getExecutionData().isEmpty())
						|| (applicationDetail.getInitiatedData() != null
								&& !applicationDetail.getInitiatedData().isEmpty())) {
					applicationProcessing(applicationDetail);
				}
			}
		}
	}

	private void applicationProcessing(FireNocApplicationDetail applicationDetail) {
		// processing logic

		List<FireNocDaoApplication> daoApplications = new ArrayList<>();
		List<FireNocDaoApplicationTasks> daoApplicationTasks = new ArrayList<>();

		// If new data is there
		if (applicationDetail.getInitiatedData() != null && !applicationDetail.getInitiatedData().isEmpty()) {
			List<FireNocApplicationData> initiatedData = applicationDetail.getInitiatedData();
			Set<String> listOfApps = initiatedData.stream().map(e -> e.getApplicationId()).collect(Collectors.toSet());
			if (listOfApps != null && !listOfApps.isEmpty()) {
				initiatedData.stream().forEach(e -> {
					List<FireNocDaoApplication> existingAppDetails = fireRepo
							.getApplicationDataByApplicationId(e.getApplicationId().trim());
					if (existingAppDetails == null || existingAppDetails.isEmpty()) {
						JSONObject attributes = null;
						String typeOfOccupancyUseName = "";
						if (e.getAttributeDetails() != null) {
							try {
								String writeValueAsString = objectMapper.writeValueAsString(e.getAttributeDetails());
								if (!writeValueAsString.isEmpty()) {
									Optional<String> findAny = typeOfOccupancyUse
											.filter(p -> writeValueAsString.contains(p)).findAny();
									if (findAny.isPresent())
										typeOfOccupancyUseName = findAny.get();
									JSONParser jsonParser = new JSONParser();
									attributes = (JSONObject) jsonParser.parse(writeValueAsString);
								}
							} catch (ParseException e1) {
								e1.printStackTrace();
							} catch (JsonProcessingException e1) {
								e1.printStackTrace();
							}
						}

						AuditDetails auditDetails = AuditDetails.builder().createdBy("0")
								.createdTime(new Date().getTime()).lastModifiedBy("0")
								.lastModifiedTime(new Date().getTime()).build();

						FireNocDaoApplication applicationTasks = FireNocDaoApplication.builder()
								.appDetailUuid(UUID.randomUUID().toString()).applicationId(e.getApplicationId())
								.serviceId(e.getServiceId()).serviceName(e.getServiceName())
								.applicationRefNo(e.getApplicationRefNo()).departmentId(e.getDepartmentId())
								.departmentName(e.getDepartmentName()).submissionDate(e.getSubmissionDate())
								.submissionMode(e.getSubmissionMode()).submissionLocation(e.getSubmissionLocation())
								.attributeDetails(attributes).typeOfOccupancyUse(typeOfOccupancyUseName)
								.applicationStatus(UNDERPROCESS_STATUS).auditDetails(auditDetails).build();

						daoApplications.add(applicationTasks);

					}
				});

				if (!daoApplications.isEmpty()) {
					fireRepo.saveApplicationDetail(daoApplications);
				}
			}
		}

		if (applicationDetail.getExecutionData() != null && !applicationDetail.getExecutionData().isEmpty()) {
			List<FireNocExecutionData> executionData = applicationDetail.getExecutionData();
			Set<String> listOfApps = executionData.stream().map(e -> e.getTaskDetails().getApplicationId())
					.collect(Collectors.toSet());

			Map<String, FireNocDaoApplication> updatedApplicationStatuses = new HashMap<>();

			if (listOfApps != null && !listOfApps.isEmpty()) {
				listOfApps.stream().forEach(e -> {
					List<FireNocExecutionData> collect = executionData.stream()
							.filter(pre -> pre.getTaskDetails().getApplicationId().trim().equals(e.trim()))
							.sorted(new Comparator<FireNocExecutionData>() {
								@Override
								public int compare(FireNocExecutionData o1, FireNocExecutionData o2) {
									Date date1 = null;
									Date date2 = null;
									try {
										date1 = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss")
												.parse(o1.getTaskDetails().getExecutedTime());
										date2 = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss")
												.parse(o2.getTaskDetails().getExecutedTime());
									} catch (java.text.ParseException e) {
										e.printStackTrace();
									}
									if (date1 != null && date2 != null)
										return date1.compareTo(date2);
									return o2.getTaskDetails().getTaskId().compareTo(o1.getTaskDetails().getTaskId());
								}
							}).collect(Collectors.toList());

					if (!collect.isEmpty()) {
						String applicationStatus = UNDERPROCESS_STATUS;
						boolean isDelivered = collect.get(0).getOfficialFormDetails().toJSONString().toUpperCase()
								.contains(DELIVERED_VALUE);
						boolean isRejected = collect.get(0).getOfficialFormDetails().toJSONString().toUpperCase()
								.contains(REJECTED_VALUE);
						if (isDelivered)
							applicationStatus = DELIVERED_STATUS;
						else if (isRejected)
							applicationStatus = REJECTED_STATUS;
						else
							applicationStatus = UNDERPROCESS_STATUS;

						if (!updatedApplicationStatuses.containsKey(e)) {
							List<FireNocDaoApplication> applicationDataByApplicationId = fireRepo
									.getApplicationDataByApplicationId(e);
							if (applicationDataByApplicationId != null && !applicationDataByApplicationId.isEmpty()) {
								FireNocDaoApplication fireNocDaoApplication = applicationDataByApplicationId.get(0);
								if (fireNocDaoApplication.getApplicationStatus() != null && !fireNocDaoApplication
										.getApplicationStatus().equalsIgnoreCase(applicationStatus)) {
									fireNocDaoApplication.setApplicationStatus(applicationStatus);
									updatedApplicationStatuses.put(e, fireNocDaoApplication);
								}
							}
						} else {
							FireNocDaoApplication fireNocDaoApplication = updatedApplicationStatuses.get(e);
							fireNocDaoApplication.setApplicationStatus(applicationStatus);
							updatedApplicationStatuses.put(e, fireNocDaoApplication);
						}
					}

					AuditDetails auditDetails = AuditDetails.builder().createdBy("0").createdTime(new Date().getTime())
							.lastModifiedBy("0").lastModifiedTime(new Date().getTime()).build();

					collect.stream().forEach(ee -> {
						List<FireNocDaoApplicationTasks> applicationTaskDataByTaskId = fireRepo
								.getApplicationTaskDataByTaskId(ee.getTaskDetails().getTaskId());

						if (applicationTaskDataByTaskId == null || applicationTaskDataByTaskId.isEmpty()) {
							JSONObject userDetails = null;
							try {
								if (ee.getTaskDetails().getFireNocUserDetail() != null) {
									String writeValueAsString = objectMapper
											.writeValueAsString(ee.getTaskDetails().getFireNocUserDetail());
									if (!writeValueAsString.isEmpty()) {
										JSONParser jsonParser = new JSONParser();
										userDetails = (JSONObject) jsonParser.parse(writeValueAsString);
									}
								}

								String applicationStatus = UNDERPROCESS_STATUS;
								boolean isDelivered = ee.getOfficialFormDetails().toJSONString().toUpperCase()
										.contains(DELIVERED_VALUE);
								boolean isRejected = ee.getOfficialFormDetails().toJSONString().toUpperCase()
										.contains(REJECTED_VALUE);
								if (isDelivered)
									applicationStatus = DELIVERED_STATUS;
								else if (isRejected)
									applicationStatus = REJECTED_STATUS;
								else
									applicationStatus = UNDERPROCESS_STATUS;

								FireNocDaoApplicationTasks applicationTasks = FireNocDaoApplicationTasks.builder()
										.appTaskDetailUuid(UUID.randomUUID().toString())
										.applicationId(ee.getTaskDetails().getApplicationId())
										.taskId(ee.getTaskDetails().getTaskId())
										.taskName(ee.getTaskDetails().getTaskName())
										.executedTime(ee.getTaskDetails().getExecutedTime())
										.actionTaken(ee.getTaskDetails().getActionTaken())
										.applicationStatus(applicationStatus).actionTakenUserDetail(userDetails)
										.officialFormDetails(ee.getOfficialFormDetails()).auditDetails(auditDetails)
										.build();

								daoApplicationTasks.add(applicationTasks);

							} catch (JsonProcessingException e1) {
								e1.printStackTrace();
							} catch (ParseException e1) {
								e1.printStackTrace();
							}
						}
					});
				}); // End of main loop
			}

			// Insert all tasks
			if (!daoApplicationTasks.isEmpty()) {
				fireRepo.saveApplicationTaskDetail(daoApplicationTasks);
			}

			// update the main application status
			if (!updatedApplicationStatuses.isEmpty()) {
				daoApplications.clear();
				Iterator<Entry<String, FireNocDaoApplication>> entrySet = updatedApplicationStatuses.entrySet()
						.iterator();
				while (entrySet.hasNext()) {
					Entry<String, FireNocDaoApplication> next = entrySet.next();
					FireNocDaoApplication applicationStatus = next.getValue();
					AuditDetails auditDetails = applicationStatus.getAuditDetails();
					auditDetails.setLastModifiedBy("1");
					auditDetails.lastModifiedTime(new Date().getTime());
					applicationStatus.setAuditDetails(auditDetails);
					daoApplications.add(applicationStatus);
				}
				if (!daoApplications.isEmpty()) {
					fireRepo.saveApplicationDetail(daoApplications);
				}
			}
		}
	}

}
