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

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

/**
 * This object holds the disposal information.
 */
@AllArgsConstructor
@NoArgsConstructor
public class Disposal {
	@JsonProperty("id")
	private String id = null;

	@JsonProperty("tenantId")
	private String tenantId = null;

	@JsonProperty("store")
	private Store store = null;

	@JsonProperty("scrapNumbers")
	private List<String> scrapNumbers = null;

	@JsonProperty("disposalNumber")
	private String disposalNumber = null;

	@JsonProperty("disposalDate")
	private Long disposalDate = null;

	@JsonProperty("handOverTo")
	private String handOverTo = null;

	@JsonProperty("auctionNumber")
	private String auctionNumber = null;

	@JsonProperty("description")
	private String description = null;

	@JsonProperty("disposalDetails")
	private List<DisposalDetail> disposalDetails = null;

	/**
	 * disposal status of the Disposal
	 */
	public enum DisposalStatusEnum {
		CREATED("CREATED"),

		APPROVED("APPROVED"),

		REJECTED("REJECTED"),

		CANCELED("CANCELED");

		private String value;

		DisposalStatusEnum(String value) {
			this.value = value;
		}

		@Override
		@JsonValue
		public String toString() {
			return String.valueOf(value);
		}

		@JsonCreator
		public static DisposalStatusEnum fromValue(String text) {
			for (DisposalStatusEnum b : DisposalStatusEnum.values()) {
				if (String.valueOf(b.value).equals(text)) {
					return b;
				}
			}
			return null;
		}
	}

	@JsonProperty("disposalStatus")
	private DisposalStatusEnum disposalStatus = null;

	@JsonProperty("workFlowDetails")
	private WorkFlowDetails workFlowDetails = null;

	@JsonProperty("stateId")
	private Long stateId = null;

	@JsonProperty("totalDisposalValue")
	private BigDecimal totalDisposalValue = null;

	@JsonProperty("auditDetails")
	private AuditDetails auditDetails = null;

	public Disposal id(String id) {
		this.id = id;
		return this;
	}

	/**
	 * Unique Identifier of the Disposal
	 * 
	 * @return id
	 **/

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Disposal tenantId(String tenantId) {
		this.tenantId = tenantId;
		return this;
	}

	/**
	 * Tenant id of the Material Issue
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

	public Disposal store(Store store) {
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

	public Disposal disposalNumber(String disposalNumber) {
		this.disposalNumber = disposalNumber;
		return this;
	}

	/**
	 * Auto generated number, read only
	 * 
	 * @return disposalNumber
	 **/

	@Size(max = 100)
	public String getDisposalNumber() {
		return disposalNumber;
	}

	public void setDisposalNumber(String disposalNumber) {
		this.disposalNumber = disposalNumber;
	}

	public Disposal scrapNumbers(List<String> scrapNumbers) {
		this.scrapNumbers = scrapNumbers;
		return this;
	}

	/**
	 * Array of scrap numbers
	 * 
	 * @return scrapNumbers
	 **/

	@Size(max = 100)
	public List<String> getScrapNumbers() {
		return scrapNumbers;
	}

	public void setScrapNumber(List<String> scrapNumbers) {
		this.scrapNumbers = scrapNumbers;
	}

	public Disposal disposalDate(Long disposalDate) {
		this.disposalDate = disposalDate;
		return this;
	}

	/**
	 * disposal date of the Disposal
	 * 
	 * @return disposalDate
	 **/

	@NotNull

	public Long getDisposalDate() {
		return disposalDate;
	}

	public void setDisposalDate(Long disposalDate) {
		this.disposalDate = disposalDate;
	}

	public Disposal handOverTo(String handOverTo) {
		this.handOverTo = handOverTo;
		return this;
	}

	/**
	 * hand over to of the Disposal
	 * 
	 * @return handOverTo
	 **/

	@Size(max = 250)
	public String getHandOverTo() {
		return handOverTo;
	}

	public void setHandOverTo(String handOverTo) {
		this.handOverTo = handOverTo;
	}

	public Disposal auctionNumber(String auctionNumber) {
		this.auctionNumber = auctionNumber;
		return this;
	}

	/**
	 * auction number of the Disposal
	 * 
	 * @return auctionNumber
	 **/

	@Size(max = 100)
	public String getAuctionNumber() {
		return auctionNumber;
	}

	public void setAuctionNumber(String auctionNumber) {
		this.auctionNumber = auctionNumber;
	}

	public Disposal description(String description) {
		this.description = description;
		return this;
	}

