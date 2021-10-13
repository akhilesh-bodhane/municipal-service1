package org.egov.pm.model;
import java.util.HashMap;

import org.springframework.kafka.support.serializer.JsonDeserializer;

public class PMDeserializer extends JsonDeserializer<HashMap> {
	public PMDeserializer() {
		super(HashMap.class);
	}
}
