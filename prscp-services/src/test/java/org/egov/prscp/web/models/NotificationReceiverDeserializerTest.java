package org.egov.prscp.web.models;

import org.junit.*;
import static org.junit.Assert.*;

public class NotificationReceiverDeserializerTest {

	@Test
	public void testNotificationReceiverDeserializer_1()
		throws Exception {

		NotificationReceiverDeserializer result = new NotificationReceiverDeserializer();

		assertNotNull(result);
	}

	@Before
	public void setUp()
		throws Exception {
		
	}


	@After
	public void tearDown()
		throws Exception {
	
	}

	
	public static void main(String[] args) {
		new org.junit.runner.JUnitCore().run(NotificationReceiverDeserializerTest.class);
	}
}