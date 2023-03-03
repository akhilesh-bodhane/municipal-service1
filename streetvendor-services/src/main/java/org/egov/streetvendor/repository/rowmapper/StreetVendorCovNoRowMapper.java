package org.egov.streetvendor.repository.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.egov.streetvendor.common.CommonConstants;
import org.egov.streetvendor.model.StreetVendorData;
import org.egov.tracer.model.CustomException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class StreetVendorCovNoRowMapper implements ResultSetExtractor<List<StreetVendorData>> {
	
	@Autowired
	private ObjectMapper mapper;

	@Override
	public List<StreetVendorData> extractData(ResultSet rs) throws SQLException, DataAccessException {
		List<StreetVendorData> StreetVendorDataList = new ArrayList<>();

		try {
			while (rs.next()) {
				
				StreetVendorData streetvendorDetails = new StreetVendorData();
				streetvendorDetails = StreetVendorData.builder().build();
				streetvendorDetails.setCovNo(rs.getString("cov_no"));
				
				StreetVendorDataList.add(streetvendorDetails);
			}

		} catch (Exception e) {
			throw new CustomException(CommonConstants.STREET_VENDOR_GET_EXCEPTION_CODE, e.getMessage());
		}
		return StreetVendorDataList;
	}

}
