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

	public static final String USER_CHARGES_SEARCH = "select\r\n"
			+ "	row_number() over (\r\n"
			+ "order by\r\n"
			+ "	category,\r\n"
			+ "	paymentstatus,\r\n"
			+ "	paymentmode\r\n"
			+ "    ) as sequencenum,\r\n"
			+ "	*\r\n"
			+ "from\r\n"
			+ "	(\r\n"
			+ "	select\r\n"
			+ "		violation.encroachment_type as category,\r\n"
			+ "		case\r\n"
			+ "			when payment.paymentstatus is null then 'PENDING'\r\n"
			+ "			else payment.paymentstatus\r\n"
			+ "		end as paymentstatus,\r\n"
			+ "		case\r\n"
			+ "			when (payment.paymentmode is null\r\n"
			+ "			or payment.paymentmode in ('ONLINE', 'POSMOHBD', 'DD', 'CHEQUE', 'POSMOHSLH', 'CARD', 'POSMOHCATTLE')) \r\n"
			+ "        then 'Digital'\r\n"
			+ "			else 'Non Digital'\r\n"
			+ "		end as paymentmode,\r\n"
			+ "		COUNT(1) as allrecords,\r\n"
			+ "		SUM(payment.totalamountpaid) as todayscollections,\r\n"
			+ "		true as ischallan\r\n"
			+ "	from\r\n"
			+ "		public.egec_violation_master violation\r\n"
			+ "	join \r\n"
			+ "        public.egec_challan_master challan \r\n"
			+ "        on\r\n"
			+ "		violation.violation_uuid = challan.violation_uuid\r\n"
			+ "	join \r\n"
			+ "        public.egcl_payment payment \r\n"
			+ "        on\r\n"
			+ "		challan.challan_id = payment.instrumentnumber where1\r\n"
			+ "	group by\r\n"
			+ "		violation.encroachment_type,\r\n"
			+ "		payment.paymentstatus,\r\n"
			+ "		case\r\n"
			+ "			when (payment.paymentmode is null\r\n"
			+ "				or payment.paymentmode in ('ONLINE', 'POSMOHBD', 'DD', 'CHEQUE', 'POSMOHSLH', 'CARD', 'POSMOHCATTLE')) \r\n"
			+ "        then 'Digital'\r\n"
			+ "			else 'Non Digital'\r\n"
			+ "		end\r\n"
			+ "union\r\n"
			+ "	select\r\n"
			+ "		'Adertisement NOC' as category,\r\n"
			+ "		case\r\n"
			+ "			when t.txn_status is null then 'PENDING'\r\n"
			+ "			else t.txn_status\r\n"
			+ "		end as paymentstatus,\r\n"
			+ "		case\r\n"
			+ "			when (t.gateway_payment_mode is null\r\n"
			+ "				or t.gateway_payment_mode in ('NB', 'PPI', 'Paytm Postpaid', 'UPI')) \r\n"
			+ "        then 'Digital'\r\n"
			+ "			else 'Non Digital'\r\n"
			+ "		end as paymentmode,\r\n"
			+ "		COUNT(1) as allrecords,\r\n"
			+ "		SUM(\r\n"
			+ "            case \r\n"
			+ "                when TO_DATE(TO_CHAR(TO_TIMESTAMP(n.created_time / 1000), 'DD/MM/YYYY'), 'DD/MM/YYYY') = NOW()::DATE \r\n"
			+ "                then 1 \r\n"
			+ "                else 0 \r\n"
			+ "            end\r\n"
			+ "        ) as todayscollections,\r\n"
			+ "		false as ischallan\r\n"
			+ "	from\r\n"
			+ "		egpm_noc_application n\r\n"
			+ "	left join \r\n"
			+ "        eg_pg_transactions t \r\n"
			+ "        on\r\n"
			+ "		n.noc_number = t.consumer_code where2\r\n"
			+ "	group by\r\n"
			+ "		t.txn_status,\r\n"
			+ "		case\r\n"
			+ "			when (t.gateway_payment_mode is null\r\n"
			+ "				or t.gateway_payment_mode in ('NB', 'PPI', 'Paytm Postpaid', 'UPI')) \r\n"
			+ "        then 'Digital'\r\n"
			+ "			else 'Non Digital'\r\n"
			+ "		end\r\n"
			+ ") as usercharges";


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
