package org.egov.assets.repository;

import static org.springframework.util.StringUtils.isEmpty;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.egov.assets.common.JdbcRepository;
import org.egov.assets.common.MdmsRepository;
import org.egov.assets.common.Pagination;
import org.egov.assets.model.Material;
import org.egov.assets.model.PriceListDetails;
import org.egov.assets.model.PriceListDetailsSearchRequest;
import org.egov.assets.model.PriceListSearchRequest;
import org.egov.assets.repository.entity.PriceListDetailsEntity;
import org.egov.assets.service.UomService;
import org.egov.common.contract.request.RequestInfo;
import org.egov.tracer.model.CustomException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;

import net.minidev.json.JSONArray;

@Service
public class PriceListDetailJdbcRepository extends JdbcRepository {

	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	@Autowired
	private UomService uomService;

	@Autowired
	private MdmsRepository mdmsRepository;

	public PriceListDetailJdbcRepository(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
		this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
	}

	public Pagination<PriceListDetails> search(PriceListDetailsSearchRequest priceListDetailsSearchRequest) {
		String searchQuery = "select * from pricelistdetails :condition  :orderby ";

		Map<String, Object> paramValues = new HashMap<>();
		StringBuffer params = new StringBuffer();

		if (!isEmpty(priceListDetailsSearchRequest.getSortBy())) {
			validateSortByOrder(priceListDetailsSearchRequest.getSortBy());
			validateEntityFieldName(priceListDetailsSearchRequest.getSortBy(), PriceListSearchRequest.class);
		}

		String orderBy = "order by id";
		if (!isEmpty(priceListDetailsSearchRequest.getSortBy())) {
			orderBy = "order by " + priceListDetailsSearchRequest.getSortBy();
		}

		if (priceListDetailsSearchRequest.getTenantId() != null) {
			if (params.length() > 0) {
				params.append(" and ");
			}
			params.append("tenantid =:tenantId");
			paramValues.put("tenantId", priceListDetailsSearchRequest.getTenantId());
		}

		if (priceListDetailsSearchRequest.getId() != null) {
			if (params.length() > 0) {
				params.append(" and ");
			}
			params.append("id =:id");
			paramValues.put("id", priceListDetailsSearchRequest.getId());
		}

		if (priceListDetailsSearchRequest.getIds() != null) {
			if (params.length() > 0) {
				params.append(" and ");
			}
			params.append("id in(:ids) ");
			paramValues.put("ids",
					new ArrayList<String>(Arrays.asList(priceListDetailsSearchRequest.getIds().split(","))));
		}

		if (priceListDetailsSearchRequest.getPriceList() != null) {
			if (params.length() > 0) {
				params.append(" and ");
			}
			params.append("priceList =:priceList");
			paramValues.put("priceList", priceListDetailsSearchRequest.getPriceList());
		}
		if (priceListDetailsSearchRequest.getMaterial() != null) {
			if (params.length() > 0) {
				params.append(" and ");
			}
			params.append(" material =(:materials) ");
			paramValues.put("materials", priceListDetailsSearchRequest.getMaterial());
		}

		if (priceListDetailsSearchRequest.getActive() != null) {
			if (params.length() > 0) {
				params.append(" and ");
			}
			params.append("active =:active");
			paramValues.put("active", priceListDetailsSearchRequest.getActive());
		}

		if (priceListDetailsSearchRequest.getDeleted() != null) {
			if (params.length() > 0) {
				params.append(" and ");
			}
			params.append("deleted =:deleted");
			paramValues.put("deleted", priceListDetailsSearchRequest.getDeleted());
		}

		Pagination<PriceListDetails> page = new Pagination<>();
		if (priceListDetailsSearchRequest.getOffSet() != null) {
			page.setOffset(priceListDetailsSearchRequest.getOffSet());
		}
		if (priceListDetailsSearchRequest.getPageSize() != null) {
			page.setPageSize(priceListDetailsSearchRequest.getPageSize());
		}

		if (params.length() > 0) {

			searchQuery = searchQuery.replace(":condition", " where deleted is not true and " + params.toString());

		} else

			searchQuery = searchQuery.replace(":condition", "");

		searchQuery = searchQuery.replace(":orderby", orderBy);

		page = (Pagination<PriceListDetails>) getPagination(searchQuery, page, paramValues);
		searchQuery = searchQuery + " :pagination";

		searchQuery = searchQuery.replace(":pagination",
				"limit " + page.getPageSize() + " offset " + page.getOffset() * page.getPageSize());

		BeanPropertyRowMapper row = new BeanPropertyRowMapper(PriceListDetailsEntity.class);

		List<PriceListDetailsEntity> priceListDetailsEntities = namedParameterJdbcTemplate.query(searchQuery.toString(),
				paramValues, row);

		List<PriceListDetails> priceListDetailsList = priceListDetailsEntities.stream()
				.map(PriceListDetailsEntity::toDomain).collect(Collectors.toList());

		ObjectMapper mapper = new ObjectMapper();
		Map<String, Material> materialMap = getMaterial(priceListDetailsSearchRequest.getTenantId(), mapper,
				new RequestInfo());

		for (PriceListDetails pld : priceListDetailsList) {
			pld.setUom(uomService.getUom(priceListDetailsSearchRequest.getTenantId(), pld.getUom().getCode(),
					new RequestInfo()));
			pld.setMaterial(materialMap.get(pld.getMaterial().getCode()));
			if (pld.getQuantity() != null)
				pld.setQuantity(pld.getQuantity() / pld.getUom().getConversionFactor().doubleValue());
		}

		page.setTotalResults(priceListDetailsList.size());

		page.setPagedData(priceListDetailsList);

		return page;
	}

