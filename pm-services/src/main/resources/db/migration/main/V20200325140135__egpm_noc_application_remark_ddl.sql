CREATE TABLE public.egpm_noc_application_remark
(
    remark_id character varying(64) COLLATE pg_catalog."default" NOT NULL,
    application_uuid character varying(64) COLLATE pg_catalog."default",
    application_status character varying(64) COLLATE pg_catalog."default",
    remark character varying(255) COLLATE pg_catalog."default",
    remark_by character varying(64) COLLATE pg_catalog."default",
    is_active boolean,
    created_by character varying(64) COLLATE pg_catalog."default",
    created_time bigint,
    last_modified_by character varying(64) COLLATE pg_catalog."default",
    last_modified_time bigint,
    document_detail json,
    tenant_id character varying(128) COLLATE pg_catalog."default",
    processing_days_count integer,
    CONSTRAINT egpm_noc_application_remark_pkey PRIMARY KEY (remark_id),
    CONSTRAINT "FK_application_uuid" FOREIGN KEY (application_uuid)
        REFERENCES public.egpm_noc_application (application_uuid) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

CREATE INDEX "fki_FK_application_uuid"
    ON public.egpm_noc_application_remark USING btree
    (application_uuid COLLATE pg_catalog."default")
    TABLESPACE pg_default;