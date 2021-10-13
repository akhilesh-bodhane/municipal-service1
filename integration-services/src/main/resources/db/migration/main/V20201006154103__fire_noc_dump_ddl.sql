create table fire_noc_dump(
uuid character varying(64) NOT NULL,
data jsonb ,
is_active boolean,
  created_by character varying(64) NOT NULL,
  created_time bigint,
  last_modified_by character varying(64),
  last_modified_time bigint
)