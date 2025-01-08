CREATE TABLE egec_item_master (
    item_uuid varchar(64) primary key,
	item_name varchar(256) not null,
	description varchar(256) not null,
	approval_status varchar(64) not null,
	tenant_id varchar(256),
	is_active boolean not null,
	created_by varchar(64),
	created_time bigint not null,
	last_modified_by varchar(256),
	last_modified_time bigint not null,
	source_uuid varchar(64),
	CONSTRAINT uk_egec_item_master UNIQUE (item_name)
);

CREATE TABLE egec_fine_master (   
    fine_uuid varchar(64) primary key,
	encroachment_type varchar(256) not null,
	number_of_violation varchar(256) not null,
	penalty_amount numeric(18,2) not null,
	storage_charges numeric(18,2) not null,
	approval_status varchar(64) not null,	
	tenant_id varchar(256),
	is_active boolean not null,
	effective_start_date date,
	effective_end_date date,
	created_by varchar(64),
	created_time bigint not null,
	last_modified_by varchar(256),
	last_modified_time bigint not null,
	source_uuid varchar(64)	
);

CREATE TABLE public.egec_vendor_registration_master
(
  vendor_uuid character varying(64) PRIMARY KEY,
  pass_no character varying(64),
  cov_no character varying(64) NOT NULL,
  name character varying(256) NOT NULL,
  father_spouse_name character varying(256),
  address character varying(512),
  contact_number character varying(20) NOT NULL,
  vendor_category character varying(64),
  street_vendor_area character varying(256),
  transport_mode character varying(64),
  tenant_id character varying(256),
  is_active boolean NOT NULL,
  created_by character varying(64),
  created_time bigint NOT NULL,
  last_modified_by character varying(256),
  last_modified_time bigint NOT NULL,
  source_uuid character varying(64)
);

CREATE TABLE public.egec_violation_master
(
  violation_uuid character varying(64) PRIMARY KEY,
  violator_name character varying(256) NOT NULL,
  contact_number character varying(50),
  email_id character varying(50),
  father_name character varying(256),
  number_of_violation character varying(256) NOT NULL,
  address character varying(512),
  sector character varying(64) NOT NULL,
  violation_date date NOT NULL,
  violation_time time without time zone NOT NULL,
  license_no_cov character varying(256),
  nature_of_violation character varying(256),
  location character varying(256) NOT NULL,
  encroachment_type character varying(256) NOT NULL,
  si_name character varying(256) NOT NULL,
  tenant_id character varying(256),
  is_active boolean NOT NULL,
  created_by character varying(64),
  created_time bigint NOT NULL,
  last_modified_by character varying(256),
  last_modified_time bigint NOT NULL,
  source_uuid character varying(64)
  );
  
  CREATE TABLE public.egec_challan_master
(
  challan_uuid character varying(64) PRIMARY KEY,
  violation_uuid character varying(64) NOT NULL,
  challan_id character varying(256) NOT NULL,
  challan_amount numeric(18,2) NOT NULL,
  challan_status character varying(256) NOT NULL,
  tenant_id character varying(256),
  is_active boolean NOT NULL,
  created_by character varying(64),
  created_time bigint NOT NULL,
  last_modified_by character varying(256),
  last_modified_time bigint NOT NULL,
  CONSTRAINT fk_egec_challan_detail_violation_uuid FOREIGN KEY (violation_uuid)
      REFERENCES public.egec_violation_master (violation_uuid) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
);
 
 CREATE TABLE public.egec_challan_detail
