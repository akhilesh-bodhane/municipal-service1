package org.egov.integration.repository.builder;

import java.util.List;

import org.egov.integration.model.RequestData;
import org.egov.integration.model.TLPublicDashboardRequest;
import org.springframework.stereotype.Component;

@Component
public class TLQueryBuilderNIUA {

	public static final String QUERY_TL_PUBLIC_DASHBOARD = "select\r\n" + "	count(1) totalApplicationsReceived,\r\n"
			+ "	count(case when ett.status = 'APPROVED' then 1 end) totalApplicationsApproved,\r\n"
			+ "	SUM(case when ett.status = 'APPROVED' then to_timestamp(ett.lastmodifiedtime / 1000)::date - to_timestamp(ett.createdtime / 1000)::date end)/ count(case when ett.status = 'APPROVED' then 1 end) timeTakenForApproval\r\n"
			+ "from\r\n" + "	eg_tl_tradelicense ett\r\n" + "where\r\n" + "	ett.tenantid = 'ch.chandigarh'\r\n"
			+ "	and ett.createdtime >= ?\r\n" + " and ett.createdtime <= ?";

	public static final String QUERY_NIUA = "((\r\n" + "select\r\n"
			+ "	'todaysCollection' ccc , ett.businessservice as name , SUM(py.totaldue) as value, SUM(case when ett.status = 'APPROVED' then 1 else 0 end) approvedLicense, SUM(case when ett.status = 'APPROVED' then to_timestamp(ett.lastmodifiedtime / 1000)::date - to_timestamp(ett.createdtime / 1000)::date else 0 end) approvedCompletionDaysLicense\r\n"
			+ "from\r\n" + "	eg_tl_tradelicense ett\r\n" + "left outer join eg_tl_tradelicensedetail ett2 on\r\n"
			+ "	ett.id = ett2.tradelicenseid\r\n" + "left outer join egcl_bill bl on\r\n"
			+ "	ett.applicationnumber = bl.consumercode\r\n" + "left outer join egcl_paymentdetail pyd on\r\n"
			+ "	pyd.billid = bl.id\r\n" + "left outer join egcl_payment py on\r\n" + "	py.id = pyd.paymentid\r\n"
			+ "where\r\n" + "	ett.tenantid = 'ch.chandigarh'\r\n" + "	and ett.createdtime >= ?\r\n"
			+ "	and ett.createdtime <= ?\r\n" + "group by\r\n" + "	ett.businessservice)\r\n" + "union (\r\n"
			+ "select\r\n"
			+ "'todaysTradeLicenses' ccc , status as name , count(businessservice) as value, SUM(case when ett.status = 'APPROVED' then 1 else 0 end) approvedLicense, SUM(case when ett.status = 'APPROVED' then to_timestamp(ett.lastmodifiedtime / 1000)::date - to_timestamp(ett.createdtime / 1000)::date else 0 end) approvedCompletionDaysLicense\r\n"
			+ "from\r\n" + "eg_tl_tradelicense ett\r\n" + "left outer join eg_tl_tradelicensedetail ett2 on\r\n"
			+ "ett.id = ett2.tradelicenseid\r\n" + "where\r\n" + "ett.tenantid = 'ch.chandigarh'\r\n"
			+ "and ett.createdtime >= ?\r\n" + "and ett.createdtime <= ?\r\n" + "group by\r\n" + "ett.status)\r\n"
			+ "union (\r\n" + "select\r\n"
			+ "'applicationsMovedToday' ccc , status as name, count(status) as value, SUM(case when ett.status = 'APPROVED' then 1 else 0 end) approvedLicense, SUM(case when ett.status = 'APPROVED' then to_timestamp(ett.lastmodifiedtime / 1000)::date - to_timestamp(ett.createdtime / 1000)::date else 0 end) approvedCompletionDaysLicense\r\n"
			+ "from\r\n" + "eg_tl_tradelicense ett\r\n" + "where\r\n" + "applicationnumber in (\r\n" + "select\r\n"
			+ "distinct businessid\r\n" + "from\r\n" + "eg_wf_processinstance_v2 ewpv\r\n" + "where\r\n"
			+ "businessid in (\r\n" + "select\r\n" + "	ett.applicationnumber\r\n" + "from\r\n"
			+ "	eg_tl_tradelicense ett\r\n" + "where\r\n" + "	ett.lastmodifiedtime >= ?\r\n"
			+ "	and ett.lastmodifiedtime <= ? )\r\n" + "group by\r\n" + "businessid )\r\n" + "group by\r\n"
			+ "status))\r\n" + "union (\r\n" + "select\r\n"
			+ "'transactions' ccc , 'transactions' as name, count(status) as value, SUM(case when ett.status = 'APPROVED' then 1 else 0 end) approvedLicense, SUM(case when ett.status = 'APPROVED' then to_timestamp(ett.lastmodifiedtime / 1000)::date - to_timestamp(ett.createdtime / 1000)::date else 0 end) approvedCompletionDaysLicense\r\n"
			+ "from\r\n" + "eg_tl_tradelicense ett\r\n" + "where\r\n" + "applicationnumber in (\r\n" + "select\r\n"
			+ "	distinct businessid\r\n" + "from\r\n" + "	eg_wf_processinstance_v2 ewpv\r\n" + "where\r\n"
			+ "	businessid in (\r\n" + "	select\r\n" + "		ett.applicationnumber\r\n" + "	from\r\n"
			+ "		eg_tl_tradelicense ett\r\n" + "	where\r\n" + "		ett.lastmodifiedtime >= ?\r\n"
			+ "		and ett.lastmodifiedtime <= ? )\r\n" + "group by\r\n" + "	businessid ))\r\n" + "union (\r\n"
			+ "select\r\n"
			+ "'todaysApplications' ccc , 'todaysApplications' as name, count(ett.applicationnumber) as value, SUM(case when ett.status = 'APPROVED' then 1 else 0 end) approvedLicense, SUM(case when ett.status = 'APPROVED' then to_timestamp(ett.lastmodifiedtime / 1000)::date - to_timestamp(ett.createdtime / 1000)::date else 0 end) approvedCompletionDaysLicense\r\n"
			+ "from\r\n" + "eg_tl_tradelicense ett\r\n" + "where\r\n" + "ett.tenantid = 'ch.chandigarh'\r\n"
			+ "and ett.createdtime >= ?\r\n" + "and ett.createdtime <= ? )\r\n" + "union\r\n" + "select\r\n"
			+ "	'adhocPenalty' ccc ,\r\n" + "	'adhocPenalty' as name,\r\n" + "	sum(taxamount) as value,\r\n"
			+ "	0 approvedLicense,\r\n" + "	0 approvedCompletionDaysLicense\r\n" + "from\r\n"
			+ "	egbs_demanddetail_v1 edv\r\n" + "where\r\n" + "	demandid in (\r\n" + "	select\r\n" + "		id\r\n"
			+ "	from\r\n" + "		egbs_demand_v1 edv\r\n" + "	where\r\n" + "		consumercode in (\r\n"
			+ "		select\r\n" + "			ett.applicationnumber\r\n" + "		from\r\n"
			+ "			eg_tl_tradelicense ett\r\n" + "		left outer join eg_tl_tradelicensedetail ett2 on\r\n"
			+ "			ett.id = ett2.tradelicenseid\r\n" + "		left outer join egcl_bill bl on\r\n"
			+ "			ett.applicationnumber = bl.consumercode\r\n"
			+ "		left outer join egcl_paymentdetail pyd on\r\n" + "			pyd.billid = bl.id\r\n"
			+ "		left outer join egcl_payment py on\r\n" + "			py.id = pyd.paymentid\r\n" + "		where\r\n"
			+ "			ett.tenantid = 'ch.chandigarh'\r\n" + "			and ett.createdtime >= ?\r\n"
			+ "			and ett.createdtime <= ?))\r\n"
			+ "	and taxheadcode in ('CTL.OLD_BOOK_MARKET_PENALTY' , 'CTL.DHOBI_GHAT_PENALTY' , 'CTL.REHRI_DRIVING_LICENSE_PENALTY', 'CTL.REHRI_REGISTRATION_PENALTY')\r\n"
			+ "union\r\n" + "select\r\n" + "	'tlTax' ccc ,\r\n" + "	'tlTax' as name,\r\n"
			+ "	sum(taxamount) as value ,\r\n" + "	0 approvedLicense,\r\n" + "	0 approvedCompletionDaysLicense\r\n"
			+ "from\r\n" + "	egbs_demanddetail_v1 edv\r\n" + "where\r\n" + "	demandid in (\r\n" + "	select\r\n"
			+ "		id\r\n" + "	from\r\n" + "		egbs_demand_v1 edv\r\n" + "	where\r\n"
			+ "		consumercode in (\r\n" + "		select\r\n" + "			ett.applicationnumber\r\n"
			+ "		from\r\n" + "			eg_tl_tradelicense ett\r\n"
			+ "		left outer join eg_tl_tradelicensedetail ett2 on\r\n"
			+ "			ett.id = ett2.tradelicenseid\r\n" + "		left outer join egcl_bill bl on\r\n"
			+ "			ett.applicationnumber = bl.consumercode\r\n"
			+ "		left outer join egcl_paymentdetail pyd on\r\n" + "			pyd.billid = bl.id\r\n"
			+ "		left outer join egcl_payment py on\r\n" + "			py.id = pyd.paymentid\r\n" + "		where\r\n"
			+ "			ett.tenantid = 'ch.chandigarh'\r\n" + "			and ett.createdtime >= ?\r\n"
			+ "			and ett.createdtime <= ?))\r\n"
			+ "	and taxheadcode not in ('CTL.OLD_BOOK_MARKET_PENALTY' , 'CTL.DHOBI_GHAT_PENALTY' , 'CTL.REHRI_DRIVING_LICENSE_PENALTY', 'CTL.REHRI_REGISTRATION_PENALTY')";

//	public static final String QUERY_NIUA = "(( select 'todaysCollection' ccc ,\r\n"
//			+ "			      ett.businessservice as name ,\r\n" + "			      SUM(py.totaldue) as value \r\n"
//			+ "			      from eg_tl_tradelicense ett \r\n"
//			+ "			      LEFT OUTER join eg_tl_tradelicensedetail ett2 on ett.id = ett2.tradelicenseid\r\n"
//			+ "			      LEFT OUTER JOIN egcl_bill bl  on  ett.applicationnumber  = bl.consumercode \r\n"
//			+ "			      LEFT OUTER JOIN egcl_paymentdetail pyd on pyd.billid = bl.id \r\n"
//			+ "			      LEFT OUTER JOIN egcl_payment py on py.id= pyd.paymentid \r\n"
//			+ "			      where ett.tenantid = 'ch.chandigarh'\r\n" + "			      and ett.createdtime >= ? \r\n"
//			+ "			      and  ett.createdtime <= ? \r\n" + "			      group by ett.businessservice)\r\n"
//			+ "			      \r\n" + "			      union \r\n" + "			      \r\n"
//			+ "			      ( select 'todaysTradeLicenses' ccc ,\r\n" + "			      status as name ,\r\n"
//			+ "			      count(businessservice) as value\r\n" + "			      \r\n"
//			+ "			      from eg_tl_tradelicense ett \r\n"
//			+ "			      LEFT OUTER join eg_tl_tradelicensedetail ett2 on ett.id = ett2.tradelicenseid \r\n"
//			+ "			      where ett.tenantid = 'ch.chandigarh'\r\n" + "			      and ett.createdtime >= ? \r\n"
//			+ "			      and  ett.createdtime <= ? \r\n" + "			      group by ett.status)\r\n"
//			+ "			      \r\n" + "			      union \r\n" + "			      \r\n"
//			+ "			      ( select 'applicationsMovedToday' ccc , status as name,\r\n"
//			+ "			      count(status) as value from eg_tl_tradelicense ett where applicationnumber in (select  distinct businessid \r\n"
//			+ "			      from eg_wf_processinstance_v2 ewpv where  businessid in \r\n"
//			+ "			     ( select ett.applicationnumber  from eg_tl_tradelicense ett \r\n"
//			+ "			      where ett.lastmodifiedtime >= ? \r\n"
//			+ "			      and  ett.lastmodifiedtime  <=  ? )\r\n" + "			      group by businessid )\r\n"
//			+ "			      group by status))\r\n" + "			      \r\n" + "			      union \r\n"
//			+ "			      \r\n" + "			      ( select 'transactions' ccc  , 'transactions' as name,\r\n"
//			+ "			      count(status) as value from eg_tl_tradelicense ett where applicationnumber in (select  distinct businessid \r\n"
//			+ "			      from eg_wf_processinstance_v2 ewpv where  businessid in \r\n"
//			+ "			     ( select ett.applicationnumber  from eg_tl_tradelicense ett \r\n"
//			+ "			      where ett.lastmodifiedtime >= ? \r\n"
//			+ "			      and  ett.lastmodifiedtime  <= ? )\r\n" + "			      group by businessid ))\r\n"
//			+ "			      \r\n" + "			      \r\n" + "			      union \r\n" + "			      \r\n"
//			+ "			      ( select 'todaysApplications' ccc  , 'todaysApplications' as name, count(ett.applicationnumber)  as value from eg_tl_tradelicense ett \r\n"
//			+ "			      where  ett.tenantid = 'ch.chandigarh'\r\n"
//			+ "			      and ett.createdtime >= ? \r\n" + "			      and  ett.createdtime <= ? )\r\n"
//			+ "			union \r\n" + "			select 'adhocPenalty' ccc  , 'adhocPenalty' as name, \r\n"
//			+ "			      sum(taxamount) as value  \r\n" + "			from egbs_demanddetail_v1 edv \r\n"
//			+ "			where demandid  in (select id  from egbs_demand_v1 edv where consumercode in (select ett.applicationnumber \r\n"
//			+ "			      from eg_tl_tradelicense ett \r\n"
//			+ "			      LEFT OUTER join eg_tl_tradelicensedetail ett2 on ett.id = ett2.tradelicenseid\r\n"
//			+ "			      LEFT OUTER JOIN egcl_bill bl  on  ett.applicationnumber  = bl.consumercode \r\n"
//			+ "			      LEFT OUTER JOIN egcl_paymentdetail pyd on pyd.billid = bl.id \r\n"
//			+ "			      LEFT OUTER JOIN egcl_payment py on py.id= pyd.paymentid \r\n"
//			+ "			      where ett.tenantid = 'ch.chandigarh'\r\n" + "			      and ett.createdtime >= ? \r\n"
//			+ "			      and  ett.createdtime <= ?)) and taxheadcode  in ('CTL.OLD_BOOK_MARKET_PENALTY' , 'CTL.DHOBI_GHAT_PENALTY' , 'CTL.REHRI_DRIVING_LICENSE_PENALTY','CTL.REHRI_REGISTRATION_PENALTY')\r\n"
//			+ "			     \r\n" + "			union \r\n" + "			 select  'tlTax' ccc  , 'tlTax' as name,\r\n"
//			+ "			      sum(taxamount) \r\n" + "			from egbs_demanddetail_v1 edv \r\n"
//			+ "			where demandid  in (select id  from egbs_demand_v1 edv where consumercode in (select ett.applicationnumber \r\n"
//			+ "			      from eg_tl_tradelicense ett \r\n"
//			+ "			      LEFT OUTER join eg_tl_tradelicensedetail ett2 on ett.id = ett2.tradelicenseid\r\n"
//			+ "			      LEFT OUTER JOIN egcl_bill bl  on  ett.applicationnumber  = bl.consumercode \r\n"
//			+ "			      LEFT OUTER JOIN egcl_paymentdetail pyd on pyd.billid = bl.id \r\n"
//			+ "			      LEFT OUTER JOIN egcl_payment py on py.id= pyd.paymentid \r\n"
//			+ "			      where ett.tenantid = 'ch.chandigarh'\r\n" + "			      and ett.createdtime >= ? \r\n"
//			+ "			      and  ett.createdtime <= ?)) and taxheadcode not in \r\n"
//			+ "			('CTL.OLD_BOOK_MARKET_PENALTY' , 'CTL.DHOBI_GHAT_PENALTY' , 'CTL.REHRI_DRIVING_LICENSE_PENALTY',\r\n"
//			+ "			'CTL.REHRI_REGISTRATION_PENALTY')";

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
		preparedStmtList.add(criteria.getFromDate());
		preparedStmtList.add(criteria.getToDate());
		preparedStmtList.add(criteria.getFromDate());
		preparedStmtList.add(criteria.getToDate());

		return builder.toString();

		// enrichCriteriaForUpdateSearch(builder,preparedStmtList,criteria);

	}

	public String getTLPublicDashboardSearchQuery(TLPublicDashboardRequest tlPublicDashboardRequest,
			List<Object> preparedStmtList) {
		StringBuilder builder = new StringBuilder(QUERY_TL_PUBLIC_DASHBOARD);
		preparedStmtList.add(tlPublicDashboardRequest.getFromDate());
		preparedStmtList.add(tlPublicDashboardRequest.getToDate());
		return builder.toString();
	}
}
