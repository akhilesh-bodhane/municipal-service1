package org.egov.nulm.repository.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.egov.nulm.common.CommonConstants;
import org.egov.nulm.model.AuditDetails;
import org.egov.nulm.model.SmidShgGroup;
import org.egov.nulm.model.Organization;
import org.egov.tracer.model.CustomException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class OrganizationRowMapper implements ResultSetExtractor<List<Organization>> {

	@Autowired
	private ObjectMapper mapper;

	@Override
	public List<Organization> extractData(ResultSet rs) throws SQLException, DataAccessException {
		Map<String, Organization> orgMap = new HashMap<>();
		List<Organization> orgList = new ArrayList<>();

		try {
			while (rs.next()) {
				String id = rs.getString("organization_uuid");

				if (!orgMap.containsKey(id)) {
					AuditDetails audit = AuditDetails.builder().createdBy(rs.getString("created_by"))
							.createdTime(rs.getLong("created_time")).lastModifiedBy(rs.getString("last_modified_by"))
							.lastModifiedTime(rs.getLong("last_modified_time")).build();
					Organization smidapp = Organization.builder().auditDetails(audit)
							.address(rs.getString("address"))
							.emailId(rs.getString("email_id"))
							.mobileNo(rs.getString("mobile_no"))
							.organizationName(rs.getString("organization_name"))
							.organizationUuid(rs.getString("organization_uuid"))
							.registrationNo(rs.getString("registration_no"))
							.representativeName(rs.getString("representative_name"))
							.tenantId(rs.getString("tenant_id"))
							.userId(rs.getLong("user_id"))
							.isActive(rs.getBoolean("is_active")).build();
					
					orgMap.put(id, smidapp);
					orgList.add(smidapp);
				}
			}

		} catch (Exception e) {
			throw new CustomException(CommonConstants.ORGANIZATION_EXCEPTION_CODE, e.getMessage());
		}
		return orgList;
	}

}
