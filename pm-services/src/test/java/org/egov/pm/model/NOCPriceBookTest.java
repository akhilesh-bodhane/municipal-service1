package org.egov.pm.model;

import org.junit.*;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.Silent.class)
public class NOCPriceBookTest {

	@Test
	public void testNOCPriceBook_1() throws Exception {

		NOCPriceBook result = new NOCPriceBook();

		assertNotNull(result);
		assertEquals(null, result.getLastModifiedTime());
		assertEquals(false, result.isActive());
		assertEquals(null, result.getCategoryId());
		assertEquals(null, result.getPriceBookId());
		assertEquals(null, result.getCreatedTime());
		assertEquals(null, result.getCreatedBy());
		assertEquals(null, result.getPerDayPrice());
		assertEquals(null, result.getAnnualPrice());
		assertEquals(null, result.getFixedPrice());
		assertEquals(null, result.getSubCategoryId());
		assertEquals(null, result.getMinSqft());
		assertEquals(null, result.getMaxSqft());
		assertEquals(null, result.getPerWeekPrice());
		assertEquals(null, result.getPerMonthPrice());
		assertEquals(null, result.getTenantId());
		assertEquals(null, result.getEffectiveFromDate());
		assertEquals(null, result.getCalculationSequence());
		assertEquals(null, result.getLastModifiedBy());
		assertEquals(null, result.getApplicationType());
		assertEquals(null, result.getEffectiveToDate());
	}

	@Test
	public void testNOCPriceBook_2() throws Exception {
		String priceBookId = "";
		String applicationType = "";
		String categoryId = "";
		String subCategoryId = "";
		Long minSqft = new Long(1L);
		Long maxSqft = new Long(1L);
		Long perDayPrice = new Long(1L);
		Long perWeekPrice = new Long(1L);
		Long perMonthPrice = new Long(1L);
		Long annualPrice = new Long(1L);
		Long fixedPrice = new Long(1L);
		String effectiveFromDate = "";
		String effectiveToDate = "";
		String tenantId = "";
		boolean isActive = true;
		String createdBy = "";
		Long createdTime = new Long(1L);
		String lastModifiedBy = "";
		Long lastModifiedTime = new Long(1L);
		Integer calculationSequence = new Integer(1);

		NOCPriceBook result = new NOCPriceBook(priceBookId, applicationType, categoryId, subCategoryId, minSqft,
				maxSqft, perDayPrice, perWeekPrice, perMonthPrice, annualPrice, fixedPrice, effectiveFromDate,
				effectiveToDate, tenantId, isActive, createdBy, createdTime, lastModifiedBy, lastModifiedTime,
				calculationSequence, lastModifiedBy);

		result.setCalculationType("range");
		assertNotNull(result);
		assertEquals(new Long(1L), result.getLastModifiedTime());
		assertEquals(true, result.isActive());
		assertEquals("", result.getCategoryId());
		assertEquals("", result.getPriceBookId());
		assertEquals(new Long(1L), result.getCreatedTime());
		assertEquals("", result.getCreatedBy());
		assertEquals(new Long(1L), result.getPerDayPrice());
		assertEquals(new Long(1L), result.getAnnualPrice());
		assertEquals(new Long(1L), result.getFixedPrice());
		assertEquals("", result.getSubCategoryId());
		assertEquals(new Long(1L), result.getMinSqft());
		assertEquals(new Long(1L), result.getMaxSqft());
		assertEquals(new Long(1L), result.getPerWeekPrice());
		assertEquals(new Long(1L), result.getPerMonthPrice());
		assertEquals("", result.getTenantId());
		assertEquals("", result.getEffectiveFromDate());
		assertEquals(new Integer(1), result.getCalculationSequence());
		assertEquals("", result.getLastModifiedBy());
		assertEquals("", result.getApplicationType());
		assertEquals("", result.getEffectiveToDate());
		assertEquals("range", result.getCalculationType());
	}

