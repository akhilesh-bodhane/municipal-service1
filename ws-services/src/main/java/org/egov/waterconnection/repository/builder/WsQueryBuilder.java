package org.egov.waterconnection.repository.builder;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.egov.common.contract.request.RequestInfo;
import org.egov.tracer.model.CustomException;
import org.egov.waterconnection.config.WSConfiguration;
import org.egov.waterconnection.constants.WCConstants;
import org.egov.waterconnection.model.Property;
import org.egov.waterconnection.model.PublicDashBoardSearchCritieria;
import org.egov.waterconnection.model.PublicDashboardSearch;
import org.egov.waterconnection.model.SearchCriteria;
import org.egov.waterconnection.model.SearchTotalCollectionCriteria;
import org.egov.waterconnection.service.UserService;
import org.egov.waterconnection.util.WaterServicesUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

@Component
public class WsQueryBuilder {

	@Autowired
	private WaterServicesUtil waterServicesUtil;

	@Autowired
	private WSConfiguration config;

	@Autowired
	private UserService userService;

	public static final String getBillingDataForDemandGeneration = "SELECT id as billGenerationId, cccode as ccCode, divsdiv as divSdiv, consumercode as consumerCode, billcycle as billCycle, billgroup as billGroup,\r\n"
			+ " subgroup as subGroup, \r\n"
			+ "       billtype as billType, name as name, address as address, add1 as add1, add2 as add2, add3  , add4  , add5  , cesscharge , \r\n"
			+ "       netamount , grossamount , surcharge , totalnetamount  , totalsurcharge  , \r\n"
			+ "       totalgrossamount , fixchargecode , fixcharge  , duedatecash , duedatecheque  , \r\n"
			+ "       status , billid , paymentid  ,totalamount_paid as totalAmountPaid, paymentmode, receiptdate, paymentstatus , createdby , lastmodifiedby  , \r\n"
			+ "       createdtime , lastmodifiedtime\r\n" + "  FROM eg_ws_savebilling where status ='PAID';";

	public static final String GET_WS_BILLING_FILES = "SELECT  filestore_url as billFileStoreUrl, filestore_id as billFileStoreId, filegeneration_time as fileGenerationTime\r\n"
			+ "  FROM eg_ws_billfile_history;";
	public static final String GET_WS_BILLING_Data = "SELECT id as billGenerationId, cccode as ccCode, divsdiv as divSdiv, consumercode as consumerCode, billcycle as billCycle, billgroup as billGroup,\r\n"
			+ " subgroup as subGroup, \r\n"
			+ "       billtype as billType, name as name, address as address, add1 as add1, add2 as add2, add3 as add3 , add4 as add4 , add5 as add5, cesscharge as cessCharge, \r\n"
			+ "       netamount as netAmount, grossamount as grossAmount , surcharge  , totalnetamount  , totalsurcharge  , \r\n"
			+ "       totalgrossamount  , fixchargecode  , fixcharge  , duedatecash  , duedatecheque  , \r\n"
			+ "       status  , billid  , paymentid , paymentstatus  , createdby  , lastmodifiedby  , \r\n"
			+ "       createdtime  , lastmodifiedtime\r\n"
			+ "  FROM eg_ws_savebilling where concat(divsdiv,consumercode) = ?;";
	private static final String INNER_JOIN_STRING = " INNER JOIN ";
	private static final String LEFT_OUTER_JOIN_STRING = " LEFT OUTER JOIN ";

	private static final String LEFT_JOIN_STRING = " LEFT JOIN ";

	private static String holderSelectValues = "connectionholder.tenantid as holdertenantid, connectionholder.connectionid as holderapplicationId, userid, connectionholder.status as holderstatus, isprimaryholder, connectionholdertype,connectionholder.correspondance_address as holdercorrepondanceaddress, holdershippercentage, connectionholder.relationship as holderrelationship,connectionholder.name as holdername,connectionholder.proposed_mobile_no as proposedMobileNo ,connectionholder.proposed_name as  proposedName,connectionholder.proposed_gender as proposedGender ,connectionholder.proposed_guardian_name as proposedGuardianName ,connectionholder.proposed_correspondance_address as  proposedCorrespondanceAddress , connectionholder.createdby as holdercreatedby, connectionholder.createdtime as holdercreatedtime, connectionholder.lastmodifiedby as holderlastmodifiedby,"
			+ " connectionholder.lastmodifiedtime as holderlastmodifiedtime, connectionholder.ws_application_id, connectionholder.sameuservalid, connectionholder.submitby, connectionholder.submitbyname,";
	
	private static final String WATER_CONNECTION_SEARCH_QUERY = "select " + holderSelectValues +" from eg_ws_connectionholder connectionholder ";

	private static final String WATER_SEARCH_QUERY = "SELECT "
			/* + " conn.*, wc.*, document.*, plumber.*, application.*, property.*, " */
			+ " wc.connectionCategory, wc.connectionType, wc.waterSource, wc.meterCount, wc.meterRentCode, wc.mfrCode, wc.meterDigits, wc.meterUnit, wc.sanctionedCapacity,"
			+ " wc.meterId, wc.meterInstallationDate, wc.pipeSize, wc.noOfTaps, wc.proposedPipeSize, wc.proposedTaps, wc.connection_id as connection_Id, wc.connectionExecutionDate, wc.initialmeterreading,wc.lastmeterreading, wc.appCreatedDate,wc.proposed_meterid, wc.proposed_meterinstallationdate,wc.proposed_initialmeterreading,wc.proposed_lastmeterreading,wc.proposed_metercount,wc.proposed_meterrentcode,wc.proposed_mfrcode,wc.proposed_meterdigits,  wc.proposed_sanctionedcapacity,wc.proposed_meterunit,"
			+ " wc.detailsprovidedby, wc.estimationfileStoreId , wc.sanctionfileStoreId , wc.estimationLetterDate, py.paymentmode,py.lastmodifiedtime as paymentdate ,"
			+ " conn.id as conn_id, conn.tenantid, conn.applicationNo, conn.applicationStatus, conn.status, conn.connectionNo, conn.oldConnectionNo, conn.property_id, conn.roadcuttingarea,"
			+ " conn.aadharNo, conn.ferruleSize, conn.action, conn.adhocpenalty, conn.adhocrebate, conn.adhocpenaltyreason, conn.applicationType, conn.dateEffectiveFrom,"
			+ " conn.adhocpenaltycomment, conn.adhocrebatereason, conn.adhocrebatecomment, conn.cccode, conn.div, conn.subdiv, conn.ledger_no,conn.ledgergroup, conn.createdBy as ws_createdBy, conn.lastModifiedBy as ws_lastModifiedBy,"
			+ " conn.createdTime as ws_createdTime, conn.lastModifiedTime as ws_lastModifiedTime, "
			+ " conn.roadtype,conn.proposedUsage_category, conn.waterApplicationType, conn.securityCharge, conn.connectionusagestype, conn.inworkflow, conn.billGroup, conn.contract_value, "
			+ " document.id as doc_Id, document.documenttype, document.filestoreid, document.active as doc_active, plumber.id as plumber_id,"
			+ " plumber.name as plumber_name, plumber.licenseno,"
			+ " plumber.mobilenumber as plumber_mobileNumber, plumber.gender as plumber_gender, plumber.fatherorhusbandname, plumber.correspondenceaddress,"
			+ " plumber.relationship, " + holderSelectValues
			+ " application.id as application_id, application.applicationno as app_applicationno, application.activitytype as app_activitytype, application.applicationstatus as app_applicationstatus, application.action as app_action, application.comments as app_comments, application.is_ferrule_applicable as app_ferrule, application.security_charges as app_securitycharge, application.total_amount_paid, application.additionalcharges, application.constructioncharges, application.outstandingcharges,  application.ismeterstolen,application.application_code,application.waterchargestt as waterChargesTT,"
			+ " application.createdBy as app_createdBy, application.lastModifiedBy as app_lastModifiedBy, application.createdTime as app_createdTime, application.lastModifiedTime as app_lastModifiedTime,application.location,connectionholder.sameuservalid, connectionholder.submitby, connectionholder.submitbyname, "
			+ " property.id as waterpropertyid, property.usagecategory, property.usagesubcategory,property.plotareatt as ploatAreaTT,pta.doorno as propertyplotno,pta.locality as propertysectorno "
			+ " FROM eg_ws_connection conn " + INNER_JOIN_STRING + "eg_ws_service wc ON wc.connection_id = conn.id"
			+ INNER_JOIN_STRING + "eg_pt_address pta ON conn.property_id = pta.propertyid" + INNER_JOIN_STRING
			+ "eg_ws_application application ON application.wsid = conn.id" + INNER_JOIN_STRING
			+ "eg_ws_property property ON property.wsid = conn.id" + INNER_JOIN_STRING
			//change to resolve proposed owner null issue
			+ "eg_ws_connectionholder connectionholder ON connectionholder.connectionid = conn.id "
			+ LEFT_OUTER_JOIN_STRING + "egcl_bill bl  on  application.applicationno = bl.consumercode"
			+ LEFT_OUTER_JOIN_STRING + "egcl_paymentdetail pyd on pyd.billid = bl.id" + LEFT_OUTER_JOIN_STRING
			+ "egcl_payment py on py.id= pyd.paymentid" + LEFT_OUTER_JOIN_STRING
			+ "eg_ws_applicationdocument document ON document.applicationid = application.id" + LEFT_OUTER_JOIN_STRING
			+ "eg_ws_plumberinfo plumber ON plumber.wsid = conn.id";

	private static final String WATER_SEARCH_QUERY_APPLICATION = "SELECT "
			/* + " conn.*, wc.*, document.*, plumber.*, application.*, property.*, " */
			+ " wc.connectionCategory, wc.connectionType, wc.waterSource, wc.meterCount, wc.meterRentCode, wc.mfrCode, wc.meterDigits, wc.meterUnit, wc.sanctionedCapacity,"
			+ " wc.meterId, wc.meterInstallationDate, wc.pipeSize, wc.noOfTaps, wc.proposedPipeSize, wc.proposedTaps, wc.connection_id as connection_Id, wc.connectionExecutionDate, wc.initialmeterreading,wc.lastmeterreading, wc.appCreatedDate,wc.proposed_meterid, wc.proposed_meterinstallationdate,wc.proposed_initialmeterreading,wc.proposed_lastmeterreading,wc.proposed_metercount,wc.proposed_meterrentcode,wc.proposed_mfrcode,wc.proposed_meterdigits,  wc.proposed_sanctionedcapacity,wc.proposed_meterunit,"
			+ " wc.detailsprovidedby, wc.estimationfileStoreId , wc.sanctionfileStoreId , wc.estimationLetterDate, py.paymentmode,py.lastmodifiedtime as paymentdate ,"
			+ " conn.id as conn_id, conn.tenantid, conn.applicationNo, conn.applicationStatus, conn.status, conn.connectionNo, conn.oldConnectionNo, conn.property_id, conn.roadcuttingarea,"
			+ " conn.aadharNo, conn.ferruleSize, conn.action, conn.adhocpenalty, conn.adhocrebate, conn.adhocpenaltyreason, conn.applicationType, conn.dateEffectiveFrom,"
			+ " conn.adhocpenaltycomment, conn.adhocrebatereason, conn.adhocrebatecomment, conn.cccode, conn.div, conn.subdiv, conn.ledger_no,conn.ledgergroup, conn.createdBy as ws_createdBy, conn.lastModifiedBy as ws_lastModifiedBy,"
			+ " conn.createdTime as ws_createdTime, conn.lastModifiedTime as ws_lastModifiedTime, "
			+ " conn.roadtype,conn.proposedUsage_category, conn.waterApplicationType, conn.securityCharge, conn.connectionusagestype, conn.inworkflow, conn.billGroup, conn.contract_value, "
			+ " document.id as doc_Id, document.documenttype, document.filestoreid, document.active as doc_active, plumber.id as plumber_id,"
			+ " plumber.name as plumber_name, plumber.licenseno,"
			+ " plumber.mobilenumber as plumber_mobileNumber, plumber.gender as plumber_gender, plumber.fatherorhusbandname, plumber.correspondenceaddress,"
			+ " plumber.relationship, " + holderSelectValues
			+ " application.id as application_id, application.applicationno as app_applicationno, application.activitytype as app_activitytype, application.applicationstatus as app_applicationstatus, application.action as app_action, application.comments as app_comments, application.is_ferrule_applicable as app_ferrule, application.security_charges as app_securitycharge, application.total_amount_paid, application.additionalcharges, application.constructioncharges, application.outstandingcharges,  application.ismeterstolen,application.application_code,application.waterchargestt as waterChargesTT,"
			+ " application.createdBy as app_createdBy, application.lastModifiedBy as app_lastModifiedBy, application.createdTime as app_createdTime, application.lastModifiedTime as app_lastModifiedTime,application.location,connectionholder.sameuservalid, connectionholder.submitby, connectionholder.submitbyname, "
			+ " property.id as waterpropertyid, property.usagecategory, property.usagesubcategory,property.plotareatt as ploatAreaTT,pta.doorno as propertyplotno,pta.locality as propertysectorno "
			+ " FROM eg_ws_connection conn " + INNER_JOIN_STRING + "eg_ws_service wc ON wc.connection_id = conn.id"
			+ INNER_JOIN_STRING + "eg_pt_address pta ON conn.property_id = pta.propertyid" + INNER_JOIN_STRING
			+ "eg_ws_application application ON application.wsid = conn.id" + INNER_JOIN_STRING
			+ "eg_ws_property property ON property.wsid = conn.id" + INNER_JOIN_STRING
			//changes done for initiated application not seen in citizen 
			+ "eg_ws_connectionholder connectionholder ON connectionholder.ws_application_id  = application.id"
			+ LEFT_OUTER_JOIN_STRING + "egcl_bill bl  on  application.applicationno = bl.consumercode"
			+ LEFT_OUTER_JOIN_STRING + "egcl_paymentdetail pyd on pyd.billid = bl.id" + LEFT_OUTER_JOIN_STRING
			+ "egcl_payment py on py.id= pyd.paymentid" + LEFT_OUTER_JOIN_STRING
			+ "eg_ws_applicationdocument document ON document.applicationid = application.id" + LEFT_OUTER_JOIN_STRING
			+ "eg_ws_plumberinfo plumber ON plumber.wsid = conn.id";
	// + LEFT_OUTER_JOIN_STRING
	// + "eg_ws_connection_mapping cm ON cm.wsid = conn.id";

