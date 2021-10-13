package org.egov.ec.web.models;

import java.util.List;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@ApiModel(description= "Auction Detail Model")

@Validated
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Auction {

	@Size(max = 64)
	@JsonProperty("auctionUuid")
	private String auctionUuid;
	
	@Size(max = 64)
	@JsonProperty("auctionDetailUuid")
	private String auctionDetailUuid;

	@Size(max = 256,message="Size Cannot be more than 256 characters")
	@JsonProperty("storeItemUuid")
	private String storeItemUuid;

	@Size(max = 256)
	@NotNull(message = "purchaser Name  should not be empty or null")
	@NotBlank(message = "purchaser Name  should not be empty or null")
	@JsonProperty("purchaserName")
	private String purchaserName;
	
	@Size(max = 256)
	@JsonProperty("challanId")
	@NotNull(message = "Challan ID  should not be empty or null")
	@NotBlank(message = "Challan ID  should not be empty or null")
	private String challanId;

	@JsonProperty("auctionAmount")
	@NotNull(message = "auction amount should not be empty or null")
	@NotBlank(message = "auction amount should not be empty or null")
	private String auctionAmount;
	
	@JsonProperty("auctionQuantity")
	private Integer auctionQuantity;

	@Size(max = 256)
	@JsonProperty("challanUuid")
	@NotNull(message = "challan Uuid should not be empty or null")
	@NotBlank(message = "challan Uuid should not be empty or null")
	private String challanUuid;

	@Size(max = 256)
	@JsonProperty("tenantId")
	@NotNull(message = "Tenant Id should not be empty or null")
	@NotBlank(message = "Tenant Id should not be empty or null")
	private String tenantId;

	@Size(max = 64)
	@JsonProperty("violationItemUuid")
	@NotNull(message = "violation Item Uuid should not be empty or null")
	@NotBlank(message = "violation Item Uuid should not be empty or null")
	private String violationItemUuid;

	@Size(max = 64)
	@JsonProperty("violationUuid")
	@NotNull(message = "violation  Uuid should not be empty or null")
	@NotBlank(message = "violation  Uuid should not be empty or null")
	private String violationUuid;

	@JsonProperty("isActive")
	@NotNull(message = "isActive should not be empty or null")
	private Boolean isActive;
	
	@JsonProperty("isAuctioned")
	@NotNull(message = "isAuctioned should not be empty or null")
	private Boolean isAuctioned;

	@Size(max = 256)
	@JsonProperty("createdBy")
	private String createdBy;

	@JsonProperty("createdTime")
	@NotNull(message = "createdTime should not be empty or null")
	@NotBlank(message = "createdTime should not be empty or null")
	private Long createdTime;

	@Size(max = 256)
	@JsonProperty("lastModifiedBy")
	private String lastModifiedBy;

	@Size(max = 256)
	@JsonProperty("status")
	private String status;

	@JsonProperty("lastModifiedTime")
	@NotNull(message = "Last Modified Time should not be empty or null")
	@NotBlank(message = "Last Modified Time should not be empty or null")
	private Long lastModifiedTime;

	@JsonProperty("sourceUuid")
	private String sourceUuid;
	
	@JsonProperty("auctionList")
	private List<Auction> auctionList;

	@JsonProperty("auctionDate")
	private String auctionDate;

	@JsonProperty("purchaserContactNo")
	private String purchaserContactNo;
	
	@JsonProperty("encroachmentType")
	private String encroachmentType;
	
	@JsonProperty("violationDate")
	private String violationDate;
	
	@JsonProperty("violatorName")
	private String violatorName;
	
	@JsonProperty("contactNumber")
	private String contactNumber;
	
	@JsonProperty("siName")
	private String siName;
	
	@JsonProperty("sector")
	private String sector;
	
	@JsonProperty("itemName")
	private String itemName;


}
