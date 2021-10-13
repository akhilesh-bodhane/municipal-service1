package org.egov.assets.model;

import java.util.Objects;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * This object holds the material type store mapping details information.
 */
public class MaterialTypeStoreMapping {
	@JsonProperty("id")
	private String id = null;

	@JsonProperty("materialType")
	private MaterialType materialType = null;

	@JsonProperty("store")
	private Store store = null;

	@JsonProperty("chartofAccount")
	private ChartOfAccount chartofAccount = null;

	@JsonProperty("active")
	private Boolean active = null;

	@JsonProperty("delete")
	private Boolean delete = null;

	@JsonProperty("tenantId")
	private String tenantId = null;

	@JsonProperty("auditDetails")
	private AuditDetails auditDetails = null;

	public MaterialTypeStoreMapping id(String id) {
		this.id = id;
		return this;
	}

	/**
	 * Unique Identifier of the Material Type Store Mapping
	 *
	 * @return id
	 **/
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public MaterialTypeStoreMapping materialType(MaterialType materialType) {
		this.materialType = materialType;
		return this;
	}

	/**
	 * Get materialType
	 *
	 * @return materialType
	 **/

	@NotNull

	public MaterialType getMaterialType() {
		return materialType;
	}

	public void setMaterialType(MaterialType materialType) {
		this.materialType = materialType;
	}

	public MaterialTypeStoreMapping store(Store store) {
		this.store = store;
		return this;
	}

	/**
	 * Get store
	 *
	 * @return store
	 **/

	@NotNull

	public Store getStore() {
		return store;
	}

	public void setStore(Store store) {
		this.store = store;
	}

	public MaterialTypeStoreMapping chartofAccount(ChartOfAccount chartofAccount) {
		this.chartofAccount = chartofAccount;
		return this;
	}

	/**
	 * Get chartofAccount
	 *
	 * @return chartofAccount
	 **/
	public ChartOfAccount getChartofAccount() {
		return chartofAccount;
	}

	public void setChartofAccount(ChartOfAccount chartofAccount) {
		this.chartofAccount = chartofAccount;
	}

	public MaterialTypeStoreMapping active(Boolean active) {
		this.active = active;
		return this;
	}

	/**
	 * active or inactive flag of mapping
	 *
	 * @return active
	 **/
	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public MaterialTypeStoreMapping delete(Boolean delete) {
		this.delete = delete;
		return this;
	}

	/**
	 * delete flag of mapping used during deleting the mapping.
	 *
	 * @return delete
	 **/
	public Boolean getDelete() {
		return delete;
	}

	public void setDelete(Boolean delete) {
		this.delete = delete;
	}

	public MaterialTypeStoreMapping tenantId(String tenantId) {
		this.tenantId = tenantId;
		return this;
	}

	/**
	 * Tenant id of the Material Type Store
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

	public MaterialTypeStoreMapping auditDetails(AuditDetails auditDetails) {
		this.auditDetails = auditDetails;
		return this;
	}

	/**
	 * Get auditDetails
	 *
	 * @return auditDetails
	 **/
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
		MaterialTypeStoreMapping materialTypeStoreMapping = (MaterialTypeStoreMapping) o;
		return Objects.equals(this.id, materialTypeStoreMapping.id)
				&& Objects.equals(this.materialType, materialTypeStoreMapping.materialType)
				&& Objects.equals(this.store, materialTypeStoreMapping.store)
				&& Objects.equals(this.chartofAccount, materialTypeStoreMapping.chartofAccount)
				&& Objects.equals(this.active, materialTypeStoreMapping.active)
				&& Objects.equals(this.delete, materialTypeStoreMapping.delete)
				&& Objects.equals(this.tenantId, materialTypeStoreMapping.tenantId)
				&& Objects.equals(this.auditDetails, materialTypeStoreMapping.auditDetails);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, materialType, store, chartofAccount, active, delete, tenantId, auditDetails);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class MaterialTypeStoreMapping {\n");

		sb.append("    id: ").append(toIndentedString(id)).append("\n");
		sb.append("    materialType: ").append(toIndentedString(materialType)).append("\n");
		sb.append("    store: ").append(toIndentedString(store)).append("\n");
		sb.append("    chartofAccount: ").append(toIndentedString(chartofAccount)).append("\n");
		sb.append("    active: ").append(toIndentedString(active)).append("\n");
		sb.append("    delete: ").append(toIndentedString(delete)).append("\n");
		sb.append("    tenantId: ").append(toIndentedString(tenantId)).append("\n");
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
