package org.egov.pgr.service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.WordUtils;
import org.apache.commons.lang3.StringUtils;
import org.egov.common.contract.request.RequestInfo;
import org.egov.common.contract.response.ResponseInfo;
import org.egov.mdms.model.MasterDetail;
import org.egov.mdms.model.MdmsCriteria;
import org.egov.mdms.model.MdmsCriteriaReq;
import org.egov.mdms.model.MdmsResponse;
import org.egov.mdms.model.ModuleDetail;
import org.egov.pgr.contract.IUDXData;
import org.egov.pgr.contract.IUDXDataRequest;
import org.egov.pgr.contract.IUDXDataResponse;
import org.egov.pgr.contract.ReportRequest;
import org.egov.pgr.contract.ReportResponse;
import org.egov.pgr.contract.SMSRequest;
import org.egov.pgr.contract.ServiceReqSearchCriteria;
import org.egov.pgr.model.AverageSolutionTime;
import org.egov.pgr.model.Bucket;
import org.egov.pgr.model.CompletionRate;
import org.egov.pgr.model.Department;
import org.egov.pgr.model.DescriptionReportLog;
import org.egov.pgr.model.DiscriptionReport;
import org.egov.pgr.model.Grievance;
import org.egov.pgr.model.GrievanceReport;
import org.egov.pgr.model.Metric;
import org.egov.pgr.model.ReportServiceResponse;
import org.egov.pgr.model.RequestInfoWrapper;
import org.egov.pgr.model.ResponseInfoWrapper;
import org.egov.pgr.model.Sector;
import org.egov.pgr.model.ServiceDefMdms;
import org.egov.pgr.model.SlaAchievement;
import org.egov.pgr.model.LevelThreeSlaCountsResponse;
import org.egov.pgr.model.LevelfiveSlaCountsResponse;
import org.egov.pgr.model.LevelfourSlaCountsResponse;
import org.egov.pgr.model.TodaysAssignedComplaint;
import org.egov.pgr.model.TodaysClosedComplaints;
import org.egov.pgr.model.TodaysComplaint;
import org.egov.pgr.model.TodaysOpenComplaint;
import org.egov.pgr.model.TodaysReassignRequestedComplaints;
import org.egov.pgr.model.TodaysReassignedComplaint;
import org.egov.pgr.model.TodaysRejectedComplaint;
import org.egov.pgr.model.TodaysReopenedComplaint;
import org.egov.pgr.model.TodaysResolvedComplaints;
import org.egov.pgr.repository.ReportRepository;
import org.egov.pgr.repository.ServiceRequestRepository;
import org.egov.pgr.repository.rowmapper.ColumnsRowMapper;
import org.egov.pgr.utils.ErrorConstants;
import org.egov.pgr.utils.PGRConstants;
import org.egov.pgr.utils.PGRUtils;
import org.egov.pgr.utils.ReportConstants;
import org.egov.pgr.utils.ReportUtils;
import org.egov.tracer.model.CustomException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jayway.jsonpath.JsonPath;

import lombok.extern.slf4j.Slf4j;
import net.minidev.json.JSONArray;

@Service
@Slf4j
public class ReportService {

	@Autowired
	private ReportRepository repository;

	@Autowired
	private ServiceRequestRepository serviceRequestRepository;

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	public NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	@Autowired
	private ColumnsRowMapper rowMapper;

	@Autowired
	private ReportUtils reportUtils;

	private final String mdmsBySearchCriteriaUrl;

	@Autowired
	private PGRUtils pGRUtils;
	
	 @Value("${notification.sms.enabled}")
	 private Boolean isSMSNotificationEnabled;

	@Autowired
	public ReportService(@Value("${egov.mdms.host}") final String mdmsServiceHostname,
			@Value("${egov.mdms.search.endpoint}") final String mdmsBySearchCriteriaUrl) {
		this.mdmsBySearchCriteriaUrl = mdmsServiceHostname + mdmsBySearchCriteriaUrl;
	}

	@Autowired
	private PGRUtils pgrUtils;

	public ReportResponse getReports(ReportRequest reportRequest) {
		reportUtils.validateReportRequest(reportRequest);
		createViewForSLA(reportRequest, false);
		List<Map<String, Object>> dbResponse = repository.getDataFromDb(reportRequest);
		if (CollectionUtils.isEmpty(dbResponse)) {
			return reportUtils.getDefaultResponse(reportRequest);
		}
		createViewForSLA(reportRequest, true);
		return enrichAndFormatResponse(reportRequest, dbResponse);
	}

	public void createViewForSLA(ReportRequest reportRequest, Boolean shouldViewBeDropped) {
		repository.createOrDropViewDb(reportRequest, shouldViewBeDropped);
	}

	public ReportResponse enrichAndFormatResponse(ReportRequest reportRequest, List<Map<String, Object>> dbResponse) {
		if (reportRequest.getReportName().equalsIgnoreCase(ReportConstants.COMPLAINT_TYPE_REPORT)) {
			enrichComplaintTypeWiseReport(reportRequest, dbResponse);
		} else if (reportRequest.getReportName().equalsIgnoreCase(ReportConstants.AO_REPORT)) {
			enrichAOWiseReport(reportRequest, dbResponse);
		} else if (reportRequest.getReportName().equalsIgnoreCase(ReportConstants.DEPARTMENT_REPORT)) {
			dbResponse = enrichDepartmentWiseReport(reportRequest, dbResponse);
		} else if (reportRequest.getReportName().equalsIgnoreCase(ReportConstants.SOURCE_REPORT)) {
			dbResponse = enrichSourceWiseReport(reportRequest, dbResponse);
		} else if (reportRequest.getReportName().equalsIgnoreCase(ReportConstants.ULBEMPLOYEE_REPORT)) {
			enrichFunctionaryWiseReport(reportRequest, dbResponse);
		}
		return reportUtils.formatDBResponse(reportRequest, dbResponse);
	}

	public void enrichComplaintTypeWiseReport(ReportRequest reportRequest, List<Map<String, Object>> dbResponse) {
		for (Map<String, Object> tuple : dbResponse) {
			tuple.put("complaint_type", reportUtils.splitCamelCase(tuple.get("complaint_type").toString()));
			tuple.put("total_open_complaints",
					reportUtils.getPercentage(tuple.get("total_complaints"), tuple.get("total_open_complaints")));
			tuple.put("outside_sla",
					reportUtils.getPercentage(tuple.get("total_complaints"), tuple.get("outside_sla")));
			tuple.put("avg_citizen_rating", reportUtils.getAvgRating(tuple.get("avg_citizen_rating")));
		}
	}

	public void enrichAOWiseReport(ReportRequest reportRequest, List<Map<String, Object>> dbResponse) {
		List<Long> GROids = dbResponse.parallelStream().map(obj -> {
			return Long.valueOf(obj.get("ao_name").toString().split("[:]")[0]);
		}).collect(Collectors.toList());

		Map<Long, String> mapOfIdAndName = getEmployeeDetails(reportRequest, GROids);

		for (Map<String, Object> tuple : dbResponse) {
			String name = mapOfIdAndName.get(Long.valueOf(tuple.get("ao_name").toString().split("[:]")[0]));
			tuple.put("ao_name", !StringUtils.isEmpty(name) ? name : tuple.get("ao_name").toString().split("[:]")[0]);
			tuple.put("complaints_unassigned",
					((Long.valueOf(tuple.get("total_complaints_received").toString()))
							- ((Long.valueOf(tuple.get("complaints_assigned").toString()))
									+ (Long.valueOf(tuple.get("complaints_rejected").toString())))));

			tuple.put("complaints_assigned", reportUtils.getPercentage(tuple.get("total_complaints_received"),
					tuple.get("complaints_assigned")));
			tuple.put("complaints_rejected", reportUtils.getPercentage(tuple.get("total_complaints_received"),
					tuple.get("complaints_rejected")));
			tuple.put("complaints_unassigned", reportUtils.getPercentage(tuple.get("total_complaints_received"),
					tuple.get("complaints_unassigned")));
		}

	}

	public List<Map<String, Object>> enrichDepartmentWiseReport(ReportRequest reportRequest,
			List<Map<String, Object>> dbResponse) {
		Map<String, String> mapOfServiceCodesAndDepts = getServiceDefsData(reportRequest, false);
		Map<String, Integer> mapOfDeptAndIndex = new HashMap<>();
		List<Map<String, Object>> enrichedResponse = new ArrayList<>();
		for (Map<String, Object> tuple : dbResponse) {
			String department = mapOfServiceCodesAndDepts.get(tuple.get("department_name"));
			if (StringUtils.isEmpty(department)) {
				continue;
			}
			if (null == mapOfDeptAndIndex.get(department)) {
				tuple.put("department_name", department);
				enrichedResponse.add(tuple);
				mapOfDeptAndIndex.put(department, enrichedResponse.indexOf(tuple));
			} else {
				Map<String, Object> parentTuple = enrichedResponse.get(mapOfDeptAndIndex.get(department));
				for (String key : parentTuple.keySet()) {
					if (key.equalsIgnoreCase("department_name"))
						continue;
					if (key.equalsIgnoreCase("avg_citizen_rating")) {
						Double rating = (Double
								.valueOf(null != parentTuple.get(key) ? parentTuple.get(key).toString() : "0")
								+ Double.valueOf(null != tuple.get(key) ? tuple.get(key).toString() : "0"));
						parentTuple.put(key, rating / 2);
					} else {
						parentTuple.put(key,
								(Long.valueOf(null != parentTuple.get(key) ? parentTuple.get(key).toString() : "0")
										+ Long.valueOf(null != tuple.get(key) ? tuple.get(key).toString() : "0")));
					}
				}
				enrichedResponse.add(mapOfDeptAndIndex.get(department), parentTuple);
				enrichedResponse.remove(mapOfDeptAndIndex.get(department) + 1);
			}
		}
		for (Map<String, Object> tuple : enrichedResponse) {
			tuple.put("total_open_complaints",
					reportUtils.getPercentage(tuple.get("total_complaints"), tuple.get("total_open_complaints")));
			tuple.put("outside_sla",
					reportUtils.getPercentage(tuple.get("total_complaints"), tuple.get("outside_sla")));
			tuple.put("avg_citizen_rating", reportUtils.getAvgRating(tuple.get("avg_citizen_rating")));
		}
		return enrichedResponse;
	}

