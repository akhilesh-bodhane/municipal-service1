package org.egov.prscp.util;

import static org.egov.prscp.util.PrScpConstants.COMMON_MASTERS_MODULE;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;

import org.egov.common.contract.request.RequestInfo;
import org.egov.mdms.model.MasterDetail;
import org.egov.mdms.model.MdmsCriteria;
import org.egov.mdms.model.MdmsCriteriaReq;
import org.egov.mdms.model.ModuleDetail;
import org.egov.prscp.config.PrScpConfiguration;
import org.egov.prscp.web.models.AuditDetails;
import org.egov.tracer.model.CustomException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class PrScpUtil {

	private PrScpConfiguration config;

	private ServiceRequestRepository serviceRequestRepository;

	@Autowired
	@Qualifier("validatorAddUpdateJSON")
	private JSONObject jsonAddObject;

	@Autowired
	public PrScpUtil(PrScpConfiguration config, ServiceRequestRepository serviceRequestRepository) {
		this.config = config;
		this.serviceRequestRepository = serviceRequestRepository;
	}

	/**
	 * Method to return auditDetails for create/update flows
	 *
	 * @param by
	 * @param isCreate
	 * @return AuditDetails
	 */
	public AuditDetails getAuditDetails(String by, Boolean isCreate) {
		Long time = System.currentTimeMillis();
		if (isCreate)
			return AuditDetails.builder().createdBy(by).lastModifiedBy(by).createdTime(time).lastModifiedTime(time)
					.build();
		else
			return AuditDetails.builder().lastModifiedBy(by).lastModifiedTime(time).build();
	}

	/**
	 * Returns the url for mdms search endpoint
	 *
	 * @return url for mdms search endpoint
	 */
	public StringBuilder getMdmsSearchUrl() {
		return new StringBuilder().append(config.getMdmsHost()).append(config.getMdmsEndPoint());
	}

	public String validateJsonAddUpdateData(String requestData, String applicationType) throws ParseException {
		String responseText = "";
		try {

			JSONParser jsonParser = new JSONParser();
			JSONObject jsonValidator = (JSONObject) jsonParser.parse(jsonAddObject.toJSONString());
			jsonValidator = (JSONObject) jsonValidator.get(applicationType);

			JSONObject jsonRequested = (JSONObject) jsonParser.parse(requestData.toString());

			if (jsonValidator == null || jsonRequested == null) {
				return "Unable to load the JSON file or requested data.";
			}
			responseText = commonValidation(jsonValidator, jsonRequested);

		} catch (Exception e) {
			throw new CustomException("PRSCP_SAVE_UPDATE_GET", "Invalid Application Type or Role or datapayload data");
		}
		return responseText;
	}

	private String commonValidation(JSONObject jsonValidator, JSONObject jsonRequested) {

		Set<String> keyValidateList = jsonValidator.keySet();
		Set<String> keyRequestedList = jsonRequested.keySet();


		StringBuilder responseText = new StringBuilder();
		try {

			for (String key : keyValidateList) {
				JSONObject actualValidate = (JSONObject) jsonValidator.get(key);
				String isMandatory = actualValidate.get("mandatory").toString();
				String isRegExpression = actualValidate.get("validateRegularExp").toString();
				if (key.equals("is_Active") || key.equals("defaultGrid") || key.equals("documentAttachment")  || key.equals("documentList")
						|| key.equals("eventImage") || key.equals("tenderDocument") )
					continue;
				else {
					if (jsonRequested.get(key) != null) {

						if (jsonRequested.get(key) instanceof JSONArray) {

							JSONArray jsonarray = (JSONArray) jsonRequested.get(key);

							for (Object json : jsonarray)
							{
								String jsonInString = new Gson().toJson(json);
								JSONObject mJSONObject = (JSONObject) new JSONParser().parse(jsonInString);

								Set keys = mJSONObject.keySet();

								HashMap<String, Object> yourHashMap = new Gson().fromJson(mJSONObject.toString(), HashMap.class);

								for (Map.Entry<String,Object> entry : yourHashMap.entrySet())  {
									if(entry.getValue().toString().contains("</script>")||entry.getValue().toString().contains("&lt;/script&gt;")) {
										responseText.append(entry.getKey().toString() + ":[Invalid data]");
										responseText.append(",");
									}
									else
										responseText =  xxsFilterPatern(entry.getValue().toString(),entry.getKey().toString(),responseText);
								}
							}
						}
						else
						{

							String dataReq = jsonRequested.get(key).toString();
							if(dataReq.contains("</script>")||dataReq.contains("&lt;/script&gt;")) {
								responseText.append(key + ":[Invalid data]");
								responseText.append(",");
							}
							else
								responseText =  xxsFilterPatern(dataReq,key,responseText);
						}

					}
				}
			}

			if (!responseText.toString().equals("")) {
				responseText = new StringBuilder(
						"Error at =>  " + responseText.substring(0, responseText.length() - 1));
			}

		} catch (Exception e) {
			responseText.append("Unable to Process request => ");
			responseText.append("Exceptions => " + e.getMessage());
		}

		return responseText.toString();
	}

	private StringBuilder xxsFilterPatern(String dataReq,String key,StringBuilder responseText)
	{

		Pattern validatePattern = null;
		List<String> validatePatternList =new ArrayList<String>();
		validatePatternList.add(CommonConstants.SCRIPTTAGXSS);
		validatePatternList.add(CommonConstants.SRC1TAGXSS);
		validatePatternList.add(CommonConstants.SRC2TAGXSS);
		validatePatternList.add(CommonConstants.SCRIPTENDTAGXSS);
		validatePatternList.add(CommonConstants.SCRIPTSTARTTAGXSS);
		validatePatternList.add(CommonConstants.JSTAGXSS);
		validatePatternList.add(CommonConstants.ONLOADTAGXSS);

		for(String validateStrPattern : validatePatternList)
		{
			if (!dataReq.equals("") && !dataReq.equals(null)) {
				validatePattern = Pattern.compile(validateStrPattern,
						Pattern.CASE_INSENSITIVE);
				if (validatePattern.matcher(dataReq).matches()) {
					responseText.append(key + ":[Invalid data]");
					responseText.append(",");
					break;
				}
			}
			/*validatePattern = Pattern.compile(CommonConstants.SRC1TAGXSS,
					Pattern.CASE_INSENSITIVE);
			if (validatePattern.matcher(dataReq).matches()) {
				responseText.append(key + ":[Invalid data]");
				responseText.append(",");
			}
			validatePattern = Pattern.compile(CommonConstants.SRC2TAGXSS,
					Pattern.CASE_INSENSITIVE);
			if (validatePattern.matcher(dataReq).matches()) {
				responseText.append(key + ":[Invalid data]");
				responseText.append(",");
			}
			validatePattern = Pattern.compile(CommonConstants.SCRIPTENDTAGXSS,
					Pattern.CASE_INSENSITIVE);
			if (validatePattern.matcher(dataReq).matches()) {
				responseText.append(key + ":[Invalid data]");
				responseText.append(",");
			}
			validatePattern = Pattern.compile(CommonConstants.SCRIPTSTARTTAGXSS,
					Pattern.CASE_INSENSITIVE);
			if (validatePattern.matcher(dataReq).matches()) {
				responseText.append(key + ":[Invalid data]");
				responseText.append(",");
			}
			validatePattern = Pattern.compile(CommonConstants.JSTAGXSS,
					Pattern.CASE_INSENSITIVE);
			if (validatePattern.matcher(dataReq).matches()) {
				responseText.append(key + ":[Invalid data]");
				responseText.append(",");
			}
			validatePattern = Pattern.compile(CommonConstants.VBTAGXSS,
					Pattern.CASE_INSENSITIVE);
			if (validatePattern.matcher(dataReq).matches()) {
				responseText.append(key + ":[Invalid data]");
				responseText.append(",");
			}
			validatePattern = Pattern.compile(CommonConstants.ONLOADTAGXSS,
					Pattern.CASE_INSENSITIVE);
			if (validatePattern.matcher(dataReq).matches()) {
				responseText.append(key + ":[Invalid data]");
				responseText.append(",");
			}*/
		}
		return responseText;

	}


}
