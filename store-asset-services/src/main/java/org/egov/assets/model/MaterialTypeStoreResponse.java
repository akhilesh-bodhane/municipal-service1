package org.egov.assets.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.validation.Valid;

import org.egov.common.contract.response.ResponseInfo;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Contract class for web response. Array of Material Type Store Mapping are
 * used in case of search ,create or update request.
 */
public class MaterialTypeStoreResponse {
	@JsonProperty("ResponseInfo")
	private ResponseInfo responseInfo = null;

	@JsonProperty("materialTypeStores")
	private List<MaterialTypeStoreMapping> materialTypeStores = null;

	@JsonProperty("page")
	private Page page = null;

	public MaterialTypeStoreResponse responseInfo(ResponseInfo responseInfo) {
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

	public MaterialTypeStoreResponse materialTypeStores(List<MaterialTypeStoreMapping> materialTypeStores) {
		this.materialTypeStores = materialTypeStores;
		return this;
	}

	public MaterialTypeStoreResponse addMaterialTypeStoresItem(MaterialTypeStoreMapping materialTypeStoresItem) {
		if (this.materialTypeStores == null) {
			this.materialTypeStores = new ArrayList<MaterialTypeStoreMapping>();
		}
		this.materialTypeStores.add(materialTypeStoresItem);
		return this;
	}

	/**
	 * Used for search result and create only
	 *
	 * @return materialTypeStores
	 **/
	@Valid

	public List<MaterialTypeStoreMapping> getMaterialTypeStores() {
		return materialTypeStores;
	}

	public void setMaterialTypeStores(List<MaterialTypeStoreMapping> materialTypeStores) {
		this.materialTypeStores = materialTypeStores;
	}

	public MaterialTypeStoreResponse page(Page page) {
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
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		MaterialTypeStoreResponse materialTypeStoreResponse = (MaterialTypeStoreResponse) o;
		return Objects.equals(this.responseInfo, materialTypeStoreResponse.responseInfo)
				&& Objects.equals(this.materialTypeStores, materialTypeStoreResponse.materialTypeStores)
				&& Objects.equals(this.page, materialTypeStoreResponse.page);
	}

	@Override
	public int hashCode() {
		return Objects.hash(responseInfo, materialTypeStores, page);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class MaterialTypeStoreResponse {\n");

		sb.append("    responseInfo: ").append(toIndentedString(responseInfo)).append("\n");
		sb.append("    materialTypeStores: ").append(toIndentedString(materialTypeStores)).append("\n");
		sb.append("    page: ").append(toIndentedString(page)).append("\n");
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
