package org.egov.hcr.repository.builder;

import java.util.List;

import org.egov.hcr.model.RequestData;
import org.egov.hcr.producer.HCConfiguration;
import org.egov.hcr.utils.HCConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.google.common.base.Strings;

@Component
public class HCQueryBuilder {

	@Autowired
	private HCConfiguration hcConfiguration;

	@Autowired
	public HCQueryBuilder(HCConfiguration config) {

	}

	private static final String QUERY = "select service_request_id,service_type,owner_name,service_request_status,tenant_id,current_assignee,to_char(to_timestamp(cast(createdtime/1000 as bigint))::date ,'DD/MM/YYYY')as createdtime,lastmodifiedtime,servicerequestsubtype,locality,street_name,landmark, createdtime as createdDateTime,ispremises, istreelies, sketchplanoftree, service_type_name,checkpoints from eg_hc_service_request hc ";

	private static final String DASHBOARD_QUERY = "select service_type,service_request_status,to_char(to_timestamp(cast(createdtime/1000 as bigint))::date ,'DD/MM/YYYY')as createdtime,lastmodifiedtime,locality,service_type_name from eg_hc_service_request hc ";

	public static final String SELECT_SERVICE_DETAIL_FOR_CITIZEN = "SELECT service_request_uuid, owner_name, tenant_id, location, latitude, longitude, locality, street_name, landmark, contact_number, email_id, tree_count, service_request_document, service_request_status, service_request_id, service_type, description,current_assignee, createdby, to_char(to_timestamp(cast(createdtime/1000 as bigint))::date,'DD/MM/YYYY') as createdtimes,servicerequest_lang ,lastmodifiedby,to_char(to_timestamp(cast(lastmodifiedtime/1000 as bigint))::date,'DD/MM/YYYY') as lastmodifiedtime,servicerequestsubtype,sla,sla_modified_date,sla_days_elapsed,range_forest_officer_report_document, is_range_forest_officer_report,ispremises, istreelies, sketchplanoftree, service_type_name,checkpoints from eg_hc_service_request WHERE service_request_id =? and createdby=?";

	public static final String SELECT_SERVICE_DETAIL = "SELECT service_request_uuid, owner_name, tenant_id, location, latitude, longitude, locality, street_name, landmark, contact_number, email_id, tree_count, service_request_document, service_request_status, service_request_id, service_type, description,current_assignee, createdby, to_char(to_timestamp(cast(createdtime/1000 as bigint))::date,'DD/MM/YYYY') as createdtimes,servicerequest_lang ,lastmodifiedby,to_char(to_timestamp(cast(lastmodifiedtime/1000 as bigint))::date,'DD/MM/YYYY') as lastmodifiedtime,servicerequestsubtype,sla,sla_modified_date,sla_days_elapsed,range_forest_officer_report_document,is_range_forest_officer_report,ispremises, istreelies, sketchplanoftree, service_type_name, ispremises, istreelies, sketchplanoftree,checkpoints from eg_hc_service_request WHERE service_request_id =?";

	public static final String SELECT_SERVICE_MEDIA_DETAIL = "SELECT service_request_uuid,service_request_document from eg_hc_service_request WHERE service_request_id =?";
	public static final String GET_CREATED_TIME = "SELECT service_type,createdtime,service_request_id,current_assignee,to_char(to_timestamp(cast(createdtime/1000 as bigint))::date ,'DD-MM-YYYY')as serviceRequestDate \r\n"
			+ "from eg_hc_service_request WHERE \r\n" + " service_request_status != '" + HCConstants.REJECTED_STATUS
			+ "' AND\r\n" + " service_request_status != '" + HCConstants.COMPLETED_STATUS + "' AND \r\n"
			+ "current_assignee != ''";

	public static final String UPDATE_SERVICE_REQUEST_SLA = "UPDATE eg_hc_service_request SET sla_days_elapsed=CASE \r\n"
			+ "WHEN hc_calculate_sla(to_timestamp(cast(createdtime/1000 as bigint))::date,DATE(NOW())) = 0 THEN\r\n"
			+ "hc_calculate_sla(to_timestamp(cast(createdtime/1000 as bigint))::date,DATE(NOW()))\r\n"
			+ "ELSE hc_calculate_sla(to_timestamp(cast(createdtime/1000 as bigint))::date,DATE(NOW()))-1\r\n"
			+ "END,sla_modified_date=DATE(NOW()) where service_request_status NOT IN ('REJECTED','COMPLETED')";

