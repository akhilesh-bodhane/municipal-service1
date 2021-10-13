ALTER TABLE public.egpm_noc_report_avgproctime_aggregate ALTER COLUMN application_type TYPE character varying(64);

ALTER TABLE public.egpm_noc_report_avgproctime_aggregate ALTER COLUMN tenant_id TYPE character varying(128);

ALTER TABLE public.egpm_noc_report_avgproctime_aggregate ALTER COLUMN total_average TYPE numeric(8,0);

ALTER TABLE public.egpm_noc_report_avgproctime_aggregate ALTER COLUMN total_avg_pending_10days_to_30days TYPE numeric(8,0);

ALTER TABLE public.egpm_noc_report_avgproctime_aggregate ALTER COLUMN total_avg_pending_greater_than30days TYPE numeric(8,0);