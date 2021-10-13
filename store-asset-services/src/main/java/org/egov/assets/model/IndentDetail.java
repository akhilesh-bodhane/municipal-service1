package org.egov.assets.model;

import java.math.BigDecimal;
import java.util.Objects;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * This object holds the indent details information i.e., material requested in
 * indent.
 */

public class IndentDetail {
	@JsonProperty("id")
	private String id = null;

	@JsonProperty("tenantId")
	private String tenantId = null;

	@JsonProperty("material")
	private Material material = null;

	@JsonProperty("uom")
	private Uom uom = null;

	@JsonProperty("parentIndentLine")
	private String parentIndentLine = null;

	@JsonProperty("orderNumber")
	private BigDecimal orderNumber = null;

	@JsonProperty("projectCode")
	private ProjectCode projectCode = null;

	@JsonProperty("asset")
	private Asset asset = null;

	@JsonProperty("userQuantity")
	private BigDecimal userQuantity = null;

	@JsonProperty("indentQuantity")
	private BigDecimal indentQuantity = null;

	@JsonProperty("totalProcessedQuantity")
	private BigDecimal totalProcessedQuantity = null;

	@JsonProperty("indentIssuedQuantity")
	private BigDecimal indentIssuedQuantity = null;

	@JsonProperty("poOrderedQuantity")
	private BigDecimal poOrderedQuantity = null;

	@JsonProperty("interstoreRequestQuantity")
	private BigDecimal interstoreRequestQuantity = null;

	@JsonProperty("deliveryTerms")
	private String deliveryTerms = null;

	@JsonProperty("remarks")
	private String remarks = null;

	public IndentDetail id(String id) {
		this.id = id;
		return this;
	}

	/**
	 * Unique Identifier of the Indent Detail
	 * 
	 * @return id
	 **/

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public IndentDetail tenantId(String tenantId) {
		this.tenantId = tenantId;
		return this;
	}

	/**
	 * Tenant id of the Indent Detail
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

	public IndentDetail material(Material material) {
		this.material = material;
		return this;
	}

	/**
	 * Get material
	 * 
	 * @return material
	 **/

	@NotNull

	public Material getMaterial() {
		return material;
	}

	public void setMaterial(Material material) {
		this.material = material;
	}

	public IndentDetail uom(Uom uom) {
		this.uom = uom;
		return this;
	}

	/**
	 * Get uom
	 * 
	 * @return uom
	 **/

	@NotNull

	public Uom getUom() {
		return uom;
	}

	public void setUom(Uom uom) {
		this.uom = uom;
	}

	public IndentDetail parentIndentLine(String parentIndentLine) {
		this.parentIndentLine = parentIndentLine;
		return this;
	}

	/**
	 * In case of interstore transfer indent, this field is used to link with
	 * initial indent id (if required)
	 * 
	 * @return parentIndentLine
	 **/

	public String getParentIndentLine() {
		return parentIndentLine;
	}

	public void setParentIndentLine(String parentIndentLine) {
		this.parentIndentLine = parentIndentLine;
	}

	public IndentDetail orderNumber(BigDecimal orderNumber) {
		this.orderNumber = orderNumber;
		return this;
	}

	/**
	 * Order of items selected.
	 * 
	 * @return orderNumber
	 **/

	public BigDecimal getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(BigDecimal orderNumber) {
		this.orderNumber = orderNumber;
	}

	public IndentDetail projectCode(ProjectCode projectCode) {
		this.projectCode = projectCode;
		return this;
	}

	/**
	 * projectCode If case the purpose is Capital
	 * 
	 * @return projectCode
	 **/

	public ProjectCode getProjectCode() {
		return projectCode;
	}

	public void setProjectCode(ProjectCode projectCode) {
		this.projectCode = projectCode;
	}

	public IndentDetail asset(Asset asset) {
		this.asset = asset;
		return this;
	}

	/**
	 * Mandatory if the purpose is Repair and Maintenance.Refer asset code format:
	 * autoComplete
	 * 
	 * @return asset
	 **/
	public Asset getAsset() {
		return asset;
	}

	public void setAsset(Asset asset) {
		this.asset = asset;
	}

	public IndentDetail userQuantity(BigDecimal userQuantity) {
		this.userQuantity = userQuantity;
		return this;
	}

	/**
	 * indent quantity of the IndentDetail. Quantity requested by indentor.
	 * 
	 * @return userQuantity
	 **/

	@NotNull

	public BigDecimal getUserQuantity() {
		return userQuantity;
	}

	public void setUserQuantity(BigDecimal userQuantity) {
		this.userQuantity = userQuantity;
	}

	public IndentDetail indentQuantity(BigDecimal indentQuantity) {
		this.indentQuantity = indentQuantity;
		return this;
	}

	/**
	 * indent quantity of the IndentDetail. Quantity after converting to base uom.
	 * 
	 * @return indentQuantity
	 **/

	public BigDecimal getIndentQuantity() {
		return indentQuantity;
	}

	public void setIndentQuantity(BigDecimal indentQuantity) {
		this.indentQuantity = indentQuantity;
	}

	public IndentDetail totalProcessedQuantity(BigDecimal totalProcessedQuantity) {
		this.totalProcessedQuantity = totalProcessedQuantity;
		return this;
	}

	/**
	 * Quantity issued from indent issue.
	 * 
	 * @return totalProcessedQuantity
	 **/

	public BigDecimal getTotalProcessedQuantity() {
		return totalProcessedQuantity;
	}

	public void setTotalProcessedQuantity(BigDecimal totalProcessedQuantity) {
		this.totalProcessedQuantity = totalProcessedQuantity;
	}

