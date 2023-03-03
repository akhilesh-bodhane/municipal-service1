package org.egov.streetvendor.repository.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

import org.egov.streetvendor.common.CommonConstants;
import org.egov.streetvendor.model.AuditDetails;
import org.egov.streetvendor.model.StreetVendorData;
import org.egov.streetvendor.model.StreetVendorDocument;
import org.egov.tracer.model.CustomException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class StreetVendorDetailsRowMapper implements ResultSetExtractor<StreetVendorData> {

	@Autowired
	private ObjectMapper mapper;

	@Override
	public StreetVendorData extractData(ResultSet rs) throws SQLException, DataAccessException {
		StreetVendorData streetvendorDetails = new StreetVendorData();

		try {
			while (rs.next()) {
				streetvendorDetails = StreetVendorData.builder().build();
				streetvendorDetails.setVendorUuid(rs.getString("vendor_uuid"));
				streetvendorDetails.setCovNo(rs.getString("cov_no"));
				streetvendorDetails.setVendorName(rs.getString("vendor_name"));
				streetvendorDetails.setVendorAadharNo(rs.getString("vendor_aadharno"));
				streetvendorDetails.setFatherName(rs.getString("father_name"));
				streetvendorDetails.setSpouseName(rs.getString("spouse_name"));
				streetvendorDetails.setNomineeName(rs.getString("nominee_name"));
				streetvendorDetails.setNomineeAadharNo(rs.getString("nominee_aadharno"));
				streetvendorDetails.setNameOfFamilyMember1(rs.getString("name_of_family_member1"));
				streetvendorDetails.setNameOfFamilyMember2(rs.getString("name_of_family_member2"));
				streetvendorDetails.setMobileNo(rs.getString("mobile_no"));
				streetvendorDetails.setAlternateMobileNo(rs.getString("alternate_mobile_no"));
				streetvendorDetails.setCategory(rs.getString("category"));
				streetvendorDetails.setTradeOfVending(rs.getString("trade_of_vending"));
				streetvendorDetails.setTypeOfVending(rs.getString("type_of_vending"));
				streetvendorDetails.setPermanentAddress(rs.getString("permanent_address"));
				streetvendorDetails.setPresentAddress(rs.getString("present_address"));
				streetvendorDetails.setStreetVendingIdCardIssue(rs.getString("street_vending_idcard_issue"));
				streetvendorDetails.setSurveyLocation(rs.getString("survey_location"));
				streetvendorDetails.setSurveyLocality(rs.getString("survey_locality"));
				streetvendorDetails.setStatusOfOccupancyStreet(rs.getString("status_of_occupancy_street"));
				streetvendorDetails.setPmSvanidhiLoan(rs.getString("pm_svanidhi_loan"));
				streetvendorDetails.setEnrollmentInPMSBY(rs.getString("enrolment_in_pmsby"));
				streetvendorDetails.setEnrollmentInPMJJBY(rs.getString("enrolment_in_pmjjby"));
				streetvendorDetails.setBankAccountNo(rs.getString("bank_account_no"));
				streetvendorDetails.setBankHolderName(rs.getString("bank_holder_name"));
				streetvendorDetails.setBankName(rs.getString("bank_name"));
				streetvendorDetails.setIfscCode(rs.getString("ifsc_code"));
				streetvendorDetails.setTenantId(rs.getString("tenant_id"));
				streetvendorDetails.setIsActive(rs.getBoolean("is_active"));
				streetvendorDetails.setLandmark(rs.getString("landmark"));
				AuditDetails audit = AuditDetails.builder().createdBy(rs.getString("created_by"))
						.createdTime(rs.getLong("created_time")).lastModifiedBy(rs.getString("last_modified_by"))
						.lastModifiedTime(rs.getLong("last_modified_time")).createdByName(rs.getString("createdbyname"))
						.lastModifiedByName(rs.getString("lastmodifiedbyname")).build();
				streetvendorDetails.setAuditDetails(audit);

				List<StreetVendorDocument> documentAttachment = null;
				if (rs.getString("document") != null) {
					documentAttachment = Arrays
							.asList(mapper.readValue(rs.getString("document"), StreetVendorDocument[].class));
				}
				streetvendorDetails.setStreetVendorDocument(documentAttachment);
			}

		} catch (Exception e) {
			throw new CustomException(CommonConstants.STREET_VENDOR_GET_EXCEPTION_CODE, e.getMessage());
		}
		return streetvendorDetails;
	}

}