	private static final String NO_OF_CONNECTION_SEARCH_QUERY = "SELECT count(*) FROM eg_ws_connection WHERE";

	private static final String PAGINATION_WRAPPER = "SELECT * FROM "
			+ "(SELECT *, DENSE_RANK() OVER (ORDER BY conn_id desc) offset_ FROM " + "({})" + " result) result_offset "
			+ "WHERE offset_ > ? AND offset_ <= ?";

	//private static final String ORDER_BY_CLAUSE = " ORDER BY conn.id DESC";
	
	private static final String ORDER_BY_CLAUSE = " ORDER BY connectionholder.lastmodifiedtime DESC";
	
	private static final String ORDER_BY_CLAUSE_APPNO = " ORDER BY application.applicationno DESC";

	public static final String GET_PIECHART_DATA = "SELECT id, cccode, divsdiv, consumercode, billcycle, billgroup, subgroup, \r\n"
			+ "       billtype, name, address, cesscharge, netamount, grossamount, \r\n"
			+ "       surcharge, totalnetamount, totalsurcharge, totalgrossamount, \r\n"
			+ "       fixchargecode, fixcharge, duedatecash, duedatecheque, status, \r\n"
			+ "       billid, paymentid, paymentstatus, createdby, lastmodifiedby, \r\n"
			+ "       createdtime, lastmodifiedtime, totalamount_paid, paymentmode, \r\n"
			+ "       fromdate, todate, receiptdate, year\r\n"
			+ "  FROM eg_ws_monthlybill_history where lastmodifiedtime >= ? and lastmodifiedtime <= ? ;";

	private static final String WATER_SEARCH_QUERY_COUNT = "SELECT   wc.connectionType, wc.connection_id as connection_Id, conn.subdiv,"
			+ " py.paymentmode,py.lastmodifiedtime as paymentdate , conn.applicationStatus, conn.status,  conn.createdTime as ws_createdTime, "
			+ "conn.lastModifiedTime as ws_lastModifiedTime,   conn.waterApplicationType,   \r\n"
			+ " application.activitytype as app_activitytype, application.applicationno as app_applicationno, conn.lastModifiedBy as ws_lastModifiedBy,"
			+ " conn.createdBy as ws_createdBy, application.applicationstatus as app_applicationstatus, \r\n"
			+ " application.total_amount_paid\r\n" + " FROM \r\n" + "eg_ws_connection conn  \r\n"
			+ "INNER JOIN eg_ws_service wc ON wc.connection_id = conn.id \r\n"
			+ "INNER JOIN eg_ws_application application ON application.wsid = conn.id \r\n"
			+ "LEFT OUTER JOIN egcl_bill bl  on  application.applicationno = bl.consumercode \r\n"
			+ "LEFT OUTER JOIN egcl_paymentdetail pyd on pyd.billid = bl.id \r\n"
			+ "LEFT OUTER JOIN egcl_payment py on py.id= pyd.paymentid ";

	private static final String WATER_SEARCH_QUERY_NIUA3 = "select  'ONLINE' as name , sum(sss.ccccc) as value  from  ((select count(connectionType) as ccccc , 'ONLINE' ccc \r\n"
			+ "from eg_sw_connection py \r\n" + "INNER JOIN  eg_sw_service sc ON sc.connection_id = py.id\r\n"
			+ "WHERE py.createdtime  >= ? AND py.createdtime <= ? and connectionType is not null\r\n"
			+ "group by	connectionType)\r\n" + "\r\n" + "union \r\n" + "\r\n" + "SELECT  distinct\r\n" + "\r\n"
			+ "count(wc.connectiontype) as cccc , 'ONLINE' ccc \r\n" + "FROM eg_ws_connection conn\r\n"
			+ "INNER JOIN eg_ws_service wc ON wc.connection_id = conn.id\r\n"
			+ "INNER JOIN eg_ws_application application ON application.wsid = conn.id\r\n"
			+ "WHERE  conn.tenantid  LIKE 'ch.chandigarh'\r\n"
			+ "     and application.createdtime  >= ? AND application.createdtime <= ? \r\n"
			+ "     group by wc.connectiontype) as sss ";

	private static final String WATER_SEARCH_QUERY_NIUA = "select '0to3Days' as name , count(vvvv.applicationno) as value from  	(select applicationno ,  vvv.days from 	(select applicationno ,  \r\n"
			+ "	            CURRENT_DATE  - to_date(to_char(to_timestamp(createdtime/1000),'YYYY-MM-DD'),'YYYY-MM-DD') AS days  from eg_ws_application application  where \r\n"
			+ "				application.action not in ('ACTIVATE_REGULAR_CONNECTION' , 'CLOSED_CONNECTION_FROM_SUPERINTENDENT' , 'CANCEL_APPLICATION' , 'REJECT' , 'INITIATE' )\r\n"
			+ "				and application.activitytype in ('TT_WATER_CONNECTION' , 'NEW_WS_CONNECTION' )\r\n"
			+ "				and application.createdtime  >= ? \r\n"
			+ "				AND application.createdtime <=  ? ) vvv\r\n"
			+ "				where  vvv.days  <= 3   and vvv.days  >= 0 ) vvvv\r\n" + "				\r\n"
			+ "				union \r\n" + "				\r\n" + "				\r\n"
			+ "				select '3to7Days' as usagecategory , count(vvvv.applicationno) as cccc from  	(select applicationno ,  vvv.days from 	(select applicationno ,  \r\n"
			+ "	            CURRENT_DATE  - to_date(to_char(to_timestamp(createdtime/1000),'YYYY-MM-DD'),'YYYY-MM-DD') AS days  from eg_ws_application application  where \r\n"
			+ "				application.action not in ('ACTIVATE_REGULAR_CONNECTION' , 'CLOSED_CONNECTION_FROM_SUPERINTENDENT' , 'CANCEL_APPLICATION' , 'REJECT' , 'INITIATE' )\r\n"
			+ "				and application.activitytype in ('TT_WATER_CONNECTION' , 'NEW_WS_CONNECTION' )\r\n"
			+ "				and application.createdtime  >= ? \r\n"
			+ "				AND application.createdtime <=  ? ) vvv\r\n"
			+ "				where  vvv.days <= 7  and vvv.days  >= 3 ) vvvv\r\n" + "				\r\n"
			+ "				union\r\n" + "				\r\n"
			+ "				select '7to15Days' as usagecategory , count(vvvv.applicationno) as cccc from  	(select applicationno ,  vvv.days from 	(select applicationno ,  \r\n"
			+ "	            CURRENT_DATE  - to_date(to_char(to_timestamp(createdtime/1000),'YYYY-MM-DD'),'YYYY-MM-DD') AS days  from eg_ws_application application  where \r\n"
			+ "				application.action not in ('ACTIVATE_REGULAR_CONNECTION' , 'CLOSED_CONNECTION_FROM_SUPERINTENDENT' , 'CANCEL_APPLICATION' , 'REJECT' , 'INITIATE' )\r\n"
			+ "				and application.activitytype in ('TT_WATER_CONNECTION' , 'NEW_WS_CONNECTION' )\r\n"
			+ "				and application.createdtime  >= ? \r\n"
			+ "				AND application.createdtime <=  ? ) vvv\r\n"
			+ "				where  vvv.days <= 15  and vvv.days  >= 7 ) vvvv\r\n" + "				\r\n"
			+ "				union\r\n" + "				\r\n"
			+ "				select 'MoreThan15Days' as usagecategory , count(vvvv.applicationno) as cccc from  	(select applicationno ,  vvv.days from 	(select applicationno ,  \r\n"
			+ "	            CURRENT_DATE  - to_date(to_char(to_timestamp(createdtime/1000),'YYYY-MM-DD'),'YYYY-MM-DD') AS days  from eg_ws_application application  where \r\n"
			+ "				application.action not in ('ACTIVATE_REGULAR_CONNECTION' , 'CLOSED_CONNECTION_FROM_SUPERINTENDENT' , 'CANCEL_APPLICATION' , 'REJECT' , 'INITIATE' )\r\n"
			+ "				and application.activitytype in ('TT_WATER_CONNECTION' , 'NEW_WS_CONNECTION' )\r\n"
			+ "				and application.createdtime  >= ? \r\n"
			+ "				AND application.createdtime <=  ? ) vvv\r\n"
			+ "				where   vvv.days  >= 15 ) vvvv";

	private static final String WATER_SEARCH_QUERY_NIUA2 = "((SELECT  distinct\r\n"
			+ "			'WATER.METERED' as name,\r\n" + "			count(wc.connectiontype) as value\r\n"
			+ "			FROM eg_ws_connection conn\r\n"
			+ "			INNER JOIN eg_ws_service wc ON wc.connection_id = conn.id\r\n"
			+ "			INNER JOIN eg_ws_application application ON application.wsid = conn.id\r\n"
			+ "			where application.applicationno in (select sss.businessid from (select  ewpv.businessid   from eg_wf_processinstance_v2 ewpv where \r\n"
			+ "	ewpv.businessservice in ( 'REGULARWSCONNECTION' , 'TT_WATER_WORKFLOW')\r\n"
			+ "	and  ewpv.action in ('ACTIVATE_REGULAR_CONNECTION' , 'CLOSED_CONNECTION_FROM_SUPERINTENDENT')\r\n"
			+ "	and ewpv.createdtime >= ? \r\n" + "	AND ewpv.createdtime <=  ?  )sss)\r\n"
			+ "	group by wc.connectiontype)\r\n" + "	\r\n" + "	union\r\n" + "	\r\n"
			+ "		(select  'SEWERAGE' usagecategory , count(applicationno) as cccc  \r\n"
			+ "			from eg_sw_connection py \r\n"
			+ "			left JOIN  eg_sw_service sc ON sc.connection_id = py.id\r\n"
			+ "			where py.applicationno in\r\n"
			+ "	(select  businessid from eg_wf_processinstance_v2 ewpv where \r\n"
			+ "	businessservice = 'SW_SEWERAGE'\r\n" + "	and  ewpv.action ='ACTIVATE_SEWERAGE_CONNECTION'\r\n"
			+ "	and ewpv.createdtime >= ? \r\n" + "	AND ewpv.createdtime <=  ? )))";

