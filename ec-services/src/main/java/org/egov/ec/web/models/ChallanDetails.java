package org.egov.ec.web.models;


	import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
	@Validated
	@Getter
	@Setter
	@AllArgsConstructor
	@NoArgsConstructor
	@Builder
	public class ChallanDetails {
		  
		@Size(max = 64)
		@JsonProperty("challanDetailUuid")
		private String challanDetailUuid;
		
		@Size(max = 64)
		@NotNull(message = "challanUuid  should not be empty or null")
		@JsonProperty("challanUuid")
		private String challanUuid;
		
		@JsonProperty("tenantId")
		private String tenantId;
		
		@JsonProperty("budgetHead")
		private String budgetHead;
		
		@Size(max = 256)
		@JsonProperty("headAmount")
		private String headAmount;
		
		@JsonProperty("isActive")
		private Boolean isActive;
		
		@Size(max = 256)
		@JsonProperty("createdBy")
		private String createdBy;
		
		@JsonProperty("createdTime")
		@NotNull(message = "createdTime  should not be empty or null")
		private Long createdTime;
		
		@Size(max = 256)
		@JsonProperty("lastModifiedBy")
		private String lastModifiedBy;
		
		@JsonProperty("lastModifiedTime")
		@NotNull(message = "lastModifiedTime  should not be empty or null")
		private Long lastModifiedTime;

	}

