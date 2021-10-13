package org.egov.ec.web.models;

import java.util.List;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;
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
public class StoreItemRegister {
	@Size(max = 64)
	@JsonProperty("storeItemUuid")
	private String storeItemUuid;
	
	@Size(max = 256)
	@NotNull(message = "Tenant Id should not be empty or null")
	@NotBlank(message = "Tenant Id should not be empty or null")	
	@JsonProperty("tenantId")
	private String tenantId;
	
	@JsonProperty("challanId")
	@NotNull(message = "challanId should not be empty or null")
	@NotBlank(message = "challanId should not be empty or null")
	private String challanId;
	
	@Size(max = 64)
	@JsonProperty("challanUuid")
	private String challanUuid;
	
	@Size(max = 64)
	@JsonProperty("itemUuid")
	private String itemUuid;
	
	@JsonProperty("itemName")
	@NotBlank(message = "itemName should not be empty or null")
	@NotNull(message = "itemName should not be empty or null")
	private String itemName;
	
	@JsonProperty("quantity")
	@NotNull(message = "quantity should not be empty or null")
	@NotBlank(message = "quantity should not be empty or null")
	private Long quantity;
	
	@JsonProperty("auctionedQuantity")
	private Long auctionedQuantity;
	
	@JsonProperty("isVerified")
	@NotNull(message = "isVerified should not be empty or null")
	private Boolean isVerified;
	
	@JsonProperty("isAuctioned")
	@NotNull(message = "isAuctioned should not be empty or null")
	private Boolean isAuctioned;
	
	@JsonProperty("isReturned")
	private Boolean isReturned;
	
	@JsonProperty("remark")
	private String remark;
	
	@JsonProperty("itemStoreDepositDate")
	@NotNull(message = "itemStoreDepositDate should not be empty or null")
	@NotBlank(message = "itemStoreDepositDate should not be empty or null")
	private String itemStoreDepositDate;
	
	@Size(max = 64)
	@JsonProperty("violationItemUuid")
	@NotNull(message = "violationItemUuid  should not be empty or null")
	@NotBlank(message = "violationItemUuid  should not be empty or null")
	private String violationItemUuid;
	
	@Size(max = 64)
	@JsonProperty("violationUuid")
	@NotNull(message = "violationUuid  should not be empty or null")
	@NotBlank(message = "violationUuid  should not be empty or null")
	private String violationUuid;
	
	@JsonProperty("isActive")
	@NotNull(message = "isActive  should not be empty or null")
	@NotBlank(message = "isActive  should not be empty or null")
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
	
	@Size(max = 256)
	@JsonProperty("status")
	private String status;
	
	@Size(max = 256)
	@JsonProperty("paymentMode")
	private String paymentMode;
	
	@JsonProperty("lastModifiedTime")
	@NotNull(message = "Last Modified Time should not be empty or null")
	private Long lastModifiedTime;
	
	@JsonProperty("sourceUuid")
	private String sourceUuid;
	
	@JsonProperty("storeItemRegister")
	private List<StoreItemRegister> storeItemRegister;
	
	@JsonProperty("document")
	private List<Document> document;
	
	@JsonProperty("damagedQuantity")
	@NotNull(message = "damagedQuantity should not be empty or null")
	@NotBlank(message = "damagedQuantity should not be empty or null")
	private Long damagedQuantity;

	
}
