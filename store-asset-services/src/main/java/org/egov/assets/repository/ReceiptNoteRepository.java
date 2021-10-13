package org.egov.assets.repository;

import org.egov.assets.common.JdbcRepository;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ReceiptNoteRepository extends JdbcRepository {
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public ReceiptNoteRepository(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

}
