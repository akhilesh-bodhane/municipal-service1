

CREATE TABLE public.eg_pgr_discription_report
(
  lastassignedto character varying(256),
  servicecode character varying(256),
  locality character varying(256),
  complaintno character varying(256),
  date character varying(256),
  name character varying(256),
  phone character varying(256),
  landmark character varying(2000),
  address character varying(256),
  description character varying(1000),
  complaintraisedby character varying(256),
  slahours character varying(256),
  lastactiondate character varying(256),
  status character varying(256),
  autoescalated character varying(256),
  department character varying(256),
  servicerequestid character varying(256),
  tenantid character varying(256),
  slaendtime bigint,
  createdtime bigint NOT NULL,
  source character varying(256),
  CONSTRAINT uk_eg_pgr_discription_report UNIQUE (servicerequestid, tenantid)
)
