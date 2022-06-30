-- public.sterilization_dog_application_document definition

-- Drop table

-- DROP TABLE public.sterilization_dog_application_document;

CREATE TABLE public.sterilization_dog_application_document (
	document_uuid varchar(64) NOT NULL,
	pick_filestore_id varchar NOT NULL,
	pick_picture varchar(256) NOT NULL,
	id varchar(64) NOT NULL,
	drop_filestore_id varchar NULL,
	drop_picture varchar(256) NULL,
	tenant_id varchar(256) NULL,
	is_active bool NOT NULL,
	created_by varchar(64) NULL,
	created_time int8 NULL,
	last_modified_by varchar(256) NULL,
	last_modified_time int8 NULL,
	CONSTRAINT id_doc_type UNIQUE (id, pick_picture, tenant_id),
	CONSTRAINT sterilization_dog_application_document_pkey PRIMARY KEY (document_uuid)
);