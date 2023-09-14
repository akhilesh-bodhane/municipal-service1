
package org.egov.nulm.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.egov.common.contract.request.Role;
import org.egov.nulm.common.CommonConstants;
import org.egov.nulm.config.NULMConfiguration;
import org.egov.nulm.model.NulmSusvTransactionRequest;
import org.egov.nulm.model.Transaction;
import org.egov.nulm.producer.Producer;
import org.egov.nulm.repository.builder.NULMQueryBuilder;
import org.egov.nulm.repository.rowmapper.TransactionRowMapper;
import org.egov.tracer.model.CustomException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Repository
public class TransactionRepository {

	private JdbcTemplate jdbcTemplate;

	private Producer producer;

	private NULMConfiguration config;

	private TransactionRowMapper transactionRowMapper;
	
	@Autowired
	public NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	@Autowired
	public TransactionRepository(JdbcTemplate jdbcTemplate, Producer producer, NULMConfiguration config,
			TransactionRowMapper transactionRowMapper) {
		this.jdbcTemplate = jdbcTemplate;
		this.producer = producer;
		this.config = config;
		this.transactionRowMapper = transactionRowMapper;
	}

	public void createTransaction(Transaction trans) {
		NulmSusvTransactionRequest infoWrapper = NulmSusvTransactionRequest.builder().nulmTransactionRequest(trans).build();
		producer.push(config.getSusvTransactionSaveTopic(), infoWrapper);
	}
	
	public void updateTransaction(Transaction trans) {
		NulmSusvTransactionRequest infoWrapper = NulmSusvTransactionRequest.builder().nulmTransactionRequest(trans).build();
		producer.push(config.getSusvTransactionUpdateTopic(), infoWrapper);
	}
	public List<Transaction> getTransaction(Transaction trans, List<Role> role,Long userId) {
		List<Transaction> result = new ArrayList<>();
		Map<String, Object> paramValues = new HashMap<>();
		paramValues.put("tenantId", trans.getTenantId());
		paramValues.put("fromDate", trans.getFromDate());
		paramValues.put("toDate", trans.getToDate());
		paramValues.put("transactionType", trans.getTransactionType());
		paramValues.put("uuid", trans.getUuid());
		try {
			for (Role roleobj : role) {
				if ((roleobj.getCode()).equalsIgnoreCase(config.getRoleEmployee())) {					
					paramValues.put("createdBy", "");

					return result = namedParameterJdbcTemplate.query(NULMQueryBuilder.GET_SUSV_TRANSACTOIN_QUERY, paramValues,
							transactionRowMapper);

				}
				}
			paramValues.put("createdBy", userId.toString());
			return result = namedParameterJdbcTemplate.query(NULMQueryBuilder.GET_SUSV_TRANSACTOIN_QUERY, paramValues, transactionRowMapper);
		

		} catch (Exception e) {
			e.printStackTrace();
			throw new CustomException(CommonConstants.ROLE, e.getMessage());
		}

	}
	
}
