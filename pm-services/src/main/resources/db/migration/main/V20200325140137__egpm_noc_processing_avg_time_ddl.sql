CREATE TABLE public.egpm_noc_report_avgproctime_aggregate
(
    sequence_id serial NOT NULL,
    application_type character varying(50) COLLATE pg_catalog."default" NOT NULL,
    tenant_id character varying(5) COLLATE pg_catalog."default" NOT NULL,
    total_average numeric(4,0) NOT NULL,
    total_avg_pending_10days_to_30days numeric(4,0) NOT NULL,
    total_avg_pending_greater_than30days numeric(4,0) NOT NULL,
    report_generation_datetime timestamp without time zone,
    dimension_type smallint,
    CONSTRAINT egpm_no_processing_avg_time_pkey PRIMARY KEY (sequence_id)
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;