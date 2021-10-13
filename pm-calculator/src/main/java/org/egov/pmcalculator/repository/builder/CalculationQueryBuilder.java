package org.egov.pmcalculator.repository.builder;

import org.springframework.stereotype.Component;

@Component
public class CalculationQueryBuilder {

	public static final String GET_PRICE_BOOK = "SELECT pb.calculation_sequence,pb.category_id,pb.sub_category_id,pb.sub_category_id, calculation_type, to_date(pb.effective_from_date::varchar, 'YYYY-MM-DD') effective_from_date,to_date(pb.effective_to_date::varchar, 'YYYY-MM-DD') effective_to_date,pb.min_sqft,pb.max_sqft,pb.perday_price,pb.perweek_price,pb.permonth_price,pb.annual_price, pb.fixed_price FROM egpm_noc_price_book pb WHERE pb.application_type=? AND to_date(?, 'YYYY-MM-DD') between pb.effective_from_date::date and COALESCE(pb.effective_to_date, current_date + 30000)::date AND CASE WHEN ?='true' THEN trim(pb.category_id)=trim(?) ELSE true=true END and trim(pb.tenant_id)=trim(?) ORDER BY pb.calculation_sequence";

}
