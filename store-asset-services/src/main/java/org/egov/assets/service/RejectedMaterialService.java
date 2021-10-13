package org.egov.assets.service;

import java.util.List;

import org.egov.assets.model.MaterialIssueDetail;
import org.egov.assets.model.PurchaseIndentDetail;
import org.egov.assets.repository.RejectedMaterialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RejectedMaterialService {

	@Autowired
	private RejectedMaterialRepository repository;

	public void minusRejectedMaterial(List<MaterialIssueDetail> issueDetail, String tenantId) {
		repository.minusRejectedMaterial(issueDetail, tenantId);
	}

	public void minusRejectedMaterialPurchaseOrder(List<PurchaseIndentDetail> purchaseIndentDetails, String tenantId) {
		repository.minusRejectedMaterialPurchaseOrder(purchaseIndentDetails, tenantId);
	}
}