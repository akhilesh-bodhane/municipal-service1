package org.egov.assets.wf.model;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.egov.assets.model.Document;
import org.egov.common.contract.request.User;
import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * A Object holds the basic data for a Trade License
 */
@ApiModel(description = "A Object holds the basic data for a Trade License")
@Validated
@javax.annotation.Generated(value = "org.egov.codegen.SpringBootCodegen", date = "2018-12-04T11:26:25.532+05:30")

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode(of = {"id"})
@ToString
public class ProcessInstance   {

        @Size(max=64)
        @JsonProperty("id")
        private String id = null;

        @NotNull
        @Size(max=128)
        @JsonProperty("tenantId")
        private String tenantId = null;

        @NotNull
        @Size(max=128)
        @JsonProperty("businessService")
        private String businessService = null;

        @NotNull
        @Size(max=128)
        @JsonProperty("businessId")
        private String businessId = null;

        @NotNull
        @Size(max=128)
        @JsonProperty("action")
        private String action = null;

        @NotNull
        @Size(max=64)
        @JsonProperty("moduleName")
        private String moduleName = null;

        @JsonProperty("state")
        private State state = null;

        @JsonProperty("comment")
        private String comment = null;

        @JsonProperty("documents")
        @Valid
        private List<Document> documents = null;

        @JsonProperty("assigner")
        private User assigner = null;

        @JsonProperty("assignee")
        private User assignee = null;

        @JsonProperty("stateSla")
        private Long stateSla = null;

        @JsonProperty("businesssServiceSla")
        private Long businesssServiceSla = null;

        @JsonProperty("previousStatus")
        @Size(max=128)
        private String previousStatus = null;

        @JsonProperty("entity")
        private Object entity = null;

        private AuditDetails auditDetails;


}