(
  challan_detail_uuid character varying(64) PRIMARY KEY,
  challan_uuid character varying(64) NOT NULL,
  budget_head character varying(256) NOT NULL,
  head_amount numeric(18,2) NOT NULL,
  tenant_id character varying(256),
  is_active boolean NOT NULL,
  created_by character varying(64),
  created_time bigint NOT NULL,
  last_modified_by character varying(256),
  last_modified_time bigint NOT NULL,
  CONSTRAINT fk_egec_challan_detail_challan_uuid FOREIGN KEY (challan_uuid)
      REFERENCES public.egec_challan_master (challan_uuid) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
);


  
CREATE TABLE public.egec_violation_detail
(
  violation_item_uuid character varying(64) PRIMARY KEY,
  violation_uuid character varying(64) NOT NULL,
  item_uuid character varying(64),
  item_name character varying(256) NOT NULL,
  item_type character varying(64),
  quantity bigint NOT NULL,
  remark character varying(256),
  vehicle_number character varying(64),
  tenant_id character varying(256),
  is_active boolean NOT NULL,
  created_by character varying(64),
  created_time bigint NOT NULL,
  last_modified_by character varying(256),
  last_modified_time bigint NOT NULL,
  CONSTRAINT fk_egec_violation_item_violation_uuid FOREIGN KEY (violation_uuid)
      REFERENCES public.egec_violation_master (violation_uuid) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
);

CREATE TABLE public.egec_store_item_register
(
  store_item_uuid character varying(64) PRIMARY KEY,
  item_uuid character varying(64),
  item_name character varying(256) NOT NULL,
  quantity bigint NOT NULL,
  auctioned_quantity bigint,
  isverified boolean NOT NULL,
  isauctioned boolean NOT NULL,
  remark character varying(256),
  isreturned boolean,
  item_store_deposit_date date NOT NULL,
  violation_item_uuid character varying(64) NOT NULL,
  violation_uuid character varying(64) NOT NULL,
  challan_uuid character varying(64) NOT NULL,
  tenant_id character varying(256),
  is_active boolean NOT NULL,
  created_by character varying(64),
  created_time bigint NOT NULL,
  last_modified_by character varying(256),
  last_modified_time bigint NOT NULL,
  source_uuid character varying(64),
  CONSTRAINT fk_egec_store_item_register_challan_uuid FOREIGN KEY (challan_uuid)
      REFERENCES public.egec_challan_master (challan_uuid) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT fk_egec_store_item_register_violation_item_uuid FOREIGN KEY (violation_item_uuid)
      REFERENCES public.egec_violation_detail (violation_item_uuid) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT fk_egec_store_item_register_violation_uuid FOREIGN KEY (violation_uuid)
      REFERENCES public.egec_violation_master (violation_uuid) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
);

CREATE TABLE public.egec_auction_master
(
  auction_uuid character varying(64) PRIMARY KEY,
  violation_uuid character varying(64) NOT NULL,
  challan_uuid character varying(64) NOT NULL,
  status character varying,
  tenant_id character varying(256),
  is_active boolean NOT NULL,
  created_by character varying(64),
  created_time bigint NOT NULL,
  last_modified_by character varying(256),
  last_modified_time bigint NOT NULL,
  source_uuid character varying(64),
  CONSTRAINT fk_egec_auction_master_challan_uuid FOREIGN KEY (challan_uuid)
      REFERENCES public.egec_challan_master (challan_uuid) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT fk_egec_auction_master_violation_uuid FOREIGN KEY (violation_uuid)
      REFERENCES public.egec_violation_master (violation_uuid) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
);

CREATE TABLE public.egec_auction_detail
(
  auction_detail_uuid character varying(64) PRIMARY KEY,
  store_item_uuid character varying(64) NOT NULL,
  purchaser_name character varying(256) NOT NULL,
  auction_amount numeric(18,2) NOT NULL,
  auction_quantity bigint,
  violation_item_uuid character varying(64) NOT NULL,
  violation_uuid character varying(64) NOT NULL,
  challan_uuid character varying(64) NOT NULL,
  isauctioned boolean,
  tenant_id character varying(256),
  is_active boolean NOT NULL,
  created_by character varying(64),
  created_time bigint NOT NULL,
  last_modified_by character varying(256),
  last_modified_time bigint NOT NULL,
  auction_uuid character varying(64) NOT NULL,
  purchaser_contact_no character varying(50),
  auction_date date,
  CONSTRAINT fk_egec_auction_detail_auction_uuid FOREIGN KEY (auction_uuid)
      REFERENCES public.egec_auction_master (auction_uuid) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT fk_egec_auction_detail_challan_uuid FOREIGN KEY (challan_uuid)
      REFERENCES public.egec_challan_master (challan_uuid) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT fk_egec_auction_detail_store_item_uuid FOREIGN KEY (store_item_uuid)
      REFERENCES public.egec_store_item_register (store_item_uuid) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT fk_egec_auction_detail_violation_item_uuid FOREIGN KEY (violation_item_uuid)
      REFERENCES public.egec_violation_detail (violation_item_uuid) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT fk_egec_auction_detail_violation_uuid FOREIGN KEY (violation_uuid)
      REFERENCES public.egec_violation_master (violation_uuid) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
);

