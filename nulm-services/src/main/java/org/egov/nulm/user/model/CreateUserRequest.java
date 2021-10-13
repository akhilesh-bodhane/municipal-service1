package org.egov.nulm.user.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import org.egov.common.contract.request.RequestInfo;

import com.fasterxml.jackson.annotation.JsonProperty;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class CreateUserRequest {
	 @JsonProperty("RequestInfo")
    private RequestInfo requestInfo;
	 
	 @JsonProperty("user")
    private UserRequest user;}


