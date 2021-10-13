package org.egov.pm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;

import org.egov.pm.model.Column;
import org.egov.pm.model.Columns;
import org.egov.pm.model.DisplayColumns;
import org.egov.pm.model.DocumentColumn;
import org.egov.pm.model.EmailColumn;
import org.egov.pm.model.EmailColumns;
import org.egov.pm.model.EmailTemplateModel;
import org.egov.tracer.model.CustomException;
import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.core.annotation.Order;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import lombok.extern.slf4j.Slf4j;

@Component
@Order(1)
@Slf4j
public class PreApplicationRunnerImpl implements ApplicationRunner {


	@Value("${egov.disp-columns.json.path}")
	private String displayColumnJSONPath;

	@Value("${egov.opms.emailTemplates.path}")
	private String emailTemplatePath;

	@Value("${egov.validation.addupdate.json.path}")
	private String configValidationAddUpdatePaths;

	@Value("${egov.validation.app.status.json.path}")
	private String configValidationApproveRejectPaths;

	@Autowired
	private ResourceLoader resourceLoader;

	public static final Logger logger = LoggerFactory.getLogger(PreApplicationRunnerImpl.class);
	public static ArrayList<DocumentColumn> documentColumnList = new ArrayList<>();

	public static ArrayList<DisplayColumns> displayColumns = new ArrayList<>();
	public static ArrayList<EmailTemplateModel> emailTemplates = new ArrayList<>();

	@Override
	public void run(final ApplicationArguments arg0) throws Exception {
		try {
			logger.info("Reading JSON for display Column files......");
			readFiles();
			readEmailTemplates();
		} catch (Exception e) {
			logger.error("Exception while loading JSON for display Column files: ", e);
		}
	}

	public void readEmailTemplates() {
		ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
		EmailColumns columns = null;
		EmailTemplateModel emailColumn = null;
		try {
			logger.info("Reading....: {}" , emailTemplates);
			Resource resource = resourceLoader.getResource(emailTemplatePath);
				columns = mapper.readValue(resource.getInputStream(), EmailColumns.class);
				if (columns != null) {
					for (EmailColumn col : (columns.getColumnMaps().getColumnConfig())) {
						String appType = col.getApplicationType();
						String cols = col.getTemplate().toString();
						String smsTemplate = col.getSmsTemplate().toString();
						String emailSubject = col.getEmailSubject().toString();
						for (String tenant : columns.getColumnMaps().getTenantId()) {
							for (String role : col.getRoles()) {
								for (String status : col.getStatus()) {
									emailColumn = new EmailTemplateModel();
									emailColumn.setTenantId(tenant);
									emailColumn.setApplicationType(appType);
									emailColumn.setStatus(status);
									emailColumn.setRoles(role);
									emailColumn.setTemplate(cols);
									emailColumn.setSmsTemplate(smsTemplate);
									emailColumn.setEmailSubject(emailSubject);
									emailTemplates.add(emailColumn);
								}
							}
						}
					}
				}
			logger.info("Parsed: {}", emailTemplates);
		} catch (Exception e) {
			logger.error("Exception while loading yaml files: ", e);
		}
	}

	public void readFiles() {
		ObjectMapper mapper = new ObjectMapper(new YAMLFactory());

		Columns columns = null;
		DisplayColumns displayCol = null;
		DocumentColumn documentColumn = null;

		try {
			logger.info("Reading....: {}" ,displayColumnJSONPath);
			Resource resource = resourceLoader.getResource(displayColumnJSONPath);
				columns = mapper.readValue(resource.getInputStream(), Columns.class);

				if (columns != null) {
					for (Column col : (columns.getColumnMaps().getColumnConfig())) {
						String appType = col.getApplicationType();
						String cols = col.getColunmNames().toString();
						for (String tenant : columns.getColumnMaps().getTenantId()) {
							for (String role : col.getRoles()) {
								displayCol = DisplayColumns.builder().build();
								displayCol.setTenantId(tenant);
								displayCol.setApplicationType(appType);
								displayCol.setRoles(role);
								displayCol.setColumns(cols);
								displayColumns.add(displayCol);
							}
						}
					}
					for (DocumentColumn col : (columns.getColumnMaps().getDocumentConfig())) {
						String appType = col.getApplicationType();
						String certificateDataQuery = col.getCertificateDataQuery().toString();
						String receiptDataQuery = col.getReceiptDataQuery().toString();
						for (String tenant : columns.getColumnMaps().getTenantId()) {
							documentColumn = new DocumentColumn();
							documentColumn.setTenantId(tenant);
							documentColumn.setApplicationType(appType);
							documentColumn.setCertificateDataQuery(certificateDataQuery);
							documentColumn.setReceiptDataQuery(receiptDataQuery);
							documentColumnList.add(documentColumn);
						}
					}
				}
			logger.info("Parsed:{} ",displayColumns);
		} catch (Exception e) {
			logger.error("Exception while loading yaml files: ", e);
		}
	}

