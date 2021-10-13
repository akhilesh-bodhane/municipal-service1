package org.egov.assets.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.egov.assets.common.JdbcRepository;
import org.egov.assets.common.Pagination;
import org.egov.assets.model.ScrapDetail;
import org.egov.assets.model.ScrapDetailSearch;
import org.egov.assets.model.ScrapSearch;
import org.egov.assets.repository.entity.DisposalDetailEntity;
import org.egov.assets.repository.entity.IndentEntity;
import org.egov.assets.repository.entity.ScrapDetailEntity;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;
@Repository
public class ScrapDetailJdbcRepository extends JdbcRepository{
	
	  static {
	        init(ScrapDetailEntity.class);
	    }
	
	
	 public Pagination<ScrapDetail> search(ScrapDetailSearch scrapDetailSearch) {
	        String searchQuery = "select * from scrapdetail" +
	                " :condition :orderby";
	        StringBuffer params = new StringBuffer();
	        Map<String, Object> paramValues = new HashMap<>();

	        if (scrapDetailSearch.getSortBy() != null && !scrapDetailSearch.getSortBy().isEmpty()) {
	            validateSortByOrder(scrapDetailSearch.getSortBy());
	            validateEntityFieldName(scrapDetailSearch.getSortBy(), ScrapSearch.class);
	        }

	        String orderBy = "order by scrapNumber";

	        if (scrapDetailSearch.getSortBy() != null && !scrapDetailSearch.getSortBy().isEmpty()) {
	            orderBy = "order by " + scrapDetailSearch.getSortBy();
	        }

	        if (scrapDetailSearch.getIds() != null) {
	            if (params.length() > 0)
	                params.append(" and ");
	            params.append("id in (:ids)");
	            paramValues.put("id", scrapDetailSearch.getIds());
	        }

	        if (scrapDetailSearch.getScrapNumber() != null) {
	            if (params.length() > 0)
	                params.append(" and ");
	            params.append("scrapNumber in (:scrapNumber)");
	            paramValues.put("scrapNumber", scrapDetailSearch.getScrapNumber());
	        }

	        
	        if (scrapDetailSearch.getTenantId() != null) {
	            if (params.length() > 0)
	                params.append(" and ");
	            params.append("tenantId = :tenantId");
	            paramValues.put("tenantId", scrapDetailSearch.getTenantId());
	        }

	        Pagination<ScrapDetail> page = new Pagination<>();
	        if (scrapDetailSearch.getPageSize() != null)
	            page.setPageSize(scrapDetailSearch.getPageSize());
	        if (scrapDetailSearch.getOffset() != null)
	            page.setOffset(scrapDetailSearch.getOffset());
	        if (params.length() > 0)
	            searchQuery = searchQuery.replace(":condition", " where " + params.toString());
	        else
	            searchQuery = searchQuery.replace(":condition", "");

	        searchQuery = searchQuery.replace(":orderby", orderBy);
	        page = (Pagination<ScrapDetail>) getPagination(searchQuery, page, paramValues);

	        searchQuery = searchQuery + " :pagination";
	        searchQuery = searchQuery.replace(":pagination", "limit " + page.getPageSize() + " offset " + page.getOffset() * page.getPageSize());
	        BeanPropertyRowMapper row = new BeanPropertyRowMapper(ScrapDetailEntity.class);

	        List<ScrapDetail> scrapDetail = new ArrayList<>();

	        List<ScrapDetailEntity> scrapDetailEntities = namedParameterJdbcTemplate
	                .query(searchQuery.toString(), paramValues, row);

	        for (ScrapDetailEntity scrapDetailEntity : scrapDetailEntities) {

	        	scrapDetail.add(scrapDetailEntity.toDomain());
	        }

	        page.setTotalResults(scrapDetail.size());

	        page.setPagedData(scrapDetail);

	        return page;
	    }
	 
	 
		public ScrapDetailEntity findById(ScrapDetailEntity entity) {
			List<String> list = allIdentitiferFields.get(entity.getClass().getSimpleName());

			Map<String, Object> paramValues = new HashMap<>();

			for (String s : list) {
				paramValues.put(s, getValue(getField(entity, s), entity));
			}

			List<ScrapDetailEntity> scrapDetails = namedParameterJdbcTemplate.query(
					getByIdQuery.get(entity.getClass().getSimpleName()).toString(), paramValues,
					new BeanPropertyRowMapper(ScrapDetailEntity.class));
			if (scrapDetails.isEmpty()) {
				return null;
			} else {
				return scrapDetails.get(0);
			}

		}

}