	private static final String WATER_SEARCH_QUERY_NIUA4 = "( select paymentmode as name , SUM(totaldue) as value  from \r\n"
			+ "egcl_payment py   \r\n" + "INNER JOIN egcl_paymentdetail pyd ON pyd.paymentid = py.id  \r\n"
			+ "INNER JOIN egcl_bill bill ON bill.id = pyd.billid  \r\n" + "where bill.consumercode in\r\n"
			+ "(select bill.consumercode   from \r\n" + "egcl_payment py   \r\n"
			+ "INNER JOIN egcl_paymentdetail pyd ON pyd.paymentid = py.id  \r\n"
			+ "INNER JOIN egcl_bill bill ON bill.id = pyd.billid   \r\n"
			+ "where py.createdtime  >=    ? AND py.createdtime  <=  ?  \r\n"
			+ "and bill.consumercode  like 'SW_AP/%' and py.totaldue != '0'\r\n" + "\r\n" + "union \r\n" + "\r\n"
			+ "select bill.consumercode   from \r\n" + "egcl_payment py   \r\n"
			+ "INNER JOIN egcl_paymentdetail pyd ON pyd.paymentid = py.id  \r\n"
			+ "INNER JOIN egcl_bill bill ON bill.id = pyd.billid   \r\n"
			+ "where py.createdtime  >=    ? AND py.createdtime  <= ? \r\n"
			+ "and bill.consumercode  like 'WS_AP/%' and py.totaldue != '0') and py.totaldue != '0' and paymentmode = 'CASH' \r\n"
			+ " group by    paymentmode)\r\n" + " \r\n" + " union \r\n" + " \r\n" + " ( select  \r\n"
			+ "--     consumer_code as cc , \r\n"
			+ "     gateway as cc, sum(txn_amount)  as gw from eg_pg_transactions ept\r\n"
			+ "where ept.consumer_code  in\r\n" + "(select bill.consumercode   from \r\n" + "egcl_payment py   \r\n"
			+ "INNER JOIN egcl_paymentdetail pyd ON pyd.paymentid = py.id  \r\n"
			+ "INNER JOIN egcl_bill bill ON bill.id = pyd.billid   \r\n"
			+ "where py.createdtime  >=    ? AND py.createdtime  <=  ?  \r\n"
			+ "and bill.consumercode  like 'SW_AP/%' and py.totaldue != '0'\r\n" + "\r\n" + "union \r\n" + "\r\n"
			+ "select bill.consumercode   from \r\n" + "egcl_payment py   \r\n"
			+ "INNER JOIN egcl_paymentdetail pyd ON pyd.paymentid = py.id  \r\n"
			+ "INNER JOIN egcl_bill bill ON bill.id = pyd.billid   \r\n"
			+ "where py.createdtime  >=    ? AND py.createdtime  <= ?  \r\n"
			+ "and bill.consumercode  like 'WS_AP/%' and py.totaldue != '0')and txn_status = 'SUCCESS'\r\n"
			+ " group by     gateway )";

	private static final String WATER_SEARCH_QUERY_NIUA5 = "select \r\n" + "  left(\r\n" + "      ffff.namee, \r\n"
			+ "      case \r\n" + "        when strpos( ffff.namee, '.') = 0 then strpos( ffff.namee, '.') \r\n"
			+ "        else strpos( ffff.namee, '.') -1 \r\n" + "      end\r\n"
			+ "  ) as name , sum(ffff.value) as value from (	SELECT  distinct\r\n"
			+ "			    sum(taxamount) as value,\r\n" + "			    pt.usagecategory as namee \r\n"
			+ "			    FROM eg_ws_connection conn  \r\n"
			+ "			      LEFT OUTER JOIN egcl_bill bl  on  conn.applicationno = bl.consumercode\r\n"
			+ "			            LEFT OUTER JOIN egbs_demand_v1 edv on edv.consumercode =  bl.consumercode\r\n"
			+ "			      LEFT OUTER JOIN egbs_demanddetail_v1 edvv on edvv.demandid = edv.id \r\n"
			+ "			      LEFT  OUTER JOIN EG_PT_PROPERTY pt ON pt.id  = conn.property_id\r\n"
			+ "			where bl.consumercode in\r\n" + "			(select bill.consumercode   from \r\n"
			+ "			egcl_payment py   \r\n"
			+ "			INNER JOIN egcl_paymentdetail pyd ON pyd.paymentid = py.id  \r\n"
			+ "			INNER JOIN egcl_bill bill ON bill.id = pyd.billid   \r\n"
			+ "			where py.createdtime  >=   ?  AND py.createdtime  <= ? \r\n"
			+ "			and bill.consumercode  like 'SW_AP/%' and py.totaldue != '0'\r\n" + "			\r\n"
			+ "			union \r\n" + "			\r\n" + "			select bill.consumercode   from \r\n"
			+ "			egcl_payment py   \r\n"
			+ "			INNER JOIN egcl_paymentdetail pyd ON pyd.paymentid = py.id  \r\n"
			+ "			INNER JOIN egcl_bill bill ON bill.id = pyd.billid   \r\n"
			+ "			where py.createdtime  >=   ? AND py.createdtime  <=  ? \r\n"
			+ "			and bill.consumercode  like 'WS_AP/%' and py.totaldue != '0')\r\n"
			+ "			 group by   pt.usagecategory )ffff  group by name";

	private static final String WATER_SEARCH_QUERY_NIUA6 = "SELECT  distinct\r\n" + "    sum(taxamount) as value ,\r\n"
			+ "    edvv.taxheadcode  as name\r\n" + "    FROM eg_ws_connection conn  \r\n"
			+ "      LEFT OUTER JOIN egcl_bill bl  on  conn.applicationno = bl.consumercode\r\n"
			+ "            LEFT OUTER JOIN egbs_demand_v1 edv on edv.consumercode =  bl.consumercode\r\n"
			+ "      LEFT OUTER JOIN egbs_demanddetail_v1 edvv on edvv.demandid = edv.id \r\n"
			+ "      LEFT  OUTER JOIN EG_PT_PROPERTY pt ON pt.id  = conn.property_id\r\n"
			+ "where bl.consumercode in\r\n" + "(select bill.consumercode   from \r\n" + "egcl_payment py   \r\n"
			+ "INNER JOIN egcl_paymentdetail pyd ON pyd.paymentid = py.id  \r\n"
			+ "INNER JOIN egcl_bill bill ON bill.id = pyd.billid   \r\n"
			+ "where py.createdtime  >=    ? AND py.createdtime  <=  ?  \r\n"
			+ "and bill.consumercode  like 'SW_AP/%' and py.totaldue != '0'\r\n" + "\r\n" + "union \r\n" + "\r\n"
			+ "select bill.consumercode   from \r\n" + "egcl_payment py   \r\n"
			+ "INNER JOIN egcl_paymentdetail pyd ON pyd.paymentid = py.id  \r\n"
			+ "INNER JOIN egcl_bill bill ON bill.id = pyd.billid   \r\n"
			+ "where py.createdtime  >=    ? AND py.createdtime  <=  ?  \r\n"
			+ "and bill.consumercode  like 'WS_AP/%' and py.totaldue != '0')\r\n" + " group by   edvv.taxheadcode";

	private static final String WATER_SEARCH_QUERY_NIUA7 = "(SELECT  distinct\r\n" + "   sc.connectiontype as name,\r\n"
			+ "      SUM(py.totaldue) as value \r\n" + "    FROM eg_ws_connection conn  \r\n"
			+ "      LEFT OUTER JOIN egcl_bill bl  on  conn.applicationno = bl.consumercode\r\n"
			+ "--      LEFT OUTER JOIN egcl_bill bl  on  conn.applicationno = bl.consumercode\r\n"
			+ "      LEFT OUTER JOIN egcl_paymentdetail pyd on pyd.billid = bl.id\r\n"
			+ "      LEFT OUTER JOIN egcl_payment py on py.id= pyd.paymentid\r\n"
			+ "            LEFT OUTER JOIN egbs_demand_v1 edv on edv.consumercode =  bl.consumercode\r\n"
			+ "      LEFT OUTER JOIN egbs_demanddetail_v1 edvv on edvv.demandid = edv.id \r\n"
			+ "      LEFT  OUTER JOIN EG_PT_PROPERTY pt ON pt.id  = conn.property_id\r\n"
			+ "      INNER JOIN  eg_sw_service sc ON sc.connection_id = conn.id \r\n"
			+ "      INNER JOIN eg_ws_application application ON application.wsid = conn.id\r\n"
			+ "where bl.consumercode in\r\n" + "(select bill.consumercode   from \r\n" + "egcl_payment py   \r\n"
			+ "INNER JOIN egcl_paymentdetail pyd ON pyd.paymentid = py.id  \r\n"
			+ "INNER JOIN egcl_bill bill ON bill.id = pyd.billid   \r\n"
			+ "where py.createdtime  >=    ? AND py.createdtime  <=  ?  \r\n"
			+ "and bill.consumercode  like 'SW_AP/%' and py.totaldue != '0') group by   sc.connectiontype)\r\n" + "\r\n"
			+ "union \r\n" + "\r\n" + "(SELECT  distinct\r\n" + " wc.connectiontype,\r\n"
			+ "      SUM(py.totaldue) \r\n" + "      FROM eg_ws_connection conn\r\n"
			+ "      LEFT OUTER JOIN egcl_bill bl  on  conn.applicationno = bl.consumercode\r\n"
			+ "      LEFT OUTER JOIN egcl_paymentdetail pyd on pyd.billid = bl.id\r\n"
			+ "      LEFT OUTER JOIN egcl_payment py on py.id= pyd.paymentid\r\n"
			+ "      INNER JOIN eg_ws_service wc ON wc.connection_id = conn.id\r\n"
			+ "--      INNER JOIN eg_ws_application application ON application.wsid = conn.id\r\n"
			+ "      where bl.consumercode in\r\n" + "(select bill.consumercode   from \r\n" + "egcl_payment py   \r\n"
			+ "INNER JOIN egcl_paymentdetail pyd ON pyd.paymentid = py.id  \r\n"
			+ "INNER JOIN egcl_bill bill ON bill.id = pyd.billid   \r\n"
			+ "where py.createdtime  >=    ? AND py.createdtime  <=  ?  \r\n"
			+ "and bill.consumercode  like 'WS_AP/%' and py.totaldue != '0') group by   wc.connectiontype)";

	private static final String WATER_SEARCH_QUERY_NIUA8 = "select  'ONLINE' as name ,sum(sss.cccc) as value  from\r\n"
			+ "		(select  'SEWERAGE' usagecategory , count(applicationno) as cccc  \r\n"
			+ "			from eg_sw_connection py \r\n"
			+ "			left JOIN  eg_sw_service sc ON sc.connection_id = py.id\r\n"
			+ "			where py.applicationno in\r\n"
			+ "	(select  businessid from eg_wf_processinstance_v2 ewpv where \r\n"
			+ "	businessservice = 'SW_SEWERAGE'\r\n" + "	and  ewpv.action ='ACTIVATE_SEWERAGE_CONNECTION'\r\n"
			+ "	and ewpv.createdtime >= ? \r\n" + "	AND ewpv.createdtime <=  ? ))sss";

	private static final String WATER_SEARCH_QUERY_NIUA9 = " select \r\n" + "  left(\r\n" + "      ffff.namee, \r\n"
			+ "      case \r\n" + "        when strpos( ffff.namee, '.') = 0 then strpos( ffff.namee, '.') \r\n"
			+ "        else strpos( ffff.namee, '.') -1 \r\n" + "      end\r\n"
			+ "  ) as name , sum(ffff.value) as value\r\n"
			+ "from(select count(pt.usagecategory) as value , pt.usagecategory as namee\r\n"
			+ "						from eg_sw_connection py\r\n"
			+ "						 LEFT  OUTER JOIN EG_PT_PROPERTY pt ON pt.id  = py.property_id\r\n"
			+ "						 where py.applicationno in (select  businessid from eg_wf_processinstance_v2 ewpv where \r\n"
			+ "				businessservice = 'SW_SEWERAGE'\r\n"
			+ "				and  ewpv.action ='ACTIVATE_SEWERAGE_CONNECTION'\r\n"
			+ "				and ewpv.createdtime >= ?  \r\n"
			+ "				AND ewpv.createdtime <=  ? )group by	pt.usagecategory)ffff  group  by name";

	private static final String WATER_SEARCH_QUERY_NIUA10 = "select  count(businessid) as value , 'ONLINE' as name   from eg_wf_processinstance_v2 ewpv where \r\n"
			+ "	ewpv.businessservice in ( 'REGULARWSCONNECTION' , 'TT_WATER_WORKFLOW')\r\n"
			+ "	and  ewpv.action in ('ACTIVATE_REGULAR_CONNECTION' , 'CLOSED_CONNECTION_FROM_SUPERINTENDENT')\r\n"
			+ "	and ewpv.createdtime >= ? \r\n" + "	AND ewpv.createdtime <=  ? ";

	private static final String WATER_SEARCH_QUERY_NIUA11 = "select \r\n" + "  left(\r\n" + "      ffff.namee, \r\n"
			+ "      case \r\n" + "        when strpos( ffff.namee, '.') = 0 then strpos( ffff.namee, '.') \r\n"
			+ "        else strpos( ffff.namee, '.') -1 \r\n" + "      end\r\n"
			+ "  ) as name , sum(ffff.value) as value\r\n" + "from (SELECT  distinct\r\n"
			+ "					   count(pt.usagecategory) as value ,\r\n"
			+ "					   pt.usagecategory as namee \r\n"
			+ "					   FROM eg_ws_connection py \r\n"
			+ "					   LEFT  OUTER JOIN EG_PT_PROPERTY pt ON pt.id  = py.property_id\r\n"
			+ "					   where py.applicationno in (select  businessid \r\n"
			+ "					   from eg_wf_processinstance_v2 ewpv where \r\n"
			+ "			ewpv.businessservice in ( 'REGULARWSCONNECTION' , 'TT_WATER_WORKFLOW')\r\n"
			+ "			and  ewpv.action in ('ACTIVATE_REGULAR_CONNECTION' , 'CLOSED_CONNECTION_FROM_SUPERINTENDENT')\r\n"
			+ "			and ewpv.createdtime >= ? \r\n" + "			AND ewpv.createdtime <= ? )\r\n"
			+ "			group by	pt.usagecategory)ffff group  by name";

