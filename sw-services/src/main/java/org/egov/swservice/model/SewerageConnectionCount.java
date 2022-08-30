package org.egov.swservice.model;

import java.util.Objects;

import javax.validation.Valid;
//
//import org.egov.cpt.models.AuditDetails;
//import org.egov.cpt.models.Document;
import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * SewerageConnection
 */
@Validated
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-03-13T11:29:47.358+05:30[Asia/Kolkata]")
public class SewerageConnectionCount  {
	
	
	@JsonProperty("paymentmode")
	private String paymentmode = null;	

//	@JsonProperty("div")
//	private String div = null;

	@JsonProperty("subdiv")
	private String subdiv = null;

//	@JsonProperty("connectionNo")
//	private String connectionNo = null;
//	
//	@JsonProperty("propertyId")
//	private String propertyId = null;
//	
//	@JsonProperty("applicationNo")
//	private String applicationNo = null;

	

	@JsonProperty("activityType")
	private String activityType = null;

	

	@JsonProperty("totalAmountPaid")
	private String totalAmountPaid;
	
	
	
	@JsonProperty("applicationStatus")
	private String applicationStatus = null;
	
	@JsonProperty("auditDetails")
	private AuditDetails auditDetails = null;


//	public String getDiv() {
//		return div;
//	}
//
//	public void setDiv(String div) {
//		this.div = div;
//	}
//
//	public String getSubdiv() {
//		return subdiv;
//	}
//
//	public void setSubdiv(String subdiv) {
//		this.subdiv = subdiv;
//	}

//	
//	public String getPaymentmode() {
//		return paymentmode;
//	}
//
//	public void setPaymentmode(String paymentmode) {
//		this.paymentmode = paymentmode;
//	}
//
//	
//
//	public String getActivityType() {
//		return activityType;
//	}
//
//	public void setActivityType(String activityType) {
//		this.activityType = activityType;
//	}

	

	/**
	 * Get noOfWaterClosets
	 * 
	 * @return noOfWaterClosets
	 **/
	

	/**
	 * Get proposedWaterClosets
	 * 
	 * @return proposedWaterClosets
	 **/
	
	/**
	 * Get noOfToilets
	 * 
	 * @return noOfToilets
	 **/
	

	/**
	 * Get proposedToilets
	 * 
	 * @return proposedToilets
	 **/
//	@ApiModelProperty(value = "")

	

//	@Override
//	public boolean equals(java.lang.Object o) {
//		if (this == o) {
//			return true;
//		}
//		if (o == null || getClass() != o.getClass()) {
//			return false;
//		}
//		SewerageConnectionCount sewerageConnection = (SewerageConnectionCount) o;
//		return Objects.equals(this.noOfWaterClosets, sewerageConnection.noOfWaterClosets)
//				&& Objects.equals(this.proposedWaterClosets, sewerageConnection.proposedWaterClosets)
//				&& Objects.equals(this.noOfToilets, sewerageConnection.noOfToilets)
//				&& Objects.equals(this.proposedToilets, sewerageConnection.proposedToilets) && super.equals(o);
//	}

//	@Override
//	public int hashCode() {
//		return Objects.hash(noOfWaterClosets, proposedWaterClosets, noOfToilets, proposedToilets, super.hashCode());
//	}

//	@Override
//	public String toString() {
//		StringBuilder sb = new StringBuilder();
//		sb.append("class SewerageConnection {\n");
//		sb.append("    ").append(toIndentedString(super.toString())).append("\n");
////		sb.append("    noOfWaterClosets: ").append(toIndentedString(noOfWaterClosets)).append("\n");
////		sb.append("    proposedWaterClosets: ").append(toIndentedString(proposedWaterClosets)).append("\n");
////		sb.append("    noOfToilets: ").append(toIndentedString(noOfToilets)).append("\n");
////		sb.append("    proposedToilets: ").append(toIndentedString(proposedToilets)).append("\n");
//		sb.append("}");
//		return sb.toString();
//	}

	/**
	 * Convert the given object to string with each line indented by 4 spaces
	 * (except the first line).
	 */
//	private String toIndentedString(java.lang.Object o) {
//		if (o == null) {
//			return "null";
//		}
//		return o.toString().replace("\n", "\n    ");
//	}
//
//	public String getTotalAmountPaid() {
//		return totalAmountPaid;
//	}
//
//	public void setTotalAmountPaid(String totalAmountPaid) {
//		this.totalAmountPaid = totalAmountPaid;
//	}
}
