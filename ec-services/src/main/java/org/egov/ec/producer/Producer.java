package org.egov.ec.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class Producer {

	@Autowired
	private KafkaTemplate<String, Object> kafkaTemplate;

	public void push(String topic, Object value) {
		kafkaTemplate.send(topic, value);
	}
}
