ALTER TABLE public.eg_pension_calculation_details ADD pension_arrear_system numeric(18,2) NULL;
ALTER TABLE public.eg_pension_calculation_details ADD pension_arrear_verified numeric(18,2) NULL;
ALTER TABLE public.eg_pension_calculation_details_audit ADD pension_arrear_system numeric(18,2) NULL;
ALTER TABLE public.eg_pension_calculation_details_audit ADD pension_arrear_verified numeric(18,2) NULL;

CREATE TABLE eg_pension_arrear
(
    uuid character varying(1024) NOT NULL,
    tenantid character varying(1024) NOT NULL,
    workflow_header_id character varying(1024) NOT NULL,
    effective_year integer,
    effective_month integer,
    interim_relief numeric(18,2),
    da numeric(18,2),
    total_pension numeric(18,2),
    pension_deductions numeric(18,2),
    wound_extraordinary_pension numeric(18,2),
    attendant_allowance numeric(18,2),
    fma numeric(18,2),
    miscellaneous numeric(18,2),
    over_payment numeric(18,2),
    income_tax numeric(18,2),
    cess numeric(18,2),
    basic_pension numeric(18,2),
    additional_pension numeric(18,2),
    commuted_pension numeric(18,2),
    net_deductions numeric(18,2),
    net_pension numeric(18,2),
    active boolean NOT NULL,
    created_by character varying(1024) NOT NULL,
    last_modified_by character varying(1024) ,
    created_date bigint NOT NULL,
    last_modified_date bigint,    
    CONSTRAINT pk_eg_pension_arrear PRIMARY KEY (uuid),
    CONSTRAINT eg_workflow_header_id_fkey FOREIGN KEY (workflow_header_id)
        REFERENCES eg_pension_workflow_header (uuid) 
        ON UPDATE CASCADE
        ON DELETE CASCADE
);