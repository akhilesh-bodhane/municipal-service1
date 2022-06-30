package org.egov.sterilizationdog.model;

import java.util.List;

import javax.validation.constraints.NotNull;

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
public class SterilizationDogApplication {
	
	private String applicationUuid ;
	
	private String applicationId ;
	
	@NotNull
	@JsonProperty("tenantId")
	private String tenantId ;
	
	@JsonProperty("pick")
	private Boolean pick;
	
	@JsonProperty("release")
	private Boolean release;
	
	@JsonProperty("picksector")
	private String picksector;
	
	@JsonProperty("pickgender")
	private String pickgender;
	
	@JsonProperty("pickhouseno")
	private String pickhouseno;
	
	@JsonProperty("picklatitude")
	private String picklatitude;
	
	@JsonProperty("picklongitude")
	private String picklongitude;
	
	@JsonProperty("dogcolor")
	private String dogcolor;
	
	@JsonProperty("picktype")
	private String picktype;
	
	@JsonProperty("dropsector")
	private String dropsector;
	
	@JsonProperty("dropgender")
	private String dropgender;
	
	@JsonProperty("drophouseno")
	private String drophouseno;
	
	@JsonProperty("droplatitude")
	private String droplatitude;
	
	@JsonProperty("droplongitude")
	private String droplongitude;
	
	
	@JsonProperty("isActive")
	private Boolean isActive ;
	
	@JsonProperty("applicationstatus")
	private String applicationstatus;
	
	
	@JsonProperty("applicationDocument")
	private List<SterilizationDogDocument> applicationDocument;
	
	@JsonProperty("auditDetails")
	private AuditDetails auditDetails ;
	
}