	public List<Map<String, Object>> enrichSourceWiseReport(ReportRequest reportRequest,
			List<Map<String, Object>> dbResponse) {
		List<Map<String, Object>> enrichedResponse = new ArrayList<>();
		Map<String, Object> tuple = dbResponse.get(0);
		Long total = Long
				.valueOf((null == tuple.get("citizen_mobile_app")) ? "0" : tuple.get("citizen_mobile_app").toString())
				+ Long.valueOf((null == tuple.get("citizen_web_app")) ? "0" : tuple.get("citizen_web_app").toString())
				+ Long.valueOf((null == tuple.get("customer_service_desk")) ? "0"
						: tuple.get("customer_service_desk").toString());
		for (String key : dbResponse.get(0).keySet()) {
			Map<String, Object> newtuple = new LinkedHashMap<>();
			newtuple.put("Source", WordUtils.capitalize(key.replaceAll("[_]", " ")));
			newtuple.put("Complaints Received", reportUtils.getPercentage(total, tuple.get(key)));
			enrichedResponse.add(newtuple);
		}

		return enrichedResponse;
	}

	public void enrichFunctionaryWiseReport(ReportRequest reportRequest, List<Map<String, Object>> dbResponse) {
		List<Long> employeeIds = new ArrayList<>();
		for (Map<String, Object> tuple : dbResponse) {
			employeeIds.add(
					Long.valueOf((null == tuple.get("employee_name")) ? "0" : tuple.get("employee_name").toString()));
		}

		Map<Long, String> mapOfIdAndName = getEmployeeDetails(reportRequest, employeeIds);

		for (Map<String, Object> tuple : dbResponse) {
			log.info("tuple: " + tuple);
			String name = mapOfIdAndName.get(
					Long.valueOf((null == tuple.get("employee_name")) ? "0" : tuple.get("employee_name").toString()));
			tuple.put("employee_name", StringUtils.isEmpty(name) ? "No-Name" : name);
			tuple.put("total_open_complaints", reportUtils.getPercentage(tuple.get("total_complaints_received"),
					tuple.get("total_open_complaints")));
			tuple.put("outside_sla",
					reportUtils.getPercentage(tuple.get("total_complaints_received"), tuple.get("outside_sla")));
			tuple.put("avg_citizen_rating", reportUtils.getAvgRating(tuple.get("avg_citizen_rating")));
		}

	}

	public Map<Long, String> getEmployeeDetails(ReportRequest reportRequest, List<Long> employeeIds) {
		Map<Long, String> mapOfIdAndName = new HashMap<>();
		try {
			ObjectMapper mapper = pgrUtils.getObjectMapper();
			StringBuilder uri = new StringBuilder();
			Object request = reportUtils.getGROSearchRequest(uri, employeeIds, reportRequest);
			Object response = serviceRequestRepository.fetchResult(uri, request);
			if (null != response) {
				List<Map<String, Object>> resultCast = mapper
						.convertValue(JsonPath.read(response, PGRConstants.EMPLOYEE_BASE_JSONPATH), List.class);
				for (Map<String, Object> employee : resultCast) {
					Map<String, Object> user = (Map) employee.get("user");
					mapOfIdAndName.put(Long.parseLong(employee.get("id").toString()), user.get("name").toString());
				}
			}
			log.debug("mapOfIdAndName: " + mapOfIdAndName);
		} catch (Exception e) {
			log.error("Exception while searching employee: ", e);
		}
		return mapOfIdAndName;
	}

	public Map<String, String> getServiceDefsData(ReportRequest reportRequest, Boolean iWantSlahours) {
		Map<String, String> mapOfServiceCodesAndDepts = new HashMap<>();
		Map<String, String> mapOfServiceCodesAndSLA = new HashMap<>();
		ObjectMapper mapper = pgrUtils.getObjectMapper();
		StringBuilder uri = new StringBuilder();
		Object request = reportUtils.getRequestForServiceDefsSearch(uri, reportRequest.getTenantId(),
				reportRequest.getRequestInfo());
		Object response = serviceRequestRepository.fetchResult(uri, request);
		if (null != response) {
			Map<String, String> deptCodeAndNameMap = new HashMap<>();
			List<Map<String, Object>> resultCast = mapper
					.convertValue(JsonPath.read(response, "$.MdmsRes.RAINMAKER-PGR.ServiceDefs"), List.class);

			for (Map<String, Object> serviceDef : resultCast) {
				if (StringUtils.isEmpty(deptCodeAndNameMap.get(serviceDef.get("department").toString()))) {
					List<String> departmentCodes = new ArrayList<>();
					departmentCodes.add(serviceDef.get("department").toString());
					List<String> depts = reportUtils.getDepartment(reportRequest.getRequestInfo(), departmentCodes,
							reportRequest.getTenantId());
					if (!CollectionUtils.isEmpty(depts)) {
						deptCodeAndNameMap.put(serviceDef.get("department").toString(), depts.get(0));
					}
					mapOfServiceCodesAndDepts.put(serviceDef.get("serviceCode").toString(), "NA");
				} else {
					mapOfServiceCodesAndDepts.put(serviceDef.get("serviceCode").toString(),
							deptCodeAndNameMap.get(serviceDef.get("department").toString()));
				}
				mapOfServiceCodesAndSLA.put(serviceDef.get("serviceCode").toString(),
						serviceDef.get("slaHours").toString());
			}

		}
		if (iWantSlahours)
			return mapOfServiceCodesAndSLA;
		else
			return mapOfServiceCodesAndDepts;
	}

	public List<Map<String, Object>> getServiceDefsData1(ReportRequest reportRequest, Boolean iWantSlahours) {

		ObjectMapper mapper = pgrUtils.getObjectMapper();
		StringBuilder uri = new StringBuilder();
		Object request = reportUtils.getRequestForServiceDefsSearch(uri, reportRequest.getTenantId(),
				reportRequest.getRequestInfo());
		Object response = serviceRequestRepository.fetchResult(uri, request);

		List<Map<String, Object>> resultCast = mapper
				.convertValue(JsonPath.read(response, "$.MdmsRes.RAINMAKER-PGR.ServiceDefs"), List.class);
		return resultCast;
	}

	public Map<String, Department> getDeptName(String tenantId, final ObjectMapper mapper, RequestInfo requestInfo) {
		net.minidev.json.JSONArray responseJSONArray = getByCriteria(tenantId, "RAINMAKER-PGR", "PgrDepartment", null,
				null, requestInfo);
		Map<String, Department> deptMap = new HashMap<>();

		if (responseJSONArray != null && responseJSONArray.size() > 0) {
			for (int i = 0; i < responseJSONArray.size(); i++) {
				Department dept = mapper.convertValue(responseJSONArray.get(i), Department.class);
				deptMap.put(dept.getCode(), dept);
				deptMap.put(dept.getName(), dept);
			}

		}
		return deptMap;
	}

	public Map<String, ServiceDefMdms> getServiceName(String tenantId, final ObjectMapper mapper,
			RequestInfo requestInfo) {
		net.minidev.json.JSONArray responseJSONArray = getByCriteria(tenantId, "RAINMAKER-PGR", "ServiceDefs", null,
				null, requestInfo);
		Map<String, ServiceDefMdms> serviceDefMap = new HashMap<>();

		if (responseJSONArray != null && responseJSONArray.size() > 0) {
			for (int i = 0; i < responseJSONArray.size(); i++) {
				ServiceDefMdms serviceDef = mapper.convertValue(responseJSONArray.get(i), ServiceDefMdms.class);
				serviceDefMap.put(serviceDef.getServiceCode(), serviceDef);
				serviceDefMap.put(serviceDef.getDepartment(), serviceDef);
			}

		}
		return serviceDefMap;
	}

	public Map<String, Sector> getSectorName(String tenantId, final ObjectMapper mapper, RequestInfo requestInfo) {
		net.minidev.json.JSONArray responseJSONArray = getByCriteria(tenantId, "RAINMAKER-PGR", "Sector", null, null,
				requestInfo);
		Map<String, Sector> sectorMap = new HashMap<>();

		if (responseJSONArray != null && responseJSONArray.size() > 0) {
			for (int i = 0; i < responseJSONArray.size(); i++) {
				Sector sector = mapper.convertValue(responseJSONArray.get(i), Sector.class);
				sectorMap.put(sector.getCode(), sector);
				sectorMap.put(sector.getName(), sector);
			}

		}
		return sectorMap;
	}

	public JSONArray getByCriteria(final String tenantId, final String moduleName, final String masterName,
			final String filterFieldName, final String filterFieldValue, final RequestInfo info) {

		List<MasterDetail> masterDetails;
		List<ModuleDetail> moduleDetails;
		MdmsCriteriaReq request = null;
		MdmsResponse response = null;
		masterDetails = new ArrayList<>();
		moduleDetails = new ArrayList<>();

		masterDetails.add(MasterDetail.builder().name(masterName).build());
		if (filterFieldName != null && filterFieldValue != null && !filterFieldName.isEmpty()
				&& !filterFieldValue.isEmpty())
			masterDetails.get(0).setFilter("[?(@." + filterFieldName + " == '" + filterFieldValue + "')]");
		moduleDetails.add(ModuleDetail.builder().moduleName(moduleName).masterDetails(masterDetails).build());

		request = MdmsCriteriaReq.builder().mdmsCriteria(
				MdmsCriteria.builder().moduleDetails(moduleDetails).tenantId(getTenantId(tenantId, moduleName)).build())
				.requestInfo(info).build();
		response = restTemplate.postForObject(mdmsBySearchCriteriaUrl, request, MdmsResponse.class);
		if (response == null || response.getMdmsRes() == null || !response.getMdmsRes().containsKey(moduleName)
				|| response.getMdmsRes().get(moduleName) == null
				|| !response.getMdmsRes().get(moduleName).containsKey(masterName)
				|| response.getMdmsRes().get(moduleName).get(masterName) == null)
			return null;
		else
			return response.getMdmsRes().get(moduleName).get(masterName);
	}

