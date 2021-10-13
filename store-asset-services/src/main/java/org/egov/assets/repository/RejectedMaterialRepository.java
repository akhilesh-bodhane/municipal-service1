package org.egov.assets.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.egov.assets.common.DomainService;
import org.egov.assets.model.MaterialIssueDetail;
import org.egov.assets.model.MaterialIssuedFromReceipt;
import org.egov.assets.model.PurchaseIndentDetail;
import org.egov.assets.repository.entity.IndentDetailEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Repository
public class RejectedMaterialRepository extends DomainService {

	@Autowired
	public NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	public void minusRejectedMaterial(List<MaterialIssueDetail> issueDetail, String tenantId) {

		for (MaterialIssueDetail detail : issueDetail) {
			Map<String, Object> paramValuesqueryMat = new HashMap<>();
			String queryMat = "update materialissuedetail set rejectedissuedquantity =:rejectedissuedquantity, quantityissued =:quantityissued, userquantityissued =:userquantityissued where id = :id and tenantid = :tenantId";
			paramValuesqueryMat.put("rejectedissuedquantity", detail.getRejectedIssuedQuantity());
			paramValuesqueryMat.put("quantityissued", detail.getQuantityIssued());
			paramValuesqueryMat.put("userquantityissued", detail.getUserQuantityIssued());
			paramValuesqueryMat.put("id", detail.getId());
			paramValuesqueryMat.put("tenantId", tenantId);
			namedParameterJdbcTemplate.update(queryMat, paramValuesqueryMat);

			for (MaterialIssuedFromReceipt fromReceipt : detail.getMaterialIssuedFromReceipts()) {
				paramValuesqueryMat.clear();
				queryMat = "update materialissuedfromreceipt set rejectedissuedquantity =:rejectedissuedquantity, quantity =:quantity where id = :id and tenantid = :tenantId";
				paramValuesqueryMat.put("rejectedissuedquantity", fromReceipt.getRejectedIssuedQuantity());
				paramValuesqueryMat.put("quantity", fromReceipt.getQuantity());
				paramValuesqueryMat.put("id", fromReceipt.getId());
				paramValuesqueryMat.put("tenantId", tenantId);
				namedParameterJdbcTemplate.update(queryMat, paramValuesqueryMat);
			}
		}
	}

	public void minusRejectedMaterialPurchaseOrder(List<PurchaseIndentDetail> purchaseIndentDetails, String tenantId) {
		for (PurchaseIndentDetail detail : purchaseIndentDetails) {
			Map<String, Object> paramValuesqueryMat = new HashMap<>();
			String queryMat = "update indentdetail set poorderedquantity = :poorderedquantity where id = :id and tenantid = :tenantId";
			paramValuesqueryMat.put("poorderedquantity", detail.getIndentDetail().getPoOrderedQuantity());
			paramValuesqueryMat.put("id", detail.getIndentDetail().getId());
			paramValuesqueryMat.put("tenantId", tenantId);
			namedParameterJdbcTemplate.update(queryMat, paramValuesqueryMat);
		}
	}
}