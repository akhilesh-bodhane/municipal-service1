package org.egov.nulm.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;
import org.json.simple.JSONArray;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class SuhFacilitiesDetails {

	private String suhUuid;

	private String facilityUuid;

	@JsonProperty("isBedding")
	private Boolean isBedding;

	@JsonProperty("beddingRemark")
	private String beddingRemark;

	@JsonProperty("isWashingOfLinen")
	private Boolean isWashingOfLinen;

	@JsonProperty("washingOfLinenRemark")
	private String washingOfLinenRemark;

	@JsonProperty("isCleaningOfPremises")
	private Boolean isCleaningOfPremises;

	@JsonProperty("cleaningOfPremiseRemark")
	private String cleaningOfPremiseRemark;

	@JsonProperty("isRecreationfacilities")
	private Boolean isRecreationfacilities;

	@JsonProperty("recreationfacilitiesRemark")
	private String recreationfacilitiesRemark;

	@JsonProperty("isDrinkingWater")
	private Boolean isDrinkingWater;

	@JsonProperty("drinkingWaterRemark")
	private String drinkingWaterRemark;

	@JsonProperty("isMeals")
	private Boolean isMeals;

	@JsonProperty("mealsRemark")
	private String mealsRemark;

	@JsonProperty("isLockerForInmates")
	private Boolean isLockerForInmates;

	@JsonProperty("lockerForInmatetRemark")
	private String lockerForInmatetRemark;

	@JsonProperty("isFireSafetyMeasure")
	private Boolean isFireSafetyMeasure;

	@JsonProperty("fireSafetyMeasureRemark")
	private String fireSafetyMeasureRemark;

	@JsonProperty("isOfficeSetUp")
	private Boolean isOfficeSetUp;

	@JsonProperty("officeSetUpRemark")
	private String officeSetUpRemark;

	@JsonProperty("isFirstAidKitAndTrainingToStaff")
	private Boolean isFirstAidKitAndTrainingToStaff;

	@JsonProperty("firstAidKitAndTrainingToStaffRemark")
	private String firstAidKitAndTrainingToStaffRemark;

	@JsonProperty("isDisplayOfEmergencyNumbers")
	private Boolean isDisplayOfEmergencyNumbers;

	@JsonProperty("displayOfEmergencyNumbersRemark")
	private String displayOfEmergencyNumbersRemark;

	@JsonProperty("isToilet")
	private Boolean isToilet;

	@JsonProperty("toiletRemark")
	private String toiletRemark;

	@JsonProperty("facilityPicture")
	private JSONArray facilityPicture;
	
	private String facilityPictureDoc;

	@NotNull
	@JsonProperty("tenantId")
	private String tenantId;

	@JsonProperty("isActive")
	private Boolean isActive;

	@JsonProperty("auditDetails")
	private AuditDetails auditDetails;

}