	private String getTenantId(String tenantId, String moduleName) {
		return tenantId.split("\\.")[0];
	}

	public ResponseEntity<ResponseInfoWrapper> process(RequestInfoWrapper request,
			ServiceReqSearchCriteria serviceReqSearchCriteria) {
		List<DiscriptionReport> list = new ArrayList<>();
		ObjectMapper mapper = new ObjectMapper();
		Map<String, ServiceDefMdms> mapOfServiceCodesAndDepts = getServiceName(
				request.getRequestInfo().getUserInfo().getTenantId(), mapper, new RequestInfo());
		Map<String, Department> mapOfDepts = getDeptName(request.getRequestInfo().getUserInfo().getTenantId(), mapper,
				new RequestInfo());
		Map<String, Sector> mapOfSectors = getSectorName(request.getRequestInfo().getUserInfo().getTenantId(), mapper,
				new RequestInfo());
		Map<String, Object> paramValues = new HashMap<>();
		// paramValues.put("sla", mapOfServiceCodesAndDepts.get(key));
		list = serviceRequestRepository.fetchDescriptionDetails(serviceReqSearchCriteria);
		/*
		 * list = namedParameterJdbcTemplate.query(ReportQueryBuilder.
		 * GET_DISCRIPTION_REPORT_QUERY, paramValues, rowMapper);
		 */
		if (list.size() > 0) {
			for (DiscriptionReport data : list) {
				// String sla=
				// namedParameterJdbcTemplate.query(ReportQueryBuilder.GET_SLAHOURS_QUERY,
				// paramValues, rowMapper);
				data.setDepartment(
						mapOfDepts.get(mapOfServiceCodesAndDepts.get(data.getServicecode()).getDepartment()).getName());
				data.setLocality(
						mapOfSectors.get(data.getLocality()) != null ? mapOfSectors.get(data.getLocality()).getName()
								: "");
				repository.saveData(request, data);
				Long dt = System.currentTimeMillis();
				DescriptionReportLog descriptionLog = new DescriptionReportLog(String.valueOf(dt),"SUCCESS", "Scheduler run successfully");
				repository.saveLogData(request, descriptionLog);
			}
		}

		return new ResponseEntity<>(ResponseInfoWrapper.builder()
				.responseInfo(ResponseInfo.builder().status("SUCCESS").build()).responseBody(null).build(),
				HttpStatus.OK);
	}

