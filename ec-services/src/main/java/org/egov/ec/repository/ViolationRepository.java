package org.egov.ec.repository;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.egov.ec.config.EchallanConfiguration;
import org.egov.ec.producer.Producer;
import org.egov.ec.repository.builder.EcQueryBuilder;
import org.egov.ec.repository.rowmapper.ColumnsRowMapper;
import org.egov.ec.repository.rowmapper.DuplicateChallanRowMapper;
import org.egov.ec.repository.rowmapper.ReceiptNoRowMapper;
import org.egov.ec.repository.rowmapper.ViolationDetailCountRowMapper;
import org.egov.ec.repository.rowmapper.ViolationDetailRowMapper;
import org.egov.ec.repository.rowmapper.ViolationDetailRowMapperV2;
import org.egov.ec.web.models.ChallanDataBckUp;
import org.egov.ec.web.models.DuplicateChallanDetails;
import org.egov.ec.web.models.EcPayment;
import org.egov.ec.web.models.EcPaymentData;
import org.egov.ec.web.models.EcSearchCriteria;
import org.egov.ec.web.models.RequestInfoWrapper;
import org.egov.ec.web.models.Violation;
import org.egov.ec.web.models.ViolationCount;
import org.egov.tracer.model.CustomException;
import org.json.simple.JSONArray;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Repository
public class ViolationRepository {

	private JdbcTemplate jdbcTemplate;

	private ViolationDetailRowMapper rowMapper;

	private ViolationDetailRowMapperV2 violationDetailRowMapperV2;

	private ViolationDetailCountRowMapper rowCountMapper;

	private ColumnsRowMapper columnsRowMapper;

	private Producer producer;

	private EchallanConfiguration config;

	private EcQueryBuilder ecQueryBuilder;

	private ReceiptNoRowMapper receiptNoRowMapper;

	public ViolationRepository(JdbcTemplate jdbcTemplate, Producer producer, EchallanConfiguration config,
			ViolationDetailRowMapper rowMapper, ColumnsRowMapper columnsRowMapper,
			ViolationDetailCountRowMapper rowCountMapper, ReceiptNoRowMapper receiptNoRowMapper,
			EcQueryBuilder ecQueryBuilder, ViolationDetailRowMapperV2 violationDetailRowMapperV2) {
		this.jdbcTemplate = jdbcTemplate;
		this.rowMapper = rowMapper;
		this.producer = producer;
		this.config = config;
		this.ecQueryBuilder = ecQueryBuilder;
		this.columnsRowMapper = columnsRowMapper;
		this.rowCountMapper = rowCountMapper;
		this.receiptNoRowMapper = receiptNoRowMapper;
		this.violationDetailRowMapperV2 = violationDetailRowMapperV2;
	}

	/**
	 * Pushes the request in generateChallan topic to save challan data
	 *
	 * @param violationMaster Violation model
	 */
	public void generateChallan(@Valid Violation violationMaster) {
		log.info("Violation Repository - generateChallan Method");
		RequestInfoWrapper infoWrapper = RequestInfoWrapper.builder().requestBody(violationMaster).build();
		producer.push(config.getGenerateChallanTopic(), infoWrapper);

	}

	/**
	 * Pushes the request in updateChallan topic to update challan status
	 *
	 * @param violationMaster Violation model
	 */
	public void updateChallan(@Valid Violation violationMaster) {
		log.info("Violation Repository - updateChallan Method");
		RequestInfoWrapper infoWrapper = RequestInfoWrapper.builder().requestBody(violationMaster).build();
		producer.push(config.getUpdateChallanTopic(), infoWrapper);
	}

	/**
	 * fetches the list of challans for different screens
	 *
	 * @param searchCriteria Search criteria to apply filter
	 * @return Returns the list of challans
	 */

