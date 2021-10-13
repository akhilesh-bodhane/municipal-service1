package org.egov.ec.config;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.egov.ec.config.EchallanConfiguration;
import org.junit.Test;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * The class <code>EchallanConfigurationTest</code> contains tests for the class <code>{@link EchallanConfiguration}</code>.
 *
 * @generatedBy CodePro at 24/5/20 8:47 AM
 * @author Aniket.Marathe
 * @version $Revision: 1.0 $
 */
public class EcConfigurationTest {
	/**
	 * Run the EchallanConfiguration() constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 24/5/20 8:47 AM
	 */
	@Test
	public void testEchallanConfiguration_1()
		throws Exception {

		EchallanConfiguration result = new EchallanConfiguration();

		
		assertNotNull(result);
		assertEquals(null, result.getTimeZone());
		assertEquals(null, result.getWfTransitionPath());
		assertEquals(null, result.getMdmsHost());
		assertEquals(null, result.getIdGenHost());
		assertEquals(null, result.getIdGenPath());
		assertEquals(null, result.getMdmsEndPoint());
		assertEquals(null, result.getWfHost());
		assertEquals(null, result.getWfBusinessServiceSearchPath());
		assertEquals(null, result.getUpdatePenaltyAmountTopic());
		assertEquals(null, result.getFineMasterupdateTopic());
		assertEquals(null, result.getUpdateStoreItemTopic());
		assertEquals(null, result.getUpdateauctionTopic());
		assertEquals(null, result.getItemMasterUpdateTopic());
		assertEquals(null, result.getCreateStoreItemTopic());
		assertEquals(null, result.getEmailNotificationTopic());
		assertEquals(null, result.getGenerateChallanTopic());
		assertEquals(null, result.getSaveAuctionTopic());
		assertEquals(null, result.getUpdateVendorTopic());
		assertEquals(null, result.getFineMasterSaveTopic());
		assertEquals(null, result.getCreateVendorTopic());
		assertEquals(null, result.getUpdateStoreItemOfflineTopic());
		assertEquals(null, result.getApplicationNumberIdgenName());
		assertEquals(null, result.getApplicationNumberIdgenFormat());
		assertEquals(null, result.getItemMasterSaveTopic());
		assertEquals(null, result.getSmsNotificationTopic());
		assertEquals(null, result.getAddpaymentHistoryTopic());
		assertEquals(null, result.getUpdateChallanTopic());
		assertEquals(null, result.getUpdateChallanTopic());
		assertEquals(null, result.getRequestDeviceSource());
		assertEquals(null, result.getLoginUrl());
		assertEquals(null, result.getHrmsHost());
		assertEquals(null, result.getHrmsSearchEndpoint());
		assertEquals(null, result.getFileStoreHost());
		assertEquals(null, result.getFileStoreUrl());
		assertEquals(null, result.getUploadFile());
		assertEquals(null, result.getEchallanNotificationFlag());
	}