	public GrievanceReport getGrievanceReport(RequestInfo requestInfo,
			ServiceReqSearchCriteria serviceReqSearchCriteria) {
		// TODO Auto-generated method stub

		List<Grievance> fetchGrievenceDetails = serviceRequestRepository
				.fetchGrievanceDetails(serviceReqSearchCriteria);
		GrievanceReport grievenceReport = new GrievanceReport();

		if (fetchGrievenceDetails != null && !fetchGrievenceDetails.isEmpty()) {

			Metric metrics = Metric.builder().build();

			String fetchUniqueCitizens = serviceRequestRepository.fetchUniqueCitizens();
			metrics.setUniqueCitizens(Integer.parseInt(fetchUniqueCitizens));

			List<Bucket> todaysComplaintByStatusBucket = fetchGrievenceDetails.stream().collect(
					Collectors.groupingBy(Grievance::getStatus, Collectors.summingInt(Grievance::getAllcomplaints)))
					.entrySet().stream().map(e -> {
						return new Bucket(e.getKey(), new BigDecimal(e.getValue()));
					}).collect(Collectors.toList());

			TodaysComplaint todaysComplaintByStatus = TodaysComplaint.builder().groupBy("status")
					.buckets(todaysComplaintByStatusBucket).build();

			List<Bucket> todaysComplaintByChannelBucket = fetchGrievenceDetails.stream().collect(
					Collectors.groupingBy(Grievance::getSource, Collectors.summingInt(Grievance::getAllcomplaints)))
					.entrySet().stream().map(e -> {
						return new Bucket(e.getKey(), new BigDecimal(e.getValue()));
					}).collect(Collectors.toList());

			TodaysComplaint todaysComplaintByChannel = TodaysComplaint.builder().groupBy("channel")
					.buckets(todaysComplaintByChannelBucket).build();

			List<Bucket> todaysComplaintByDepartmentBucket = fetchGrievenceDetails.stream().collect(Collectors
					.groupingBy(Grievance::getServicecode, Collectors.summingInt(Grievance::getAllcomplaints)))
					.entrySet().stream().map(e -> {
						return new Bucket(e.getKey(), new BigDecimal(e.getValue()));
					}).collect(Collectors.toList());

			TodaysComplaint todaysComplaintByDepartment = TodaysComplaint.builder().groupBy("department")
					.buckets(todaysComplaintByDepartmentBucket).build();

			List<Bucket> todaysComplaintByCategoryBucket = fetchGrievenceDetails.stream().collect(
					Collectors.groupingBy(Grievance::getCategory, Collectors.summingInt(Grievance::getAllcomplaints)))
					.entrySet().stream().map(e -> {
						return new Bucket(e.getKey(), new BigDecimal(e.getValue()));
					}).collect(Collectors.toList());

			TodaysComplaint todaysComplaintByCategory = TodaysComplaint.builder().groupBy("category")
					.buckets(todaysComplaintByCategoryBucket).build();

			List<TodaysComplaint> todaysComplaint = Arrays.asList(todaysComplaintByStatus, todaysComplaintByChannel,
					todaysComplaintByDepartment, todaysComplaintByCategory);
			metrics.setTodaysComplaints(todaysComplaint);

			// Re-Opened
			List<Bucket> todaysComplaintByDepartmentReopenBucket = fetchGrievenceDetails.stream().collect(
					Collectors.groupingBy(Grievance::getServicecode, Collectors.summingInt(Grievance::getReopen)))
					.entrySet().stream().map(e -> {
						return new Bucket(e.getKey(), new BigDecimal(e.getValue()));
					}).collect(Collectors.toList());

			TodaysReopenedComplaint todaysReopenedComplaint = TodaysReopenedComplaint.builder().groupBy("department")
					.buckets(todaysComplaintByDepartmentReopenBucket).build();

			metrics.setTodaysReopenedComplaints(Arrays.asList(todaysReopenedComplaint));

			// Opened
			List<Bucket> todaysComplaintByDepartmentOpenBucket = fetchGrievenceDetails.stream()
					.collect(
							Collectors.groupingBy(Grievance::getServicecode, Collectors.summingInt(Grievance::getOpen)))
					.entrySet().stream().map(e -> {
						return new Bucket(e.getKey(), new BigDecimal(e.getValue()));
					}).collect(Collectors.toList());

			TodaysOpenComplaint todaysOpenComplaint = TodaysOpenComplaint.builder().groupBy("department")
					.buckets(todaysComplaintByDepartmentOpenBucket).build();

			metrics.setTodaysOpenComplaints(Arrays.asList(todaysOpenComplaint));

			// Assigned
			List<Bucket> todaysComplaintByDepartmentAssignedBucket = fetchGrievenceDetails.stream().collect(
					Collectors.groupingBy(Grievance::getServicecode, Collectors.summingInt(Grievance::getAssigned)))
					.entrySet().stream().map(e -> {
						return new Bucket(e.getKey(), new BigDecimal(e.getValue()));
					}).collect(Collectors.toList());

			TodaysAssignedComplaint todaysAssignedComplaint = TodaysAssignedComplaint.builder().groupBy("department")
					.buckets(todaysComplaintByDepartmentAssignedBucket).build();

			metrics.setTodaysAssignedComplaints(Arrays.asList(todaysAssignedComplaint));

			// Rejected
			List<Bucket> todaysComplaintByDepartmentRejectedBucket = fetchGrievenceDetails.stream().collect(
					Collectors.groupingBy(Grievance::getServicecode, Collectors.summingInt(Grievance::getRejected)))
					.entrySet().stream().map(e -> {
						return new Bucket(e.getKey(), new BigDecimal(e.getValue()));
					}).collect(Collectors.toList());

			TodaysRejectedComplaint todaysRejectedComplaint = TodaysRejectedComplaint.builder().groupBy("department")
					.buckets(todaysComplaintByDepartmentRejectedBucket).build();

			metrics.setTodaysRejectedComplaints(Arrays.asList(todaysRejectedComplaint));

			// Reassigned
			List<Bucket> todaysComplaintByDepartmentReassignedBucket = fetchGrievenceDetails.stream().collect(Collectors
					.groupingBy(Grievance::getServicecode, Collectors.summingInt(Grievance::getReassignrequested)))
					.entrySet().stream().map(e -> {
						return new Bucket(e.getKey(), new BigDecimal(e.getValue()));
					}).collect(Collectors.toList());

			TodaysReassignedComplaint todaysReassignedComplaint = TodaysReassignedComplaint.builder()
					.groupBy("department").buckets(todaysComplaintByDepartmentReassignedBucket).build();

			metrics.setTodaysReassignedComplaints(Arrays.asList(todaysReassignedComplaint));

			// Resolved
			List<Bucket> todaysResolvedComplaintsByDepartmentBucket = fetchGrievenceDetails.stream().collect(
					Collectors.groupingBy(Grievance::getServicecode, Collectors.summingInt(Grievance::getResolved)))
					.entrySet().stream().map(e -> {
						return new Bucket(e.getKey(), new BigDecimal(e.getValue()));
					}).collect(Collectors.toList());

			TodaysResolvedComplaints todaysResolvedComplaintsByDepartment = TodaysResolvedComplaints.builder()
					.groupBy("department").buckets(todaysResolvedComplaintsByDepartmentBucket).build();

			metrics.setTodaysResolvedComplaints(Arrays.asList(todaysResolvedComplaintsByDepartment));

			// ReassignRequested
			List<Bucket> todaysReassignRequestedComplaintsByDepartmentBucket = fetchGrievenceDetails.stream()
					.collect(Collectors.groupingBy(Grievance::getServicecode,
							Collectors.summingInt(Grievance::getReassignrequested)))
					.entrySet().stream().map(e -> {
						return new Bucket(e.getKey(), new BigDecimal(e.getValue()));
					}).collect(Collectors.toList());

			TodaysReassignRequestedComplaints todaysReassignRequestedComplaintsByDepartment = TodaysReassignRequestedComplaints
					.builder().groupBy("department").buckets(todaysReassignRequestedComplaintsByDepartmentBucket)
					.build();

			metrics.setTodaysReassignRequestedComplaints(Arrays.asList(todaysReassignRequestedComplaintsByDepartment));

			// Closed
			List<Bucket> todaysClosedComplaintsByDepartmentBucket = fetchGrievenceDetails.stream().collect(
					Collectors.groupingBy(Grievance::getServicecode, Collectors.summingInt(Grievance::getClosed)))
					.entrySet().stream().map(e -> {
						return new Bucket(e.getKey(), new BigDecimal(e.getValue()));
					}).collect(Collectors.toList());

			TodaysClosedComplaints todaysClosedComplaintsByDepartment = TodaysClosedComplaints.builder()
					.groupBy("department").buckets(todaysClosedComplaintsByDepartmentBucket).build();

			metrics.setTodaysClosedComplaints(Arrays.asList(todaysClosedComplaintsByDepartment));

			List<Bucket> departmentsClosedBucket = fetchGrievenceDetails.stream().collect(Collectors
					.groupingBy(Grievance::getServicecode, Collectors.summingInt(Grievance::getClosedcomplaints)))
					.entrySet().stream().map(e -> {
						return new Bucket(e.getKey(), new BigDecimal(e.getValue()));
					}).collect(Collectors.toList());

			List<Bucket> departmentsTotalBucket = fetchGrievenceDetails.stream().collect(Collectors
					.groupingBy(Grievance::getServicecode, Collectors.summingInt(Grievance::getTotalComplaints)))
					.entrySet().stream().map(e -> {
						return new Bucket(e.getKey(), new BigDecimal(e.getValue()));
					}).collect(Collectors.toList());

			List<Bucket> listCompletionRate = new ArrayList<Bucket>();
			if (!departmentsClosedBucket.isEmpty() && !departmentsTotalBucket.isEmpty()) {
				for (Bucket b : departmentsTotalBucket) {
					Optional<Bucket> findAny = departmentsClosedBucket.stream()
							.filter(e -> e.getName().equals(b.getName())).findAny();
					if (findAny.isPresent()) {
						Bucket bucket = Bucket.builder().name(b.getName()).value(new BigDecimal(0.0)).build();
						if (findAny.get().getValue().compareTo(BigDecimal.ZERO) > 0
								&& b.getValue().compareTo(BigDecimal.ZERO) > 0) {
							BigDecimal res1 = new BigDecimal(findAny.get().getValue().toBigInteger());
							BigDecimal res2 = new BigDecimal(b.getValue().toBigInteger());
							bucket.setValue(res1.divide(res2, 2, RoundingMode.HALF_EVEN));
							listCompletionRate.add(bucket);
						}
					}
				}
			}

			CompletionRate completionRate = CompletionRate.builder().groupBy("department").buckets(listCompletionRate)
					.build();
			metrics.setCompletionRate(Arrays.asList(completionRate));

			List<Bucket> listSLAAchievement = new ArrayList<Bucket>();
			List<Bucket> listAverageSolutionTime = new ArrayList<Bucket>();
			ObjectMapper mapper = new ObjectMapper();
			Object response = fetchGrievancesSLAAchievement(requestInfo, serviceReqSearchCriteria);

			try {
				ReportServiceResponse resultCast = mapper.convertValue(response, ReportServiceResponse.class);
				if (resultCast.getReportResponses() != null && !resultCast.getReportResponses().isEmpty()) {
					if (resultCast.getReportResponses().get(0).getReportData() != null
							&& !resultCast.getReportResponses().get(0).getReportData().isEmpty()) {
						for (List<Object> list : resultCast.getReportResponses().get(0).getReportData()) {
							Bucket bucket = Bucket.builder().name(list.get(0).toString())
									.value(new BigDecimal(list.get(1).toString())).build();
							listSLAAchievement.add(bucket);
							Bucket bucketAt = Bucket.builder().name(list.get(0).toString())
									.value(new BigDecimal(list.get(2).toString())).build();
							listAverageSolutionTime.add(bucketAt);
						}
					}
				}

				SlaAchievement slaAchievement = SlaAchievement.builder().groupBy("department")
						.buckets(listSLAAchievement).build();
				metrics.setSlaAchievement(Arrays.asList(slaAchievement));

				AverageSolutionTime averageSolutionTime = AverageSolutionTime.builder().groupBy("department")
						.buckets(listAverageSolutionTime).build();
				metrics.setAverageSolutionTime(Arrays.asList(averageSolutionTime));
				grievenceReport.setMetrics(metrics);

				// Completion Days Calculation

				Integer closedComplaints = 0;
				for (Bucket buckets : todaysClosedComplaintsByDepartmentBucket) {
					closedComplaints = closedComplaints + buckets.getValue().intValue();
				}

				Integer resolvedComplaints = 0;
				for (Bucket buckets : todaysResolvedComplaintsByDepartmentBucket) {
					resolvedComplaints = resolvedComplaints + buckets.getValue().intValue();
				}

				Integer completionDaysClosed = fetchGrievenceDetails.stream().reduce(0,
						(s, ob) -> s + ob.getCompletionDaysClosed() + ob.getCompletionDaysClosed(), Integer::sum);

				Integer completionDaysResolved = fetchGrievenceDetails.stream().reduce(0,
						(s, ob) -> s + ob.getCompletionDaysResolved() + ob.getCompletionDaysResolved(), Integer::sum);

				metrics.setAvgDaysForApplication(
						resolvedComplaints > 0 ? completionDaysResolved / resolvedComplaints : 0);
				metrics.setStipulatedDays(closedComplaints > 0 ? completionDaysClosed / closedComplaints : 0);

			} catch (Exception e) {
				throw new CustomException(ErrorConstants.ERROR_CODE_GRIVENCE, e.getMessage());
			}
			return grievenceReport;
		}

		throw new CustomException(ErrorConstants.ERROR_CODE_GRIVENCE, ErrorConstants.ERROR_MESSAGE_GRIVENCE);
	}

	public Object fetchGrievancesSLAAchievement(RequestInfo requestInfo,
			ServiceReqSearchCriteria serviceReqSearchCriteria) {
		StringBuilder uri = new StringBuilder();
		ReportRequest reportRequest = pGRUtils.prepareSearchGrievancesSLAAchievement(uri,
				serviceReqSearchCriteria.getTenantId(), serviceReqSearchCriteria.getStartDate(),
				serviceReqSearchCriteria.getEndDate(), requestInfo);
		Object response = null;
		try {
			response = serviceRequestRepository.fetchResult(uri, reportRequest);
		} catch (Exception e) {
			log.error("Exception while fetching serviceCodes: " + e);
		}
		return response;

	}

	@SuppressWarnings("unchecked")
	public ResponseEntity getIUDXDataReports(IUDXDataRequest iudxDataRequest) {
		if (iudxDataRequest.getRequestData() != null && iudxDataRequest.getRequestData().getTenantId() != null
				&& !iudxDataRequest.getRequestData().getTenantId().isEmpty()
				&& iudxDataRequest.getRequestData().getFromDate() != null
				&& iudxDataRequest.getRequestData().getToDate() != null) {
			IUDXData iudxNocData = repository.getIUDXDataReports(iudxDataRequest);

			if (iudxNocData != null)
				iudxNocData.setCityName("chandigarh");
			else {
				return new ResponseEntity(IUDXDataResponse.builder()
						.responseInfo(ResponseInfo.builder().status("Fail").msgId("No record found").build())
						.iudxData(null).build(), HttpStatus.OK);
			}

			return new ResponseEntity(IUDXDataResponse.builder()
					.responseInfo(ResponseInfo.builder().status("Success").build()).iudxData(iudxNocData).build(),
					HttpStatus.OK);
		} else {
			return new ResponseEntity(IUDXDataResponse.builder()
					.responseInfo(ResponseInfo.builder().status("Fail")
							.msgId("tenant id, from date, todate are mandatory").build())
					.iudxData(null).build(), HttpStatus.OK);
		}
	}
	
