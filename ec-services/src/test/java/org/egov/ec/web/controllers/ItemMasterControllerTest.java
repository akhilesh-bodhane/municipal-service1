
package org.egov.ec.web.controllers;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.io.IOException;

import org.apache.commons.io.IOUtils;
import org.egov.ec.service.ItemService;
import org.egov.ec.web.controllers.ItemMasterController;
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

@WebMvcTest(ItemMasterController.class)

@Import(TestConfiguration.class)

@AutoConfigureMockMvc


public class ItemMasterControllerTest {

	  @Autowired MockMvc mockMvc;
	  
	  @MockBean ItemService service;
	      
	  @MockBean KafkaTemplate<String, Object> producer;
	  
	  @MockBean JdbcTemplate jdbc;

	@Test
	public void testGet() throws Exception {

		Mockito.when(service.getItem(Matchers.any(RequestInfoWrapper.class)))
				.thenReturn(new ResponseEntity<ResponseInfoWrapper>(ResponseInfoWrapper.builder().build(), HttpStatus.OK));

		mockMvc.perform(
				MockMvcRequestBuilders.post("/item/_get").content(getFileContents("testResources/getItemRequest.json"))
					.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());


	}

	
	  @Test public void testAddItem() throws Exception {
	  
		  Mockito.when(service.addItem(RequestInfoWrapper.builder().build(),"hsbk"))
		  .thenReturn(new ResponseEntity<ResponseInfoWrapper>(ResponseInfoWrapper.builder().build(),
		  HttpStatus.OK));
		  
		  mockMvc.perform(MockMvcRequestBuilders.post("/item/_create")
		  .content(getFileContents("testResources/createItemRequest.json"))
		  .header("User-Agent", "hbcbkb")
		  .contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON)).
		  andExpect(status().isOk());
	  
	  }
	  
	  @Test public void testUpdateItem() throws Exception {
	  
		  Mockito.when(service.updateItem(Matchers.any(RequestInfoWrapper.class)))
		  .thenReturn(new ResponseEntity<ResponseInfoWrapper>(ResponseInfoWrapper.builder().build(),
		  HttpStatus.OK));
		  
		  mockMvc.perform(MockMvcRequestBuilders.post("/item/_update")
		  .content(getFileContents("testResources/updateItemRequest.json"))
		  .contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON)).
		  andExpect(status().isOk()); 
		  }
	 
	private String getFileContents(String fileName) throws IOException {
		return IOUtils.toString(this.getClass().getClassLoader().getResourceAsStream(fileName), "UTF-8");
	}
}
