package org.egov.pgr.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
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
import org.egov.pgr.contract.ReportRequest;
import org.egov.pgr.contract.ReportResponse;
import org.egov.pgr.model.Department;
import org.egov.pgr.model.DiscriptionReport;
import org.egov.pgr.model.RequestInfoWrapper;
import org.egov.pgr.model.ResponseInfoWrapper;
import org.egov.pgr.model.Sector;
import org.egov.pgr.model.ServiceDef;
import org.egov.pgr.model.ServiceDefMdms;
import org.egov.pgr.repository.ReportQueryBuilder;
import org.egov.pgr.repository.ReportRepository;
import org.egov.pgr.repository.ServiceRequestRepository;
import org.egov.pgr.repository.rowmapper.ColumnsRowMapper;
import org.egov.pgr.utils.PGRConstants;
import org.egov.pgr.utils.PGRUtils;
import org.egov.pgr.utils.ReportConstants;
import org.egov.pgr.utils.ReportUtils;
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
	private   RestTemplate restTemplate;
	
	@Autowired
	public NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	@Autowired
	private ColumnsRowMapper rowMapper;

	@Autowired
	private ReportUtils reportUtils;
	
	private final String mdmsBySearchCriteriaUrl;
	@Autowired
	public ReportService(
			@Value("${egov.mdms.host}") final String mdmsServiceHostname,
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
			tuple.put("total_open_complaints", reportUtils.getPercentage(tuple.get("total_complaints"), tuple.get("total_open_complaints")));
			tuple.put("outside_sla", reportUtils.getPercentage(tuple.get("total_complaints"), tuple.get("outside_sla")));
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
			tuple.put("total_open_complaints", reportUtils.getPercentage(tuple.get("total_complaints"), tuple.get("total_open_complaints")));
			tuple.put("outside_sla", reportUtils.getPercentage(tuple.get("total_complaints"), tuple.get("outside_sla")));
			tuple.put("avg_citizen_rating", reportUtils.getAvgRating(tuple.get("avg_citizen_rating")));
		}
		return enrichedResponse;
	}

	public List<Map<String, Object>> enrichSourceWiseReport(ReportRequest reportRequest, List<Map<String, Object>> dbResponse) {
		List<Map<String, Object>> enrichedResponse = new ArrayList<>();
		Map<String, Object> tuple = dbResponse.get(0);
		Long total = Long.valueOf((null ==tuple.get("citizen_mobile_app")) ? "0" : tuple.get("citizen_mobile_app").toString()) 
				+ Long.valueOf((null == tuple.get("citizen_web_app")) ? "0" : tuple.get("citizen_web_app").toString()) 
				+ Long.valueOf((null == tuple.get("customer_service_desk")) ? "0" : tuple.get("customer_service_desk").toString());
		for(String key: dbResponse.get(0).keySet()) {
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
			log.info("tuple: "+tuple);
			String name = mapOfIdAndName.get(
					Long.valueOf((null == tuple.get("employee_name")) ? "0" : tuple.get("employee_name").toString()));
			tuple.put("employee_name", StringUtils.isEmpty(name) ? "No-Name" : name);
			tuple.put("total_open_complaints", reportUtils.getPercentage(tuple.get("total_complaints_received"), tuple.get("total_open_complaints")));
			tuple.put("outside_sla", reportUtils.getPercentage(tuple.get("total_complaints_received"), tuple.get("outside_sla")));
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
				List<Map<String, Object>> resultCast = mapper.convertValue(JsonPath.read(response, PGRConstants.EMPLOYEE_BASE_JSONPATH), List.class);
				for (Map<String, Object> employee : resultCast) {
					Map<String, Object> user = (Map) employee.get("user");
					mapOfIdAndName.put(Long.parseLong(employee.get("id").toString()), user.get("name").toString());
				}
			}
			log.debug("mapOfIdAndName: " + mapOfIdAndName);
		}catch(Exception e) {
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
			List<Map<String, Object>> resultCast = mapper.convertValue(JsonPath.read(response, "$.MdmsRes.RAINMAKER-PGR.ServiceDefs"), List.class);
			for (Map<String, Object> serviceDef : resultCast) {
				if(StringUtils.isEmpty(deptCodeAndNameMap.get(serviceDef.get("department").toString()))) {
					List<String> departmentCodes = new ArrayList<>();
					departmentCodes.add(serviceDef.get("department").toString());
					List<String> depts = reportUtils.getDepartment(reportRequest.getRequestInfo(), departmentCodes, reportRequest.getTenantId());
					if(!CollectionUtils.isEmpty(depts)) {
						deptCodeAndNameMap.put(serviceDef.get("department").toString(), depts.get(0));
					}
					mapOfServiceCodesAndDepts.put(serviceDef.get("serviceCode").toString(), "NA");
				}else {
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

			
			List<Map<String, Object>> resultCast = mapper.convertValue(JsonPath.read(response, "$.MdmsRes.RAINMAKER-PGR.ServiceDefs"), List.class);
			return  resultCast;
	}
	
	public Map<String, Department> getDeptName (String tenantId, final ObjectMapper mapper, RequestInfo requestInfo) {
		net.minidev.json.JSONArray responseJSONArray = getByCriteria(tenantId, "RAINMAKER-PGR", "PgrDepartment",
				null, null, requestInfo);
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
	
	public Map<String, ServiceDefMdms> getServiceName (String tenantId, final ObjectMapper mapper, RequestInfo requestInfo) {
		net.minidev.json.JSONArray responseJSONArray = getByCriteria(tenantId, "RAINMAKER-PGR", "ServiceDefs",
				null, null, requestInfo);
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
	
	public Map<String, Sector> getSectorName (String tenantId, final ObjectMapper mapper, RequestInfo requestInfo) {
		net.minidev.json.JSONArray responseJSONArray = getByCriteria(tenantId, "RAINMAKER-PGR", "Sector",
				null, null, requestInfo);
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

	public ResponseEntity<ResponseInfoWrapper> process(RequestInfoWrapper request) {
		List<DiscriptionReport> list = new ArrayList<>();
		ObjectMapper mapper = new ObjectMapper();
		Map<String, ServiceDefMdms > mapOfServiceCodesAndDepts = getServiceName(request.getRequestInfo().getUserInfo().getTenantId(), mapper, new RequestInfo());
		Map<String, Department > mapOfDepts = getDeptName(request.getRequestInfo().getUserInfo().getTenantId(), mapper, new RequestInfo());
		Map<String, Sector > mapOfSectors = getSectorName(request.getRequestInfo().getUserInfo().getTenantId(), mapper, new RequestInfo());
		Map<String, Object> paramValues = new HashMap<>();
	//	paramValues.put("sla", mapOfServiceCodesAndDepts.get(key));
		list = namedParameterJdbcTemplate.query(ReportQueryBuilder.GET_DISCRIPTION_REPORT_QUERY, paramValues, rowMapper);	
		if(list.size()>0)
		{
			for(DiscriptionReport data:list) {
			//	String sla= namedParameterJdbcTemplate.query(ReportQueryBuilder.GET_SLAHOURS_QUERY, paramValues, rowMapper);	
			data.setDepartment(mapOfDepts.get(mapOfServiceCodesAndDepts.get(data.getServicecode()).getDepartment()).getName());
			data.setLocality(mapOfSectors.get(data.getLocality())!=null ? mapOfSectors.get(data.getLocality()).getName() : "");
			repository.saveData(request,data);
			}
		}
		
		return new ResponseEntity<>(ResponseInfoWrapper.builder()
				.responseInfo(ResponseInfo.builder().status("SUCCESS").build()).responseBody(null)
				.build(), HttpStatus.OK);
	}

}
