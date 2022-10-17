package org.egov.temporarystall.repository.builder;

import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class STALLQueryBuilder {
	
	public static final String GET_STALL_APPLICATION_QUERY = "SELECT TS.id, TS.applicationn_id, TS.name, TS.mobile_no, TS.festival, TS.from_date, TS.to_date, TS.sector, TS.village , TS.paymentstatus , TS.stall_size, TS.address_details, TS.landmark, TS.tenant_id, TS.total_amount, TS.is_active, TS.created_by, TS.created_time, TS.last_modified_by, TS.last_modified_time, TS.no_o_days, TS.fees_per_day, TS.application_status, TS.main_amount, TS.gst_amont, TS.nominee_name, TS.relation, \n"
			+ "	array_to_json(array_agg(json_build_object('documnetUuid',SD.document_uuid, 'filestoreId',SD.filestore_id, 'applicationUuid',SD.id, 'documentType',SD.document_type, 'tenantId',SD.tenant_id,'isActive', SD.is_active))) as document \n"
			+ "	FROM public.temporary_stall_application_detail TS inner join temporary_stall_application_document SD on TS.id=SD.id and TS.tenant_id=SD.tenant_id \n"
			+ "	 where TS.applicationn_id=(case when ?  <>'' then ?  else TS.applicationn_id end) and TS.application_status = 'FEES PAID' AND TS.paymentstatus IS NULL OR TS.paymentstatus IN ('SUCCESS')  and  \n"
			+ "	 TS.mobile_no=(case when ?  <>'' then ?  else TS.mobile_no end)   \n"
			+ "	 group by TS.id    ORDER BY created_time desc ";
	
	
	public static final String GET_STALL_DEMAND_QUERY = "select id from egbs_demand_v1 edv where consumercode =(case when ?  <>'' then ?  else consumercode end)";
	
	
	public static final String GET_STALL_DEMAND_DETAIL_QUERY ="select id from egbs_demanddetail_v1 edv where demandid  in (select id  from egbs_demand_v1 edv where consumercode =(case when ?  <>'' then ?  else consumercode end) )";
	
	public static final String GET_STALL_PAYMENT_STATUS_QUERY ="select trn.txn_status , trn.txn_id from eg_pg_transactions trn \n"
			+ "	where trn.consumer_code =(case when ?  <>'' then ?  else trn.consumer_code end)";

}
