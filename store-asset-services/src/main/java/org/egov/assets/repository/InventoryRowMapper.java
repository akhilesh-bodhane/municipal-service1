package org.egov.assets.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

import org.egov.assets.model.Department;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.jdbc.core.RowMapper;

public class InventoryRowMapper implements RowMapper<JSONArray> {
	JSONArray mainOutput = new JSONArray();

	Map<String, Department> departmentMap = null;

	public InventoryRowMapper(Map<String, Department> departmentMap) {
		this.departmentMap = departmentMap;
	}

	@Override
	public JSONArray mapRow(ResultSet resultSet, int i) throws SQLException {
		JSONObject sunMain = new JSONObject();
		sunMain.put("srNo", i + 1);
		sunMain.put("openingQty", resultSet.getString("openqty"));
		sunMain.put("openingUom", resultSet.getString("openuom"));
		sunMain.put("openingRate", resultSet.getString("openrate"));
		sunMain.put("receiptDate", resultSet.getString("recptdate"));
		sunMain.put("receiptNo", resultSet.getString("recptreceiptno"));

		sunMain.put("receiptDepartment",
				departmentMap.get(resultSet.getString("recptdepartment")) != null
						? departmentMap.get(resultSet.getString("recptdepartment")).getName()
						: resultSet.getString("recptdepartment"));

		sunMain.put("receiptPurchaseQty", resultSet.getString("recptqtypurchased"));
		sunMain.put("receiptPurchaseUom", resultSet.getString("recptuom"));
		sunMain.put("receiptPurchaseUnitRate", resultSet.getString("recptunitrate"));
		sunMain.put("receiptTotalValue", resultSet.getString("recpttotalvalue"));
		sunMain.put("issuedDate", resultSet.getString("issuedate"));
		sunMain.put("issuedNo", resultSet.getString("issuenum"));
		
		sunMain.put("issuedToDepartment",
				departmentMap.get(resultSet.getString("issuedepart")) != null
						? departmentMap.get(resultSet.getString("issuedepart")).getName()
						: resultSet.getString("issuedepart"));
		sunMain.put("issuedQty", resultSet.getString("issueqty"));
		sunMain.put("issuedUom", resultSet.getString("issueuom"));
		sunMain.put("issuedUnitRate", resultSet.getString("issuerate"));
		sunMain.put("issuedTotalValue", resultSet.getString("issuetotalvalue"));
		sunMain.put("balanceQty", resultSet.getString("balanceqty"));
		sunMain.put("balanceUom", resultSet.getString("balanceuom"));
		sunMain.put("balanceTotalValue", resultSet.getString("balancetotalvalue"));
		mainOutput.add(sunMain);
		return mainOutput;
	}
}
