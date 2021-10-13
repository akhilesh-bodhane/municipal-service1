package org.egov.integration.repository.builder;

import org.springframework.stereotype.Component;

@Component
public class QueryBuilder {	
	 
	public static final String GET_POST_DETAIL_QUERY="select employee_code,org_unit_id,array_to_json(array_agg(json_build_object('post_detail_id',post_detail_id,'post',org_unit_name) ))as postDetail from employee_post_detail_map where employee_code=:employeeCode\n" + 
			"GROUP BY  employee_code,org_unit_id ";
}