	/**
	 * Run the EchallanConfiguration(String,String,String,String,String,String,String,String,String,String,String,String,String,String,String,String,String,Boolean,String,String,String,String,String,String,Boolean,String,String,String,String,Boolean,String,String,String,String,String,String,String,String,String,String,String,String,String,String,String,String,String,String,String) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 24/5/20 8:47 AM
	 */
	@Test
	public void testEchallanConfiguration_2()
		throws Exception {
		String timeZone = "";
		String userHost = "";
		String userSearchEndpoint = "";
		String usernamePrefix = "";
		String idGenHost = "";
		String idGenPath = "";
		String applicationNumberIdgenName = "";
		String applicationNumberIdgenFormat = "";
		String saveTopic = "";
		String updateTopic = "";
		String updateWorkflowTopic = "";
		String localizationHost = "";
		String localizationContextPath = "";
		String localizationSearchEndpoint = "";
		Boolean isLocalizationStateLevel = new Boolean(true);
		String mdmsHost = "";
		String mdmsEndPoint = "";
		String loginUrl="";
		String businessServiceValue = "";
		String wfHost = "";
		String wfTransitionPath = "";
		String wfBusinessServiceSearchPath = "";
		Boolean isExternalWorkFlowEnabled = new Boolean(true);
		String uiAppHost = "";
		String saveUserEventsTopic = "";
		String payLink = "";
		String payCode = "";
		Boolean isUserEventsNotificationEnabled = new Boolean(true);
		String payTriggers = "";
		String businessService = "";
		String itemMasterSaveTopic = "";
		String itemMasterUpdateTopic = "";
		String FineMasterSaveTopic = "";
		String FineMasterupdateTopic = "";
		String emailNotificationTopic = "";
		String smsNotificationTopic = "";
		String generateChallanTopic = "";
		String updateChallanTopic = "";
		String CreateStoreItemTopic = "";
		String updateStoreItemTopic = "";
		String updateStoreItemOfflineTopic = "";
		String saveAuctionTopic = "";
		String updateauctionTopic = "";
		String updatePenaltyAmountTopic = "";
		String addpaymentHistoryTopic = "";
		String CreateVendorTopic = "";
		String UpdateVendorTopic = "";
		String RequestDeviceSource="";
		String echallanNotificationFlag="";
		String editChallanTopic="";
		
		EchallanConfiguration result = new EchallanConfiguration(timeZone, userHost, userSearchEndpoint, usernamePrefix, idGenHost, idGenPath, applicationNumberIdgenName, applicationNumberIdgenFormat, saveTopic, updateTopic, updateWorkflowTopic, localizationHost, localizationContextPath, localizationSearchEndpoint, mdmsHost, mdmsEndPoint, businessServiceValue, loginUrl, wfHost, wfTransitionPath, wfBusinessServiceSearchPath, uiAppHost, saveUserEventsTopic, payLink, payCode, payTriggers, businessService, itemMasterSaveTopic, itemMasterUpdateTopic, FineMasterSaveTopic, FineMasterupdateTopic, emailNotificationTopic, smsNotificationTopic, generateChallanTopic, updateChallanTopic, echallanNotificationFlag, echallanNotificationFlag, echallanNotificationFlag, echallanNotificationFlag, echallanNotificationFlag,editChallanTopic, editChallanTopic);

		
		assertNotNull(result);
		assertEquals("", result.getTimeZone());
		assertEquals("", result.getWfTransitionPath());
		assertEquals("", result.getMdmsHost());
		assertEquals("", result.getIdGenHost());
		assertEquals("", result.getIdGenPath());
		assertEquals("", result.getMdmsEndPoint());
		assertEquals("", result.getWfHost());
		assertEquals("", result.getWfBusinessServiceSearchPath());
		assertEquals("", result.getUpdatePenaltyAmountTopic());
		assertEquals("", result.getFineMasterupdateTopic());
		assertEquals("", result.getUpdateStoreItemTopic());
		assertEquals("", result.getUpdateauctionTopic());
		assertEquals("", result.getItemMasterUpdateTopic());
		assertEquals("", result.getCreateStoreItemTopic());
		assertEquals("", result.getEmailNotificationTopic());
		assertEquals("", result.getGenerateChallanTopic());
		assertEquals("", result.getSaveAuctionTopic());
		assertEquals("", result.getUpdateVendorTopic());
		assertEquals("", result.getFineMasterSaveTopic());
		assertEquals("", result.getCreateVendorTopic());
		assertEquals("", result.getUpdateStoreItemOfflineTopic());
		assertEquals("", result.getApplicationNumberIdgenName());
		assertEquals("", result.getApplicationNumberIdgenFormat());
		assertEquals("", result.getItemMasterSaveTopic());
		assertEquals("", result.getSmsNotificationTopic());
		assertEquals("", result.getAddpaymentHistoryTopic());
		assertEquals("", result.getUpdateChallanTopic());
		assertEquals("", result.getRequestDeviceSource());
		assertEquals("", result.getLoginUrl());
		assertEquals("", result.getEchallanNotificationFlag());
	}

	/**
	 * Run the EchallanConfiguration.EchallanConfigurationBuilder builder() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 24/5/20 8:47 AM
	 */
	@Test
	public void testBuilder_1()
		throws Exception {

		EchallanConfiguration.EchallanConfigurationBuilder result = EchallanConfiguration.builder();

		
		assertNotNull(result);
		assertEquals("EchallanConfiguration.EchallanConfigurationBuilder(timeZone=null, hrmsHost=null, hrmsSearchEndpoint=null, idGenHost=null, idGenPath=null, applicationNumberIdgenName=null, applicationNumberIdgenFormat=null, fileStoreHost=null, fileStoreUrl=null, uploadFile=null, mdmsHost=null, mdmsEndPoint=null, loginUrl=null, wfHost=null, wfTransitionPath=null, wfBusinessServiceSearchPath=null, itemMasterSaveTopic=null, itemMasterUpdateTopic=null, editChallanTopic=null, FineMasterSaveTopic=null, FineMasterupdateTopic=null, emailNotificationTopic=null, smsNotificationTopic=null, generateChallanTopic=null, updateChallanTopic=null, CreateStoreItemTopic=null, updateStoreItemTopic=null, updateStoreItemOfflineTopic=null, saveAuctionTopic=null, updateauctionTopic=null, rejectauctionTopic=null, updatePenaltyAmountTopic=null, addpaymentHistoryTopic=null, CreateVendorTopic=null, UpdateVendorTopic=null, RequestDeviceSource=null, updatePayment=null, dataBckChallan=null, echallanNotificationFlag=null, urlShortnerHost=null, urlShortnerPath=null)", result.toString());
	}
	