	public List<Violation> getChallan(EcSearchCriteria searchCriteria) {
		log.info("Violation Repository - getChallan Method");

		List<Violation> violationDetailList = null;

		String parameter = "%" + searchCriteria.getSearchText() + "%";

		if (null != searchCriteria.getSearchText() && !searchCriteria.getSearchText().isEmpty()) {
			try {
				violationDetailList = jdbcTemplate.query(
						EcQueryBuilder.GET_VIOLATION_MASTER_SEARCH, new Object[] { parameter, parameter, parameter,
								parameter, parameter, parameter, parameter, parameter, searchCriteria.getTenantId() },
						rowMapper);
			} catch (Exception e) {
				log.error("Violation Service - Get Violation Exception" + e.getMessage());
			}

			if (violationDetailList.size() >= searchCriteria.getLimit()) {

				return new ArrayList<Violation>(violationDetailList.subList(0, searchCriteria.getLimit()));
			} else {
				return violationDetailList;
			}

		} else if (searchCriteria.getAction().equalsIgnoreCase("auctionChallan")) {
			System.out.println("Inside auctionChallan type action");
			violationDetailList = jdbcTemplate.query(EcQueryBuilder.GET_VIOLATION_MASTER_AUTION,
					new Object[] { searchCriteria.getTenantId(), searchCriteria.getFromDate(), searchCriteria.getToDate() }, rowMapper);
			return violationDetailList;

		} else if (searchCriteria.getAction().equalsIgnoreCase("ChallanSM")) {

			violationDetailList = jdbcTemplate.query(EcQueryBuilder.GET_VIOLATION_MASTER_SM,
					new Object[] { searchCriteria.getTenantId() }, rowMapper);
			return violationDetailList;

		} else {
			violationDetailList = jdbcTemplate.query(EcQueryBuilder.GET_VIOLATION_MASTER,
					new Object[] { searchCriteria.getTenantId() }, rowMapper);

			if (violationDetailList.size() >= searchCriteria.getLimit()) {
				return new ArrayList<Violation>(violationDetailList.subList(0, searchCriteria.getLimit()));

			} else {
				return violationDetailList;
			}
		}
	}

	/**
	 * fetches the penalty amount and fine date validation
	 *
	 * @param violationMaster Violation model
	 * @return Returns the penalty amount
	 */
	public String getpenalty(@Valid Violation violationMaster) {
		log.info("Violation Repository - getpenalty Method");
		String numberOfViolation;
		String x = null;
		try {
			if (violationMaster.getEncroachmentType().equals("Seizure of Vehicles")) {
				numberOfViolation = violationMaster.getViolationItem().get(0).getItemType();
			} else {
				numberOfViolation = violationMaster.getNumberOfViolation() + "";
			}
			x = jdbcTemplate.queryForObject(EcQueryBuilder.GET_FINE_PENALTY_AMOUNT,
					new Object[] { violationMaster.getEncroachmentType(), numberOfViolation },

					(String.class));
		} catch (Exception e) {
			return x;
		}
		return x;

	}

	/**
	 * Pushes the request in AddpaymentHistory topic to to maintain payment history
	 * for online payment
	 *
	 * @param ecPayment EcPayment model
	 */
	public void addPayment(EcPayment ecPayment) {
		log.info("Violation Repository - addPayment Method");
		RequestInfoWrapper infoWrapper = RequestInfoWrapper.builder().requestBody(ecPayment).build();
		producer.push(config.getAddpaymentHistoryTopic(), infoWrapper);

	}

	/**
	 * fetches the list of challans which are marked as defective by storemanager
	 *
	 * @param searchCriteria EcSearchCriteria model
	 * @return Returns the list of challans
	 */
	public List<Violation> getChallanForHOD(EcSearchCriteria searchCriteria) {
		log.info("Violation Repository - getChallanForHOD Method");

		List<Violation> violationDetailList = jdbcTemplate.query(EcQueryBuilder.GET_VIOLATION_MASTER_HOD,
				new Object[] { searchCriteria.getTenantId() }, rowMapper);
		return violationDetailList;
	}

	/**
	 * fetches the list of challans whoose auctions are need to be approved by hod
	 *
	 * @param searchCriteria EcSearchCriteria model
	 * @return Returns the list of challans
	 */
	public List<Violation> getChallanForAuctionHOD(EcSearchCriteria searchCriteria) {
		log.info("Violation Repository - getChallanForAuctionHOD Method");

		List<Violation> violationDetailList = jdbcTemplate.query(EcQueryBuilder.GET_VIOLATION_MASTER_AUCTION_HOD,
				new Object[] { searchCriteria.getTenantId() }, rowMapper);
		return violationDetailList;
	}

	/**
	 * fetches the list of challans on the basis of search criterias
	 *
	 * @param searchCriteria EcSearchCriteria model
	 * @return Returns the list of challans
	 */
//	public List<Violation> getSearchChallan(Violation violation) {
//		log.info("Violation Repository - getSearchChallan Method");
//
//		List<Violation> violationDetailList;
//
//		violationDetailList = jdbcTemplate.query(EcQueryBuilder.SEARCH_VIOLATION_MASTER,
//				new Object[] { violation.getFromDate(), violation.getFromDate(), violation.getToDate(),
//						violation.getToDate(), violation.getSiName(), violation.getSiName(),
//						violation.getEncroachmentType(), violation.getEncroachmentType(), violation.getSector(),
//						violation.getSector(), violation.getStatus(), violation.getStatus(), violation.getTenantId(),
//						violation.getChallanId(), violation.getChallanId() },
//				rowMapper);
//
//		return violationDetailList;
//
//	}

