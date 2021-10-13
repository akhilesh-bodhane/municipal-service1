package org.egov.pm.model;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.egov.common.contract.request.RequestInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

import junit.framework.Assert;

@RunWith(MockitoJUnitRunner.Silent.class)
public class PriceBookRequestDataTest {

	@InjectMocks
	private PriceBookRequestData book;

	@Test
	public void testBuilder() {
		PriceBookRequestData book1 = PriceBookRequestData.builder().build();
	}

	@Test
	public void testGetRequestInfo() {
		book.setRequestInfo(RequestInfo.builder().action("request").build());
		Assert.assertEquals("request", book.getRequestInfo().getAction());
	}

	@Test
	public void testGetNocPriceBook() {
		List<NOCPriceBook> nocPriceBook = new ArrayList<>();
		book.setNocPriceBook(nocPriceBook);
		Assert.assertEquals(nocPriceBook, book.getNocPriceBook());
	}

	@Test
	public void testPriceBookRequestDataRequestInfoListOfNOCPriceBook() {
		PriceBookRequestData bookRequestData = new PriceBookRequestData();
	}

	@Test
	public void testPriceBookRequestData() {
		PriceBookRequestData.PriceBookRequestDataBuilder book2 = new PriceBookRequestData.PriceBookRequestDataBuilder();
		List<NOCPriceBook> nocPriceBook = new ArrayList<>();
		book2.nocPriceBook(nocPriceBook);
		book2.requestInfo(RequestInfo.builder().action("request").build());
		book2.build();

		String str = book2.toString();
		Assert.assertEquals(str, book2.toString());
	}

}
