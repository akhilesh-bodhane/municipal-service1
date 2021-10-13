package org.egov.ec.repository;

import org.egov.ec.config.EchallanConfiguration;
import org.egov.ec.producer.Producer;
import org.egov.ec.repository.StoreItemRegisterRepository;
import org.egov.ec.web.models.EcPayment;
import org.egov.ec.web.models.EcSearchCriteria;
import org.egov.ec.web.models.StoreItemRegister;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.jdbc.core.JdbcTemplate;

@RunWith(MockitoJUnitRunner.class)
public class StoreItemRegisterRepositoryTest {
	
	@InjectMocks
	private StoreItemRegisterRepository repository;

	@Mock
	private JdbcTemplate jdbcTemplate;

	@Mock
	private Producer producer;

	@Mock
	private EchallanConfiguration config;


	@Test
	public void testCreateStoreItemRegister() {
		StoreItemRegister master = StoreItemRegister.builder().storeItemUuid("aasdjiasdu8ahs89asdy8a9h")
				.build();
		repository.saveStoreItem(master);
	}
	
	@Test
	public void testUpdateStoreItemRegister() {
		StoreItemRegister master = StoreItemRegister.builder().storeItemUuid("aasdjiasdu8ahs89asdy8a9h")
				.build();
		repository.updateStoreItem(master);
	}
	
	@Test
	public void testUpdateStorePayment() {
		EcPayment master = EcPayment.builder().paymentUuid("aasdjiasdu8ahs89asdy8a9h")
				.build();
		repository.updateStorePayment(master);
	}
	
	@Test
	public void testGetAuctionItem() {
		String tenant="ch";
		repository.getStoreAuctionItem(tenant);
	}
	
	@Test
	public void testGetStoreItemRegister() {
		
		EcSearchCriteria searchCriteria = EcSearchCriteria.builder().searchText("test").tenantId("ch").limit(1).build();
		repository.getStoreItemRegister(searchCriteria);
	}
	
	@Test
	public void testGetStoreItemRegister_1() {
		
		EcSearchCriteria searchCriteria = EcSearchCriteria.builder().searchText("").tenantId("ch").limit(1).build();
		repository.getStoreItemRegister(searchCriteria);
	}
	
	
	
	
}