	public List<Violation> getSearchChallan(Violation violation) {
		log.info("Violation Repository - getSearchChallan Method");

		List<Violation> violationDetailList;

		violationDetailList = jdbcTemplate.query(EcQueryBuilder.SEARCH_VIOLATION_MASTER,
				new Object[] { violation.getStatus(), violation.getStatus(), violation.getFromDate(),
						violation.getFromDate(), violation.getToDate(), violation.getToDate(),
						violation.getEncroachmentType(), violation.getEncroachmentType(), violation.getSiName(),
						violation.getSiName(), violation.getSector(), violation.getSector(), violation.getSurveyedCovNo(), violation.getSurveyedCovNo(),
						violation.getChallanId(), violation.getChallanId() },
				violationDetailRowMapperV2);
		System.out.println("Violation Detail List : " + violationDetailList.toString());

		return violationDetailList;

	}

	/**
	 * fetches the list of challans on the basis of search criterias For Count
	 *
	 * @param searchCriteria EcSearchCriteria model
	 * @return Returns the list of challans
	 */
	public List<ViolationCount> getSearchChallanCount(ViolationCount violation) {
		log.info("Violation Repository - getSearchChallan Method");

		List<ViolationCount> violationDetailList;

		violationDetailList = jdbcTemplate.query(EcQueryBuilder.SEARCH_VIOLATION_MASTER_COUNT, new Object[] {
				violation.getFromDate(), violation.getFromDate(), violation.getToDate(), violation.getToDate() },
				rowCountMapper);

		return violationDetailList;

	}

	public void updatePayment(EcPaymentData ecPayment) {
		log.info("Violation Repository - updatePayment Method");
		RequestInfoWrapper infoWrapper = RequestInfoWrapper.builder().requestBody(ecPayment).build();
		producer.push(config.getUpdatePayment(), infoWrapper);
	}

	public void deleteChallan(ChallanDataBckUp bck) {
		RequestInfoWrapper infoWrapper = RequestInfoWrapper.builder().requestBody(bck).build();
		producer.push(config.getDataBckChallan(), infoWrapper);

	}

	public JSONArray getdataProcessInstance(ChallanDataBckUp bck) {
		return jdbcTemplate.query(EcQueryBuilder.SEARCH_PROCESS_INSTANCE,
				new Object[] { bck.getChallanId(), bck.getChallanId() }, columnsRowMapper);
	}

	public JSONArray getdataEgecDocument(ChallanDataBckUp bck) {
		return jdbcTemplate.query(EcQueryBuilder.SEARCH_DOCUMENt, new Object[] { bck.getChallanId() },
				columnsRowMapper);
	}

	public JSONArray getdataStoreItem(ChallanDataBckUp bck) {
		return jdbcTemplate.query(EcQueryBuilder.SEARCH_STORE_ITEM, new Object[] { bck.getChallanId() },
				columnsRowMapper);
	}

	public JSONArray getdatPayment(ChallanDataBckUp bck) {
		return jdbcTemplate.query(EcQueryBuilder.SEARCH_PAYMENT, new Object[] { bck.getChallanId() }, columnsRowMapper);
	}

	public JSONArray getdatChallanDetail(ChallanDataBckUp bck) {
		return jdbcTemplate.query(EcQueryBuilder.SEARCH_CHALLAN_DETAILS, new Object[] { bck.getChallanId() },
				columnsRowMapper);
	}

	public JSONArray getdatChallanMaster(ChallanDataBckUp bck) {
		return jdbcTemplate.query(EcQueryBuilder.SEARCH_CHALLAN_MASTER, new Object[] { bck.getChallanId() },
				columnsRowMapper);
	}

	public JSONArray getdatViolationDetail(ChallanDataBckUp bck) {
		return jdbcTemplate.query(EcQueryBuilder.SEARCH_VIOLATION_DETAIL, new Object[] {}, columnsRowMapper);
	}

	public JSONArray getdatViolationMaster(ChallanDataBckUp bck) {
		return jdbcTemplate.query(EcQueryBuilder.SEARCH_VIOLATION_MASTER_DETAILS, new Object[] {}, columnsRowMapper);
	}

	public void editChallan(Violation violationMaster) {
		RequestInfoWrapper infoWrapper = RequestInfoWrapper.builder().requestBody(violationMaster).build();
		producer.push(config.getEditChallanTopic(), infoWrapper);
	}

	public String getReceiptNo(EcSearchCriteria searchCriteria) {
		String receiptno = "";

		try {
			return receiptno = jdbcTemplate.query(EcQueryBuilder.GET_RECEIPT_NO,
					new Object[] { searchCriteria.getSearchText() }, receiptNoRowMapper);
		} catch (Exception e) {
			e.printStackTrace();
			throw new CustomException("Exception", e.getMessage());
		}

	}
	