	public static ArrayList<DisplayColumns> getDisplayColumns() {
		return displayColumns;
	}

	public static ArrayList<EmailTemplateModel> getTemplates() {
		return emailTemplates;
	}

	public static String getSqlQuery(String tenantId, String roles, String applicationType) {
		String sqlQuery = "";
		DisplayColumns temp = displayColumns
				.stream().filter(value -> value.getApplicationType().equals(applicationType)
						&& value.getRoles().equals(roles) && value.getTenantId().equals(tenantId))
				.findFirst().orElse(null);
		if (temp != null) {
			sqlQuery = temp.getColumns();
		}
		return sqlQuery;
	}

	public static String getCertificateSqlQuery(String tenantId, String applicationType, String documentType) {
		String sqlQuery = "";
		DocumentColumn temp = documentColumnList.stream().filter(
				value -> value.getApplicationType().equals(applicationType) && value.getTenantId().equals(tenantId))
				.findFirst().orElse(null);
		if (temp != null) {
			if (documentType.equals("certificateData"))
				sqlQuery = temp.getCertificateDataQuery();
			else if (documentType.equals("receiptData"))
				sqlQuery = temp.getReceiptDataQuery();
		}
		return sqlQuery;
	}

	public static Map<String, EmailTemplateModel> getTemplate(String tenantId, String status, String applicationType) {
		Map<String, EmailTemplateModel> map = null;
		List<EmailTemplateModel> templateList = emailTemplates
				.stream().filter(value -> value.getApplicationType().equals(applicationType)
						&& value.getStatus().equals(status) && value.getTenantId().equals(tenantId))
				.collect(Collectors.toList());
		if (templateList != null && !templateList.isEmpty()) {
			map = new HashMap<String, EmailTemplateModel>();
			for (EmailTemplateModel template : templateList) {
				map.put(template.getRoles(), template);
			}
		}
		return map;
	}

	public static void setDisplayColumns(ArrayList<DisplayColumns> displayColumns) {
		PreApplicationRunnerImpl.displayColumns = displayColumns;
	}

	@PostConstruct
	@Bean(name = "validatorAddUpdateJSON")
	public JSONObject loadValidationSourceConfigs() {
		Map<String, String> errorMap = new HashMap<>();
		JSONObject jsonObject = new JSONObject();
		ObjectMapper mapper = new ObjectMapper();
		log.info("====================== EGOV NOC SERVICE ======================");
		log.info("LOADING CONFIGS VALIDATION : " + configValidationAddUpdatePaths);
		try {
			log.info("Attempting to load config: " + configValidationAddUpdatePaths);
			Resource resource = resourceLoader.getResource(configValidationAddUpdatePaths);
			jsonObject = mapper.readValue(resource.getInputStream(), JSONObject.class);

			log.info("Parsed: " + jsonObject);
		} catch (Exception e) {
			log.error("Exception while fetching service map for: " + configValidationAddUpdatePaths, e);
			errorMap.put("FAILED_TO_FETCH_FILE", configValidationAddUpdatePaths);
		}
		if (!errorMap.isEmpty())
			throw new CustomException(errorMap);
		else
			log.info("====================== VALIDATION CONFIGS LOADED SUCCESSFULLY! ====================== ");

		return jsonObject;
	}

	@PostConstruct
	@Bean(name = "validatorApproveRejectJSON")
	public JSONObject loadValidationSourceApproveRejectConfigs() {
		Map<String, String> errorMap = new HashMap<>();
		JSONObject jsonObject = new JSONObject();
		ObjectMapper mapper = new ObjectMapper();
		log.info("====================== EGOV NOC SERVICE ======================");
		log.info("LOADING CONFIGS VALIDATION : " + configValidationApproveRejectPaths);
		try {
			log.info("Attempting to load config: " + configValidationApproveRejectPaths);
			log.info("Reading....: " + configValidationApproveRejectPaths);
			Resource resource = resourceLoader.getResource(configValidationApproveRejectPaths);

			jsonObject = mapper.readValue(resource.getInputStream(), JSONObject.class);
			log.info("Parsed: " + jsonObject);
		} catch (Exception e) {
			log.error("Exception while fetching service map for: " + configValidationApproveRejectPaths, e);
			errorMap.put("FAILED_TO_FETCH_FILE", configValidationApproveRejectPaths);
		}

		if (!errorMap.isEmpty())
			throw new CustomException(errorMap);
		else
			log.info("====================== VALIDATION CONFIGS LOADED SUCCESSFULLY! ====================== ");

		return jsonObject;
	}

}
