package org.egov.hcr.contract;

import org.egov.hcr.contract.SMSRequest.SMSRequestBuilder;
import org.egov.hcr.model.Email;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Setter
@Getter
@ToString

public class EmailRequest {
    private String email;
    private String subject;
    private String body;
    @JsonProperty("isHTML")
    private boolean isHTML;

    public Email toDomain() {
        return Email.builder()
				.toAddress(email)
				.subject(subject)
				.body(body)
				.html(isHTML)
				.build();
    }
}
