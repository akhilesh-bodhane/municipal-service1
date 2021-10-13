alter table employee_post_detail_map add column org_unit_id character varying(64);
alter table employee_post_detail_map add  CONSTRAINT employee_post_detail_map_pkey PRIMARY KEY ( uuid);