package org.egov.temporarystall.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.UUID;

import org.egov.common.contract.request.RequestInfo;
import org.egov.common.contract.request.Role;
import org.egov.common.contract.response.ResponseInfo;
import org.egov.mdms.model.MdmsResponse;
import org.egov.temporarystall.common.CommonConstants;
import org.egov.temporarystall.config.StallConfiguration;
import org.egov.temporarystall.idgen.model.IdGenerationResponse;
import org.egov.temporarystall.model.ResponseInfoWrapper;
import org.egov.temporarystall.model.StallApplication;
import org.egov.temporarystall.model.StallApplicationDocument;
import org.egov.temporarystall.model.StallRequest;
import org.egov.temporarystall.model.demand.Demand;
import org.egov.temporarystall.model.demand.Demand.StatusEnum;
import org.egov.temporarystall.model.demand.DemandDetail;
import org.egov.temporarystall.model.demand.DemandRequest;
import org.egov.temporarystall.repository.TemporaryStallRepository;
import org.egov.temporarystall.repository.ServiceRequestRepository;
import org.egov.temporarystall.util.AuditDetailsUtil;
import org.egov.temporarystall.util.IdGenRepository;
import org.egov.tracer.model.CustomException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jayway.jsonpath.JsonPath;

@Service
public class StallService {

	private final ObjectMapper objectMapper;
	
	private StallConfiguration config;
	
	private TemporaryStallRepository repository;
	
	private IdGenRepository idgenrepository;
	
	private AuditDetailsUtil auditDetailsUtil;
	
	@Autowired
	private MDMSService mdmsService;
	
	
	@Autowired
	private ObjectMapper mapper;
	
	
	@Autowired
	private ServiceRequestRepository repository1;
	
	@Autowired
	private EnrichmentService enrichmentService;

	@Autowired
	public StallService(TemporaryStallRepository repository,ObjectMapper objectMapper,IdGenRepository idgenrepository,
			StallConfiguration config,AuditDetailsUtil auditDetailsUtil) {
		this.objectMapper = objectMapper;
		this.repository = repository;
		this.idgenrepository = idgenrepository;
		this.config = config;
		this.auditDetailsUtil=auditDetailsUtil;
	}

