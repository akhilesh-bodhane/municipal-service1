package org.egov.assets.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.egov.common.contract.request.RequestInfo;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * PurchaseOrderRequest
 */

public class PurchaseOrderRequest   {
  @JsonProperty("RequestInfo")
  private RequestInfo requestInfo = null;

  @JsonProperty("purchaseOrders")
  private List<PurchaseOrder> purchaseOrders = new ArrayList<PurchaseOrder>();

	@JsonProperty("workFlowDetails")
	private WorkFlowDetails workFlowDetails;

	public PurchaseOrderRequest workFlowDetails(WorkFlowDetails workFlowDetails) {
		this.workFlowDetails = workFlowDetails;
		return this;
	}

	public WorkFlowDetails getWorkFlowDetails() {
		return workFlowDetails;
	}

	public void setWorkFlowDetails(WorkFlowDetails workFlowDetails) {
		this.workFlowDetails = workFlowDetails;
	}

  public PurchaseOrderRequest requestInfo(RequestInfo requestInfo) {
    this.requestInfo = requestInfo;
    return this;
  }

   /**
   * Get requestInfo
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

  public PurchaseOrderRequest purchaseOrders(List<PurchaseOrder> purchaseOrders) {
    this.purchaseOrders = purchaseOrders;
    return this;
  }

  public PurchaseOrderRequest addPurchaseOrdersItem(PurchaseOrder purchaseOrdersItem) {
    this.purchaseOrders.add(purchaseOrdersItem);
    return this;
  }

   /**
   * Used for search result and create only
   * @return purchaseOrders
  **/
  
  @NotNull

  @Valid

  public List<PurchaseOrder> getPurchaseOrders() {
    return purchaseOrders;
  }

  public void setPurchaseOrders(List<PurchaseOrder> purchaseOrders) {
    this.purchaseOrders = purchaseOrders;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PurchaseOrderRequest purchaseOrderRequest = (PurchaseOrderRequest) o;
    return Objects.equals(this.requestInfo, purchaseOrderRequest.requestInfo) &&
        Objects.equals(this.purchaseOrders, purchaseOrderRequest.purchaseOrders);
  }

  @Override
  public int hashCode() {
    return Objects.hash(requestInfo, purchaseOrders);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PurchaseOrderRequest {\n");
    
    sb.append("    requestInfo: ").append(toIndentedString(requestInfo)).append("\n");
    sb.append("    purchaseOrders: ").append(toIndentedString(purchaseOrders)).append("\n");
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

