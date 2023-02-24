package org.egov.streetvendor.repository.builder;

import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class StreetvendorQueryBuilder {
	

	public static final String GET_STREET_VENDOR_DATA_QUERY = "SELECT sv.vendor_uuid, sv.cov_no, sv.vendor_name, sv.vendor_aadharno, sv.father_name, sv.spouse_name, sv.nominee_name, sv.nominee_aadharno, sv.name_of_family_member1, sv.name_of_family_member2, sv.mobile_no, sv.alternate_mobile_no, sv.category, sv.trade_of_vending, sv.type_of_vending, sv.permanent_address, sv.present_address, sv.street_vending_idcard_issue, sv.survey_location, sv.survey_locality, sv.status_of_occupancy_street, sv.pm_svanidhi_loan, sv.enrolment_in_pmsby, sv.enrolment_in_pmjjby, sv.bank_account_no, sv.bank_holder_name, sv.bank_name, sv.ifsc_code, sv.tenant_id, sv.is_active, sv.created_by, sv.created_time, sv.last_modified_by, sv.last_modified_time,sv.landmark, \r\n"
			+ " array_to_json(array_agg(json_build_object('documnetUuid',svd.document_uuid, 'filestoreId',svd.filestore_id,'documenttype',svd.document_type, 'vendoruuid',svd.vendor_uuid,'tenantId',svd.tenant_id,'isActive', svd.is_active))) as document \r\n"
			+ "	FROM public.street_vendor_data_detail sv inner join street_vendor_data_document svd on sv.vendor_uuid=svd.vendor_uuid and sv.tenant_id=sv.tenant_id \r\n"
			+ "	 where (sv.cov_no=? or sv.cov_no=? is null) and (sv.vendor_name=? or sv.vendor_name=? is null) and (sv.category=? or sv.category=? is null) \r\n"
			+ "	group by sv.vendor_uuid ORDER BY created_time desc ";
	
	

	
}
