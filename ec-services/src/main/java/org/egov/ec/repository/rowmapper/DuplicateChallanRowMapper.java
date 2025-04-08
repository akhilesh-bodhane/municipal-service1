package org.egov.ec.repository.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.egov.ec.web.models.DuplicateChallanDetails;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

@Component
public class DuplicateChallanRowMapper implements RowMapper<DuplicateChallanDetails> {

    @Override
    public DuplicateChallanDetails mapRow(ResultSet rs, int rowNum) throws SQLException {
        DuplicateChallanDetails details = new DuplicateChallanDetails();

        details.setChallanId(rs.getString("challan_id"));
        details.setChallanStatus(rs.getString("challan_status"));
        details.setChallanAmount(rs.getDouble("challan_amount"));
        details.setChallanDate(rs.getString("challan_date"));
        details.setEncroachmentType(rs.getString("encroachment_type"));
        details.setMobileNumber(rs.getString("contact_number"));
        details.setViolatorName(rs.getString("violator_name"));
        details.setNumberOfViolation(rs.getString("number_of_violation"));
        details.setPaymentMode(rs.getString("payment_mode"));
        details.setPaymentStatus(rs.getString("payment_status"));
        details.setItemNames(rs.getString("item_names"));

        return details;
    }
}