	@Test
	public void testBuilder_1() throws Exception {

		NOCPriceBook.NOCPriceBookBuilder result = NOCPriceBook.builder();

		assertNotNull(result);
		assertEquals(
				"NOCPriceBook.NOCPriceBookBuilder(priceBookId=null, applicationType=null, categoryId=null, subCategoryId=null, minSqft=null, maxSqft=null, perDayPrice=null, perWeekPrice=null, perMonthPrice=null, annualPrice=null, fixedPrice=null, effectiveFromDate=null, effectiveToDate=null, tenantId=null, isActive=false, createdBy=null, createdTime=null, lastModifiedBy=null, lastModifiedTime=null, calculationSequence=null, calculationType=null)",
				result.toString());
	}

	@Test
	public void testGetAnnualPrice_1() throws Exception {
		NOCPriceBook fixture = new NOCPriceBook("", "", "", "", new Long(1L), new Long(1L), new Long(1L), new Long(1L),
				new Long(1L), new Long(1L), new Long(1L), "", "", "", true, "", new Long(1L), "", new Long(1L),
				new Integer(1), null);

		Long result = fixture.getAnnualPrice();

		assertNotNull(result);
		assertEquals("1", result.toString());
		assertEquals((byte) 1, result.byteValue());
		assertEquals((short) 1, result.shortValue());
		assertEquals(1, result.intValue());
		assertEquals(1L, result.longValue());
		assertEquals(1.0f, result.floatValue(), 1.0f);
		assertEquals(1.0, result.doubleValue(), 1.0);
	}

	@Test
	public void testGetApplicationType_1() throws Exception {
		NOCPriceBook fixture = new NOCPriceBook("", "", "", "", new Long(1L), new Long(1L), new Long(1L), new Long(1L),
				new Long(1L), new Long(1L), new Long(1L), "", "", "", true, "", new Long(1L), "", new Long(1L),
				new Integer(1), null);

		String result = fixture.getApplicationType();

		assertEquals("", result);
	}

	@Test
	public void testGetCalculationSequence_1() throws Exception {
		NOCPriceBook fixture = new NOCPriceBook("", "", "", "", new Long(1L), new Long(1L), new Long(1L), new Long(1L),
				new Long(1L), new Long(1L), new Long(1L), "", "", "", true, "", new Long(1L), "", new Long(1L),
				new Integer(1), null);

		Integer result = fixture.getCalculationSequence();

		assertNotNull(result);
		assertEquals("1", result.toString());
		assertEquals((byte) 1, result.byteValue());
		assertEquals((short) 1, result.shortValue());
		assertEquals(1, result.intValue());
		assertEquals(1L, result.longValue());
		assertEquals(1.0f, result.floatValue(), 1.0f);
		assertEquals(1.0, result.doubleValue(), 1.0);
	}

	@Test
	public void testGetCategoryId_1() throws Exception {
		NOCPriceBook fixture = new NOCPriceBook("", "", "", "", new Long(1L), new Long(1L), new Long(1L), new Long(1L),
				new Long(1L), new Long(1L), new Long(1L), "", "", "", true, "", new Long(1L), "", new Long(1L),
				new Integer(1), null);

		String result = fixture.getCategoryId();

		assertEquals("", result);
	}

	@Test
	public void testGetCreatedBy_1() throws Exception {
		NOCPriceBook fixture = new NOCPriceBook("", "", "", "", new Long(1L), new Long(1L), new Long(1L), new Long(1L),
				new Long(1L), new Long(1L), new Long(1L), "", "", "", true, "", new Long(1L), "", new Long(1L),
				new Integer(1), null);

		String result = fixture.getCreatedBy();

		assertEquals("", result);
	}

	@Test
	public void testGetCreatedTime_1() throws Exception {
		NOCPriceBook fixture = new NOCPriceBook("", "", "", "", new Long(1L), new Long(1L), new Long(1L), new Long(1L),
				new Long(1L), new Long(1L), new Long(1L), "", "", "", true, "", new Long(1L), "", new Long(1L),
				new Integer(1), null);

		Long result = fixture.getCreatedTime();

		assertNotNull(result);
		assertEquals("1", result.toString());
		assertEquals((byte) 1, result.byteValue());
		assertEquals((short) 1, result.shortValue());
		assertEquals(1, result.intValue());
		assertEquals(1L, result.longValue());
		assertEquals(1.0f, result.floatValue(), 1.0f);
		assertEquals(1.0, result.doubleValue(), 1.0);
	}

