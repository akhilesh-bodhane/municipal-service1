ALTER TABLE public.eg_pension_pensioner_application_details ALTER COLUMN claimant TYPE varchar(1024) USING claimant::varchar;
ALTER TABLE public.eg_pension_pensioner_application_details ALTER COLUMN bank_code TYPE varchar(1024) USING bank_code::varchar;
ALTER TABLE public.eg_pension_pensioner_application_details ALTER COLUMN bank_ifsc TYPE varchar(1024) USING bank_ifsc::varchar;
ALTER TABLE public.eg_pension_pensioner_application_details ALTER COLUMN account_number TYPE varchar(1024) USING account_number::varchar;

ALTER TABLE public.eg_pension_dependent_audit ALTER COLUMN bank_account_number TYPE varchar(1024) USING bank_account_number::varchar;
ALTER TABLE public.eg_pension_dependent_audit ALTER COLUMN bank_code TYPE varchar(1024) USING bank_code::varchar;
ALTER TABLE public.eg_pension_dependent_audit ALTER COLUMN bank_ifsc TYPE varchar(1024) USING bank_ifsc::varchar;

ALTER TABLE public.eg_pension_dependent ALTER COLUMN bank_code TYPE varchar(1024) USING bank_code::varchar;
ALTER TABLE public.eg_pension_dependent ALTER COLUMN bank_ifsc TYPE varchar(1024) USING bank_ifsc::varchar;
ALTER TABLE public.eg_pension_dependent ALTER COLUMN bank_account_number TYPE varchar(1024) USING bank_account_number::varchar;