	@Test
	public void testBuilder_2()
		throws Exception {
		
		EchallanConfiguration.EchallanConfigurationBuilder builder = new EchallanConfiguration.EchallanConfigurationBuilder();
		builder.timeZone(null);
		builder.wfTransitionPath(null);
		builder.mdmsHost(null);
		builder.idGenHost(null);
		builder.idGenPath(null);
		builder.mdmsEndPoint(null);
		builder.wfHost(null);
		builder.wfBusinessServiceSearchPath(null);
		builder.updatePenaltyAmountTopic(null);
		builder.FineMasterSaveTopic(null);
		builder.updateStoreItemTopic(null);
		builder.updateauctionTopic(null);
		builder.itemMasterUpdateTopic(null);
		builder.updateStoreItemTopic(null);
		builder.emailNotificationTopic(null);
		builder.generateChallanTopic(null);
		builder.saveAuctionTopic(null);
		builder.UpdateVendorTopic(null);
		builder.FineMasterSaveTopic(null);
		builder.CreateVendorTopic(null);
		builder.updateStoreItemOfflineTopic(null);
		builder.applicationNumberIdgenName(null);
		builder.applicationNumberIdgenFormat(null);
		builder.itemMasterSaveTopic(null);
		builder.smsNotificationTopic(null);
		builder.addpaymentHistoryTopic(null);
		builder.updateChallanTopic(null);
		builder.RequestDeviceSource(null);
		builder.CreateStoreItemTopic(null);
		builder.FineMasterupdateTopic(null);
		builder.rejectauctionTopic(null);
		builder.loginUrl(null);
		builder.echallanNotificationFlag(null);
		builder.build();

		EchallanConfiguration.EchallanConfigurationBuilder builder2 = new EchallanConfiguration.EchallanConfigurationBuilder();
		builder2.timeZone(null);
		builder2.wfTransitionPath(null);
		builder2.mdmsHost(null);
		builder2.idGenHost(null);
		builder2.idGenPath(null);
		builder2.mdmsEndPoint(null);
		builder2.wfHost(null);
		builder2.wfBusinessServiceSearchPath(null);
		builder2.updatePenaltyAmountTopic(null);
		builder2.FineMasterSaveTopic(null);
		builder2.updateStoreItemTopic(null);
		builder2.updateauctionTopic(null);
		builder2.itemMasterUpdateTopic(null);
		builder2.updateStoreItemTopic(null);
		builder2.emailNotificationTopic(null);
		builder2.generateChallanTopic(null);
		builder2.saveAuctionTopic(null);
		builder2.UpdateVendorTopic(null);
		builder2.FineMasterSaveTopic(null);
		builder2.CreateVendorTopic(null);
		builder2.updateStoreItemOfflineTopic(null);
		builder2.applicationNumberIdgenName(null);
		builder2.applicationNumberIdgenFormat(null);
		builder2.itemMasterSaveTopic(null);
		builder2.smsNotificationTopic(null);
		builder2.addpaymentHistoryTopic(null);
		builder2.updateChallanTopic(null);
		builder2.RequestDeviceSource(null);
		builder2.FineMasterupdateTopic(null);
		builder2.CreateStoreItemTopic(null);
		builder2.FineMasterupdateTopic(null);
		builder2.rejectauctionTopic(null);
		builder2.loginUrl(null);
		builder2.echallanNotificationFlag(null);
		builder2.smsText(null);
		builder2.build();
	}
	
	

	/**
	 * Run the String getAddpaymentHistoryTopic() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 24/5/20 8:47 AM
	 */
	@Test
	public void testGetAddpaymentHistoryTopic_1()
		throws Exception {
		EchallanConfiguration fixture = new EchallanConfiguration("","", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "","", null,null, null, null, null);

		String result = fixture.getAddpaymentHistoryTopic();

		
		assertEquals("", result);
	}

	/**
	 * Run the String getApplicationNumberIdgenFormat() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 24/5/20 8:47 AM
	 */
	@Test
	public void testGetApplicationNumberIdgenFormat_1()
		throws Exception {
		EchallanConfiguration fixture = new EchallanConfiguration("", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "","","", null,null, null, null, null);

		String result = fixture.getApplicationNumberIdgenFormat();

		
		assertEquals("", result);
	}

	/**
	 * Run the String getApplicationNumberIdgenName() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 24/5/20 8:47 AM
	 */
	@Test
	public void testGetApplicationNumberIdgenName_1()
		throws Exception {
		EchallanConfiguration fixture = new EchallanConfiguration("", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "","","", null,null, null, null, null);

		String result = fixture.getApplicationNumberIdgenName();

		
		assertEquals("", result);
	}

	/**
	 * Run the String getCreateStoreItemTopic() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 24/5/20 8:47 AM
	 */
	@Test
	public void testGetCreateStoreItemTopic_1()
		throws Exception {
		EchallanConfiguration fixture = new EchallanConfiguration("", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "","","", null,null, null, null, null);

		String result = fixture.getCreateStoreItemTopic();

		
		assertEquals("", result);
	}

