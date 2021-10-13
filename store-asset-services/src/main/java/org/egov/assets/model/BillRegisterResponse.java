package org.egov.assets.model;

import lombok.*;

import org.egov.assets.common.Pagination;
import org.egov.common.contract.response.ResponseInfo;

import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class BillRegisterResponse {

    private ResponseInfo responseInfo;

    private List<BillRegister> billRegisters;

    private Pagination page;
}