	public IndentDetail indentIssuedQuantity(BigDecimal indentIssuedQuantity) {
		this.indentIssuedQuantity = indentIssuedQuantity;
		return this;
	}

	/**
	 * Quantity issued from material indent screen.
	 * 
	 * @return indentIssuedQuantity
	 **/
	public BigDecimal getIndentIssuedQuantity() {
		return indentIssuedQuantity;
	}

	public void setIndentIssuedQuantity(BigDecimal indentIssuedQuantity) {
		this.indentIssuedQuantity = indentIssuedQuantity;
	}

	public IndentDetail poOrderedQuantity(BigDecimal poOrderedQuantity) {
		this.poOrderedQuantity = poOrderedQuantity;
		return this;
	}

	/**
	 * How many quantities ordered for purchase order.
	 * 
	 * @return poOrderedQuantity
	 **/

	public BigDecimal getPoOrderedQuantity() {
		return poOrderedQuantity;
	}

	public void setPoOrderedQuantity(BigDecimal poOrderedQuantity) {
		this.poOrderedQuantity = poOrderedQuantity;
	}

	public IndentDetail interstoreRequestQuantity(BigDecimal interstoreRequestQuantity) {
		this.interstoreRequestQuantity = interstoreRequestQuantity;
		return this;
	}

	/**
	 * Quantity requsted via inter store indent.
	 * 
	 * @return interstoreRequestQuantity
	 **/
	public BigDecimal getInterstoreRequestQuantity() {
		return interstoreRequestQuantity;
	}

	public void setInterstoreRequestQuantity(BigDecimal interstoreRequestQuantity) {
		this.interstoreRequestQuantity = interstoreRequestQuantity;
	}

	public IndentDetail deliveryTerms(String deliveryTerms) {
		this.deliveryTerms = deliveryTerms;
		return this;
	}

	/**
	 * Delivery conditions if any
	 * 
	 * @return deliveryTerms
	 **/
	@Size(max = 512)
	public String getDeliveryTerms() {
		return deliveryTerms;
	}

	public void setDeliveryTerms(String deliveryTerms) {
		this.deliveryTerms = deliveryTerms;
	}

	public IndentDetail remarks(String remarks) {
		this.remarks = remarks;
		return this;
	}

	/**
	 * remarks of the IndentDetail
	 * 
	 * @return remarks
	 **/
	@Size(max = 512)
	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		IndentDetail indentDetail = (IndentDetail) o;
		return Objects.equals(this.id, indentDetail.id) && Objects.equals(this.tenantId, indentDetail.tenantId)
				&& Objects.equals(this.material, indentDetail.material) && Objects.equals(this.uom, indentDetail.uom)
				&& Objects.equals(this.parentIndentLine, indentDetail.parentIndentLine)
				&& Objects.equals(this.orderNumber, indentDetail.orderNumber)
				&& Objects.equals(this.projectCode, indentDetail.projectCode)
				&& Objects.equals(this.asset, indentDetail.asset)
				&& Objects.equals(this.userQuantity, indentDetail.userQuantity)
				&& Objects.equals(this.indentQuantity, indentDetail.indentQuantity)
				&& Objects.equals(this.totalProcessedQuantity, indentDetail.totalProcessedQuantity)
				&& Objects.equals(this.indentIssuedQuantity, indentDetail.indentIssuedQuantity)
				&& Objects.equals(this.poOrderedQuantity, indentDetail.poOrderedQuantity)
				&& Objects.equals(this.interstoreRequestQuantity, indentDetail.interstoreRequestQuantity)
				&& Objects.equals(this.deliveryTerms, indentDetail.deliveryTerms)
				&& Objects.equals(this.remarks, indentDetail.remarks);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, tenantId, material, uom, parentIndentLine, orderNumber, projectCode, asset,
				userQuantity, indentQuantity, totalProcessedQuantity, indentIssuedQuantity, poOrderedQuantity,
				interstoreRequestQuantity, deliveryTerms, remarks);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class IndentDetail {\n");

		sb.append("    id: ").append(toIndentedString(id)).append("\n");
		sb.append("    tenantId: ").append(toIndentedString(tenantId)).append("\n");
		sb.append("    material: ").append(toIndentedString(material)).append("\n");
		sb.append("    uom: ").append(toIndentedString(uom)).append("\n");
		sb.append("    parentIndentLine: ").append(toIndentedString(parentIndentLine)).append("\n");
		sb.append("    orderNumber: ").append(toIndentedString(orderNumber)).append("\n");
		sb.append("    projectCode: ").append(toIndentedString(projectCode)).append("\n");
		sb.append("    asset: ").append(toIndentedString(asset)).append("\n");
		sb.append("    userQuantity: ").append(toIndentedString(userQuantity)).append("\n");
		sb.append("    indentQuantity: ").append(toIndentedString(indentQuantity)).append("\n");
		sb.append("    totalProcessedQuantity: ").append(toIndentedString(totalProcessedQuantity)).append("\n");
		sb.append("    indentIssuedQuantity: ").append(toIndentedString(indentIssuedQuantity)).append("\n");
		sb.append("    poOrderedQuantity: ").append(toIndentedString(poOrderedQuantity)).append("\n");
		sb.append("    interstoreRequestQuantity: ").append(toIndentedString(interstoreRequestQuantity)).append("\n");
		sb.append("    deliveryTerms: ").append(toIndentedString(deliveryTerms)).append("\n");
		sb.append("    remarks: ").append(toIndentedString(remarks)).append("\n");
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
