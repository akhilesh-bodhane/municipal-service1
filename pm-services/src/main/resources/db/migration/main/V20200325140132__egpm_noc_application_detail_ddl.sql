CREATE TABLE public.egpm_noc_application_detail
(
    application_detail_uuid character varying(64) COLLATE pg_catalog."default" NOT NULL,
    application_uuid character varying(64) COLLATE pg_catalog."default",
    application_detail json,
    is_active boolean,
    created_by character varying(64) COLLATE pg_catalog."default",
    created_time bigint,
    last_modified_by character varying(64) COLLATE pg_catalog."default",
    last_modified_time bigint,
    tenant_id character varying(128) COLLATE pg_catalog."default",
    CONSTRAINT egpm_noc_application_detail_pkey PRIMARY KEY (application_detail_uuid),
    CONSTRAINT fk_application_id FOREIGN KEY (application_uuid)
        REFERENCES public.egpm_noc_application (application_uuid) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;