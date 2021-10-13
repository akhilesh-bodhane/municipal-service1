package org.egov.assets.service;

import org.egov.assets.common.MdmsRepository;
import org.egov.assets.model.BankContract;
import org.egov.common.contract.request.RequestInfo;
import org.egov.tracer.model.CustomException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BankContractRepository {

	@Autowired
	private MdmsRepository mdmsRepository;

	public BankContract findById(BankContract bankContract, RequestInfo requestInfo) {

		BankContract bankContractResponse = (BankContract) mdmsRepository.fetchObject(bankContract.getTenantId(),
				"store-asset", "BankCodes", "id", bankContract.getId(), BankContract.class, requestInfo);

		if (bankContractResponse != null) {
			return bankContractResponse;
		} else {
			throw new CustomException("Bank", "Bank Id " + bankContract.getId() + " doesnt exist");
		}

	}

	public BankContract findByCode(BankContract bankContract, RequestInfo requestInfo) {
		BankContract bankContractResponse = (BankContract) mdmsRepository.fetchObject(bankContract.getTenantId(),
				"store-asset", "BankCodes", "code", bankContract.getCode(), BankContract.class, requestInfo);

		if (bankContractResponse != null) {
			return bankContractResponse;
		} else {
			throw new CustomException("Bank", "Bank Code " + bankContract.getCode() + " doesnt exist");
		}

	}
}