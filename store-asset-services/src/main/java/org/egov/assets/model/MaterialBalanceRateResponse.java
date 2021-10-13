package org.egov.assets.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.validation.Valid;

import org.egov.common.contract.response.ResponseInfo;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Hold the Material Balance AND Rate Response information
 */

public class MaterialBalanceRateResponse {
	@JsonProperty("ResponseInfo")
	private ResponseInfo responseInfo = null;

	@JsonProperty("MaterialBalanceRate")
	private List<MaterialBalanceRate> materialBalanceRate = null;

	public MaterialBalanceRateResponse responseInfo(ResponseInfo responseInfo) {
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

	public MaterialBalanceRateResponse materialReceipt(List<MaterialBalanceRate> materialBalanceRate) {
		this.materialBalanceRate = materialBalanceRate;
		return this;
	}

	public MaterialBalanceRateResponse addMaterialReceiptItem(MaterialBalanceRate materialBalanceRate) {
		if (this.materialBalanceRate == null) {
			this.materialBalanceRate = new ArrayList<MaterialBalanceRate>();
		}
		this.materialBalanceRate.add(materialBalanceRate);
		return this;
	}

	@Override
	public String toString() {
		return "MaterialBalanceRateResponse [materialBalanceRate=" + materialBalanceRate + "]";
	}

	public List<MaterialBalanceRate> getMaterialBalanceRate() {
		return materialBalanceRate;
	}

	public void setMaterialBalanceRate(List<MaterialBalanceRate> materialBalanceRate) {
		this.materialBalanceRate = materialBalanceRate;
	}
}
