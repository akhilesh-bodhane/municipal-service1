package org.egov.ec.web.controllers;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.io.IOException;

import org.apache.commons.io.IOUtils;
import org.egov.ec.service.VendorRegistrationService;
import org.egov.ec.web.controllers.VendorRegistrationContorller;
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
@WebMvcTest(VendorRegistrationContorller.class)
@Import(TestConfiguration.class)
@AutoConfigureMockMvc
public class VendorRegistrationContorllerTest {
	
	  @Autowired MockMvc mockMvc;
	  @MockBean VendorRegistrationService service;
	  @MockBean KafkaTemplate<String, Object> producer;
	  @MockBean JdbcTemplate jdbc;

	  @Test
		public void testGet() throws Exception {

			Mockito.when(service.getVendor(Matchers.any(RequestInfoWrapper.class)))
					.thenReturn(new ResponseEntity<ResponseInfoWrapper>(ResponseInfoWrapper.builder().build(), HttpStatus.OK));

			mockMvc.perform(
					MockMvcRequestBuilders.post("/vendor/_get").content(getFileContents("testResources/getVendorRequest.json"))
						.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON))
					.andExpect(status().isOk());


		}
	  
	  @Test public void testAdd() throws Exception {
		  
		  Mockito.when(service.createVendor(RequestInfoWrapper.builder().build(),"hsbk"))
		  .thenReturn(new ResponseEntity<ResponseInfoWrapper>(ResponseInfoWrapper.builder().build(),
		  HttpStatus.OK));
		  
		  mockMvc.perform(MockMvcRequestBuilders.post("/vendor/_create")
		  .content(getFileContents("testResources/createVendorRequest.json"))
		  .header("User-Agent", "hbcbkb")
		  .contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON)).
		  andExpect(status().isOk());
	  
	  }
	  
	  @Test public void testUpdate() throws Exception {
	  
		  Mockito.when(service.updateVendor(Matchers.any(RequestInfoWrapper.class)))
		  .thenReturn(new ResponseEntity<ResponseInfoWrapper>(ResponseInfoWrapper.builder().build(),
		  HttpStatus.OK));
		  
		  mockMvc.perform(MockMvcRequestBuilders.post("/vendor/_update")
		  .content(getFileContents("testResources/updateVendorRequest.json"))
		  .contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON)).
		  andExpect(status().isOk()); 
		  }
	  
	  private String getFileContents(String fileName) throws IOException {
			return IOUtils.toString(this.getClass().getClassLoader().getResourceAsStream(fileName), "UTF-8");
		}
}
