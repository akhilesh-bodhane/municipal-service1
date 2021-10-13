package org.egov.ec.web.controllers;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.io.IOException;

import org.apache.commons.io.IOUtils;
import org.egov.ec.service.EcSchedulerService;
import org.egov.ec.web.controllers.SchedulerController;
import org.egov.ec.web.models.EcSearchCriteria;
import org.egov.ec.web.models.RequestInfoWrapper;
import org.egov.ec.web.models.ResponseInfoWrapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Matchers;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@RunWith(SpringRunner.class)
@WebMvcTest(SchedulerController.class)
@Import(TestConfiguration.class)
@AutoConfigureMockMvc
public class SchedulerControllerTest {
	
	  @Autowired MockMvc mockMvc;
	  
	  @MockBean EcSchedulerService service;
	      
	  @MockBean KafkaTemplate<String, Object> producer;
	  
	  @MockBean JdbcTemplate jdbc;
	  
	  @Test public void testUpdateFineAmount() throws Exception {
		  
		  Mockito.when(service.updateFineAmount(Matchers.any(RequestInfoWrapper.class),Matchers.any(EcSearchCriteria.class)))
		  .thenReturn(new ResponseEntity<ResponseInfoWrapper>(ResponseInfoWrapper.builder().build(),
		  HttpStatus.OK));
		  
		  mockMvc.perform(MockMvcRequestBuilders.post("/scheduler/_updatePenalty")
		  .content(getFileContents("testResources/updateFineRequest.json"))
		  .contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON)).
		  andExpect(status().isCreated()); 
		  }
	  
	  @Test public void testAuctionReminder() throws Exception {
		  
		  Mockito.when(service.fetchAuctionReport(Matchers.any(RequestInfoWrapper.class),Matchers.any(EcSearchCriteria.class)))
		  .thenReturn(new ResponseEntity<ResponseInfoWrapper>(ResponseInfoWrapper.builder().build(),
		  HttpStatus.OK));
		  
		  mockMvc.perform(MockMvcRequestBuilders.post("/scheduler/_auctionReminder")
		  .content(getFileContents("testResources/updateFineRequest.json"))
		  .contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON)).
		  andExpect(status().isCreated()); 
		  }
	  
	  @Test public void testUpdateChallanStatus() throws Exception {
		  
		  Mockito.when(service.updateChallanStatus(Matchers.any(RequestInfoWrapper.class),Matchers.any(EcSearchCriteria.class)))
		  .thenReturn(new ResponseEntity<ResponseInfoWrapper>(ResponseInfoWrapper.builder().build(),
		  HttpStatus.OK));
		  
		  mockMvc.perform(MockMvcRequestBuilders.post("/scheduler/_updateChallanStatus")
		  .content(getFileContents("testResources/updateFineRequest.json"))
		  .contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON)).
		  andExpect(status().isCreated()); 
		  }
	  
	  @Test public void testUpdateAuctionStatus() throws Exception {
		  
		  Mockito.when(service.updateAuctionStatus(Matchers.any(RequestInfoWrapper.class),Matchers.any(EcSearchCriteria.class)))
		  .thenReturn(new ResponseEntity<ResponseInfoWrapper>(ResponseInfoWrapper.builder().build(),
		  HttpStatus.OK));
		  
		  mockMvc.perform(MockMvcRequestBuilders.post("/scheduler/_updateAuctionStatus")
		  .content(getFileContents("testResources/updateFineRequest.json"))
		  .contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON)).
		  andExpect(status().isCreated()); 
		  }
	  
	  private String getFileContents(String fileName) throws IOException {
			return IOUtils.toString(this.getClass().getClassLoader().getResourceAsStream(fileName), "UTF-8");
		}

}
