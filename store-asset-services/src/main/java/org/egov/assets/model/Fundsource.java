package org.egov.assets.model;

import java.util.Objects;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 *
 */

public class Fundsource {
	@JsonProperty("id")
	private String id = null;

	@JsonProperty("code")
	private String code = null;

	@JsonProperty("name")
	private String name = null;

	@JsonProperty("type")
	private String type = null;

	@JsonProperty("parent")
	private Long parent = null;

	@JsonProperty("llevel")
	private Double llevel = null;

	@JsonProperty("active")
	private Boolean active = null;

	@JsonProperty("isParent")
	private Boolean isParent = null;

	@JsonProperty("auditDetails")
	private Auditable auditDetails = null;

	public Fundsource id(String id) {
		this.id = id;
		return this;
	}

	/**
	 * Unique Identifier of the Fundsource
	 *
	 * @return id
	 **/
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Fundsource code(String code) {
		this.code = code;
		return this;
	}

	/**
	 * code of the Fundsource
	 *
	 * @return code
	 **/

	@NotNull

	@Size(min = 1, max = 25)
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Fundsource name(String name) {
		this.name = name;
		return this;
	}

	/**
	 * name of the Fundsource
	 *
	 * @return name
	 **/

	@NotNull

	@Size(min = 1, max = 25)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Fundsource type(String type) {
		this.type = type;
		return this;
	}

	/**
	 * type of the Fundsource
	 *
	 * @return type
	 **/
	@Size(min = 1, max = 25)
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Fundsource parent(Long parent) {
		this.parent = parent;
		return this;
	}

	/**
	 * parent of the Fundsource
	 *
	 * @return parent
	 **/
	public Long getParent() {
		return parent;
	}

	public void setParent(Long parent) {
		this.parent = parent;
	}

	public Fundsource llevel(Double llevel) {
		this.llevel = llevel;
		return this;
	}

	/**
	 * llevel of the Fundsource
	 *
	 * @return llevel
	 **/
	public Double getLlevel() {
		return llevel;
	}

	public void setLlevel(Double llevel) {
		this.llevel = llevel;
	}

	public Fundsource active(Boolean active) {
		this.active = active;
		return this;
	}

	/**
	 * Whether Fundsource is Active or not. If the value is TRUE, then Fundsource is
	 * active,If the value is FALSE then Fundsource is inactive,Default value is
	 * TRUE
	 *
	 * @return active
	 **/

	@NotNull

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public Fundsource isParent(Boolean isParent) {
		this.isParent = isParent;
		return this;
	}

	/**
	 * is parent of the Fundsource
	 *
	 * @return isParent
	 **/
	public Boolean getIsParent() {
		return isParent;
	}

	public void setIsParent(Boolean isParent) {
		this.isParent = isParent;
	}

	public Fundsource auditDetails(Auditable auditDetails) {
		this.auditDetails = auditDetails;
		return this;
	}

	/**
	 * Get auditDetails
	 *
	 * @return auditDetails
	 **/
	@Valid

	public Auditable getAuditDetails() {
		return auditDetails;
	}

	public void setAuditDetails(Auditable auditDetails) {
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
		Fundsource fundsource = (Fundsource) o;
		return Objects.equals(this.id, fundsource.id) && Objects.equals(this.code, fundsource.code)
				&& Objects.equals(this.name, fundsource.name) && Objects.equals(this.type, fundsource.type)
				&& Objects.equals(this.parent, fundsource.parent) && Objects.equals(this.llevel, fundsource.llevel)
				&& Objects.equals(this.active, fundsource.active) && Objects.equals(this.isParent, fundsource.isParent)
				&& Objects.equals(this.auditDetails, fundsource.auditDetails);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, code, name, type, parent, llevel, active, isParent, auditDetails);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class Fundsource {\n");

		sb.append("    id: ").append(toIndentedString(id)).append("\n");
		sb.append("    code: ").append(toIndentedString(code)).append("\n");
		sb.append("    name: ").append(toIndentedString(name)).append("\n");
		sb.append("    type: ").append(toIndentedString(type)).append("\n");
		sb.append("    parent: ").append(toIndentedString(parent)).append("\n");
		sb.append("    llevel: ").append(toIndentedString(llevel)).append("\n");
		sb.append("    active: ").append(toIndentedString(active)).append("\n");
		sb.append("    isParent: ").append(toIndentedString(isParent)).append("\n");
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
