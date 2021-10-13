package org.egov.assets.repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.egov.assets.model.AuditDetails;
import org.egov.assets.model.Indent;
import org.egov.assets.model.Store;
import org.egov.assets.model.Indent.IndentPurposeEnum;
import org.egov.assets.model.Indent.IndentStatusEnum;
import org.egov.assets.model.Indent.IndentTypeEnum;
import org.egov.assets.model.Indent.InventoryTypeEnum;
import org.springframework.jdbc.core.RowMapper;

public class IndentRowMapper implements RowMapper<Indent> {

	@Override
	public Indent mapRow(ResultSet rs, int rowNum) throws SQLException {

		return new Indent().id(rs.getString("id")).indentNumber(rs.getString("indentNumber"))
				.indentDate(rs.getLong("indentDate")).designation(rs.getString("designation"))
				.expectedDeliveryDate(rs.getLong("expectedDeliveryDate")).fileStoreId(rs.getString("fileStoreId"))
				.indentStore(new Store().name(rs.getString("indentStore.name")).code(rs.getString("indentStore.code")))
				.materialHandOverTo(rs.getString("materialHandOverTo")).narration(rs.getString("narration"))
				.tenantId(rs.getString("tenantId")).indentType(IndentTypeEnum.fromValue(rs.getString("indentType")))
				.inventoryType(InventoryTypeEnum.fromValue(rs.getString("inventoryType")))
				.indentPurpose(IndentPurposeEnum.fromValue(rs.getString("indentPurpose")))
				.indentStatus(IndentStatusEnum.fromValue(rs.getString("indentStatus")))
				.indentCreatedBy(rs.getString("indentCreatedBy"))
				.issueStore(new Store().name(rs.getString("issueStore.name")).code(rs.getString("issueStore.code")))
				.totalIndentValue(rs.getBigDecimal("totalIndentValue"))
				.auditDetails(new AuditDetails().createdBy(rs.getString("createdBy"))
						.createdTime(rs.getLong("createdTime")).lastModifiedBy(rs.getString("lastModifiedBy"))
						.lastModifiedTime(rs.getLong("lastModifiedTime")));

	}

}
