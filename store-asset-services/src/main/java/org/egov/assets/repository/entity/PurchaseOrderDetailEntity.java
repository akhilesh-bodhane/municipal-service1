package org.egov.assets.repository.entity;

import java.math.BigDecimal;

import org.egov.assets.model.Material;
import org.egov.assets.model.PriceList;
import org.egov.assets.model.PurchaseOrderDetail;
import org.egov.assets.model.Uom;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PurchaseOrderDetailEntity {
	public static final String TABLE_NAME = "PurchaseOrderDetail";
	private String id;
	private String tenantId;
	private String material;
	private String purchaseOrder;
	private BigDecimal orderNumber;
	private String uom;
	private String priceList;
	private String purchaseOrderPurpose;
	private String workDetailRemarks;
	private BigDecimal orderQuantity;
	private BigDecimal userQuantity;
	private BigDecimal usedQuantity;
	private BigDecimal receivedQuantity;
	private BigDecimal unitPrice;
	private String description;
	private String indentNumber;

	public PurchaseOrderDetail toDomain() {
		PurchaseOrderDetail poDetails = new PurchaseOrderDetail();
		poDetails.setId(this.id);
		poDetails.setTenantId(this.tenantId);
		poDetails.setMaterial(new Material().code(material));
		poDetails.setUom(new Uom().code(uom));
		poDetails.setOrderNumber(this.orderNumber);
		poDetails.setPriceList(new PriceList().id(priceList));
		poDetails.setUserQuantity(userQuantity);
		poDetails.setOrderQuantity(orderQuantity);
		poDetails.setUsedQuantity(usedQuantity);
		poDetails.setReceivedQuantity(receivedQuantity);
		poDetails.setUnitPrice(unitPrice);
		poDetails.setDescription(description);
		poDetails.setPurchaseOrderNumber(purchaseOrder);
		poDetails.setPurchaseOrderPurpose(purchaseOrderPurpose);
		poDetails.setWorkDetailRemarks(workDetailRemarks);
		poDetails.setIndentNumber(indentNumber);
		return poDetails;
	}

	public PurchaseOrderDetailEntity toEntity(PurchaseOrderDetail po) {
		this.id = po.getId();
		this.tenantId = po.getTenantId();
		this.material = po.getMaterial() != null ? po.getMaterial().getId() : null;
		this.uom = po.getUom() != null ? po.getUom().getId() : null;
		this.orderNumber = po.getOrderNumber();
		this.priceList = po.getPriceList() != null ? po.getPriceList().getId() : null;
		this.orderQuantity = po.getOrderQuantity() != null ? po.getOrderQuantity() : null;
		this.userQuantity = po.getUserQuantity() != null ? po.getUserQuantity() : null;
		this.usedQuantity = po.getUsedQuantity() != null ? po.getUsedQuantity() : null;
		this.receivedQuantity = po.getReceivedQuantity() != null ? po.getReceivedQuantity() : null;
		this.unitPrice = po.getUnitPrice();
		this.description = po.getDescription();
		return this;
	}

}
