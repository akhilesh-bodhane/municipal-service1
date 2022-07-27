package org.egov.nulm.web.controller;

import java.io.IOException;

import javax.validation.Valid;

import org.egov.nulm.model.NulmAlfMemberRequest;
import org.egov.nulm.model.NulmShgRequest;
import org.egov.nulm.model.ResponseInfoWrapper;
import org.egov.nulm.service.SmidAlfMemberService;
//import org.egov.prscp.web.models.RequestInfoWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/smid/alf/member")
public class SmidALFMemberController {

	private final SmidAlfMemberService service;

	@Autowired
	public SmidALFMemberController(SmidAlfMemberService service) {
		this.service = service;
	}
	
	@PostMapping(value = "/_upload")
	public ResponseEntity<ResponseInfoWrapper> uplaodExternalUser(@Valid @RequestBody NulmAlfMemberRequest memberrequest)
			throws IOException {
		return service.uplaodExternalGuest(memberrequest);
	}
	

	@PostMapping(value = "/_read")
	public ResponseEntity<ResponseInfoWrapper> readExternalUser(@Valid @RequestBody NulmAlfMemberRequest memberrequest)
			throws IOException {
		return service.readExternalGuest(memberrequest);
	}
	@PostMapping(value = "/_create")
	public ResponseEntity<ResponseInfoWrapper> createMembers(@Valid @RequestBody NulmAlfMemberRequest memberrequest) {
		return service.createMembers(memberrequest);
	}
	@PostMapping(value = "/_update")
	public ResponseEntity<ResponseInfoWrapper> updateMembers(@Valid @RequestBody NulmAlfMemberRequest memberrequest) {
		return service.updateMembers(memberrequest);
	}

	@PostMapping(value = "/_get")
	public ResponseEntity<ResponseInfoWrapper> getMembers(@Valid @RequestBody NulmAlfMemberRequest memberrequest) {
		return service.getMembers(memberrequest);
	}
	@PostMapping(value = "/_delete")
	public ResponseEntity<ResponseInfoWrapper> deleteMembers(@Valid @RequestBody NulmAlfMemberRequest memberrequest) {
		return service.deleteMembers(memberrequest);
	}
	@PostMapping(value = "/_memberCount")
	public ResponseEntity<ResponseInfoWrapper> memberCount(@RequestBody NulmAlfMemberRequest memberrequest) {
		return service.memberCount(memberrequest);
	}
	@PostMapping(value = "/_upload1")
	public ResponseEntity<ResponseInfoWrapper> uplaodExternalUser1(@Valid @RequestBody NulmAlfMemberRequest memberrequest)
			throws IOException {
		return service.uplaodExternalGuest1(memberrequest);
	}
}
