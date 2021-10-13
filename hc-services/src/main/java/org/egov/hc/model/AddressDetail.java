package org.egov.hc.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.egov.hc.model.AuditDetails;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AddressDetail {

//	@JsonProperty("uuid")
//	public String uuid;

	@JsonProperty("houseNoAndStreetName")
	public String houseNoAndStreetName;

	@NotNull
	@JsonProperty("mohalla")
	public String mohalla;
	
	@JsonProperty("locality")
	public String locality;

	@NotNull
	@JsonProperty("city")
	public String city;

	@Size(max=257)
	@JsonProperty("latitude")
	private String latitude;
	
	@Size(max=257)
	@JsonProperty("longitude")
	private String longitude;

	@JsonProperty("landmark")
	public String landmark;
	
	@JsonProperty("tenantId")
	public String tenantId;
	
	@JsonProperty("auditDetails")
	public AuditDetails auditDetails;

}
