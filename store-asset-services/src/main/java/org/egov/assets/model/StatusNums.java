package org.egov.assets.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import lombok.Builder;

@Builder
public class StatusNums {

	/**
	 * status of request processing - to be enhanced in futuer to include INPROGRESS
	 */
	public enum StatusEnum {
		SUCCESSFUL("SUCCESSFUL"),

		FAILED("FAILED");

		private String value;

		StatusEnum(String value) {
			this.value = value;
		}

		@Override
		@JsonValue
		public String toString() {
			return String.valueOf(value);
		}

		@JsonCreator
		public static StatusEnum fromValue(String text) {
			for (StatusEnum b : StatusEnum.values()) {
				if (String.valueOf(b.value).equals(text)) {
					return b;
				}
			}
			return null;
		}
	}
}
