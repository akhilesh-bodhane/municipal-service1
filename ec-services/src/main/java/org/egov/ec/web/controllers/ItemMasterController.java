package org.egov.ec.web.controllers;

import javax.validation.Valid;

import org.egov.ec.service.ItemService;
import org.egov.ec.web.models.RequestInfoWrapper;
import org.egov.ec.web.models.ResponseInfoWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/item")
@Slf4j
public class ItemMasterController {

	private final ItemService itemService;

	@Autowired
	public ItemMasterController(ItemService itemService) {
		this.itemService = itemService;
	}

	/**
	* Get  Item Master  controller
	* 
	* @param RequestInfoWrapper object of EcSearchCriteria
	* @return HTTP status 200 on success
	*/
	@PostMapping(value = "/_get")
	public ResponseEntity<ResponseInfoWrapper> getItem(@Valid @RequestBody RequestInfoWrapper requestInfoWrapper) {
		log.info("Entering: " + Thread.currentThread().getStackTrace()[1].getClassName()
				+ "."+ Thread.currentThread().getStackTrace()[1].getMethodName());
		return itemService.getItem(requestInfoWrapper);
	}
	

	/**
	* create  Item Master  controller
	* 
	* @param RequestInfoWrapper List of items
	* @param requestHeader for saving device information
	* @return HTTP status 200 on success
	*/
	@PostMapping(value = "/_create")
	public ResponseEntity<ResponseInfoWrapper> addItem(@RequestBody @Valid @Validated RequestInfoWrapper requestInfoWrapper,@RequestHeader("User-Agent") String requestHeader) {
		log.info("Entering: " + Thread.currentThread().getStackTrace()[1].getClassName()
				+ "."+ Thread.currentThread().getStackTrace()[1].getMethodName());
		return itemService.addItem(requestInfoWrapper,requestHeader);
	}

	/**
	* update  Item Master  controller
	* 
	* @param RequestInfoWrapper object of items
	* 
	* @return HTTP status 200 on success
	*/
	@PostMapping(value = "/_update")
	public ResponseEntity<ResponseInfoWrapper> updateItem(@RequestBody @Valid @Validated RequestInfoWrapper requestInfoWrapper) {
		log.info("Entering: " + Thread.currentThread().getStackTrace()[1].getClassName()
				+ "."+ Thread.currentThread().getStackTrace()[1].getMethodName());
		return itemService.updateItem(requestInfoWrapper);
	}

}
