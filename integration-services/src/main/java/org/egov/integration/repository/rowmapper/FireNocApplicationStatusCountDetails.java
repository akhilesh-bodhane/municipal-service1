package org.egov.integration.repository.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.egov.integration.common.CommonConstants;
import org.egov.integration.model.FireApplicationDetails;
import org.egov.tracer.model.CustomException;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Component;

@Component
public class FireNocApplicationStatusCountDetails implements ResultSetExtractor<FireApplicationDetails> {

	@Override
	public FireApplicationDetails extractData(ResultSet rs) throws SQLException, DataAccessException {
		FireApplicationDetails fireApplicationDetails = new FireApplicationDetails();
		try {
			while (rs.next()) {
				fireApplicationDetails.setTotalApplicationsReceived(
						rs.getString("TotalApplications") != null ? rs.getString("TotalApplications") : "0");
				fireApplicationDetails.setTotalApplicationsUnderProcess(
						rs.getString("UnderProcess") != null ? rs.getString("UnderProcess") : "0");
				fireApplicationDetails.setTotalApplicationsDelivered(
						rs.getString("Delivered") != null ? rs.getString("Delivered") : "0");
				fireApplicationDetails.setTotalApplicationsRejected(
						rs.getString("Rejected") != null ? rs.getString("Rejected") : "0");
			}
		} catch (Exception e) {
			throw new CustomException(CommonConstants.FIR_NOC_EXCEPTION_CODE, e.getMessage());
		}
		return fireApplicationDetails;
	}
}
