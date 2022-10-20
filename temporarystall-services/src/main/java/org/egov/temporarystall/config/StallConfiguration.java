package org.egov.temporarystall.config;

import java.math.BigDecimal;
import java.util.TimeZone;

import javax.annotation.PostConstruct;

import org.egov.tracer.config.TracerConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Import({ TracerConfiguration.class })
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Component
public class StallConfiguration {

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
  
		
	// Idgen Config
	@Value("${egov.idgen.host}")
	private String idGenHost;

	@Value("${egov.idgen.path}")
	private String idGenPath;
	
	@Value("${egov.idgen.temporary.stall.idname}")
	private String stallapplicationNumberIdgenName;

	@Value("${egov.idgen.temporary.stall.idformat}")
	private String stallapplicationNumberIdgenFormat;
	

	// STALL Config topics
	@Value("${persister.save.stallapplication.topic}")
	private String STALLApplicationSaveTopic;	
	
	
	// MDMS
		@Value("${egov.mdms.host}")
		private String mdmsHost;

		@Value("${egov.mdms.search.endpoint}")
		private String mdmsSearchEndpoint;
		
		
		@Value("${egov.demand.minimum.payable.amount}")
		private BigDecimal minimumPayableAmount;
		
		@Value("${egov.demand.create.endpoint}")
		private String demandCreateEndpoint;
		
		@Value("${egov.billingservice.host}")
		private String billingHost;
		
		@Value("${egov.demand.search.endpoint}")
		private String billingHostSerach;
		
		@Value("${egov.collectionservice.host}")
		private String collectionHostSerach;

		@Value("${egov.collection.search.endpoint}")
		private String collectionSearcheUrl;
		
		
		
		@Value("${persister.update.stallapplication.topic}")
		private String STALLApplicationUpdateTopic;
		
		
		@Value("${persister.update.stallapplication.paymentstatus.topic}")
		private String STALLApplicationUpdatepaymentstatusTopic;
		
		
		@Value("${persister.update.stallapplication.applicationstatus.topic}")
		private String STALLApplicationUpdateapplicationstatusTopic;
		
		
		@Value("${persister.update.stallapplication.paymentstatus.schedular.topic}")
		private String STALLApplicationUpdatepaymentstatusSchedularTopic;
		
		
		@Value("${persister.update.stallapplication.applicationstatus.schedular.topic}")
		private String STALLApplicationUpdateapplicationstatusSchedularTopic;
		
		

		@Value("${egov.demand.update.endpoint}")
		private String BillingUpdateUrl;	
}