	public ResponseEntity<ResponseInfoWrapper> LevelThreeprocess(RequestInfoWrapper request) {
		
	LevelThreeSlaCountsResponse slaCountsResponse=null;
	try {			
	Map<String, Map<String, List<String>>> getlevelthreesmsRoutingData = getlevelthreesmsRoutingData(request);
	
	// Store SLA counts for each category
    Map<String,Integer> sePublicHealthCounts = new HashMap<>();
    Map<String, Integer> seBRCounts = new HashMap<>();
    Map<String, Integer> seHECounts = new HashMap<>();
    Map<String, Integer> mohCounts = new HashMap<>();
	
	
	Map<String, List<String>> sepublichealth = getlevelthreesmsRoutingData.get(PGRConstants.ROLE_PH);	
	
	for (Map.Entry<String, List<String>> entry : sepublichealth.entrySet()) {

	    String key = entry.getKey();
	    
	    List<String> value = entry.getValue();
	    
	    System.out.println("Key: " + key);
	    System.out.println("Value: " + value);
	   	       
	    int unresolvedSLACount = serviceRequestRepository.getUnresolvedSLACount(key,value);	    	    
	    sePublicHealthCounts.put(entry.getKey(), unresolvedSLACount);
	}	
	Map<String, List<String>> seBRData = getlevelthreesmsRoutingData.get(PGRConstants.ROLE_BR);
	for (Map.Entry<String, List<String>> entry : seBRData.entrySet()) {

	    String key = entry.getKey();
	    
	    List<String> value = entry.getValue();
	    
	    System.out.println("Key: " + key);
	    System.out.println("Value: " + value);
	    	    
	    int unresolvedSLACount1 = serviceRequestRepository.getUnresolvedSLACount1(key,value);
	    	    
	    seBRCounts.put(entry.getKey(), unresolvedSLACount1);  
	}	
	Map<String, List<String>> seHR = getlevelthreesmsRoutingData.get(PGRConstants.ROLE_HE);
	for (Map.Entry<String, List<String>> entry : seHR.entrySet()) {

	    String key = entry.getKey();

	    List<String> value = entry.getValue();
	    
	    System.out.println("Key: " + key);
	    System.out.println("Value: " + value);
	    	    
	    int unresolvedSLACount2 = serviceRequestRepository.getUnresolvedSLACount2(key,value);
	        
	    seHECounts.put(entry.getKey(), unresolvedSLACount2);
	}
	
	Map<String, List<String>> MOH = getlevelthreesmsRoutingData.get(PGRConstants.ROLE_MOH);
	for (Map.Entry<String, List<String>> entry : MOH.entrySet()) {
		
	    String key = entry.getKey();
	    
	    List<String> value = entry.getValue();
	    
	    System.out.println("Key: " + key);
	    System.out.println("Value: " + value);
	    	    
	    int unresolvedSLACount2 = serviceRequestRepository.getUnresolvedSLACount3(key,value);
	    	    
	    mohCounts.put(entry.getKey(), unresolvedSLACount2);
	}
	
	  publicHealthprocess(sePublicHealthCounts);
	  BRprocess(seBRCounts);
	  HEprocess(seHECounts);
	  MOHprocess(mohCounts);
	  
	  slaCountsResponse = new LevelThreeSlaCountsResponse(sePublicHealthCounts, seBRCounts, seHECounts, mohCounts);
				
	}catch (Exception e) {
		 log.error("Exception in LevelThreeprocess method!"+e.getLocalizedMessage());		
	}
	return new ResponseEntity<>(ResponseInfoWrapper.builder()
			.responseInfo(ResponseInfo.builder().status("SUCCESS").build()).responseBody(slaCountsResponse).build(),
			HttpStatus.OK);
	}
	
	public void publicHealthprocess(Map<String,Integer> sePublicHealthCounts) {
		RequestInfo requestInfo = new RequestInfo();
		requestInfo.setMsgId("1007212671881518955|en_IN");
        try {
        	List<SMSRequest> smsRequestsProperty = new LinkedList<>();

    		if (isSMSNotificationEnabled != null) {
    			if (isSMSNotificationEnabled) {
    				enrichPublicHealthSMSRequest(sePublicHealthCounts, smsRequestsProperty, requestInfo);
    				if (!CollectionUtils.isEmpty(smsRequestsProperty)) {
    					pGRUtils.sendSMS(smsRequestsProperty, true);				
    				}
    			}
    		}			
		} catch (Exception e) {
			log.error("Exception in publicHealthprocess method!"+e.getLocalizedMessage());
		}
		
	}
	
	private void enrichPublicHealthSMSRequest(Map<String,Integer> sePublicHealthCounts, List<SMSRequest> smsRequests, RequestInfo requestInfo) {
		
		   try {			   
			   String message = null;
				String localizationMessages;
	            String tenantId="ch.chandigarh";
				localizationMessages = pGRUtils.getLocalizationMessages(tenantId, requestInfo);
				message = pGRUtils.getPublicHealthTemplate(sePublicHealthCounts, localizationMessages);
						  
				  Map<String, String> mobileNumberToOwner = new HashMap<>();
				  
				  String officerrole=PGRConstants.ROLE_PH;
				  
				  List<Map<String, Object>> userData = serviceRequestRepository.getUsermobileno(officerrole);
				  
				  System.out.println(userData);
				  Set<String> processedMobileNumbers = new HashSet<>(); 
				  String processedMessage="";
				  for (Map<String, Object> row : userData) {
				      String mobileNumber = (String) row.get("mobilenumber");
				      String name = (String) row.get("name");
				      System.out.println("Mobile: " + mobileNumber + ", Name: " + name);
				      
				      // Check if the mobile number is already processed
				      if (!processedMobileNumbers.contains(mobileNumber)) {
				          processedMobileNumbers.add(mobileNumber); // Mark as processed
				          mobileNumberToOwner.putIfAbsent(mobileNumber, name); // Avoid overwriting
				          
				          processedMessage   = message.replaceAll("<br/>", "");

				      }			     			      
				      //mobileNumberToOwner.put(mobileNumber,name);			      
				      //message = message.replaceAll("<br/>", "");
					  //smsRequests.addAll(pGRUtils.createSMSRequest(message, mobileNumberToOwner));
				  }
				  smsRequests.addAll(pGRUtils.createSMSRequest(processedMessage, mobileNumberToOwner));	
			
		} catch (Exception e) {
			log.error("Exception in enrichPublicHealthSMSRequest method!"+e.getLocalizedMessage());
		}
					 
	}
	
	
	public void BRprocess(Map<String,Integer> seBRCounts) {
		RequestInfo requestInfo = new RequestInfo();
		requestInfo.setMsgId("1007666966271199412|en_IN");
		
		try {			
			List<SMSRequest> smsRequestsProperty = new LinkedList<>();

			if (isSMSNotificationEnabled != null) {
				if (isSMSNotificationEnabled) {
					enrichBRSMSRequest(seBRCounts, smsRequestsProperty, requestInfo);
					if (!CollectionUtils.isEmpty(smsRequestsProperty)) {
						pGRUtils.sendSMS(smsRequestsProperty, true);				
					}
				}
			}
			
		} catch (Exception e) {
			log.error("Exception in BRprocess method!"+e.getLocalizedMessage());
		}		
	}
	
	private void enrichBRSMSRequest(Map<String,Integer> seBRCounts, List<SMSRequest> smsRequests, RequestInfo requestInfo) {
		
		try {			
			String message = null;
			String localizationMessages;
	        String tenantId="ch.chandigarh";
			localizationMessages = pGRUtils.getLocalizationMessages(tenantId, requestInfo);
			message = pGRUtils.getBRTemplate(seBRCounts, localizationMessages);
					  
			  Map<String, String> mobileNumberToOwner = new HashMap<>();
			  
			  String officerrole=PGRConstants.ROLE_BR;
			  
			  List<Map<String, Object>> userData = serviceRequestRepository.getUsermobileno(officerrole);
			  
			  System.out.println(userData);
			  Set<String> processedMobileNumbers = new HashSet<>(); 
			  String processedMessage="";
			  for (Map<String, Object> row : userData) {
			      String mobileNumber = (String) row.get("mobilenumber");
			      String name = (String) row.get("name");
			      System.out.println("Mobile: " + mobileNumber + ", Name: " + name);
			      
			      // Check if the mobile number is already processed
			      if (!processedMobileNumbers.contains(mobileNumber)) {
			          processedMobileNumbers.add(mobileNumber); // Mark as processed
			          mobileNumberToOwner.putIfAbsent(mobileNumber, name); // Avoid overwriting
			          
			          processedMessage   = message.replaceAll("<br/>", "");

			      }			     			      
			      //mobileNumberToOwner.put(mobileNumber,name);			      
			      //message = message.replaceAll("<br/>", "");
				  //smsRequests.addAll(pGRUtils.createSMSRequest(message, mobileNumberToOwner));
			  }
			  smsRequests.addAll(pGRUtils.createSMSRequest(processedMessage, mobileNumberToOwner));		
			
		} catch (Exception e) {
			log.error("Exception in enrichBRSMSRequest method!"+e.getLocalizedMessage());
		}
			 
}
	
	public void HEprocess(Map<String,Integer> seHECounts) {
		RequestInfo requestInfo = new RequestInfo();
		requestInfo.setMsgId("1007903896804833422|en_IN");
		
		try {
			List<SMSRequest> smsRequestsProperty = new LinkedList<>();

			if (isSMSNotificationEnabled != null) {
				if (isSMSNotificationEnabled) {
					enrichHESMSRequest(seHECounts, smsRequestsProperty, requestInfo);
					if (!CollectionUtils.isEmpty(smsRequestsProperty)) {
						pGRUtils.sendSMS(smsRequestsProperty, true);				
					}
				}
			}			
		} catch (Exception e) {
			log.error("Exception in HEprocess method!"+e.getLocalizedMessage());
		}		
	}
	
