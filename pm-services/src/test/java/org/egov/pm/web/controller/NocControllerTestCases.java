package org.egov.pm.web.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.io.IOException;

import org.apache.commons.io.IOUtils;
import org.egov.common.contract.response.ResponseInfo;
import org.egov.pm.model.ErrorResponseInfo;
import org.egov.pm.model.Errors;
import org.egov.pm.model.RequestData;
import org.egov.pm.service.NocService;
import org.egov.pm.service.ReportGenerationSchecduler;
import org.egov.pm.util.UserUtil;
import org.egov.pm.web.contract.NocResponse;
import org.egov.pm.web.contract.ResponseData;
import org.egov.pm.web.contract.factory.ResponseFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Matchers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.web.client.RestTemplate;

@RunWith(SpringRunner.class)
@WebMvcTest(NocController.class)
@Import(TestConfiguration.class)
@AutoConfigureMockMvc
public class NocControllerTestCases {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	RestTemplate restTemplate;

	@MockBean
	private NocService nocService;

	@MockBean
	private ReportGenerationSchecduler reportGenerationSchecduler;

	@MockBean
	private UserUtil userUtil;

	@MockBean
	private ResponseFactory responseFactory;

	private Errors getError() {
		return Errors.builder().error(ErrorResponseInfo.builder().message("success").build()).build();
	}

	@Test
	public void testGet() throws IOException, Exception {

		// when(userUtil.validateUser(any(RequestData.class))).thenReturn(getError());
		
		when(nocService.getNoc(Matchers.any(RequestData.class)))
				.thenReturn(new ResponseEntity(NocResponse.builder().build(), HttpStatus.OK));

		mockMvc.perform(
				MockMvcRequestBuilders.post("/noc/_get").content(getFileContents("testRecources/getNocRequest.json"))
						.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());
//				.andExpect(MockMvcResultMatchers.jsonPath("$.nocApplicationDetail").exists());
	}

	@Test
	public void testView() throws Exception {
		// when(userUtil.validateUser(any(RequestData.class))).thenReturn(getError());
		when(nocService.viewNoc(Matchers.any(RequestData.class)))
				.thenReturn(new ResponseEntity(NocResponse.builder().build(), HttpStatus.OK));

		mockMvc.perform(
				MockMvcRequestBuilders.post("/noc/_view").content(getFileContents("testRecources/viewNocRequest.json"))
						.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());
				//.andExpect(MockMvcResultMatchers.jsonPath("$.nocApplicationDetail").exists());
	}

	@Test
	public void testGetCertificateData() throws IOException, Exception {
		// when(userUtil.validateUser(any(RequestData.class))).thenReturn(getError());
		when(nocService.getCertificateData(Matchers.any(RequestData.class)))
				.thenReturn(new ResponseEntity(NocResponse.builder().build(), HttpStatus.OK));

		mockMvc.perform(MockMvcRequestBuilders.post("/noc/_getCertificateData")
				.content(getFileContents("testRecources/getCertificateDataNocRequest.json"))
				.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
				//.andExpect(MockMvcResultMatchers.jsonPath("$.nocApplicationDetail").exists());
	}

	@Test
	public void testCreateNoc() throws Exception {
		// when(userUtil.validateUser(any(RequestData.class))).thenReturn(getError());
		when(nocService.saveNoc(Matchers.any(RequestData.class))).thenReturn(new ResponseEntity(
				ResponseData.builder().applicationId("PMS-2020-02-25-041860").build(), HttpStatus.OK));

		mockMvc.perform(MockMvcRequestBuilders.post("/noc/_create")
				.content(getFileContents("testRecources/createNocRequest.json")).contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("$.applicationId").exists());
	}

	@Test
	public void testUpdate() throws IOException, Exception {
		// when(userUtil.validateUser(any(RequestData.class))).thenReturn(getError());
		when(nocService.updateNoc(Matchers.any(RequestData.class))).thenReturn(new ResponseEntity(
				ResponseData.builder().applicationId("PMS-2020-03-11-042081").build(), HttpStatus.OK));

		mockMvc.perform(MockMvcRequestBuilders.post("/noc/_update")
				.content(getFileContents("testRecources/updateNocRequest.json")).contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("$.applicationId").exists());

	}

	@Test
	public void testUpdateApplicationStatus() throws IOException, Exception {
		// when(userUtil.validateUser(any(RequestData.class))).thenReturn(getError());
		when(nocService.updateNocApplicationStatus(Matchers.any(RequestData.class))).thenReturn(new ResponseEntity(
				ResponseData.builder().responseInfo(ResponseInfo.builder().status("status").build()).build(),
				HttpStatus.OK));

		mockMvc.perform(MockMvcRequestBuilders.post("/noc/_updateappstatus")
				.content(getFileContents("testRecources/updateNocRequest.json")).contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("$.ResponseInfo.status").exists());
	}

	
	@Test
	public void testviewpricebook() throws IOException, Exception {
	 when(userUtil.validateUser(any(RequestData.class))).thenReturn(getError());
		NocResponse res = new NocResponse();

		when(nocService.viewPriceBook(Matchers.any(RequestData.class)))
				.thenReturn(res);
		
		when(nocService.viewPriceBookById(Matchers.any(RequestData.class)))
		.thenReturn(res);

		mockMvc.perform(MockMvcRequestBuilders.post("/noc/_viewPriceBook")
				.content(getFileContents("testRecources/priceBook.json"))
				.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
				//.andExpect(MockMvcResultMatchers.jsonPath("$.nocApplicationDetail").exists());
	}
	

	@Test
	public void testupdatepricebook() throws IOException, Exception {
	 when(userUtil.validateUser(any(RequestData.class))).thenReturn(getError());
		NocResponse res = new NocResponse();

		when(nocService.updatepricebook(Matchers.any(RequestData.class)))
				.thenReturn(res);

		mockMvc.perform(MockMvcRequestBuilders.post("/noc/_updatepricebook")
				.content(getFileContents("testRecources/updatepricebook.json"))
				.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
				//.andExpect(MockMvcResultMatchers.jsonPath("$.nocApplicationDetail").exists());
	}


	private String getFileContents(String fileName) throws IOException {
		return IOUtils.toString(this.getClass().getClassLoader().getResourceAsStream(fileName), "UTF-8");
	}
}
