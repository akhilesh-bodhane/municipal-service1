package org.egov.assets.repository.entity;

import org.egov.assets.model.AuditDetails;
import org.egov.assets.model.Material;
import org.egov.assets.model.PriceListDetails;
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
public class PriceListDetailsEntity {
	
    public static final String TABLE_NAME = "pricelistdetails";
    public static final String SEQUENCE_NAME = "seq_pricelistdetails";
    public static final String ALIAS = "pricelistdetails";

    protected String createdBy;
    
    private String id;
    
    private String material;
    
    private String priceList;
    
    private Double ratePerUnit;
    
    private Double quantity;
    
    private String uom;
    
    private Long fromDate;
    
    private Long toDate;
    
    private Boolean active;
    
    private Boolean deleted;
    
    private String tenantId;

    private String lastModifiedBy;

    private Long createdTime;

    private Long lastModifiedTime;

    public PriceListDetails toDomain() {
        return PriceListDetails.builder()
                .id(id)
                .material(getMaterial(material))
                .uom(getUom(uom))
                .quantity(quantity)
                .ratePerUnit(ratePerUnit)
                .fromDate(fromDate)
                .toDate(toDate)
                .active(null != active ? active : null )
                .auditDetails(mapAuditDetails(tenantId, createdBy, createdTime, lastModifiedBy, lastModifiedTime))
                .build();
    }

    private Material getMaterial(String id) {
    	Material material = new Material();
    	material.setCode(id);
        return material;
    }
    
    private Uom getUom(String id) {
    	Uom uom = new Uom();
    	uom.setCode(id);
        return uom;
    }
    
    private AuditDetails mapAuditDetails(String tenantId, String createdBy, Long createdTime, String lastModifiedBy, Long lastModifiedTime) {
        return AuditDetails.builder()
                .createdBy(createdBy)
                .createdTime(createdTime)
                .lastModifiedBy(lastModifiedBy)
                .lastModifiedTime(lastModifiedTime)
                .build();
    }
}
