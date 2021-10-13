package org.egov.assets.repository.entity;

import java.math.BigDecimal;

import org.egov.assets.model.AuditDetails;
import org.egov.assets.model.Material;
import org.egov.assets.model.MaterialIssueDetail;
import org.egov.assets.model.Scrap;
import org.egov.assets.model.ScrapDetail;
import org.egov.assets.model.Uom;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ScrapDetailEntity {
	public static final String TABLE_NAME = "scrapDetail";
	public static final String SEQUENCE_NAME = "seq_scrapDetail";
	public static final String ALIAS = "scrapDetail";

	private String id;

	private String scrapNumber;

	private String material;

	private String uom;

	private String lotNumber;

	private Integer expiryDate;

	private String scrapReason;

	private String issuedetailid;

	private BigDecimal quantity;

	private BigDecimal scrapQuantity;

	private BigDecimal userQuantity;

	private BigDecimal disposalQuantity;

	private BigDecimal existingValue;

	private BigDecimal scrapValue;

	private String createdBy;

	private Long createdTime;

	private String lastModifiedBy;

	private Long lastModifiedTime;

	private String tenantId;

	public ScrapDetail toDomain() {
		ScrapDetail scrapDetail = new ScrapDetail();
		scrapDetail.setIssueDetail(new MaterialIssueDetail().id(issuedetailid));
		return scrapDetail.id(id).scrapNumber(scrapNumber).expiryDate(expiryDate).material(buildMaterial())
				.uom(new Uom().code(uom)).lotNumber(lotNumber)
				.scrapReason(ScrapDetail.ScrapReasonEnum.fromValue(scrapReason)).quantity(quantity)
				.scrapQuantity(scrapQuantity).userQuantity(userQuantity).disposalQuantity(disposalQuantity)
				.existingValue(existingValue).scrapValue(scrapValue).tenantId(tenantId);

	}

	private Material buildMaterial() {
		Material materials = new Material();
		return materials.code(this.material);
	}

	public ScrapDetailEntity toEntity(ScrapDetail scrapDetails) {
		if (scrapDetails.getId() != null)
			this.id = scrapDetails.getId();
		this.tenantId = scrapDetails.getTenantId();
		if (scrapDetails.getScrapNumber() != null)
			this.scrapNumber = scrapDetails.getScrapNumber();
		if (scrapDetails.getMaterial() != null)
			if (scrapDetails.getMaterial().getCode() != null) {
				this.material = scrapDetails.getMaterial().getCode();
			}
		if (scrapDetails.getUom() != null)
			if (scrapDetails.getUom().getCode() != null) {
				this.uom = scrapDetails.getUom().getCode();
			}
		if (scrapDetails.getLotNumber() != null)
			this.lotNumber = scrapDetails.getLotNumber();
		if (scrapDetails.getExpiryDate() != null)
			this.expiryDate = scrapDetails.getExpiryDate();
		if (scrapDetails.getScrapReason() != null)
			this.scrapReason = scrapDetails.getScrapReason().name();
		if (scrapDetails.getQuantity() != null)
			this.quantity = scrapDetails.getQuantity();
		if (scrapDetails.getDisposalQuantity() != null)
			this.disposalQuantity = scrapDetails.getDisposalQuantity();
		if (scrapDetails.getScrapValue() != null)
			this.scrapValue = scrapDetails.getScrapValue();
		return this;
	}

}
