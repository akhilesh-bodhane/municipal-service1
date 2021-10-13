package org.egov.pmrefund.pg.models;

import java.util.List;

import org.egov.common.contract.response.ResponseInfo;
import org.egov.pmrefund.pg.models.Transaction;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * <h1>Transaction</h1>
 *
 * @author VISHAL_GENIUS
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TransactionResponse {

    private ResponseInfo responseInfo;

    private List<Transaction> transactions;

}