	@Test
	public void testGetEffectiveFromDate_1() throws Exception {
		NOCPriceBook fixture = new NOCPriceBook("", "", "", "", new Long(1L), new Long(1L), new Long(1L), new Long(1L),
				new Long(1L), new Long(1L), new Long(1L), "", "", "", true, "", new Long(1L), "", new Long(1L),
				new Integer(1), null);

		String result = fixture.getEffectiveFromDate();

		assertEquals("", result);
	}

	@Test
	public void testGetEffectiveToDate_1() throws Exception {
		NOCPriceBook fixture = new NOCPriceBook("", "", "", "", new Long(1L), new Long(1L), new Long(1L), new Long(1L),
				new Long(1L), new Long(1L), new Long(1L), "", "", "", true, "", new Long(1L), "", new Long(1L),
				new Integer(1), null);

		String result = fixture.getEffectiveToDate();

		assertEquals("", result);
	}

	@Test
	public void testGetFixedPrice_1() throws Exception {
		NOCPriceBook fixture = new NOCPriceBook("", "", "", "", new Long(1L), new Long(1L), new Long(1L), new Long(1L),
				new Long(1L), new Long(1L), new Long(1L), "", "", "", true, "", new Long(1L), "", new Long(1L),
				new Integer(1), null);

		Long result = fixture.getFixedPrice();

		assertNotNull(result);
		assertEquals("1", result.toString());
		assertEquals((byte) 1, result.byteValue());
		assertEquals((short) 1, result.shortValue());
		assertEquals(1, result.intValue());
		assertEquals(1L, result.longValue());
		assertEquals(1.0f, result.floatValue(), 1.0f);
		assertEquals(1.0, result.doubleValue(), 1.0);
	}

	@Test
	public void testGetLastModifiedBy_1() throws Exception {
		NOCPriceBook fixture = new NOCPriceBook("", "", "", "", new Long(1L), new Long(1L), new Long(1L), new Long(1L),
				new Long(1L), new Long(1L), new Long(1L), "", "", "", true, "", new Long(1L), "", new Long(1L),
				new Integer(1), null);

		String result = fixture.getLastModifiedBy();

		assertEquals("", result);
	}

	@Test
	public void testGetLastModifiedTime_1() throws Exception {
		NOCPriceBook fixture = new NOCPriceBook("", "", "", "", new Long(1L), new Long(1L), new Long(1L), new Long(1L),
				new Long(1L), new Long(1L), new Long(1L), "", "", "", true, "", new Long(1L), "", new Long(1L),
				new Integer(1), null);

		Long result = fixture.getLastModifiedTime();

		assertNotNull(result);
		assertEquals("1", result.toString());
		assertEquals((byte) 1, result.byteValue());
		assertEquals((short) 1, result.shortValue());
		assertEquals(1, result.intValue());
		assertEquals(1L, result.longValue());
		assertEquals(1.0f, result.floatValue(), 1.0f);
		assertEquals(1.0, result.doubleValue(), 1.0);
	}

	@Test
	public void testGetMaxSqft_1() throws Exception {
		NOCPriceBook fixture = new NOCPriceBook("", "", "", "", new Long(1L), new Long(1L), new Long(1L), new Long(1L),
				new Long(1L), new Long(1L), new Long(1L), "", "", "", true, "", new Long(1L), "", new Long(1L),
				new Integer(1), null);

		Long result = fixture.getMaxSqft();

		assertNotNull(result);
		assertEquals("1", result.toString());
		assertEquals((byte) 1, result.byteValue());
		assertEquals((short) 1, result.shortValue());
		assertEquals(1, result.intValue());
		assertEquals(1L, result.longValue());
		assertEquals(1.0f, result.floatValue(), 1.0f);
		assertEquals(1.0, result.doubleValue(), 1.0);
	}

