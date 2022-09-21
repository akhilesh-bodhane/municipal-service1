package org.egov.ec.repository.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.egov.ec.web.models.Document;
import org.egov.ec.web.models.EcPayment;
import org.egov.ec.web.models.EcPaymentCount;
import org.egov.ec.web.models.ViolationCount;
import org.egov.tracer.model.CustomException;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Component;

@Component
public class ViolationDetailCountRowMapper implements ResultSetExtractor<List<ViolationCount>> {

	@Override
	public List<ViolationCount> extractData(ResultSet rs) throws SQLException, DataAccessException {

		Map<String, ViolationCount> ViolationCountMap = new LinkedHashMap<>();
		EcPaymentCount ecPayment=new EcPaymentCount();

		try {
			while (rs.next()) {

				String ViolationCountUuid = rs.getString("Violation_uuid");

					ViolationCount ViolationCount = org.egov.ec.web.models.ViolationCount.builder().violationUuid(ViolationCountUuid)
							.encroachmentType((rs.getString("encroachment_type") == null ? ""
									: rs.getString("encroachment_type")))
							.violationDate(
									(rs.getString("violation_date") == null ? "" : rs.getString("violation_date")))
							.sector((rs.getString("sector") == null ? "" : rs.getString("sector")))
							.siName((rs.getString("si_name") == null ? "" : rs.getString("si_name")))
							.status((rs.getString("challan_status") == null ? "" : rs.getString("challan_status")))
							.createdTime((rs.getLong("created_time")))
							.build();
					
					
					ecPayment.setPaymentStatus(rs.getString("payment_status"));
					ecPayment.setPaymentMode(rs.getString("payment_mode"));
					ViolationCount.setPaymentDetails(ecPayment);
					ViolationCountMap.put(ViolationCountUuid, ViolationCount);
			}

		} catch (Exception e) {
			throw new CustomException("GET_ViolationCount_EXCEPTION", e.getMessage());
		}
		return new ArrayList<>(ViolationCountMap.values());
	}

}