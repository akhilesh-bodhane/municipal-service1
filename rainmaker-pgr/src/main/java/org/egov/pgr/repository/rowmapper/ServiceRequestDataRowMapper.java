package org.egov.pgr.repository.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.egov.pgr.contract.Address;
import org.egov.pgr.contract.ServiceRequestComplaints;
import org.egov.pgr.model.ActionInfo;
import org.egov.pgr.model.AuditDetails;
import org.egov.pgr.model.Service;
import org.egov.pgr.model.Service.StatusEnum;
import org.egov.pgr.model.user.Citizen;
import org.egov.tracer.model.CustomException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class ServiceRequestDataRowMapper implements ResultSetExtractor<List<ServiceRequestComplaints>> {

	@Autowired
	private ObjectMapper mapper;

	@Override
	public List<ServiceRequestComplaints> extractData(ResultSet rs) throws SQLException, DataAccessException {
		Map<String, ServiceRequestComplaints> map = new HashMap<>();
		try {

			while (rs.next()) {
				ServiceRequestComplaints serviceRequestComplaints = ServiceRequestComplaints.builder().build();

				Service service = new Service();
				service.setServiceRequestId(rs.getString("serviceRequestId"));
				service.setCategory(rs.getString("category"));
				service.setServiceCode(rs.getString("servicecode"));
				service.setStatus(StatusEnum.fromValue(rs.getString("status")));
				service.setSlaEndTime(
						rs.getString("slaendtime") != null ? Long.parseLong(rs.getString("slaendtime")) : 0L);
				service.setDescription(rs.getString("description"));
				service.setRating(rs.getString("rating"));

				service.setCitizen(Citizen.builder().name(rs.getString("name"))
						.mobileNumber(rs.getString("mobilenumber")).build());

				service.setAuditDetails(AuditDetails.builder().createdBy(rs.getString("createdby"))
						.createdTime(
								rs.getString("createdtime") != null ? Long.parseLong(rs.getString("createdtime")) : 0L)
						.lastModifiedBy(rs.getString("lastmodifiedby"))
						.lastModifiedTime(rs.getString("lastmodifiedtime") != null
								? Long.parseLong(rs.getString("lastmodifiedtime"))
								: 0L)
						.build());

				service.setAddressDetail(Address.builder().mohalla(rs.getString("mohalla")).build());

				// Action History
				if (rs.getString("actionHistory") != null) {
					List<ActionInfo> actionInfo = mapper.readValue(rs.getString("actionHistory"),
							new TypeReference<List<ActionInfo>>() {
							});
					if (actionInfo != null && !actionInfo.isEmpty())
						actionInfo = actionInfo.stream().sorted(new Comparator<ActionInfo>() {
							public int compare(ActionInfo o1, ActionInfo o2) {
								return o1.getWhen().compareTo(o2.getWhen());
							};
						}).collect(Collectors.toList());

					serviceRequestComplaints.setActionInfo(actionInfo);
				}
				serviceRequestComplaints.setService(service);
				map.put(service.getServiceRequestId(), serviceRequestComplaints);
			}

			return map.entrySet().stream().map(Map.Entry::getValue).collect(Collectors.toList());

		} catch (Exception e) {
			throw new CustomException("GRIEVENCE ERROR", e.getMessage());
		}
	}
}
