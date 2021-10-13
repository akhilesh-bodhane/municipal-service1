package org.egov.hc.utils;

import java.util.UUID;

import org.egov.hc.contract.AuditDetails;
import org.egov.hc.contract.RequestInfoWrapper;
import org.egov.hc.model.DeviceSources;


import org.egov.hc.producer.HCConfiguration;
import org.egov.hc.producer.HCProducer;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import eu.bitwalker.useragentutils.Browser;
import eu.bitwalker.useragentutils.OperatingSystem;
import eu.bitwalker.useragentutils.UserAgent;

@Component
public class DeviceSource {

	
	@Autowired
	private HCProducer hCProducer;
	
	@Autowired
	private HCConfiguration hcConfiguration;

	public String saveDeviceDetails(String request, String moduleType, String tenantId, String moduleCode,
			AuditDetails auditDetails,String reference_uuid) {

		JSONObject deviceDetails = new JSONObject();
		UserAgent userAgent = UserAgent.parseUserAgentString(request);
		Browser bwr = userAgent.getBrowser();
		OperatingSystem os = userAgent.getOperatingSystem();

		deviceDetails.put("BrowserName", bwr.getName());
		deviceDetails.put("BrowserType", bwr.getBrowserType().getName());
		deviceDetails.put("BrowserEnginee", bwr.getRenderingEngine().name());
		deviceDetails.put("OperatingSystem", os.getName());
		deviceDetails.put("DeviceType", os.getDeviceType().getName());
//		deviceDetails.put("referance_id", os.getDeviceType().getName());

		String sourceUuid = UUID.randomUUID().toString();
//		String sourceUuid = uuid;
		DeviceSources deviceSources = DeviceSources.builder().sourceUuid(sourceUuid).moduleCode(moduleCode)
				.deviceDetails(deviceDetails.toJSONString()).reference_uuid(reference_uuid)
				.deviceType(os.getDeviceType() == null ? "" : os.getDeviceType().getName()).tenantId(tenantId)
				.moduleType(moduleType)
				.createdBy(auditDetails.getCreatedBy())
				.createdTime(auditDetails.getCreatedTime())
				.build();

		RequestInfoWrapper infoWrapper = RequestInfoWrapper.builder().requestBody(deviceSources).build();

		hCProducer.push(hcConfiguration.getRequestDeviceSource(), infoWrapper);
		return sourceUuid;
	}

}
