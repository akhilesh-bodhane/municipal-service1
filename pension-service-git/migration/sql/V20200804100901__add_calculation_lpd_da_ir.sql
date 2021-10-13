ALTER TABLE public.eg_pension_calculation_details ADD interim_relief_lpd_system numeric(18,2) NULL;
ALTER TABLE public.eg_pension_calculation_details ADD da_lpd_system numeric(18,2) NULL;
ALTER TABLE public.eg_pension_calculation_details_audit ADD interim_relief_lpd_system numeric(18,2) NULL;
ALTER TABLE public.eg_pension_calculation_details_audit ADD da_lpd_system numeric(18,2) NULL;