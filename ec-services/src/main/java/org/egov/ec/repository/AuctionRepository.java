package org.egov.ec.repository;

import java.util.List;

import javax.validation.Valid;

import org.egov.ec.config.EchallanConfiguration;
import org.egov.ec.producer.Producer;
import org.egov.ec.repository.builder.EcQueryBuilder;
import org.egov.ec.web.models.Auction;
import org.egov.ec.web.models.EcSearchCriteria;
import org.egov.ec.web.models.RequestInfoWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Repository
public class AuctionRepository {

	private JdbcTemplate jdbcTemplate;

	private Producer producer;

	private EchallanConfiguration config;

	@Autowired
	public AuctionRepository(JdbcTemplate jdbcTemplate, Producer producer, EchallanConfiguration config) {
		this.jdbcTemplate = jdbcTemplate;
		this.producer = producer;
		this.config = config;
	}

	/**
	 * Pushes the request in update Auction Topic for auction approval
	 *
	 * @param Auction Auction Update request
	 */
	public void updateAuction(@Valid Auction auction) {
		log.info("Auction Repository - updateAuction Method");

		RequestInfoWrapper infoWrapper = RequestInfoWrapper.builder().requestBody(auction).build();
		producer.push(config.getUpdateauctionTopic(), infoWrapper);
	}

	/**
	 * Pushes the request in Save Auction Topic for saving auction to get it
	 * approved by HOD
	 *
	 * @param Auction Auction Save request
	 */
	public void saveAuction(@Valid Auction auction) {
		log.info("Auction Repository - saveAuction Method");
		RequestInfoWrapper infoWrapper = RequestInfoWrapper.builder().requestBody(auction).build();
		producer.push(config.getSaveAuctionTopic(), infoWrapper);

	}

	/**
	 * fetches the list of items which are eligible for auction against challan
	 *
	 * @param searchCriteria Search criteria to apply filter on challan id
	 * @return Returns the list of items which are eligible for auction against
	 *         challan
	 */
	public List<Auction> getAuction(EcSearchCriteria searchCriteria) {
		log.info("Auction Repository - getAuction Method");
		List<Auction> auction;

		auction = jdbcTemplate.query(EcQueryBuilder.GET_AUCTION_MASTER,
				new Object[] { searchCriteria.getChallanUuid(), searchCriteria.getTenantId() },
				new BeanPropertyRowMapper<Auction>(Auction.class));

		return auction;
	}

	/**
	 * fetches the list of challans which are eligible for auction
	 *
	 * @param Auction Auction request for tenantId
	 * @return Returns the list of challans which are eligible for auction
	 */
	public List<Auction> getAuctionChallan(Auction auction) {
		log.info("Auction Repository - getAuctionChallan Method");
		List<Auction> auctionList;
		if(auction.getAuctionUuid() != null)
		{
			auctionList = jdbcTemplate.query(EcQueryBuilder.GET_AUCTION_UUID_CHALLAN_MASTER,
					new Object[] { auction.getAuctionUuid(),auction.getTenantId() }, new BeanPropertyRowMapper<Auction>(Auction.class));
		}
		else
		{
		auctionList = jdbcTemplate.query(EcQueryBuilder.GET_AUCTION_CHALLAN_MASTER,
				new Object[] { auction.getTenantId() }, new BeanPropertyRowMapper<Auction>(Auction.class));
		}

		return auctionList;
	}

	/**
	 * Pushes the request in update Auction Topic for auction rejection
	 *
	 * @param Auction Auction Update request
	 */
	public void updateAuctionRejection(@Valid Auction auction) {
		log.info("Auction Repository - updateAuctionRejection Method");
		RequestInfoWrapper infoWrapper = RequestInfoWrapper.builder().requestBody(auction).build();
		producer.push(config.getRejectauctionTopic(), infoWrapper);

	}

	/**
	 * fetches the count of remaining auctioned items against challan
	 *
	 * @param Auction Auction request for challanId
	 * @return Returns the count of pending and remaining auctions
	 */
	public List<Auction> getQuantity(String tenantId) {
		log.info("Auction Repository - getQuantity Method");
		List<Auction> auctionList;
		auctionList= jdbcTemplate.query(EcQueryBuilder.GET_AUCTIONED_AVAILABLE_COUNT,
				new Object[] {tenantId},new BeanPropertyRowMapper<Auction> (Auction.class));
		return auctionList;
	}
	
	/**
	 * fetches the count of remaining auctioned items against challan
	 *
	 * @param Auction Auction request for challanId
	 * @return Returns the count of pending and remaining auctions
	 */
	public List<Auction> getPendingForAuctionChallans(String tenantId) {
		log.info("Auction Repository - getPendingForAuctionChallans Method");
		List<Auction> auctionList;
		auctionList= jdbcTemplate.query(EcQueryBuilder.GET_CHALLAN_PENDING_AUCTION,
				new Object[] {tenantId},new BeanPropertyRowMapper<Auction> (Auction.class));
		return auctionList;
	}
}
