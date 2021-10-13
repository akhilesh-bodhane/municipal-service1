package org.egov.assets.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.validation.Valid;

import org.egov.common.contract.response.ResponseInfo;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

/**
 * Contract class for web response. Array of PriceList items  are used in case of search ,create or update request.
 */
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PriceListDetailsResponse   {
  @JsonProperty("ResponseInfo")
  private ResponseInfo responseInfo = null;

  @JsonProperty("priceListDetails")
  private List<PriceListDetails> priceListDetails = null;

  @JsonProperty("page")
  private Page page = null;

  public PriceListDetailsResponse responseInfo(ResponseInfo responseInfo) {
    this.responseInfo = responseInfo;
    return this;
  }

   /**
   * Get responseInfo
   * @return responseInfo
  **/
    @Valid

  public ResponseInfo getResponseInfo() {
    return responseInfo;
  }

  public void setResponseInfo(ResponseInfo responseInfo) {
    this.responseInfo = responseInfo;
  }

  public PriceListDetailsResponse priceListDetails(List<PriceListDetails> priceListDetails) {
    this.priceListDetails = priceListDetails;
    return this;
  }

  public PriceListDetailsResponse addPriceListDetailsItem(PriceListDetails priceListDetailsItem) {
    if (this.priceListDetails == null) {
      this.priceListDetails = new ArrayList<PriceListDetails>();
    }
    this.priceListDetails.add(priceListDetailsItem);
    return this;
  }

   /**
   * Used for search result and create only
   * @return priceLists
  **/
    @Valid

  public List<PriceListDetails> getPriceListDetials() {
    return priceListDetails;
  }

  public void setPriceListDetails(List<PriceListDetails> priceListDetails) {
    this.priceListDetails = priceListDetails;
  }

  public PriceListDetailsResponse page(Page page) {
    this.page = page;
    return this;
  }

   /**
   * Get page
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
    PriceListDetailsResponse priceListDetailsResponse = (PriceListDetailsResponse) o;
    return Objects.equals(this.responseInfo, priceListDetailsResponse.responseInfo) &&
        Objects.equals(this.priceListDetails, priceListDetailsResponse.priceListDetails) &&
        Objects.equals(this.page, priceListDetailsResponse.page);
  }

  @Override
  public int hashCode() {
    return Objects.hash(responseInfo, priceListDetails, page);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PriceListDetailsResponse {\n");
    
    sb.append("    responseInfo: ").append(toIndentedString(responseInfo)).append("\n");
    sb.append("    priceListDetails: ").append(toIndentedString(priceListDetails)).append("\n");
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