	private static final String WATER_SEARCH_QUERY_NIUA12 = "  SELECT  distinct\r\n"
			+ "			'WATER.METERED' as name,\r\n" + "			count(wc.connectiontype) as value\r\n"
			+ "			FROM eg_ws_connection conn\r\n"
			+ "			INNER JOIN eg_ws_service wc ON wc.connection_id = conn.id\r\n"
			+ "			INNER JOIN eg_ws_application application ON application.wsid = conn.id\r\n"
			+ "			where application.applicationno in (select sss.businessid from (select  ewpv.businessid   from eg_wf_processinstance_v2 ewpv where \r\n"
			+ "	ewpv.businessservice in ( 'REGULARWSCONNECTION' , 'TT_WATER_WORKFLOW')\r\n"
			+ "	and  ewpv.action in ('ACTIVATE_REGULAR_CONNECTION' , 'CLOSED_CONNECTION_FROM_SUPERINTENDENT')\r\n"
			+ "	and ewpv.createdtime >= ? \r\n" + "	AND ewpv.createdtime <=  ? )sss)";

	private static final String WATER_SEARCH_QUERY_NIUA13 = "select  'SEWERAGE' as name , count(sss.businessid) as value from\r\n"
			+ "	\r\n" + "	((select distinct  ewpv.businessid   from eg_wf_processinstance_v2 ewpv where \r\n"
			+ "	ewpv.businessservice in ( 'REGULARWSCONNECTION' , 'TT_WATER_WORKFLOW')\r\n"
			+ "	and  ewpv.action not in ('ACTIVATE_REGULAR_CONNECTION' , 'CLOSED_CONNECTION_FROM_SUPERINTENDENT')\r\n"
			+ "	and ewpv.createdtime >= ? \r\n" + "	AND ewpv.createdtime <=  ? )\r\n" + "	union\r\n"
			+ "	(select distinct  businessid from eg_wf_processinstance_v2 ewpv where \r\n"
			+ "	businessservice = 'SW_SEWERAGE'\r\n"
			+ "	and  ewpv.action not in ( 'ACTIVATE_SEWERAGE_CONNECTION')\r\n" + "	and ewpv.createdtime >= ? \r\n"
			+ "	AND ewpv.createdtime <=  ? )) sss";

	private static final String WATER_SEARCH_QUERY_NIUA14 = "select 'todaysTotalApplicationscount' as name ,"
			+ " count(sss.dd) as value from (select application.applicationno as dd from \r\n"
			+ "      eg_ws_connection conn  \r\n" + "INNER JOIN eg_ws_service wc ON wc.connection_id = conn.id \r\n"
			+ "INNER JOIN eg_pt_address pta ON conn.property_id = pta.propertyid \r\n"
			+ "INNER JOIN eg_ws_application application ON application.wsid = conn.id \r\n"
			+ "where application.createdtime >= ? \r\n" + "and application.createdtime <= ? \r\n" + "union \r\n"
			+ "select distinct py.applicationno as dd \r\n" + "from eg_sw_connection py \r\n"
			+ "left JOIN  eg_sw_service sc ON sc.connection_id = py.id\r\n"
			+ "where py.createdtime   >= ? and py.createdtime <= ? ) sss";

	private static final String WATER_SEARCH_QUERY_NIUA15 = "select 'todaysClosedApplications' as name ,"
			+ " count(businessid) as value from eg_wf_processinstance_v2 ewpv where  action in ('UPDATE_METER_INFORMATION',\r\n"
			+ "'CONVERT_INTO_REGULAR_CONNECTION',\r\n" + "'ACTIVATE_TUBEWELL_CONNECTION',\r\n"
			+ "'ACTIVATE_TEMPORARY_CONNECTION',\r\n" + "'REACTIVATE_CONNECTION',\r\n"
			+ "'EXTEND_TEMPORARY_CONNECTION',\r\n" + "'CHANGE_CONNECTION_HOLDER',\r\n" + "'CLOSE_CONNECTION',\r\n"
			+ "'TEMPORARY_CLOSE_CONNECTION',\r\n" + "'METER_TESTING_STARTED',\r\n" + "'CHANGE_TARIFF',\r\n"
			+ "'CHANGE_ACCOUNT_NUMBER',\r\n" + "'ACTIVATE_REGULAR_CONNECTION',\r\n"
			+ "'ACTIVATE_TEMPORARY_CONNECTION',\r\n" + "'CLOSED_CONNECTION_FROM_SUPERINTENDENT',\r\n"
			+ "'ACTIVATE_SEWERAGE_CONNECTION')\r\n" + "and\r\n" + "createdtime  >= ? and createdtime <= ? ";

	/*
	 * private static final String WATER_GET_API =
	 * " select wc.connectionType,conn.tenantid,\r\n" +
	 * "wc.connection_id as connection_Id,application.applicationno as app_applicationno,conn.applicationStatus ,conn.status,\r\n"
	 * + "		conn.connectionNo,\r\n" +
	 * "		wc.proposedPipeSize, wc.waterSource,\r\n" +
	 * "		conn.waterApplicationType,\r\n" + "		conn.inworkflow,\r\n" +
	 * "		application.activitytype as app_activitytype,\r\n" +
	 * "		conn.property_id,\r\n" + "		conn.applicationType,\r\n" +
	 * "		conn.id as conn_id,\r\n" + "		conn.subdiv,\r\n" +
	 * "		application.id as application_id,\r\n" +
	 * "		application.applicationstatus as app_applicationstatus,\r\n" +
	 * "		application.action as app_action,\r\n" +
	 * "		application.comments as app_comments,\r\n" +
	 * "		property.id as waterpropertyid,\r\n" +
	 * "	    property.usagecategory,\r\n" +
	 * "		property.usagesubcategory,\r\n" +
	 * "		pta.doorno as propertyplotno,\r\n" +
	 * "		property.plotareatt as ploatAreaTT,\r\n" +
	 * "		pta.locality as propertysectorno,\r\n" +
	 * "		application.createdBy as app_createdBy,\r\n" +
	 * "			application.lastModifiedBy as app_lastModifiedBy,\r\n" +
	 * "			application.createdTime as app_createdTime,\r\n" +
	 * "			application.lastModifiedTime as app_lastModifiedTime,\r\n" +
	 * "			userid,\r\n" + "		connectionholder.ws_application_id,\r\n"
	 * + "		holdershippercentage,\r\n" + "		isprimaryholder,\r\n" +
	 * "		connectionholder.relationship as holderrelationship,\r\n" +
	 * "		connectionholder.status as holderstatus,\r\n" +
	 * "		connectionholdertype,\r\n" +
	 * "		connectionholder.tenantid as holdertenantid,\r\n" +
	 * "		connectionholder.name as holdername,\r\n" +
	 * "		connectionholder.correspondance_address as holdercorrepondanceaddress,\r\n"
	 * +
	 * "		connectionholder.proposed_correspondance_address as proposedCorrespondanceAddress ,\r\n"
	 * + "		connectionholder.proposed_gender as proposedGender ,\r\n" +
	 * "		connectionholder.proposed_guardian_name as proposedGuardianName ,\r\n"
	 * + "		connectionholder.proposed_mobile_no as proposedMobileNo ,\r\n" +
	 * "		connectionholder.proposed_name as proposedName,\r\n" +
	 * "		connectionholder.lastmodifiedtime as holderlastmodifiedtime\r\n" +
	 * "		from\r\n" + "			eg_ws_connection conn\r\n" +
	 * "		inner join eg_ws_service wc on\r\n" +
	 * "			wc.connection_id = conn.id\r\n" +
	 * "		inner join eg_pt_address pta on\r\n" +
	 * "			conn.property_id = pta.propertyid\r\n" +
	 * "		inner join eg_ws_application application on\r\n" +
	 * "			application.wsid = conn.id\r\n" +
	 * "		inner join eg_ws_property property on\r\n" +
	 * "			property.wsid = conn.id\r\n" +
	 * "		left outer join eg_ws_connectionholder connectionholder on\r\n" +
	 * "			connectionholder.connectionid = conn.id";
	 */

	/*
	 * private static final String WATER_GET_API = " select distinct " +
	 * "wc.connectionType," + "conn.tenantid,\r\n" +
	 * "wc.connection_id as connection_Id," +
	 * "application.applicationno as app_applicationno," +
	 * "conn.applicationStatus ," + "conn.status,\r\n" + "conn.connectionNo,\r\n" +
	 * "	wc.proposedPipeSize, wc.waterSource,\r\n" +
	 * "	conn.waterApplicationType,\r\n" + "	conn.inworkflow,\r\n" +
	 * "	application.activitytype as app_activitytype,\r\n" +
	 * "	conn.property_id,\r\n" + "	conn.applicationType,\r\n" +
	 * "	conn.id as conn_id,\r\n" + "	conn.div,\r\n" + "	conn.subdiv,\r\n" +
	 * " application.id as application_id,\r\n" +
	 * "	application.applicationstatus as app_applicationstatus,\r\n" +
	 * "	application.action as app_action,\r\n" +
	 * "	application.comments as app_comments,\r\n" +
	 * "	property.id as waterpropertyid,\r\n" + "	property.usagecategory,\r\n"
	 * + "	property.usagesubcategory,\r\n" + "	pta.doorno as propertyplotno,\r\n" +
	 * "	property.plotareatt as ploatAreaTT,\r\n" +
	 * "	pta.locality as propertysectorno,\r\n" +
	 * "	application.createdBy as app_createdBy,\r\n" +
	 * "	application.lastModifiedBy as app_lastModifiedBy,\r\n" +
	 * "	application.createdTime as app_createdTime,\r\n" +
	 * "	application.lastModifiedTime as app_lastModifiedTime,\r\n" +
	 * "	userid,\r\n" + "	connectionholder.ws_application_id,\r\n" +
	 * "	holdershippercentage,\r\n" + "	isprimaryholder,\r\n" +
	 * "	connectionholder.relationship as holderrelationship,\r\n" +
	 * "	connectionholder.status as holderstatus,\r\n" +
	 * "	connectionholdertype,\r\n" +
	 * "	connectionholder.tenantid as holdertenantid,\r\n" +
	 * "	connectionholder.name as holdername,\r\n" + "	'WATER' as service,\r\n"
	 * + "	application.total_amount_paid as paidamount,\r\n" +
	 * "	connectionholder.correspondance_address as holdercorrepondanceaddress\r\n"
	 * 
	 * +
	 * "	connectionholder.proposed_correspondance_address as proposedCorrespondanceAddress ,\r\n"
	 * 
	 * + "	connectionholder.proposed_gender as proposedGender ,\r\n"
	 * 
	 * + "	connectionholder.proposed_guardian_name as proposedGuardianName ,\r\n"
	 * 
	 * + "	connectionholder.proposed_mobile_no as proposedMobileNo ,\r\n" +
	 * "	connectionholder.proposed_name as proposedName,\r\n" +
	 * "	connectionholder.lastmodifiedtime as holderlastmodifiedtime\r\n" +
	 * "	from\r\n" + "	eg_ws_connection conn\r\n" +
	 * "	inner join eg_ws_service wc on\r\n" + "	wc.connection_id = conn.id\r\n"
	 * + "	inner join eg_pt_address pta on\r\n" +
	 * "	conn.property_id = pta.propertyid\r\n" +
	 * "	inner join eg_ws_application application on\r\n" +
	 * "	application.wsid = conn.id\r\n" +
	 * "	inner join eg_ws_property property on\r\n" +
	 * "	property.wsid = conn.id\r\n" +
	 * "	left outer join eg_ws_connectionholder connectionholder on\r\n" +
	 * "	connectionholder.connectionid = conn.id";
	 */

