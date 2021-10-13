package org.egov.prscp.web.models;

import org.json.simple.JSONArray;

public class DocumentListFactory
 {

	private DocumentListFactory() {
	}


	public static DocumentList createDocumentList() {
		return new DocumentList("", new JSONArray(), "");
	}

	public static DocumentList createDocumentList2() {
		return new DocumentList("0123456789", (JSONArray) null, "0123456789");
	}


	public static DocumentList createDocumentList3() {
		return new DocumentList();
	}



	public static DocumentList createDocumentList4() {
		return new DocumentList((String) null, new JSONArray(), "An??t-1.0.txt");
	}
}