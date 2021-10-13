package org.egov.pm.repository.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.egov.pm.model.NOCApplicationDetail;
import org.egov.pm.model.NOCPriceBook;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class PriceRowMapper implements ResultSetExtractor<List<NOCPriceBook>> {

	@Override
	public List<NOCPriceBook> extractData(ResultSet rs) throws SQLException {

		Map<String, NOCPriceBook> NOCPriceBookMap = new LinkedHashMap<>();
		while (rs.next()) {

			
			NOCPriceBook NOCPriceBook = new NOCPriceBook();
			NOCPriceBook.setPriceBookId(rs.getString("price_book_id"));
				NOCPriceBook.setCategoryId(rs.getString("category_id"));
				NOCPriceBook.setTenantId(rs.getString("tenant_id"));
				NOCPriceBook.setSubCategoryId(rs.getString("sub_category_id"));
				NOCPriceBook.setPerDayPrice(rs.getLong("perday_price"));
				NOCPriceBook.setPerWeekPrice(rs.getLong("perweek_price"));
				NOCPriceBook.setPerMonthPrice(rs.getLong("permonth_price"));
				NOCPriceBook.setAnnualPrice(rs.getLong("annual_price"));
				NOCPriceBook.setFixedPrice(rs.getLong("fixed_price"));
				NOCPriceBook.setEffectiveFromDate(rs.getString("effective_from_date"));
				NOCPriceBook.setEffectiveToDate(rs.getString("effective_to_date"));
				NOCPriceBook.setCalculationSequence(rs.getInt("calculation_sequence"));
				NOCPriceBookMap.put(NOCPriceBook.getPriceBookId(), NOCPriceBook);
			
		}
		log.debug("converting map to list object ::: " + NOCPriceBookMap.values());
		return new ArrayList<>(NOCPriceBookMap.values());
	}

}
