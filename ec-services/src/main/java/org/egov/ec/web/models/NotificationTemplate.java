package org.egov.ec.web.models;

import java.util.List;

import org.egov.ec.web.models.ItemMaster.ItemMasterBuilder;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class NotificationTemplate {
	
	@JsonProperty("email")
	private String email;
	
	@JsonProperty("subject")
	private String subject;
	
	@JsonProperty("body")
	private String body;
	
	@JsonProperty("attachments")
	private List<EmailAttachment> attachments;
	
	@JsonProperty("mobileNumber")
	private Long mobileNumber;
	
	@JsonProperty("message")
	private String message;
	
	@JsonProperty("isHTML")
	private Boolean isHTML;
}