	private static final String WATER_GET_API = " select wc.connectionType,conn.tenantid,\r\n"
			+ "wc.connection_id as connection_Id,application.applicationno as app_applicationno,"
			/* + "conn.applicationStatus ," */
			+ "conn.status,\r\n" 
			+ "		conn.connectionNo,\r\n"
			/* + "	wc.proposedPipeSize," */
			/* + " wc.waterSource,\r\n" */
			/* + "		conn.waterApplicationType,\r\n" */
			/* + "		conn.inworkflow,\r\n" */
			+ "		application.activitytype as app_activitytype,\r\n" + "		conn.property_id,\r\n"
			/* + "		conn.applicationType,\r\n" */
			+ "		conn.id as conn_id,\r\n" + "	   conn.div,\r\n" + "		conn.subdiv,\r\n"
			+ "		application.id as application_id,\r\n"
			+ "		application.applicationstatus as app_applicationstatus,\r\n"
			/* + "		application.action as app_action,\r\n" */
			/* + "		application.comments as app_comments,\r\n" */
			+ "		property.id as waterpropertyid,\r\n"
			/* + "	    property.usagecategory,\r\n" */
			/* + "		property.usagesubcategory,\r\n" */
			+ "		pta.doorno as propertyplotno,\r\n"
			/* + "		property.plotareatt as ploatAreaTT,\r\n" */
			+ "		pta.locality as propertysectorno,\r\n" + "		application.createdBy as app_createdBy,\r\n"
			+ "			application.lastModifiedBy as app_lastModifiedBy,\r\n"
			+ "			application.createdTime as app_createdTime,\r\n"
			+ "			application.lastModifiedTime as app_lastModifiedTime,\r\n" + "			userid,\r\n"
			+ "		connectionholder.ws_application_id,\r\n" + "		holdershippercentage,\r\n"
			+ "		isprimaryholder,\r\n"
			/* + "		connectionholder.relationship as holderrelationship,\r\n" */
			/* + "		connectionholder.status as holderstatus,\r\n" */
			/* + "		connectionholdertype,\r\n" */
			/* + "		connectionholder.tenantid as holdertenantid,\r\n" */
			/* + "		connectionholder.name as holdername,\r\n" */
			+ "	'WATER' as service,\r\n" + "	application.total_amount_paid as paidamount,\r\n"
			+ "	connectionholder.correspondance_address as holdercorrepondanceaddress\r\n"
			/*
			 * +
			 * "		connectionholder.proposed_correspondance_address as proposedCorrespondanceAddress ,\r\n"
			 */
			/* + "		connectionholder.proposed_gender as proposedGender ,\r\n" */
			/*
			 * +
			 * "		connectionholder.proposed_guardian_name as proposedGuardianName ,\r\n"
			 */
			/* + "		connectionholder.proposed_mobile_no as proposedMobileNo ,\r\n" */
			/* + "		connectionholder.proposed_name as proposedName,\r\n" */
			/* + "		connectionholder.lastmodifiedtime as holderlastmodifiedtime\r\n" */
			+ "		from\r\n" + "			eg_ws_connection conn\r\n" + "		inner join eg_ws_service wc on\r\n"
			+ "			wc.connection_id = conn.id\r\n" + "		inner join eg_pt_address pta on\r\n"
			+ "			conn.property_id = pta.propertyid\r\n" + "		inner join eg_ws_application application on\r\n"
			+ "			application.wsid = conn.id\r\n" + "		inner join eg_ws_property property on\r\n"
			+ "			property.wsid = conn.id\r\n"
			+ "		left outer join eg_ws_connectionholder connectionholder on\r\n"
			+ "			connectionholder.connectionid = conn.id";

	private static final String WATER_SEARCH_QUERY_NIUA16 = "select SUM(case when ewa.applicationstatus in ('CONNECTION_ACTIVATED','METER_UPDATED',\r\n"
			+ "			'CONNECTION_TYPE_CHANGED','TUBEWELL_CONNECTION_ACTIVATED','CONNECTION_REACTIVATED','CONNECTION_EXTENDED',\r\n"
			+ "			'CONNECTION_UPDATED','CONNECTION_CLOSED','TEMPORARY_CONNECTION_CLOSED','METER_TESTED',\r\n"
			+ "			'CONNECTION_TARIFF_CHANGED','CONNECTION_ACCOUNT_NUMBER_CHANGED','CLOSED_CONNECTION') then 1 else 0 end) from eg_ws_application ewa";

	private static final String WATER_SEARCH_QUERY_NIUA17 = " select SUM(case when ewa.applicationstatus in ('CONNECTION_ACTIVATED','METER_UPDATED',\r\n"
			+ "			'CONNECTION_TYPE_CHANGED','TUBEWELL_CONNECTION_ACTIVATED','CONNECTION_REACTIVATED','CONNECTION_EXTENDED',\r\n"
			+ "			'CONNECTION_UPDATED','CONNECTION_CLOSED','TEMPORARY_CONNECTION_CLOSED','METER_TESTED',\r\n"
			+ "			'CONNECTION_TARIFF_CHANGED','CONNECTION_ACCOUNT_NUMBER_CHANGED','CLOSED_CONNECTION') then to_timestamp(ewa.lastmodifiedtime / 1000)::date - to_timestamp(ewa.createdtime / 1000)::date else 0 end) approveddays\r\n"
			+ "			 from eg_ws_application ewa";

	private static final String WATER_SEARCH_QUERY_NIUA18 = " select SUM(case when ewa.applicationstatus in ('SEWERAGE_CONNECTION_ACTIVATED') then 1 else 0 end) from eg_sw_connection ewa";

	private static final String WATER_SEARCH_QUERY_NIUA19 = " select SUM(case when ewa.applicationstatus in ('SEWERAGE_CONNECTION_ACTIVATED') then to_timestamp(ewa.lastmodifiedtime / 1000)::date - to_timestamp(ewa.createdtime / 1000)::date else 0 end) approveddays from eg_sw_connection ewa";

	private static final String PUBLIC_DASHBOARD_WATER_SEARCH = "select count(*) from eg_ws_application ewa ";
	
	private static final String PUBLIC_DASHBOARD_WATER_TOTAL_COLLECTION = "select sum(ept.txn_amount) from eg_ws_application ewa inner join eg_pg_transactions ept on ewa.applicationno = ept.consumer_code ";
	
	private static final String PUBLIC_DASHBOARD_WATER_FILESTORE = "select filestoreid from eg_ws_publicdashboardfilestore where createdtime is not null order by createdtime desc limit 1 ";
	
	private static final String PUBLIC_DASHBOARD_WATER_FILESTORE_CREATED_TIME = "select createdtime from eg_ws_publicdashboardfilestore where createdtime is not null order by createdtime desc limit 1 ";

	private static final String PUBLIC_DASHBOARD_WATER_SEARCH_APPROVED = "select SUM(case when ewa.applicationstatus in ('CONNECTION_ACTIVATED','METER_UPDATED',"
			+ "'CONNECTION_TYPE_CHANGED','TUBEWELL_CONNECTION_ACTIVATED','CONNECTION_REACTIVATED','CONNECTION_EXTENDED',"
			+ "'CONNECTION_UPDATED','CONNECTION_CLOSED','TEMPORARY_CONNECTION_CLOSED','METER_TESTED',"
			+ "'CONNECTION_TARIFF_CHANGED','CONNECTION_ACCOUNT_NUMBER_CHANGED','CLOSED_CONNECTION') then 1 else 0 end) from eg_ws_application ewa ";

	private static final String PUBLIC_DASHBOARD_WATER_SEARCH_TIME_TAKEN_APPROVED = "select SUM(case when ewa.applicationstatus in ('CONNECTION_ACTIVATED','METER_UPDATED',"
			+ "	'CONNECTION_TYPE_CHANGED','TUBEWELL_CONNECTION_ACTIVATED','CONNECTION_REACTIVATED','CONNECTION_EXTENDED',"
			+ "	'CONNECTION_UPDATED','CONNECTION_CLOSED','TEMPORARY_CONNECTION_CLOSED','METER_TESTED',"
			+ "	'CONNECTION_TARIFF_CHANGED','CONNECTION_ACCOUNT_NUMBER_CHANGED','CLOSED_CONNECTION') then to_timestamp(ewa.lastmodifiedtime / 1000)::date - to_timestamp(ewa.createdtime / 1000)::date else 0 end) approveddays\r\n"
			+ " from eg_ws_application ewa ";

	public static final String MOBILE_NUMBER_EXCEPTION_CODE = "MOBILE NUMBER DOES NOT EXISTS";
	
	
	public String getWaterConnectionSearchQueryString(SearchCriteria criteria, List<Object> preparedStatement,
			RequestInfo requestInfo) {
		if (criteria.isEmpty())
			return null;
		StringBuilder query = new StringBuilder();

		query = new StringBuilder(WATER_CONNECTION_SEARCH_QUERY);
		
		if (!StringUtils.isEmpty(criteria.getConnectionNumber())) {
			addClauseIfRequired(preparedStatement, query);
			query.append(" conn.connectionno = ? ");
			preparedStatement.add(criteria.getConnectionNumber());
		}
		
		query.append(ORDER_BY_CLAUSE);
		return addPaginationWrapper(query.toString(), preparedStatement, criteria);
	}

	/**
	 * 
	 * @param criteria          The WaterCriteria
	 * @param preparedStatement The Array Of Object
	 * @param requestInfo       The Request Info
	 * @return query as a string
	 */
	public String getSearchQueryString(SearchCriteria criteria, List<Object> preparedStatement,
			RequestInfo requestInfo) {
		if (criteria.isEmpty())
			return null;
		StringBuilder query = new StringBuilder();

		query = new StringBuilder(WATER_SEARCH_QUERY);
		
		boolean propertyIdsPresent = false;
		/*
		 * if (!StringUtils.isEmpty(criteria.getMobileNumber())) { Set<String>
		 * propertyIds = new HashSet<>(); List<Property> propertyList =
		 * waterServicesUtil.propertySearchOnCriteria(criteria, requestInfo);
		 * propertyList.forEach(property -> propertyIds.add(property.getId())); if
		 * (!propertyIds.isEmpty()) { addClauseIfRequired(preparedStatement, query);
		 * query.append(" (conn.property_id in (").append(createQuery(propertyIds)).
		 * append(" )"); addToPreparedStatement(preparedStatement, propertyIds);
		 * propertyIdsPresent = true; } }
		 */
		if (!StringUtils.isEmpty(criteria.getMobileNumber())) {
			if (requestInfo.getUserInfo() != null && requestInfo.getUserInfo().getRoles().contains("CITIZEN")) {
				query.append(" connectionholder.mobile_no = ? ");
				preparedStatement.add(criteria.getMobileNumber());
			} else {
				Set<String> uuids = userService.getUUIDForUsers(criteria.getMobileNumber(), criteria.getTenantId(),
						requestInfo);
				boolean userIdsPresent = false;
				if (!CollectionUtils.isEmpty(uuids)) {
					addORClauseIfRequired(preparedStatement, query);
					if (!propertyIdsPresent)
						query.append("(");
					query.append(" connectionholder.userid in (").append(createQuery(uuids)).append(" ))");
					addToPreparedStatement(preparedStatement, uuids);
					userIdsPresent = true;
				}
			}
			/*
			 * if(propertyIdsPresent && !userIdsPresent){ query.append(")"); }
			 */
		}
		if (!StringUtils.isEmpty(criteria.getTenantId())) {
			addClauseIfRequired(preparedStatement, query);
			query.append(" conn.tenantid = ? ");
			preparedStatement.add(criteria.getTenantId());
		}
//		if (!StringUtils.isEmpty(criteria.getPropertyId())) {
//			addClauseIfRequired(preparedStatement, query);
//			query.append(" conn.property_id = ? ");
//			preparedStatement.add(criteria.getPropertyId());
//		}
		if (!CollectionUtils.isEmpty(criteria.getIds())) {
			addClauseIfRequired(preparedStatement, query);
			query.append(" application.id in (").append(createQuery(criteria.getIds())).append(" )");
			addToPreparedStatement(preparedStatement, criteria.getIds());
		}
		if (!StringUtils.isEmpty(criteria.getOldConnectionNumber())) {
			addClauseIfRequired(preparedStatement, query);
			query.append(" conn.oldconnectionno = ? ");
			preparedStatement.add(criteria.getOldConnectionNumber());
		}
		if (!StringUtils.isEmpty(criteria.getPlotNo())) {
			addClauseIfRequired(preparedStatement, query);
			query.append(" pta.doorno = ? ");
			preparedStatement.add(criteria.getPlotNo());
		}
		if (!StringUtils.isEmpty(criteria.getSectorNo())) {
			addClauseIfRequired(preparedStatement, query);
			query.append(" pta.locality = ? ");
			preparedStatement.add(criteria.getSectorNo());
		}
		if (!StringUtils.isEmpty(criteria.getGroupNo())) {
			addClauseIfRequired(preparedStatement, query);
			query.append(" conn.billgroup = ? ");
			preparedStatement.add(criteria.getGroupNo());
		}
		if (!StringUtils.isEmpty(criteria.getLedgerGroup())) {
			addClauseIfRequired(preparedStatement, query);
			query.append(" conn.ledgergroup = ? ");
			preparedStatement.add(criteria.getLedgerGroup());
		}
		if (!StringUtils.isEmpty(criteria.getSubDivision())) {
			addClauseIfRequired(preparedStatement, query);
			query.append(" conn.subdiv = ? ");
			preparedStatement.add(criteria.getSubDivision());
		}
		if (!StringUtils.isEmpty(criteria.getDivision())) {
			addClauseIfRequired(preparedStatement, query);
			query.append(" conn.div = ? ");
			preparedStatement.add(criteria.getDivision());
		}

		if (!StringUtils.isEmpty(criteria.getConnectionNumber())) {
			addClauseIfRequired(preparedStatement, query);
			query.append(" conn.connectionno = ? ");
			preparedStatement.add(criteria.getConnectionNumber());
		}
		if (!StringUtils.isEmpty(criteria.getStatus())) {
			addClauseIfRequired(preparedStatement, query);
			query.append(" conn.status = ? ");
			preparedStatement.add(criteria.getStatus());
		}
		if (!StringUtils.isEmpty(criteria.getConHolderStatus())){
			addClauseIfRequired(preparedStatement, query);
			query.append(" connectionholder.status = ? ");
			preparedStatement.add(criteria.getConHolderStatus());
		}
		if (!StringUtils.isEmpty(criteria.getApplicationNumber())) {
			addClauseIfRequired(preparedStatement, query);
			query.append(" application.applicationno = ? ");
			preparedStatement.add(criteria.getApplicationNumber());
		}
		if (!StringUtils.isEmpty(criteria.getApplicationNumberSearch())) {
			addClauseIfRequired(preparedStatement, query);
			query.append(" application.applicationno ilike ? ");
			preparedStatement.add("%" + criteria.getApplicationNumberSearch());
		}
		if (!StringUtils.isEmpty(criteria.getApplicationStatus())) {
			addClauseIfRequired(preparedStatement, query);
			query.append(" application.applicationStatus = ? ");
			preparedStatement.add(criteria.getApplicationStatus());
		}
		if (criteria.getFromDate() != null) {
			addClauseIfRequired(preparedStatement, query);
			query.append("  application.createdTime >= ? ");
			preparedStatement.add(criteria.getFromDate());
		}
		if (criteria.getToDate() != null) {
			addClauseIfRequired(preparedStatement, query);
			query.append("  application.createdTime <= ? ");
			preparedStatement.add(criteria.getToDate());
		}
		if (criteria.getAppFromDate() != null) {
			addClauseIfRequired(preparedStatement, query);
			query.append("  application.lastModifiedTime >= ?  ");
			preparedStatement.add(criteria.getAppFromDate());
		}
		if (criteria.getAppToDate() != null) {
			addClauseIfRequired(preparedStatement, query);
			query.append("  application.lastModifiedTime <= ? ");
			preparedStatement.add(criteria.getAppToDate());
		}
		if (criteria.getAppFromDate() != null || criteria.getAppToDate() != null) {
			addClauseIfRequired(preparedStatement, query);
			query.append("  application.applicationStatus in (").append(createQuery(WCConstants.APPROVED_ACTIONS))
					.append(" )");
			addToPreparedStatement(preparedStatement, WCConstants.APPROVED_ACTIONS);
		}
		if (!StringUtils.isEmpty(criteria.getApplicationType())) {
			addClauseIfRequired(preparedStatement, query);
			query.append(" application.activitytype = ? ");
			preparedStatement.add(criteria.getApplicationType());
		}
		/*
		 * if (!StringUtils.isEmpty(criteria.getConnectionUserId())) {
		 * addORClauseIfRequired(preparedStatement, query);
		 * query.append(" cm.user_id = ? ");
		 * preparedStatement.add(criteria.getConnectionUserId()); }
		 */
		query.append(ORDER_BY_CLAUSE_APPNO);
		return addPaginationWrapper(query.toString(), preparedStatement, criteria);
	}
	
