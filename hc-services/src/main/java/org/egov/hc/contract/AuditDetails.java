package org.egov.hc.contract;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModel;

import com.fasterxml.jackson.annotation.JsonCreator;

import javax.validation.Valid;
import javax.validation.constraints.*;

import org.springframework.validation.annotation.Validated;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Builder;

/**
 * Collection of audit related fields used by most models
 */
@ApiModel(description = "Collection of audit related fields used by most models")
@Validated
@javax.annotation.Generated(value = "org.egov.codegen.SpringBootCodegen", date = "2018-09-18T17:06:11.263+05:30")

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AuditDetails   {

        @Size(max=64)
        @JsonProperty("createdBy")
        private String createdBy;

        @Size(max=64)
        @JsonProperty("lastModifiedBy")
        private String lastModifiedBy;

        @JsonProperty("createdTime")
        private Long createdTime;

        @JsonProperty("lastModifiedTime")
        private Long lastModifiedTime;


}

