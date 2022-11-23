package org.egov.integration.repository.rowmapper;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

import org.egov.integration.model.applicationsMovedToday;
import org.egov.integration.model.buckets;
import org.egov.integration.model.metrics;
import org.egov.integration.model.todaysCollection;
import org.egov.integration.model.todaysTradeLicenses;
//import org.egov.tl.web.models.*;
import org.egov.tracer.model.CustomException;
//import org.egov.waterconnection.model.buckets;
import org.postgresql.util.PGobject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//import static org.egov.tl.util.TLConstants.*;


@Component
public class TLRowMapperNIUA  implements ResultSetExtractor<metrics> {


    @Autowired
    private ObjectMapper mapper;



    public metrics extractData(ResultSet rs) throws SQLException, DataAccessException {

    	metrics mtrcs = new metrics();
    	List<buckets> listBCKTttl = new ArrayList<>();
//    	todaysCollection
    	List<buckets> listBCKTtc = new ArrayList<>();
//    	applicationsMovedToday
    	List<buckets> listBCKTamt = new ArrayList<>();
    	
    	List<todaysTradeLicenses> listTTL = new ArrayList<todaysTradeLicenses>();
    	List<todaysCollection> listTC = new ArrayList<todaysCollection>();
    	List<applicationsMovedToday> listAMT = new ArrayList<applicationsMovedToday>();
    	
    	todaysTradeLicenses ttl = new todaysTradeLicenses();
    	todaysCollection TC = new todaysCollection();
    	applicationsMovedToday amt = new applicationsMovedToday();
//    	buckets bckt = new buckets();
    	
    	while (rs.next()) {
    		String ccc = rs.getString("ccc");
        	String name = rs.getString("name");
        	String value = rs.getString("value");
        	buckets bckt = new buckets();
            if(ccc.equalsIgnoreCase("todaysTradeLicenses")) {
            	ttl.setGroupBy(ccc);
            	bckt.setName(name);
            	bckt.setValue(value);
            	listBCKTttl.add(bckt);
            	ttl.setBuckets(listBCKTttl);
            }
            
            else if(ccc.equalsIgnoreCase("todaysCollection")) {
            	TC.setGroupBy(ccc);
            	bckt.setName(name);
            	bckt.setValue(value);
            	listBCKTtc.add(bckt);
            	TC.setBuckets(listBCKTtc);
            }
            
            else  if(ccc.equalsIgnoreCase("applicationsMovedToday")) {
            	amt.setGroupBy(ccc);
            	bckt.setName(name);
            	bckt.setValue(value);
            	listBCKTamt.add(bckt);
            	amt.setBuckets(listBCKTamt);
            }
            
            else  if(ccc.equalsIgnoreCase("transactions")) {
            	mtrcs.setTransactions(value);
            }
			else  if(ccc.equalsIgnoreCase("todaysApplications")) {
				mtrcs.setTodaysApplications(value);
			            	
			}
			else  if(ccc.equalsIgnoreCase("tlTax")) {
				mtrcs.setTlTax(value);
			}
			else  if(ccc.equalsIgnoreCase("adhocPenalty")) {
				mtrcs.setAdhocPenalty(value);     	
			}
			else  if(ccc.equalsIgnoreCase("adhocRebate")) {
				mtrcs.setAdhocRebate(value);
			}
            
            
            listTTL.add(ttl);
            listTC.add(TC);
            listAMT.add(amt);
            
            
            mtrcs.setTodaysTradeLicenses(listTTL);
            mtrcs.setTodaysCollection(listTC);
            mtrcs.setApplicationsMovedToday(listAMT);
    	}
    	
    	Gson gson = new Gson();
        String json = gson.toJson(mtrcs);
    	
    	return mtrcs ;

    }







}
