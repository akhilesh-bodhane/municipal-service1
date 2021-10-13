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
public class SubScheme {
	@JsonProperty("id")
	private String id = null;

	@JsonProperty("scheme")
	private Scheme scheme = null;

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

	@JsonProperty("departmentId")
	private String departmentId = null;

	@JsonProperty("auditDetails")
	private Auditable auditDetails = null;

	public SubScheme id(String id) {
		this.id = id;
		return this;
	}

	/**
	 * Unique Identifier of the SubScheme
	 *
	 * @return id
	 **/
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public SubScheme scheme(Scheme scheme) {
		this.scheme = scheme;
		return this;
	}

	/**
	 * scheme of the SubScheme
	 *
	 * @return scheme
	 **/

	@NotNull

	@Valid

	public Scheme getScheme() {
		return scheme;
	}

	public void setScheme(Scheme scheme) {
		this.scheme = scheme;
	}

	public SubScheme code(String code) {
		this.code = code;
		return this;
	}

	/**
	 * code of the SubScheme
	 *
	 * @return code
	 **/

	@NotNull

	@Size(min = 1, max = 50)
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public SubScheme name(String name) {
		this.name = name;
		return this;
	}

	/**
	 * name of the SubScheme
	 *
	 * @return name
	 **/

	@NotNull

	@Size(min = 1, max = 50)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public SubScheme validFrom(LocalDate validFrom) {
		this.validFrom = validFrom;
		return this;
	}

	/**
	 * valid from of the SubScheme
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

	public SubScheme validTo(LocalDate validTo) {
		this.validTo = validTo;
		return this;
	}

	/**
	 * valid to of the SubScheme
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

	public SubScheme active(Boolean active) {
		this.active = active;
		return this;
	}

	/**
	 * Whether SubScheme is Active or not. If the value is TRUE, then SubScheme is
	 * active,If the value is FALSE then SubScheme is inactive,Default value is TRUE
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

	public SubScheme departmentId(String departmentId) {
		this.departmentId = departmentId;
		return this;
	}

	/**
	 * department id of the SubScheme
	 *
	 * @return departmentId
	 **/

	public String getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(String departmentId) {
		this.departmentId = departmentId;
	}

	public SubScheme auditDetails(Auditable auditDetails) {
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
		SubScheme subScheme = (SubScheme) o;
		return Objects.equals(this.id, subScheme.id) && Objects.equals(this.scheme, subScheme.scheme)
				&& Objects.equals(this.code, subScheme.code) && Objects.equals(this.name, subScheme.name)
				&& Objects.equals(this.validFrom, subScheme.validFrom)
				&& Objects.equals(this.validTo, subScheme.validTo) && Objects.equals(this.active, subScheme.active)
				&& Objects.equals(this.departmentId, subScheme.departmentId)
				&& Objects.equals(this.auditDetails, subScheme.auditDetails);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, scheme, code, name, validFrom, validTo, active, departmentId, auditDetails);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class SubScheme {\n");

		sb.append("    id: ").append(toIndentedString(id)).append("\n");
		sb.append("    scheme: ").append(toIndentedString(scheme)).append("\n");
		sb.append("    code: ").append(toIndentedString(code)).append("\n");
		sb.append("    name: ").append(toIndentedString(name)).append("\n");
		sb.append("    validFrom: ").append(toIndentedString(validFrom)).append("\n");
		sb.append("    validTo: ").append(toIndentedString(validTo)).append("\n");
		sb.append("    active: ").append(toIndentedString(active)).append("\n");
		sb.append("    departmentId: ").append(toIndentedString(departmentId)).append("\n");
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
