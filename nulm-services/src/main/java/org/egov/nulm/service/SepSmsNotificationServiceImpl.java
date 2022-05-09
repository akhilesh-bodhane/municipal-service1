package org.egov.nulm.service;


import java.util.Arrays;

import org.egov.nulm.config.NULMConfiguration;
import org.egov.nulm.model.NulmSepRequest;
import org.egov.nulm.model.SMSRequest;
import org.egov.nulm.model.SepApplication;
import org.egov.nulm.util.NotificationUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class SepSmsNotificationServiceImpl implements SepSmsNotificationService {

	@Autowired
	private NULMConfiguration config;
		
	@Autowired
	private ObjectMapper mapper;
	
	
	@Autowired
	private NotificationUtil notificationUtil;
	
	
	@Override
	public void sendSms(NulmSepRequest nulmSepRequest) {
		SepApplication sep  = nulmSepRequest.getNulmSepRequest();
//		String template = config.getNotificationTemplate();
//		template  = template.replace("<#var1>", wn.getApplication_no()).replace("<#var2>", wn.getConsumer_name()).replace("<#var3>",
//				wn.getHouse_no()).replace("<#var4>", wn.getSector_village()).replace("<#var5>", wn.getPhone_no()).replace("<#var6>", wn.getApplication_type())
//				.replace("<#var7>",wn.getApplication_status()).replace("<#var8>", wn.getAmount());
		String template=getTemplate(sep);
		SMSRequest smsTemplate = SMSRequest.builder().message(template).mobileNumber(sep.getContact()).build();
		notificationUtil.sendSMS(Arrays.asList(smsTemplate));
	}
	
	private String getTemplate(SepApplication sep) {
		String template = null;
		
		/* if(sep.getTemplateName()==null) { */
		   if(sep.getApplicationStatus().equals(SepApplication.StatusEnum.APPROVEDBYTASKFORCECOMMITTEE)) {
			template = config.getNotificationTemplate();
			template  = template.replace("<#var1>", sep.getApplicationId()).replace("<#var2>", sep.getAddress());
		   }
		   if(sep.getApplicationStatus().equals(SepApplication.StatusEnum.REJECTEDBYTASKFORCECOMMITTEE)) {
				template = config.getNotificationTemplate();
				template  = template.replace("<#var1>", sep.getName()).replace("<#var2>", sep.getGender());
			   }
		/*}else {
			switch (wn.getTemplateName()) {
			case TEMPLATE_NAME_SITE_INSPECTOR:
				template=config.getNotificationTemplateSiteInspector();
				template  = template.replace("<#var1>", sep.getApplication_no()).replace("<#var2>", sep.getConsumer_name()).replace("<#var3>",
						wn.getHouse_no()).replace("<#var4>", sep.getSector_village()).replace("<#var5>", sep.getPhone_no()).replace("<#var6>", wn.getApplication_type())
						.replace("<#var7>",sep.getApplication_status()).replace("<#var8>", sep.getAmount());
				break;
			case TEMPLATE_NAME_CITIZEN_CASE1:
				template=config.getNotificationTemplateCitizenCase1();
				template=template.replace("<#var1>", wn.getApplication_no()).replaceAll("<#var2>", sep.getSubdivision());
				break;
			case TEMPLATE_NAME_CITIZEN_CASE2:
				template=config.getNotificationTemplateCitizenCase2();
				template=template.replace("<#var1>", sep.getAmount()).replace("<#var2>", sep.getApplication_no());
				break;
			case TEMPLATE_NAME_CITIZEN_CASE3:
				template=config.getNotificationTemplateCitizenCase3();
				template=template.replace("<#var1>", sep.getApplication_no());
				break;
			}
		}*/
		
		return template;
	}
}
