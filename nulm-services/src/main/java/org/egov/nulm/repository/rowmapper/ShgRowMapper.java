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
import org.egov.nulm.model.SmidShgGroup;
import org.egov.nulm.model.SmidShgMemberApplication;
import org.egov.tracer.model.CustomException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class ShgRowMapper implements ResultSetExtractor<List<SmidShgGroup>> {

	@Autowired
	private ObjectMapper mapper;

	@Override
	public List<SmidShgGroup> extractData(ResultSet rs) throws SQLException, DataAccessException {
		Map<String, SmidShgGroup> groupMap = new HashMap<>();
		List<SmidShgGroup> groupList = new ArrayList<>();

		try {
			while (rs.next()) {
				String id = rs.getString("shg_uuid");

				if (!groupMap.containsKey(id)) {
					AuditDetails audit = AuditDetails.builder().createdBy(rs.getString("created_by"))
							.createdTime(rs.getLong("created_time")).lastModifiedBy(rs.getString("last_modified_by"))
							.lastModifiedTime(rs.getLong("last_modified_time")).build();

					SmidShgGroup smidapp = SmidShgGroup.builder().auditDetails(audit).type(rs.getString("type"))
							.accountNo(rs.getString("account_no")).address(rs.getString("address"))
							.bankName(rs.getString("bank_name")).branchName(rs.getString("branch_name"))
							.contactNo(rs.getString("contact_no")).groupNominatedBy(rs.getString("groups_nominated_by"))
							.name(rs.getString("name")).remark(rs.getString("remark")).shgId(rs.getString("shg_id"))
							.shgUuid(rs.getString("shg_uuid")).tenantId(rs.getString("tenant_id"))
							.status(SmidShgGroup.StatusEnum.fromValue(rs.getString("status")))
							.dateOfFormation(rs.getString("date_of_formation"))
							.dateOfOpeningAccount(rs.getString("date_of_opening_account"))
							.formendThrough(rs.getString("formed_through")).isActive(rs.getBoolean("is_active"))
							.mainAcitivity(rs.getString("main_activity")).build();

					List<SmidShgMemberApplication> memberList = null;
					if (rs.getString("member") != null) {
						memberList = Arrays
								.asList(mapper.readValue(rs.getString("member"), SmidShgMemberApplication[].class));
					}
					if (memberList != null)
						memberList = memberList.stream().filter(ele -> ele.getApplicationId() != null)
								.collect(Collectors.toList());

					smidapp.setSmidShgMemberApplication(memberList);
					groupMap.put(id, smidapp);
					groupList.add(smidapp);
				}
			}

		} catch (Exception e) {
			throw new CustomException(CommonConstants.SMID_SHG_APPLICATION_EXCEPTION_CODE, e.getMessage());
		}
		return groupList;
	}

}
