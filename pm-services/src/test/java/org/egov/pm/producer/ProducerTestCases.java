package org.egov.pm.producer;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.kafka.core.KafkaTemplate;

@RunWith(MockitoJUnitRunner.Silent.class)
public class ProducerTestCases {

	@InjectMocks
	private Producer producer;
	
	@Mock
	private KafkaTemplate<String, Object> kafkaTemplate;
	
	@Test
	public void testPush() {
		producer.push("topic", "savenoc");
	}

}
