package org.egov.ec.web.controllers;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.io.IOException;

import org.apache.commons.io.IOUtils;
import org.egov.ec.service.AuctionService;
import org.egov.ec.service.DeviceSourceService;
import org.egov.ec.service.VendorRegistrationService;
import org.egov.ec.service.ViolationService;
import org.egov.ec.web.controllers.AuctionController;
import org.egov.ec.web.models.DeviceSources;
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
@WebMvcTest(AuctionController.class)
@Import(TestConfiguration.class)
@AutoConfigureMockMvc
public class AuctionControllerTest {
	
	@Autowired MockMvc mockMvc;
	  @MockBean AuctionService service;
	  @MockBean KafkaTemplate<String, Object> producer;
	  @MockBean JdbcTemplate jdbc;
	  @MockBean DeviceSourceService deviceSource;

	  @Test
		public void testGet() throws Exception {

			Mockito.when(service.getAuction(Matchers.any(RequestInfoWrapper.class)))
					.thenReturn(new ResponseEntity<ResponseInfoWrapper>(ResponseInfoWrapper.builder().build(), HttpStatus.OK));

			mockMvc.perform(
					MockMvcRequestBuilders.post("/auction/_get").content(getFileContents("testResources/getAuctionRequest.json"))
						.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON))
					.andExpect(status().isOk());


		}
	  
	  @Test public void testAdd() throws Exception {
			
			  Mockito.when(service.addAuction(RequestInfoWrapper.builder().build(), "dbkbdk"))
			  .thenReturn(new
			  ResponseEntity<ResponseInfoWrapper>(ResponseInfoWrapper.builder().build(),
			  HttpStatus.OK));
			 
		  
		  mockMvc.perform(MockMvcRequestBuilders.post("/auction/_create")
		  .content(getFileContents("testResources/createAuctionRequest.json"))
		  .header("User-Agent", "hbcbkb")
		  .contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON)).
		  andExpect(status().isOk());
	  
	  }
	  
	  @Test public void testUpdate() throws Exception {
	  
		  Mockito.when(service.updateAuction(Matchers.any(RequestInfoWrapper.class)))
		  .thenReturn(new ResponseEntity<ResponseInfoWrapper>(ResponseInfoWrapper.builder().build(),
		  HttpStatus.OK));
		  
		  mockMvc.perform(MockMvcRequestBuilders.post("/auction/_update")
		  .content(getFileContents("testResources/updateAuctionRequest.json"))
		  .contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON)).
		  andExpect(status().isOk()); 
		  }
	  
	  private String getFileContents(String fileName) throws IOException {
			return IOUtils.toString(this.getClass().getClassLoader().getResourceAsStream(fileName), "UTF-8");
		}
	  
	  @Test
		public void testGetChallan() throws Exception {

			Mockito.when(service.getAuctionChallan(Matchers.any(RequestInfoWrapper.class)))
					.thenReturn(new ResponseEntity<ResponseInfoWrapper>(ResponseInfoWrapper.builder().build(), HttpStatus.OK));

			mockMvc.perform(
					MockMvcRequestBuilders.post("/auction/_getChallan").content(getFileContents("testResources/getAuctionRequest.json"))
						.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON))
					.andExpect(status().isOk());


		}

}
