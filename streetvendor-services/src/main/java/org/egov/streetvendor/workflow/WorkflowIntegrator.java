package org.egov.streetvendor.workflow;

import static java.util.Objects.isNull;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;

import org.egov.common.contract.request.RequestInfo;
import org.egov.common.contract.response.ResponseInfo;
import org.egov.streetvendor.common.CommonConstants;
import org.egov.tracer.model.CustomException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

import lombok.extern.slf4j.Slf4j;


@Service
@Slf4j
public class WorkflowIntegrator {

	private RestTemplate rest;


	
	@Autowired
	@Qualifier("validatorAddUpdateJSON")
	private JSONObject jsonAddObject;

	@Autowired
	public WorkflowIntegrator(RestTemplate rest) {
		this.rest = rest;		
	}

	
	public String validateJsonAddUpdateData(String requestData, String applicationType)  {
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
			throw new CustomException("HC_SAVE_UPDATE_GET", "Invalid Application Type or Role or datapayload data");
		}
		return responseText;
	}

	private String commonValidation(JSONObject jsonValidator, JSONObject jsonRequested) {
		//Set<String> keyValidateList = jsonValidator.keySet();
		Set<String> keyValidateList = jsonRequested.keySet();
		//Set<String> keyRequestedList = jsonRequested.keySet();
		StringBuilder responseText = new StringBuilder();

		try {
			for (String key : keyValidateList) {
				//JSONObject actualValidate = (JSONObject) jsonValidator.get(key);
				//String isMandatory = actualValidate.get("mandatory").toString();
				//String isRegExpression = actualValidate.get("validateRegularExp").toString();
				if (key.equals("isActive") || key.equals("offset") || key.equals("limit") || key.equals("document") || key.equals("isAuctioned"))
					continue;
				else {
					if (jsonRequested.get(key) != null) {
						if (jsonRequested.get(key) instanceof JSONArray) {
							JSONArray jsonarray = (JSONArray) jsonRequested.get(key);
							for (Object json : jsonarray)
							{
								if (json instanceof JSONObject) 
								{
									String jsonInString = new Gson().toJson(json);
									JSONObject mJSONObject = (JSONObject) new JSONParser().parse(jsonInString);
									HashMap<String, Object> yourHashMap = new Gson().fromJson(mJSONObject.toString(), HashMap.class);

									for (Map.Entry<String,Object> entry : yourHashMap.entrySet()) 
									{
										if(entry.getValue().toString().contains("</script>")||entry.getValue().toString().contains("&lt;/script&gt;")) {
											responseText.append(entry.getKey().toString() + ":[Invalid data]");
											responseText.append(",");
										}
										else
											responseText =  xxsFilterPatern(entry.getValue().toString(),entry.getKey().toString(),responseText);
									}
								}
								else
								{
									if(json.toString().contains("</script>")||json.toString().contains("&lt;/script&gt;")) {
										responseText.append(key + ":[Invalid data]");
										responseText.append(",");
										break;
									}
									else 
										responseText =  xxsFilterPatern(json.toString().toString(),key,responseText);
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
				responseText = new StringBuilder("Error at =>  " + responseText.substring(0, responseText.length() - 1));
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
		}
		return responseText;

	}
}