	private final String paginationWrapper = "SELECT * FROM "
			+ "(SELECT *, DENSE_RANK() OVER (ORDER BY lastmodifiedtime DESC) offset_ FROM " + "({})"
			+ " result) result_offset " + "WHERE offset_ > ? AND offset_ <= ?";

	public String getHCSearchQuery(RequestData criteria, List<Object> preparedStmtList) {

		StringBuilder builder = new StringBuilder(QUERY);

		// owner name
		if (criteria.getOwnerName() != null) {
			addClauseIfRequired(preparedStmtList, builder);
			builder.append(" hc.owner_name like ? ");

			preparedStmtList.add("%" + criteria.getOwnerName().trim() + "%");
		}

		// address
		if (criteria.getAddress() != null) {
			addClauseIfRequired(preparedStmtList, builder);
			builder.append(" hc.location like ? ");

			preparedStmtList.add("%" + criteria.getAddress().trim() + "%");
		}

		// latitude
		if (criteria.getLatitude() != null) {
			addClauseIfRequired(preparedStmtList, builder);
			builder.append(" hc.latitude  =? ");

			preparedStmtList.add(criteria.getLatitude().trim());
		}

		// longitude
		if (criteria.getLongitude() != null) {
			addClauseIfRequired(preparedStmtList, builder);
			builder.append(" hc.longitude = ?  ");

			preparedStmtList.add(criteria.getLongitude().trim());
		}

		// locality
		if (criteria.getHouseNoAndStreetName() != null) {
			addClauseIfRequired(preparedStmtList, builder);
			String locality = criteria.getHouseNoAndStreetName();
			String[] localityArray = locality.split(",");
			//builder.append(" hc.locality ilike ? ");
			builder.append(" hc.locality IN (?) ");
			
			StringBuilder localityStr = new StringBuilder();

			for(int i=0; i > localityArray.length; i++) {
				localityStr.append("'" + localityArray[i].trim() + "'");	
				if(i > localityArray.length || i == (localityArray.length - 1)) {
					localityStr.append(",");
				}
			}
			preparedStmtList.add(localityStr);
		}

		// street name
		if (criteria.getStreetName() != null) {
			addClauseIfRequired(preparedStmtList, builder);
			builder.append(" hc.street_name ilike ?");
			preparedStmtList.add("%" + criteria.getStreetName().trim() + "%");
		}

		// landmark
		if (criteria.getLandmark() != null) {
			addClauseIfRequired(preparedStmtList, builder);
			builder.append(" hc.landmark ilike ?");
			preparedStmtList.add("%" + criteria.getLandmark().trim() + "%");
		}
		// contact_number
		if (criteria.getOwnerContactNumber() != null) {
			addClauseIfRequired(preparedStmtList, builder);
			builder.append(" hc.contact_number ilike ?");
			preparedStmtList.add("%" + criteria.getOwnerContactNumber().trim() + "%");
		}

		// email_id
		if (criteria.getEmail() != null) {

			addClauseIfRequired(preparedStmtList, builder);
			builder.append(" hc.email_id ilike ?");
			preparedStmtList.add("%" + criteria.getEmail().trim() + "%");
		}

		// tree_count
		if (criteria.getTreeCount() != null) {
			addClauseIfRequired(preparedStmtList, builder);
			builder.append(" hc.tree_count = ?");
			preparedStmtList.add(criteria.getTreeCount());
		}

		// service type
		if (criteria.getServiceType() != null) {
			addClauseIfRequired(preparedStmtList, builder);
			builder.append(" hc.service_type ilike ?");
			preparedStmtList.add("%" + criteria.getServiceType().trim().toUpperCase() + "%");
		}

		// service request id
		if (criteria.getService_request_id() != null) {

			addClauseIfRequired(preparedStmtList, builder);
			builder.append(" hc.service_request_id ilike ?");
			preparedStmtList.add("%" + criteria.getService_request_id().trim() + "%");
		}

		// service request status
		if (criteria.getServiceRequestStatus() != null) {

			addClauseIfRequired(preparedStmtList, builder);
			builder.append(" hc.service_request_status   = ?");
			preparedStmtList.add(criteria.getServiceRequestStatus().trim().toUpperCase());
		}

		// from date

		if (criteria.getFromDate() != null) {
			addClauseIfRequired(preparedStmtList, builder);
			builder.append(" hc.createdtime >= ? ");
			preparedStmtList.add(criteria.getFromDate());
		}

		// to date
		if (criteria.getToDate() != null) {
			addClauseIfRequired(preparedStmtList, builder);
			builder.append(" hc.createdtime <= ? ");
			preparedStmtList.add(criteria.getToDate());

		}
		// service request sub type
		if (criteria.getServiceRequestSubtype() != null) {
			addClauseIfRequired(preparedStmtList, builder);
			builder.append(" hc.servicerequestsubtype->>'subservicetype' = ?");

			preparedStmtList.add(criteria.getServiceRequestSubtype().trim());
		}

		if (criteria.getDataPayload() != null && criteria.getDataPayload().get("assignedTo") != null) {
			addClauseIfRequired(preparedStmtList, builder);
			builder.append(" hc.current_assignee= ?");

			preparedStmtList.add(criteria.getDataPayload().get("assignedTo").toString().trim());
		}

		// this is for citizen
		if (criteria.getRequestInfo().getUserInfo().getType().equals("CITIZEN")) {

			addClauseIfRequired(preparedStmtList, builder);
			builder.append(" hc.createdby  = ? ");
			preparedStmtList.add(criteria.getAuditDetails().getCreatedBy());

		}

		// ServiceTypeName
		if (!Strings.isNullOrEmpty(criteria.getServiceTypeName())) {
			addClauseIfRequired(preparedStmtList, builder);
			builder.append(" hc.service_type_name  = ? ");
			preparedStmtList.add(criteria.getServiceTypeName());
		}

		// builder.append(" ORDER BY service_request_id DESC");

		return addPaginationWrapper(builder.toString(), preparedStmtList, criteria);
	}

