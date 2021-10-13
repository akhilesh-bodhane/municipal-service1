package org.egov.ec.repository;

import org.egov.ec.config.EchallanConfiguration;
import org.egov.ec.producer.Producer;
import org.egov.ec.repository.AuctionRepository;
import org.egov.ec.web.models.Auction;
import org.egov.ec.web.models.EcSearchCriteria;
import org.egov.ec.web.models.VendorRegistration;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.jdbc.core.JdbcTemplate;


@RunWith(MockitoJUnitRunner.class)
public class AuctionRepositoryTest {
	
	@InjectMocks
	private AuctionRepository repository;

	@Mock
	private JdbcTemplate jdbcTemplate;

	@Mock
	private Producer producer;

	@Mock
	private EchallanConfiguration config;
	
	@Test
	public void testCreateAuction() {
		Auction master = Auction.builder().auctionUuid("aasdjiasdu8ahs89asdy8a9h")
				.build();
		repository.saveAuction(master);
	}

	@Test
	public void testUpdateAuction() {
		Auction master = Auction.builder().auctionUuid("aasdjiasdu8ahs89asdy8a9h")
				.build();
		repository.updateAuction(master);
	}
	
	@Test
	public void testGetAuction() {
		
		EcSearchCriteria searchCriteria = EcSearchCriteria.builder().build();
		repository.getAuction(searchCriteria);
	}

	@Test
	public void testGetAuctionChallan1() {
		
		Auction searchCriteria = Auction.builder().auctionUuid("aasdjiasdu8ahs89asdy8a9h")
				.build();
		repository.getAuctionChallan(searchCriteria);
	}
	
	@Test
	public void testGetAuctionChallan2() {
		
		Auction searchCriteria = Auction.builder().build();
		repository.getAuctionChallan(searchCriteria);
	}
	
	@Test
	public void testUpdateAuctionRejection() {
		
		Auction searchCriteria = Auction.builder().build();
		repository.updateAuctionRejection(searchCriteria);
	}
	
	@Test
	public void testGetQuantity() {
		
		String tenant="ch";
		repository.getQuantity(tenant);
	}
	
	@Test
	public void testGetPendingAuctionChallans() {
		
		String tenant="ch";
		repository.getPendingForAuctionChallans(tenant);
	}
}
