package org.egov.assets.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.egov.assets.model.PurchaseIndentDetail;
import org.egov.assets.repository.entity.PurchaseIndentDetailEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class PurchaseIndentDetailJdbcRepository extends org.egov.assets.common.JdbcRepository {
	private static final Logger LOG = LoggerFactory.getLogger(PurchaseIndentDetailJdbcRepository.class);

	static {
		LOG.debug("init purchase order");
		init(PurchaseIndentDetailEntity.class);
		LOG.debug("end init purchase order");
	}

	public PurchaseIndentDetailJdbcRepository(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
		this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
	}

	public PurchaseIndentDetailEntity create(PurchaseIndentDetailEntity entity) {
		super.create(entity);
		return entity;
	}

	public PurchaseIndentDetailEntity update(PurchaseIndentDetailEntity entity) {
		super.update(entity);
		return entity;

	}

	public boolean delete(PurchaseIndentDetailEntity entity, String reason) {
		super.delete(entity, reason);
		return true;

	}

	public PurchaseIndentDetail findById(PurchaseIndentDetailEntity entity) {
		List<String> list = allIdentitiferFields.get(entity.getClass().getSimpleName());

		Map<String, Object> paramValues = new HashMap<>();

		for (String s : list) {
			paramValues.put(s, getValue(getField(entity, s), entity));
		}

		System.out.println("Qouryr :::: " + getByIdQuery.get(entity.getClass().getSimpleName()).toString());

		List<PurchaseIndentDetailEntity> poIndentDetails = namedParameterJdbcTemplate.query(
				getByIdQuery.get(entity.getClass().getSimpleName()).toString(), paramValues,
				new BeanPropertyRowMapper(PurchaseIndentDetailEntity.class));

		if (poIndentDetails.isEmpty()) {
			return null;
		} else {
			return poIndentDetails.get(0).toDomain();
		}

	}

	public PurchaseIndentDetail findByPODetailId(PurchaseIndentDetailEntity entity) {
		String query = "select * from  PurchaseIndentDetail where  purchaseorderdetail=:purchaseorderdetail and tenantId=:tenantId ";
		Map<String, Object> paramValues = new HashMap<>();

		if (entity.getTenantId().isEmpty() || entity.getPurchaseOrderDetail().isEmpty())
			return null;

		if (entity.getTenantId() != null) {
			paramValues.put("tenantId", entity.getTenantId());
		}
		if (entity.getPurchaseOrderDetail() != null) {
			paramValues.put("purchaseorderdetail", entity.getPurchaseOrderDetail());
		}

		List<PurchaseIndentDetailEntity> poIndentDetails = namedParameterJdbcTemplate.query(query, paramValues,
				new BeanPropertyRowMapper(PurchaseIndentDetailEntity.class));

		if (poIndentDetails.isEmpty()) {
			return null;
		} else {
			return poIndentDetails.get(0).toDomain();
		}

	}
}