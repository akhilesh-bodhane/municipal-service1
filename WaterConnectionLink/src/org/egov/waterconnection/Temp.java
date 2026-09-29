package org.egov.waterconnection;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class Temp {

	public static void main(String[] args) throws FileNotFoundException, IOException, ParseException {
		
		SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
	//	System.out.println(expiry);
		DateFormat dateParser = new SimpleDateFormat("ddMMyyyy");
		DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd");
		String eg_ws_connection;
		String eg_ws_connectionholder;
		String eg_ws_property;
		String eg_pt_property;
		String eg_pt_address;
		String eg_ws_service;
		String eg_ws_connectionUuid;
		String eg_ws_connectionholderUuid;
		String eg_ws_propertyUuid;
		String eg_pt_propertyUuid;
		String eg_pt_addressUuid;
		String eg_ws_application;
		String eg_ws_applicationuuid;
		String connectionUuid;
		String propertyUuid;
		String propertyId ;
		String applicationId;
		String accountId;
		String tenant;
		String connId,connDate,billgp,pipesize,meterrentcode,meterid,initialmeterreading,hosueno,address,tariffType,sector,sectorName,name,div,subdivision,ledger,doorNo,floorNo,eg_pt_ownerUuid,eg_pt_owner;
		PrintWriter writer = null;
		
		try (BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\vmodisauser25\\Desktop\\CONNECTION DATA (1) (1)-Sheet1.csv"))) {
			String line;
//			‪C:\Users\WS-09\Desktop\new_water.csv
//			C:\\Users\\WS-09\\Desktop\\new_water.csv
//			C:\Users\WS-09\Desktop\new_Water_user_9_3.csv
//			C:\Users\WS-09\Desktop\new_water_user13_3.csv
//			‪C:\Users\WS-09\Desktop\new_water_user_16_3.csv
//			C:\Users\WS-09\Desktop\new_User_Water_17_3.csv
//			C:\Users\WS-09\Desktop\new_water_user_21_03.csv
//			C:\Users\WS-09\Desktop\new_water_user_22_03.csv
//			C:\Users\WS-09\Desktop\new_User_Water_24_03.csv
//			new_User_Water_25(2)_03
//			C:\Users\WS-09\Desktop\new_User_Water_28_03.csv.csv
//			new_User_Water_28(2)_03
//			new_water_user_04_04
//			new_water_user_07_04(2)
//			new_water_user_11_04
//			new_water_user_13_04
//			new_water_user_18_04
//			new_water_user_19_04
//			new_water_user_20_04
//			new_water_user_21_04
//			C:\Users\WS-09\Desktop\new_water_user_09_05.csv
//			new_water_user_09_05(1)
//			new_water_user_17_05
//			new_water_user_18_05
//			C:\Users\WS-09\Desktop\new_water_user_01_06.csv
//			new_water_user_06_06
//			new_water_user_16_06 new_water_user_17_06(1)new_water_user_13_07

			writer = new PrintWriter("C:\\Users\\vmodisauser25\\Desktop\\water_query\\water_query_29_08.txt", "UTF-8");
			while ((line = br.readLine()) != null) {
				String[] values = line.split(",");
				List<String> data = Arrays.asList(values);
				eg_ws_connectionUuid=UUID.randomUUID().toString();
				eg_ws_connectionholderUuid=UUID.randomUUID().toString();
				eg_ws_propertyUuid=UUID.randomUUID().toString();
				eg_pt_propertyUuid=UUID.randomUUID().toString();
				eg_pt_addressUuid=UUID.randomUUID().toString();
				eg_pt_ownerUuid=UUID.randomUUID().toString();
				eg_ws_applicationuuid = UUID.randomUUID().toString();
				connId=	data.get(2).trim();
				connDate = data.get(8).trim();
				Date date = df.parse(connDate);
				long epoch = date.getTime();
				billgp = data.get(1).trim();
				tariffType= data.get(7).trim();
				name = data.get(3).trim();
				hosueno= data.get(4).trim();
				initialmeterreading=data.get(15).trim();
				pipesize= data.get(9).trim();
				meterrentcode= data.get(10).trim();
				meterid=data.get(11).trim();
				address=data.get(4).trim()+" "+data.get(5).trim()+" "+data.get(6).trim();
				sectorName= data.get(6).trim();
				propertyId= "TEMP_PROPERTY"+connId;
				accountId= "TEMP_ACCOUNT"+connId;
				applicationId="WSAP"+connId;
				div=connId.substring(0, 1);
				subdivision=connId.substring(1, 3);
				sector = connId.substring(3, 5);
				ledger=connId.substring(5, 7);
				doorNo=connId.substring(7, 11);
				floorNo=connId.substring(11, 13);
				if(connId.equalsIgnoreCase("220MZ01006300R")) {
					System.out.println();
				}
				System.out.println(connId+"  "+div+"  "+subdivision+"  "+ledger+"  "+doorNo+"  "+sector+floorNo + "sect-"+sectorName);
				 eg_ws_connection="INSERT INTO public.eg_ws_connection (id, tenantid, property_id,applicationstatus,  status, connectionno,inworkflow, div, subdiv, ledger_no, ledgergroup,billgroup,waterapplicationtype,createdtime,lastmodifiedtime)  VALUES('"+eg_ws_connectionUuid+"', 'ch.chandigarh', '"+eg_pt_propertyUuid+"', 'CONNECTION_ACTIVATED', 'Active', '"+connId+"',  false, '"+div+"', '"+subdivision+"','"+ledger+"', '"+sector+ledger+"', '"+billgp+"','"+getApplicationType(tariffType)+"',"+epoch+","+epoch+");";
				 eg_ws_connectionholder="INSERT INTO public.eg_ws_connectionholder(tenantid, connectionid,name,   correspondance_address,ws_application_id) VALUES('ch.chandigarh', '"+eg_ws_connectionUuid+"', '"+name+"', '"+address+"','"+eg_ws_applicationuuid+"');";
				 eg_ws_property="INSERT INTO public.eg_ws_property(id, tenantid, property_id, wsid, usagecategory) VALUES('"+eg_ws_propertyUuid+"', 'ch.chandigarh', '"+eg_pt_propertyUuid+"', '"+eg_ws_connectionUuid+"', '"+tariffType+"');";
				 eg_pt_property="INSERT INTO public.eg_pt_property (id, propertyid, tenantid,accountid,status,propertytype,ownershipcategory,source, channel,createdtime,lastmodifiedtime) VALUES('"+eg_pt_propertyUuid+"', '"+propertyId+"', 'ch.chandigarh', '"+accountId+"','Active','VACANT','INDIVIDUAL.SINGLEOWNER','MUNICIPAL_RECORDS', 'SYSTEM',"+epoch+","+epoch+");";
				 eg_pt_address="INSERT INTO public.eg_pt_address(tenantid,city, id, propertyid,  locality,doorNo,floor_no,plotno, createdtime,lastmodifiedtime)VALUES('ch.chandigarh','Chandigarh', '"+eg_pt_addressUuid+"', '"+eg_pt_propertyUuid+"', '"+sector+"','"+doorNo+"','"+floorNo+"','"+hosueno+"',"+epoch+","+epoch+");";
				 eg_ws_service="INSERT INTO public.eg_ws_service(connection_id, connectionexecutiondate, connectionType,proposedpipesize,meterrentcode,meterid,initialmeterreading)VALUES('"+eg_ws_connectionUuid+"', '"+epoch+"','Metered', '"+pipesize+"','"+meterrentcode+"','"+meterid+"',"+initialmeterreading+");";
				 eg_ws_application="INSERT INTO public.eg_ws_application(id, tenantid,activitytype,applicationstatus, wsid, applicationno,createdtime,lastmodifiedtime)VALUES('"+eg_ws_applicationuuid+"', 'ch.chandigarh','NEW_WS_CONNECTION', 'CONNECTION_ACTIVATED','"+eg_ws_connectionUuid+"','"+applicationId+"',"+epoch+","+epoch+");";
				 eg_pt_owner=" INSERT INTO public.eg_pt_owner(ownerinfouuid, tenantid, propertyid, userid, status, createdtime, owner_name, correspondance_address,lastmodifiedtime)VALUES('"+eg_pt_ownerUuid+"', 'ch.chandigarh', '"+eg_pt_propertyUuid+"', 'TEMP_"+eg_pt_propertyUuid+"', 'ACTIVE',  "+epoch+", '"+name+"', '"+address+"',"+epoch+");";
				 writer.println(eg_ws_connection);
				 writer.println(eg_pt_property);
				 writer.println(eg_ws_connectionholder);
				 writer.println(eg_ws_property);
				 writer.println(eg_pt_address);
				 writer.println(eg_ws_service);
				 writer.println(eg_ws_application);
				 writer.println(eg_pt_owner);
				 writer.println("---------------------------------------------------------------");
				
				 
			}
		}catch(Exception e) {
			System.out.println(e);
		}
		finally{
			 writer.close();
		}
		
	}

	private static String getApplicationType(String tariffType) {
		if(tariffType.equalsIgnoreCase("19")||tariffType.equalsIgnoreCase("17")) {
			return "TEMPORARY";
		}else {
			return "REGULAR";
		} 
	}

}
