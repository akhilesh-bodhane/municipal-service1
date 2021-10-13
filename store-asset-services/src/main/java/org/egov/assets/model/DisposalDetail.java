package org.egov.assets.model;

import java.math.BigDecimal;
import java.util.Objects;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * This object contains the list of materials marked as scraped in the selected
 * store and are to be disposed.
 */

public class DisposalDetail {
	@JsonProperty("id")
	private String id = null;

	@JsonProperty("tenantId")
	private String tenantId = null;

	@JsonProperty("material")
	private Material material = null;

	@JsonProperty("uom")
	private Uom uom = null;

	@JsonProperty("scrapDetails")
	private ScrapDetail scrapDetails = null;

	@JsonProperty("disposalQuantity")
	private BigDecimal disposalQuantity = null;

	@JsonProperty("userDisposalQuantity")
	private BigDecimal userDisposalQuantity = null;

	@JsonProperty("pendingScrapQuantity")
	private BigDecimal pendingScrapQuantity = null;

	@JsonProperty("disposalValue")
	private BigDecimal disposalValue = null;

	public DisposalDetail id(String id) {
		this.id = id;
		return this;
	}

	/**
	 * Unique Identifier of the Disposal Details
	 * 
	 * @return id
	 **/

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public DisposalDetail tenantId(String tenantId) {
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

	public DisposalDetail material(Material material) {
		this.material = material;
		return this;
	}

	/**
	 * Get material
	 * 
	 * @return material
	 **/

	public Material getMaterial() {
		return material;
	}

	public void setMaterial(Material material) {
		this.material = material;
	}

	public DisposalDetail uom(Uom uom) {
		this.uom = uom;
		return this;
	}

	/**
	 * Auto populate unit of material from scrap
	 * 
	 * @return uom
	 **/

	@Valid

	public Uom getUom() {
		return uom;
	}

	public void setUom(Uom uom) {
		this.uom = uom;
	}

	public DisposalDetail scrapDetails(ScrapDetail scrapDetails) {
		this.scrapDetails = scrapDetails;
		return this;
	}

	/**
	 * Get scrapDetails
	 * 
	 * @return scrapDetails
	 **/

	@NotNull

	public ScrapDetail getScrapDetails() {
		return scrapDetails;
	}

	public void setScrapDetails(ScrapDetail scrapDetails) {
		this.scrapDetails = scrapDetails;
	}

	public DisposalDetail disposalQuantity(BigDecimal disposalQuantity) {
		this.disposalQuantity = disposalQuantity;
		return this;
	}

	/**
	 * disposal quantity of the DisposalDetails
	 * 
	 * @return disposalQuantity
	 **/
	@Valid

	public BigDecimal getDisposalQuantity() {
		return disposalQuantity;
	}

	public void setDisposalQuantity(BigDecimal disposalQuantity) {
		this.disposalQuantity = disposalQuantity;
	}

	public DisposalDetail userDisposalQuantity(BigDecimal userDisposalQuantity) {
		this.userDisposalQuantity = userDisposalQuantity;
		return this;
	}

	/**
	 * disposal quantity of the DisposalDetails
	 * 
	 * @return disposalQuantity
	 **/

	@NotNull

	@Valid

	public BigDecimal getUserDisposalQuantity() {
		return userDisposalQuantity;
	}

	public void setUserDisposalQuantity(BigDecimal userDisposalQuantity) {
		this.userDisposalQuantity = userDisposalQuantity;
	}

	public DisposalDetail pendingScrapQuantity(BigDecimal pendingScrapQuantity) {
		this.pendingScrapQuantity = pendingScrapQuantity;
		return this;
	}

	/**
	 * pending ScrapQuantity of the DisposalDetails
	 * 
	 * @return pendingScrapQuantity
	 **/

	public BigDecimal getPendingScrapQuantity() {
		return pendingScrapQuantity;
	}

	public void setPendingScrapQuantity(BigDecimal pendingScrapQuantity) {
		this.pendingScrapQuantity = pendingScrapQuantity;
	}

	public DisposalDetail disposalValue(BigDecimal disposalValue) {
		this.disposalValue = disposalValue;
		return this;
	}

	/**
	 * disposal value of the DisposalDetails
	 * 
	 * @return disposalValue
	 **/

	@NotNull

	public BigDecimal getDisposalValue() {
		return disposalValue;
	}

	public void setDisposalValue(BigDecimal disposalValue) {
		this.disposalValue = disposalValue;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		DisposalDetail disposalDetails = (DisposalDetail) o;
		return Objects.equals(this.id, disposalDetails.id)
				&& Objects.equals(this.scrapDetails, disposalDetails.scrapDetails)
				&& Objects.equals(this.disposalQuantity, disposalDetails.disposalQuantity)
				&& Objects.equals(this.disposalValue, disposalDetails.disposalValue);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, scrapDetails, disposalQuantity, disposalValue);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class DisposalDetails {\n");

		sb.append("    id: ").append(toIndentedString(id)).append("\n");
		sb.append("    scrapDetails: ").append(toIndentedString(scrapDetails)).append("\n");
		sb.append("    disposalQuantity: ").append(toIndentedString(disposalQuantity)).append("\n");
		sb.append("    disposalValue: ").append(toIndentedString(disposalValue)).append("\n");
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