	/**
	 * Run the String getCreateVendorTopic() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 24/5/20 8:47 AM
	 */
	@Test
	public void testGetCreateVendorTopic_1()
		throws Exception {
		EchallanConfiguration fixture = new EchallanConfiguration("", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "","", "",null,null,null,null,null);

		String result = fixture.getCreateVendorTopic();

		
		assertEquals("", result);
	}

	/**
	 * Run the String getEmailNotificationTopic() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 24/5/20 8:47 AM
	 */
	@Test
	public void testGetEmailNotificationTopic_1()
		throws Exception {
		EchallanConfiguration fixture = new EchallanConfiguration("", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "","","", null,null,null,null,null);

		String result = fixture.getEmailNotificationTopic();

		
		assertEquals("", result);
	}

	/**
	 * Run the String getFineMasterSaveTopic() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 24/5/20 8:47 AM
	 */
	@Test
	public void testGetFineMasterSaveTopic_1()
		throws Exception {
		EchallanConfiguration fixture = new EchallanConfiguration("", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "","","", null,null,null,null,null);

		String result = fixture.getFineMasterSaveTopic();

		
		assertEquals("", result);
	}

	/**
	 * Run the String getFineMasterupdateTopic() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 24/5/20 8:47 AM
	 */
	@Test
	public void testGetFineMasterupdateTopic_1()
		throws Exception {
		EchallanConfiguration fixture = new EchallanConfiguration("", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "","","", null,null,null,null,null);

		String result = fixture.getFineMasterupdateTopic();

		
		assertEquals("", result);
	}

	/**
	 * Run the String getGenerateChallanTopic() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 24/5/20 8:47 AM
	 */
	@Test
	public void testGetGenerateChallanTopic_1()
		throws Exception {
		EchallanConfiguration fixture = new EchallanConfiguration("", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "","","", null,null,null,null,null);

		String result = fixture.getGenerateChallanTopic();

		
		assertEquals("", result);
	}

	/**
	 * Run the String getIdGenHost() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 24/5/20 8:47 AM
	 */
	@Test
	public void testGetIdGenHost_1()
		throws Exception {
		EchallanConfiguration fixture = new EchallanConfiguration("","", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "","", null,null,null,null,null);

		String result = fixture.getIdGenHost();

		
		assertEquals("", result);
	}

	/**
	 * Run the String getIdGenPath() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 24/5/20 8:47 AM
	 */
	@Test
	public void testGetIdGenPath_1()
		throws Exception {
		EchallanConfiguration fixture = new EchallanConfiguration("","", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "","", null,null,null,null,null);

		String result = fixture.getIdGenPath();

		
		assertEquals("", result);
	}

	/**
	 * Run the String getItemMasterSaveTopic() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 24/5/20 8:47 AM
	 */
	@Test
	public void testGetItemMasterSaveTopic_1()
		throws Exception {
		EchallanConfiguration fixture = new EchallanConfiguration("","", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "","", null,null,null,null,null);

		String result = fixture.getItemMasterSaveTopic();

		
		assertEquals("", result);
	}

	/**
	 * Run the String getItemMasterUpdateTopic() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 24/5/20 8:47 AM
	 */
	@Test
	public void testGetItemMasterUpdateTopic_1()
		throws Exception {
		EchallanConfiguration fixture = new EchallanConfiguration("","", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "","", null,null,null,null, null);

		String result = fixture.getItemMasterUpdateTopic();

		
		assertEquals("", result);
	}

	/**
	 * Run the String getMdmsEndPoint() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 24/5/20 8:47 AM
	 */
	@Test
	public void testGetMdmsEndPoint_1()
		throws Exception {
		EchallanConfiguration fixture = new EchallanConfiguration("", "","", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "","", null,null,null,null,null);

		String result = fixture.getMdmsEndPoint();

		
		assertEquals("", result);
	}

	/**
	 * Run the String getMdmsHost() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 24/5/20 8:47 AM
	 */
	@Test
	public void testGetMdmsHost_1()
		throws Exception {
		EchallanConfiguration fixture = new EchallanConfiguration("", "", "","", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "","", null,null,null,null,null);

		String result = fixture.getMdmsHost();

		
		assertEquals("", result);
	}
	
	/**
	 * Run the String getSaveAuctionTopic() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 24/5/20 8:47 AM
	 */
	@Test
	public void testGetSaveAuctionTopic_1()
		throws Exception {
		EchallanConfiguration fixture = new EchallanConfiguration("", "", "","", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "","", null,null,null,null,null);

		String result = fixture.getSaveAuctionTopic();

		
		assertEquals("", result);
	}

