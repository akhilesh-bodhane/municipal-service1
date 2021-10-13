package org.egov.assets.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.egov.common.contract.request.RequestInfo;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Contract class for web request. Array of Material Type Store Mapping are used
 * in case of create or update
 */
public class MaterialTypeStoreRequest {
	@JsonProperty("RequestInfo")
	private RequestInfo requestInfo = null;

	@JsonProperty("materialTypeStores")
	private List<MaterialTypeStoreMapping> materialTypeStores = new ArrayList<MaterialTypeStoreMapping>();

	public MaterialTypeStoreRequest requestInfo(RequestInfo requestInfo) {
		this.requestInfo = requestInfo;
		return this;
	}

	/**
	 * Get requestInfo
	 *
	 * @return requestInfo
	 **/
	
	@NotNull
	@Valid
	public RequestInfo getRequestInfo() {
		return requestInfo;
	}

	public void setRequestInfo(RequestInfo requestInfo) {
		this.requestInfo = requestInfo;
	}

	public MaterialTypeStoreRequest materialTypeStores(List<MaterialTypeStoreMapping> materialTypeStores) {
		this.materialTypeStores = materialTypeStores;
		return this;
	}

	public MaterialTypeStoreRequest addMaterialTypeStoresItem(MaterialTypeStoreMapping materialTypeStoresItem) {
		this.materialTypeStores.add(materialTypeStoresItem);
		return this;
	}

	/**
	 * Used for search result and create only
	 *
	 * @return materialTypeStores
	 **/
	
	@NotNull

	@Valid

	public List<MaterialTypeStoreMapping> getMaterialTypeStores() {
		return materialTypeStores;
	}

	public void setMaterialTypeStores(List<MaterialTypeStoreMapping> materialTypeStores) {
		this.materialTypeStores = materialTypeStores;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		MaterialTypeStoreRequest materialTypeStoreRequest = (MaterialTypeStoreRequest) o;
		return Objects.equals(this.requestInfo, materialTypeStoreRequest.requestInfo)
				&& Objects.equals(this.materialTypeStores, materialTypeStoreRequest.materialTypeStores);
	}

	@Override
	public int hashCode() {
		return Objects.hash(requestInfo, materialTypeStores);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class MaterialTypeStoreRequest {\n");

		sb.append("    requestInfo: ").append(toIndentedString(requestInfo)).append("\n");
		sb.append("    materialTypeStores: ").append(toIndentedString(materialTypeStores)).append("\n");
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
