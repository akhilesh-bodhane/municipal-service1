package org.egov.hc.workflow;


import java.util.ArrayList;
import java.util.HashMap;

import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.egov.common.contract.request.RequestInfo;
import org.egov.hc.contract.ServiceRequest;
import org.egov.hc.model.ServiceRequestData;
import org.egov.hc.producer.HCConfiguration;

import org.egov.hc.utils.HCConstants;
import org.egov.tracer.model.CustomException;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;
import com.jayway.jsonpath.PathNotFoundException;

import lombok.extern.slf4j.Slf4j;
import net.minidev.json.JSONArray;
import net.minidev.json.JSONObject;

@Service
@Slf4j
public class WorkflowIntegratortest {

	private static final String TENANTIDKEY = "tenantId";

	private static final String BUSINESSSERVICEKEY = "businessService";

	private static final String ACTIONKEY = "action";

	private static final String COMMENTKEY = "comment";

	private static final String MODULENAMEKEY = "moduleName";

	private static final String BUSINESSIDKEY = "businessId";

	private static final String DOCUMENTSKEY = "documents";

	private static final String ASSIGNEEKEY = "assignes";

	private static final String MODULENAMEVALUE = "HORTICULTURE";

	private static final String WORKFLOWREQUESTARRAYKEY = "ProcessInstances";

	private static final String REQUESTINFOKEY = "RequestInfo";

	@Autowired
	private RestTemplate rest;
	
	@Autowired
	private HCConfiguration config;

	
	@Test
	public  void callWorkFlowTest() throws Exception {
	
		String wfTenantId = "ch.chandigarh";
		JSONArray array = new JSONArray();
		JSONObject obj = new JSONObject();
		Document wfDocument = new Document();
		wfDocument.setActive(true);
		wfDocument.setDocumentType("jpg");
		wfDocument.setId("123");
		wfDocument.setTenantId(wfTenantId);
		wfDocument.setFileStoreId("123456");
		wfDocument.setDocumentUid("b4adcccf-1e2a-406c-a203-593fc9c73829");
				
				obj.put("businesssServiceSla", "123456");

				obj.put(DOCUMENTSKEY, wfDocument);
				obj.put(BUSINESSIDKEY, "CH-HC-2020-07-25-001432");
				obj.put(TENANTIDKEY, wfTenantId);	
				
				obj.put(BUSINESSSERVICEKEY, "PRUNING OF TREES GIRTH GREATER THAN 90 CMS" );  
				
		
				obj.put(MODULENAMEKEY, MODULENAMEVALUE);
				obj.put(ACTIONKEY, "INITIATE");		
				obj.put(COMMENTKEY, "Comment");

				obj.put(ASSIGNEEKEY, "EE");
				array.add(obj);
			
			RequestInfo requestinfo = new RequestInfo();
			JSONObject workFlowRequest = new JSONObject();
			workFlowRequest.put(REQUESTINFOKEY,requestinfo );
			workFlowRequest.put(WORKFLOWREQUESTARRAYKEY, array);
			String response = null;
			
			//response = rest.postForObject(config.getWfHost().concat(config.getWfTransitionPath()), workFlowRequest, String.class);
			
	}
	
	
}