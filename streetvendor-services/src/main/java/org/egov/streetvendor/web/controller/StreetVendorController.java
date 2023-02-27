package org.egov.streetvendor.web.controller;

import javax.validation.Valid;
import org.egov.streetvendor.model.RequestInfoWrapper;
import org.egov.streetvendor.model.ResponseInfoWrapper;
import org.egov.streetvendor.model.StreetVendorData;
import org.egov.streetvendor.model.StreetVendorRequest;
import org.egov.streetvendor.service.StreetVendorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/streetvendor")
public class StreetVendorController {

	private final StreetVendorService streetVendorService;

	@Autowired
	public StreetVendorController(StreetVendorService streetVendorService) {
		this.streetVendorService = streetVendorService;
	}

	@PostMapping(value = "/_create")
	public ResponseEntity<ResponseInfoWrapper> createStreetVendorData(
			@Valid @RequestBody RequestInfoWrapper requestInfoWrapper) {
		return streetVendorService.createStreetVendorData(requestInfoWrapper);
	}

	@PostMapping(value = "/_get")
	public ResponseEntity<ResponseInfoWrapper> getStreetVendorData(@ModelAttribute StreetVendorData streetVendorData) {
		return streetVendorService.getStreetVendorDataList(streetVendorData);
	}

	@PostMapping(value = "/_getdetails")
	public ResponseEntity<ResponseInfoWrapper> getStreetVendorDataDetails(
			@ModelAttribute StreetVendorData streetVendorData) {
		return streetVendorService.getStreetVendorDataDataDetails(streetVendorData);
	}
	
	@PostMapping(value = "/_update")
	public ResponseEntity<ResponseInfoWrapper> updateStreetVendorData(@RequestBody StreetVendorRequest streetVendorRequest){
	    return streetVendorService.updateStreetVendorData(streetVendorRequest);
	}

}
