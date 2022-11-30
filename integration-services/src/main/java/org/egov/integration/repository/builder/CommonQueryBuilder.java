package org.egov.integration.repository.builder;

import java.util.List;

import org.egov.common.contract.request.RequestInfo;
import org.springframework.stereotype.Component;

@Component
public class CommonQueryBuilder {

	
	private static final String COMMON_SEARCH_CITIZEN_COUNT = "select count(*) as totalCitizensCount from eg_user eu where \"type\" = 'CITIZEN'";

	
	
	public String getSearchQueryStringTotalCitizensCount(List<Object> preparedStatement,
			RequestInfo requestInfo) {
		preparedStatement.clear();
		StringBuilder query = null;
		query = new StringBuilder(COMMON_SEARCH_CITIZEN_COUNT);	
		return query.toString();		
		
	}

}