	/**
	 * description of the Disposal
	 * 
	 * @return description
	 **/

	@Size(max = 1000)
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Disposal disposalDetails(List<DisposalDetail> disposalDetails) {
		this.disposalDetails = disposalDetails;
		return this;
	}

	public Disposal addDisposalDetailsItem(DisposalDetail disposalDetailsItem) {
		if (this.disposalDetails == null) {
			this.disposalDetails = new ArrayList<DisposalDetail>();
		}
		this.disposalDetails.add(disposalDetailsItem);
		return this;
	}

	/**
	 * This object contains the list of materials marked as scraped in the selected
	 * store and are to be disposed.
	 * 
	 * @return disposalDetails
	 **/

	@Valid

	public List<DisposalDetail> getDisposalDetails() {
		return disposalDetails;
	}

	public void setDisposalDetails(List<DisposalDetail> disposalDetails) {
		this.disposalDetails = disposalDetails;
	}

	public Disposal disposalStatus(DisposalStatusEnum disposalStatus) {
		this.disposalStatus = disposalStatus;
		return this;
	}

	/**
	 * disposal status of the Disposal
	 * 
	 * @return disposalStatus
	 **/

	@NotNull

	public DisposalStatusEnum getDisposalStatus() {
		return disposalStatus;
	}

	public void setDisposalStatus(DisposalStatusEnum disposalStatus) {
		this.disposalStatus = disposalStatus;
	}

	public Disposal workFlowDetails(WorkFlowDetails workFlowDetails) {
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

	public Disposal stateId(Long stateId) {
		this.stateId = stateId;
		return this;
	}

	/**
	 * state id of the Disposal
	 * 
	 * @return stateId
	 **/

	public Long getStateId() {
		return stateId;
	}

	public void setStateId(Long stateId) {
		this.stateId = stateId;
	}

	public Disposal totalDisposalValue(BigDecimal totalDisposalValue) {
		this.totalDisposalValue = totalDisposalValue;
		return this;
	}

	/**
	 * totalDisposalValue denormalized value from Disposal Details
	 * 
	 * @return totalDisposalValue
	 **/

	public BigDecimal getTotalDisposalValue() {
		return totalDisposalValue;
	}

	public void setTotalDisposalValue(BigDecimal totalDisposalValue) {
		this.totalDisposalValue = totalDisposalValue;
	}

	public Disposal auditDetails(AuditDetails auditDetails) {
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
		Disposal disposal = (Disposal) o;
		return Objects.equals(this.id, disposal.id) && Objects.equals(this.store, disposal.store)
				&& Objects.equals(this.disposalNumber, disposal.disposalNumber)
				&& Objects.equals(this.disposalDate, disposal.disposalDate)
				&& Objects.equals(this.handOverTo, disposal.handOverTo)
				&& Objects.equals(this.auctionNumber, disposal.auctionNumber)
				&& Objects.equals(this.description, disposal.description)
				&& Objects.equals(this.disposalDetails, disposal.disposalDetails)
				&& Objects.equals(this.disposalStatus, disposal.disposalStatus)
				&& Objects.equals(this.workFlowDetails, disposal.workFlowDetails)
				&& Objects.equals(this.stateId, disposal.stateId)
				&& Objects.equals(this.totalDisposalValue, disposal.totalDisposalValue);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, store, disposalNumber, disposalDate, handOverTo, auctionNumber, description,
				disposalDetails, disposalStatus, workFlowDetails, stateId, totalDisposalValue);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class Disposal {\n");

		sb.append("    id: ").append(toIndentedString(id)).append("\n");
		sb.append("    store: ").append(toIndentedString(store)).append("\n");
		sb.append("    disposalNumber: ").append(toIndentedString(disposalNumber)).append("\n");
		sb.append("    disposalDate: ").append(toIndentedString(disposalDate)).append("\n");
		sb.append("    handOverTo: ").append(toIndentedString(handOverTo)).append("\n");
		sb.append("    auctionNumber: ").append(toIndentedString(auctionNumber)).append("\n");
		sb.append("    description: ").append(toIndentedString(description)).append("\n");
		sb.append("    disposalDetails: ").append(toIndentedString(disposalDetails)).append("\n");
		sb.append("    disposalStatus: ").append(toIndentedString(disposalStatus)).append("\n");
		sb.append("    workFlowDetails: ").append(toIndentedString(workFlowDetails)).append("\n");
		sb.append("    stateId: ").append(toIndentedString(stateId)).append("\n");
		sb.append("    totalDisposalValue: ").append(toIndentedString(totalDisposalValue)).append("\n");
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
