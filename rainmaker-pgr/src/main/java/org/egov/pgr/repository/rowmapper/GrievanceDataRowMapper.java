package org.egov.pgr.repository.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.egov.pgr.model.Grievance;
import org.egov.tracer.model.CustomException;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Component;

@Component
public class GrievanceDataRowMapper implements ResultSetExtractor<List<Grievance>> {

	@Override
	public List<Grievance> extractData(ResultSet rs) throws SQLException, DataAccessException {
		Map<Integer, Grievance> map = new HashMap<>();
		try {

			while (rs.next()) {

				Grievance grievence = new Grievance();
				grievence.setSequencenum(Integer.parseInt(rs.getString("sequencenum")));

				grievence.setAllcomplaints(Integer.parseInt(rs.getString("allcomplaints")));
				grievence.setAssigned(Integer.parseInt(rs.getString("assigned")));
				grievence.setClosed(Integer.parseInt(rs.getString("closed")));
				grievence.setClosedcomplaints(Integer.parseInt(rs.getString("closedcomplaints")));
				grievence.setEscalatedlevel1pending(Integer.parseInt(rs.getString("escalatedlevel1pending")));
				grievence.setEscalatedlevel2pending(Integer.parseInt(rs.getString("escalatedlevel2pending")));
				grievence.setOpen(Integer.parseInt(rs.getString("open")));
				grievence.setReassignrequested(Integer.parseInt(rs.getString("reassignrequested")));
				grievence.setRejected(Integer.parseInt(rs.getString("rejected")));
				grievence.setReopen(Integer.parseInt(rs.getString("reopen")));
				grievence.setResolved(Integer.parseInt(rs.getString("resolved")));
				grievence.setResolvedcomplaints(Integer.parseInt(rs.getString("resolvedcomplaints")));

				grievence.setServicecode(rs.getString("servicecode"));
				grievence.setCategory(rs.getString("category"));
				grievence.setSource(rs.getString("source"));
				grievence.setStatus(rs.getString("status"));
				grievence.setTotalComplaints(Integer.parseInt(rs.getString("totalComplaints")));

				map.put(grievence.getSequencenum(), grievence);

			}

			return map.entrySet().stream().map(Map.Entry::getValue).collect(Collectors.toList());

		} catch (Exception e) {
			throw new CustomException("GRIEVENCE ERROR", e.getMessage());
		}
	}
}
