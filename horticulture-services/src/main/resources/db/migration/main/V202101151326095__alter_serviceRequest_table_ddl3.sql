ALTER TABLE eg_hc_service_request
ADD COLUMN sla integer;
ALTER TABLE eg_hc_service_request
ADD COLUMN sla_days_elapsed integer;
ALTER TABLE eg_hc_service_request
ADD COLUMN sla_modified_date date;

create or replace function hc_calculate_sla(from_date date, to_date date)
returns int
as $fbd$
    select count(d::date)::int as d
    from generate_series(from_date, to_date, '1 day'::interval) d
    where extract('dow' from d) not in (0, 6) 
$fbd$ language sql;