	public ResponseEntity<ResponseInfoWrapper> createStallApplication(StallRequest stallrequest) {
		try {
			StallApplication stallapplication = objectMapper.convertValue(stallrequest.getStallApplicationRequest(),
					StallApplication.class);
			String stallid = UUID.randomUUID().toString();
			stallapplication.setApplicationUuid(stallid);
			stallapplication.setIsActive(true);
			stallapplication.setAuditDetails(
					auditDetailsUtil.getAuditDetails(stallrequest.getRequestInfo(), CommonConstants.ACTION_DRAFT));
			// idgen service call to genrate event id
			IdGenerationResponse id = idgenrepository.getId(stallrequest.getRequestInfo(), stallapplication.getTenantId(),
					config.getStallapplicationNumberIdgenName(), config.getStallapplicationNumberIdgenFormat(), 1);
			if (id.getIdResponses() != null && id.getIdResponses().get(0) != null)
				stallapplication.setApplicationId(id.getIdResponses().get(0).getId());
			else
				throw new CustomException(HttpStatus.INTERNAL_SERVER_ERROR.toString(), CommonConstants.ID_GENERATION);

			//stallapplication.setTotalamount(stallapplication.getNoofdays() * stallapplication.getFeesperday());
			stallapplication.setApplicationstatus(CommonConstants.ACTION_DRAFT);
			// save document to temporary_stall_application_document table
			List<StallApplicationDocument> stalldoc = new ArrayList<>();
			for (StallApplicationDocument docobj : stallapplication.getApplicationDocument()) {
				StallApplicationDocument document = new StallApplicationDocument();
				document.setDocumnetUuid(UUID.randomUUID().toString());
				document.setApplicationUuid(stallid);
				document.setDocumentType(docobj.getDocumentType());
				document.setFilestoreId(docobj.getFilestoreId());
				document.setAuditDetails(
						auditDetailsUtil.getAuditDetails(stallrequest.getRequestInfo(), CommonConstants.ACTION_DRAFT));
				document.setIsActive(true);
				document.setTenantId(stallapplication.getTenantId());
				stalldoc.add(document);

			}

			stallapplication.setApplicationDocument(stalldoc);
			
			
			Object mdmsData = mdmsService.mDMSCall(stallrequest.getRequestInfo(), stallapplication.getTenantId());
			
//			int getpayperrant = getpayperrant(stallrequest.getRequestInfo(), mdmsData,stallapplication);
			
			double stallsizerate = getStallsize(stallrequest.getRequestInfo(), mdmsData,stallapplication);
			
			double amount=stallapplication.getNoofdays() * stallsizerate ;
			
			double totalamount =  amount + (amount * 0.18);
			
			
			
			stallapplication.setTotalamount(totalamount);
			
			
			enrichmentService.generateDemand(stallrequest);
			
			repository.createSTALLApplication(stallapplication);

			return new ResponseEntity<>(ResponseInfoWrapper.builder()
					.responseInfo(ResponseInfo.builder().status(CommonConstants.SUCCESS).build())
					.responseBody(stallapplication).build(), HttpStatus.CREATED);

		} catch (Exception e) {
			throw new CustomException(CommonConstants.STALL_APPLICATION_EXCEPTION_CODE, e.getMessage());
		}
	}
	
	
	
	
	public ResponseEntity<ResponseInfoWrapper> getSTALLApplication(StallRequest stallrequest) {
		try {

			StallApplication StallApplication = objectMapper.convertValue(stallrequest.getStallApplicationRequest(),
					StallApplication.class);			
			List<StallApplication> StallApplicationresult = repository.getStallApplication(StallApplication);
			return new ResponseEntity<>(ResponseInfoWrapper.builder()
					.responseInfo(ResponseInfo.builder().status(CommonConstants.SUCCESS).build())
					.responseBody(StallApplicationresult).build(), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			throw new CustomException(CommonConstants.STALL_APPLICATION_EXCEPTION_CODE, e.getMessage());
		}
	}
	
//	public int getpayperrant(RequestInfo requestInfo,Object mdmsData,StallApplication stallapplication) {
//		int feeperamount = 0;
//		try {
//
//			LinkedHashMap opmsData = JsonPath.read(mdmsData, CommonConstants.MDMS_PM_PATH);
//			if (opmsData.size() == 0)
//				return 0;
//
//			List jsonOutput = JsonPath.read(mdmsData, CommonConstants.MDMS_TAXHEAD_PATH);
//
//			for (Object entry : jsonOutput) {
//				HashMap<String, Object> map = (HashMap<String, Object>) entry;
//				
//				String festivalname = ((String) map.get("name")).split("\\.")[0];
//				if (festivalname != null && festivalname.equalsIgnoreCase(stallapplication.getFestival())) {
//					feeperamount = new Integer(map.get("feesperday").toString());
//					
//					//stallapplication.setFeesperday(feeperamount);
//					
//				
//					
//				break;
//				}
//			}
//
//		} catch (Exception e) {
//			throw new CustomException("MDMS ERROR", "Failed to get calculationType");
//		}
//
//		return feeperamount;
//	}
	
	@SuppressWarnings("unlikely-arg-type")
	public int getStallsize(RequestInfo requestInfo,Object mdmsData,StallApplication stallapplication) {
	int sizeamount = 0;
	try {

	LinkedHashMap opmsData = JsonPath.read(mdmsData, CommonConstants.MDMS_PM_PATH);
	if (opmsData.size() == 0)
	return 0;

	List jsonOutput = JsonPath.read(mdmsData, CommonConstants.MDMS_TAXHEAD_SIZE_PATH);


	for (Object entry : jsonOutput) {
	HashMap<String, Object> map = (HashMap<String, Object>) entry;


	String sector = ((String) map.get("sector")).split("\\.")[0];
	String size = ((String) map.get("size"));
//	String requestdays = ((String) map.get("maxdays"));


	   if("Diwali".equalsIgnoreCase(stallapplication.getFestival()) && stallapplication.getNoofdays()== 20) {
	    if("Up to 250Sq.ft".equalsIgnoreCase(stallapplication.getStallsize())){
	sizeamount = 2000;

	break;
	 }
	   }
	if(sector!=null && (!"17".equalsIgnoreCase(stallapplication.getSector()) && !"22".equalsIgnoreCase(stallapplication.getSector()))) {
	if(size !=null && size.equalsIgnoreCase(stallapplication.getStallsize())){
	sizeamount = new Integer(map.get("rate").toString());

	break;
	}
	}
	if(sector.equalsIgnoreCase(stallapplication.getSector())) {
	if(size !=null && size.equalsIgnoreCase(stallapplication.getStallsize())) {
	sizeamount = new Integer(map.get("rate").toString());

	break;
	}
	}

	}


	} catch (Exception e) {
	throw new CustomException("MDMS ERROR", "Failed to get calculationType");
	}

	return sizeamount;
	}
	
	///
	
	public ResponseEntity<ResponseInfoWrapper> updateStallApplication(StallRequest stallrequest) throws Exception {
		StallApplication StallApplication = objectMapper.convertValue(stallrequest.getStallApplicationRequest(),
				StallApplication.class);			
		
//		validate.validateStall(StallApplication);
		StallApplication.setAuditDetails(
				auditDetailsUtil.getAuditDetails(stallrequest.getRequestInfo(), CommonConstants.ACTION_DRAFT));
		StallApplication.setTotalamount(StallApplication.getNoofdays() * StallApplication.getFeesperday());
		StallApplication.setApplicationstatus(CommonConstants.ACTION_DRAFT);
		// Update document to temporary_stall_application_document table
					List<StallApplicationDocument> stalldoc = new ArrayList<>();
					for (StallApplicationDocument docobj : StallApplication.getApplicationDocument()) {
						StallApplicationDocument document = new StallApplicationDocument();
						document.setDocumnetUuid(docobj.getDocumnetUuid());
						document.setDocumentType(docobj.getDocumentType());
						document.setApplicationUuid(docobj.getApplicationUuid());
						document.setFilestoreId(docobj.getFilestoreId());
						document.setAuditDetails(
								auditDetailsUtil.getAuditDetails(stallrequest.getRequestInfo(), CommonConstants.ACTION_DRAFT));
						document.setIsActive(true);
						document.setTenantId(StallApplication.getTenantId());
						stalldoc.add(document);

					}
					
					
					Object mdmsData = mdmsService.mDMSCall(stallrequest.getRequestInfo(), StallApplication.getTenantId());
					
					double stallsizerate = getStallsize(stallrequest.getRequestInfo(), mdmsData,StallApplication);
					
					double amount=StallApplication.getNoofdays() * stallsizerate ;
					
					double totalamount =  amount + (amount * 0.18);
					
					StallApplication.setTotalamount(totalamount);
					
//					List<Demand> searchResult = calculation.searchDemand("ch.chandigarh",
//							Collections.singleton(StallApplication.getApplicationId()), stallrequest.getRequestInfo());
					
					StringBuilder uri = new StringBuilder();
					uri = uri.append(config.getBillingHost()).append(config.getBillingHostSerach());
					
					uri = uri.append("tenantId=").append("ch.chandigarh").append("&businessService=").append("TEMPORARY_STALL_CHARGES_BOOKING&consumerCode=").append(StallApplication.getApplicationId());
					
					Object fetchResult = repository1.fetchResult(uri,
							stallrequest.getRequestInfo());   
					
					
					
					
					StringBuilder curi = new StringBuilder();
//					uric = uri.append(config.getBillingHost()).append(config.getBillingHostSerach());
					StringBuilder append = curi.append(config.getCollectionHostSerach()).append(config.getCollectionSearcheUrl());
					append.append("consumerCodes=").append(StallApplication.getApplicationId()).append("&tenantId=ch.chandigarh");
					
					  
//					Object fetchResultCollecto = repository1.fetchResult(append,
//						stallrequest.getRequestInfo());
//					Object fetchResult2 = repository1.fetchResult(append, stallrequest.getRequestInfo());
					
//					RequestInfo req =new RequestInfo(stallrequest.getRequestInfo());
					
					
					
//					Demand demand = StallApplication.getDemand();
				
					
//                     
//					convertValue.
//					List<DemandDetail> demandDetails = demand.getDemandDetails();
//					List<DemandDetail> updatedDemandDetails = getUpdatedDemandDetails(calculation, demandDetails);
//					demand.setDemandDetails(updatedDemandDetails);
//					demands.add(demand);
//				}
					
						
						org.egov.common.contract.request.User i1 = new org.egov.common.contract.request.User();

//						User lp = stallrequest.getRequestInfo().getUserInfo();
						i1.setId(stallrequest.getRequestInfo().getUserInfo().getId());
						i1.setEmailId(stallrequest.getRequestInfo().getUserInfo().getEmailId());
						i1.setName(stallrequest.getRequestInfo().getUserInfo().getName());
						i1.setTenantId(stallrequest.getRequestInfo().getUserInfo().getTenantId());
						i1.setType(stallrequest.getRequestInfo().getUserInfo().getType());
						i1.setUuid(stallrequest.getRequestInfo().getUserInfo().getUuid());
						i1.setUserName(stallrequest.getRequestInfo().getUserInfo().getUserName());

				
						double j =0;

						

						DemandDetail ff = new DemandDetail();
//						ff.setId(stallid);
						ff.setTaxHeadMasterCode("TEMPORARY_STALL_CHARGES_BOOKING");
						ff.setDemandId(StallApplication.getApplicationId());
						ff.setTenantId("ch.chandigarh");
						ff.setCollectionAmount(j);
						ff.setTaxAmount(totalamount);
						ff.setAuditDetails(StallApplication.getAuditDetails());

						List<DemandDetail> dema1 = new ArrayList<>();

						dema1.add(ff);

						List<Demand> dema = new ArrayList<>();
						Demand build2 = Demand.builder().id(StallApplication.getApplicationUuid()).tenantId("ch.chandigarh")
								.consumerCode(StallApplication.getApplicationId()).consumerType("booking")
								.businessService("TEMPORARY_STALL_CHARGES_BOOKING")
								.taxPeriodFrom(StallApplication.getAuditDetails().getLastModifiedTime())
								.taxPeriodTo(StallApplication.getAuditDetails().getLastModifiedTime())
								.demandDetails(dema1).auditDetails(StallApplication.getAuditDetails())
								.minimumAmountPayable(BigDecimal.ZERO).status(StatusEnum.ACTIVE).payer(i1)
								.demandDetails(dema1).build();
						dema.add(build2);
						DemandRequest DR = new DemandRequest();
						DemandRequest build = DR.builder().demands(dema).build();
						DemandRequest request = new DemandRequest(stallrequest.getRequestInfo(), dema);
//							DemandBuilder businessService = Demand.builder().id(stallid).tenantId("ch").consumerCode("123").consumerType("temp").businessService("temp");

						
						MdmsResponse response2 = mapper.convertValue(
								repository1.fetchResult(repository.getBillingUpdateUrl(), request),
								MdmsResponse.class);
					
					StallApplication.setApplicationDocument(stalldoc);
					repository.updateSTALLApplication(StallApplication);
		
					return new ResponseEntity<>(ResponseInfoWrapper.builder()
							.responseInfo(ResponseInfo.builder().status(CommonConstants.SUCCESS).build())
							.responseBody(StallApplication).build(), HttpStatus.CREATED);
		
		
	}



}
