package org.egov.assets.repository;

import org.egov.assets.model.PDFResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class PDFServiceReposistory {

	private final RestTemplate restTemplate;
	private final String pdfServiceUrls;

	@Autowired
	public PDFServiceReposistory(final RestTemplate restTemplate,
			@Value("${egov.services.pdfservice.hostname}") final String hostName,
			@Value("${egov.services.pdfservice.path}") final String path) {
		this.restTemplate = restTemplate;
		this.pdfServiceUrls = hostName + path;
	}

	public PDFResponse getPrint(Object request, String key, String tenantId) {
		StringBuilder pathString = new StringBuilder(pdfServiceUrls);
		pathString.append("?key=");
		pathString.append(key);
		pathString.append("&tenantId=");
		pathString.append(tenantId);
		return restTemplate.postForObject(pathString.toString(), request, PDFResponse.class);
	}
}
