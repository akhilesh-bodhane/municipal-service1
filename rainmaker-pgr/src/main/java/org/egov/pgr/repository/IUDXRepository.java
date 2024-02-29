package org.egov.pgr.repository;

import java.util.ArrayList;
import java.util.List;

import org.egov.common.contract.request.RequestInfo;
import org.egov.pgr.contract.ServiceReqSearchCriteria;
import org.egov.pgr.model.IUDXResponse;
import org.egov.pgr.repository.rowmapper.IUDXDataRowMapper;
import org.egov.pgr.repository.rowmapper.IUDXRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import lombok.extern.slf4j.Slf4j;

@Repository
@Slf4j
public class IUDXRepository {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Autowired
	private IUDXRowMapper iudxRowMapper;

	public List<IUDXResponse> search(RequestInfo requestInfo, ServiceReqSearchCriteria serviceReqSearchCriteria) {
		List<Object> preparedStmtList = new ArrayList<>();

		String query = "select des.department,des.locality,pgr.lastmodifiedtime,pgr.servicerequestid,pgr.source,pgr.category,des.description,concat(adds.housenoandstreetname,' ', adds.mohalla,' ', adds.landmark) as address,adds.latitude,adds.longitude,pgr.status from eg_pgr_service pgr join eg_pgr_discription_report des on pgr.servicerequestid = des.servicerequestid join eg_pgr_action act on pgr.servicerequestid = act.businesskey and pgr.status = act.status left join eg_pgr_address adds on pgr.addressid = adds.uuid ";

		StringBuilder queryBuilder = new StringBuilder(query);
		StringBuilder queryBuilderWhere = new StringBuilder();

		if (serviceReqSearchCriteria.getStartDate() != null) {
			queryBuilderWhere.append(" pgr.lastmodifiedtime >= ").append(serviceReqSearchCriteria.getStartDate());
		}
		if (queryBuilderWhere.length() > 0)
			queryBuilderWhere.append(" and ");

		if (serviceReqSearchCriteria.getEndDate() != null) {
			queryBuilderWhere.append(" pgr.lastmodifiedtime <= ").append(serviceReqSearchCriteria.getEndDate());
		}

		if (queryBuilderWhere.length() > 0)
			queryBuilder.append(" WHERE ").append(queryBuilderWhere);

		log.info("IUDXResponse Query: " + queryBuilder);

		List<IUDXResponse> iudxResponses = jdbcTemplate.query(queryBuilder.toString(), preparedStmtList.toArray(),
				iudxRowMapper);
		return iudxResponses;
	}

}
