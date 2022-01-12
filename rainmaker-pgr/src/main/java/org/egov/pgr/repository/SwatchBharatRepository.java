package org.egov.pgr.repository;

import java.util.ArrayList;
import java.util.List;

import org.egov.pgr.contract.SwatchBharatRequest;
import org.egov.pgr.model.SwatchBharat;
import org.egov.pgr.repository.rowmapper.SwatchBharatRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import lombok.extern.slf4j.Slf4j;

@Repository
@Slf4j
public class SwatchBharatRepository {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Autowired
	private SwatchBharatRowMapper swatchBharatRowMapper;

	public List<SwatchBharat> getDataFromDb(SwatchBharatRequest swatchBharatRequest) {
		List<Object> preparedStmtList = new ArrayList<>();

		String query = "SELECT uuid, useruuid, fileid, createdby, updatedby, isvalidimage, createddate, updateddate, username, workbookid \r\n"
				+ "FROM public.sb_workbook_doc ";

		StringBuilder queryBuilder = new StringBuilder(query);
		StringBuilder queryBuilderWhere = new StringBuilder();
		if (swatchBharatRequest.getSwatchBharatSearch() != null) {
			if (swatchBharatRequest.getSwatchBharatSearch().getFileid() != null
					&& !swatchBharatRequest.getSwatchBharatSearch().getFileid().isEmpty()) {
				queryBuilderWhere.append(" fileid = ")
						.append("'" + swatchBharatRequest.getSwatchBharatSearch().getFileid() + "'");
			} else {
				queryBuilderWhere.append("fileid = fileid");
			}
			if (swatchBharatRequest.getSwatchBharatSearch().getUseruuid() != null
					&& !swatchBharatRequest.getSwatchBharatSearch().getUseruuid().isEmpty()) {
				queryBuilderWhere.append(" AND useruuid = ")
						.append("'" + swatchBharatRequest.getSwatchBharatSearch().getUseruuid() + "'");
			} else {
				queryBuilderWhere.append(" AND useruuid = useruuid");
			}
			if (swatchBharatRequest.getSwatchBharatSearch().getUuid() != null
					&& !swatchBharatRequest.getSwatchBharatSearch().getUuid().isEmpty()) {
				queryBuilderWhere.append(" AND uuid = ")
						.append("'" + swatchBharatRequest.getSwatchBharatSearch().getUuid() + "'");
			} else {
				queryBuilderWhere.append(" AND uuid = uuid");
			}
		}

		if (queryBuilderWhere.length() > 0)
			queryBuilder.append(" WHERE ").append(queryBuilderWhere);

		log.info("Query: " + queryBuilder);

		List<SwatchBharat> swatchBharat = jdbcTemplate.query(queryBuilder.toString(), preparedStmtList.toArray(),
				swatchBharatRowMapper);
		return swatchBharat;
	}

}
