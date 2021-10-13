package org.egov.nulm.web.controller;

import javax.validation.Valid;

import org.egov.nulm.model.NulmShgRequest;
import org.egov.nulm.model.ResponseInfoWrapper;
import org.egov.nulm.service.SmidShgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/smid/shg")
public class SmidShgController {

	private final SmidShgService service;

	@Autowired
	public SmidShgController(SmidShgService service) {
		this.service = service;
	}
	
	@PostMapping(value = "/_create")
	public ResponseEntity<ResponseInfoWrapper> createGroup(@Valid @RequestBody NulmShgRequest shgrequest) {
		return service.createGroup(shgrequest);
	}
	@PostMapping(value = "/_get")
	public ResponseEntity<ResponseInfoWrapper> getGroup(@Valid @RequestBody NulmShgRequest shgrequest) {
		return service.getGroup(shgrequest);
	}
	@PostMapping(value = "/_update")
	public ResponseEntity<ResponseInfoWrapper> updateGroup( @RequestBody NulmShgRequest shgrequest) {
		return service.updateGroup(shgrequest);
	}
	@PostMapping(value = "/_delete")
	public ResponseEntity<ResponseInfoWrapper> deleteGroup(@Valid @RequestBody NulmShgRequest shgrequest) {
		return service.deleteGroup(shgrequest);
	}
	
	@PostMapping(value = "/_updateAppStatus")
	public ResponseEntity<ResponseInfoWrapper> updateGroupStatus(@Valid @RequestBody NulmShgRequest shgrequest) {
		return service.updateGroupStatus(shgrequest);
	}
	@PostMapping(value = "/_forwardToApproval")
	public ResponseEntity<ResponseInfoWrapper> forwardToApproval(@Valid @RequestBody NulmShgRequest shgrequest) {
		return service.forwardToApproval(shgrequest);
	}
	

	
	
}
