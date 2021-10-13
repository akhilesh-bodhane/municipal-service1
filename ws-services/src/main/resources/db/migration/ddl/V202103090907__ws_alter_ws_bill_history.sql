
ALTER TABLE eg_ws_connectionholder 
ADD column proposed_mobile_No character varying(15),
ADD column proposed_name character varying(50),
ADD column proposed_gender character varying(6),
ADD column proposed_guardian_name character varying(50),
ADD column proposed_correspondance_address character varying(100);

 ALTER TABLE eg_ws_application
 add column total_amount_paid varchar;
 
CREATE TABLE public.eg_ws_monthlybill_history
(
  id character varying(64) NOT NULL,
  cccode character varying,
  divsdiv character varying,
  consumercode character varying,
  billcycle character varying,
  billgroup character varying,
  subgroup character varying,
  billtype character varying,
  name character varying,
  address character varying,
  cesscharge character varying,
  netamount character varying,
  grossamount character varying,
  surcharge character varying,
  totalnetamount character varying,
  totalsurcharge character varying,
  totalgrossamount character varying,
  fixchargecode character varying,
  fixcharge character varying,
  duedatecash character varying,
  duedatecheque character varying,
  status character varying,
  billid character varying,
  paymentid character varying,
  paymentstatus character varying,
  createdby character varying(64),
  lastmodifiedby character varying(64),
  createdtime bigint,
  lastmodifiedtime bigint,
  totalamount_paid character varying,
  paymentmode character varying,
  fromdate bigint,
  todate bigint,
  receiptdate bigint,
  year integer,
  UNIQUE (consumercode, billcycle)
);
