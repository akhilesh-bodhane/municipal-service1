package org.egov.prscp.web.models;

public class EmailAttachmentFactory
 {
	
	private EmailAttachmentFactory() {
	}


	public static EmailAttachment createEmailAttachment() {
		return new EmailAttachment("", "", "");
	}


	public static EmailAttachment createEmailAttachment2() {
		return new EmailAttachment("0123456789", "0123456789", "0123456789");
	}


	
	public static EmailAttachment createEmailAttachment3() {
		return new EmailAttachment("An??t-1.0.txt", "An??t-1.0.txt", "An??t-1.0.txt");
	}


	public static EmailAttachment createEmailAttachment4() {
		return new EmailAttachment();
	}
}