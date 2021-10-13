CREATE TABLE public.egpm_noc_application
(
    application_uuid character varying(64) COLLATE pg_catalog."default" NOT NULL,
    tenant_id character varying(128) COLLATE pg_catalog."default",
    noc_number character varying(64) COLLATE pg_catalog."default",
    applicant_name character varying(255) COLLATE pg_catalog."default",
    house_number character varying(64) COLLATE pg_catalog."default",
    sector character varying(64) COLLATE pg_catalog."default",
    applied_date character varying(256) COLLATE pg_catalog."default",
    application_type character varying(64) COLLATE pg_catalog."default",
    application_status character varying(64) COLLATE pg_catalog."default",
    is_active boolean,
    created_by character varying(64) COLLATE pg_catalog."default",
    created_time bigint,
    last_modified_by character varying(64) COLLATE pg_catalog."default",
    last_modified_time bigint,
    amount numeric,
    paid_flag boolean,
    gst_amount numeric,
    total_amount numeric,
    performance_bank_guarantee numeric,
    CONSTRAINT egpm_noc_application_pkey PRIMARY KEY (application_uuid),
    CONSTRAINT uniq_noc_number UNIQUE (noc_number)

)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;