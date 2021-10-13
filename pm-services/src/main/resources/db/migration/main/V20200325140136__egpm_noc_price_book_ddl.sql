CREATE TABLE public.egpm_noc_price_book
(
    price_book_id character varying(64) COLLATE pg_catalog."default" NOT NULL,
    application_type character varying(64) COLLATE pg_catalog."default",
    category_id character varying(64) COLLATE pg_catalog."default",
    sub_category_id character varying(64) COLLATE pg_catalog."default",
    min_sqft integer,
    max_sqft integer,
    perday_price numeric,
    perweek_price numeric,
    permonth_price numeric,
    annual_price numeric,
    fixed_price numeric,
    effective_from_date timestamp without time zone,
    effective_to_date timestamp without time zone,
    tenant_id character varying(128) COLLATE pg_catalog."default",
    is_active boolean,
    created_by character varying(64) COLLATE pg_catalog."default",
    created_time bigint,
    last_modified_by character varying(64) COLLATE pg_catalog."default",
    last_modified_time bigint,
    calculation_sequence integer,
    calculation_type character varying(50) COLLATE pg_catalog."default",
    CONSTRAINT egpm_noc_price_book_pkey PRIMARY KEY (price_book_id)
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;