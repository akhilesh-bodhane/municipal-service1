
package org.egov.nulm.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.egov.common.contract.request.Role;
import org.egov.common.contract.response.ResponseInfo;
import org.egov.nulm.common.CommonConstants;
import org.egov.nulm.config.NULMConfiguration;
import org.egov.nulm.idgen.model.IdGenerationResponse;
import org.egov.nulm.model.NulmSmidRequest;

import org.egov.nulm.model.Integratrequest;
import org.egov.nulm.model.IntegratrequestPayload;
import org.egov.nulm.model.NulmSepRequest;
import org.egov.nulm.model.ResponseInfoWrapper;
import org.egov.nulm.model.SepApplication;
import org.egov.nulm.model.SmidApplication;
import org.egov.nulm.model.SmidApplicationy;
import org.egov.nulm.model.SuhApplication;
import org.egov.nulm.model.SusvApplication;
import org.egov.nulm.repository.SmidRepository;
import org.egov.nulm.repository.SuhRepository;
import org.egov.nulm.repository.SusvRepository;
import org.egov.nulm.repository.SepRepository;
import org.egov.nulm.util.AuditDetailsUtil;
import org.egov.nulm.util.IdGenRepository;
import org.egov.tracer.model.CustomException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class IntegrateService {

	private final ObjectMapper objectMapper;

	private NULMConfiguration config;

	private SmidRepository repository;
	
	private SuhRepository repository1;
	
	private SusvRepository repository2;
	
	private SepRepository repository3;

	private IdGenRepository idgenrepository;

	private AuditDetailsUtil auditDetailsUtil;

	@Autowired
	public IntegrateService(SmidRepository repository, SusvRepository repository2, SepRepository repository3, SuhRepository repository1, ObjectMapper objectMapper, IdGenRepository idgenrepository,
			NULMConfiguration config, AuditDetailsUtil auditDetailsUtil) {
		this.objectMapper = objectMapper;
		this.repository = repository;
		this.repository1 = repository1;
		this.repository2 = repository2;
		this.repository3 = repository3;
		this.idgenrepository = idgenrepository;
		this.config = config;
		this.auditDetailsUtil = auditDetailsUtil;

	}

	

	public ResponseEntity<Integratrequest> getSMIDApplication(IntegratrequestPayload smidrequests ) {
//		Integratrequest smidrequest,
//        Integratrequest seprequest,Integratrequest request,Integratrequest susvrequest
		try {

			SmidApplication SmidApplication = objectMapper.convertValue(smidrequests.getNulmSmidRequesty(),
					SmidApplication.class);
			SepApplication SEPApplication = objectMapper.convertValue(smidrequests.getNulmSmidRequesty(),
					SepApplication.class);
			SuhApplication suhapplication = objectMapper.convertValue(smidrequests.getNulmSmidRequesty(),
					SuhApplication.class);
			SusvApplication susvApplication = objectMapper.convertValue(smidrequests.getNulmSmidRequesty(),
					SusvApplication.class);
			 List<Role> role = smidrequests.getRequestInfo().getUserInfo().getRoles();
//			List<Role> role1 = susvrequest.getRequestInfo().getUserInfo().getRoles();
//			 List<Role> role2 = request.getRequestInfo().getUserInfo().getRoles();
//				List<Role> role3 = seprequest.getRequestInfo().getUserInfo().getRoles();
			List<SmidApplication> SmidApplicationresult = repository.getSMIDApplication(SmidApplication, role,smidrequests.getRequestInfo().getUserInfo().getId());
			
			List<SuhApplication> SuhApplicationresult = repository1.getSuhApplication(suhapplication,role,smidrequests.getRequestInfo().getUserInfo().getId());
			List<SepApplication> SEPApplicationresult = repository3.getSEPApplication(SEPApplication, role,smidrequests.getRequestInfo().getUserInfo().getId());
			List<SusvApplication> result = repository2.getSusvApplication(susvApplication, role,smidrequests.getRequestInfo().getUserInfo().getId());
			
			return new ResponseEntity<>(Integratrequest.builder()
                .responseInfo(ResponseInfo.builder().status(CommonConstants.SUCCESS).build())
				.nulmSmidRequest(SmidApplicationresult).nulmSepRequest(SEPApplicationresult).nulmSuhRequest(SuhApplicationresult)
				.nulmSepRequest(SEPApplicationresult).nulmSusvRequest(result).build(), HttpStatus.OK);
			

		} catch (Exception e) {
			throw new CustomException(CommonConstants.SMID_APPLICATION_EXCEPTION_CODE, e.getMessage());
		}
	}

	
}