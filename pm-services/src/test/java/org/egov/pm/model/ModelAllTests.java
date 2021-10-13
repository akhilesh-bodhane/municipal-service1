package org.egov.pm.model;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ AuditDetailTestCases.class, ColumnsMapsTestCases.class, ColumnsTestCases.class, ColumnTest.class,
		DisplayColumnsTestCases.class, EmailColumnMapsTestCases.class, EmailColumnTestCases.class,
		EmailRequestTestCases.class, EmailTemplateModelTestCases.class, ErrorResponseInfoTestCases.class,
		ErrorsTestCases.class, IdGenModelTestCases.class, IdGenRequestModelTestCases.class,
		NOCApplicationDetailTest.class,// NOCApplicationRemarkTest.class,// NOCApplicationTest.class,
		NOCDetailsRequestDataTest.class, NOCRemarksRequestDataTest.class, NOCRequestDataTest.class,
		RequestInfoWrapperTest.class, SMSRequestTest.class, UserTest.class, EmailColumnMapsTestCases.class,
		EmailColumnsTest.class, DocumentColumnTest.class, DisplayColumnsTestCases.class, PriceBookRequestDataTest.class,
		ReportModelTest.class, RequestDataTest.class,NOCPriceBookTest.class })
public class ModelAllTests {

}
