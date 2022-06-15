package org.egov.temporarystall.repository.builder;

import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class STALLQueryBuilder {
	
	public static final String GET_STALL_APPLICATION_QUERY = "SELECT TS.id, TS.applicationn_id, TS.name, TS.mobile_no, TS.festival, TS.from_date, TS.to_date, TS.sector, TS.stall_size, TS.address_details, TS.landmark, TS.tenant_id, TS.total_amount, TS.is_active, TS.created_by, TS.created_time, TS.last_modified_by, TS.last_modified_time, TS.no_o_days, TS.fees_per_day, TS.application_status, \n"
			+ "	array_to_json(array_agg(json_build_object('documnetUuid',SD.document_uuid, 'filestoreId',SD.filestore_id, 'id',SD.id, 'documentType',SD.document_type, 'tenantId',SD.tenant_id,'isActive', SD.is_active))) as document \n"
			+ "	FROM public.temporary_stall_application_detail TS inner join temporary_stall_application_document SD on TS.id=SD.id and TS.tenant_id=SD.tenant_id \n"
			+ "	 where TS.applicationn_id=(case when ?  <>'' then ?  else TS.applicationn_id end) and \n"
			+ "	 TS.mobile_no=(case when ?  <>'' then ?  else TS.mobile_no end) \n"
			+ "	 group by TS.id    ORDER BY created_time desc";

}
