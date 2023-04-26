package org.egov.streetvendor.repository.builder;

import java.util.List;

import org.egov.common.contract.request.RequestInfo;
import org.egov.streetvendor.model.StreetVendorData;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class StreetvendorQueryBuilder {

	public static final String GET_STREET_VENDOR_DATA_QUERY = "SELECT sv.vendor_uuid, sv.cov_no, sv.vendor_name, sv.vendor_aadharno, sv.father_name, sv.spouse_name, sv.nominee_name, sv.nominee_aadharno, sv.name_of_family_member1, sv.name_of_family_member2, sv.mobile_no, sv.alternate_mobile_no, sv.category, sv.trade_of_vending, sv.type_of_vending, sv.permanent_address, sv.present_address, sv.street_vending_idcard_issue, sv.survey_location, sv.survey_locality, sv.status_of_occupancy_street, sv.pm_svanidhi_loan, sv.enrolment_in_pmsby, sv.enrolment_in_pmjjby, sv.bank_account_no, sv.bank_holder_name, sv.bank_name, sv.ifsc_code, sv.tenant_id, sv.is_active, sv.created_by, sv.created_time, sv.last_modified_by, sv.last_modified_time,sv.landmark,sv.gender,sv.religion,sv.remarks, \r\n"
			+ " array_to_json(array_agg(json_build_object('documentUuid',svd.document_uuid, 'filestoreId',svd.filestore_id,'documenttype',svd.document_type, 'vendoruuid',svd.vendor_uuid,'tenantId',svd.tenant_id,'isActive', svd.is_active))) as document \r\n"
			+ "	FROM public.street_vendor_data_detail sv left join street_vendor_data_document svd on sv.vendor_uuid=svd.vendor_uuid and sv.tenant_id=sv.tenant_id \r\n";

	public static final String GET_DETAILS_STREET_VENDOR_DATA_QUERY = "SELECT sv.vendor_uuid, sv.cov_no, sv.vendor_name, sv.vendor_aadharno, sv.father_name, sv.spouse_name, sv.nominee_name, sv.nominee_aadharno, sv.name_of_family_member1, sv.name_of_family_member2, sv.mobile_no, sv.alternate_mobile_no, sv.category, sv.trade_of_vending, sv.type_of_vending, sv.permanent_address, sv.present_address, sv.street_vending_idcard_issue, sv.survey_location, sv.survey_locality, sv.status_of_occupancy_street, sv.pm_svanidhi_loan, sv.enrolment_in_pmsby, sv.enrolment_in_pmjjby, sv.bank_account_no, sv.bank_holder_name, sv.bank_name, sv.ifsc_code, sv.tenant_id, sv.is_active, sv.created_by, sv.created_time, sv.last_modified_by, sv.last_modified_time,u.name as createdbyname, u1.name as lastmodifiedbyname,sv.landmark,sv.gender,sv.religion,sv.remarks, \r\n"
			+ "array_to_json(array_agg(json_build_object('documentUuid',svd.document_uuid, 'filestoreId',svd.filestore_id,'documenttype',svd.document_type, 'vendoruuid',svd.vendor_uuid,'tenantId',svd.tenant_id,'isActive', svd.is_active))) as document \r\n"
			+ "FROM public.street_vendor_data_detail sv left join street_vendor_data_document svd on sv.vendor_uuid=svd.vendor_uuid and sv.tenant_id=sv.tenant_id left join eg_user u  on sv.created_by =u.id::varchar \r\n"
			+ " left join eg_user u1 on sv.last_modified_by =u1.id::varchar \r\n"
			+ " where sv.cov_no=? group by sv.vendor_uuid, u.name, u1.name";
	
	public static final String GET_COV_NOS_QUERY ="select cov_no from street_vendor_data_detail svdd where svdd.tenant_id ='ch.chandigarh'";
	
	private static final String ORDER_BY_CLAUSE= " ORDER BY created_time desc";
	
	
	public String getSearchQueryStringCount(StreetVendorData streetVendorData, List<Object> preparedStatement,
			RequestInfo requestInfo) {
	
		StringBuilder query = new StringBuilder(GET_STREET_VENDOR_DATA_QUERY);
		boolean propertyIdsPresent = false;
		

		if (streetVendorData.getCovNo() != null) {
			addClauseIfRequired(preparedStatement, query);
			query.append("  sv.cov_no=? ");
			preparedStatement.add(streetVendorData.getCovNo());
		}
		if (streetVendorData.getVendorName() != null) {
			addClauseIfRequired(preparedStatement, query);
			query.append("  sv.vendor_name=? ");
			preparedStatement.add(streetVendorData.getVendorName());
		}
		if (streetVendorData.getCategory() != null) {
			addClauseIfRequired(preparedStatement, query);
			query.append("  sv.category=? ");
			preparedStatement.add(streetVendorData.getCategory());
		}
		
		query.append("group by sv.vendor_uuid");
		
		query.append(ORDER_BY_CLAUSE);
		
		
		return query.toString() ;
	}
	
	
	private void addClauseIfRequired(List<Object> values, StringBuilder queryString) {
		if (values.isEmpty())
			queryString.append(" WHERE ");
		else {
			queryString.append(" AND");
		}
	}

	private void addORClauseIfRequired(List<Object> values, StringBuilder queryString){
		if (values.isEmpty())
			queryString.append(" WHERE ");
		else {
			queryString.append(" OR");
		}
	}

}
