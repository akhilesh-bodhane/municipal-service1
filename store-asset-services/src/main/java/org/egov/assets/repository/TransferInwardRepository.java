package org.egov.assets.repository;

import org.egov.assets.common.JdbcRepository;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class TransferInwardRepository extends JdbcRepository {
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public TransferInwardRepository(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

}
