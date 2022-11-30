package org.egov.integration.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.egov.common.contract.request.RequestInfo;
import org.egov.integration.model.CommonBuckets;
import org.egov.integration.model.CommonMetrics;
import org.egov.integration.model.LiveUlbsCount;
import org.egov.integration.repository.builder.CommonQueryBuilder;
import org.egov.integration.repository.rowmapper.TotalCitizenCountRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.google.gson.Gson;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Repository
public class CommonDaoImpl implements CommonDao{
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private CommonQueryBuilder commonQueryBuilder;
	
	@Autowired
	private TotalCitizenCountRowMapper totalCitizenCountRowMapper ;
	
	@Override
	public CommonMetrics getCommonTotalCollectionListCountNIUA(RequestInfo requestInfo) {
		
		List<Object> preparedStatement = new ArrayList<>();
		
		
		List<LiveUlbsCount> build3 = new ArrayList<>();
		
	    LiveUlbsCount connection = new LiveUlbsCount();
				
		String groupby="serviceModuleCode";
					
		List<CommonBuckets> query2 = null;
		
		List<CommonMetrics> totalCitizensCount = totalCitizensCount(preparedStatement, requestInfo);
					
		//data(preparedStatement, requestInfo);
		
		query2 = Stream.of(
				           //new Buckets("SW",01),
				           new CommonBuckets("TL",01),
				           new CommonBuckets("PGR",01),
				           new CommonBuckets("WS",01)
				           //,new buckets("NOC",01),				           
				           //new Buckets("ECHALLAN",01)
				           ).collect(Collectors.toList());
					
		connection.setGroupBy(groupby);
		connection.setBuckets(query2);
		build3.add(connection);
				
		CommonMetrics build = CommonMetrics.builder().liveUlbsCount(build3).build();
		
		build.setStatus("Live");
		build.setOnboardedUlbsCount(01);
		build.setTotalCitizensCount(totalCitizensCount.get(0).getTotalCitizensCount());
		build.setTotalLiveUlbsCount(01);
		build.setTotalUlbCount(01);
		
		
		Gson gson = new Gson();
        String json = gson.toJson(build);
		
		return build;
	}
	
	
private List<CommonMetrics> totalCitizensCount(List<Object> preparedStatement, RequestInfo requestInfo) {
		
		String query = commonQueryBuilder.getSearchQueryStringTotalCitizensCount(preparedStatement, requestInfo);
		
			List<CommonMetrics> query2 = jdbcTemplate.query(query, preparedStatement.toArray(),totalCitizenCountRowMapper);
		
				
		return query2;
	}
		
}
