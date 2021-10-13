package org.egov.prscp.web.models;

import java.util.ArrayList;
import java.util.List;

public class EmailFactory
 {
	
	private EmailFactory() {
	}


	public static Email createEmail() {
		ArrayList<EmailAttachment> list = new ArrayList<EmailAttachment>();
		list.add(new EmailAttachment("", "", ""));
		list.add(new EmailAttachment("0123456789", "0123456789", "0123456789"));
		list.add(new EmailAttachment("An??t-1.0.txt", "An??t-1.0.txt", "An??t-1.0.txt"));
		list.add(new EmailAttachment());
		return new Email("0123456789", "0123456789", "0123456789", true, list);
	}


	public static Email createEmail2() {
		ArrayList<EmailAttachment> list = new ArrayList<EmailAttachment>();
		list.add(new EmailAttachment("", "", ""));
		return new Email("", "", "", false, list);
	}

	public static Email createEmail3() {
		ArrayList<EmailAttachment> list = new ArrayList<EmailAttachment>();
		list.add(new EmailAttachment("0123456789", "0123456789", "0123456789"));
		return new Email("An??t-1.0.txt", "An??t-1.0.txt", (String) null, false, list);
	}


	public static Email createEmail4() {
		ArrayList<EmailAttachment> list = new ArrayList<EmailAttachment>();
		list.add(new EmailAttachment("An??t-1.0.txt", "An??t-1.0.txt", "An??t-1.0.txt"));
		return new Email("", "", "", true, list);
	}


	public static Email createEmail5() {
		ArrayList<EmailAttachment> list = new ArrayList<EmailAttachment>();
		list.add(new EmailAttachment());
		return new Email("0123456789", "0123456789", "An??t-1.0.txt", false, list);
	}
}