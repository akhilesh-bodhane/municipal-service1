package org.egov.assets.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.egov.common.contract.request.RequestInfo;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Contract class for web request. Array of Indent items are used in case of
 * create or update
 */
public class TransferIndentNoteRequest {
	@JsonProperty("RequestInfo")
	private RequestInfo requestInfo = null;

	@JsonProperty("transferIndentNotes")
	private List<Indent> transferIndentNotes = new ArrayList<Indent>();

	public TransferIndentNoteRequest requestInfo(RequestInfo requestInfo) {
		this.requestInfo = requestInfo;
		return this;
	}

	/**
	 * Get requestInfo
	 * 
	 * @return requestInfo
	 **/
	
	@NotNull
	@Valid
	public RequestInfo getRequestInfo() {
		return requestInfo;
	}

	public void setRequestInfo(RequestInfo requestInfo) {
		this.requestInfo = requestInfo;
	}

	public TransferIndentNoteRequest transferIndentNotes(List<Indent> transferIndentNotes) {
		this.transferIndentNotes = transferIndentNotes;
		return this;
	}

	public TransferIndentNoteRequest addTransferIndentNotesItem(Indent transferIndentNotesItem) {
		this.transferIndentNotes.add(transferIndentNotesItem);
		return this;
	}

	/**
	 * Used for search result and create only
	 * 
	 * @return transferIndentNotes
	 **/
	@NotNull
	@Valid
	public List<Indent> getTransferIndentNotes() {
		return transferIndentNotes;
	}

	public void setTransferIndentNotes(List<Indent> transferIndentNotes) {
		this.transferIndentNotes = transferIndentNotes;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		TransferIndentNoteRequest transferIndentNoteRequest = (TransferIndentNoteRequest) o;
		return Objects.equals(this.requestInfo, transferIndentNoteRequest.requestInfo)
				&& Objects.equals(this.transferIndentNotes, transferIndentNoteRequest.transferIndentNotes);
	}

	@Override
	public int hashCode() {
		return Objects.hash(requestInfo, transferIndentNotes);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class TransferIndentNoteRequest {\n");

		sb.append("    requestInfo: ").append(toIndentedString(requestInfo)).append("\n");
		sb.append("    transferIndentNotes: ").append(toIndentedString(transferIndentNotes)).append("\n");
		sb.append("}");
		return sb.toString();
	}

	/**
	 * Convert the given object to string with each line indented by 4 spaces
	 * (except the first line).
	 */
	private String toIndentedString(java.lang.Object o) {
		if (o == null) {
			return "null";
		}
		return o.toString().replace("\n", "\n    ");
	}
}
