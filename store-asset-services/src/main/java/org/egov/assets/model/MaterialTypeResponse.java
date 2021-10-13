package org.egov.assets.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.validation.Valid;

import org.egov.common.contract.response.ResponseInfo;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Contract class for web response. Array of Material Types are used in case of
 * search ,create or update request.
 */

public class MaterialTypeResponse {
	@JsonProperty("ResponseInfo")
	private ResponseInfo responseInfo = null;

	@JsonProperty("materialTypes")
	private List<MaterialType> materialTypes = null;

	@JsonProperty("page")
	private Page page = null;

	public MaterialTypeResponse responseInfo(ResponseInfo responseInfo) {
		this.responseInfo = responseInfo;
		return this;
	}

	/**
	 * Get responseInfo
	 * 
	 * @return responseInfo
	 **/
	@Valid

	public ResponseInfo getResponseInfo() {
		return responseInfo;
	}

	public void setResponseInfo(ResponseInfo responseInfo) {
		this.responseInfo = responseInfo;
	}

	public MaterialTypeResponse materialTypes(List<MaterialType> materialTypes) {
		this.materialTypes = materialTypes;
		return this;
	}

	public MaterialTypeResponse addMaterialTypesItem(MaterialType materialTypesItem) {
		if (this.materialTypes == null) {
			this.materialTypes = new ArrayList<MaterialType>();
		}
		this.materialTypes.add(materialTypesItem);
		return this;
	}

	/**
	 * Used for search result and create only
	 * 
	 * @return materialTypes
	 **/
	@Valid

	public List<MaterialType> getMaterialTypes() {
		return materialTypes;
	}

	public void setMaterialTypes(List<MaterialType> materialTypes) {
		this.materialTypes = materialTypes;
	}

	public MaterialTypeResponse page(Page page) {
		this.page = page;
		return this;
	}

	/**
	 * Get page
	 * 
	 * @return page
	 **/
	@Valid

	public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		MaterialTypeResponse materialTypeResponse = (MaterialTypeResponse) o;
		return Objects.equals(this.responseInfo, materialTypeResponse.responseInfo)
				&& Objects.equals(this.materialTypes, materialTypeResponse.materialTypes)
				&& Objects.equals(this.page, materialTypeResponse.page);
	}

	@Override
	public int hashCode() {
		return Objects.hash(responseInfo, materialTypes, page);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class MaterialTypeResponse {\n");

		sb.append("    responseInfo: ").append(toIndentedString(responseInfo)).append("\n");
		sb.append("    materialTypes: ").append(toIndentedString(materialTypes)).append("\n");
		sb.append("    page: ").append(toIndentedString(page)).append("\n");
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