	public Pagination<?> getPagination(String searchQuery, Pagination<?> page, Map<String, Object> paramValues) {
		String countQuery = "select count(*) from (" + searchQuery + ") as x";
		Long count = namedParameterJdbcTemplate.queryForObject(countQuery.toString(), paramValues, Long.class);
		Integer totalpages = (int) Math.ceil((double) count / page.getPageSize());
		page.setTotalPages(totalpages);
		page.setCurrentPage(page.getOffset());
		return page;
	}

	private Map<String, Material> getMaterial(String tenantId, final ObjectMapper mapper, RequestInfo requestInfo) {
		JSONArray responseJSONArray = mdmsRepository.getByCriteria(tenantId, "store-asset", "Material", null, null,
				requestInfo);
		Map<String, Material> materialMap = new HashMap<>();

		if (responseJSONArray != null && responseJSONArray.size() > 0) {
			for (int i = 0; i < responseJSONArray.size(); i++) {
				Material material = mapper.convertValue(responseJSONArray.get(i), Material.class);
				materialMap.put(material.getCode(), material);
			}

		}
		return materialMap;
	}

	public void validateSortByOrder(final String sortBy) {
		List<String> sortByList = new ArrayList<String>();
		if (sortBy.contains(",")) {
			sortByList = Arrays.asList(sortBy.split(","));
		} else {
			sortByList = Arrays.asList(sortBy);
		}
		for (String s : sortByList) {
			if (s.contains(" ")
					&& (!s.toLowerCase().trim().endsWith("asc") && !s.toLowerCase().trim().endsWith("desc"))) {

				throw new CustomException(s.split(" ")[0],
						"Please send the proper sortBy order for the field " + s.split(" ")[0]);
			}
		}

	}

	public void validateEntityFieldName(String sortBy, final Class<?> object) {
		List<String> sortByList = new ArrayList<String>();
		if (sortBy.contains(",")) {
			sortByList = Arrays.asList(sortBy.split(","));
		} else {
			sortByList = Arrays.asList(sortBy);
		}
		Boolean isFieldExist = Boolean.FALSE;
		for (String s : sortByList) {
			for (int i = 0; i < object.getDeclaredFields().length; i++) {
				if (object.getDeclaredFields()[i].getName().equals(s.contains(" ") ? s.split(" ")[0] : s)) {
					isFieldExist = Boolean.TRUE;
					break;
				} else {
					isFieldExist = Boolean.FALSE;
				}
			}
			if (!isFieldExist) {
				throw new CustomException(s.contains(" ") ? s.split(" ")[0] : s, "Please send the proper Field Names ");

			}
		}

	}
}