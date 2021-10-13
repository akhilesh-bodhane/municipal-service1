package org.egov.assets.model;

import java.util.Objects;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 *
 */

public class FinancialStatus {
	@JsonProperty("id")
	private String id = null;

	@JsonProperty("moduleType")
	private String moduleType = null;

	@JsonProperty("code")
	private String code = null;

	@JsonProperty("name")
	private String name = null;

	@JsonProperty("description")
	private String description = null;

	@JsonProperty("auditDetails")
	private Auditable auditDetails = null;

	public FinancialStatus id(String id) {
		this.id = id;
		return this;
	}

	/**
	 * Unique Identifier of the FinancialStatus
	 *
	 * @return id
	 **/

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public FinancialStatus moduleType(String moduleType) {
		this.moduleType = moduleType;
		return this;
	}

	/**
	 * module type of the FinancialStatus
	 *
	 * @return moduleType
	 **/
	@NotNull

	@Size(min = 3, max = 50)
	public String getModuleType() {
		return moduleType;
	}

	public void setModuleType(String moduleType) {
		this.moduleType = moduleType;
	}

	public FinancialStatus code(String code) {
		this.code = code;
		return this;
	}

	/**
	 * code of the FinancialStatus
	 *
	 * @return code
	 **/

	@NotNull

	@Size(min = 3, max = 20)
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public FinancialStatus name(String name) {
		this.name = name;
		return this;
	}

	/**
	 * name of the FinancialStatus
	 *
	 * @return name
	 **/

	@NotNull

	@Size(min = 3, max = 20)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public FinancialStatus description(String description) {
		this.description = description;
		return this;
	}

	/**
	 * description of the FinancialStatus
	 *
	 * @return description
	 **/

	@NotNull

	@Size(min = 3, max = 250)
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public FinancialStatus auditDetails(Auditable auditDetails) {
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
		FinancialStatus financialStatus = (FinancialStatus) o;
		return Objects.equals(this.id, financialStatus.id)
				&& Objects.equals(this.moduleType, financialStatus.moduleType)
				&& Objects.equals(this.code, financialStatus.code) && Objects.equals(this.name, financialStatus.name)
				&& Objects.equals(this.description, financialStatus.description)
				&& Objects.equals(this.auditDetails, financialStatus.auditDetails);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, moduleType, code, name, description, auditDetails);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class FinancialStatus {\n");

		sb.append("    id: ").append(toIndentedString(id)).append("\n");
		sb.append("    moduleType: ").append(toIndentedString(moduleType)).append("\n");
		sb.append("    code: ").append(toIndentedString(code)).append("\n");
		sb.append("    name: ").append(toIndentedString(name)).append("\n");
		sb.append("    description: ").append(toIndentedString(description)).append("\n");
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
