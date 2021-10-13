package org.egov.pm;

import org.egov.pm.config.ApplicationPropertiesTestCases;
import org.egov.pm.model.ModelAllTests;
import org.egov.pm.producer.ProducerTestCases;
import org.egov.pm.repository.NocRepositoryTestCases;
import org.egov.pm.service.NocServiceTestCases;
import org.egov.pm.web.contract.ContractAllTests;
import org.egov.pm.web.contract.factory.ResponseFactoryTestCases;
import org.egov.pm.web.controller.NocControllerTestCases;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ NocControllerTestCases.class, NocRepositoryTestCases.class, NocServiceTestCases.class,
		ModelAllTests.class, ContractAllTests.class, ApplicationPropertiesTestCases.class, ProducerTestCases.class,ResponseFactoryTestCases.class })
public class AllTests {

}
