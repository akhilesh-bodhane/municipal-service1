package org.egov.ec.repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.egov.common.contract.request.RequestInfo;
import org.egov.common.contract.request.Role;
import org.egov.ec.config.EchallanConfiguration;
import org.egov.ec.producer.Producer;
import org.egov.ec.repository.VendorRegistrationRepository;
import org.egov.ec.web.models.EcSearchCriteria;
import org.egov.ec.web.models.RequestInfoWrapper;
import org.egov.ec.web.models.VendorRegistration;
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
public class VendorRegistrationRepositoryTest {

	@InjectMocks
	private VendorRegistrationRepository repository;

	@Mock
	private JdbcTemplate jdbcTemplate;

	@Mock
	private Producer producer;

	@Mock
	private EchallanConfiguration config;

	@Test
	public void testCreateVendorRegistration() {
		VendorRegistration master = VendorRegistration.builder().vendorUuid("aasdjiasdu8ahs89asdy8a9h")
				.vendorCategory("test").build();
		repository.saveVendor(master);
	}

	@Test
	public void testUpdateVendorRegistration() {
		VendorRegistration master = VendorRegistration.builder().vendorUuid("aasdjiasdu8ahs89asdy8a9h").build();
		repository.updateVendor(master);
	}

	@Test
	public void testGetVendorRegistration1() {
		VendorRegistration master = VendorRegistration.builder().vendorUuid("Test Modified").build();
		EcSearchCriteria ecSearchCriteria = EcSearchCriteria.builder().searchText("MCC-EC-000211").build();
		List<VendorRegistration> list = new ArrayList<>();
		list.add(master);

		Mockito.when(jdbcTemplate.query(Matchers.anyString(), Matchers.any(Object[].class),
				Matchers.any(BeanPropertyRowMapper.class))).thenReturn(list);

		Assert.assertEquals(master.getVendorRegistrationList(),
				repository.getVendor(ecSearchCriteria).get(0).getVendorRegistrationList());

	}

	@Test
	public void testGetVendorRegistration2() {
		VendorRegistration master = VendorRegistration.builder().vendorUuid("Test Modified").build();
		EcSearchCriteria ecSearchCriteria = EcSearchCriteria.builder().searchText(null).build();
		List<VendorRegistration> list = new ArrayList<>();
		list.add(master);

		Mockito.when(jdbcTemplate.query(Matchers.anyString(), Matchers.any(Object[].class),
				Matchers.any(BeanPropertyRowMapper.class))).thenReturn(list);

		Assert.assertEquals(master.getVendorRegistrationList(),
				repository.getVendor(ecSearchCriteria).get(0).getVendorRegistrationList());

	}

}