	/**
	 * 
	 * @param criteria          The WaterCriteria
	 * @param preparedStatement The Array Of Object
	 * @param requestInfo       The Request Info
	 * @return query as a string
	 */
	public String getSearchQueryStringCitizen(SearchCriteria criteria, List<Object> preparedStatement,
			RequestInfo requestInfo) {
		if (criteria.isEmpty())
			return null;
		StringBuilder query = new StringBuilder();

		query = new StringBuilder(WATER_SEARCH_QUERY_APPLICATION);
		
		boolean propertyIdsPresent = false;
		/*
		 * if (!StringUtils.isEmpty(criteria.getMobileNumber())) { Set<String>
		 * propertyIds = new HashSet<>(); List<Property> propertyList =
		 * waterServicesUtil.propertySearchOnCriteria(criteria, requestInfo);
		 * propertyList.forEach(property -> propertyIds.add(property.getId())); if
		 * (!propertyIds.isEmpty()) { addClauseIfRequired(preparedStatement, query);
		 * query.append(" (conn.property_id in (").append(createQuery(propertyIds)).
		 * append(" )"); addToPreparedStatement(preparedStatement, propertyIds);
		 * propertyIdsPresent = true; } }
		 */
		if (!StringUtils.isEmpty(criteria.getMobileNumber())) {
			if (requestInfo.getUserInfo() != null && requestInfo.getUserInfo().getRoles().contains("CITIZEN")) {
				query.append(" connectionholder.mobile_no = ? ");
				preparedStatement.add(criteria.getMobileNumber());
			} else {
				Set<String> uuids = userService.getUUIDForUsers(criteria.getMobileNumber(), criteria.getTenantId(),
						requestInfo);
				boolean userIdsPresent = false;
				if (!CollectionUtils.isEmpty(uuids)) {
					addORClauseIfRequired(preparedStatement, query);
					if (!propertyIdsPresent)
						query.append("(");
					query.append(" connectionholder.userid in (").append(createQuery(uuids)).append(" ))");
					addToPreparedStatement(preparedStatement, uuids);
					userIdsPresent = true;
				}
			}
			/*
			 * if(propertyIdsPresent && !userIdsPresent){ query.append(")"); }
			 */
		}
		if (!StringUtils.isEmpty(criteria.getTenantId())) {
			addClauseIfRequired(preparedStatement, query);
			query.append(" conn.tenantid = ? ");
			preparedStatement.add(criteria.getTenantId());
		}
//		if (!StringUtils.isEmpty(criteria.getPropertyId())) {
//			addClauseIfRequired(preparedStatement, query);
//			query.append(" conn.property_id = ? ");
//			preparedStatement.add(criteria.getPropertyId());
//		}
		if (!CollectionUtils.isEmpty(criteria.getIds())) {
			addClauseIfRequired(preparedStatement, query);
			query.append(" application.id in (").append(createQuery(criteria.getIds())).append(" )");
			addToPreparedStatement(preparedStatement, criteria.getIds());
		}
		if (!StringUtils.isEmpty(criteria.getOldConnectionNumber())) {
			addClauseIfRequired(preparedStatement, query);
			query.append(" conn.oldconnectionno = ? ");
			preparedStatement.add(criteria.getOldConnectionNumber());
		}
		if (!StringUtils.isEmpty(criteria.getPlotNo())) {
			addClauseIfRequired(preparedStatement, query);
			query.append(" pta.doorno = ? ");
			preparedStatement.add(criteria.getPlotNo());
		}
		if (!StringUtils.isEmpty(criteria.getSectorNo())) {
			addClauseIfRequired(preparedStatement, query);
			query.append(" pta.locality = ? ");
			preparedStatement.add(criteria.getSectorNo());
		}
		if (!StringUtils.isEmpty(criteria.getGroupNo())) {
			addClauseIfRequired(preparedStatement, query);
			query.append(" conn.billgroup = ? ");
			preparedStatement.add(criteria.getGroupNo());
		}
		if (!StringUtils.isEmpty(criteria.getLedgerGroup())) {
			addClauseIfRequired(preparedStatement, query);
			query.append(" conn.ledgergroup = ? ");
			preparedStatement.add(criteria.getLedgerGroup());
		}
		if (!StringUtils.isEmpty(criteria.getSubDivision())) {
			addClauseIfRequired(preparedStatement, query);
			query.append(" conn.subdiv = ? ");
			preparedStatement.add(criteria.getSubDivision());
		}
		if (!StringUtils.isEmpty(criteria.getDivision())) {
			addClauseIfRequired(preparedStatement, query);
			query.append(" conn.div = ? ");
			preparedStatement.add(criteria.getDivision());
		}

		if (!StringUtils.isEmpty(criteria.getConnectionNumber())) {
			addClauseIfRequired(preparedStatement, query);
			query.append(" conn.connectionno = ? ");
			preparedStatement.add(criteria.getConnectionNumber());
		}
		if (!StringUtils.isEmpty(criteria.getStatus())) {
			addClauseIfRequired(preparedStatement, query);
			query.append(" conn.status = ? ");
			preparedStatement.add(criteria.getStatus());
		}
		if (!StringUtils.isEmpty(criteria.getApplicationNumber())) {
			addClauseIfRequired(preparedStatement, query);
			query.append(" application.applicationno = ? ");
			preparedStatement.add(criteria.getApplicationNumber());
		}
		if (!StringUtils.isEmpty(criteria.getApplicationNumberSearch())) {
			addClauseIfRequired(preparedStatement, query);
			query.append(" application.applicationno ilike ? ");
			preparedStatement.add("%" + criteria.getApplicationNumberSearch());
		}
		if (!StringUtils.isEmpty(criteria.getApplicationStatus())) {
			addClauseIfRequired(preparedStatement, query);
			query.append(" application.applicationStatus = ? ");
			preparedStatement.add(criteria.getApplicationStatus());
		}
		if (criteria.getFromDate() != null) {
			addClauseIfRequired(preparedStatement, query);
			query.append("  application.createdTime >= ? ");
			preparedStatement.add(criteria.getFromDate());
		}
		if (criteria.getToDate() != null) {
			addClauseIfRequired(preparedStatement, query);
			query.append("  application.createdTime <= ? ");
			preparedStatement.add(criteria.getToDate());
		}
		if (criteria.getAppFromDate() != null) {
			addClauseIfRequired(preparedStatement, query);
			query.append("  application.lastModifiedTime >= ?  ");
			preparedStatement.add(criteria.getAppFromDate());
		}
		if (criteria.getAppToDate() != null) {
			addClauseIfRequired(preparedStatement, query);
			query.append("  application.lastModifiedTime <= ? ");
			preparedStatement.add(criteria.getAppToDate());
		}
		if (criteria.getAppFromDate() != null || criteria.getAppToDate() != null) {
			addClauseIfRequired(preparedStatement, query);
			query.append("  application.applicationStatus in (").append(createQuery(WCConstants.APPROVED_ACTIONS))
					.append(" )");
			addToPreparedStatement(preparedStatement, WCConstants.APPROVED_ACTIONS);
		}
		if (!StringUtils.isEmpty(criteria.getApplicationType())) {
			addClauseIfRequired(preparedStatement, query);
			query.append(" application.activitytype = ? ");
			preparedStatement.add(criteria.getApplicationType());
		}
		/*
		 * if (!StringUtils.isEmpty(criteria.getConnectionUserId())) {
		 * addORClauseIfRequired(preparedStatement, query);
		 * query.append(" cm.user_id = ? ");
		 * preparedStatement.add(criteria.getConnectionUserId()); }
		 */
		query.append(ORDER_BY_CLAUSE);
		return addPaginationWrapper(query.toString(), preparedStatement, criteria);
	}

	/**
	 * 
	 * @param criteria          The WaterCriteria
	 * @param preparedStatement The Array Of Object
	 * @param requestInfo       The Request Info
	 * @return query as a string
	 */
	public String getSearchQueryStringCount(SearchCriteria criteria, List<Object> preparedStatement,
			RequestInfo requestInfo) {
		if (criteria.isEmpty())
			return null;
		StringBuilder query = new StringBuilder(WATER_SEARCH_QUERY_COUNT);
		boolean propertyIdsPresent = false;

		if (!StringUtils.isEmpty(criteria.getTenantId())) {
			addClauseIfRequired(preparedStatement, query);
			query.append(" conn.tenantid = ? ");
			preparedStatement.add(criteria.getTenantId());
		}

		if (criteria.getFromDate() != null) {
			addClauseIfRequired(preparedStatement, query);
			query.append("  application.createdTime >= ? ");
			preparedStatement.add(criteria.getFromDate());
		}
		if (criteria.getToDate() != null) {
			addClauseIfRequired(preparedStatement, query);
			query.append("  application.createdTime <= ? ");
			preparedStatement.add(criteria.getToDate());
		}

		query.append(ORDER_BY_CLAUSE);
		return query.toString();
	}

	private void addClauseIfRequired(List<Object> values, StringBuilder queryString) {
		if (values.isEmpty())
			queryString.append(" WHERE ");
		else {
			queryString.append(" AND");
		}
	}

	private void addORClauseIfRequired(List<Object> values, StringBuilder queryString) {
		if (values.isEmpty())
			queryString.append(" WHERE ");
		else {
			queryString.append(" OR");
		}
	}

	private String createQuery(Set<String> ids) {
		StringBuilder builder = new StringBuilder();
		int length = ids.size();
		for (int i = 0; i < length; i++) {
			builder.append(" ?");
			if (i != length - 1)
				builder.append(",");
		}
		return builder.toString();
	}

	private void addToPreparedStatement(List<Object> preparedStatement, Set<String> ids) {
		ids.forEach(id -> {
			preparedStatement.add(id);
		});
	}

	/**
	 * 
	 * @param query            The
	 * @param preparedStmtList Array of object for preparedStatement list
	 * @return It's returns query
	 */
	private String addPaginationWrapper(String query, List<Object> preparedStmtList, SearchCriteria criteria) {
		Integer limit = config.getDefaultLimit();
		Integer offset = config.getDefaultOffset();
		if (criteria.getLimit() == null && criteria.getOffset() == null)
			limit = config.getMaxLimit();

		if (criteria.getLimit() != null && criteria.getLimit() <= config.getDefaultLimit())
			limit = criteria.getLimit();

		if (criteria.getLimit() != null && criteria.getLimit() > config.getDefaultOffset())
			limit = config.getDefaultLimit();

		if (criteria.getOffset() != null)
			offset = criteria.getOffset();

		preparedStmtList.add(offset);
		preparedStmtList.add(limit + offset);
		return PAGINATION_WRAPPER.replace("{}", query);
	}

