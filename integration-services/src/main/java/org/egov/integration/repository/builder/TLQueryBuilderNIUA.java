package org.egov.integration.repository.builder;

import java.util.List;

import org.egov.integration.model.RequestData;
import org.springframework.stereotype.Component;

@Component
public class TLQueryBuilderNIUA {	
	 

	
	public static final String QUERY_NIUA = "  (( select 'todaysCollection' ccc ,\r\n"
			+ "      ett.businessservice as name ,\r\n"
			+ "      SUM(py.totaldue) as value \r\n"
			+ "      from eg_tl_tradelicense ett \r\n"
			+ "      LEFT OUTER join eg_tl_tradelicensedetail ett2 on ett.id = ett2.tradelicenseid\r\n"
			+ "      LEFT OUTER JOIN egcl_bill bl  on  ett.applicationnumber  = bl.consumercode \r\n"
			+ "      LEFT OUTER JOIN egcl_paymentdetail pyd on pyd.billid = bl.id \r\n"
			+ "      LEFT OUTER JOIN egcl_payment py on py.id= pyd.paymentid \r\n"
			+ "      where ett.tenantid = 'ch.chandigarh'\r\n"
			+ "      and ett.createdtime >= ? \r\n"
			+ "      and  ett.createdtime <= ? \r\n"
			+ "      group by ett.businessservice)\r\n"
			+ "      \r\n"
			+ "      union \r\n"
			+ "      \r\n"
			+ "      ( select 'todaysTradeLicenses' ccc ,\r\n"
			+ "      status as name ,\r\n"
			+ "      count(businessservice) as value\r\n"
			+ "      \r\n"
			+ "      from eg_tl_tradelicense ett \r\n"
			+ "      LEFT OUTER join eg_tl_tradelicensedetail ett2 on ett.id = ett2.tradelicenseid \r\n"
			+ "      where ett.tenantid = 'ch.chandigarh'\r\n"
			+ "      and ett.createdtime >= ? \r\n"
			+ "      and  ett.createdtime <= ? \r\n"
			+ "      group by ett.status)\r\n"
			+ "      \r\n"
			+ "      union \r\n"
			+ "      \r\n"
			+ "      ( select 'applicationsMovedToday' ccc , status as name,\r\n"
			+ "      count(status) as value from eg_tl_tradelicense ett where applicationnumber in (select  distinct businessid \r\n"
			+ "      from eg_wf_processinstance_v2 ewpv where  businessid in \r\n"
			+ "     ( select ett.applicationnumber  from eg_tl_tradelicense ett \r\n"
			+ "      where ett.lastmodifiedtime >= ? \r\n"
			+ "      and  ett.lastmodifiedtime  <=  ? )\r\n"
			+ "      group by businessid )\r\n"
			+ "      group by status))\r\n"
			+ "      \r\n"
			+ "      union \r\n"
			+ "      \r\n"
			+ "      ( select 'transactions' ccc  , 'transactions' as name,\r\n"
			+ "      count(status) as value from eg_tl_tradelicense ett where applicationnumber in (select  distinct businessid \r\n"
			+ "      from eg_wf_processinstance_v2 ewpv where  businessid in \r\n"
			+ "     ( select ett.applicationnumber  from eg_tl_tradelicense ett \r\n"
			+ "      where ett.lastmodifiedtime >= ? \r\n"
			+ "      and  ett.lastmodifiedtime  <= ? )\r\n"
			+ "      group by businessid ))\r\n"
			+ "      \r\n"
			+ "      \r\n"
			+ "      union \r\n"
			+ "      \r\n"
			+ "      ( select 'todaysApplications' ccc  , 'todaysApplications' as name, count(ett.applicationnumber)  as value from eg_tl_tradelicense ett \r\n"
			+ "      where  ett.tenantid = 'ch.chandigarh'\r\n"
			+ "      and ett.createdtime >= ? \r\n"
			+ "      and  ett.createdtime <= ? ) " ;
	
	
    public String getTLSearchQuery(RequestData criteria, List<Object> preparedStmtList) {

        StringBuilder builder = new StringBuilder(QUERY_NIUA);


            preparedStmtList.add(criteria.getFromDate());
            preparedStmtList.add(criteria.getToDate());
            preparedStmtList.add(criteria.getFromDate());
            preparedStmtList.add(criteria.getToDate());
            preparedStmtList.add(criteria.getFromDate());
            preparedStmtList.add(criteria.getToDate());
            preparedStmtList.add(criteria.getFromDate());
            preparedStmtList.add(criteria.getToDate());
            preparedStmtList.add(criteria.getFromDate());
            preparedStmtList.add(criteria.getToDate());



            return builder.toString();
        











       // enrichCriteriaForUpdateSearch(builder,preparedStmtList,criteria);

    }
}