	private void enrichHESMSRequest(Map<String,Integer> seHECounts, List<SMSRequest> smsRequests, RequestInfo requestInfo) {	
		
		try {			
			String message = null;
			String localizationMessages;
	        String tenantId="ch.chandigarh";
			localizationMessages = pGRUtils.getLocalizationMessages(tenantId, requestInfo);
			message = pGRUtils.getHETemplate(seHECounts, localizationMessages);
					  
			  Map<String, String> mobileNumberToOwner = new HashMap<>();
			  
			  String officerrole=PGRConstants.ROLE_HE;
			  
			  List<Map<String, Object>> userData = serviceRequestRepository.getUsermobileno(officerrole);
			  
			  System.out.println(userData);
			  Set<String> processedMobileNumbers = new HashSet<>(); 
			  String processedMessage="";
			  for (Map<String, Object> row : userData) {
			      String mobileNumber = (String) row.get("mobilenumber");
			      String name = (String) row.get("name");
			      System.out.println("Mobile: " + mobileNumber + ", Name: " + name);
			      
			      // Check if the mobile number is already processed
			      if (!processedMobileNumbers.contains(mobileNumber)) {
			          processedMobileNumbers.add(mobileNumber); // Mark as processed
			          mobileNumberToOwner.putIfAbsent(mobileNumber, name); // Avoid overwriting
			          
			          processedMessage   = message.replaceAll("<br/>", "");

			      }			     			      
			      //mobileNumberToOwner.put(mobileNumber,name);			      
			      //message = message.replaceAll("<br/>", "");
				  //smsRequests.addAll(pGRUtils.createSMSRequest(message, mobileNumberToOwner));
			  }
			  smsRequests.addAll(pGRUtils.createSMSRequest(processedMessage, mobileNumberToOwner));	
			
		} catch (Exception e) {
			log.error("Exception in enrichHESMSRequest method!"+e.getLocalizedMessage());
		}				 
}
	
	public void MOHprocess(Map<String,Integer> mohCounts) {
		RequestInfo requestInfo = new RequestInfo();
		requestInfo.setMsgId("1007568025969717533|en_IN");
		
		try {
			List<SMSRequest> smsRequestsProperty = new LinkedList<>();

			if (isSMSNotificationEnabled != null) {
				if (isSMSNotificationEnabled) {
					enrichMOHSMSRequest(mohCounts, smsRequestsProperty, requestInfo);
					if (!CollectionUtils.isEmpty(smsRequestsProperty)) {
						pGRUtils.sendSMS(smsRequestsProperty, true);				
					}
				}
			}
			
		} catch (Exception e) {
			log.error("Exception in MOHprocess method!"+e.getLocalizedMessage());
		}		
	}
	
	private void enrichMOHSMSRequest(Map<String,Integer> mohCounts, List<SMSRequest> smsRequests, RequestInfo requestInfo) {
		
		try {
			String message = null;
			String localizationMessages;
	        String tenantId="ch.chandigarh";
			localizationMessages = pGRUtils.getLocalizationMessages(tenantId, requestInfo);
			message = pGRUtils.getMOHTemplate(mohCounts, localizationMessages);
					  
			  Map<String, String> mobileNumberToOwner = new HashMap<>();
			  
			  String officerrole=PGRConstants.ROLE_MOH;
			  
			  List<Map<String, Object>> userData = serviceRequestRepository.getUsermobileno(officerrole);
			  
			  System.out.println(userData);
			  Set<String> processedMobileNumbers = new HashSet<>(); 
			  String processedMessage="";
			  for (Map<String, Object> row : userData) {
			      String mobileNumber = (String) row.get("mobilenumber");
			      String name = (String) row.get("name");
			      System.out.println("Mobile: " + mobileNumber + ", Name: " + name);
			      
			      // Check if the mobile number is already processed
			      if (!processedMobileNumbers.contains(mobileNumber)) {
			          processedMobileNumbers.add(mobileNumber); // Mark as processed
			          mobileNumberToOwner.putIfAbsent(mobileNumber, name); // Avoid overwriting
			          
			          processedMessage   = message.replaceAll("<br/>", "");

			      }			     			      
			      //mobileNumberToOwner.put(mobileNumber,name);			      
			      //message = message.replaceAll("<br/>", "");
				  //smsRequests.addAll(pGRUtils.createSMSRequest(message, mobileNumberToOwner));
			  }
			  smsRequests.addAll(pGRUtils.createSMSRequest(processedMessage, mobileNumberToOwner));				
		} catch (Exception e) {
			log.error("Exception in enrichMOHSMSRequest method!"+e.getLocalizedMessage());
		}
				 
}
	
	
	public Map<String, Map<String, List<String>>> getlevelthreesmsRoutingData(RequestInfoWrapper requestinfoWrapper) {
		// Map to store categories division-wise
		Map<String, Map<String, List<String>>> rolesDataMap = new HashMap<>();
		try {						
			ObjectMapper mapper = pgrUtils.getObjectMapper();
			StringBuilder uri = new StringBuilder();
			String tenantId="ch.chandigarh";
			Object request = reportUtils.getRequestForLevelThreeRoutingSearch(uri, tenantId,
					requestinfoWrapper.getRequestInfo());
			Object response = serviceRequestRepository.fetchResult(uri, request);
			if (null != response) {
				List<Map<String, Object>> resultCast = mapper
						.convertValue(JsonPath.read(response, "$.MdmsRes.common-masters.levelthreesmsrouting"), List.class);
				
				 // Iterating through the routing data
		        for (Map<String, Object> routingData : resultCast) {
		        	String roleName = (String) routingData.get("RoleName");

		            // Initialize a map for the current role's divisions
		            Map<String, List<String>> divisionDataMap = new HashMap<>();
		            
		            // Process divisions if they exist
		            List<Map<String, Object>> divisions = (List<Map<String, Object>>) routingData.get("Divisions");
		            
		            if (divisions != null) {
		                // Iterate through the divisions and fetch categories or sectors
		                for (Map<String, Object> division : divisions) {
		                    String divisionName = (String) division.get("Division");
		                    List<String> categories = (List<String>) division.get("category");
		                    List<String> sectors = (List<String>) division.get("Sectors");

		                    // Check if the category list contains "All Category", fetch sectors if true
		                    if (categories != null && categories.contains("All Category") && sectors != null) {
		                        divisionDataMap.put(divisionName, sectors); // Store sectors
		                    } else if (categories != null) {
		                        divisionDataMap.put(divisionName, categories); // Store categories
		                    }
		                }
		            }
		            
		            // Add the division data for the current role to the roles data map
		            rolesDataMap.put(roleName, divisionDataMap);
		        }

			}						
		} catch (Exception e) {
			log.error("Exception in getlevelthreesmsRoutingData method!"+e.getLocalizedMessage());
		}
		return rolesDataMap;
	}
	
	
	public ResponseEntity<ResponseInfoWrapper> Levelfourprocess(RequestInfoWrapper request) {
		
		LevelfourSlaCountsResponse slaCountsResponse=null;
		try {			
		Map<String, Map<String, List<String>>> getlevelfoursmsRoutingData = getlevelfoursmsRoutingData(request);
		
		// Store SLA counts for each category
	    Map<String,Integer> CECounts = new HashMap<>();
	    Map<String, Integer> JCMC1Counts = new HashMap<>();
	    Map<String, Integer> JCMC2Counts = new HashMap<>();
	    Map<String, Integer> JCMC3Counts = new HashMap<>();
		
		
		Map<String, List<String>> CE = getlevelfoursmsRoutingData.get(PGRConstants.ROLE_CE);	
		
		for (Map.Entry<String, List<String>> entry : CE.entrySet()) {

		    String key = entry.getKey();
		    
		    List<String> value = entry.getValue();
		    
		    System.out.println("Key: " + key);
		    System.out.println("Value: " + value);
		   	       
		    int unresolvedSLACount = serviceRequestRepository.getCEUnresolvedSLACount(key,value);	    	    
		    CECounts.put(entry.getKey(), unresolvedSLACount);
		}	
		Map<String, List<String>> JCMC1Data = getlevelfoursmsRoutingData.get(PGRConstants.ROLE_JCMC1);
		for (Map.Entry<String, List<String>> entry : JCMC1Data.entrySet()) {

		    String key = entry.getKey();
		    
		    List<String> value = entry.getValue();
		    
		    System.out.println("Key: " + key);
		    System.out.println("Value: " + value);
		    	    
		    int unresolvedSLACount1 = serviceRequestRepository.getJCMC1UnresolvedSLACount(key,value);
		    	    
		    JCMC1Counts.put(entry.getKey(), unresolvedSLACount1);  
		}	
		Map<String, List<String>> JCMC2Data = getlevelfoursmsRoutingData.get(PGRConstants.ROLE_JCMC2);
		for (Map.Entry<String, List<String>> entry : JCMC2Data.entrySet()) {

		    String key = entry.getKey();

		    List<String> value = entry.getValue();
		    
		    System.out.println("Key: " + key);
		    System.out.println("Value: " + value);
		    	    
		    int unresolvedSLACount2 = serviceRequestRepository.getJCMC2UnresolvedSLACount(key,value);
		        
		    JCMC2Counts.put(entry.getKey(), unresolvedSLACount2);
		}
		
		Map<String, List<String>> JCMC3Data = getlevelfoursmsRoutingData.get(PGRConstants.ROLE_JCMC3);
		for (Map.Entry<String, List<String>> entry : JCMC3Data.entrySet()) {
			
		    String key = entry.getKey();
		    
		    List<String> value = entry.getValue();
		    
		    System.out.println("Key: " + key);
		    System.out.println("Value: " + value);
		    	    
		    int unresolvedSLACount2 = serviceRequestRepository.getJCMC3UnresolvedSLACount(key,value);
		    	    
		    JCMC3Counts.put(entry.getKey(), unresolvedSLACount2);
		}
		
		  CEprocess(CECounts);
		  JCMC1process(JCMC1Counts);
		  JCMC2process(JCMC2Counts);
		  JCMC3process(JCMC3Counts);
		  
		  slaCountsResponse = new LevelfourSlaCountsResponse(CECounts, JCMC1Counts, JCMC2Counts, JCMC3Counts);
					
		}catch (Exception e) {
			 log.error("Exception in Levelfourprocess method!"+e.getLocalizedMessage());		
		}
		return new ResponseEntity<>(ResponseInfoWrapper.builder()
				.responseInfo(ResponseInfo.builder().status("SUCCESS").build()).responseBody(slaCountsResponse).build(),
				HttpStatus.OK);
		}
	