	public String getNoOfWaterConnectionQuery(Set<String> connectionIds, List<Object> preparedStatement) {
		StringBuilder query = new StringBuilder(NO_OF_CONNECTION_SEARCH_QUERY);
		query.append(" connectionno in (").append(createQuery(connectionIds)).append(" )");
		addToPreparedStatement(preparedStatement, connectionIds);
		return query.toString();
	}

	/**
	 * 
	 * @param criteria          The WaterCriteria
	 * @param preparedStatement The Array Of Object
	 * @param requestInfo       The Request Info
	 * @return query as a string
	 */

	public String getSearchQueryStringTotalCollectionCountNIUA(String string, String groupByName,
			SearchTotalCollectionCriteria searchTotalCollectionCriteria, List<Object> preparedStatement,
			RequestInfo requestInfo) {
		preparedStatement.clear();
		StringBuilder query = null;
		if ("connectionType".equalsIgnoreCase(string) && groupByName.equalsIgnoreCase("connectionsCreated")) {
			query = new StringBuilder(WATER_SEARCH_QUERY_NIUA2);
			preparedStatement.add(searchTotalCollectionCriteria.getFromDate());
			preparedStatement.add(searchTotalCollectionCriteria.getToDate());
			preparedStatement.add(searchTotalCollectionCriteria.getFromDate());
			preparedStatement.add(searchTotalCollectionCriteria.getToDate());
		} else if ("channelType".equalsIgnoreCase(string) && groupByName.equalsIgnoreCase("connectionsCreated")) {
			query = new StringBuilder(WATER_SEARCH_QUERY_NIUA3);
			preparedStatement.add(searchTotalCollectionCriteria.getFromDate());
			preparedStatement.add(searchTotalCollectionCriteria.getToDate());
			preparedStatement.add(searchTotalCollectionCriteria.getFromDate());
			preparedStatement.add(searchTotalCollectionCriteria.getToDate());
		} else if ("paymentChannelType".equalsIgnoreCase(string) && groupByName.equalsIgnoreCase("todaysCollection")) {
			query = new StringBuilder(WATER_SEARCH_QUERY_NIUA4);
			preparedStatement.add(searchTotalCollectionCriteria.getFromDate());
			preparedStatement.add(searchTotalCollectionCriteria.getToDate());
			preparedStatement.add(searchTotalCollectionCriteria.getFromDate());
			preparedStatement.add(searchTotalCollectionCriteria.getToDate());
			preparedStatement.add(searchTotalCollectionCriteria.getFromDate());
			preparedStatement.add(searchTotalCollectionCriteria.getToDate());
			preparedStatement.add(searchTotalCollectionCriteria.getFromDate());
			preparedStatement.add(searchTotalCollectionCriteria.getToDate());
		} else if ("usageType".equalsIgnoreCase(string) && groupByName.equalsIgnoreCase("todaysCollection")) {
			query = new StringBuilder(WATER_SEARCH_QUERY_NIUA5);
			preparedStatement.add(searchTotalCollectionCriteria.getFromDate());
			preparedStatement.add(searchTotalCollectionCriteria.getToDate());
			preparedStatement.add(searchTotalCollectionCriteria.getFromDate());
			preparedStatement.add(searchTotalCollectionCriteria.getToDate());
		} else if ("taxHeads".equalsIgnoreCase(string) && groupByName.equalsIgnoreCase("todaysCollection")) {
			query = new StringBuilder(WATER_SEARCH_QUERY_NIUA6);
			preparedStatement.add(searchTotalCollectionCriteria.getFromDate());
			preparedStatement.add(searchTotalCollectionCriteria.getToDate());
			preparedStatement.add(searchTotalCollectionCriteria.getFromDate());
			preparedStatement.add(searchTotalCollectionCriteria.getToDate());
		} else if ("connectionType".equalsIgnoreCase(string) && groupByName.equalsIgnoreCase("todaysCollection")) {
			query = new StringBuilder(WATER_SEARCH_QUERY_NIUA7);
			preparedStatement.add(searchTotalCollectionCriteria.getFromDate());
			preparedStatement.add(searchTotalCollectionCriteria.getToDate());
			preparedStatement.add(searchTotalCollectionCriteria.getFromDate());
			preparedStatement.add(searchTotalCollectionCriteria.getToDate());
		} else if ("channelType".equalsIgnoreCase(string) && groupByName.equalsIgnoreCase("sewerageConnections")) {
			query = new StringBuilder(WATER_SEARCH_QUERY_NIUA8);
			preparedStatement.add(searchTotalCollectionCriteria.getFromDate());
			preparedStatement.add(searchTotalCollectionCriteria.getToDate());
		} else if ("usageType".equalsIgnoreCase(string) && groupByName.equalsIgnoreCase("sewerageConnections")) {
			query = new StringBuilder(WATER_SEARCH_QUERY_NIUA9);
			preparedStatement.add(searchTotalCollectionCriteria.getFromDate());
			preparedStatement.add(searchTotalCollectionCriteria.getToDate());
		} else if ("channelType".equalsIgnoreCase(string) && groupByName.equalsIgnoreCase("waterConnections")) {
			query = new StringBuilder(WATER_SEARCH_QUERY_NIUA10);
			preparedStatement.add(searchTotalCollectionCriteria.getFromDate());
			preparedStatement.add(searchTotalCollectionCriteria.getToDate());
		} else if ("usageType".equalsIgnoreCase(string) && groupByName.equalsIgnoreCase("waterConnections")) {
			query = new StringBuilder(WATER_SEARCH_QUERY_NIUA11);
			preparedStatement.add(searchTotalCollectionCriteria.getFromDate());
			preparedStatement.add(searchTotalCollectionCriteria.getToDate());
		} else if ("meterType".equalsIgnoreCase(string) && groupByName.equalsIgnoreCase("waterConnections")) {
			query = new StringBuilder(WATER_SEARCH_QUERY_NIUA12);
			preparedStatement.add(searchTotalCollectionCriteria.getFromDate());
			preparedStatement.add(searchTotalCollectionCriteria.getToDate());
		}

		else if ("duration".equalsIgnoreCase(string) && groupByName.equalsIgnoreCase("pendingConnections")) {
			query = new StringBuilder(WATER_SEARCH_QUERY_NIUA);
			preparedStatement.add(searchTotalCollectionCriteria.getFromDate());
			preparedStatement.add(searchTotalCollectionCriteria.getToDate());
			preparedStatement.add(searchTotalCollectionCriteria.getFromDate());
			preparedStatement.add(searchTotalCollectionCriteria.getToDate());
			preparedStatement.add(searchTotalCollectionCriteria.getFromDate());
			preparedStatement.add(searchTotalCollectionCriteria.getToDate());
			preparedStatement.add(searchTotalCollectionCriteria.getFromDate());
			preparedStatement.add(searchTotalCollectionCriteria.getToDate());
		}

		else if ("transactions".equalsIgnoreCase(string) && groupByName.equalsIgnoreCase("transactions")) {
			query = new StringBuilder(WATER_SEARCH_QUERY_NIUA13);
			preparedStatement.add(searchTotalCollectionCriteria.getFromDate());
			preparedStatement.add(searchTotalCollectionCriteria.getToDate());
			preparedStatement.add(searchTotalCollectionCriteria.getFromDate());
			preparedStatement.add(searchTotalCollectionCriteria.getToDate());
		}

		else if ("todaysTotalApplications".equalsIgnoreCase(string)
				&& groupByName.equalsIgnoreCase("todaysTotalApplications")) {
			query = new StringBuilder(WATER_SEARCH_QUERY_NIUA14);
			preparedStatement.add(searchTotalCollectionCriteria.getFromDate());
			preparedStatement.add(searchTotalCollectionCriteria.getToDate());
			preparedStatement.add(searchTotalCollectionCriteria.getFromDate());
			preparedStatement.add(searchTotalCollectionCriteria.getToDate());
		}

		else if ("todaysClosedApplications".equalsIgnoreCase(string)
				&& groupByName.equalsIgnoreCase("todaysClosedApplications")) {
			query = new StringBuilder(WATER_SEARCH_QUERY_NIUA15);
			preparedStatement.add(searchTotalCollectionCriteria.getFromDate());
			preparedStatement.add(searchTotalCollectionCriteria.getToDate());
		}

		return query.toString();

	}

	public String getWaterSearchQueryApprovedDaysNIUA(SearchTotalCollectionCriteria searchTotalCollectionCriteria,
			List<Object> preparedStatement) {
		preparedStatement.clear();
		StringBuilder query = null;
		query = new StringBuilder(WATER_SEARCH_QUERY_NIUA16);
		if (searchTotalCollectionCriteria.getFromDate() != null) {
			addClauseIfRequired(preparedStatement, query);
			query.append("  ewa.createdtime >= ?  ");
			preparedStatement.add(searchTotalCollectionCriteria.getFromDate());
		}
		if (searchTotalCollectionCriteria.getToDate() != null) {
			addClauseIfRequired(preparedStatement, query);
			query.append("  ewa.createdtime <= ? ");
			preparedStatement.add(searchTotalCollectionCriteria.getToDate());
		}

		return query.toString();

	}

	public String getWaterSearchQueryApprovedTimeTakenDaysNIUA(
			SearchTotalCollectionCriteria searchTotalCollectionCriteria, List<Object> preparedStatement) {
		preparedStatement.clear();
		StringBuilder query = null;
		query = new StringBuilder(WATER_SEARCH_QUERY_NIUA17);
		if (searchTotalCollectionCriteria.getFromDate() != null) {
			addClauseIfRequired(preparedStatement, query);
			query.append("  ewa.createdtime >= ?  ");
			preparedStatement.add(searchTotalCollectionCriteria.getFromDate());
		}
		if (searchTotalCollectionCriteria.getToDate() != null) {
			addClauseIfRequired(preparedStatement, query);
			query.append("  ewa.createdtime <= ? ");
			preparedStatement.add(searchTotalCollectionCriteria.getToDate());
		}

		return query.toString();

	}

	public String getSewerageSearchQueryApprovedNIUA(SearchTotalCollectionCriteria searchTotalCollectionCriteria,
			List<Object> preparedStatement) {
		preparedStatement.clear();
		StringBuilder query = null;
		query = new StringBuilder(WATER_SEARCH_QUERY_NIUA18);
		if (searchTotalCollectionCriteria.getFromDate() != null) {
			addClauseIfRequired(preparedStatement, query);
			query.append("  ewa.createdtime >= ?  ");
			preparedStatement.add(searchTotalCollectionCriteria.getFromDate());
		}
		if (searchTotalCollectionCriteria.getToDate() != null) {
			addClauseIfRequired(preparedStatement, query);
			query.append("  ewa.createdtime <= ? ");
			preparedStatement.add(searchTotalCollectionCriteria.getToDate());
		}

		return query.toString();

	}

	public String getSewerageSearchQueryApprovedTimeTakenNIUA(
			SearchTotalCollectionCriteria searchTotalCollectionCriteria, List<Object> preparedStatement) {
		preparedStatement.clear();
		StringBuilder query = null;
		query = new StringBuilder(WATER_SEARCH_QUERY_NIUA19);
		if (searchTotalCollectionCriteria.getFromDate() != null) {
			addClauseIfRequired(preparedStatement, query);
			query.append("  ewa.createdtime >= ?  ");
			preparedStatement.add(searchTotalCollectionCriteria.getFromDate());
		}
		if (searchTotalCollectionCriteria.getToDate() != null) {
			addClauseIfRequired(preparedStatement, query);
			query.append("  ewa.createdtime <= ? ");
			preparedStatement.add(searchTotalCollectionCriteria.getToDate());
		}

		return query.toString();

	}

