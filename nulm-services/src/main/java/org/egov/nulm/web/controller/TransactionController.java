package org.egov.nulm.web.controller;

import javax.validation.Valid;

import org.egov.nulm.model.NulmSusvRequest;
import org.egov.nulm.model.NulmSusvTransactionRequest;
import org.egov.nulm.model.ResponseInfoWrapper;
import org.egov.nulm.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/susv/transaction")
public class TransactionController {

	private final TransactionService service;

	@Autowired
	public TransactionController(TransactionService service) {
		this.service = service;
	}
	
	@PostMapping(value = "/_create")
	public ResponseEntity<ResponseInfoWrapper> createTransaction(@Valid @RequestBody NulmSusvTransactionRequest request) {
		return service.createTransaction(request);
	}
	
	@PostMapping(value = "/_update")
	public ResponseEntity<ResponseInfoWrapper> updateTransaction(@Valid @RequestBody NulmSusvTransactionRequest request) {
		return service.updateTransaction(request);
	}
	 @PostMapping(value = "/_get")
		public ResponseEntity<ResponseInfoWrapper> getTransaction( @RequestBody NulmSusvTransactionRequest request) {
			return service.getTransaction(request);
		}
		
	
}
