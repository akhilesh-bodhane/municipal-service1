package org.egov.integration.repository.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.egov.integration.common.CommonConstants;
import org.egov.integration.model.FireService;
import org.egov.tracer.model.CustomException;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Component;

@Component
public class FireServiceDataRowMapper implements ResultSetExtractor<List<FireService>> {

	@Override
	public List<FireService> extractData(ResultSet rs) throws SQLException, DataAccessException {
		Map<String, FireService> map = new HashMap<>();
		try {

			while (rs.next()) {
				FireService fireService = new FireService();

				fireService.setUuid(rs.getString("uuid"));
				fireService.setService_id(
						rs.getString("service_id") != null ? Integer.parseInt(rs.getString("service_id")) : 0);
				fireService.setService_name(rs.getString("service_name"));
				fireService.setDelivered(
						rs.getString("delivered") != null ? Integer.parseInt(rs.getString("delivered")) : 0);
				fireService.setPending(rs.getString("pending") != null ? Integer.parseInt(rs.getString("pending")) : 0);
				fireService
						.setRejected(rs.getString("rejected") != null ? Integer.parseInt(rs.getString("rejected")) : 0);
				fireService.setSubmitted(
						rs.getString("submitted") != null ? Integer.parseInt(rs.getString("submitted")) : 0);

				fireService.setCreatedBy(rs.getString("createdby"));
				fireService.setCreatedTime(Long.parseLong(rs.getString("createdtime")));
				fireService.setLastModifiedBy(rs.getString("lastmodifiedby"));
				fireService.setLastModifiedTime(Long.parseLong(rs.getString("lastmodifiedtime")));
				map.put(fireService.getUuid(), fireService);
			}

			return map.entrySet().stream().map(Map.Entry::getValue).collect(Collectors.toList());

		} catch (Exception e) {
			throw new CustomException(CommonConstants.FIR_NOC_EXCEPTION_CODE, e.getMessage());
		}
	}
}
