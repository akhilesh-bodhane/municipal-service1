package org.egov.pm.repository.rowmapper;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.egov.pm.model.IUDXData;
import org.egov.pm.model.IUDXServiceData;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class IUDXDataRowMapper implements ResultSetExtractor<IUDXServiceData> {

	@Override
	public IUDXServiceData extractData(ResultSet rs) throws SQLException {
		IUDXServiceData iudxServiceData = IUDXServiceData.builder().build();

		while (rs.next()) {

			String applicationType = rs.getString("applicationType") != null ? rs.getString("applicationType") : "";
			Integer applicationCount = Integer
					.parseInt(rs.getString("applicationCount") == null ? "0" : rs.getString("applicationCount"));
			BigDecimal revenueCollected = new BigDecimal(
					rs.getString("revenueCollected") == null ? "0" : rs.getString("revenueCollected"));

			if (applicationType != null || applicationType.isEmpty()) {
				IUDXData iudxData = null;
				if (applicationType.trim().equalsIgnoreCase("PETNOC")) {
					iudxData = IUDXData.builder().applicationCount(applicationCount)
							.totalRevenueCollection(revenueCollected).build();
					iudxServiceData.setPetNoc(iudxData);
				}
				if (applicationType.trim().equalsIgnoreCase("SELLMEATNOC")) {
					iudxData = IUDXData.builder().applicationCount(applicationCount)
							.totalRevenueCollection(revenueCollected).build();
					iudxServiceData.setSellmeat(iudxData);
				}
				if (applicationType.trim().equalsIgnoreCase("ROADCUTNOC")) {
					iudxData = IUDXData.builder().applicationCount(applicationCount)
							.totalRevenueCollection(revenueCollected).build();
					iudxServiceData.setRoadcutNoc(iudxData);
				}
				if (applicationType != null && applicationType.trim().equalsIgnoreCase("ADVERTISEMENTNOC")) {
					iudxData = IUDXData.builder().applicationCount(applicationCount)
							.totalRevenueCollection(revenueCollected).build();
					iudxServiceData.setAdvertisementNoc(iudxData);
				}
				if (applicationType.trim().equalsIgnoreCase("UTROADCUTNOC")) {
					iudxData = IUDXData.builder().applicationCount(applicationCount)
							.totalRevenueCollection(revenueCollected).build();
					iudxServiceData.setUtroadcutNoc(iudxData);
				}
			}

		}
		return iudxServiceData;
	}

}
