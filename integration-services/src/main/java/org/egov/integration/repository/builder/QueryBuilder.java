package org.egov.integration.repository.builder;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class QueryBuilder {	
	 
	public static final String GET_POST_DETAIL_QUERY="select employee_code,org_unit_id,array_to_json(array_agg(json_build_object('post_detail_id',post_detail_id,'post',org_unit_name) ))as postDetail from employee_post_detail_map where employee_code=:employeeCode\n" + 
			"GROUP BY  employee_code,org_unit_id ";
	
	
	public static final String IDLE_KILL_CONNECTION_COUNT ="WITH inactive_connections AS (\r\n"
			+ "    SELECT\r\n"
			+ "        pid,\r\n"
			+ "        rank() over (partition by client_addr order by backend_start ASC) as rank\r\n"
			+ "    FROM\r\n"
			+ "        pg_stat_activity\r\n"
			+ "    WHERE\r\n"
			+ "        -- Exclude the thread owned connection (ie no auto-kill)\r\n"
			+ "        pid <> pg_backend_pid( )\r\n"
			+ "    AND\r\n"
			+ "        -- Exclude known applications connections\r\n"
			+ "        application_name !~ '(?:psql)|(?:pgAdmin.+)'\r\n"
			+ "    AND\r\n"
			+ "        -- Include connections to the same database the thread is connected to\r\n"
			+ "        datname = 'digit'\r\n"
			+ "    AND\r\n"
			+ "        -- Include connections using the same thread username connection\r\n"
			+ "        usename = 'digit_prod'\r\n"
			+ "    AND\r\n"
			+ "        -- Include inactive connections only\r\n"
			+ "        state in ('idle', 'idle in transaction', 'idle in transaction (aborted)', 'disabled')\r\n"
			+ "    AND\r\n"
			+ "        -- Include old connections (found with the state_change field)\r\n"
			+ "        current_timestamp - state_change > interval '5 minutes'\r\n"
			+ ")\r\n"
			+ "SELECT\r\n"
			+ "    count(pg_terminate_backend(pid)) as idlekillconnections \r\n"
			+ "FROM\r\n"
			+ "    inactive_connections\r\n"
			+ "WHERE\r\n"
			+ "    rank > 1 ";
	
	public String getIdleConnectionKillCount(List<Object> preparedStatement) {
		StringBuilder query;
		query = new StringBuilder(IDLE_KILL_CONNECTION_COUNT);
		
		//System.out.println("Idle Connections Kill Count query :"+query);
		
		return query.toString() ;

	}
	
	
	
	public static final String COEXISTENCE_IDLE_KILL_CONNECTION_COUNT ="WITH inactive_connections AS (\r\n"
			+ "    SELECT\r\n"
			+ "        pid,\r\n"
			+ "        rank() over (partition by client_addr order by backend_start ASC) as rank\r\n"
			+ "    FROM\r\n"
			+ "        pg_stat_activity\r\n"
			+ "    WHERE\r\n"
			+ "        -- Exclude the thread owned connection (ie no auto-kill)\r\n"
			+ "        pid <> pg_backend_pid( )\r\n"
			+ "    AND\r\n"
			+ "        -- Exclude known applications connections\r\n"
			+ "        application_name !~ '(?:psql)|(?:pgAdmin.+)'\r\n"
			+ "    AND\r\n"
			+ "        -- Include connections to the same database the thread is connected to\r\n"
			+ "        datname = 'coexistence'\r\n"
			+ "    AND\r\n"
			+ "        -- Include connections using the same thread username connection\r\n"
			+ "        usename = 'finance_prod'\r\n"
			+ "    AND\r\n"
			+ "        -- Include inactive connections only\r\n"
			+ "        state in ('idle', 'idle in transaction', 'idle in transaction (aborted)', 'disabled')\r\n"
			+ "    AND\r\n"
			+ "        -- Include old connections (found with the state_change field)\r\n"
			+ "        current_timestamp - state_change > interval '5 minutes'\r\n"
			+ ")\r\n"
			+ "SELECT\r\n"
			+ "    count(pg_terminate_backend(pid)) as idlekillconnections \r\n"
			+ "FROM\r\n"
			+ "    inactive_connections\r\n"
			+ "WHERE\r\n"
			+ "    rank > 1 ";
	
	
	public static final String OBPS_IDLE_KILL_CONNECTION_COUNT ="WITH inactive_connections AS (\r\n"
			+ "    SELECT\r\n"
			+ "        pid,\r\n"
			+ "        rank() over (partition by client_addr order by backend_start ASC) as rank\r\n"
			+ "    FROM\r\n"
			+ "        pg_stat_activity\r\n"
			+ "    WHERE\r\n"
			+ "        -- Exclude the thread owned connection (ie no auto-kill)\r\n"
			+ "        pid <> pg_backend_pid( )\r\n"
			+ "    AND\r\n"
			+ "        -- Exclude known applications connections\r\n"
			+ "        application_name !~ '(?:psql)|(?:pgAdmin.+)'\r\n"
			+ "    AND\r\n"
			+ "        -- Include connections to the same database the thread is connected to\r\n"
			+ "        datname = 'obps'\r\n"
			+ "    AND\r\n"
			+ "        -- Include connections using the same thread username connection\r\n"
			+ "        usename = 'obps_prod'\r\n"
			+ "    AND\r\n"
			+ "        -- Include inactive connections only\r\n"
			+ "        state in ('idle', 'idle in transaction', 'idle in transaction (aborted)', 'disabled')\r\n"
			+ "    AND\r\n"
			+ "        -- Include old connections (found with the state_change field)\r\n"
			+ "        current_timestamp - state_change > interval '5 minutes'\r\n"
			+ ")\r\n"
			+ "SELECT\r\n"
			+ "    count(pg_terminate_backend(pid)) as idlekillconnections \r\n"
			+ "FROM\r\n"
			+ "    inactive_connections\r\n"
			+ "WHERE\r\n"
			+ "    rank > 1 ";
	
	public static final String UPDATE_CITY ="UPDATE eg_user_address\r\n"
			+ "SET city = 'ch.chandigarh'\r\n"
			+ "FROM eg_user u\r\n"
			+ "WHERE eg_user_address.userid = u.id \r\n"
			+ "AND eg_user_address.\"type\" = 'PERMANENT' \r\n"
			+ "AND (eg_user_address.city IS NULL OR eg_user_address.city = 'ch');";
	
	public String getCoexistenceIdleConnectionKillCount(List<Object> preparedStatement) {
		StringBuilder query;
		query = new StringBuilder(COEXISTENCE_IDLE_KILL_CONNECTION_COUNT);
		
		//System.out.println("Idle Connections Kill Count query :"+query);
		
		return query.toString() ;

	}
	
	public String getObpsIdleConnectionKillCount(List<Object> preparedStatement) {
		StringBuilder query;
		query = new StringBuilder(OBPS_IDLE_KILL_CONNECTION_COUNT);
		
		//System.out.println("Idle Connections Kill Count query :"+query);
		
		return query.toString() ;

	}
	
	public String updatecity(List<Object> preparedStatement) {
		StringBuilder query;
		query = new StringBuilder(UPDATE_CITY);
		
		System.out.println("updatecity query :"+query);
		
		return query.toString();

	}
}
