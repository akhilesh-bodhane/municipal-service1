-- public.temporary_stall_application_detail definition

-- Drop table

-- DROP TABLE public.temporary_stall_application_detail;

CREATE TABLE public.temporary_stall_application_detail (
	id varchar(64) NOT NULL,
	applicationn_id varchar(64) NOT NULL,
	"name" varchar(255) NULL,
	mobile_no varchar(255) NULL,
	festival varchar(255) NULL,
	from_date varchar(20) NULL,
	to_date varchar(20) NULL,
	sector varchar(255) NULL,
	stall_size varchar(255) NULL,
	address_details varchar(255) NULL,
	landmark varchar(255) NULL,
	tenant_id varchar(256) NULL,
	total_amount int8 NULL,
	is_active bool NULL,
	created_by varchar(64) NULL,
	created_time varchar NULL,
	last_modified_by varchar(64) NULL,
	last_modified_time varchar NULL,
	no_o_days int8 NULL,
	fees_per_day int8 NULL,
	application_status varchar NULL,
	CONSTRAINT applicationn_id UNIQUE (applicationn_id),
	CONSTRAINT temporary_stall_application_detail_pkey PRIMARY KEY (id)
);


