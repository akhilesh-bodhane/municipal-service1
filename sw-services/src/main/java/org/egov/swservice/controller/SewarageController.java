package org.egov.swservice.controller;

import java.util.List;

import javax.validation.Valid;

import org.egov.swservice.model.PublicDashBoardSearchCritieria;
import org.egov.swservice.model.PublicDashboardResponse;
import org.egov.swservice.model.RequestInfoWrapper;
import org.egov.swservice.model.ResponseData;
import org.egov.swservice.model.SearchCriteria;
import org.egov.swservice.model.SearchTotalCollectionCriteria;
import org.egov.swservice.model.SewerageCollectionCountResponse;
import org.egov.swservice.model.SewerageConnection;
import org.egov.swservice.model.SewerageConnectionCount;
import org.egov.swservice.model.SewerageConnectionRequest;
import org.egov.swservice.model.SewerageConnectionResponse;
import org.egov.swservice.model.SewerageCountConnectionResponse;
import org.egov.swservice.model.SewerageTotalCollections;
import org.egov.swservice.service.SewarageService;
import org.egov.swservice.util.ResponseInfoFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@RestController
@RequestMapping("/swc")
public class SewarageController {

	@Autowired
	SewarageService sewarageService;

	@Autowired
	private final ResponseInfoFactory responseInfoFactory;

	@RequestMapping(value = "/_create", method = RequestMethod.POST, produces = "application/json")
	public ResponseEntity<SewerageConnectionResponse> createWaterConnection(
			@Valid @RequestBody SewerageConnectionRequest sewerageConnectionRequest) {
		List<SewerageConnection> sewerageConnection = sewarageService.createSewarageConnection(sewerageConnectionRequest);
		SewerageConnectionResponse response = SewerageConnectionResponse.builder().sewerageConnections(sewerageConnection)
				.responseInfo(responseInfoFactory
						.createResponseInfoFromRequestInfo(sewerageConnectionRequest.getRequestInfo(), true))
				.build();
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@RequestMapping(value = "/_search", method = RequestMethod.POST)
	public ResponseEntity<SewerageConnectionResponse> search(@Valid @RequestBody RequestInfoWrapper requestInfoWrapper,
			@Valid @ModelAttribute SearchCriteria criteria) {
		List<SewerageConnection> sewerageConnectionList = sewarageService.search(criteria,
				requestInfoWrapper.getRequestInfo());

		SewerageConnectionResponse response = SewerageConnectionResponse.builder()
				.sewerageConnections(sewerageConnectionList).responseInfo(responseInfoFactory
						.createResponseInfoFromRequestInfo(requestInfoWrapper.getRequestInfo(), true))
				.build();
		return new ResponseEntity<>(response, HttpStatus.OK);

	}
	
	@RequestMapping(value = "/_searchCount", method = RequestMethod.POST)
	public ResponseEntity<SewerageCountConnectionResponse> searchCount(@Valid @RequestBody RequestInfoWrapper requestInfoWrapper,
			@Valid @ModelAttribute SearchCriteria criteria) {
		List<SewerageConnectionCount> sewerageConnectionList = sewarageService.searchCount(criteria,
				requestInfoWrapper.getRequestInfo());

		SewerageCountConnectionResponse response = SewerageCountConnectionResponse.builder()
				.sewerageCountConnections(sewerageConnectionList).responseInfo(responseInfoFactory
						.createResponseInfoFromRequestInfo(requestInfoWrapper.getRequestInfo(), true))
				.build();
		return new ResponseEntity<>(response, HttpStatus.OK);

	}

	@RequestMapping(value = "/_update", method = RequestMethod.POST, produces = "application/json")
	public ResponseEntity<SewerageConnectionResponse> updateSewerageConnection(
			@Valid @RequestBody SewerageConnectionRequest sewerageConnectionRequest) {
		List<SewerageConnection> sewerageConnection = sewarageService.updateSewarageConnection(sewerageConnectionRequest);
		SewerageConnectionResponse response = SewerageConnectionResponse.builder().sewerageConnections(sewerageConnection)
				.responseInfo(responseInfoFactory
						.createResponseInfoFromRequestInfo(sewerageConnectionRequest.getRequestInfo(), true))
				.build();
		return new ResponseEntity<>(response, HttpStatus.OK);

	}
	
	@RequestMapping(value = "/_searchTotalcollectionCount", method = RequestMethod.POST)
	public ResponseEntity<SewerageCollectionCountResponse> searchTotalCollectionCount(@Valid @RequestBody RequestInfoWrapper requestInfoWrapper,
			@Valid @ModelAttribute SearchTotalCollectionCriteria SearchTotalCollectionCriteria) {
		List<SewerageTotalCollections> sewerageConnectionList = sewarageService.searchTotalCollectionCount(SearchTotalCollectionCriteria, requestInfoWrapper.getRequestInfo());
		SewerageCollectionCountResponse response = SewerageCollectionCountResponse.builder().waterConnection(sewerageConnectionList)
				.responseInfo(responseInfoFactory.createResponseInfoFromRequestInfo(requestInfoWrapper.getRequestInfo(),
						true))
				.build();
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/_searchCountPublicDashBoard", method = RequestMethod.POST)
	public ResponseEntity<PublicDashboardResponse> searchPublicDashBoardCount(@Valid @RequestBody PublicDashBoardSearchCritieria SearchTotalCollectionCriteria) {
				
		ResponseData searchTotalCollectionCount = sewarageService.searchPublicDashBoardCount(SearchTotalCollectionCriteria);	
		
		PublicDashboardResponse metricsResponsebody = PublicDashboardResponse.builder().responseData(searchTotalCollectionCount).build();

        return new ResponseEntity<>( metricsResponsebody , HttpStatus.OK);
	}

}
