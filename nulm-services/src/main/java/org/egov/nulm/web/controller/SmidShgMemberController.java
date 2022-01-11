package org.egov.nulm.web.controller;

import javax.validation.Valid;

import org.egov.nulm.model.NulmShgMemberRequest;
import org.egov.nulm.model.NulmShgRequest;
import org.egov.nulm.model.ResponseInfoWrapper;
import org.egov.nulm.service.SmidShgMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/smid/shg/member")
public class SmidShgMemberController {

	private final SmidShgMemberService service;

	@Autowired
	public SmidShgMemberController(SmidShgMemberService service) {
		this.service = service;
	}
	
	@PostMapping(value = "/_create")
	public ResponseEntity<ResponseInfoWrapper> createMembers(@Valid @RequestBody NulmShgMemberRequest memberrequest) {
		return service.createMembers(memberrequest);
	}
	@PostMapping(value = "/_update")
	public ResponseEntity<ResponseInfoWrapper> updateMembers(@Valid @RequestBody NulmShgMemberRequest memberrequest) {
		return service.updateMembers(memberrequest);
	}
	
	@PostMapping(value = "/_get")
	public ResponseEntity<ResponseInfoWrapper> getMembers(@Valid @RequestBody NulmShgMemberRequest memberrequest) {
		return service.getMembers(memberrequest);
	}
	@PostMapping(value = "/_delete")
	public ResponseEntity<ResponseInfoWrapper> deleteMembers(@Valid @RequestBody NulmShgMemberRequest memberrequest) {
		return service.deleteMembers(memberrequest);
	}
	@PostMapping(value = "/_memberCount")
	public ResponseEntity<ResponseInfoWrapper> memberCount(@RequestBody NulmShgMemberRequest memberrequest) {
		return service.memberCount(memberrequest);
	}
	
}
