--Alter egpm_noc_application

ALTER TABLE public.egpm_noc_application ALTER COLUMN tenant_id SET NOT NULL;
ALTER TABLE public.egpm_noc_application ALTER COLUMN noc_number SET NOT NULL;
ALTER TABLE public.egpm_noc_application ALTER COLUMN applied_date SET NOT NULL;
ALTER TABLE public.egpm_noc_application ALTER COLUMN application_type SET NOT NULL;
ALTER TABLE public.egpm_noc_application ALTER COLUMN application_status SET NOT NULL;
ALTER TABLE public.egpm_noc_application ALTER COLUMN created_by SET NOT NULL;
ALTER TABLE public.egpm_noc_application ALTER COLUMN created_time SET NOT NULL;


--Alter egpm_noc_application_detail

ALTER TABLE public.egpm_noc_application_detail ALTER COLUMN application_uuid SET NOT NULL;
ALTER TABLE public.egpm_noc_application_detail ALTER COLUMN application_detail SET NOT NULL;
ALTER TABLE public.egpm_noc_application_detail ALTER COLUMN created_by SET NOT NULL;
ALTER TABLE public.egpm_noc_application_detail ALTER COLUMN tenant_id SET NOT NULL;


--Alter egpm_noc_application_remark

ALTER TABLE public.egpm_noc_application_remark ALTER COLUMN application_uuid SET NOT NULL;
ALTER TABLE public.egpm_noc_application_remark ALTER COLUMN application_status SET NOT NULL;
ALTER TABLE public.egpm_noc_application_remark ALTER COLUMN remark_by SET NOT NULL;
ALTER TABLE public.egpm_noc_application_remark ALTER COLUMN created_by SET NOT NULL;
ALTER TABLE public.egpm_noc_application_remark ALTER COLUMN created_time SET NOT NULL;


--Alter egpm_noc_price_book

ALTER TABLE public.egpm_noc_price_book ALTER COLUMN application_type SET NOT NULL;