	@Test
	public void testGetMinSqft_1() throws Exception {
		NOCPriceBook fixture = new NOCPriceBook("", "", "", "", new Long(1L), new Long(1L), new Long(1L), new Long(1L),
				new Long(1L), new Long(1L), new Long(1L), "", "", "", true, "", new Long(1L), "", new Long(1L),
				new Integer(1), null);

		Long result = fixture.getMinSqft();

		assertNotNull(result);
		assertEquals("1", result.toString());
		assertEquals((byte) 1, result.byteValue());
		assertEquals((short) 1, result.shortValue());
		assertEquals(1, result.intValue());
		assertEquals(1L, result.longValue());
		assertEquals(1.0f, result.floatValue(), 1.0f);
		assertEquals(1.0, result.doubleValue(), 1.0);
	}

	@Test
	public void testGetPerDayPrice_1() throws Exception {
		NOCPriceBook fixture = new NOCPriceBook("", "", "", "", new Long(1L), new Long(1L), new Long(1L), new Long(1L),
				new Long(1L), new Long(1L), new Long(1L), "", "", "", true, "", new Long(1L), "", new Long(1L),
				new Integer(1), null);

		Long result = fixture.getPerDayPrice();

		assertNotNull(result);
		assertEquals("1", result.toString());
		assertEquals((byte) 1, result.byteValue());
		assertEquals((short) 1, result.shortValue());
		assertEquals(1, result.intValue());
		assertEquals(1L, result.longValue());
		assertEquals(1.0f, result.floatValue(), 1.0f);
		assertEquals(1.0, result.doubleValue(), 1.0);
	}

	@Test
	public void testGetPerMonthPrice_1() throws Exception {
		NOCPriceBook fixture = new NOCPriceBook("", "", "", "", new Long(1L), new Long(1L), new Long(1L), new Long(1L),
				new Long(1L), new Long(1L), new Long(1L), "", "", "", true, "", new Long(1L), "", new Long(1L),
				new Integer(1), null);

		Long result = fixture.getPerMonthPrice();

		assertNotNull(result);
		assertEquals("1", result.toString());
		assertEquals((byte) 1, result.byteValue());
		assertEquals((short) 1, result.shortValue());
		assertEquals(1, result.intValue());
		assertEquals(1L, result.longValue());
		assertEquals(1.0f, result.floatValue(), 1.0f);
		assertEquals(1.0, result.doubleValue(), 1.0);
	}

	@Test
	public void testGetPerWeekPrice_1() throws Exception {
		NOCPriceBook fixture = new NOCPriceBook("", "", "", "", new Long(1L), new Long(1L), new Long(1L), new Long(1L),
				new Long(1L), new Long(1L), new Long(1L), "", "", "", true, "", new Long(1L), "", new Long(1L),
				new Integer(1), null);

		Long result = fixture.getPerWeekPrice();

		assertNotNull(result);
		assertEquals("1", result.toString());
		assertEquals((byte) 1, result.byteValue());
		assertEquals((short) 1, result.shortValue());
		assertEquals(1, result.intValue());
		assertEquals(1L, result.longValue());
		assertEquals(1.0f, result.floatValue(), 1.0f);
		assertEquals(1.0, result.doubleValue(), 1.0);
	}

	@Test
	public void testGetPriceBookId_1() throws Exception {
		NOCPriceBook fixture = new NOCPriceBook("", "", "", "", new Long(1L), new Long(1L), new Long(1L), new Long(1L),
				new Long(1L), new Long(1L), new Long(1L), "", "", "", true, "", new Long(1L), "", new Long(1L),
				new Integer(1), null);

		String result = fixture.getPriceBookId();

		assertEquals("", result);
	}

