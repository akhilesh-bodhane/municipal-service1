package org.egov.integration.service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.egov.common.contract.request.RequestInfo;
import org.egov.common.contract.response.ResponseInfo;
import org.egov.integration.model.RequestData;
import org.egov.integration.model.metricsDomainWise;
import org.egov.integration.config.DomainWiseConfig;
import org.egov.integration.config.EawasConfiguration;
import org.egov.integration.model.MasterData;
import org.egov.integration.model.RequestData;
import org.egov.mdms.model.MasterDetail;
import org.egov.mdms.model.MdmsCriteria;
import org.egov.mdms.model.MdmsCriteriaReq;
import org.egov.mdms.model.ModuleDetail;
import org.egov.tracer.model.ServiceCallException;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.XML;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.google.gson.Gson;
import com.jayway.jsonpath.JsonPath;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class DomainWiseService {


	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private DomainWiseConfig config;

	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");  
	  

	public List<MasterData> searchNIUADoaminWise(RequestInfo requestInfo, String tenantId) {
		
		List<MasterData>  MasterDataList = new ArrayList<>();
		  LocalDateTime now = LocalDateTime.now();  
		   String Date = dtf.format(now); 
		   String  ulb = "ch.chandigarh";
		   String  region = "Chandigarh" ;
		   String   state = "Punjab" ;
		Object mDMSCall = mDMSCall(requestInfo, tenantId);
		 List read = JsonPath.read(mDMSCall, "$.MdmsRes.egf-master.TargetCollection");
		 for (Object TargetCollectionList : read) {
			 HashMap<String, Object> map = (HashMap<String, Object>) TargetCollectionList;

				String financialYear = ((String) map.get("financialYear"));
				String module = ((String) map.get("module"));
				int budgetProposedForMunicipalCorporation =  (int) map.get("budgetProposedForMunicipalCorporation");
				MasterData masterdata = new MasterData();
				masterdata.setFinancialYear(financialYear);
				masterdata.setModule(module);
				masterdata.setUlb(ulb);
				masterdata.setRegion(region);
				masterdata.setState(state);
				masterdata.setMetrics(metricsDomainWise.builder().date(Date).snoForMunicipalCorporation("1")
						.ulbName(region).budgetProposedForMunicipalCorporation(budgetProposedForMunicipalCorporation).build());
				
				MasterDataList.add(masterdata);
		}
		return MasterDataList;
	}
	
	public Object mDMSCall(RequestInfo requestInfo, String tenantId) {
		MdmsCriteriaReq mdmsCriteriaReq = getMDMSRequest(requestInfo, tenantId);
		StringBuilder url = getMdmsSearchUrl();
		Object result = fetchResult(url, mdmsCriteriaReq);
		return result;
	}
	
	private MdmsCriteriaReq getMDMSRequest(RequestInfo requestInfo, String tenantId) {

		
		List<MasterDetail> billMasterDetails = new ArrayList<>();
		billMasterDetails.add(MasterDetail.builder().name("TargetCollection").build());
		ModuleDetail billModuleDtls = ModuleDetail.builder().masterDetails(billMasterDetails)
				.moduleName("egf-master").build();
		
		 
		
		List<ModuleDetail> moduleDetails = new ArrayList<>();
		moduleDetails.add(billModuleDtls);

		MdmsCriteria mdmsCriteria = MdmsCriteria.builder().moduleDetails(moduleDetails).tenantId(tenantId).build();

		return MdmsCriteriaReq.builder().requestInfo(requestInfo).mdmsCriteria(mdmsCriteria).build();
	}
	
private StringBuilder getMdmsSearchUrl() {
		
		 StringBuilder append = new StringBuilder().append(config.getMdmsHost()).append(config.getMdmsEndPoint());
		 return append ;
	}




/**
 * Makes a RestTemplate Call on the input uri with the given request
 * @param uri The uri to be called
 * @param request The request body
 * @return The reponse of the call
 */
public Object fetchResult(StringBuilder uri, Object request) {
    ObjectMapper mapper = new ObjectMapper();
    Object response = null;
    try {
        log.info("Request: "+mapper.writeValueAsString(request));
        response = restTemplate.postForObject(uri.toString(), request, Map.class);
    }catch(HttpClientErrorException e) {
        log.error("External Service threw an Exception: ",e);
        throw new ServiceCallException(e.getResponseBodyAsString());
    }catch(Exception e) {
        log.error("Exception while fetching from searcher: ",e);
    }

    return response;

}
	
	    

}
