package org.egov.pm.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class EmailTemplateModel {

	private String tenantId;
	private String template;
	private String status;
	private String roles;
	private String applicationType;
	private String smsTemplate;
	private String emailSubject;


	public int hashCode() {
		int hashcode = 99;
		hashcode += tenantId.hashCode() + status.hashCode() + applicationType.hashCode();
		return hashcode;
	}

	public boolean equals(Object obj) {
		if (obj instanceof EmailTemplateModel) {
			EmailTemplateModel pp = (EmailTemplateModel) obj;
			return (pp.tenantId.equals(this.tenantId) && pp.template == this.template && pp.status == this.status
					&& pp.applicationType == this.applicationType);
		} else {
			return false;
		}
	}

}
