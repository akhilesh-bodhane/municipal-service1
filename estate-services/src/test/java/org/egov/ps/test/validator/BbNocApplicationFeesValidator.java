package org.egov.ps.test.validator;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import org.egov.ps.model.Application;
import org.egov.ps.model.calculation.Category;
import org.egov.ps.service.ApplicationEnrichmentService;
import org.egov.ps.util.PSConstants;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

@ActiveProfiles("test")
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class BbNocApplicationFeesValidator {

	@Autowired
	ApplicationEnrichmentService applicationEnrichmentService;

	ObjectMapper objectMapper = new ObjectMapper();
	ObjectNode applicationDetails = objectMapper.createObjectNode();

	@Test
	public void testDevelopmentTaxHeadCode() {
		Application application = Application.builder().branchType("BuildingBranch").applicationType("NOC").build();
		assertEquals("ESTATE_SERVICE_BUILDING_BRANCH.NOC_APPLICATION_DEVELOPMENT_CHARGES",
				applicationEnrichmentService.getBbNocTaxHeadCode(application.getBillingBusinessService(),
						PSConstants.TAX_HEAD_CODE_APPLICATION_CHARGE, "DEVELOPMENT", Category.CHARGES));
	}

	@Test
	public void testConversionTaxHeadCode() {
		Application application = Application.builder().branchType("BuildingBranch").applicationType("NOC").build();
		assertEquals("ESTATE_SERVICE_BUILDING_BRANCH.NOC_APPLICATION_CONVERSION_CHARGES",
				applicationEnrichmentService.getBbNocTaxHeadCode(application.getBillingBusinessService(),
						PSConstants.TAX_HEAD_CODE_APPLICATION_CHARGE, "CONVERSION", Category.CHARGES));
	}

	@Test
	public void testScrutinyTaxHeadCode() {
		Application application = Application.builder().branchType("BuildingBranch").applicationType("NOC").build();
		assertEquals("ESTATE_SERVICE_BUILDING_BRANCH.NOC_APPLICATION_SCRUTINY_CHARGES",
				applicationEnrichmentService.getBbNocTaxHeadCode(application.getBillingBusinessService(),
						PSConstants.TAX_HEAD_CODE_APPLICATION_CHARGE, "SCRUTINY", Category.CHARGES));
	}

	@Test
	public void testTransferTaxHeadCode() {
		Application application = Application.builder().branchType("BuildingBranch").applicationType("NOC").build();
		assertEquals("ESTATE_SERVICE_BUILDING_BRANCH.NOC_APPLICATION_TRANSFER_FEE",
				applicationEnrichmentService.getBbNocTaxHeadCode(application.getBillingBusinessService(),
						PSConstants.TAX_HEAD_CODE_APPLICATION_CHARGE, "TRANSFER", Category.FEE));
	}

	@Test
	public void testAllotmentNumberTaxHeadCode() {
		Application application = Application.builder().branchType("BuildingBranch").applicationType("NOC").build();
		assertEquals("ESTATE_SERVICE_BUILDING_BRANCH.NOC_APPLICATION_ALLOTMENT_NUMBER_CHARGES",
				applicationEnrichmentService.getBbNocTaxHeadCode(application.getBillingBusinessService(),
						PSConstants.TAX_HEAD_CODE_APPLICATION_CHARGE, "ALLOTMENT_NUMBER", Category.CHARGES));
	}

	@Test
	public void testCalculateDevelopmentChargesWithoutSideStreet() {

		((ObjectNode) applicationDetails).put("frontElevationWidth", 35);
		((ObjectNode) applicationDetails).put("frontElevationWidthInch", 0);
		((ObjectNode) applicationDetails).put("streetWidth", 10);
		((ObjectNode) applicationDetails).put("streetWidthInch", 6);
		((ObjectNode) applicationDetails).put("otherSideStreet", false);
		((ObjectNode) applicationDetails).put("sameWidthOfSideStreet", 35);
		((ObjectNode) applicationDetails).put("sameWidthOfSideStreetInch", 0);
		((ObjectNode) applicationDetails).put("sameHeightOfSideStreet", 10);
		((ObjectNode) applicationDetails).put("sameHeightOfSideStreetInch", 6);

		BigDecimal expectedValue = new BigDecimal("18375.00");
		BigDecimal actualValue = applicationEnrichmentService.calculateDevelopmentCharges(applicationDetails);

		org.junit.Assert.assertTrue(expectedValue.compareTo(actualValue) == 0);

	}

	@Test
	public void testCalculateDevelopmentChargesWithSideStreet() {

		((ObjectNode) applicationDetails).put("frontElevationWidth", 35);
		((ObjectNode) applicationDetails).put("frontElevationWidthInch", 0);
		((ObjectNode) applicationDetails).put("streetWidth", 10);
		((ObjectNode) applicationDetails).put("streetWidthInch", 6);
		((ObjectNode) applicationDetails).put("otherSideStreet", true);
		((ObjectNode) applicationDetails).put("sameWidthOfSideStreet", 35);
		((ObjectNode) applicationDetails).put("sameWidthOfSideStreetInch", 0);
		((ObjectNode) applicationDetails).put("sameHeightOfSideStreet", 10);
		((ObjectNode) applicationDetails).put("sameHeightOfSideStreetInch", 6);

		BigDecimal expectedValue = new BigDecimal("36750.00");
		BigDecimal actualValue = applicationEnrichmentService.calculateDevelopmentCharges(applicationDetails);

		org.junit.Assert.assertTrue(expectedValue.compareTo(actualValue) == 0);

	}

	@Test
	public void testcalculateConversionChargesNotApplicable() {

		((ObjectNode) applicationDetails).put("commercialActivity", false);
		((ObjectNode) applicationDetails).put("groundFloorcommercialActivity", 50);
		((ObjectNode) applicationDetails).put("groundFloorcommercialActivityInch", 0);
		((ObjectNode) applicationDetails).put("firstFloorcommercialActivity", 0);
		((ObjectNode) applicationDetails).put("firstFloorcommercialActivityInch", 0);
		((ObjectNode) applicationDetails).put("secondFloorcommercialActivity", 0);
		((ObjectNode) applicationDetails).put("secondFloorcommercialActivityInch", 0);

		BigDecimal expectedValue = new BigDecimal("0.00");
		BigDecimal actualValue = applicationEnrichmentService.calculateConversionCharges(applicationDetails);

		org.junit.Assert.assertTrue(expectedValue.compareTo(actualValue) == 0);

	}

	@Test
	public void testcalculateConversionChargesGroundFloor() {

		((ObjectNode) applicationDetails).put("commercialActivity", true);
		((ObjectNode) applicationDetails).put("groundFloorcommercialActivity", 400);
		((ObjectNode) applicationDetails).put("groundFloorcommercialActivityInch", 0);
		((ObjectNode) applicationDetails).put("firstFloorcommercialActivity", 0);
		((ObjectNode) applicationDetails).put("firstFloorcommercialActivityInch", 0);
		((ObjectNode) applicationDetails).put("secondFloorcommercialActivity", 0);
		((ObjectNode) applicationDetails).put("secondFloorcommercialActivityInch", 0);

		BigDecimal expectedValue = new BigDecimal("106666.67");
		BigDecimal actualValue = applicationEnrichmentService.calculateConversionCharges(applicationDetails);

		org.junit.Assert.assertTrue(expectedValue.compareTo(actualValue) == 0);

	}

	@Test
	public void testcalculateConversionChargesFirstFloor() {

		((ObjectNode) applicationDetails).put("commercialActivity", true);
		((ObjectNode) applicationDetails).put("groundFloorcommercialActivity", 400);
		((ObjectNode) applicationDetails).put("groundFloorcommercialActivityInch", 0);
		((ObjectNode) applicationDetails).put("firstFloorcommercialActivity", 200);
		((ObjectNode) applicationDetails).put("firstFloorcommercialActivityInch", 0);
		((ObjectNode) applicationDetails).put("secondFloorcommercialActivity", 0);
		((ObjectNode) applicationDetails).put("secondFloorcommercialActivityInch", 0);

		BigDecimal expectedValue = new BigDecimal("160000.00");
		BigDecimal actualValue = applicationEnrichmentService.calculateConversionCharges(applicationDetails);

		org.junit.Assert.assertTrue(expectedValue.compareTo(actualValue) == 0);

	}

	@Test
	public void testcalculateConversionChargesSecondFloor() {

		((ObjectNode) applicationDetails).put("commercialActivity", true);
		((ObjectNode) applicationDetails).put("groundFloorcommercialActivity", 400);
		((ObjectNode) applicationDetails).put("groundFloorcommercialActivityInch", 0);
		((ObjectNode) applicationDetails).put("firstFloorcommercialActivity", 200);
		((ObjectNode) applicationDetails).put("firstFloorcommercialActivityInch", 0);
		((ObjectNode) applicationDetails).put("secondFloorcommercialActivity", 300);
		((ObjectNode) applicationDetails).put("secondFloorcommercialActivityInch", 0);

		BigDecimal expectedValue = new BigDecimal("240000.00");
		BigDecimal actualValue = applicationEnrichmentService.calculateConversionCharges(applicationDetails);

		org.junit.Assert.assertTrue(expectedValue.compareTo(actualValue) == 0);

	}

	@Test
	public void testBigDecimalRoundHalfEven() {

		BigDecimal expectedValue = new BigDecimal("240000.554");
		expectedValue = expectedValue.setScale(2, BigDecimal.ROUND_HALF_EVEN);
		BigDecimal actualValue = new BigDecimal("240000.55");

		org.junit.Assert.assertTrue(expectedValue.compareTo(actualValue) == 0);

		BigDecimal expectedValue1 = new BigDecimal("240000.555");
		expectedValue1 = expectedValue1.setScale(2, BigDecimal.ROUND_HALF_EVEN);
		BigDecimal actualValue1 = new BigDecimal("240000.56");

		org.junit.Assert.assertTrue(expectedValue1.compareTo(actualValue1) == 0);

		BigDecimal expectedValue2 = new BigDecimal("240000.556");
		expectedValue2 = expectedValue2.setScale(2, BigDecimal.ROUND_HALF_EVEN);
		BigDecimal actualValue2 = new BigDecimal("240000.56");

		org.junit.Assert.assertTrue(expectedValue2.compareTo(actualValue2) == 0);
	}

	@Test
	public void testObjectNodeToBigDecimal() {

		((ObjectNode) applicationDetails).put("scrutinyCharges", "100");
		((ObjectNode) applicationDetails).put("transferFee", 100);
		((ObjectNode) applicationDetails).put("applicationNumberCharges", 100.0);

		BigDecimal scrutinyCharges = BigDecimal.ZERO;
		if (null != applicationDetails.get("scrutinyCharges")) {
			scrutinyCharges = new BigDecimal(applicationDetails.get("scrutinyCharges").asText());
		}

		BigDecimal transferFee = BigDecimal.ZERO;
		if (null != applicationDetails.get("transferFee")) {
			transferFee = new BigDecimal(applicationDetails.get("transferFee").asText());
		}

		BigDecimal applicationNumberCharges = BigDecimal.ZERO;
		if (null != applicationDetails.get("applicationNumberCharges")) {
			applicationNumberCharges = new BigDecimal(applicationDetails.get("applicationNumberCharges").asText());
		}

		BigDecimal expectedValue = new BigDecimal("100");
		org.junit.Assert.assertTrue(expectedValue.compareTo(scrutinyCharges) == 0);

		org.junit.Assert.assertTrue(expectedValue.compareTo(transferFee) == 0);

		org.junit.Assert.assertTrue(expectedValue.compareTo(applicationNumberCharges) == 0);

	}

}