	@Test
	public void testGetSubCategoryId_1() throws Exception {
		NOCPriceBook fixture = new NOCPriceBook("", "", "", "", new Long(1L), new Long(1L), new Long(1L), new Long(1L),
				new Long(1L), new Long(1L), new Long(1L), "", "", "", true, "", new Long(1L), "", new Long(1L),
				new Integer(1), null);

		String result = fixture.getSubCategoryId();

		assertEquals("", result);
	}

	@Test
	public void testGetTenantId_1() throws Exception {
		NOCPriceBook fixture = new NOCPriceBook("", "", "", "", new Long(1L), new Long(1L), new Long(1L), new Long(1L),
				new Long(1L), new Long(1L), new Long(1L), "", "", "", true, "", new Long(1L), "", new Long(1L),
				new Integer(1), null);

		String result = fixture.getTenantId();

		assertEquals("", result);
	}

	@Test
	public void testIsActive_1() throws Exception {
		NOCPriceBook fixture = new NOCPriceBook("", "", "", "", new Long(1L), new Long(1L), new Long(1L), new Long(1L),
				new Long(1L), new Long(1L), new Long(1L), "", "", "", true, "", new Long(1L), "", new Long(1L),
				new Integer(1), null);

		boolean result = fixture.isActive();

		assertEquals(true, result);
	}

	@Test
	public void testIsActive_2() throws Exception {
		NOCPriceBook fixture = new NOCPriceBook("", "", "", "", new Long(1L), new Long(1L), new Long(1L), new Long(1L),
				new Long(1L), new Long(1L), new Long(1L), "", "", "", false, "", new Long(1L), "", new Long(1L),
				new Integer(1), null);

		boolean result = fixture.isActive();

		assertEquals(false, result);
	}

	@Test
	public void testSetActive_1() throws Exception {
		NOCPriceBook fixture = new NOCPriceBook("", "", "", "", new Long(1L), new Long(1L), new Long(1L), new Long(1L),
				new Long(1L), new Long(1L), new Long(1L), "", "", "", true, "", new Long(1L), "", new Long(1L),
				new Integer(1), null);
		boolean isActive = true;

		fixture.setActive(isActive);

	}

	@Test
	public void testSetAnnualPrice_1() throws Exception {
		NOCPriceBook fixture = new NOCPriceBook("", "", "", "", new Long(1L), new Long(1L), new Long(1L), new Long(1L),
				new Long(1L), new Long(1L), new Long(1L), "", "", "", true, "", new Long(1L), "", new Long(1L),
				new Integer(1), null);
		Long annualPrice = new Long(1L);

		fixture.setAnnualPrice(annualPrice);

	}

	@Test
	public void testSetApplicationType_1() throws Exception {
		NOCPriceBook fixture = new NOCPriceBook("", "", "", "", new Long(1L), new Long(1L), new Long(1L), new Long(1L),
				new Long(1L), new Long(1L), new Long(1L), "", "", "", true, "", new Long(1L), "", new Long(1L),
				new Integer(1), null);
		String applicationType = "";

		fixture.setApplicationType(applicationType);

	}

	@Test
	public void testSetCalculationSequence_1() throws Exception {
		NOCPriceBook fixture = new NOCPriceBook("", "", "", "", new Long(1L), new Long(1L), new Long(1L), new Long(1L),
				new Long(1L), new Long(1L), new Long(1L), "", "", "", true, "", new Long(1L), "", new Long(1L),
				new Integer(1), null);
		Integer calculationSequence = new Integer(1);

		fixture.setCalculationSequence(calculationSequence);

	}

	@Test
	public void testSetCategoryId_1() throws Exception {
		NOCPriceBook fixture = new NOCPriceBook("", "", "", "", new Long(1L), new Long(1L), new Long(1L), new Long(1L),
				new Long(1L), new Long(1L), new Long(1L), "", "", "", true, "", new Long(1L), "", new Long(1L),
				new Integer(1), null);
		String categoryId = "";

		fixture.setCategoryId(categoryId);

	}