	/**
	 * Run the String getSmsNotificationTopic() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 24/5/20 8:47 AM
	 */
	@Test
	public void testGetSmsNotificationTopic_1()
		throws Exception {
		EchallanConfiguration fixture = new EchallanConfiguration("", "", "", "","", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "","", null,null,null,null,null);

		String result = fixture.getSmsNotificationTopic();

		
		assertEquals("", result);
	}

	/**
	 * Run the String getTimeZone() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 24/5/20 8:47 AM
	 */
	@Test
	public void testGetTimeZone_1()
		throws Exception {
		EchallanConfiguration fixture = new EchallanConfiguration("", "", "", "", "","", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "","", null,null,null,null,null);

		String result = fixture.getTimeZone();

		
		assertEquals("", result);
	}


	/**
	 * Run the String getUpdateChallanTopic() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 24/5/20 8:47 AM
	 */
	@Test
	public void testGetUpdateChallanTopic_1()
		throws Exception {
		EchallanConfiguration fixture = new EchallanConfiguration("", "", "", "", "", "", "","", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "","", null,null,null,null,null);

		String result = fixture.getUpdateChallanTopic();

		
		assertEquals("", result);
	}

	/**
	 * Run the String getUpdatePenaltyAmountTopic() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 24/5/20 8:47 AM
	 */
	@Test
	public void testGetUpdatePenaltyAmountTopic_1()
		throws Exception {
		EchallanConfiguration fixture = new EchallanConfiguration("", "", "", "", "", "", "", "","", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "","", null,null,null,null,null);

		String result = fixture.getUpdatePenaltyAmountTopic();

		
		assertEquals("", result);
	}

	/**
	 * Run the String getUpdateStoreItemOfflineTopic() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 24/5/20 8:47 AM
	 */
	@Test
	public void testGetUpdateStoreItemOfflineTopic_1()
		throws Exception {
		EchallanConfiguration fixture = new EchallanConfiguration("", "", "", "", "", "", "", "","", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "","", null,null,null,null,null);

		String result = fixture.getUpdateStoreItemOfflineTopic();

		
		assertEquals("", result);
	}

	/**
	 * Run the String getUpdateStoreItemTopic() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 24/5/20 8:47 AM
	 */
	@Test
	public void testGetUpdateStoreItemTopic_1()
		throws Exception {
		EchallanConfiguration fixture = new EchallanConfiguration("", "", "", "", "", "", "", "", "","", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "","", null,null,null,null,null);

		String result = fixture.getUpdateStoreItemTopic();

		
		assertEquals("", result);
	}

	/**
	 * Run the String getUpdateVendorTopic() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 24/5/20 8:47 AM
	 */
	@Test
	public void testGetUpdateVendorTopic_1()
		throws Exception {
		EchallanConfiguration fixture = new EchallanConfiguration("", "", "", "", "", "", "", "", "", "","", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "","", null,null,null,null,null);

		String result = fixture.getUpdateVendorTopic();

		
		assertEquals("", result);
	}
	
	@Test
	public void testGetRequestDeviceSource_1()
		throws Exception {
		EchallanConfiguration fixture = new EchallanConfiguration("", "", "", "", "", "", "", "", "", "", "","", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "","", null,null,null,null,null);

		String result = fixture.getRequestDeviceSource();

		
		assertEquals("", result);
	}

	/**
	 * Run the String getUpdateauctionTopic() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 24/5/20 8:47 AM
	 */
	@Test
	public void testGetUpdateauctionTopic_1()
		throws Exception {
		EchallanConfiguration fixture = new EchallanConfiguration("", "", "", "", "", "", "", "", "", "", "", "","", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "","", null,null,null,null,null);

		String result = fixture.getUpdateauctionTopic();

		
		assertEquals("", result);
	}
	
	@Test
	public void testGetRejectAuctionTopic_1()
		throws Exception {
		EchallanConfiguration fixture = new EchallanConfiguration("", "", "", "", "", "", "", "", "", "", "", "", "","", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "","", null,null,null,null,null);

		String result = fixture.getRejectauctionTopic();

		
		assertEquals("", result);
	}

	/**
	 * Run the String getWfBusinessServiceSearchPath() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 24/5/20 8:47 AM
	 */
	@Test
	public void testGetWfBusinessServiceSearchPath_1()
		throws Exception {
		EchallanConfiguration fixture = new EchallanConfiguration("", "", "", "", "", "", "", "", "", "", "", "", "", "","", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "","", null,null,null,null,null);

		String result = fixture.getWfBusinessServiceSearchPath();

		
		assertEquals("", result);
	}

	/**
	 * Run the String getWfHost() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 24/5/20 8:47 AM
	 */
	@Test
	public void testGetWfHost_1()
		throws Exception {
		EchallanConfiguration fixture = new EchallanConfiguration("", "", "", "", "", "", "", "", "", "", "", "", "", "","", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "","", null,null,null,null,null);

		String result = fixture.getWfHost();

		
		assertEquals("", result);
	}

