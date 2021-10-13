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
public class PriceListResponse   {
  @JsonProperty("ResponseInfo")
  private ResponseInfo responseInfo = null;

  @JsonProperty("priceLists")
  private List<PriceList> priceLists = null;

  @JsonProperty("page")
  private Page page = null;

  public PriceListResponse responseInfo(ResponseInfo responseInfo) {
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

  public PriceListResponse priceLists(List<PriceList> priceLists) {
    this.priceLists = priceLists;
    return this;
  }

  public PriceListResponse addPriceListsItem(PriceList priceListsItem) {
    if (this.priceLists == null) {
      this.priceLists = new ArrayList<PriceList>();
    }
    this.priceLists.add(priceListsItem);
    return this;
  }

   /**
   * Used for search result and create only
   * @return priceLists
  **/
    @Valid

  public List<PriceList> getPriceLists() {
    return priceLists;
  }

  public void setPriceLists(List<PriceList> priceLists) {
    this.priceLists = priceLists;
  }

  public PriceListResponse page(Page page) {
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
    PriceListResponse priceListResponse = (PriceListResponse) o;
    return Objects.equals(this.responseInfo, priceListResponse.responseInfo) &&
        Objects.equals(this.priceLists, priceListResponse.priceLists) &&
        Objects.equals(this.page, priceListResponse.page);
  }

  @Override
  public int hashCode() {
    return Objects.hash(responseInfo, priceLists, page);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PriceListResponse {\n");
    
    sb.append("    responseInfo: ").append(toIndentedString(responseInfo)).append("\n");
    sb.append("    priceLists: ").append(toIndentedString(priceLists)).append("\n");
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

