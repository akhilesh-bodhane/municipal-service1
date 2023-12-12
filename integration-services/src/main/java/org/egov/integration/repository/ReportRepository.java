package org.egov.integration.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.egov.integration.model.ServiceReqSearchCriteria;
import org.egov.integration.model.UserCharges;
import org.egov.integration.repository.rowmapper.UserChargesDataRowMapper;
import org.egov.tracer.model.CustomException;
import org.postgresql.util.PSQLException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessResourceFailureException;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import lombok.extern.slf4j.Slf4j;

@Repository
@Slf4j
public class ReportRepository {

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	@Autowired
	private UserChargesDataRowMapper userChargesDataRowMapper;

	public static final String USER_CHARGES_SEARCH = "select row_number() over(order by category,paymentstatus,paymentmode) sequencenum, * from ( select violation.encroachment_type as category,case when payment.paymentstatus is null then 'PENDING' else payment.paymentstatus end as paymentstatus, case when payment.paymentmode is null then 'OTHERS' else payment.paymentmode end as paymentmode, count(1)  allrecords,SUM(payment.totalamountpaid)  todayscollections, true ischallan from public.egec_violation_master violation JOIN public.egec_challan_master challan on violation.violation_uuid=challan.violation_uuid JOIN public.egcl_payment payment on challan.challan_id = payment.instrumentnumber where1 group by violation.encroachment_type,payment.paymentstatus,payment.paymentmode  union select 'Adertisement NOC' as category, case when t.txn_status is null then 'PENDING' else t.txn_status end as paymentstatus,case when t.gateway_payment_mode is null then 'OTHERS' else t.gateway_payment_mode end as paymentmode, count(1)  allrecords, SUM(case when to_date(TO_CHAR(to_timestamp(n.created_time / 1000), 'DD/MM/YYYY'),'DD/MM/YYYY') = NOW()::date then 1 else 0 end)  todayscollections, false ischallan from egpm_noc_application n left join eg_pg_transactions t on n.noc_number = t.consumer_code where2 group by n.application_status,t.txn_status,t.gateway_payment_mode) as usercharges";

	public List<UserCharges> fetchUserChangesDetails(ServiceReqSearchCriteria serviceReqSearchCriteria) {
		Map<String, Object> preparedStatementValues = new HashMap<>();
		String query = getGrievanceDetailsQuery(serviceReqSearchCriteria);
		List<UserCharges> userCharges = null;
		try {
			userCharges = namedParameterJdbcTemplate.query(query, preparedStatementValues, userChargesDataRowMapper);
		} catch (DataAccessResourceFailureException ex) {
			log.info("Query Execution Failed Due To Timeout: ", ex);
			PSQLException cause = (PSQLException) ex.getCause();
			if (cause != null && cause.getSQLState().equals("57014")) {
				throw new CustomException("QUERY_EXECUTION_TIMEOUT", "Query failed, as it took more than expected");
			} else {
				throw ex;
			}
		} catch (Exception e) {
			log.info("Query Execution Failed: ", e);
			throw e;
		}
		return userCharges;

	}

	public String getGrievanceDetailsQuery(ServiceReqSearchCriteria serviceReqSearchCriteria) {
		StringBuilder whereStr1 = new StringBuilder();

		if (serviceReqSearchCriteria.getTenantId() != null && !serviceReqSearchCriteria.getTenantId().isEmpty()) {
			whereStr1.append(" violation.tenant_id=").append("'" + serviceReqSearchCriteria.getTenantId() + "'");
		}
		if (serviceReqSearchCriteria.getStartDate() != null && serviceReqSearchCriteria.getStartDate() != 0) {
			whereStr1.append(" and to_timestamp(cast(violation.created_time/1000 as bigint))::date >=")
					.append("to_timestamp(cast(" + serviceReqSearchCriteria.getStartDate() + "/1000 as bigint))::date");
		}
		if (serviceReqSearchCriteria.getEndDate() != null && serviceReqSearchCriteria.getEndDate() != 0) {
			whereStr1.append(" and to_timestamp(cast(violation.created_time/1000 as bigint))::date <=")
					.append("to_timestamp(cast(" + serviceReqSearchCriteria.getEndDate() + "/1000 as bigint))::date");
		}

		StringBuilder whereStr2 = new StringBuilder();

		if (serviceReqSearchCriteria.getTenantId() != null && !serviceReqSearchCriteria.getTenantId().isEmpty()) {
			whereStr2.append(" n.tenant_id=").append("'" + serviceReqSearchCriteria.getTenantId() + "'");
		}
		if (serviceReqSearchCriteria.getStartDate() != null && serviceReqSearchCriteria.getStartDate() != 0) {
			whereStr2.append(" and to_timestamp(cast(n.created_time/1000 as bigint))::date >=")
					.append("to_timestamp(cast(" + serviceReqSearchCriteria.getStartDate() + "/1000 as bigint))::date");
		}
		if (serviceReqSearchCriteria.getEndDate() != null && serviceReqSearchCriteria.getEndDate() != 0) {
			whereStr2.append(" and to_timestamp(cast(n.created_time/1000 as bigint))::date <=")
					.append("to_timestamp(cast(" + serviceReqSearchCriteria.getEndDate() + "/1000 as bigint))::date");
		}

		String query = USER_CHARGES_SEARCH;
		query = query.replace("where1", "where " + whereStr1.toString());
		query = query.replace("where2", "where " + whereStr2.toString());

		log.info("User Charges Report query: " + query);
		return query.toString();
	}

}
