package org.egov.assets.service;

import org.egov.assets.common.MdmsRepository;
import org.egov.assets.model.Uom;
import org.egov.common.contract.request.RequestInfo;
import org.egov.tracer.model.CustomException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.databind.ObjectMapper;

import net.minidev.json.JSONArray;

@Service
@Transactional(readOnly = true)
public class UomService {

	private static final String MODULE_CODE = "common-masters";

	private static final String UOM_MASTER_NAME = "UOM";

	@Autowired
	private MdmsRepository mdmsRepository;

	public Uom getUom(final String tenantId, final String code, final RequestInfo requestInfo) {

		JSONArray responseJSONArray;
		final ObjectMapper mapper = new ObjectMapper();

		responseJSONArray = mdmsRepository.getByCriteria(tenantId, MODULE_CODE, UOM_MASTER_NAME, "code", code,
				requestInfo);

		if (responseJSONArray != null && responseJSONArray.size() > 0)
			return mapper.convertValue(responseJSONArray.get(0), Uom.class);
		else
			throw new CustomException("Uom", "Given Uom is invalid: " + code);

	}
}