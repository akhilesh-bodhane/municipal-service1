-- public.temporary_stall_application_document definition

-- Drop table

-- DROP TABLE public.temporary_stall_application_document;

CREATE TABLE public.temporary_stall_application_document (
	document_uuid varchar(64) NOT NULL,
	filestore_id varchar NOT NULL,
	id varchar(64) NOT NULL,
	document_type varchar(256) NOT NULL,
	tenant_id varchar(256) NULL,
	is_active bool NOT NULL,
	created_by varchar(64) NULL,
	created_time int8 NULL,
	last_modified_by varchar(256) NULL,
	last_modified_time int8 NULL,
	CONSTRAINT id_document_type UNIQUE (id, document_type, tenant_id),
	CONSTRAINT temporary_stall_application_document_pkey PRIMARY KEY (document_uuid)
);