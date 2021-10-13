package org.egov.pmrefund.pg.models;

import java.util.List;

import org.egov.common.contract.request.RequestInfo;
import org.egov.pmrefund.pg.models.Transaction;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * <h1>TransactionRequest</h1>
 * 
 * @author VISHAL_GENIUS
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TransactionRequest {

	@JsonProperty("RequestInfo")
	private RequestInfo requestInfo;

	private List<Transaction> transaction;

}
