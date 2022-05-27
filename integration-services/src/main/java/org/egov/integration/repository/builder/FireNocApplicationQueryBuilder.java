package org.egov.integration.repository.builder;

public class FireNocApplicationQueryBuilder {
	public static final String GET_APPLICATION_MAPPING_QUERY = "SELECT app_detail_uuid,application_id,service_id,application_ref_no,service_name,department_id,department_name,submission_date,submission_mode,application_status,type_of_occupancy_use,submission_location,attribute_details,created_by,created_time,last_modified_by,last_modified_time FROM fire_noc_application_details pt WHERE application_id=:applicationId";

	public static final String GET_APPLICATION_TASK_MAPPING_QUERY = "SELECT app_task_detail_uuid,application_id,task_id,task_name,action_taken,executed_time,application_status,official_form_details,action_taken_user_detail,created_by,created_time,last_modified_by,last_modified_time FROM fire_noc_application_task_details pt WHERE task_id=:taskId";

	public static final String GET_APPLICATION_DUMP_MAPPING_QUERY = "SELECT uuid,data,created_by,created_time,last_modified_by,last_modified_time FROM fire_noc_dump WHERE uuid=:appUuid";

	public static final String GET_APPLICATION_COUNT_STATUS_MAPPING_QUERY = "select count(app_detail_uuid) TotalApplications,sum(case WHEN application_status = 'UNDERPROCESS' THEN 1 ELSE 0 END) UnderProcess,\r\n"
			+ "sum(case WHEN application_status = 'DELIVERED' THEN 1 ELSE 0 END) Delivered,sum(case WHEN application_status = 'REJECTED' THEN 1 ELSE 0 END) Rejected \r\n"
			+ "from public.fire_noc_application_details where (TO_DATE(submission_date,'dd-MM-yyyy') >= case when :fromDate<>'' then TO_DATE(:fromDate,'yyyy-MM-dd') else TO_DATE(submission_date,'dd-MM-yyyy') end and TO_DATE(submission_date,'dd-MM-yyyy') <= case when :toDate<>'' then TO_DATE(:toDate,'yyyy-MM-dd') else TO_DATE(submission_date,'dd-MM-yyyy') end)\r\n"
			+ "and type_of_occupancy_use = case when :typeOfOccupancyUse<>'' then :typeOfOccupancyUse else type_of_occupancy_use end";

	public static final String GET_APPLICATION_WISE_STATUS_MAPPING_QUERY = "select app_detail_uuid,application_id,service_id,application_ref_no,service_name,department_id,department_name,submission_date,submission_mode,application_status,type_of_occupancy_use,submission_location,attribute_details,created_by,created_time,last_modified_by,last_modified_time from public.fire_noc_application_details where (TO_DATE(submission_date,'dd-MM-yyyy') >= case when :fromDate<>'' then TO_DATE(:fromDate,'yyyy-MM-dd') else TO_DATE(submission_date,'dd-MM-yyyy') end and TO_DATE(submission_date,'dd-MM-yyyy') <= case when :toDate<>'' then TO_DATE(:toDate,'yyyy-MM-dd') else TO_DATE(submission_date,'dd-MM-yyyy') end) "
			+ "and type_of_occupancy_use = case when :typeOfOccupancyUse<>'' then :typeOfOccupancyUse else type_of_occupancy_use end and application_ref_no  = case when :applicationRefNo<>'' then :applicationRefNo else application_ref_no end";
}
