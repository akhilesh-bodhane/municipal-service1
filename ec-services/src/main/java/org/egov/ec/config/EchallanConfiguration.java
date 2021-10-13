package org.egov.ec.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.*;
import org.egov.tracer.config.TracerConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.TimeZone;

@Import({ TracerConfiguration.class })
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Component
public class EchallanConfiguration {

	@Value("${app.timezone}")
	private String timeZone;

	@PostConstruct
	public void initialize() {
		TimeZone.setDefault(TimeZone.getTimeZone(timeZone));
	}

	@Bean
	@Autowired
	public MappingJackson2HttpMessageConverter jacksonConverter(ObjectMapper objectMapper) {
		MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
		converter.setObjectMapper(objectMapper);
		return converter;
	}

	// hrms Config
	@Value("${egov.hrms.host}")
	public String hrmsHost;

	@Value("${egov.hrms.search}")
	public String hrmsSearchEndpoint;

	// Idgen Config
	@Value("${egov.idgen.host}")
	private String idGenHost;

	@Value("${egov.idgen.path}")
	private String idGenPath;

	@Value("${egov.idgen.ec.applicationNum.name}")
	private String applicationNumberIdgenName;

	@Value("${egov.idgen.ec.applicationNum.format}")
	private String applicationNumberIdgenFormat;

	// file store
	@Value("${egov.filestore.host}")
	private String fileStoreHost;

	@Value("${egov.filestore.url}")
	private String fileStoreUrl;

	@Value("${egov.filestore.search}")
	private String uploadFile;

	// MDMS
	@Value("${egov.mdms.host}")
	private String mdmsHost;

	@Value("${egov.mdms.search.endpoint}")
	private String mdmsEndPoint;

	// Login Url

	@Value("${echallan.login.url}")
	private String loginUrl;

	// Workflow

	@Value("${workflow.context.path}")
	private String wfHost;

	@Value("${workflow.transition.path}")
	private String wfTransitionPath;

	@Value("${workflow.businessservice.search.path}")
	private String wfBusinessServiceSearchPath;


	// Item Master Topic
	@Value("${persister.save.itemmaster.item.topic}")
	private String itemMasterSaveTopic;

	@Value("${persister.update.itemmaster.item.topic}")
	private String itemMasterUpdateTopic;

	@Value("${persister.edit.challan.topic}")
	private String editChallanTopic;
	
	// Fine Master Topic
	@Value("${persister.save.finemaster.fine.topic}")
	private String FineMasterSaveTopic;

	@Value("${persister.update.finemaster.fine.topic}")
	private String FineMasterupdateTopic;

	// notification topic

	@Value("${egov.core.notification.email}")
	private String emailNotificationTopic;

	@Value("${egov.core.notification.sms}")
	private String smsNotificationTopic;

	// challan master topic
	@Value("${persister.generate.challan.topic}")
	private String generateChallanTopic;

	@Value("${persister.update.challan.topic}")
	private String updateChallanTopic;

	// StoreItemRegisterTopic
	@Value("${persister.create.StoreItem.topic}")
	private String CreateStoreItemTopic;

	@Value("${persister.update.StoreItem.topic}")
	private String updateStoreItemTopic;

	@Value("${persister.update.storeItemOfflinePayment.topic}")
	private String updateStoreItemOfflineTopic;

	// auction
	@Value("${persister.save.auction.topic}")
	private String saveAuctionTopic;

	@Value("${persister.update.auction.topic}")
	private String updateauctionTopic;

	@Value("${persister.update.auctionRejection.topic}")
	private String rejectauctionTopic;

	// penalty amount update
	@Value("${persister.update.penalty.amount.topic}")
	private String updatePenaltyAmountTopic;

	@Value("${persister.add.payment.history.topic}")
	private String addpaymentHistoryTopic;

	// VendorRegistration
	@Value("${persister.create.vendor.topic}")
	private String CreateVendorTopic;

	@Value("${persister.update.vendor.topic}")
	private String UpdateVendorTopic;

	@Value("${persister.create.deviceSource.topic}")
	public String RequestDeviceSource;
	
	@Value("${persister.update.payment.topic}")
	public String updatePayment;
	
	@Value("${persister.delete.challan.topic}")
	public String dataBckChallan;
	
	
	@Value("${echallan.notification.flag}")
	public String echallanNotificationFlag;

	@Value("${integration.service.host}")
	private String urlShortnerHost;

	@Value("${integration.service.path}")
	private String urlShortnerPath;

}