CREATE TABLE public.egec_document
(
  document_uuid character varying(64) PRIMARY KEY,
  filestore_id character varying NOT NULL,
  violation_uuid character varying(64) NOT NULL,
  challan_uuid character varying(64) NOT NULL,
  document_type character varying(256) NOT NULL,
  tenant_id character varying(256),
  is_active boolean NOT NULL,
  created_by character varying(64),
  created_time bigint NOT NULL,
  last_modified_by character varying(256),
  last_modified_time bigint NOT NULL,
  CONSTRAINT fk_egec_document_challan_uuid FOREIGN KEY (challan_uuid)
      REFERENCES public.egec_challan_master (challan_uuid) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT fk_egec_document_violation_uuid FOREIGN KEY (violation_uuid)
      REFERENCES public.egec_violation_master (violation_uuid) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
);

CREATE TABLE public.egec_payment
(
  payment_uuid character varying(64) PRIMARY KEY,
  payment_mode character varying(64),
  payment_status character varying(64) NOT NULL,
  payment_amount numeric(18,2) NOT NULL,
  transaction_id character varying(128),
  challan_uuid character varying(64) NOT NULL,
  violation_uuid character varying(64) NOT NULL,
  payment_gateway character varying(256),
  pg_status character varying(256),
  tenant_id character varying(256),
  is_active boolean NOT NULL,
  created_by character varying(64),
  created_time bigint NOT NULL,
  last_modified_by character varying(256),
  last_modified_time bigint NOT NULL,
  CONSTRAINT fk_egec_payment_challan_uuid FOREIGN KEY (challan_uuid)
      REFERENCES public.egec_challan_master (challan_uuid) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT fk_egec_payment_violation_uuid FOREIGN KEY (violation_uuid)
      REFERENCES public.egec_violation_master (violation_uuid) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
);

CREATE TABLE public.egec_payment_receipt
(
  payment_receipt_uuid character varying(64) PRIMARY KEY,
  payment_uuid character varying(64) NOT NULL,
  payment_status character varying(64) NOT NULL,
  challan_amount numeric(18,2) NOT NULL,
  challan_uuid character varying(64) NOT NULL,
  violation_uuid character varying(64) NOT NULL,
  payment_gateway character varying(256),
  tenant_id character varying(256),
  is_active boolean NOT NULL,
  created_by character varying(64),
  created_time bigint NOT NULL,
  last_modified_by character varying(256),
  last_modified_time bigint NOT NULL,
  source_uuid character varying(64),
  CONSTRAINT fk_egec_payment_receipt_challan_uuid FOREIGN KEY (challan_uuid)
      REFERENCES public.egec_challan_master (challan_uuid) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT fk_egec_payment_receipt_payment_uuid FOREIGN KEY (payment_uuid)
      REFERENCES public.egec_payment (payment_uuid) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT fk_egec_payment_receipt_violation_uuid FOREIGN KEY (violation_uuid)
      REFERENCES public.egec_violation_master (violation_uuid) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
);

CREATE TABLE public.egec_device_source_detail
(
  source_uuid character varying(64) PRIMARY KEY,
  module_type character varying(64),
  device_type character varying(64),
  module_code character varying(10),
  device_details json,
  created_by character varying(64),
  created_time bigint,
  tenant_id character varying(256)
  );
