CREATE TABLE public.egec_delete_challan_bckup
(
challan_id character varying(256),
  eg_wf_processinstance_v2 jsonb,
  egec_document jsonb,
  egec_store_item_register jsonb,
  egec_payment jsonb,
  egec_challan_detail jsonb,
  egec_challan_master jsonb,
  egec_violation_detail jsonb,
  egec_violation_master jsonb
);