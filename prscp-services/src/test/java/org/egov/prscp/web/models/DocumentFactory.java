package org.egov.prscp.web.models;


public class DocumentFactory
 {
	private DocumentFactory() {
	}

	public static Document createDocument() {
		return new Document("", "", "", "", "", new AuditDetails("", "", new Long(-1L), new Long(-1L)));
	}

	public static Document createDocument2() {
		return new Document("0123456789", "0123456789", "0123456789", "0123456789", "", new AuditDetails((String) null, (String) null, new Long(Long.MAX_VALUE), new Long(Long.MAX_VALUE)));
	}


	public static Document createDocument3() {
		return new Document("0123456789", "0123456789", "0123456789", "0123456789", "0123456789", new AuditDetails("0123456789", "0123456789", new Long(0L), new Long(0L)));
	}


	public static Document createDocument4() {
		return new Document("An??t-1.0.txt", "An??t-1.0.txt", "An??t-1.0.txt", "An??t-1.0.txt", "0123456789", (AuditDetails) null);
	}


	public static Document createDocument5() {
		return new Document("An??t-1.0.txt", "An??t-1.0.txt", "An??t-1.0.txt", "An??t-1.0.txt", "An??t-1.0.txt", new AuditDetails("An??t-1.0.txt", "An??t-1.0.txt", new Long(1L), new Long(1L)));
	}


	public static Document createDocument6() {
		return new Document();
	}


	public static Document createDocument7() {
		return new Document((String) null, (String) null, (String) null, (String) null, (String) null, new AuditDetails());
	}
}