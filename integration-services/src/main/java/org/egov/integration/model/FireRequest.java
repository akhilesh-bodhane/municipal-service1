package org.egov.integration.model;

import java.util.List;

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
public class FireRequest {
	
	@JsonProperty("fireNocRequest")
	private FireNoc fireNocRequest;
	
	@JsonProperty("fireNocApplicationRequest")
	private List<FireNocDaoApplication> fireNocApplicationRequest;

	@JsonProperty("fireNocApplicationTasksRequest")
	private List<FireNocDaoApplicationTasks> fireNocApplicationTasksRequest;

}
