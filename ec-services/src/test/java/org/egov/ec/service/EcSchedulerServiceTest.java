package org.egov.ec.service;

import org.egov.ec.repository.FineMasterRepository;
import org.egov.ec.repository.StoreItemRegisterRepository;
import org.egov.ec.service.EcSchedulerService;
import org.egov.ec.web.models.AuditDetails;
import org.egov.ec.web.models.ItemMaster;
import org.egov.ec.web.models.RequestInfoWrapper;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.http.HttpStatus;

public class EcSchedulerServiceTest {
	
	@Mock
	private FineMasterRepository fineRepository;
	
	@Mock
	private StoreItemRegisterRepository storeItemRegisterRepository;

	@InjectMocks
	private EcSchedulerService service;
	
	@Test public void testUpdateFineAmount() {
		
		  }

}
