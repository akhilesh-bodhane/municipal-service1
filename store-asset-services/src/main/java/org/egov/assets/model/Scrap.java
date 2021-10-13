package org.egov.assets.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * This object holds the scrap information.
 */
public class Scrap {
	@JsonProperty("id")
	private String id = null;

	@JsonProperty("tenantId")
	private String tenantId = null;

	@JsonProperty("issueNumber")
	private String issueNumber = null;

	@JsonProperty("store")
	private Store store = null;

	@JsonProperty("scrapNumber")
	private String scrapNumber = null;

	@JsonProperty("scrapDate")
	private Long scrapDate = null;

	@JsonProperty("description")
	private String description = null;

	@JsonProperty("scrapDetails")
	private List<ScrapDetail> scrapDetails = new ArrayList<ScrapDetail>();

	/**
	 * scrap status of the Scrap
	 */
	public enum ScrapStatusEnum {
		CREATED("CREATED"),

		APPROVED("APPROVED"),

		REJECTED("REJECTED"),

		CANCELED("CANCELED");

		private String value;

		ScrapStatusEnum(String value) {
			this.value = value;
		}

		@Override
		@JsonValue
		public String toString() {
			return String.valueOf(value);
		}

		@JsonCreator
		public static ScrapStatusEnum fromValue(String text) {
			for (ScrapStatusEnum b : ScrapStatusEnum.values()) {
				if (String.valueOf(b.value).equals(text)) {
					return b;
				}
			}
			return null;
		}
	}

	@JsonProperty("scrapStatus")
	private ScrapStatusEnum scrapStatus = null;

	@JsonProperty("workFlowDetails")
	private WorkFlowDetails workFlowDetails = null;

	@JsonProperty("stateId")
	private Long stateId = null;

	@JsonProperty("designation")
	private String designation = null;

	@JsonProperty("auditDetails")
	private AuditDetails auditDetails = null;

	public Scrap issueNumber(String issueNumber) {
		this.issueNumber = issueNumber;
		return this;
	}

	/**
	 * issue note number/outward note number.Auto generated number, read only.
	 * 
	 * @return issueNumber
	 **/
	@Size(max = 100)
	public String getIssueNumber() {
		return issueNumber;
	}

	public void setIssueNumber(String issueNumber) {
		this.issueNumber = issueNumber;
	}

	public Scrap id(String id) {
		this.id = id;
		return this;
	}

	/**
	 * Unique Identifier of the Scrap
	 * 
	 * @return id
	 **/

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Scrap tenantId(String tenantId) {
		this.tenantId = tenantId;
		return this;
	}

	/**
	 * Tenant id of the Scrap
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

	public Scrap store(Store store) {
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

	public Scrap scrapNumber(String scrapNumber) {
		this.scrapNumber = scrapNumber;
		return this;
	}

	/**
	 * scrapNumber Auto generated number, read only
	 * 
	 * @return scrapNumber
	 **/

	public String getScrapNumber() {
		return scrapNumber;
	}

	public void setScrapNumber(String scrapNumber) {
		this.scrapNumber = scrapNumber;
	}

	public Scrap scrapDate(Long scrapDate) {
		this.scrapDate = scrapDate;
		return this;
	}

	/**
	 * scrap date of the Scrap
	 * 
	 * @return scrapDate
	 **/

	@NotNull

	public Long getScrapDate() {
		return scrapDate;
	}

	public void setScrapDate(Long scrapDate) {
		this.scrapDate = scrapDate;
	}

	public Scrap description(String description) {
		this.description = description;
		return this;
	}

	/**
	 * description of the Scrap
	 * 
	 * @return description
	 **/

	@Size(max = 500)
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Scrap scrapDetails(List<ScrapDetail> scrapDetails) {
		this.scrapDetails = scrapDetails;
		return this;
	}

	public Scrap addScrapDetailsItem(ScrapDetail scrapDetailsItem) {
		this.scrapDetails.add(scrapDetailsItem);
		return this;
	}

