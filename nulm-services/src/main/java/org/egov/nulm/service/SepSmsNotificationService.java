package org.egov.nulm.service;

import org.egov.nulm.model.NulmSepRequest;

public interface SepSmsNotificationService {
	
	public void sendSms(NulmSepRequest nulmSepRequest);

}
