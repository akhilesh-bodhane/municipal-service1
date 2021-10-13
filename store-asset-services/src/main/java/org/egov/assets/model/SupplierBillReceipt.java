package org.egov.assets.model;

import java.util.Objects;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Asset information for the Contractor Bill
 */
public class SupplierBillReceipt {
	@JsonProperty("id")
	private String id = null;

	@JsonProperty("tenantId")
	private String tenantId = null;

	@JsonProperty("supplierBill")
	private String supplierBill = null;

	@JsonProperty("materialReceipt")
	private MaterialReceipt materialReceipt = null;

	@JsonProperty("auditDetails")
	private AuditDetails auditDetails = null;

	public SupplierBillReceipt id(String id) {
		this.id = id;
		return this;
	}

	/**
	 * Unique Identifier of the Supplier Bill
	 *
	 * @return id
	 **/
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public SupplierBillReceipt tenantId(String tenantId) {
		this.tenantId = tenantId;
		return this;
	}

	/**
	 * Tenant id of the Supplier Bill
	 *
	 * @return tenantId
	 **/
	@NotNull
	@Size(min = 2, max = 128)
	public String getTenantId() {
		return tenantId;
	}

	public void setTenantId(String tenantId) {
		this.tenantId = tenantId;
	}

	public SupplierBillReceipt supplierBill(String supplierBill) {
		this.supplierBill = supplierBill;
		return this;
	}

	/**
	 * supplier bill number id as reference
	 *
	 * @return supplierBill
	 **/

	@NotNull
	public String getSupplierBill() {
		return supplierBill;
	}

	public void setSupplierBill(String supplierBill) {
		this.supplierBill = supplierBill;
	}

	public SupplierBillReceipt materialReceipt(MaterialReceipt materialReceipt) {
		this.materialReceipt = materialReceipt;
		return this;
	}

	/**
	 * Material receipt used in supplier bill. There is no partial payment allowed
	 * in supplier bill for a selecte4d material receipt. On cancellation of
	 * supplier bill, samereceipt can be used to recreate new supplier bill.
	 *
	 * @return materialReceipt
	 **/
	@NotNull
	@Valid
	public MaterialReceipt getMaterialReceipt() {
		return materialReceipt;
	}

	public void setMaterialReceipt(MaterialReceipt materialReceipt) {
		this.materialReceipt = materialReceipt;
	}

	public SupplierBillReceipt auditDetails(AuditDetails auditDetails) {
		this.auditDetails = auditDetails;
		return this;
	}

	/**
	 * Get auditDetails
	 *
	 * @return auditDetails
	 **/
	@Valid
	public AuditDetails getAuditDetails() {
		return auditDetails;
	}

	public void setAuditDetails(AuditDetails auditDetails) {
		this.auditDetails = auditDetails;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		SupplierBillReceipt supplierBillReceipt = (SupplierBillReceipt) o;
		return Objects.equals(this.id, supplierBillReceipt.id)
				&& Objects.equals(this.tenantId, supplierBillReceipt.tenantId)
				&& Objects.equals(this.supplierBill, supplierBillReceipt.supplierBill)
				&& Objects.equals(this.materialReceipt, supplierBillReceipt.materialReceipt)
				&& Objects.equals(this.auditDetails, supplierBillReceipt.auditDetails);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, tenantId, supplierBill, materialReceipt, auditDetails);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class SupplierBillReceipt {\n");

		sb.append("    id: ").append(toIndentedString(id)).append("\n");
		sb.append("    tenantId: ").append(toIndentedString(tenantId)).append("\n");
		sb.append("    supplierBill: ").append(toIndentedString(supplierBill)).append("\n");
		sb.append("    materialReceipt: ").append(toIndentedString(materialReceipt)).append("\n");
		sb.append("    auditDetails: ").append(toIndentedString(auditDetails)).append("\n");
		sb.append("}");
		return sb.toString();
	}

	/**
	 * Convert the given object to string with each line indented by 4 spaces
	 * (except the first line).
	 */
	private String toIndentedString(Object o) {
		if (o == null) {
			return "null";
		}
		return o.toString().replace("\n", "\n    ");
	}
}