	@Test
	public void testSetCreatedBy_1() throws Exception {
		NOCPriceBook fixture = new NOCPriceBook("", "", "", "", new Long(1L), new Long(1L), new Long(1L), new Long(1L),
				new Long(1L), new Long(1L), new Long(1L), "", "", "", true, "", new Long(1L), "", new Long(1L),
				new Integer(1), null);
		String createdBy = "";

		fixture.setCreatedBy(createdBy);

	}

	@Test
	public void testSetCreatedTime_1() throws Exception {
		NOCPriceBook fixture = new NOCPriceBook("", "", "", "", new Long(1L), new Long(1L), new Long(1L), new Long(1L),
				new Long(1L), new Long(1L), new Long(1L), "", "", "", true, "", new Long(1L), "", new Long(1L),
				new Integer(1), null);
		Long createdTime = new Long(1L);

		fixture.setCreatedTime(createdTime);

	}

	@Test
	public void testSetEffectiveFromDate_1() throws Exception {
		NOCPriceBook fixture = new NOCPriceBook("", "", "", "", new Long(1L), new Long(1L), new Long(1L), new Long(1L),
				new Long(1L), new Long(1L), new Long(1L), "", "", "", true, "", new Long(1L), "", new Long(1L),
				new Integer(1), null);
		String effectiveFromDate = "";

		fixture.setEffectiveFromDate(effectiveFromDate);

	}

	@Test
	public void testSetEffectiveToDate_1() throws Exception {
		NOCPriceBook fixture = new NOCPriceBook("", "", "", "", new Long(1L), new Long(1L), new Long(1L), new Long(1L),
				new Long(1L), new Long(1L), new Long(1L), "", "", "", true, "", new Long(1L), "", new Long(1L),
				new Integer(1), null);
		String effectiveToDate = "";

		fixture.setEffectiveToDate(effectiveToDate);

	}

	@Test
	public void testSetFixedPrice_1() throws Exception {
		NOCPriceBook fixture = new NOCPriceBook("", "", "", "", new Long(1L), new Long(1L), new Long(1L), new Long(1L),
				new Long(1L), new Long(1L), new Long(1L), "", "", "", true, "", new Long(1L), "", new Long(1L),
				new Integer(1), null);
		Long fixedPrice = new Long(1L);

		fixture.setFixedPrice(fixedPrice);

	}

	@Test
	public void testSetLastModifiedBy_1() throws Exception {
		NOCPriceBook fixture = new NOCPriceBook("", "", "", "", new Long(1L), new Long(1L), new Long(1L), new Long(1L),
				new Long(1L), new Long(1L), new Long(1L), "", "", "", true, "", new Long(1L), "", new Long(1L),
				new Integer(1), null);
		String lastModifiedBy = "";

		fixture.setLastModifiedBy(lastModifiedBy);

	}

	@Test
	public void testSetLastModifiedTime_1() throws Exception {
		NOCPriceBook fixture = new NOCPriceBook("", "", "", "", new Long(1L), new Long(1L), new Long(1L), new Long(1L),
				new Long(1L), new Long(1L), new Long(1L), "", "", "", true, "", new Long(1L), "", new Long(1L),
				new Integer(1), null);
		Long lastModifiedTime = new Long(1L);

		fixture.setLastModifiedTime(lastModifiedTime);

	}

	@Test
	public void testSetMaxSqft_1() throws Exception {
		NOCPriceBook fixture = new NOCPriceBook("", "", "", "", new Long(1L), new Long(1L), new Long(1L), new Long(1L),
				new Long(1L), new Long(1L), new Long(1L), "", "", "", true, "", new Long(1L), "", new Long(1L),
				new Integer(1), null);
		Long maxSqft = new Long(1L);

		fixture.setMaxSqft(maxSqft);

	}

	@Test
	public void testSetMinSqft_1() throws Exception {
		NOCPriceBook fixture = new NOCPriceBook("", "", "", "", new Long(1L), new Long(1L), new Long(1L), new Long(1L),
				new Long(1L), new Long(1L), new Long(1L), "", "", "", true, "", new Long(1L), "", new Long(1L),
				new Integer(1), null);
		Long minSqft = new Long(1L);

		fixture.setMinSqft(minSqft);

	}