	/**
	 * Run the String getWfTransitionPath() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 24/5/20 8:47 AM
	 */
	@Test
	public void testGetWfTransitionPath_1()
		throws Exception {
		EchallanConfiguration fixture = new EchallanConfiguration("", "", "", "", "", "", "", "", "", "", "", "", "", "", "","", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "","", null,null,null,null,null);

		String result = fixture.getWfTransitionPath();

		
		assertEquals("", result);
	}

	/**
	 * Run the void initialize() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 24/5/20 8:47 AM
	 */
	@Test
	public void testInitialize_1()
		throws Exception {
		EchallanConfiguration fixture = new EchallanConfiguration("", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "","", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "","", null,null,null,null,null);

		fixture.initialize();

		
	}

	/**
	 * Run the MappingJackson2HttpMessageConverter jacksonConverter(ObjectMapper) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 24/5/20 8:47 AM
	 */
	@Test
	public void testJacksonConverter_1()
		throws Exception {
		EchallanConfiguration fixture = new EchallanConfiguration("","", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "","", null,null,null,null,null);
		ObjectMapper objectMapper = new ObjectMapper();

		MappingJackson2HttpMessageConverter result = fixture.jacksonConverter(objectMapper);

		
		assertNotNull(result);
	}

	/**
	 * Run the void setAddpaymentHistoryTopic(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 24/5/20 8:47 AM
	 */
	@Test
	public void testSetAddpaymentHistoryTopic_1()
		throws Exception {
		EchallanConfiguration fixture = new EchallanConfiguration("","", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "","", null,null,null,null,null);
		String addpaymentHistoryTopic = "";

		fixture.setAddpaymentHistoryTopic(addpaymentHistoryTopic);

		
	}

	/**
	 * Run the void setApplicationNumberIdgenFormat(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 24/5/20 8:47 AM
	 */
	@Test
	public void testSetApplicationNumberIdgenFormat_1()
		throws Exception {
		EchallanConfiguration fixture = new EchallanConfiguration("","", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "","", null,null,null,null,null);
		String applicationNumberIdgenFormat = "";

		fixture.setApplicationNumberIdgenFormat(applicationNumberIdgenFormat);

		
	}

	/**
	 * Run the void setApplicationNumberIdgenName(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 24/5/20 8:47 AM
	 */
	@Test
	public void testSetApplicationNumberIdgenName_1()
		throws Exception {
		EchallanConfiguration fixture = new EchallanConfiguration("","", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "","", null,null,null,null,null);
		String applicationNumberIdgenName = "";

		fixture.setApplicationNumberIdgenName(applicationNumberIdgenName);

		
	}

	/**
	 * Run the void setCreateStoreItemTopic(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 24/5/20 8:47 AM
	 */
	@Test
	public void testSetCreateStoreItemTopic_1()
		throws Exception {
		EchallanConfiguration fixture = new EchallanConfiguration("", "","", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "","", null,null,null,null,null);
		String CreateStoreItemTopic = "";

		fixture.setCreateStoreItemTopic(CreateStoreItemTopic);

		
	}

	/**
	 * Run the void setCreateVendorTopic(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 24/5/20 8:47 AM
	 */
	@Test
	public void testSetCreateVendorTopic_1()
		throws Exception {
		EchallanConfiguration fixture = new EchallanConfiguration("", "", "","", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "","", null,null,null,null,null);
		String CreateVendorTopic = "";

		fixture.setCreateVendorTopic(CreateVendorTopic);

		
	}

	/**
	 * Run the void setEmailNotificationTopic(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 24/5/20 8:47 AM
	 */
	@Test
	public void testSetEmailNotificationTopic_1()
		throws Exception {
		EchallanConfiguration fixture = new EchallanConfiguration("", "", "", "","", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "","", null,null,null,null,null);
		String emailNotificationTopic = "";

		fixture.setEmailNotificationTopic(emailNotificationTopic);

		
	}

	/**
	 * Run the void setFineMasterSaveTopic(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 24/5/20 8:47 AM
	 */
	@Test
	public void testSetFineMasterSaveTopic_1()
		throws Exception {
		EchallanConfiguration fixture = new EchallanConfiguration("", "", "", "", "","", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "","", null,null,null,null,null);
		String FineMasterSaveTopic = "";

		fixture.setFineMasterSaveTopic(FineMasterSaveTopic);

		
	}

	/**
	 * Run the void setFineMasterupdateTopic(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 24/5/20 8:47 AM
	 */
	@Test
	public void testSetFineMasterupdateTopic_1()
		throws Exception {
		EchallanConfiguration fixture = new EchallanConfiguration("", "", "", "", "","", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "","", null,null,null,null,null);
		String FineMasterupdateTopic = "";

		fixture.setFineMasterupdateTopic(FineMasterupdateTopic);

		
	}

