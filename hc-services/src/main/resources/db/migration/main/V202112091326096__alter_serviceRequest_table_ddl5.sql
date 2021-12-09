ALTER TABLE public.eg_hc_service_request 
ADD is_range_forest_officer_report boolean NULL DEFAULT false;

ALTER TABLE public.eg_hc_service_request 
ADD range_forest_officer_report_document jsonb NULL;
