package org.egov.pgr.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.egov.pgr.model.AutoroutingMap;
import org.egov.pgr.repository.rowmapper.AutoRoutingMapRowmapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;

import lombok.extern.slf4j.Slf4j;

@Repository
@Slf4j
public class MasterDataRepository {
		
	@Autowired
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	/**
     * @param id
     * @param tenantId
     * @return AutoroutingMap
     */
    public AutoroutingMap getAutoRoutingData(String id, String tenantId) {

        String query = "SELECT id, tenantid, autorouting, createdby, createdtime, lastmodifiedby, lastmodifiedtime, active FROM eg_pgr_autorouting_data WHERE id=:id AND tenantid=:tenantid";

        final Map<String, Object> parametersMap = new HashMap<String, Object>();
        parametersMap.put("id", id);
        parametersMap.put("tenantid", tenantId);

        List<AutoroutingMap> autoroutingMapList = namedParameterJdbcTemplate.query(query, parametersMap, new AutoRoutingMapRowmapper());
        if(!CollectionUtils.isEmpty(autoroutingMapList)) {
        	return autoroutingMapList.get(0);
        }
        return null;
    }
    
    /**
     * @param tenantId
     * @return AutoroutingMap
     */
    public AutoroutingMap getAutoRoutingData(String tenantId) {

    	String query = "SELECT id, tenantid, autorouting, createdby, createdtime, lastmodifiedby, lastmodifiedtime, active FROM eg_pgr_autorouting_data WHERE tenantid=:tenantid";

        final Map<String, Object> parametersMap = new HashMap<String, Object>();
        parametersMap.put("tenantid", tenantId);

        List<AutoroutingMap> autoroutingMapList = namedParameterJdbcTemplate.query(query, parametersMap, new AutoRoutingMapRowmapper());
        if(!CollectionUtils.isEmpty(autoroutingMapList)) {
        	return autoroutingMapList.get(0);
        }
        return null;
    }

}
