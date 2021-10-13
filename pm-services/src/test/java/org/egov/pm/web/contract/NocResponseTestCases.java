package org.egov.pm.web.contract;

import static org.junit.Assert.fail;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

import junit.framework.Assert;

@RunWith(MockitoJUnitRunner.Silent.class)
public class NocResponseTestCases {

	@InjectMocks
	private NocResponse nocResponse;

	@Test
	public void testNocResponse() {
		NocResponse nocResponse2 = new NocResponse(null, null);
		Assert.assertEquals(null, nocResponse2.getNocApplicationDetail());
	}

	@Test
	public void testBuilder() {
		NocResponse.builder();
	}

	@Test
	public void testNocResponseBuilder() {
		NocResponse.NocResponseBuilder builder = new NocResponse.NocResponseBuilder();
		builder.nocApplicationDetail(null);
		builder.resposneInfo(null);
		builder.build();

		NocResponse.NocResponseBuilder builder2 = new NocResponse.NocResponseBuilder();
		builder2.nocApplicationDetail(null);
		builder2.resposneInfo(null);
		builder2.build();

		Assert.assertEquals(builder.toString(), builder2.toString());
	}

	@Test
	public void testGetResposneInfo() {
		nocResponse.setResposneInfo(null);
		Assert.assertEquals(null, nocResponse.getResposneInfo());
	}

	@Test
	public void testGetNocApplicationDetail() {
		Object atr = new Object();
		nocResponse.setNocApplicationDetail(atr);
		Assert.assertEquals(atr, nocResponse.getNocApplicationDetail());
	}

}
