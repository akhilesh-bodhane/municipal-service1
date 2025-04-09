package org.egov.ec.service.validator;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Map;

import org.egov.ec.web.models.ChallanDataBckUp;
import org.springframework.stereotype.Component;

@Component
public class EchallanFieldValidator {
	
	public void validateFieldRequest(ChallanDataBckUp bck) {
		if (isNullOrEmpty(bck.getChallanId())) {
			throw new IllegalArgumentException("Invalid Challan Id");
		}
		if (isNullOrEmpty(bck.getComment())) {
			throw new IllegalArgumentException("Invalid Comments Id");
		}if (isNullOrEmpty(bck.getReferenceChallanNo())) {
			throw new IllegalArgumentException("Invalid Reference Challan No");
		}
	}
	
	public static boolean isNullOrEmpty(final Object object) {
		if (object == null)
			return true;
		if (object instanceof String)
			return ((String) object).length() == 0;
		if (object instanceof Collection)
			return ((Collection<?>) object).isEmpty();
		if (object instanceof Map)
			return ((Map<?, ?>) object).isEmpty();
		if (object.getClass().isArray()) {
			if (Array.getLength(object) == 0) {
				return true;
			} else {
				// test 1st dim array
				for (int i = 0; i < Array.getLength(object); i++) {
					if (Array.get(object, i) != null) {
						// check if 2 dim array
						if (Array.get(object, i).getClass().isArray()) {
							if (Array.getLength(Array.get(object, i)) == 0) {
								return true;
							}
							for (int j = 0; j < Array.getLength(Array.get(object, i)); j++) {
								if (Array.get(Array.get(object, j), i) != null) {
									// means found at least one data not null
									return false;
								}
							}
							// means all data of a row are null
							return true;
						} else {
							// means 1 dim array and one data not null
							return false;
						}
					}
				}
				// all data are null
				return true;
			}
		}
		return false;
	}

}
