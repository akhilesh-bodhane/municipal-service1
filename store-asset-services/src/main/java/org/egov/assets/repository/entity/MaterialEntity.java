package org.egov.assets.repository.entity;

import lombok.*;

import java.math.BigDecimal;

import org.egov.assets.model.AssetCategory;
import org.egov.assets.model.AuditDetails;
import org.egov.assets.model.ChartOfAccount;
import org.egov.assets.model.Material;
import org.egov.assets.model.Material.InventoryTypeEnum;
import org.egov.assets.model.Material.MaterialClassEnum;
import org.egov.assets.model.Material.StatusEnum;
import org.egov.assets.model.MaterialType;
import org.egov.assets.model.Uom;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MaterialEntity {

	public static final String TABLE_NAME = "material";
	public static final String SEQUENCE_NAME = "seq_material";
	public static final String ALIAS = "material";

	private String id;
	private String code;
	private String name;
	private String description;
	private String oldCode;
	private String materialType;
	private String baseUom;
	private String inventoryType;
	private String status;
	private String purchaseUom;
	private String expenseAccount;
	private Long minQuantity;
	private Long maxQuantity;
	private String stockingUom;
	private String materialClass;
	private Long reorderLevel;
	private Long reorderQuantity;
	private Boolean lotcontrol;
	private Boolean shelfLifeControl;
	private Boolean serialNumber;
	private Boolean scrapable;
	private String assetcategory;
	private String model;
	private String manufacturePartNo;
	private String techincalSpecs;
	private String termsOfDelivery;
	private String tenantId;
	private String lastModifiedBy;
	private Long createdTime;
	private String createdBy;
	private Long lastModifiedTime;

	public Material toDomain() {
		return Material.builder().id(id).code(code).minQuantity(BigDecimal.valueOf(minQuantity))
				.maxQuantity(BigDecimal.valueOf(maxQuantity)).reorderLevel(BigDecimal.valueOf(reorderLevel))
				.reorderQuantity(BigDecimal.valueOf(reorderQuantity))
				.assetCategory(new AssetCategory().code(assetcategory)).baseUom(new Uom().code(baseUom)).code(code)
				.description(description).expenseAccount(new ChartOfAccount().glcode(expenseAccount))
				.lotControl(lotcontrol).manufacturePartNo(manufacturePartNo)
				.materialType(new MaterialType().code(materialType)).model(model).name(name).oldCode(oldCode)
				.purchaseUom(new Uom().code(purchaseUom)).scrapable(scrapable).serialNumber(serialNumber)
				.shelfLifeControl(shelfLifeControl)
				.status((StatusEnum.ACTIVE.toString().equals(status) ? StatusEnum.ACTIVE
						: StatusEnum.INACTIVE.toString().equals(status) ? StatusEnum.INACTIVE
								: StatusEnum.WITHDRAWN.toString().equals(status) ? StatusEnum.WITHDRAWN
										: StatusEnum.OBSOLETE.toString().equals(status) ? StatusEnum.OBSOLETE : null))
				.materialClass((MaterialClassEnum.HIGHUSAGE.toString().equals(materialClass)
						? MaterialClassEnum.HIGHUSAGE
						: MaterialClassEnum.MEDIUMUSAGE.toString().equals(materialClass) ? MaterialClassEnum.MEDIUMUSAGE
								: MaterialClassEnum.LOWUSAGE.toString().equals(materialClass)
										? MaterialClassEnum.LOWUSAGE
										: null))
				.inventoryType((InventoryTypeEnum.ASSET.toString().equals(materialClass) ? InventoryTypeEnum.ASSET
						: InventoryTypeEnum.CONSUMABLE.toString().equals(inventoryType) ? InventoryTypeEnum.CONSUMABLE
								: null))

				.stockingUom(new Uom().code(stockingUom)).techincalSpecs(techincalSpecs).tenantId(tenantId)
				.termsOfDelivery(termsOfDelivery).auditDetails(mapAuditDetails()).build();
	}

	public MaterialEntity toEntity(Material material) {
		return MaterialEntity.builder().id(material.getId())
				.assetcategory(null != material.getAssetCategory() ? material.getAssetCategory().getCode() : null)
				.baseUom(material.getBaseUom().getCode()).code(material.getCode())
				.description(material.getDescription())
				.expenseAccount(null != material.getExpenseAccount() ? material.getExpenseAccount().getGlcode() : null)
				.inventoryType(null != material.getInventoryType() ? material.getInventoryType().toString() : null)
				.lotcontrol(material.getLotControl()).manufacturePartNo(material.getManufacturePartNo())
				.materialClass(null != material.getMaterialClass() ? material.getMaterialClass().toString() : null)
				.materialType(null != material.getMaterialType() ? material.getMaterialType().getCode() : null)
				.maxQuantity(null != material.getMaxQuantity() ? material.getMaxQuantity().longValue() : null)
				.minQuantity(null != material.getMinQuantity() ? material.getMinQuantity().longValue() : null)
				.model(material.getModel()).name(material.getName()).oldCode(material.getOldCode())
				.purchaseUom(null != material.getPurchaseUom() ? material.getPurchaseUom().getCode() : null)
				.reorderLevel(null != material.getReorderLevel() ? material.getReorderLevel().longValue() : null)
				.reorderQuantity(
						null != material.getReorderQuantity() ? material.getReorderQuantity().longValue() : null)
				.scrapable(material.getScrapable()).serialNumber(material.getSerialNumber())
				.shelfLifeControl(material.getShelfLifeControl())
				.status(null != material.getStatus() ? material.getStatus().toString() : null)
				.stockingUom(null != material.getStockingUom() ? material.getStockingUom().getCode() : null)
				.techincalSpecs(material.getTechincalSpecs()).tenantId(material.getTenantId())
				.termsOfDelivery(material.getTermsOfDelivery()).build();
	}

	private AuditDetails mapAuditDetails() {
		return AuditDetails.builder().createdBy(createdBy).createdTime(createdTime).lastModifiedBy(lastModifiedBy)
				.lastModifiedTime(lastModifiedTime).build();
	}
}
