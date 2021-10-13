package org.egov.ec.repository.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.egov.ec.web.models.Document;
import org.egov.ec.web.models.EcPayment;
import org.egov.ec.web.models.Violation;
import org.egov.ec.web.models.ViolationItem;
import org.egov.tracer.model.CustomException;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Component;

@Component
public class ViolationDetailRowMapper implements ResultSetExtractor<List<Violation>> {

	@Override
	public List<Violation> extractData(ResultSet rs) throws SQLException, DataAccessException {

		Map<String, Violation> violationMap = new LinkedHashMap<>();
		ArrayList<Document> listtoaddDoc = new ArrayList<Document>();
		ArrayList<ViolationItem> listtoaddItem = new ArrayList<ViolationItem>();
		EcPayment ecPayment=new EcPayment();

		try {
			while (rs.next()) {

				String violationUuid = rs.getString("violation_uuid");
				if (violationMap.containsKey(violationUuid)) {
					// JSONArray aa = (JSONArray) jsonParser.parse(rs.getString(columnLabel));

					Violation violation = Violation.builder().violationUuid(violationUuid)
							.violationUuid(
									(rs.getString("violation_uuid") == null ? "" : rs.getString("violation_uuid")))
							.tenantId((rs.getString("tenant_id") == null ? "" : rs.getString("tenant_id")))
							.numberOfViolation((rs.getString("number_of_violation") == null ? ""
									: rs.getString("number_of_violation")))
							.challanId((rs.getString("challan_id") == null ? "" : rs.getString("challan_id")))
							.encroachmentType((rs.getString("encroachment_type") == null ? ""
									: rs.getString("encroachment_type")))
							.violationDate(
									(rs.getString("violation_date") == null ? "" : rs.getString("violation_date")))
							.violationTime(
									(rs.getString("violation_time") == null ? "" : rs.getString("violation_time")))
							.violatorName((rs.getString("violator_name") == null ? "" : rs.getString("violator_name")))
							.sector((rs.getString("sector") == null ? "" : rs.getString("sector")))
							.address((rs.getString("address") == null ? "" : rs.getString("address")))
							.emailId((rs.getString("email_id") == null ? "" : rs.getString("email_id")))
							.fatherName((rs.getString("father_name") == null ? "" : rs.getString("father_name")))
							.contactNumber(
									(rs.getString("contact_number") == null ? "" : rs.getString("contact_number")))
							.licenseNoCov(
									(rs.getString("license_no_cov") == null ? "" : rs.getString("license_no_cov")))
							.natureOfViolation((rs.getString("nature_of_violation") == null ? ""
									: rs.getString("nature_of_violation")))
							.location((rs.getString("location") == null ? "" : rs.getString("location")))
							.challanAmount((rs.getString("fineamount"))).penaltyAmount((rs.getString("penaltyamount")))
							.totalChallanAmount((rs.getString("challan_amount")))
							.siName((rs.getString("si_name") == null ? "" : rs.getString("si_name")))
							.status((rs.getString("challan_status") == null ? "" : rs.getString("challan_status")))
							.isActive((rs.getBoolean("is_active")))
							.createdBy((rs.getString("created_by") == null ? "" : rs.getString("created_by")))
							.createdTime((rs.getLong("created_time")))
							.lastModifiedBy(
									(rs.getString("last_modified_by") == null ? "" : rs.getString("last_modified_by")))
							.lastModifiedTime((rs.getLong("last_modified_time")))
							.challanUuid(rs.getString("challan_uuid") == null ? "" : rs.getString("challan_uuid"))
							.build();
					
					ecPayment.setPaymentUuid(rs.getString("payment_uuid"));
					ecPayment.setPaymentStatus(rs.getString("payment_status"));
					ecPayment.setPaymentMode(rs.getString("payment_mode"));
					ecPayment.setLastModifiedTime(rs.getLong("last_modified_time"));
					ecPayment.setPaymentAmount(rs.getString("payment_amount"));
					ecPayment.setPaymentGateway(rs.getString("payment_gateway"));

					String docUuid = rs.getString("document_uuid");
					if(docUuid != null) 
					{
					List<Document> listRedundantDoc = listtoaddDoc.stream()
							.filter(p -> p.getDocumentUuid().equals(docUuid)).collect(Collectors.toList());
					if (listRedundantDoc.isEmpty()) {
						Document doc = new Document();
						doc.setChallanId(rs.getString("challan_id"));
						doc.setCreatedBy(rs.getString("created_by"));
						doc.setCreatedTime(rs.getLong("created_time"));
						doc.setDocumentType(rs.getString("document_type"));
						doc.setDocumentUuid(rs.getString("document_uuid"));
						doc.setFileStoreId(rs.getString("filestore_id"));
						doc.setIsActive(rs.getBoolean("is_active"));
						doc.setLastModifiedBy(rs.getString("last_modified_by"));
						doc.setLastModifiedTime(rs.getLong("last_modified_time"));
						doc.setTenantId(rs.getString("tenant_id"));
						doc.setViolationUuid(rs.getString("violation_uuid"));

						listtoaddDoc.add(doc);
					}
					}

					

					String violationItemUuid = rs.getString("violation_item_uuid");
					List<ViolationItem> listRedundantItem = listtoaddItem.stream()
							.filter(p -> p.getViolationItemUuid().equals(violationItemUuid))
							.collect(Collectors.toList());

					if (listRedundantItem.isEmpty()) {
						ViolationItem violationItem = new ViolationItem();
						violationItem.setViolationItemUuid(rs.getString("violation_item_uuid"));
						violationItem.setViolationUuid(rs.getString("violation_uuid"));
						violationItem.setItemName(rs.getString("item_name"));
						violationItem.setItemType(rs.getString("item_type"));
						violationItem.setItemUuid(rs.getString("item_uuid"));
						violationItem.setQuantity(rs.getInt("quantity"));
						violationItem.setIsActive(rs.getBoolean("is_active"));
						violationItem.setCreatedBy(rs.getString("created_by"));
						violationItem.setCreatedTime(rs.getLong("created_time"));
						violationItem.setLastModifiedBy(rs.getString("last_modified_by"));
						violationItem.setLastModifiedTime(rs.getLong("last_modified_time"));
						violationItem.setRemark(rs.getString("remark"));
						violationItem.setTenantId(rs.getString("tenant_id"));
						violationItem.setVehicleNumber(rs.getString("vehicle_number"));

						listtoaddItem.add(violationItem);
					}

					violation.setViolationItem(listtoaddItem);
					violation.setDocument(listtoaddDoc);
					violation.setPaymentDetails(ecPayment);
					violationMap.put(violationUuid, violation);

				} else {
					listtoaddDoc = new ArrayList<Document>();
					listtoaddItem = new ArrayList<ViolationItem>();
					ecPayment=new EcPayment();

					Violation violation = Violation.builder().violationUuid(violationUuid)
							.violationUuid(
									(rs.getString("violation_uuid") == null ? "" : rs.getString("violation_uuid")))
							.tenantId((rs.getString("tenant_id") == null ? "" : rs.getString("tenant_id")))
							.numberOfViolation((rs.getString("number_of_violation") == null ? ""
									: rs.getString("number_of_violation")))
							.challanId((rs.getString("challan_id") == null ? "" : rs.getString("challan_id")))
							.encroachmentType((rs.getString("encroachment_type") == null ? ""
									: rs.getString("encroachment_type")))
							.violationDate(
									(rs.getString("violation_date") == null ? "" : rs.getString("violation_date")))
							.violationTime(
									(rs.getString("violation_time") == null ? "" : rs.getString("violation_time")))
							.violatorName((rs.getString("violator_name") == null ? "" : rs.getString("violator_name")))
							.sector((rs.getString("sector") == null ? "" : rs.getString("sector")))
							.address((rs.getString("address") == null ? "" : rs.getString("address")))
							.emailId((rs.getString("email_id") == null ? "" : rs.getString("email_id")))
							.fatherName((rs.getString("father_name") == null ? "" : rs.getString("father_name")))
							.contactNumber(
									(rs.getString("contact_number") == null ? "" : rs.getString("contact_number")))
							.licenseNoCov(
									(rs.getString("license_no_cov") == null ? "" : rs.getString("license_no_cov")))
							.natureOfViolation((rs.getString("nature_of_violation") == null ? ""
									: rs.getString("nature_of_violation")))
							.location((rs.getString("location") == null ? "" : rs.getString("location")))
							.challanAmount((rs.getString("fineamount"))).penaltyAmount((rs.getString("penaltyamount")))
							.totalChallanAmount((rs.getString("challan_amount")))
							.siName((rs.getString("si_name") == null ? "" : rs.getString("si_name")))
							.status((rs.getString("challan_status") == null ? "" : rs.getString("challan_status")))
							.isActive((rs.getBoolean("is_active")))
							.createdBy((rs.getString("created_by") == null ? "" : rs.getString("created_by")))
							.createdTime((rs.getLong("created_time")))
							.lastModifiedBy(
									(rs.getString("last_modified_by") == null ? "" : rs.getString("last_modified_by")))
							.lastModifiedTime((rs.getLong("last_modified_time")))
							.challanUuid(rs.getString("challan_uuid") == null ? "" : rs.getString("challan_uuid"))
							.build();

					// Document List

					ecPayment.setPaymentUuid(rs.getString("payment_uuid"));
					ecPayment.setPaymentStatus(rs.getString("payment_status"));
					ecPayment.setPaymentMode(rs.getString("payment_mode"));
					ecPayment.setLastModifiedTime(rs.getLong("last_modified_time"));
					ecPayment.setPaymentAmount(rs.getString("payment_amount"));
					ecPayment.setPaymentGateway(rs.getString("payment_gateway"));
					
					Document doc = new Document();
					doc.setChallanId(rs.getString("challan_id"));
					doc.setCreatedBy(rs.getString("created_by"));
					doc.setCreatedTime(rs.getLong("created_time"));
					doc.setDocumentType(rs.getString("document_type"));
					doc.setDocumentUuid(rs.getString("document_uuid"));
					doc.setFileStoreId(rs.getString("filestore_id"));
					doc.setIsActive(rs.getBoolean("is_active"));
					doc.setLastModifiedBy(rs.getString("last_modified_by"));
					doc.setLastModifiedTime(rs.getLong("last_modified_time"));
					doc.setTenantId(rs.getString("tenant_id"));
					doc.setViolationUuid(rs.getString("violation_uuid"));

					listtoaddDoc.add(doc);

					// violation Item

					ViolationItem violationItem = new ViolationItem();
					violationItem.setViolationItemUuid(rs.getString("violation_item_uuid"));
					violationItem.setViolationUuid(rs.getString("violation_uuid"));
					violationItem.setItemName(rs.getString("item_name"));
					violationItem.setItemType(rs.getString("item_type"));
					violationItem.setItemUuid(rs.getString("item_uuid"));
					violationItem.setQuantity(rs.getInt("quantity"));
					violationItem.setIsActive(rs.getBoolean("is_active"));
					violationItem.setCreatedBy(rs.getString("created_by"));
					violationItem.setCreatedTime(rs.getLong("created_time"));
					violationItem.setLastModifiedBy(rs.getString("last_modified_by"));
					violationItem.setLastModifiedTime(rs.getLong("last_modified_time"));
					violationItem.setRemark(rs.getString("remark"));
					violationItem.setTenantId(rs.getString("tenant_id"));
					violationItem.setVehicleNumber(rs.getString("vehicle_number"));

					listtoaddItem.add(violationItem);

					violation.setDocument(listtoaddDoc);
					violation.setViolationItem(listtoaddItem);
					violation.setPaymentDetails(ecPayment);
					violationMap.put(violationUuid, violation);

				}
			}

		} catch (Exception e) {
			throw new CustomException("GET_VIOLATION_EXCEPTION", e.getMessage());
		}
		return new ArrayList<>(violationMap.values());
	}

}