	/**
	 * Run the void setGenerateChallanTopic(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 24/5/20 8:47 AM
	 */
	@Test
	public void testSetGenerateChallanTopic_1()
		throws Exception {
		EchallanConfiguration fixture = new EchallanConfiguration("", "", "", "", "", "","", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "","", null,null,null,null,null);
		String generateChallanTopic = "";

		fixture.setGenerateChallanTopic(generateChallanTopic);

		
	}

	/**
	 * Run the void setIdGenHost(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 24/5/20 8:47 AM
	 */
	@Test
	public void testSetIdGenHost_1()
		throws Exception {
		EchallanConfiguration fixture = new EchallanConfiguration("", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "","","", null,null,null,null,null);
		String idGenHost = "";

		fixture.setIdGenHost(idGenHost);

		
	}

	/**
	 * Run the void setIdGenPath(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 24/5/20 8:47 AM
	 */
	@Test
	public void testSetIdGenPath_1()
		throws Exception {
		EchallanConfiguration fixture = new EchallanConfiguration("", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "","","", null,null,null,null,null);
		String idGenPath = "";

		fixture.setIdGenPath(idGenPath);

		
	}

	/**
	 * Run the void setItemMasterSaveTopic(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 24/5/20 8:47 AM
	 */
	@Test
	public void testSetItemMasterSaveTopic_1()
		throws Exception {
		EchallanConfiguration fixture = new EchallanConfiguration("", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "","","", null,null,null,null,null);
		String itemMasterSaveTopic = "";

		fixture.setItemMasterSaveTopic(itemMasterSaveTopic);

		
	}

	/**
	 * Run the void setItemMasterUpdateTopic(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 24/5/20 8:47 AM
	 */
	@Test
	public void testSetItemMasterUpdateTopic_1()
		throws Exception {
		EchallanConfiguration fixture = new EchallanConfiguration("", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "","","", null,null,null,null,null);
		String itemMasterUpdateTopic = "";

		fixture.setItemMasterUpdateTopic(itemMasterUpdateTopic);

		
	}

	/**
	 * Run the void setMdmsEndPoint(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 24/5/20 8:47 AM
	 */
	@Test
	public void testSetMdmsEndPoint_1()
		throws Exception {
		EchallanConfiguration fixture = new EchallanConfiguration("", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "","","", null,null,null,null,null);
		String mdmsEndPoint = "";

		fixture.setMdmsEndPoint(mdmsEndPoint);

		
	}

	/**
	 * Run the void setMdmsHost(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 24/5/20 8:47 AM
	 */
	@Test
	public void testSetMdmsHost_1()
		throws Exception {
		EchallanConfiguration fixture = new EchallanConfiguration("", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "","","", null,null,null,null,null);
		String mdmsHost = "";

		fixture.setMdmsHost(mdmsHost);

		
	}

	/**
	 * Run the void setSaveAuctionTopic(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 24/5/20 8:47 AM
	 */
	@Test
	public void testSetSaveAuctionTopic_1()
		throws Exception {
		EchallanConfiguration fixture = new EchallanConfiguration("", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "","","", null,null,null,null,null);
		String saveAuctionTopic = "";

		fixture.setSaveAuctionTopic(saveAuctionTopic);

		
	}

	/**
	 * Run the void setSmsNotificationTopic(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 24/5/20 8:47 AM
	 */
	@Test
	public void testSetSmsNotificationTopic_1()
		throws Exception {
		EchallanConfiguration fixture = new EchallanConfiguration("", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "","","", null,null,null,null,null);
		String smsNotificationTopic = "";

		fixture.setSmsNotificationTopic(smsNotificationTopic);

		
	}

	/**
	 * Run the void setTimeZone(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 24/5/20 8:47 AM
	 */
	@Test
	public void testSetTimeZone_1()
		throws Exception {
		EchallanConfiguration fixture = new EchallanConfiguration("", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "","","", null,null,null,null,null);
		String timeZone = "";

		fixture.setTimeZone(timeZone);

		
	}

	/**
	 * Run the void setUpdateChallanTopic(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 24/5/20 8:47 AM
	 */
	@Test
	public void testSetUpdateChallanTopic_1()
		throws Exception {
		EchallanConfiguration fixture = new EchallanConfiguration("", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "","","", null,null,null,null,null);
		String updateChallanTopic = "";

		fixture.setUpdateChallanTopic(updateChallanTopic);

		
	}

	/**
	 * Run the void setUpdatePenaltyAmountTopic(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 24/5/20 8:47 AM
	 */
	@Test
	public void testSetUpdatePenaltyAmountTopic_1()
		throws Exception {
		EchallanConfiguration fixture = new EchallanConfiguration("", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "","","", null,null,null,null,null);
		String updatePenaltyAmountTopic = "";

		fixture.setUpdatePenaltyAmountTopic(updatePenaltyAmountTopic);

		
	}