	@Test
	public void testSetPerDayPrice_1() throws Exception {
		NOCPriceBook fixture = new NOCPriceBook("", "", "", "", new Long(1L), new Long(1L), new Long(1L), new Long(1L),
				new Long(1L), new Long(1L), new Long(1L), "", "", "", true, "", new Long(1L), "", new Long(1L),
				new Integer(1), null);
		Long perDayPrice = new Long(1L);

		fixture.setPerDayPrice(perDayPrice);

	}

	@Test
	public void testSetPerMonthPrice_1() throws Exception {
		NOCPriceBook fixture = new NOCPriceBook("", "", "", "", new Long(1L), new Long(1L), new Long(1L), new Long(1L),
				new Long(1L), new Long(1L), new Long(1L), "", "", "", true, "", new Long(1L), "", new Long(1L),
				new Integer(1), null);
		Long perMonthPrice = new Long(1L);

		fixture.setPerMonthPrice(perMonthPrice);

	}

	@Test
	public void testSetPerWeekPrice_1() throws Exception {
		NOCPriceBook fixture = new NOCPriceBook("", "", "", "", new Long(1L), new Long(1L), new Long(1L), new Long(1L),
				new Long(1L), new Long(1L), new Long(1L), "", "", "", true, "", new Long(1L), "", new Long(1L),
				new Integer(1), null);
		Long perWeekPrice = new Long(1L);

		fixture.setPerWeekPrice(perWeekPrice);

	}

	@Test
	public void testSetPriceBookId_1() throws Exception {
		NOCPriceBook fixture = new NOCPriceBook("", "", "", "", new Long(1L), new Long(1L), new Long(1L), new Long(1L),
				new Long(1L), new Long(1L), new Long(1L), "", "", "", true, "", new Long(1L), "", new Long(1L),
				new Integer(1), null);
		String priceBookId = "";

		fixture.setPriceBookId(priceBookId);

	}

	@Test
	public void testSetSubCategoryId_1() throws Exception {
		NOCPriceBook fixture = new NOCPriceBook("", "", "", "", new Long(1L), new Long(1L), new Long(1L), new Long(1L),
				new Long(1L), new Long(1L), new Long(1L), "", "", "", true, "", new Long(1L), "", new Long(1L),
				new Integer(1), null);
		String subCategoryId = "";

		fixture.setSubCategoryId(subCategoryId);

	}

	@Test
	public void testSetTenantId_1() throws Exception {
		NOCPriceBook fixture = new NOCPriceBook("", "", "", "", new Long(1L), new Long(1L), new Long(1L), new Long(1L),
				new Long(1L), new Long(1L), new Long(1L), "", "", "", true, "", new Long(1L), "", new Long(1L),
				new Integer(1), null);
		String tenantId = "";

		fixture.setTenantId(tenantId);

	}

	@Test
	public void testNOCPriceBookBuilder() throws Exception {
		NOCPriceBook.NOCPriceBookBuilder fixture = new NOCPriceBook.NOCPriceBookBuilder();
		fixture.annualPrice(1545L);
		fixture.applicationType("NOCTYPE");
		fixture.calculationSequence(11);
		fixture.calculationType("range");
		fixture.categoryId("10001");
		fixture.createdBy("1212");
		fixture.createdTime(154554545454L);
		fixture.effectiveFromDate("2020-12-12");
		fixture.effectiveToDate("2021-12-12");
		fixture.fixedPrice(12155L);
		fixture.isActive(true);
		fixture.lastModifiedBy("244");
		fixture.lastModifiedTime(154551545L);
		fixture.minSqft(14L);
		fixture.maxSqft(45L);
		fixture.perDayPrice(14525L);
		fixture.perMonthPrice(0L);
		fixture.perWeekPrice(0L);
		fixture.priceBookId("slv390fjce29ec2c");
		fixture.subCategoryId("20002");
		fixture.tenantId("ch");
		fixture.build();

		String str = fixture.toString();
		Assert.assertEquals(str, fixture.toString());

	}

}