	/**
	 * 
	 * @param criteria          The WaterCriteria
	 * @param preparedStatement The Array Of Object
	 * @param requestInfo       The Request Info
	 * @return query as a string
	 */
	public String getAPI(SearchCriteria criteria, List<Object> preparedStatement, RequestInfo requestInfo) {
		if (criteria.isEmpty())
			return null;
		StringBuilder query = new StringBuilder(WATER_GET_API);
		boolean propertyIdsPresent = false;
		/*
		 * if (!StringUtils.isEmpty(criteria.getMobileNumber())) { Set<String>
		 * propertyIds = new HashSet<>(); List<Property> propertyList =
		 * waterServicesUtil.propertySearchOnCriteria(criteria, requestInfo);
		 * propertyList.forEach(property -> propertyIds.add(property.getId())); if
		 * (!propertyIds.isEmpty()) { addClauseIfRequired(preparedStatement, query);
		 * query.append(" (conn.property_id in (").append(createQuery(propertyIds)).
		 * append(" )"); addToPreparedStatement(preparedStatement, propertyIds);
		 * propertyIdsPresent = true; } }
		 */
		if (!StringUtils.isEmpty(criteria.getMobileNumber())) {
			Set<String> uuids = userService.getUUIDForUsers(criteria.getMobileNumber(), criteria.getTenantId(),
					requestInfo);
			boolean userIdsPresent = false;
			if (!CollectionUtils.isEmpty(uuids)) {
				addORClauseIfRequired(preparedStatement, query);
				if (!propertyIdsPresent)
					query.append("(");
				query.append(" connectionholder.userid in (").append(createQuery(uuids)).append(" ))");
				addToPreparedStatement(preparedStatement, uuids);
				userIdsPresent = true;
			} else {
				throw new CustomException(MOBILE_NUMBER_EXCEPTION_CODE,
						"This mobile number is not register in our system");
			}
			/*
			 * if(propertyIdsPresent && !userIdsPresent){ query.append(")"); }
			 */
		}
		if (!StringUtils.isEmpty(criteria.getTenantId())) {
			addClauseIfRequired(preparedStatement, query);
			query.append(" conn.tenantid = ? ");
			preparedStatement.add(criteria.getTenantId());
		}

		if (!CollectionUtils.isEmpty(criteria.getIds())) {
			addClauseIfRequired(preparedStatement, query);
			query.append(" application.id in (").append(createQuery(criteria.getIds())).append(" )");
			addToPreparedStatement(preparedStatement, criteria.getIds());
		}
		if (!StringUtils.isEmpty(criteria.getOldConnectionNumber())) {
			addClauseIfRequired(preparedStatement, query);
			query.append(" conn.oldconnectionno = ? ");
			preparedStatement.add(criteria.getOldConnectionNumber());
		}
		if (!StringUtils.isEmpty(criteria.getPlotNo())) {
			addClauseIfRequired(preparedStatement, query);
			query.append(" pta.doorno = ? ");
			preparedStatement.add(criteria.getPlotNo());
		}
		if (!StringUtils.isEmpty(criteria.getSectorNo())) {
			addClauseIfRequired(preparedStatement, query);
			query.append(" pta.locality = ? ");
			preparedStatement.add(criteria.getSectorNo());
		}
		if (!StringUtils.isEmpty(criteria.getGroupNo())) {
			addClauseIfRequired(preparedStatement, query);
			query.append(" conn.billgroup = ? ");
			preparedStatement.add(criteria.getGroupNo());
		}
		if (!StringUtils.isEmpty(criteria.getLedgerGroup())) {
			addClauseIfRequired(preparedStatement, query);
			query.append(" conn.ledgergroup = ? ");
			preparedStatement.add(criteria.getLedgerGroup());
		}
		if (!StringUtils.isEmpty(criteria.getSubDivision())) {
			addClauseIfRequired(preparedStatement, query);
			query.append(" conn.subdiv = ? ");
			preparedStatement.add(criteria.getSubDivision());
		}
		if (!StringUtils.isEmpty(criteria.getDivision())) {
			addClauseIfRequired(preparedStatement, query);
			query.append(" conn.div = ? ");
			preparedStatement.add(criteria.getDivision());
		}

		if (!StringUtils.isEmpty(criteria.getConnectionNumber())) {
			addClauseIfRequired(preparedStatement, query);
			query.append(" conn.connectionno = ? ");
			preparedStatement.add(criteria.getConnectionNumber());
		}
		if (!StringUtils.isEmpty(criteria.getStatus())) {
			addClauseIfRequired(preparedStatement, query);
			query.append(" conn.status = ? ");
			preparedStatement.add(criteria.getStatus());
		}
		if (!StringUtils.isEmpty(criteria.getApplicationNumber())) {
			addClauseIfRequired(preparedStatement, query);
			query.append(" application.applicationno = ? ");
			preparedStatement.add(criteria.getApplicationNumber());
		}
		if (!StringUtils.isEmpty(criteria.getApplicationNumberSearch())) {
			addClauseIfRequired(preparedStatement, query);
			query.append(" application.applicationno ilike ? ");
			preparedStatement.add("%" + criteria.getApplicationNumberSearch());
		}
		if (!StringUtils.isEmpty(criteria.getApplicationStatus())) {
			addClauseIfRequired(preparedStatement, query);
			query.append(" application.applicationStatus = ? ");
			preparedStatement.add(criteria.getApplicationStatus());
		}
		if (criteria.getFromDate() != null) {
			addClauseIfRequired(preparedStatement, query);
			query.append("  application.createdTime >= ? ");
			preparedStatement.add(criteria.getFromDate());
		}
		if (criteria.getToDate() != null) {
			addClauseIfRequired(preparedStatement, query);
			query.append("  application.createdTime <= ? ");
			preparedStatement.add(criteria.getToDate());
		}
		if (criteria.getAppFromDate() != null) {
			addClauseIfRequired(preparedStatement, query);
			query.append("  application.lastModifiedTime >= ?  ");
			preparedStatement.add(criteria.getAppFromDate());
		}
		if (criteria.getAppToDate() != null) {
			addClauseIfRequired(preparedStatement, query);
			query.append("  application.lastModifiedTime <= ? ");
			preparedStatement.add(criteria.getAppToDate());
		}
		if (criteria.getAppFromDate() != null || criteria.getAppToDate() != null) {
			addClauseIfRequired(preparedStatement, query);
			query.append("  application.applicationStatus in (").append(createQuery(WCConstants.APPROVED_ACTIONS))
					.append(" )");
			addToPreparedStatement(preparedStatement, WCConstants.APPROVED_ACTIONS);
		}
		if (!StringUtils.isEmpty(criteria.getApplicationType())) {
			addClauseIfRequired(preparedStatement, query);
			query.append(" application.activitytype = ? ");
			preparedStatement.add(criteria.getApplicationType());
		}
		/*
		 * if (!StringUtils.isEmpty(criteria.getConnectionUserId())) {
		 * addORClauseIfRequired(preparedStatement, query);
		 * query.append(" cm.user_id = ? ");
		 * preparedStatement.add(criteria.getConnectionUserId()); }
		 */
		query.append(ORDER_BY_CLAUSE);
		return addPaginationWrapper(query.toString(), preparedStatement, criteria);
	}

	public String getSearchQueryStringPublicDashBoard(PublicDashBoardSearchCritieria SearchTotalCollectionCriteria,
			List<Object> preparedStatement) {
		preparedStatement.clear();
		StringBuilder query = null;
		query = new StringBuilder(PUBLIC_DASHBOARD_WATER_SEARCH);
		if (SearchTotalCollectionCriteria.getDataPayload().getFromDate() != null) {
			addClauseIfRequired(preparedStatement, query);
			query.append("  ewa.createdtime >= ?  ");
			preparedStatement.add(SearchTotalCollectionCriteria.getDataPayload().getFromDate());
		}
		if (SearchTotalCollectionCriteria.getDataPayload().getToDate() != null) {
			addClauseIfRequired(preparedStatement, query);
			query.append("  ewa.createdtime <= ? ");
			preparedStatement.add(SearchTotalCollectionCriteria.getDataPayload().getToDate());
		}
		if (SearchTotalCollectionCriteria.getDataPayload().getServicetype() != null) {
			addClauseIfRequired(preparedStatement, query);
			if ("CONNECTION_CONVERSION".equals(SearchTotalCollectionCriteria.getDataPayload().getServicetype())) {
				query.append("  ewa.activitytype in('CONNECTION_CONVERSION_TARIFF','CONNECTION_CONVERSION') ");
			} else {
				query.append("  ewa.activitytype = ? ");
				preparedStatement.add(SearchTotalCollectionCriteria.getDataPayload().getServicetype());
			}

		}

		return query.toString();

	}

	public String getSearchQueryStringPublicDashBoardApproved(
			PublicDashBoardSearchCritieria SearchTotalCollectionCriteria, List<Object> preparedStatement) {
		preparedStatement.clear();
		StringBuilder query = null;
		query = new StringBuilder(PUBLIC_DASHBOARD_WATER_SEARCH_APPROVED);
		if (SearchTotalCollectionCriteria.getDataPayload().getFromDate() != null) {
			addClauseIfRequired(preparedStatement, query);
			query.append("  ewa.createdtime >= ?  ");
			preparedStatement.add(SearchTotalCollectionCriteria.getDataPayload().getFromDate());
		}
		if (SearchTotalCollectionCriteria.getDataPayload().getToDate() != null) {
			addClauseIfRequired(preparedStatement, query);
			query.append("  ewa.createdtime <= ? ");
			preparedStatement.add(SearchTotalCollectionCriteria.getDataPayload().getToDate());
		}
		if (SearchTotalCollectionCriteria.getDataPayload().getServicetype() != null) {
			addClauseIfRequired(preparedStatement, query);
			if ("CONNECTION_CONVERSION".equals(SearchTotalCollectionCriteria.getDataPayload().getServicetype())) {
				query.append("  ewa.activitytype in('CONNECTION_CONVERSION_TARIFF','CONNECTION_CONVERSION') ");
			} else {
				query.append("  ewa.activitytype = ? ");
				preparedStatement.add(SearchTotalCollectionCriteria.getDataPayload().getServicetype());
			}
		}

		return query.toString();

	}

	public String getSearchQueryStringPublicDashBoardTimeTaken(
			PublicDashBoardSearchCritieria SearchTotalCollectionCriteria, List<Object> preparedStatement) {
		preparedStatement.clear();
		StringBuilder query = null;
		query = new StringBuilder(PUBLIC_DASHBOARD_WATER_SEARCH_TIME_TAKEN_APPROVED);
		if (SearchTotalCollectionCriteria.getDataPayload().getFromDate() != null) {
			addClauseIfRequired(preparedStatement, query);
			query.append("  ewa.createdtime >= ?  ");
			preparedStatement.add(SearchTotalCollectionCriteria.getDataPayload().getFromDate());
		}
		if (SearchTotalCollectionCriteria.getDataPayload().getToDate() != null) {
			addClauseIfRequired(preparedStatement, query);
			query.append("  ewa.createdtime <= ? ");
			preparedStatement.add(SearchTotalCollectionCriteria.getDataPayload().getToDate());
		}
		if (SearchTotalCollectionCriteria.getDataPayload().getServicetype() != null) {
			addClauseIfRequired(preparedStatement, query);
			if ("CONNECTION_CONVERSION".equals(SearchTotalCollectionCriteria.getDataPayload().getServicetype())) {
				query.append("  ewa.activitytype in('CONNECTION_CONVERSION_TARIFF','CONNECTION_CONVERSION') ");
			} else {
				query.append("  ewa.activitytype = ? ");
				preparedStatement.add(SearchTotalCollectionCriteria.getDataPayload().getServicetype());
			}
		}

		return query.toString();

	}
	
	public String getSearchQueryStringPublicDashBoardTotalCollection(
			PublicDashBoardSearchCritieria SearchTotalCollectionCriteria, List<Object> preparedStatement) {
		preparedStatement.clear();
		StringBuilder query = null;
		query = new StringBuilder(PUBLIC_DASHBOARD_WATER_TOTAL_COLLECTION);
		if (SearchTotalCollectionCriteria.getDataPayload().getFromDate() != null) {
			addClauseIfRequired(preparedStatement, query);
			query.append("  ewa.createdtime >= ?  ");
			preparedStatement.add(SearchTotalCollectionCriteria.getDataPayload().getFromDate());
		}
		if (SearchTotalCollectionCriteria.getDataPayload().getToDate() != null) {
			addClauseIfRequired(preparedStatement, query);
			query.append("  ewa.createdtime <= ? ");
			preparedStatement.add(SearchTotalCollectionCriteria.getDataPayload().getToDate());
		}
		if (SearchTotalCollectionCriteria.getDataPayload().getServicetype() != null) {
			addClauseIfRequired(preparedStatement, query);
			if ("CONNECTION_CONVERSION".equals(SearchTotalCollectionCriteria.getDataPayload().getServicetype())) {
				query.append("  ewa.activitytype in('CONNECTION_CONVERSION_TARIFF','CONNECTION_CONVERSION') ");
			} else {
				query.append("  ewa.activitytype = ? ");
				preparedStatement.add(SearchTotalCollectionCriteria.getDataPayload().getServicetype());
			}
		}
		
		addClauseIfRequired(preparedStatement, query);
		query.append("  ept.txn_status = 'SUCCESS' ");

		return query.toString();

	}
	
	public String getSearchQueryStringPublicDashBoardFilestoreId(
			PublicDashBoardSearchCritieria SearchTotalCollectionCriteria, List<Object> preparedStatement) {
		preparedStatement.clear();
		StringBuilder query = null;
		query = new StringBuilder(PUBLIC_DASHBOARD_WATER_FILESTORE);
		return query.toString();

	}
	
	
	public String getSearchQueryStringPublicDashBoardFilestoreCreatedTime(
			PublicDashBoardSearchCritieria SearchTotalCollectionCriteria, List<Object> preparedStatement) {
		preparedStatement.clear();
		StringBuilder query = null;
		query = new StringBuilder(PUBLIC_DASHBOARD_WATER_FILESTORE_CREATED_TIME);
		return query.toString();

	}

}
