CREATE TABLE eg_pgr_autorouting_data(
  id character varying(256),
  tenantId character varying(256),
  autorouting JSONB,
  createdby character varying(256) NOT NULL,
  createdtime bigint NOT NULL,
  lastmodifiedby character varying(256),
  lastmodifiedtime bigint,
  active boolean,
  CONSTRAINT pk_eg_pgr_autorouting_data PRIMARY KEY (id)
);