	public void CEprocess(Map<String,Integer> CECounts) {
		RequestInfo requestInfo = new RequestInfo();
		requestInfo.setMsgId("1007816608884562188|en_IN");
        try {
        	List<SMSRequest> smsRequestsProperty = new LinkedList<>();

    		if (isSMSNotificationEnabled != null) {
    			if (isSMSNotificationEnabled) {
    				enrichCESMSRequest(CECounts, smsRequestsProperty, requestInfo);
    				if (!CollectionUtils.isEmpty(smsRequestsProperty)) {
    					pGRUtils.sendSMS(smsRequestsProperty, true);				
    				}
    			}
    		}			
		} catch (Exception e) {
			log.error("Exception in CEprocess method!"+e.getLocalizedMessage());
		}
		
	}
	
	private void enrichCESMSRequest(Map<String,Integer> CECounts, List<SMSRequest> smsRequests, RequestInfo requestInfo) {
		
		   try {			   
			   String message = null;
				String localizationMessages;
	            String tenantId="ch.chandigarh";
				localizationMessages = pGRUtils.getLocalizationMessages(tenantId, requestInfo);
				message = pGRUtils.getCETemplate(CECounts, localizationMessages);
						  
				  Map<String, String> mobileNumberToOwner = new HashMap<>();
				  
				  String officerrole=PGRConstants.ROLE_CE;
				  
				  List<Map<String, Object>> userData = serviceRequestRepository.getUsermobileno(officerrole);
				  
				  System.out.println(userData);
				  Set<String> processedMobileNumbers = new HashSet<>(); 
				  String processedMessage="";
				  for (Map<String, Object> row : userData) {
				      String mobileNumber = (String) row.get("mobilenumber");
				      String name = (String) row.get("name");
				      System.out.println("Mobile: " + mobileNumber + ", Name: " + name);
				      
				      // Check if the mobile number is already processed
				      if (!processedMobileNumbers.contains(mobileNumber)) {
				          processedMobileNumbers.add(mobileNumber); // Mark as processed
				          mobileNumberToOwner.putIfAbsent(mobileNumber, name); // Avoid overwriting
				          
				          processedMessage   = message.replaceAll("<br/>", "");

				      }			     			      
				      //mobileNumberToOwner.put(mobileNumber,name);			      
				      //message = message.replaceAll("<br/>", "");
					  //smsRequests.addAll(pGRUtils.createSMSRequest(message, mobileNumberToOwner));
				  }
				  smsRequests.addAll(pGRUtils.createSMSRequest(processedMessage, mobileNumberToOwner));	
			
		} catch (Exception e) {
			log.error("Exception in enrichCESMSRequest method!"+e.getLocalizedMessage());
		}
					 
	}
	
	public void JCMC1process(Map<String,Integer> JCMC1Counts) {
		RequestInfo requestInfo = new RequestInfo();
		requestInfo.setMsgId("1007226799854888750|en_IN");
        try {
        	List<SMSRequest> smsRequestsProperty = new LinkedList<>();

    		if (isSMSNotificationEnabled != null) {
    			if (isSMSNotificationEnabled) {
    				enrichJCMC1SMSRequest(JCMC1Counts, smsRequestsProperty, requestInfo);
    				if (!CollectionUtils.isEmpty(smsRequestsProperty)) {
    					pGRUtils.sendSMS(smsRequestsProperty, true);				
    				}
    			}
    		}			
		} catch (Exception e) {
			log.error("Exception in JCMC1process method!"+e.getLocalizedMessage());
		}
		
	}
	
	private void enrichJCMC1SMSRequest(Map<String,Integer> JCMC1Counts, List<SMSRequest> smsRequests, RequestInfo requestInfo) {
		
		   try {			   
			   String message = null;
				String localizationMessages;
	            String tenantId="ch.chandigarh";
				localizationMessages = pGRUtils.getLocalizationMessages(tenantId, requestInfo);
				message = pGRUtils.getJCMC1Template(JCMC1Counts, localizationMessages);
						  
				  Map<String, String> mobileNumberToOwner = new HashMap<>();
				  
				  String officerrole=PGRConstants.ROLE_JCMC1;
				  
				  List<Map<String, Object>> userData = serviceRequestRepository.getUsermobileno(officerrole);
				  
				  System.out.println(userData);
				  Set<String> processedMobileNumbers = new HashSet<>(); 
				  String processedMessage="";
				  for (Map<String, Object> row : userData) {
				      String mobileNumber = (String) row.get("mobilenumber");
				      String name = (String) row.get("name");
				      System.out.println("Mobile: " + mobileNumber + ", Name: " + name);
				      
				      // Check if the mobile number is already processed
				      if (!processedMobileNumbers.contains(mobileNumber)) {
				          processedMobileNumbers.add(mobileNumber); // Mark as processed
				          mobileNumberToOwner.putIfAbsent(mobileNumber, name); // Avoid overwriting
				          
				          processedMessage   = message.replaceAll("<br/>", "");

				      }			     			      
				      //mobileNumberToOwner.put(mobileNumber,name);			      
				      //message = message.replaceAll("<br/>", "");
					  //smsRequests.addAll(pGRUtils.createSMSRequest(message, mobileNumberToOwner));
				  }
				  smsRequests.addAll(pGRUtils.createSMSRequest(processedMessage, mobileNumberToOwner));	
			
		} catch (Exception e) {
			log.error("Exception in enrichJCMC1SMSRequest method!"+e.getLocalizedMessage());
		}
					 
	}
	
	public void JCMC2process(Map<String,Integer> JCMC2Counts) {
		RequestInfo requestInfo = new RequestInfo();
		requestInfo.setMsgId("1007917932334871167|en_IN");
        try {
        	List<SMSRequest> smsRequestsProperty = new LinkedList<>();

    		if (isSMSNotificationEnabled != null) {
    			if (isSMSNotificationEnabled) {
    				enrichJCMC2SMSRequest(JCMC2Counts, smsRequestsProperty, requestInfo);
    				if (!CollectionUtils.isEmpty(smsRequestsProperty)) {
    					pGRUtils.sendSMS(smsRequestsProperty, true);				
    				}
    			}
    		}			
		} catch (Exception e) {
			log.error("Exception in JCMC2process method!"+e.getLocalizedMessage());
		}
		
	}
	
	private void enrichJCMC2SMSRequest(Map<String,Integer> JCMC2Counts, List<SMSRequest> smsRequests, RequestInfo requestInfo) {
		
		   try {			   
			   String message = null;
				String localizationMessages;
	            String tenantId="ch.chandigarh";
				localizationMessages = pGRUtils.getLocalizationMessages(tenantId, requestInfo);
				message = pGRUtils.getJCMC2Template(JCMC2Counts, localizationMessages);
						  
				  Map<String, String> mobileNumberToOwner = new HashMap<>();
				  
				  String officerrole=PGRConstants.ROLE_JCMC2;
				  
				  List<Map<String, Object>> userData = serviceRequestRepository.getUsermobileno(officerrole);
				  
				  System.out.println(userData);
				  Set<String> processedMobileNumbers = new HashSet<>(); 
				  String processedMessage="";
				  for (Map<String, Object> row : userData) {
				      String mobileNumber = (String) row.get("mobilenumber");
				      String name = (String) row.get("name");
				      System.out.println("Mobile: " + mobileNumber + ", Name: " + name);
				      
				      // Check if the mobile number is already processed
				      if (!processedMobileNumbers.contains(mobileNumber)) {
				          processedMobileNumbers.add(mobileNumber); // Mark as processed
				          mobileNumberToOwner.putIfAbsent(mobileNumber, name); // Avoid overwriting
				          
				          processedMessage   = message.replaceAll("<br/>", "");

				      }			     			      
				      //mobileNumberToOwner.put(mobileNumber,name);			      
				      //message = message.replaceAll("<br/>", "");
					  //smsRequests.addAll(pGRUtils.createSMSRequest(message, mobileNumberToOwner));
				  }
				  smsRequests.addAll(pGRUtils.createSMSRequest(processedMessage, mobileNumberToOwner));	
			
		} catch (Exception e) {
			log.error("Exception in enrichJCMC2SMSRequest method!"+e.getLocalizedMessage());
		}
					 
	}
	
	public void JCMC3process(Map<String,Integer> JCMC3Counts) {
		RequestInfo requestInfo = new RequestInfo();
		requestInfo.setMsgId("1007357629795231352|en_IN");
        try {
        	List<SMSRequest> smsRequestsProperty = new LinkedList<>();

    		if (isSMSNotificationEnabled != null) {
    			if (isSMSNotificationEnabled) {
    				enrichJCMC3SMSRequest(JCMC3Counts, smsRequestsProperty, requestInfo);
    				if (!CollectionUtils.isEmpty(smsRequestsProperty)) {
    					pGRUtils.sendSMS(smsRequestsProperty, true);				
    				}
    			}
    		}			
		} catch (Exception e) {
			log.error("Exception in JCMC3process method!"+e.getLocalizedMessage());
		}
		
	}
	
