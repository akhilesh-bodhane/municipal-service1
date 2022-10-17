package org.egov.swservice.model;

import java.util.List;
import java.util.Set;

import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SearchTotalCollectionCriteria {

	@JsonProperty("tenantId")
	private String tenantId;

	@JsonProperty("fromDate")
	private Long fromDate = null;

	@JsonProperty("toDate")
	private Long toDate = null;	
	
	@JsonProperty("usagetype")
	private String usagetype;
	
	@JsonProperty("paymentchannel")
	private String paymentchannel;
	
	@JsonProperty("usagecategory")
	private String usagecategory;
	
	@JsonProperty("connectionchannel")
	private String connectionchannel;
	
	@JsonIgnore
	private List<String> ownerIds;

	public boolean isEmpty() {
		return (StringUtils.isEmpty(this.tenantId)  
				&& StringUtils.isEmpty(this.fromDate)
				&& StringUtils.isEmpty(this.toDate)
				&& StringUtils.isEmpty(this.usagetype) && StringUtils.isEmpty(this.usagetype)
                && StringUtils.isEmpty(this.paymentchannel) && StringUtils.isEmpty(this.paymentchannel)
                 && StringUtils.isEmpty(this.usagecategory) && StringUtils.isEmpty(this.usagecategory)
                  && StringUtils.isEmpty(this.connectionchannel) && StringUtils.isEmpty(this.connectionchannel));
	}

	public boolean tenantIdOnly() {
		return (this.tenantId != null 
				&& this.fromDate == null && this.toDate == null && this.ownerIds == null 
				 && this.usagetype == null && this.paymentchannel == null 
				&& this.usagecategory == null && this.connectionchannel == null);
	}

}
