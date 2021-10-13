package org.egov.assets.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * This object holds the material type information.
 */

public class MaterialType {
	@JsonProperty("id")
	private String id = null;

	@JsonProperty("tenantId")
	private String tenantId = null;

	@JsonProperty("name")
	private String name = null;

	@JsonProperty("code")
	private String code = null;

	@JsonProperty("description")
	private String description = null;

	@JsonProperty("storeMapping")
	private List<StoreMapping> storeMapping = null;

	@JsonProperty("parent")
	private String parent = null;

	@JsonProperty("isParent")
	private Boolean isParent = null;

	@JsonProperty("active")
	private Boolean active = null;

	@JsonProperty("auditDetails")
	private AuditDetails auditDetails = null;

	public MaterialType id(String id) {
		this.id = id;
		return this;
	}

	/**
	 * Unique Identifier of the Material Type
	 *
	 * @return id
	 **/

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public MaterialType tenantId(String tenantId) {
		this.tenantId = tenantId;
		return this;
	}

	/**
	 * Tenant id of the Material Type
	 *
	 * @return tenantId
	 **/
	@Size(min = 2, max = 128)
	public String getTenantId() {
		return tenantId;
	}

	public void setTenantId(String tenantId) {
		this.tenantId = tenantId;
	}

	public MaterialType name(String name) {
		this.name = name;
		return this;
	}

	/**
	 * name of the MaterialType
	 *
	 * @return name
	 **/
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public MaterialType code(String code) {
		this.code = code;
		return this;
	}

	/**
	 * code of the MaterialType
	 *
	 * @return code
	 **/
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public MaterialType description(String description) {
		this.description = description;
		return this;
	}

	/**
	 * description of the Material type
	 *
	 * @return description
	 **/
	@Size(max = 512)
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public MaterialType storeMapping(List<StoreMapping> storeMapping) {
		this.storeMapping = storeMapping;
		return this;
	}

	public MaterialType addStoreMappingItem(StoreMapping storeMappingItem) {
		if (this.storeMapping == null) {
			this.storeMapping = new ArrayList<StoreMapping>();
		}
		this.storeMapping.add(storeMappingItem);
		return this;
	}

	/**
	 * Get storeMapping
	 *
	 * @return storeMapping
	 **/
	public List<StoreMapping> getStoreMapping() {
		return storeMapping;
	}

	public void setStoreMapping(List<StoreMapping> storeMapping) {
		this.storeMapping = storeMapping;
	}

	public MaterialType parent(String parent) {
		this.parent = parent;
		return this;
	}

	/**
	 * parent of the MaterialType
	 *
	 * @return parent
	 **/
	public String getParent() {
		return parent;
	}

	public void setParent(String parent) {
		this.parent = parent;
	}

	public MaterialType isParent(Boolean isParent) {
		this.isParent = isParent;
		return this;
	}

	/**
	 * whether parent or not of material type
	 *
	 * @return isParent
	 **/
	public Boolean getIsParent() {
		return isParent;
	}

	public void setIsParent(Boolean isParent) {
		this.isParent = isParent;
	}

	public MaterialType active(Boolean active) {
		this.active = active;
		return this;
	}

	/**
	 * whether material type is active or not.
	 *
	 * @return active
	 **/
	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public MaterialType auditDetails(AuditDetails auditDetails) {
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
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		MaterialType materialType = (MaterialType) o;
		return Objects.equals(this.id, materialType.id) && Objects.equals(this.tenantId, materialType.tenantId)
				&& Objects.equals(this.name, materialType.name) && Objects.equals(this.code, materialType.code)
				&& Objects.equals(this.description, materialType.description)
				&& Objects.equals(this.storeMapping, materialType.storeMapping)
				&& Objects.equals(this.parent, materialType.parent)
				&& Objects.equals(this.isParent, materialType.isParent)
				&& Objects.equals(this.active, materialType.active)
				&& Objects.equals(this.auditDetails, materialType.auditDetails);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, tenantId, name, code, description, storeMapping, parent, isParent, active,
				auditDetails);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class MaterialType {\n");

		sb.append("    id: ").append(toIndentedString(id)).append("\n");
		sb.append("    tenantId: ").append(toIndentedString(tenantId)).append("\n");
		sb.append("    name: ").append(toIndentedString(name)).append("\n");
		sb.append("    code: ").append(toIndentedString(code)).append("\n");
		sb.append("    description: ").append(toIndentedString(description)).append("\n");
		sb.append("    storeMapping: ").append(toIndentedString(storeMapping)).append("\n");
		sb.append("    parent: ").append(toIndentedString(parent)).append("\n");
		sb.append("    isParent: ").append(toIndentedString(isParent)).append("\n");
		sb.append("    active: ").append(toIndentedString(active)).append("\n");
		sb.append("    auditDetails: ").append(toIndentedString(auditDetails)).append("\n");
		sb.append("}");
		return sb.toString();
	}

	/**
	 * Convert the given object to string with each line indented by 4 spaces
	 * (except the first line).
	 */
	private String toIndentedString(java.lang.Object o) {
		if (o == null) {
			return "null";
		}
		return o.toString().replace("\n", "\n    ");
	}
}