	private void enrichJCMC3SMSRequest(Map<String,Integer> JCMC3Counts, List<SMSRequest> smsRequests, RequestInfo requestInfo) {
		
		   try {			   
			   String message = null;
				String localizationMessages;
	            String tenantId="ch.chandigarh";
				localizationMessages = pGRUtils.getLocalizationMessages(tenantId, requestInfo);
				message = pGRUtils.getJCMC3Template(JCMC3Counts, localizationMessages);
						  
				  Map<String, String> mobileNumberToOwner = new HashMap<>();
				  
				  String officerrole=PGRConstants.ROLE_JCMC3;
				  
				  List<Map<String, Object>> userData = serviceRequestRepository.getUsermobileno(officerrole);
				  
				  System.out.println(userData);
				  Set<String> processedMobileNumbers = new HashSet<>(); 
				  String processedMessage="";
				  for (Map<String, Object> row : userData) {
				      String mobileNumber = (String) row.get("mobilenumber");
				      String name = (String) row.get("name");
				      System.out.println("Mobile: " + mobileNumber + ", Name: " + name);
				      
				      // Check if the mobile number is already processed
				      if (!processedMobileNumbers.contains(mobileNumber)) {
				          processedMobileNumbers.add(mobileNumber); // Mark as processed
				          mobileNumberToOwner.putIfAbsent(mobileNumber, name); // Avoid overwriting
				          
				          processedMessage   = message.replaceAll("<br/>", "");

				      }			     			      
				      //mobileNumberToOwner.put(mobileNumber,name);			      
				      //message = message.replaceAll("<br/>", "");
					  //smsRequests.addAll(pGRUtils.createSMSRequest(message, mobileNumberToOwner));
				  }
				  smsRequests.addAll(pGRUtils.createSMSRequest(processedMessage, mobileNumberToOwner));	
			
		} catch (Exception e) {
			log.error("Exception in enrichJCMC3SMSRequest method!"+e.getLocalizedMessage());
		}
					 
	}
	
	
	public Map<String, Map<String, List<String>>> getlevelfoursmsRoutingData(RequestInfoWrapper requestinfoWrapper) {
		// Map to store categories division-wise
		Map<String, Map<String, List<String>>> rolesDataMap = new HashMap<>();
		try {						
			ObjectMapper mapper = pgrUtils.getObjectMapper();
			StringBuilder uri = new StringBuilder();
			String tenantId="ch.chandigarh";
			Object request = reportUtils.getRequestForLevelfourRoutingSearch(uri, tenantId,
					requestinfoWrapper.getRequestInfo());
			Object response = serviceRequestRepository.fetchResult(uri, request);
			if (null != response) {
				List<Map<String, Object>> resultCast = mapper
						.convertValue(JsonPath.read(response, "$.MdmsRes.common-masters.levelfoursmsrouting"), List.class);
				
				 // Iterating through the routing data
		        for (Map<String, Object> routingData : resultCast) {
		        	String roleName = (String) routingData.get("RoleName");

		            // Initialize a map for the current role's divisions
		            Map<String, List<String>> divisionDataMap = new HashMap<>();
		            
		            // Process divisions if they exist
		            List<Map<String, Object>> divisions = (List<Map<String, Object>>) routingData.get("Divisions");
		            
		            if (divisions != null) {
		                // Iterate through the divisions and fetch categories or sectors
		                for (Map<String, Object> division : divisions) {
		                    String divisionName = (String) division.get("Division");
		                    List<String> categories = (List<String>) division.get("category");
		                    List<String> sectors = (List<String>) division.get("Sectors");

		                    // Check if the category list contains "All Category", fetch sectors if true
		                    if (categories != null && categories.contains("All Category") && sectors != null) {
		                        divisionDataMap.put(divisionName, sectors); // Store sectors
		                    } else if (categories != null) {
		                        divisionDataMap.put(divisionName, categories); // Store categories
		                    }
		                }
		            }
		            
		            // Add the division data for the current role to the roles data map
		            rolesDataMap.put(roleName, divisionDataMap);
		        }

			}						
		} catch (Exception e) {
			log.error("Exception in getlevelfoursmsRoutingData method!"+e.getLocalizedMessage());
		}
		return rolesDataMap;
	}
	
	public ResponseEntity<ResponseInfoWrapper> Levelfiveprocess(RequestInfoWrapper request) {
		
		LevelfiveSlaCountsResponse slaCountsResponse=null;
		try {			
		Map<String, Map<String, List<String>>> getlevelfivesmsRoutingData = getlevelfivesmsRoutingData(request);
		
		// Store SLA counts for each category
	    Map<String,Integer> CommissionerCounts = new HashMap<>();
				
		Map<String, List<String>> COMMISSIONER = getlevelfivesmsRoutingData.get(PGRConstants.ROLE_COMMISSIONER);	
		
		for (Map.Entry<String, List<String>> entry : COMMISSIONER.entrySet()) {

		    String key = entry.getKey();
		    
		    List<String> value = entry.getValue();
		    
		    System.out.println("Key: " + key);
		    System.out.println("Value: " + value);
		   	       
		    int unresolvedSLACount = serviceRequestRepository.getCommisionerUnresolvedSLACount(key,value);	    	    
		    CommissionerCounts.put(entry.getKey(), unresolvedSLACount);
		}	

		  Commissionerprocess(CommissionerCounts);

		  
		  slaCountsResponse = new LevelfiveSlaCountsResponse(CommissionerCounts);
					
		}catch (Exception e) {
			 log.error("Exception in Levelfiveprocess method!"+e.getLocalizedMessage());		
		}
		return new ResponseEntity<>(ResponseInfoWrapper.builder()
				.responseInfo(ResponseInfo.builder().status("SUCCESS").build()).responseBody(slaCountsResponse).build(),
				HttpStatus.OK);
		}
	
	public void Commissionerprocess(Map<String,Integer> CommissionerCounts) {
		RequestInfo requestInfo = new RequestInfo();
		requestInfo.setMsgId("1007615217573497663|en_IN");
        try {
        	List<SMSRequest> smsRequestsProperty = new LinkedList<>();

    		if (isSMSNotificationEnabled != null) {
    			if (isSMSNotificationEnabled) {
    				enrichCommissionerSMSRequest(CommissionerCounts, smsRequestsProperty, requestInfo);
    				if (!CollectionUtils.isEmpty(smsRequestsProperty)) {
    					pGRUtils.sendSMS(smsRequestsProperty, true);				
    				}
    			}
    		}			
		} catch (Exception e) {
			log.error("Exception in Commissionerprocess method!"+e.getLocalizedMessage());
		}
		
	}
	
	private void enrichCommissionerSMSRequest(Map<String,Integer> CommissionerCounts, List<SMSRequest> smsRequests, RequestInfo requestInfo) {
		
		   try {			   
			   String message = null;
				String localizationMessages;
	            String tenantId="ch.chandigarh";
				localizationMessages = pGRUtils.getLocalizationMessages(tenantId, requestInfo);
				message = pGRUtils.getCommissionerTemplate(CommissionerCounts, localizationMessages);
						  
				  Map<String, String> mobileNumberToOwner = new HashMap<>();
				  
				  String officerrole=PGRConstants.ROLE_COMMISSIONER;
				  
				  List<Map<String, Object>> userData = serviceRequestRepository.getUsermobileno(officerrole);
				  
				  System.out.println(userData);
				  Set<String> processedMobileNumbers = new HashSet<>(); 
				  String processedMessage="";
				  for (Map<String, Object> row : userData) {
				      String mobileNumber = (String) row.get("mobilenumber");
				      String name = (String) row.get("name");
				      System.out.println("Mobile: " + mobileNumber + ", Name: " + name);
				      
				      // Check if the mobile number is already processed
				      if (!processedMobileNumbers.contains(mobileNumber)) {
				          processedMobileNumbers.add(mobileNumber); // Mark as processed
				          mobileNumberToOwner.putIfAbsent(mobileNumber, name); // Avoid overwriting
				          
				          processedMessage   = message.replaceAll("<br/>", "");

				      }			     			      
				      //mobileNumberToOwner.put(mobileNumber,name);			      
				      //message = message.replaceAll("<br/>", "");
					  //smsRequests.addAll(pGRUtils.createSMSRequest(message, mobileNumberToOwner));
				  }
				  smsRequests.addAll(pGRUtils.createSMSRequest(processedMessage, mobileNumberToOwner));	
			
		} catch (Exception e) {
			log.error("Exception in enrichCommissionerSMSRequest method!"+e.getLocalizedMessage());
		}
					 
	}
	
	public Map<String, Map<String, List<String>>> getlevelfivesmsRoutingData(RequestInfoWrapper requestinfoWrapper) {
		// Map to store categories division-wise
		Map<String, Map<String, List<String>>> rolesDataMap = new HashMap<>();
		try {						
			ObjectMapper mapper = pgrUtils.getObjectMapper();
			StringBuilder uri = new StringBuilder();
			String tenantId="ch.chandigarh";
			Object request = reportUtils.getRequestForLevelfiveRoutingSearch(uri, tenantId,
					requestinfoWrapper.getRequestInfo());
			Object response = serviceRequestRepository.fetchResult(uri, request);
			if (null != response) {
				List<Map<String, Object>> resultCast = mapper
						.convertValue(JsonPath.read(response, "$.MdmsRes.common-masters.levelfivesmsrouting"), List.class);
				
				 // Iterating through the routing data
		        for (Map<String, Object> routingData : resultCast) {
		        	String roleName = (String) routingData.get("RoleName");

		            // Initialize a map for the current role's divisions
		            Map<String, List<String>> divisionDataMap = new HashMap<>();
		            
		            // Process divisions if they exist
		            List<Map<String, Object>> divisions = (List<Map<String, Object>>) routingData.get("Divisions");
		            
		            if (divisions != null) {
		                // Iterate through the divisions and fetch categories or sectors
		                for (Map<String, Object> division : divisions) {
		                    String divisionName = (String) division.get("Division");
		                    List<String> categories = (List<String>) division.get("category");
		                    List<String> sectors = (List<String>) division.get("Sectors");

		                    // Check if the category list contains "All Category", fetch sectors if true
		                    if (categories != null && categories.contains("All Category") && sectors != null) {
		                        divisionDataMap.put(divisionName, sectors); // Store sectors
		                    } else if (categories != null) {
		                        divisionDataMap.put(divisionName, categories); // Store categories
		                    }
		                }
		            }
		            
		            // Add the division data for the current role to the roles data map
		            rolesDataMap.put(roleName, divisionDataMap);
		        }

			}						
		} catch (Exception e) {
			log.error("Exception in getlevelfivesmsRoutingData method!"+e.getLocalizedMessage());
		}
		return rolesDataMap;
	}
	
		
}
