package org.egov.ec.repository.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.egov.ec.web.models.EcPayment;
import org.egov.ec.web.models.Violation;
import org.egov.ec.web.models.ViolationItem;
import org.egov.tracer.model.CustomException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class ViolationDetailRowMapperV2 implements ResultSetExtractor<List<Violation>> {

	@Autowired
	private ObjectMapper objectMapper;

	@Override
	public List<Violation> extractData(ResultSet rs) throws SQLException, DataAccessException {
		objectMapper.enable(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY);

		Map<String, Violation> violationMap = new LinkedHashMap<>();

		try {
			while (rs.next()) {

				String violationUuid = rs.getString("violation_uuid");
				if (!violationMap.containsKey(violationUuid)) {
					Violation violation = Violation.builder().violationUuid(violationUuid)
							.status((rs.getString("challan_status") == null ? "" : rs.getString("challan_status")))
							.challanUuid(rs.getString("challan_uuid") == null ? "" : rs.getString("challan_uuid"))
							.tenantId((rs.getString("tenant_id") == null ? "" : rs.getString("tenant_id")))
							.challanId((rs.getString("challan_id") == null ? "" : rs.getString("challan_id")))
							.encroachmentType((rs.getString("encroachment_type") == null ? ""
									: rs.getString("encroachment_type")))
							.contactNumber(
									(rs.getString("contact_number") == null ? "" : rs.getString("contact_number")))
							.violationDate(
									(rs.getString("violation_date") == null ? "" : rs.getString("violation_date")))
							.challanAmount((rs.getString("fineamount"))).penaltyAmount((rs.getString("penaltyamount")))
							.violatorName((rs.getString("violator_name") == null ? "" : rs.getString("violator_name")))
							.sector((rs.getString("sector") == null ? "" : rs.getString("sector")))
							.siName((rs.getString("si_name") == null ? "" : rs.getString("si_name")))
							.createdTime(rs.getString("created_time") == null ? null
									: (Long.parseLong(rs.getString("created_time"))))
							.lastModifiedTime(rs.getString("last_modified_time") == null ? null
									: (Long.parseLong(rs.getString("last_modified_time"))))
							.build();

					String violationItem = rs.getString("violation_item");
					List<ViolationItem> listtoaddItem = new ArrayList<ViolationItem>();
					if (violationItem != null && !"[{}]".equalsIgnoreCase(violationItem)) {
						listtoaddItem = objectMapper.readValue(violationItem,
								new TypeReference<ArrayList<ViolationItem>>() {
								});
					}
					violation.setViolationItem(listtoaddItem);
					violation.setPaymentDetails(
							EcPayment.builder().paymentStatus(rs.getString("payment_status")).build());
					violationMap.put(violationUuid, violation);

				}
			}

		} catch (Exception e) {
			throw new CustomException("GET_VIOLATION_EXCEPTION", e.getMessage());
		}
		return new ArrayList<>(violationMap.values());
	}

}