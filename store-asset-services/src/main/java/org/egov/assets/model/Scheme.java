package org.egov.assets.model;

import java.util.Objects;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.joda.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 *
 */

public class Scheme {
	@JsonProperty("id")
	private String id = null;

	@JsonProperty("fund")
	private Fund fund = null;

	@JsonProperty("code")
	private String code = null;

	@JsonProperty("name")
	private String name = null;

	@JsonProperty("validFrom")
	private LocalDate validFrom = null;

	@JsonProperty("validTo")
	private LocalDate validTo = null;

	@JsonProperty("active")
	private Boolean active = null;

	@JsonProperty("description")
	private String description = null;

	@JsonProperty("boundary")
	private String boundary = null;

	@JsonProperty("auditDetails")
	private Auditable auditDetails = null;

	public Scheme id(String id) {
		this.id = id;
		return this;
	}

	/**
	 * Unique Identifier of the Scheme
	 *
	 * @return id
	 **/
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Scheme fund(Fund fund) {
		this.fund = fund;
		return this;
	}

	/**
	 * fund of the Scheme
	 *
	 * @return fund
	 **/
	@Valid

	public Fund getFund() {
		return fund;
	}

	public void setFund(Fund fund) {
		this.fund = fund;
	}

	public Scheme code(String code) {
		this.code = code;
		return this;
	}

	/**
	 * code of the Scheme
	 *
	 * @return code
	 **/
	@Size(min = 1, max = 25)
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Scheme name(String name) {
		this.name = name;
		return this;
	}

	/**
	 * name of the Scheme
	 *
	 * @return name
	 **/
	@Size(min = 1, max = 25)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Scheme validFrom(LocalDate validFrom) {
		this.validFrom = validFrom;
		return this;
	}

	/**
	 * valid from of the Scheme
	 *
	 * @return validFrom
	 **/

	@NotNull

	@Valid

	public LocalDate getValidFrom() {
		return validFrom;
	}

	public void setValidFrom(LocalDate validFrom) {
		this.validFrom = validFrom;
	}

	public Scheme validTo(LocalDate validTo) {
		this.validTo = validTo;
		return this;
	}

	/**
	 * valid to of the Scheme
	 *
	 * @return validTo
	 **/

	@NotNull

	@Valid

	public LocalDate getValidTo() {
		return validTo;
	}

	public void setValidTo(LocalDate validTo) {
		this.validTo = validTo;
	}

	public Scheme active(Boolean active) {
		this.active = active;
		return this;
	}

	/**
	 * Whether Scheme is Active or not. If the value is TRUE, then Scheme is
	 * active,If the value is FALSE then Scheme is inactive,Default value is TRUE
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

	public Scheme description(String description) {
		this.description = description;
		return this;
	}

	/**
	 * description of the Scheme
	 *
	 * @return description
	 **/
	@Size(max = 256)
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Scheme boundary(String boundary) {
		this.boundary = boundary;
		return this;
	}

	/**
	 * boundary of the Scheme
	 *
	 * @return boundary
	 **/
	public String getBoundary() {
		return boundary;
	}

	public void setBoundary(String boundary) {
		this.boundary = boundary;
	}

	public Scheme auditDetails(Auditable auditDetails) {
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
		Scheme scheme = (Scheme) o;
		return Objects.equals(this.id, scheme.id) && Objects.equals(this.fund, scheme.fund)
				&& Objects.equals(this.code, scheme.code) && Objects.equals(this.name, scheme.name)
				&& Objects.equals(this.validFrom, scheme.validFrom) && Objects.equals(this.validTo, scheme.validTo)
				&& Objects.equals(this.active, scheme.active) && Objects.equals(this.description, scheme.description)
				&& Objects.equals(this.boundary, scheme.boundary)
				&& Objects.equals(this.auditDetails, scheme.auditDetails);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, fund, code, name, validFrom, validTo, active, description, boundary, auditDetails);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class Scheme {\n");

		sb.append("    id: ").append(toIndentedString(id)).append("\n");
		sb.append("    fund: ").append(toIndentedString(fund)).append("\n");
		sb.append("    code: ").append(toIndentedString(code)).append("\n");
		sb.append("    name: ").append(toIndentedString(name)).append("\n");
		sb.append("    validFrom: ").append(toIndentedString(validFrom)).append("\n");
		sb.append("    validTo: ").append(toIndentedString(validTo)).append("\n");
		sb.append("    active: ").append(toIndentedString(active)).append("\n");
		sb.append("    description: ").append(toIndentedString(description)).append("\n");
		sb.append("    boundary: ").append(toIndentedString(boundary)).append("\n");
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