	/**
	 * Run the void setUpdateStoreItemOfflineTopic(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 24/5/20 8:47 AM
	 */
	@Test
	public void testSetUpdateStoreItemOfflineTopic_1()
		throws Exception {
		EchallanConfiguration fixture = new EchallanConfiguration("", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "","","", null,null,null,null,null);
		String updateStoreItemOfflineTopic = "";

		fixture.setUpdateStoreItemOfflineTopic(updateStoreItemOfflineTopic);

		
	}

	/**
	 * Run the void setUpdateStoreItemTopic(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 24/5/20 8:47 AM
	 */
	@Test
	public void testSetUpdateStoreItemTopic_1()
		throws Exception {
		EchallanConfiguration fixture = new EchallanConfiguration("", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "","","", null,null,null,null,null);
		String updateStoreItemTopic = "";

		fixture.setUpdateStoreItemTopic(updateStoreItemTopic);

		
	}

	/**
	 * Run the void setUpdateVendorTopic(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 24/5/20 8:47 AM
	 */
	@Test
	public void testSetUpdateVendorTopic_1()
		throws Exception {
		EchallanConfiguration fixture = new EchallanConfiguration("", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "","","", null,null,null,null,null);
		String UpdateVendorTopic = "";

		fixture.setUpdateVendorTopic(UpdateVendorTopic);

		
	}

	/**
	 * Run the void setUpdateauctionTopic(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 24/5/20 8:47 AM
	 */
	@Test
	public void testSetUpdateauctionTopic_1()
		throws Exception {
		EchallanConfiguration fixture = new EchallanConfiguration("", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "","","", null,null,null,null,null);
		String updateauctionTopic = "";

		fixture.setUpdateauctionTopic(updateauctionTopic);

		
	}

	/**
	 * Run the void setWfBusinessServiceSearchPath(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 24/5/20 8:47 AM
	 */
	@Test
	public void testSetWfBusinessServiceSearchPath_1()
		throws Exception {
		EchallanConfiguration fixture = new EchallanConfiguration("", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "","","", null,null,null,null,null);
		String wfBusinessServiceSearchPath = "";

		fixture.setWfBusinessServiceSearchPath(wfBusinessServiceSearchPath);

		
	}

	/**
	 * Run the void setWfHost(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 24/5/20 8:47 AM
	 */
	@Test
	public void testSetWfHost_1()
		throws Exception {
		EchallanConfiguration fixture = new EchallanConfiguration("", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "","","", null,null,null,null,null);
		String wfHost = "";

		fixture.setWfHost(wfHost);

		
	}
	
	@Test
	public void testSetRejectauctionTopic_1()
		throws Exception {
		EchallanConfiguration fixture = new EchallanConfiguration("", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "","","", null,null,null,null,null);
		String rejectauctionTopic = "";

		fixture.setRejectauctionTopic(rejectauctionTopic);;

		
	}

	/**
	 * Run the void setWfTransitionPath(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 24/5/20 8:47 AM
	 */
	@Test
	public void testSetWfTransitionPath_1()
		throws Exception {
		EchallanConfiguration fixture = new EchallanConfiguration("", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "","","", null,null,null,null,null);
		String wfTransitionPath = "";

		fixture.setWfTransitionPath(wfTransitionPath);

		
	}
	
	@Test
	public void testSetRequestDeviceSource_1()
		throws Exception {
		EchallanConfiguration fixture = new EchallanConfiguration("", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "","","", null,null,null,null,null);
		String RequestDeviceSource = "";

		fixture.setRequestDeviceSource(RequestDeviceSource);

		
	}
	
	@Test
	public void testSetLoginUrl_1()
		throws Exception {
		EchallanConfiguration fixture = new EchallanConfiguration("","", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "","", null,null, null, null, null);
		String loginUrl = "";

		fixture.setLoginUrl(loginUrl);

		
	}
	
	@Test
	public void testGetLoginUrl_1()
		throws Exception {
		EchallanConfiguration fixture = new EchallanConfiguration("","", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "","", null,null, null, null, null);

		String result = fixture.getLoginUrl();		
		assertEquals("", result);
	}
	
	@Test
	public void testSetEchallanNotificationFlag_1()
		throws Exception {
		EchallanConfiguration fixture = new EchallanConfiguration("","", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "","", null,null, null, null, null);
		String echallanNotificationFlag = "";

		fixture.setEchallanNotificationFlag(echallanNotificationFlag);

		
	}
	
	@Test
	public void testGetEchallanNotificationFlag_1()
		throws Exception {
		EchallanConfiguration fixture = new EchallanConfiguration("","", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", null);

		String result = fixture.getEchallanNotificationFlag();		
		assertEquals("", result);
	}
}