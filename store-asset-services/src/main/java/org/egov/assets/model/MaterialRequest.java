package org.egov.assets.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.validation.Valid;

import org.egov.common.contract.request.RequestInfo;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Contract class for web request. Array of Material items are used in case of
 * create or update
 */

public class MaterialRequest {
	@JsonProperty("RequestInfo")
	private RequestInfo requestInfo = null;

	@JsonProperty("materials")
	private List<Material> materials = null;

	public MaterialRequest requestInfo(RequestInfo requestInfo) {
		this.requestInfo = requestInfo;
		return this;
	}

	/**
	 * Get requestInfo
	 *
	 * @return requestInfo
	 **/
	@Valid

	public RequestInfo getRequestInfo() {
		return requestInfo;
	}

	public void setRequestInfo(RequestInfo requestInfo) {
		this.requestInfo = requestInfo;
	}

	public MaterialRequest materials(List<Material> materials) {
		this.materials = materials;
		return this;
	}

	public MaterialRequest addMaterialsItem(Material materialsItem) {
		if (this.materials == null) {
			this.materials = new ArrayList<Material>();
		}
		this.materials.add(materialsItem);
		return this;
	}

	/**
	 * Used for search result and create only
	 *
	 * @return materials
	 **/
	public List<Material> getMaterials() {
		return materials;
	}

	public void setMaterials(List<Material> materials) {
		this.materials = materials;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		MaterialRequest materialRequest = (MaterialRequest) o;
		return Objects.equals(this.requestInfo, materialRequest.requestInfo)
				&& Objects.equals(this.materials, materialRequest.materials);
	}

	@Override
	public int hashCode() {
		return Objects.hash(requestInfo, materials);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class MaterialRequest {\n");

		sb.append("    requestInfo: ").append(toIndentedString(requestInfo)).append("\n");
		sb.append("    materials: ").append(toIndentedString(materials)).append("\n");
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
