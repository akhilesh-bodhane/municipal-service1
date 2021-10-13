package org.egov.ec.repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.egov.common.contract.request.RequestInfo;
import org.egov.common.contract.request.Role;
import org.egov.ec.config.EchallanConfiguration;
import org.egov.ec.producer.Producer;
import org.egov.ec.repository.ItemRepository;
import org.egov.ec.web.models.ItemMaster;
import org.egov.ec.web.models.RequestInfoWrapper;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

@RunWith(MockitoJUnitRunner.class)
public class ItemRepositoryTest {

	@InjectMocks
	private ItemRepository repository;

	@Mock
	private JdbcTemplate jdbcTemplate;

	@Mock
	private Producer producer;

	@Mock
	private EchallanConfiguration config;

	@Test
	public void testCreateItem() {
		ItemMaster master = ItemMaster.builder().itemUuid("aasdjiasdu8ahs89asdy8a9h").itemName("test")
				.description("hdbjhvdj").build();
		repository.addItems(master);
	}

	@Test
	public void testUpdateItem() {
		ItemMaster master = ItemMaster.builder().itemUuid("aasdjiasdu8ahs89asdy8a9h").build();
		repository.updateItem(master);
	}

	@Test
	public void testGetItem1() {
		ItemMaster master = ItemMaster.builder().itemName("Test Modified").build();
		org.egov.common.contract.request.User userInfo = new org.egov.common.contract.request.User();
		userInfo.setTenantId("ch.chandigarh");
		userInfo.setRoles(Arrays.asList(Role.builder().code("EAO").name("EAO").build()));
		RequestInfoWrapper infoWrapper = RequestInfoWrapper.builder().requestBody(master)
				.requestInfo(RequestInfo.builder().userInfo(userInfo).build()).build();
		List<ItemMaster> list = new ArrayList<>();
		list.add(master);

		Mockito.when(jdbcTemplate.query(Matchers.anyString(),
				Matchers.any(Object[].class), Matchers.any(BeanPropertyRowMapper.class))).thenReturn(list);
		

		Assert.assertEquals(master.getItemName(), repository.getItem(infoWrapper).get(0).getItemName());

	}
	
	@Test
	public void testGetItem2() {
		ItemMaster master = ItemMaster.builder().itemName("Test Modified").build();
		org.egov.common.contract.request.User userInfo = new org.egov.common.contract.request.User();
		userInfo.setTenantId("ch.chandigarh");
		userInfo.setRoles(Arrays.asList(Role.builder().code("HOD").name("HOD").build()));
		RequestInfoWrapper infoWrapper = RequestInfoWrapper.builder().requestBody(master)
				.requestInfo(RequestInfo.builder().userInfo(userInfo).build()).build();
		List<ItemMaster> list = new ArrayList<>();
		list.add(master);

		Mockito.when(jdbcTemplate.query(Matchers.anyString(),
				Matchers.any(Object[].class), Matchers.any(BeanPropertyRowMapper.class))).thenReturn(list);
		

		Assert.assertEquals(master.getItemName(), repository.getItem(infoWrapper).get(0).getItemName());

	}
}
