package org.egov.nulm.repository.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.egov.nulm.common.CommonConstants;
import org.egov.nulm.model.AuditDetails;
import org.egov.nulm.model.SupportingDocument;
import org.egov.nulm.model.Transaction;
import org.egov.tracer.model.CustomException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class TransactionRowMapper implements ResultSetExtractor<List<Transaction>> {

	@Autowired
	private ObjectMapper mapper;

	@Override
	public List<Transaction> extractData(ResultSet rs) throws SQLException, DataAccessException {
		Map<String, Transaction> transMap = new HashMap<>();
		List<Transaction> transList = new ArrayList<>();

		try {
			while (rs.next()) {
				String id = rs.getString("uuid");
				
				if (!transMap.containsKey(id)) {
					AuditDetails audit = AuditDetails.builder().createdBy(rs.getString("created_by"))
							.createdTime(rs.getLong("created_time")).lastModifiedBy(rs.getString("last_modified_by"))
							.lastModifiedTime(rs.getLong("last_modified_time")).build();
									
					Transaction susvapp = Transaction.builder().auditDetails(audit)
							.amount(rs.getString("amount"))
							.comments(rs.getString("comments"))
							.donationReceivedFrom(rs.getString("donation_received_from"))
							.donorDetails(rs.getString("donor_details"))
							.expenditureDetails(rs.getString("expenditure_details"))
							.emailId(rs.getString("email_id"))
							.expenditureType(rs.getString("expenditure_type"))
							.modeOfPayment(rs.getString("mode_of_payment"))
							.paymentDetails(rs.getString("payment_details"))
							.remark(rs.getString("remark"))
							.transactionType(rs.getString("transaction_type"))
							.uuid(rs.getString("uuid"))
							.tenantId(rs.getString("tenant_id"))
							.isActive(rs.getBoolean("is_active"))
							.tenantId(rs.getString("tenant_id"))
							.build();
					List<SupportingDocument> documentAttachment = null;
					if (rs.getString("document") != null) {
						documentAttachment = Arrays
								.asList(mapper.readValue(rs.getString("document"), SupportingDocument[].class));
					}
					if (documentAttachment != null)
						documentAttachment = documentAttachment.stream().filter(ele -> ele.getUuid() != null)
								.collect(Collectors.toList());
					susvapp.setSupportingDocument(documentAttachment);
					transMap.put(id, susvapp);
					transList.add(susvapp);
				}
			}

		} catch (Exception e) {
			throw new CustomException(CommonConstants.TRANSACTION_EXCEPTION_CODE, e.getMessage());
		}
		return transList;
	}

}