	/**
	 * scrap details of the Scrap
	 * 
	 * @return scrapDetails
	 **/

	@NotNull

	@Size(min = 1, max = 50)
	public List<ScrapDetail> getScrapDetails() {
		return scrapDetails;
	}

	public void setScrapDetails(List<ScrapDetail> scrapDetails) {
		this.scrapDetails = scrapDetails;
	}

	public Scrap scrapStatus(ScrapStatusEnum scrapStatus) {
		this.scrapStatus = scrapStatus;
		return this;
	}

	/**
	 * scrap status of the Scrap
	 * 
	 * @return scrapStatus
	 **/
	public ScrapStatusEnum getScrapStatus() {
		return scrapStatus;
	}

	public void setScrapStatus(ScrapStatusEnum scrapStatus) {
		this.scrapStatus = scrapStatus;
	}

	public Scrap workFlowDetails(WorkFlowDetails workFlowDetails) {
		this.workFlowDetails = workFlowDetails;
		return this;
	}

	/**
	 * Get workFlowDetails
	 * 
	 * @return workFlowDetails
	 **/
	@Valid

	public WorkFlowDetails getWorkFlowDetails() {
		return workFlowDetails;
	}

	public void setWorkFlowDetails(WorkFlowDetails workFlowDetails) {
		this.workFlowDetails = workFlowDetails;
	}

	public Scrap stateId(Long stateId) {
		this.stateId = stateId;
		return this;
	}

	/**
	 * state id of the Scrap
	 * 
	 * @return stateId
	 **/

	public Long getStateId() {
		return stateId;
	}

	public void setStateId(Long stateId) {
		this.stateId = stateId;
	}

	public Scrap designation(String designation) {
		this.designation = designation;
		return this;
	}

	/**
	 * Designation of the created by user at the time of Scrap Note creation.
	 * 
	 * @return designation
	 **/
	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public Scrap auditDetails(AuditDetails auditDetails) {
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
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Scrap scrap = (Scrap) o;
		return Objects.equals(this.id, scrap.id) && Objects.equals(this.tenantId, scrap.tenantId)
				&& Objects.equals(this.store, scrap.store) && Objects.equals(this.scrapNumber, scrap.scrapNumber)
				&& Objects.equals(this.scrapDate, scrap.scrapDate)
				&& Objects.equals(this.description, scrap.description)
				&& Objects.equals(this.scrapDetails, scrap.scrapDetails)
				&& Objects.equals(this.scrapStatus, scrap.scrapStatus)
				&& Objects.equals(this.workFlowDetails, scrap.workFlowDetails)
				&& Objects.equals(this.stateId, scrap.stateId) && Objects.equals(this.designation, scrap.designation)
				&& Objects.equals(this.auditDetails, scrap.auditDetails);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, tenantId, store, scrapNumber, scrapDate, description, scrapDetails, scrapStatus,
				workFlowDetails, stateId, designation, auditDetails);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class Scrap {\n");

		sb.append("    id: ").append(toIndentedString(id)).append("\n");
		sb.append("    tenantId: ").append(toIndentedString(tenantId)).append("\n");
		sb.append("    store: ").append(toIndentedString(store)).append("\n");
		sb.append("    scrapNumber: ").append(toIndentedString(scrapNumber)).append("\n");
		sb.append("    scrapDate: ").append(toIndentedString(scrapDate)).append("\n");
		sb.append("    description: ").append(toIndentedString(description)).append("\n");
		sb.append("    scrapDetails: ").append(toIndentedString(scrapDetails)).append("\n");
		sb.append("    scrapStatus: ").append(toIndentedString(scrapStatus)).append("\n");
		sb.append("    workFlowDetails: ").append(toIndentedString(workFlowDetails)).append("\n");
		sb.append("    stateId: ").append(toIndentedString(stateId)).append("\n");
		sb.append("    designation: ").append(toIndentedString(designation)).append("\n");
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