	public String getDashboardSearchQuery(RequestData criteria, List<Object> preparedStmtList) {

		StringBuilder builder = new StringBuilder(DASHBOARD_QUERY);

		// owner name
		if (criteria.getOwnerName() != null) {
			addClauseIfRequired(preparedStmtList, builder);
			builder.append(" hc.owner_name like ? ");

			preparedStmtList.add("%" + criteria.getOwnerName().trim() + "%");
		}

		// address
		if (criteria.getAddress() != null) {
			addClauseIfRequired(preparedStmtList, builder);
			builder.append(" hc.location like ? ");

			preparedStmtList.add("%" + criteria.getAddress().trim() + "%");
		}

		// latitude
		if (criteria.getLatitude() != null) {
			addClauseIfRequired(preparedStmtList, builder);
			builder.append(" hc.latitude  =? ");

			preparedStmtList.add(criteria.getLatitude().trim());
		}

		// longitude
		if (criteria.getLongitude() != null) {
			addClauseIfRequired(preparedStmtList, builder);
			builder.append(" hc.longitude = ?  ");

			preparedStmtList.add(criteria.getLongitude().trim());
		}

		// locality
		if (criteria.getHouseNoAndStreetName() != null) {
			addClauseIfRequired(preparedStmtList, builder);
			builder.append(" hc.locality ilike ? ");

			preparedStmtList.add("%" + criteria.getHouseNoAndStreetName().trim() + "%");
		}

		// street name
		if (criteria.getStreetName() != null) {
			addClauseIfRequired(preparedStmtList, builder);
			builder.append(" hc.street_name ilike ?");
			preparedStmtList.add("%" + criteria.getStreetName().trim() + "%");
		}

		// landmark
		if (criteria.getLandmark() != null) {
			addClauseIfRequired(preparedStmtList, builder);
			builder.append(" hc.landmark ilike ?");
			preparedStmtList.add("%" + criteria.getLandmark().trim() + "%");
		}
		// contact_number
		if (criteria.getOwnerContactNumber() != null) {
			addClauseIfRequired(preparedStmtList, builder);
			builder.append(" hc.contact_number ilike ?");
			preparedStmtList.add("%" + criteria.getOwnerContactNumber().trim() + "%");
		}

		// email_id
		if (criteria.getEmail() != null) {

			addClauseIfRequired(preparedStmtList, builder);
			builder.append(" hc.email_id ilike ?");
			preparedStmtList.add("%" + criteria.getEmail().trim() + "%");
		}

		// tree_count
		if (criteria.getTreeCount() != null) {
			addClauseIfRequired(preparedStmtList, builder);
			builder.append(" hc.tree_count = ?");
			preparedStmtList.add(criteria.getTreeCount());
		}

		// service type
		if (criteria.getServiceType() != null) {
			addClauseIfRequired(preparedStmtList, builder);
			builder.append(" hc.service_type ilike ?");
			preparedStmtList.add("%" + criteria.getServiceType().trim().toUpperCase() + "%");
		}

		// service request id
		if (criteria.getService_request_id() != null) {

			addClauseIfRequired(preparedStmtList, builder);
			builder.append(" hc.service_request_id ilike ?");
			preparedStmtList.add("%" + criteria.getService_request_id().trim() + "%");
		}

		// service request status
		if (criteria.getServiceRequestStatus() != null) {

			addClauseIfRequired(preparedStmtList, builder);
			builder.append(" hc.service_request_status   = ?");
			preparedStmtList.add(criteria.getServiceRequestStatus().trim().toUpperCase());
		}

		// from date

		if (criteria.getFromDate() != null) {
			addClauseIfRequired(preparedStmtList, builder);
			builder.append(" hc.createdtime >= ? ");
			preparedStmtList.add(criteria.getFromDate());
		}

		// to date
		if (criteria.getToDate() != null) {
			addClauseIfRequired(preparedStmtList, builder);
			builder.append(" hc.createdtime <= ? ");
			preparedStmtList.add(criteria.getToDate());

		}
		// service request sub type
		if (criteria.getServiceRequestSubtype() != null) {
			addClauseIfRequired(preparedStmtList, builder);
			builder.append(" hc.servicerequestsubtype->>'subservicetype' = ?");

			preparedStmtList.add(criteria.getServiceRequestSubtype().trim());
		}

		if (criteria.getDataPayload() != null && criteria.getDataPayload().get("assignedTo") != null) {
			addClauseIfRequired(preparedStmtList, builder);
			builder.append(" hc.current_assignee= ?");

			preparedStmtList.add(criteria.getDataPayload().get("assignedTo").toString().trim());
		}

		// this is for citizen
		if (criteria.getRequestInfo().getUserInfo().getType().equals("CITIZEN")) {

			addClauseIfRequired(preparedStmtList, builder);
			builder.append(" hc.createdby  = ? ");
			preparedStmtList.add(criteria.getAuditDetails().getCreatedBy());

		}

		// ServiceTypeName
		if (!Strings.isNullOrEmpty(criteria.getServiceTypeName())) {
			addClauseIfRequired(preparedStmtList, builder);
			builder.append(" hc.service_type_name  = ? ");
			preparedStmtList.add(criteria.getServiceTypeName());
		}

		// builder.append(" ORDER BY service_request_id DESC");

		return addPaginationWrapper(builder.toString(), preparedStmtList, criteria);
	}

	private String addPaginationWrapper(String query, List<Object> preparedStmtList, RequestData criteria) {

		int limit = hcConfiguration.getDefaultLimit();
		int offset = hcConfiguration.getDefaultOffset();
		String finalQuery = paginationWrapper.replace("{}", query);

		if (criteria.getLimit() != null && criteria.getLimit() <= hcConfiguration.getMaxSearchLimit())
			limit = criteria.getLimit();

		if (criteria.getLimit() != null && criteria.getLimit() > hcConfiguration.getMaxSearchLimit())
			limit = hcConfiguration.getMaxSearchLimit();

		if (criteria.getOffset() != null)
			offset = criteria.getOffset();

		preparedStmtList.add(offset);
		preparedStmtList.add(limit + offset);

		return finalQuery;
	}

	private static void addClauseIfRequired(List<Object> values, StringBuilder queryString) {
		if (values.isEmpty())
			queryString.append(" WHERE ");
		else {
			queryString.append(" AND");
		}
	}
}