	public List<DuplicateChallanDetails> getDuplicatechallanDetails(DuplicateChallanDetails duplicateChallanDetails) {
	    List<DuplicateChallanDetails> sterilizationdog = new ArrayList<>();

	    try {
	    	
	    	// Mandatory validation
	        if (duplicateChallanDetails.getEncroachmentType() == null || duplicateChallanDetails.getMobileNumber() == null) {
	            throw new CustomException("MANDATORY_FIELDS_MISSING", "Encroachment type and Mobile number are required.");
	        }

	        // Conditional validation based on encroachment type
	        if ("Unauthorized/Unregistered Vendor".equalsIgnoreCase(duplicateChallanDetails.getEncroachmentType())
	                && duplicateChallanDetails.getNumberOfViolation() == null) {
	            throw new CustomException("MANDATORY_FIELDS_MISSING", "Number of violations is required for Unauthorized/Unregistered Vendor.");
	        }
	    	
	        StringBuilder queryBuilder = new StringBuilder();
	        List<Object> parameters = new ArrayList<>();

	        queryBuilder.append("SELECT ")
	                    .append("ecm.challan_id, ")
	                    .append("ecm.challan_status, ")
	                    .append("ecm.challan_amount, ")
	                    .append("TO_CHAR(TO_TIMESTAMP(ecm.created_time / 1000), 'DD-MM-YYYY') AS challan_date, ")
	                    .append("evm.encroachment_type, ")
	                    .append("evm.contact_number, ")
	                    .append("evm.violator_name, ")
	                    .append("evm.number_of_violation, ")
	                    .append("ep.payment_mode, ")
	                    .append("ep.payment_status, ")
	                    .append("STRING_AGG(DISTINCT evd.item_name, ', ') AS item_names ")
	                    .append("FROM egec_challan_detail ecd ")
	                    .append("INNER JOIN egec_challan_master ecm ON ecm.challan_uuid = ecd.challan_uuid ")
	                    .append("INNER JOIN egec_violation_master evm ON evm.violation_uuid = ecm.violation_uuid ")
	                    .append("INNER JOIN egec_violation_detail evd ON evd.violation_uuid = evm.violation_uuid ")
	                    .append("INNER JOIN egec_payment ep ON ep.challan_uuid = ecm.challan_uuid ")
	                    .append("WHERE ecd.tenant_id = 'ch.chandigarh' AND ep.payment_status = 'PENDING' ");

	        // Dynamic conditions
	        if (duplicateChallanDetails.getEncroachmentType() != null) {
	            queryBuilder.append("AND evm.encroachment_type = ? ");
	            parameters.add(duplicateChallanDetails.getEncroachmentType());
	        }

	        if (duplicateChallanDetails.getMobileNumber() != null) {
	            queryBuilder.append("AND evm.contact_number = ? ");
	            parameters.add(duplicateChallanDetails.getMobileNumber());
	        }

	        if (duplicateChallanDetails.getNumberOfViolation() != null) {
	            queryBuilder.append("AND evm.number_of_violation = ? ");
	            parameters.add(duplicateChallanDetails.getNumberOfViolation());
	        }

	        queryBuilder.append("AND (evm.encroachment_type, evm.contact_number, evm.violator_name, evm.number_of_violation, TRIM(LOWER(evd.item_name))) IN ( ")
	                    .append("SELECT evm2.encroachment_type, evm2.contact_number, evm2.violator_name, evm2.number_of_violation, TRIM(LOWER(evd2.item_name)) ")
	                    .append("FROM egec_challan_master ecm2 ")
	                    .append("INNER JOIN egec_violation_master evm2 ON evm2.violation_uuid = ecm2.violation_uuid ")
	                    .append("INNER JOIN egec_violation_detail evd2 ON evd2.violation_uuid = evm2.violation_uuid ")
	                    .append("INNER JOIN egec_payment ep2 ON ep2.challan_uuid = ecm2.challan_uuid ")
	                    .append("WHERE ep2.payment_status = 'PENDING' AND ecm2.tenant_id = 'ch.chandigarh' ")
	                    .append("GROUP BY evm2.encroachment_type, evm2.contact_number, evm2.violator_name, evm2.number_of_violation, TRIM(LOWER(evd2.item_name)) ")
	                    .append("HAVING COUNT(*) > 1) ");

	        queryBuilder.append("GROUP BY ecm.challan_id, ecm.challan_amount, ecm.created_time, ecm.challan_status, ")
	                    .append("evm.encroachment_type, evm.violator_name, evm.number_of_violation, evm.contact_number, ")
	                    .append("ep.payment_mode, ep.payment_status ")
	                    .append("ORDER BY ecm.challan_id DESC");

	        return jdbcTemplate.query(queryBuilder.toString(), parameters.toArray(), new DuplicateChallanRowMapper());

	    } catch (Exception e) {
	        e.printStackTrace();
	        throw new CustomException("Exception", e.getMessage());
	    }
	}

}
