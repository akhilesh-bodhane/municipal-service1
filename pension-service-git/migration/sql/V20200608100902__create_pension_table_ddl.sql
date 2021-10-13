-- Table: eg_pension_employee

-- DROP TABLE eg_pension_employee;

CREATE TABLE eg_pension_employee
(
    uuid character varying(1024) NOT NULL,
    tenantid character varying(1024) NOT NULL,
    employee_hrms_id bigint NOT NULL,
    employee_hrms_code character varying(250) NOT NULL,
    name character varying(250) NOT NULL,
    date_of_birth bigint NOT NULL,
    date_of_retirement bigint,
    date_of_death bigint,
    active boolean NOT NULL,
    created_by character varying(1024) ,
    last_modified_by character varying(1024) ,
    created_date bigint,
    last_modified_date bigint,
    employee_hrms_uuid character varying(1024) ,
    salutation character varying(10) ,
    gender character varying(20) ,
    employee_status character varying(250) ,
    employee_type character varying(250) ,
    date_of_appointment bigint,
    CONSTRAINT pk_tbl_pension_employee PRIMARY KEY (uuid)
);

-- Table: eg_pension_employee_audit

-- DROP TABLE eg_pension_employee_audit;

CREATE TABLE eg_pension_employee_audit
(
    uuid character varying(1024) NOT NULL,
    tenantid character varying(1024) NOT NULL,
    pension_employee_id character varying(1024) NOT NULL,
    employee_hrms_id bigint NOT NULL,
    employee_hrms_code character varying(250) NOT NULL,
    name character varying(250) NOT NULL,
    date_of_birth bigint NOT NULL,
    date_of_retirement bigint,
    date_of_death bigint,
    active boolean NOT NULL,
    created_by character varying(1024) ,
    last_modified_by character varying(1024) ,
    created_date bigint,
    last_modified_date bigint,
    employee_hrms_uuid character varying(1024) ,
    salutation character varying(10) ,
    gender character varying(20) ,
    employee_status character varying(250) ,
    employee_type character varying(250) ,
    date_of_appointment bigint,
    CONSTRAINT pk_tbl_pension_employee_audit PRIMARY KEY (uuid),
    CONSTRAINT eg_pension_employee_audit_pension_employee_id_fkey FOREIGN KEY (pension_employee_id)
        REFERENCES eg_pension_employee (uuid) 
        ON UPDATE CASCADE
        ON DELETE CASCADE
);
	
-- Table: eg_pension_employee_contact_details

-- DROP TABLE eg_pension_employee_contact_details;

CREATE TABLE eg_pension_employee_contact_details
(
    uuid character varying(1024) NOT NULL,
    tenantid character varying(1024) NOT NULL,
    pension_employee_id character varying(1024) NOT NULL,
    mobile_number character varying(20) ,
    email_id character varying(250) ,
    alt_contact_number character varying(250) ,
    pan character varying(250) ,
    aadhaar_number character varying(250) ,
    permanent_address character varying(1024) ,
    permanent_city character varying(250) ,
    permanent_pin_code character varying(6) ,
    correspondence_address character varying(1024) ,
    correspondence_city character varying(250) ,
    correspondence_pin_code character varying(6) ,
    father_or_husband_name character varying(250) ,
    blood_group character varying(50) ,
    identification_mark character varying(250) ,
    active boolean NOT NULL,
    created_by character varying(1024) NOT NULL,
    last_modified_by character varying(1024) ,
    created_date bigint NOT NULL,
    last_modified_date bigint,
    CONSTRAINT pk_tbl_pension_employee_contact_details PRIMARY KEY (uuid)
);
	
-- Table: eg_pension_employee_assignment

-- DROP TABLE eg_pension_employee_assignment;

CREATE TABLE eg_pension_employee_assignment
(
    uuid character varying(1024) NOT NULL,
    tenantid character varying(1024) NOT NULL,
    pension_employee_id character varying(1024) NOT NULL,
    "position" bigint,
    department character varying(250) ,
    designation character varying(250) ,
    from_date bigint,
    to_date bigint,
    govt_order_no character varying(250) ,
    reporting_to character varying(250) ,
    is_hod boolean,
    is_current_assignment boolean,
    active boolean NOT NULL,
    created_by character varying(1024) NOT NULL,
    last_modified_by character varying(1024) ,
    created_date bigint NOT NULL,
    last_modified_date bigint,
    is_primary_assignment boolean,
    is_pension_applicable boolean,
    CONSTRAINT pk_tbl_pension_employee_assignment PRIMARY KEY (uuid)
);
	
-- Table: eg_pension_employee_service_history

-- DROP TABLE eg_pension_employee_service_history;

CREATE TABLE eg_pension_employee_service_history
(
    uuid character varying(1024) NOT NULL,
    tenantid character varying(1024) NOT NULL,
    pension_employee_id character varying(1024) NOT NULL,
    service_status character varying(250) ,
    service_from bigint,
    service_to bigint,
    order_no character varying(250) ,
    location character varying(250) ,
    is_current_position boolean,
    active boolean NOT NULL,
    created_by character varying(1024) NOT NULL,
    last_modified_by character varying(1024) ,
    created_date bigint NOT NULL,
    last_modified_date bigint,
    CONSTRAINT pk_tbl_pension_employee_service_history PRIMARY KEY (uuid)
);
	
-- Table: eg_pension_notification_register

-- DROP TABLE eg_pension_notification_register;

CREATE TABLE eg_pension_notification_register
(
    uuid character varying(1024) NOT NULL,
    tenantid character varying(1024) NOT NULL,
    pension_employee_id character varying(1024) NOT NULL,
    is_initiated boolean,
    active boolean NOT NULL,
    created_by character varying(1024) ,
    last_modified_by character varying(1024) ,
    created_date bigint,
    last_modified_date bigint,
    CONSTRAINT pk_tbl_pension_notification_register PRIMARY KEY (uuid),
    CONSTRAINT fk_tbl_pension_notification_register_pn_employee_uuid FOREIGN KEY (pension_employee_id)
        REFERENCES eg_pension_employee (uuid) 
        ON UPDATE CASCADE
        ON DELETE CASCADE,
    CONSTRAINT tbl_pension_notification_register_pension_employee_id_fkey FOREIGN KEY (pension_employee_id)
        REFERENCES eg_pension_employee (uuid) 
        ON UPDATE CASCADE
        ON DELETE CASCADE
);
	
-- Table: eg_pension_notification_register_audit

-- DROP TABLE eg_pension_notification_register_audit;

CREATE TABLE eg_pension_notification_register_audit
(
    uuid character varying(1024) NOT NULL,
    tenantid character varying(1024) NOT NULL,
    pension_notification_register_id character varying(1024) NOT NULL,
    pension_employee_id character varying(1024) NOT NULL,
    is_initiated boolean,
    active boolean NOT NULL,
    created_by character varying(1024) ,
    last_modified_by character varying(1024) ,
    created_date bigint,
    last_modified_date bigint,
    CONSTRAINT pk_tbl_pension_notification_register_audit PRIMARY KEY (uuid),
    CONSTRAINT fk_tbl_pension_notification_register_audit_pn_employee_uuid FOREIGN KEY (pension_employee_id)
        REFERENCES eg_pension_employee (uuid) 
        ON UPDATE CASCADE
        ON DELETE CASCADE,
    CONSTRAINT fk_tbl_pension_notification_register_audit_pn_register_uuid FOREIGN KEY (pension_notification_register_id)
        REFERENCES eg_pension_notification_register (uuid) 
        ON UPDATE CASCADE
        ON DELETE CASCADE,
    CONSTRAINT tbl_pension_notification_register_audi_pension_employee_id_fkey FOREIGN KEY (pension_employee_id)
        REFERENCES eg_pension_employee (uuid) 
        ON UPDATE CASCADE
        ON DELETE CASCADE
);
	
-- Table: eg_pension_dependent

-- DROP TABLE eg_pension_dependent;

CREATE TABLE eg_pension_dependent
(
    uuid character varying(1024) NOT NULL,
    tenantid character varying(1024) NOT NULL,
    pension_employee_id character varying(1024) NOT NULL,
    name character varying(250) NOT NULL,
    dob bigint NOT NULL,
    address character varying(1024) ,
    mobile_number character varying(20) ,
    relationship character varying(250) NOT NULL,
    is_disabled boolean,
    marital_status character varying(250) ,
    is_holly_dependent boolean,
    no_spouse_no_children boolean,
    is_grandchild_from_deceased_son boolean,
    is_eligible_for_gratuity boolean,
    is_eligible_for_pension boolean,
    active boolean NOT NULL,
    created_by character varying(1024) NOT NULL,
    last_modified_by character varying(1024) ,
    created_date bigint NOT NULL,
    last_modified_date bigint,
    gratuity_percentage numeric(18,2) DEFAULT 0,
    bank_account_number character varying(50) ,
    bank_details character varying(1024) ,
    CONSTRAINT pk_tbl_pension_dependent PRIMARY KEY (uuid),
    CONSTRAINT tbl_pension_dependent_pension_employee_id_fkey FOREIGN KEY (pension_employee_id)
        REFERENCES eg_pension_employee (uuid) 
        ON UPDATE CASCADE
        ON DELETE CASCADE
);
	
-- Table: eg_pension_dependent_audit

-- DROP TABLE eg_pension_dependent_audit;

CREATE TABLE eg_pension_dependent_audit
(
    uuid character varying(1024) NOT NULL,
    tenantid character varying(1024) NOT NULL,
    dependent_id character varying(1024) NOT NULL,
    pension_employee_id character varying(1024) NOT NULL,
    name character varying(250) NOT NULL,
    dob bigint NOT NULL,
    address character varying(1024) ,
    mobile_number character varying(20) ,
    relationship character varying(250) NOT NULL,
    is_disabled boolean,
    marital_status character varying(250) ,
    is_holly_dependent boolean,
    no_spouse_no_children boolean,
    is_grandchild_from_deceased_son boolean,
    is_eligible_for_gratuity boolean,
    is_eligible_for_pension boolean,
    active boolean NOT NULL,
    created_by character varying(1024) NOT NULL,
    last_modified_by character varying(1024) ,
    created_date bigint NOT NULL,
    last_modified_date bigint,
    gratuity_percentage numeric(18,2) DEFAULT 0,
    bank_account_number character varying(50) ,
    bank_details character varying(1024) ,
    CONSTRAINT pk_tbl_pension_dependent_audit PRIMARY KEY (uuid),
    CONSTRAINT eg_pension_dependent_audit_dependent_id_fkey FOREIGN KEY (dependent_id)
        REFERENCES eg_pension_dependent (uuid) 
        ON UPDATE CASCADE
        ON DELETE CASCADE,
    CONSTRAINT tbl_pension_dependent_audit_pension_employee_id_fkey FOREIGN KEY (pension_employee_id)
        REFERENCES eg_pension_employee (uuid) 
        ON UPDATE CASCADE
        ON DELETE CASCADE
);
	
-- Table: eg_pension_disability_register

-- DROP TABLE eg_pension_disability_register;

CREATE TABLE eg_pension_disability_register
(
    uuid character varying(1024) NOT NULL,
    tenantid character varying(1024) NOT NULL,
    pension_employee_id character varying(1024) NOT NULL,
    severity_of_disability character varying(250) NOT NULL,
    disability_percentage numeric(18,2) NOT NULL,
    date_of_injury bigint NOT NULL,
    injury_application_date bigint NOT NULL,
    wound_extraordinary_pension numeric(18,2),
    attendant_allowance_granted boolean,
    comments character varying(1024) ,
    active boolean NOT NULL,
    created_by character varying(1024) ,
    last_modified_by character varying(1024) ,
    created_date bigint,
    last_modified_date bigint,
    CONSTRAINT pk_eg_pension_disability_register PRIMARY KEY (uuid),
    CONSTRAINT eg_pension_disability_register_pension_employee_id_fkey FOREIGN KEY (pension_employee_id)
        REFERENCES eg_pension_employee (uuid) 
        ON UPDATE CASCADE
        ON DELETE CASCADE
);
	
-- Table: eg_pension_disability_register_audit

-- DROP TABLE eg_pension_disability_register_audit;

CREATE TABLE eg_pension_disability_register_audit
(
    uuid character varying(1024) NOT NULL,
    tenantid character varying(1024) NOT NULL,
    disability_register_id character varying(1024) NOT NULL,
    pension_employee_id character varying(1024) NOT NULL,
    severity_of_disability character varying(250) NOT NULL,
    disability_percentage numeric(18,2) NOT NULL,
    date_of_injury bigint NOT NULL,
    injury_application_date bigint NOT NULL,
    wound_extraordinary_pension numeric(18,2),
    attendant_allowance_granted boolean,
    comments character varying(1024) ,
    active boolean NOT NULL,
    created_by character varying(1024) ,
    last_modified_by character varying(1024) ,
    created_date bigint,
    last_modified_date bigint,
    CONSTRAINT pk_eg_pension_disability_register_audit PRIMARY KEY (uuid),
    CONSTRAINT eg_pension_disability_register_audi_disability_register_id_fkey FOREIGN KEY (disability_register_id)
        REFERENCES eg_pension_disability_register (uuid) 
        ON UPDATE CASCADE
        ON DELETE CASCADE,
    CONSTRAINT eg_pension_disability_register_audit_pension_employee_id_fkey FOREIGN KEY (pension_employee_id)
        REFERENCES eg_pension_employee (uuid) 
        ON UPDATE CASCADE
        ON DELETE CASCADE
);
	
-- Table: eg_pension_workflow_header

-- DROP TABLE eg_pension_workflow_header;

CREATE TABLE eg_pension_workflow_header
(
    uuid character varying(1024) NOT NULL,
    tenantid character varying(1024) NOT NULL,
    pension_employee_id character varying(1024) NOT NULL,
    workflow_type character varying(250) NOT NULL,
    application_number character varying(250) NOT NULL,
    application_date bigint NOT NULL,
    active boolean NOT NULL,
    created_by character varying(1024) NOT NULL,
    last_modified_by character varying(1024) ,
    created_date bigint NOT NULL,
    last_modified_date bigint,
    assignee character varying(1024) ,
    workflow_state character varying(250) ,
    CONSTRAINT pk_tbl_pension_workflow_header PRIMARY KEY (uuid)
);
	
-- Table: eg_pension_workflow_header_audit

-- DROP TABLE eg_pension_workflow_header_audit;

CREATE TABLE eg_pension_workflow_header_audit
(
    uuid character varying(1024) NOT NULL,
    tenantid character varying(1024) NOT NULL,
    pension_employee_id character varying(1024) NOT NULL,
    workflow_header_id character varying(1024) NOT NULL,
    workflow_type character varying(250) NOT NULL,
    application_number character varying(250) NOT NULL,
    application_date bigint NOT NULL,
    active boolean NOT NULL,
    created_by character varying(1024) ,
    last_modified_by character varying(1024) ,
    created_date bigint NOT NULL,
    last_modified_date bigint,
    assignee character varying(1024) ,
    workflow_state character varying(250) ,
    CONSTRAINT pk_tbl_pension_workflow_header_audit PRIMARY KEY (uuid),
    CONSTRAINT eg_pension_workflow_header_audit_workflow_header_id_fkey FOREIGN KEY (workflow_header_id)
        REFERENCES eg_pension_workflow_header (uuid) 
        ON UPDATE CASCADE
        ON DELETE CASCADE
);
	
-- Table: eg_pension_employee_other_details

-- DROP TABLE eg_pension_employee_other_details;

CREATE TABLE eg_pension_employee_other_details
(
    uuid character varying(1024) NOT NULL,
    tenantid character varying(1024) NOT NULL,
    workflow_header_id character varying(1024) NOT NULL,
    workflow_state character varying(250) ,
    ltc numeric(18,2),
    lpd numeric(18,2),
    pension_arrear numeric(18,2),
    is_da_medical_admissible boolean,
    fma numeric(18,2),
    medical_relief numeric(18,2),
    miscellaneous numeric(18,2),
    over_payment numeric(18,2),
    income_tax numeric(18,2),
    cess numeric(18,2),
    bank_address character varying(1024) ,
    account_number character varying(50) ,
    claimant character varying(50) ,
    wef bigint,
    active boolean NOT NULL,
    created_by character varying(1024) NOT NULL,
    last_modified_by character varying(1024) ,
    created_date bigint NOT NULL,
    last_modified_date bigint,
    total_no_pay_leaves_days integer DEFAULT 0,
    dues numeric(18,2) DEFAULT 0,
    is_employment_active boolean DEFAULT false,
    is_convicted_serious_crime_or_grave_misconduct boolean DEFAULT false,
    is_any_judicial_proceeding_is_continuing boolean DEFAULT false,
    is_any_misconduct_insolvency_inefficiency boolean DEFAULT false,
    is_employee_dies_in_terrorist_attack boolean DEFAULT false,
    is_employee_dies_in_accidental_death boolean DEFAULT false,
    is_commutation_opted boolean DEFAULT false,
    reason_for_retirement character varying(250) ,
    is_eligible_for_pension boolean DEFAULT false,
    is_dues_present boolean DEFAULT false,
    is_dues_amount_decided boolean DEFAULT false,
    is_taken_monthly_pension_and_gratuity boolean DEFAULT false,
    is_taken_gratuity_commutation_terminal_benefit boolean DEFAULT false,
    is_taken_compensation_pension_and_gratuity boolean DEFAULT false,
    dies_in_extremists_dacoits_smuggler_antisocial_attack boolean DEFAULT false,
    is_compassionate_pension_granted boolean DEFAULT false,
    total_no_pay_leaves_months integer DEFAULT 0,
    total_no_pay_leaves_years integer DEFAULT 0,
    no_dues_for_avail_govt_accomodation boolean DEFAULT false,
    employee_group character varying(250) ,
    date_of_contingent bigint,
    CONSTRAINT pk_tbl_pension_employee_other_details PRIMARY KEY (uuid),
    CONSTRAINT tbl_pension_employee_other_details_workflow_header_id_fkey FOREIGN KEY (workflow_header_id)
        REFERENCES eg_pension_workflow_header (uuid) 
        ON UPDATE CASCADE
        ON DELETE CASCADE
);
	
-- Table: eg_pension_employee_other_details_audit

-- DROP TABLE eg_pension_employee_other_details_audit;

CREATE TABLE eg_pension_employee_other_details_audit
(
    uuid character varying(1024) NOT NULL,
    tenantid character varying(1024) NOT NULL,
    employee_other_details_id character varying(1024) NOT NULL,
    workflow_header_id character varying(1024) NOT NULL,
    workflow_state character varying(250) ,
    ltc numeric(18,2),
    lpd numeric(18,2),
    pension_arrear numeric(18,2),
    is_da_medical_admissible boolean,
    fma numeric(18,2),
    medical_relief numeric(18,2),
    miscellaneous numeric(18,2),
    over_payment numeric(18,2),
    income_tax numeric(18,2),
    cess numeric(18,2),
    bank_address character varying(1024) ,
    account_number character varying(50) ,
    claimant character varying(50) ,
    wef bigint,
    active boolean NOT NULL,
    created_by character varying(1024) NOT NULL,
    last_modified_by character varying(1024) ,
    created_date bigint NOT NULL,
    last_modified_date bigint,
    total_no_pay_leaves_days integer DEFAULT 0,
    dues numeric(18,2) DEFAULT 0,
    is_employment_active boolean DEFAULT false,
    is_convicted_serious_crime_or_grave_misconduct boolean DEFAULT false,
    is_any_judicial_proceeding_is_continuing boolean DEFAULT false,
    is_any_misconduct_insolvency_inefficiency boolean DEFAULT false,
    is_employee_dies_in_terrorist_attack boolean DEFAULT false,
    is_employee_dies_in_accidental_death boolean DEFAULT false,
    is_commutation_opted boolean DEFAULT false,
    reason_for_retirement character varying(250) ,
    is_eligible_for_pension boolean DEFAULT false,
    is_dues_present boolean DEFAULT false,
    is_dues_amount_decided boolean DEFAULT false,
    is_taken_monthly_pension_and_gratuity boolean DEFAULT false,
    is_taken_gratuity_commutation_terminal_benefit boolean DEFAULT false,
    is_taken_compensation_pension_and_gratuity boolean DEFAULT false,
    dies_in_extremists_dacoits_smuggler_antisocial_attack boolean DEFAULT false,
    is_compassionate_pension_granted boolean DEFAULT false,
    total_no_pay_leaves_months integer DEFAULT 0,
    total_no_pay_leaves_years integer DEFAULT 0,
    no_dues_for_avail_govt_accomodation boolean DEFAULT false,
    employee_group character varying(250) ,
    date_of_contingent bigint,
    CONSTRAINT pk_tbl_pension_employee_other_details_audit PRIMARY KEY (uuid),
    CONSTRAINT eg_pension_employee_other_detail_employee_other_details_id_fkey FOREIGN KEY (employee_other_details_id)
        REFERENCES eg_pension_employee_other_details (uuid) 
        ON UPDATE CASCADE
        ON DELETE CASCADE,
    CONSTRAINT tbl_pension_employee_other_details_audi_workflow_header_id_fkey FOREIGN KEY (workflow_header_id)
        REFERENCES eg_pension_workflow_header (uuid) 
        ON UPDATE CASCADE
        ON DELETE CASCADE
);
	
-- Table: eg_pension_attachment

-- DROP TABLE eg_pension_attachment;

CREATE TABLE eg_pension_attachment
(
    uuid character varying(1024) NOT NULL,
    tenantid character varying(1024) NOT NULL,
    workflow_header_id character varying(1024) NOT NULL,
    file_store_id character varying(250) NOT NULL,
    document_type character varying(250) NOT NULL,
    state character varying(250) ,
    comment character varying(250) ,
    active boolean NOT NULL,
    created_by character varying(1024) NOT NULL,
    last_modified_by character varying(1024) ,
    created_date bigint NOT NULL,
    last_modified_date bigint,
    CONSTRAINT pk_tbl_pension_attachment PRIMARY KEY (uuid),
    CONSTRAINT tbl_pension_attachment_workflow_header_id_fkey FOREIGN KEY (workflow_header_id)
        REFERENCES eg_pension_workflow_header (uuid) 
        ON UPDATE CASCADE
        ON DELETE CASCADE
);
	
-- Table: eg_pension_attachment_audit

-- DROP TABLE eg_pension_attachment_audit;

CREATE TABLE eg_pension_attachment_audit
(
    uuid character varying(1024) NOT NULL,
    tenantid character varying(1024) NOT NULL,
    pension_attachment_id character varying(1024) NOT NULL,
    workflow_header_id character varying(1024) NOT NULL,
    file_store_id character varying(250) NOT NULL,
    document_type character varying(250) NOT NULL,
    state character varying(250) ,
    comment character varying(250) ,
    active boolean NOT NULL,
    created_by character varying(1024) NOT NULL,
    last_modified_by character varying(1024) ,
    created_date bigint NOT NULL,
    last_modified_date bigint,
    CONSTRAINT pk_tbl_pension_attachment_audit PRIMARY KEY (uuid),
    CONSTRAINT eg_pension_attachment_audit_pension_attachment_id_fkey FOREIGN KEY (pension_attachment_id)
        REFERENCES eg_pension_attachment (uuid) 
        ON UPDATE CASCADE
        ON DELETE CASCADE,
    CONSTRAINT tbl_pension_attachment_audit_workflow_header_id_fkey FOREIGN KEY (workflow_header_id)
        REFERENCES eg_pension_workflow_header (uuid) 
        ON UPDATE CASCADE
        ON DELETE CASCADE
);

-- Table: eg_pension_calculation_details

-- DROP TABLE eg_pension_calculation_details;

CREATE TABLE eg_pension_calculation_details
(
    uuid character varying(1024) NOT NULL,
    tenantid character varying(1024) NOT NULL,
    workflow_header_id character varying(1024) NOT NULL,
    workflow_state character varying(250) ,
    basic_pension_sytem numeric(18,2),
    pension_deductions_system numeric(18,2),
    additional_pension_system numeric(18,2),
    commuted_pension_system numeric(18,2),
    commuted_value_system numeric(18,2),
    family_pension_i_system numeric(18,2),
    family_pension_ii_system numeric(18,2),
    dcrg_system numeric(18,2),
    net_deductions_system numeric(18,2),
    final_calculated_pension_system numeric(18,2),
    basic_pension_verified numeric(18,2),
    pension_deductions_verified numeric(18,2),
    additional_pension_verified numeric(18,2),
    commuted_pension_verified numeric(18,2),
    commuted_value_verified numeric(18,2),
    family_pension_i_verified numeric(18,2),
    family_pension_ii_verified numeric(18,2),
    dcrg_verified numeric(18,2),
    net_deductions_verified numeric(18,2),
    final_calculated_pension_verified numeric(18,2),
    active boolean NOT NULL,
    created_by character varying(1024) NOT NULL,
    last_modified_by character varying(1024) ,
    created_date bigint NOT NULL,
    last_modified_date bigint,
    interim_relief_system numeric(18,2) DEFAULT 0,
    da_system numeric(18,2) DEFAULT 0,
    interim_relief_verified numeric(18,2) DEFAULT 0,
    da_verified numeric(18,2) DEFAULT 0,
    nqs_year_system integer DEFAULT 0,
    nqs_month_system integer DEFAULT 0,
    nqs_day_system integer DEFAULT 0,
    nqs_year_verified integer DEFAULT 0,
    nqs_month_verified integer DEFAULT 0,
    nqs_day_verified integer DEFAULT 0,
    dues_deductions_system numeric(18,2) DEFAULT 0,
    compassionate_pension_system numeric(18,2) DEFAULT 0,
    compensation_pension_system numeric(18,2) DEFAULT 0,
    terminal_benefit_system numeric(18,2) DEFAULT 0,
    dues_deductions_verified numeric(18,2) DEFAULT 0,
    compassionate_pension_verified numeric(18,2) DEFAULT 0,
    compensation_pension_verified numeric(18,2) DEFAULT 0,
    terminal_benefit_verified numeric(18,2) DEFAULT 0,
    final_calculated_gratuity_system numeric(18,2) DEFAULT 0,
    final_calculated_gratuity_verified numeric(18,2) DEFAULT 0,
    family_pension_i_start_date_system bigint,
    family_pension_i_start_date_verified bigint,
    family_pension_i_end_date_system bigint,
    family_pension_i_end_date_verified bigint,
    family_pension_ii_start_date_system bigint,
    family_pension_ii_start_date_verified bigint,
    ex_gratia_system numeric(18,2),
    ex_gratia_verified numeric(18,2),
    pensioner_family_pension_system numeric(18,2),
    pensioner_family_pension_verified numeric(18,2),
    total_pension_system numeric(18,2),
    total_pension_verified numeric(18,2),
    provisional_pension_system numeric(18,2),
    provisional_pension_verified numeric(18,2),
    interim_relief_applicable boolean DEFAULT false,
    interim_relief_expression character varying(250) ,
    basic_pension_applicable boolean DEFAULT false,
    basic_pension_expression character varying(250) ,
    provisional_pension_applicable boolean DEFAULT false,
    provisional_pension_expression character varying(250) ,
    compassionate_pension_applicable boolean DEFAULT false,
    compassionate_pension_expression character varying(250) ,
    compensation_pension_applicable boolean DEFAULT false,
    compensation_pension_expression character varying(250) ,
    commuted_pension_applicable boolean DEFAULT false,
    commuted_pension_expression character varying(250) ,
    family_pension_i_applicable boolean DEFAULT false,
    family_pension_i_expression character varying(250) ,
    family_pension_ii_applicable boolean DEFAULT false,
    family_pension_ii_expression character varying(250) ,
    da_applicable boolean DEFAULT false,
    da_expression character varying(250) ,
    additional_pension_applicable boolean DEFAULT false,
    additional_pension_expression character varying(250) ,
    total_pension_applicable boolean DEFAULT false,
    total_pension_expression character varying(250) ,
    pension_deductions_applicable boolean DEFAULT false,
    pension_deductions_expression character varying(250) ,
    net_deductions_applicable boolean DEFAULT false,
    net_deductions_expression character varying(250) ,
    final_calculated_pension_applicable boolean DEFAULT false,
    final_calculated_pension_expression character varying(250) ,
    commutation_value_applicable boolean DEFAULT false,
    commutation_value_expression character varying(250) ,
    dcrg_applicable boolean DEFAULT false,
    dcrg_expression character varying(250) ,
    terminal_benefit_applicable boolean DEFAULT false,
    terminal_benefit_expression character varying(250) ,
    dues_deductions_applicable boolean DEFAULT false,
    dues_deductions_expression character varying(250) ,
    final_calculated_gratuity_applicable boolean DEFAULT false,
    final_calculated_gratuity_expression character varying(250) ,
    ex_gratia_applicable boolean DEFAULT false,
    ex_gratia_expression character varying(250) ,
    pensioner_family_pension_applicable boolean DEFAULT false,
    pensioner_family_pension_expression character varying(250) ,
    invalid_pension_system numeric(18,2),
    wound_extraordinary_pension_system numeric(18,2),
    attendant_allowance_system numeric(18,2),
    invalid_pension_verified numeric(18,2),
    wound_extraordinary_pension_verified numeric(18,2),
    attendant_allowance_verified numeric(18,2),
    invalid_pension_applicable boolean DEFAULT false,
    invalid_pension_expression character varying(250) ,
    wound_extraordinary_pension_applicable boolean DEFAULT false,
    wound_extraordinary_pension_expression character varying(250) ,
    attendant_allowance_applicable boolean DEFAULT false,
    attendant_allowance_expression character varying(250) ,
    gqs_year_system integer DEFAULT 0,
    gqs_month_system integer DEFAULT 0,
    gqs_day_system integer DEFAULT 0,
    gqs_year_verified integer DEFAULT 0,
    gqs_month_verified integer DEFAULT 0,
    gqs_day_verified integer DEFAULT 0,
    notification_text_system character varying ,
    notification_text_verified character varying ,
    CONSTRAINT pk_tbl_pension_calculation_details PRIMARY KEY (uuid),
    CONSTRAINT tbl_pension_calculation_details_workflow_header_id_fkey FOREIGN KEY (workflow_header_id)
        REFERENCES eg_pension_workflow_header (uuid) 
        ON UPDATE CASCADE
        ON DELETE CASCADE
);
	
-- Table: eg_pension_calculation_details_audit

-- DROP TABLE eg_pension_calculation_details_audit;

CREATE TABLE eg_pension_calculation_details_audit
(
    uuid character varying(1024) NOT NULL,
    tenantid character varying(1024) NOT NULL,
    pension_calculation_id character varying(1024) NOT NULL,
    workflow_header_id character varying(1024) NOT NULL,
    workflow_state character varying(250) ,
    basic_pension_sytem numeric(18,2),
    pension_deductions_system numeric(18,2),
    additional_pension_system numeric(18,2),
    commuted_pension_system numeric(18,2),
    commuted_value_system numeric(18,2),
    family_pension_i_system numeric(18,2),
    family_pension_ii_system numeric(18,2),
    dcrg_system numeric(18,2),
    net_deductions_system numeric(18,2),
    final_calculated_pension_system numeric(18,2),
    basic_pension_verified numeric(18,2),
    pension_deductions_verified numeric(18,2),
    additional_pension_verified numeric(18,2),
    commuted_pension_verified numeric(18,2),
    commuted_value_verified numeric(18,2),
    family_pension_i_verified numeric(18,2),
    family_pension_ii_verified numeric(18,2),
    dcrg_verified numeric(18,2),
    net_deductions_verified numeric(18,2),
    final_calculated_pension_verified numeric(18,2),
    active boolean NOT NULL,
    created_by character varying(1024) NOT NULL,
    last_modified_by character varying(1024) ,
    created_date bigint NOT NULL,
    last_modified_date bigint,
    interim_relief_system numeric(18,2) DEFAULT 0,
    da_system numeric(18,2) DEFAULT 0,
    interim_relief_verified numeric(18,2) DEFAULT 0,
    da_verified numeric(18,2) DEFAULT 0,
    nqs_year_system integer DEFAULT 0,
    nqs_month_system integer DEFAULT 0,
    nqs_day_system integer DEFAULT 0,
    nqs_year_verified integer DEFAULT 0,
    nqs_month_verified integer DEFAULT 0,
    nqs_day_verified integer DEFAULT 0,
    dues_deductions_system numeric(18,2) DEFAULT 0,
    compassionate_pension_system numeric(18,2) DEFAULT 0,
    compensation_pension_system numeric(18,2) DEFAULT 0,
    terminal_benefit_system numeric(18,2) DEFAULT 0,
    dues_deductions_verified numeric(18,2) DEFAULT 0,
    compassionate_pension_verified numeric(18,2) DEFAULT 0,
    compensation_pension_verified numeric(18,2) DEFAULT 0,
    terminal_benefit_verified numeric(18,2) DEFAULT 0,
    final_calculated_gratuity_system numeric(18,2) DEFAULT 0,
    final_calculated_gratuity_verified numeric(18,2) DEFAULT 0,
    family_pension_i_start_date_system bigint,
    family_pension_i_start_date_verified bigint,
    family_pension_i_end_date_system bigint,
    family_pension_i_end_date_verified bigint,
    family_pension_ii_start_date_system bigint,
    family_pension_ii_start_date_verified bigint,
    ex_gratia_system numeric(18,2),
    ex_gratia_verified numeric(18,2),
    pensioner_family_pension_system numeric(18,2),
    pensioner_family_pension_verified numeric(18,2),
    total_pension_system numeric(18,2),
    total_pension_verified numeric(18,2),
    provisional_pension_system numeric(18,2),
    provisional_pension_verified numeric(18,2),
    interim_relief_applicable boolean DEFAULT false,
    interim_relief_expression character varying(250) ,
    basic_pension_applicable boolean DEFAULT false,
    basic_pension_expression character varying(250) ,
    provisional_pension_applicable boolean DEFAULT false,
    provisional_pension_expression character varying(250) ,
    compassionate_pension_applicable boolean DEFAULT false,
    compassionate_pension_expression character varying(250) ,
    compensation_pension_applicable boolean DEFAULT false,
    compensation_pension_expression character varying(250) ,
    commuted_pension_applicable boolean DEFAULT false,
    commuted_pension_expression character varying(250) ,
    family_pension_i_applicable boolean DEFAULT false,
    family_pension_i_expression character varying(250) ,
    family_pension_ii_applicable boolean DEFAULT false,
    family_pension_ii_expression character varying(250) ,
    da_applicable boolean DEFAULT false,
    da_expression character varying(250) ,
    additional_pension_applicable boolean DEFAULT false,
    additional_pension_expression character varying(250) ,
    total_pension_applicable boolean DEFAULT false,
    total_pension_expression character varying(250) ,
    pension_deductions_applicable boolean DEFAULT false,
    pension_deductions_expression character varying(250) ,
    net_deductions_applicable boolean DEFAULT false,
    net_deductions_expression character varying(250) ,
    final_calculated_pension_applicable boolean DEFAULT false,
    final_calculated_pension_expression character varying(250) ,
    commutation_value_applicable boolean DEFAULT false,
    commutation_value_expression character varying(250) ,
    dcrg_applicable boolean DEFAULT false,
    dcrg_expression character varying(250) ,
    terminal_benefit_applicable boolean DEFAULT false,
    terminal_benefit_expression character varying(250) ,
    dues_deductions_applicable boolean DEFAULT false,
    dues_deductions_expression character varying(250) ,
    final_calculated_gratuity_applicable boolean DEFAULT false,
    final_calculated_gratuity_expression character varying(250) ,
    ex_gratia_applicable boolean DEFAULT false,
    ex_gratia_expression character varying(250) ,
    pensioner_family_pension_applicable boolean DEFAULT false,
    pensioner_family_pension_expression character varying(250) ,
    invalid_pension_system numeric(18,2),
    wound_extraordinary_pension_system numeric(18,2),
    attendant_allowance_system numeric(18,2),
    invalid_pension_verified numeric(18,2),
    wound_extraordinary_pension_verified numeric(18,2),
    attendant_allowance_verified numeric(18,2),
    invalid_pension_applicable boolean DEFAULT false,
    invalid_pension_expression character varying(250) ,
    wound_extraordinary_pension_applicable boolean DEFAULT false,
    wound_extraordinary_pension_expression character varying(250) ,
    attendant_allowance_applicable boolean DEFAULT false,
    attendant_allowance_expression character varying(250) ,
    gqs_year_system integer DEFAULT 0,
    gqs_month_system integer DEFAULT 0,
    gqs_day_system integer DEFAULT 0,
    gqs_year_verified integer DEFAULT 0,
    gqs_month_verified integer DEFAULT 0,
    gqs_day_verified integer DEFAULT 0,
    notification_text_system character varying ,
    notification_text_verified character varying ,
    CONSTRAINT pk_tbl_pension_calculation_details_audit PRIMARY KEY (uuid),
    CONSTRAINT eg_pension_calculation_details_audi_pension_calculation_id_fkey FOREIGN KEY (pension_calculation_id)
        REFERENCES eg_pension_calculation_details (uuid) 
        ON UPDATE CASCADE
        ON DELETE CASCADE,
    CONSTRAINT tbl_pension_calculation_details_audit_workflow_header_id_fkey FOREIGN KEY (workflow_header_id)
        REFERENCES eg_pension_workflow_header (uuid) 
        ON UPDATE CASCADE
        ON DELETE CASCADE
);
	
-- Table: eg_pension_pensioner

-- DROP TABLE eg_pension_pensioner;

CREATE TABLE eg_pension_pensioner
(
    uuid character varying(1024) NOT NULL,
    tenantid character varying(1024) NOT NULL,
    pension_employee_id character varying(1024) NOT NULL,
    active boolean NOT NULL,
    created_by character varying(1024) NOT NULL,
    last_modified_by character varying(1024) ,
    created_date bigint NOT NULL,
    last_modified_date bigint,
    business_service character varying(128) ,
    dependent_id character varying(1024) ,
    pensioner_number character varying(1024) ,
    CONSTRAINT pk_tbl_pension_pensioner PRIMARY KEY (uuid),
    CONSTRAINT tbl_pension_pensioner_pension_employee_id_fkey FOREIGN KEY (pension_employee_id)
        REFERENCES eg_pension_employee (uuid) 
        ON UPDATE CASCADE
        ON DELETE CASCADE
);
	
-- Table: eg_pension_pensioner_audit

-- DROP TABLE eg_pension_pensioner_audit;

CREATE TABLE eg_pension_pensioner_audit
(
    uuid character varying(1024) NOT NULL,
    pensioner_id character varying(1024) NOT NULL,
    tenantid character varying(1024) NOT NULL,
    pension_employee_id character varying(1024) NOT NULL,
    active boolean NOT NULL,
    created_by character varying(1024) NOT NULL,
    last_modified_by character varying(1024) ,
    created_date bigint NOT NULL,
    last_modified_date bigint,
    business_service character varying(128) ,
    dependent_id character varying(1024) ,
    pensioner_number character varying(1024) ,
    CONSTRAINT pk_eg_pension_pensioner_audit PRIMARY KEY (uuid),
    CONSTRAINT eg_pension_pensioner_audit_pension_employee_id_fkey FOREIGN KEY (pension_employee_id)
        REFERENCES eg_pension_employee (uuid) 
        ON UPDATE CASCADE
        ON DELETE CASCADE,
    CONSTRAINT eg_pension_pensioner_audit_pensioner_id_fkey FOREIGN KEY (pensioner_id)
        REFERENCES eg_pension_pensioner (uuid) 
        ON UPDATE CASCADE
        ON DELETE CASCADE
);



-- Table: eg_pension_pensioner_application_details

-- DROP TABLE eg_pension_pensioner_application_details;

CREATE TABLE eg_pension_pensioner_application_details
(
    uuid character varying(1024) NOT NULL,
    tenantid character varying(1024) NOT NULL,
    pensioner_id character varying(1024) NOT NULL,
    ltc numeric(18,2),
    lpd numeric(18,2),
    pension_arrear numeric(18,2),
    is_da_medical_admissible boolean,
    fma numeric(18,2),
    medical_relief numeric(18,2),
    miscellaneous numeric(18,2),
    over_payment numeric(18,2),
    income_tax numeric(18,2),
    cess numeric(18,2),
    bank_address character varying(1024) ,
    account_number character varying(50) ,
    claimant character varying(50) ,
    wef bigint,
    total_no_pay_leaves_days integer,
    total_no_pay_leaves_months integer,
    total_no_pay_leaves_years integer,
    dues numeric(18,2),
    is_employment_active boolean DEFAULT false,
    is_convicted_serious_crime_or_grave_misconduct boolean DEFAULT false,
    is_any_judicial_proceeding_is_continuing boolean DEFAULT false,
    is_any_misconduct_insolvency_inefficiency boolean DEFAULT false,
    is_employee_dies_in_terrorist_attack boolean DEFAULT false,
    is_employee_dies_in_accidental_death boolean DEFAULT false,
    is_commutation_opted boolean DEFAULT false,
    reason_for_retirement character varying(250) ,
    is_eligible_for_pension boolean DEFAULT false,
    is_dues_present boolean DEFAULT false,
    is_dues_amount_decided boolean DEFAULT false,
    is_taken_monthly_pension_and_gratuity boolean DEFAULT false,
    is_taken_gratuity_commutation_terminal_benefit boolean DEFAULT false,
    is_taken_compensation_pension_and_gratuity boolean DEFAULT false,
    dies_in_extremists_dacoits_smuggler_antisocial_attack boolean DEFAULT false,
    is_compassionate_pension_granted boolean DEFAULT false,
    no_dues_for_avail_govt_accomodation boolean DEFAULT false,
    employee_group character varying(250) ,
    active boolean NOT NULL,
    created_by character varying(1024) NOT NULL,
    last_modified_by character varying(1024) ,
    created_date bigint NOT NULL,
    last_modified_date bigint,
    date_of_contingent bigint,
    CONSTRAINT pk_eg_pension_pensioner_application_details PRIMARY KEY (uuid),
    CONSTRAINT eg_pension_pensioner_application_details_pensioner_id_fkey FOREIGN KEY (pensioner_id)
        REFERENCES eg_pension_pensioner (uuid) 
        ON UPDATE CASCADE
        ON DELETE CASCADE
);
	
-- Table: eg_pension_pensioner_final_calculated_benefit

-- DROP TABLE eg_pension_pensioner_final_calculated_benefit;

CREATE TABLE eg_pension_pensioner_final_calculated_benefit
(
    uuid character varying(1024) NOT NULL,
    tenantid character varying(1024) NOT NULL,
    pensioner_id character varying(1024) NOT NULL,
    basic_pension numeric(18,2),
    pension_deductions numeric(18,2),
    additional_pension numeric(18,2),
    commuted_pension numeric(18,2),
    commuted_value numeric(18,2),
    family_pension_i numeric(18,2),
    family_pension_ii numeric(18,2),
    dcrg numeric(18,2),
    net_deductions numeric(18,2),
    final_calculated_pension numeric(18,2),
    interim_relief numeric(18,2),
    da numeric(18,2),
    nqs_year integer,
    nqs_month integer,
    nqs_day integer,
    dues_deductions numeric(18,2),
    compassionate_pension numeric(18,2),
    compensation_pension numeric(18,2),
    terminal_benefit numeric(18,2),
    final_calculated_gratuity numeric(18,2),
    family_pension_i_start_date bigint,
    family_pension_i_end_date bigint,
    family_pension_ii_start_date bigint,
    ex_gratia numeric(18,2),
    pensioner_family_pension numeric(18,2),
    total_pension numeric(18,2),
    provisional_pension numeric(18,2),
    active boolean NOT NULL,
    created_by character varying(1024) NOT NULL,
    last_modified_by character varying(1024) ,
    created_date bigint NOT NULL,
    last_modified_date bigint,
    wound_extraordinary_pension numeric(18,2),
    attendant_allowance numeric(18,2),
    invalid_pension numeric(18,2),
    CONSTRAINT pk_eg_pension_pensioner_final_calculated_benefit PRIMARY KEY (uuid),
    CONSTRAINT eg_pension_pensioner_final_calculated_benefit_pensioner_id_fkey FOREIGN KEY (pensioner_id)
        REFERENCES eg_pension_pensioner (uuid) 
        ON UPDATE CASCADE
        ON DELETE CASCADE
);

-- Table: eg_pension_revision

-- DROP TABLE eg_pension_revision;

CREATE TABLE eg_pension_revision
(
    uuid character varying(1024) NOT NULL,
    tenantid character varying(1024) NOT NULL,
    pensioner_id character varying(1024) NOT NULL,
    effective_start_year integer,
    effective_start_month integer,
    effective_end_year integer,
    effective_end_month integer,
    pension_arrear numeric(18,2),
    fma numeric(18,2),
    miscellaneous numeric(18,2),
    over_payment numeric(18,2),
    income_tax numeric(18,2),
    cess numeric(18,2),
    basic_pension numeric(18,2),
    additional_pension numeric(18,2),
    commuted_pension numeric(18,2),
    net_deductions numeric(18,2),
    final_calculated_pension numeric(18,2),
    active boolean NOT NULL,
    created_by character varying(1024) NOT NULL,
    last_modified_by character varying(1024) ,
    created_date bigint NOT NULL,
    last_modified_date bigint,
    interim_relief numeric(18,2),
    da numeric(18,2),
    total_pension numeric(18,2),
    pension_deductions numeric(18,2),
    pensioner_final_calculated_benefit_id character varying(1024) ,
    remarks character varying(250) ,
    wound_extraordinary_pension numeric(18,2),
    attendant_allowance numeric(18,2),
    CONSTRAINT pk_eg_pension_revision PRIMARY KEY (uuid),
    CONSTRAINT eg_pension_revision_pensioner_final_calculated_benefit_id_fkey FOREIGN KEY (pensioner_final_calculated_benefit_id)
        REFERENCES eg_pension_pensioner_final_calculated_benefit (uuid) 
        ON UPDATE CASCADE
        ON DELETE CASCADE,
    CONSTRAINT eg_pension_revision_pensioner_id_fkey FOREIGN KEY (pensioner_id)
        REFERENCES eg_pension_pensioner (uuid) 
        ON UPDATE CASCADE
        ON DELETE CASCADE
);

-- Table: eg_pension_revision_audit

-- DROP TABLE eg_pension_revision_audit;

CREATE TABLE eg_pension_revision_audit
(
    uuid character varying(1024) NOT NULL,
    pension_revision_id character varying(1024) NOT NULL,
    tenantid character varying(1024) NOT NULL,
    pensioner_id character varying(1024) NOT NULL,
    effective_start_year integer,
    effective_start_month integer,
    effective_end_year integer,
    effective_end_month integer,
    pension_arrear numeric(18,2),
    fma numeric(18,2),
    miscellaneous numeric(18,2),
    over_payment numeric(18,2),
    income_tax numeric(18,2),
    cess numeric(18,2),
    basic_pension numeric(18,2),
    additional_pension numeric(18,2),
    commuted_pension numeric(18,2),
    net_deductions numeric(18,2),
    final_calculated_pension numeric(18,2),
    active boolean NOT NULL,
    created_by character varying(1024) NOT NULL,
    last_modified_by character varying(1024) ,
    created_date bigint NOT NULL,
    last_modified_date bigint,
    interim_relief numeric(18,2),
    da numeric(18,2),
    total_pension numeric(18,2),
    pension_deductions numeric(18,2),
    pensioner_final_calculated_benefit_id character varying(1024) ,
    remarks character varying(250) ,
    wound_extraordinary_pension numeric(18,2),
    attendant_allowance numeric(18,2),
    CONSTRAINT pk_eg_pension_revision_audit PRIMARY KEY (uuid),
    CONSTRAINT eg_pension_revision_audit_pension_revision_id_fkey FOREIGN KEY (pension_revision_id)
        REFERENCES eg_pension_revision (uuid) 
        ON UPDATE CASCADE
        ON DELETE CASCADE,
    CONSTRAINT eg_pension_revision_audit_pensioner_final_calculated_benef_fkey FOREIGN KEY (pensioner_final_calculated_benefit_id)
        REFERENCES eg_pension_pensioner_final_calculated_benefit (uuid) 
        ON UPDATE CASCADE
        ON DELETE CASCADE,
    CONSTRAINT eg_pension_revision_audit_pensioner_id_fkey FOREIGN KEY (pensioner_id)
        REFERENCES eg_pension_pensioner (uuid) 
        ON UPDATE CASCADE
        ON DELETE CASCADE
);

-- Table: eg_pension_register

-- DROP TABLE eg_pension_register;

CREATE TABLE eg_pension_register
(
    uuid character varying(1024) NOT NULL,
    tenantid character varying(1024) NOT NULL,
    pensioner_id character varying(1024) NOT NULL,
    effective_year integer,
    effective_month integer,
    pension_arrear numeric(18,2),
    fma numeric(18,2),
    miscellaneous numeric(18,2),
    over_payment numeric(18,2),
    income_tax numeric(18,2),
    cess numeric(18,2),
    basic_pension numeric(18,2),
    additional_pension numeric(18,2),
    commuted_pension numeric(18,2),
    net_deductions numeric(18,2),
    final_calculated_pension numeric(18,2),
    interim_relief numeric(18,2),
    da numeric(18,2),
    total_pension numeric(18,2),
    pension_deductions numeric(18,2),
    active boolean NOT NULL,
    created_by character varying(1024) NOT NULL,
    last_modified_by character varying(1024) ,
    created_date bigint NOT NULL,
    last_modified_date bigint,
    wound_extraordinary_pension numeric(18,2),
    attendant_allowance numeric(18,2),
    CONSTRAINT pk_eg_pension_register PRIMARY KEY (uuid),
    CONSTRAINT eg_pension_register_pensioner_id_fkey FOREIGN KEY (pensioner_id)
        REFERENCES eg_pension_pensioner (uuid) 
        ON UPDATE CASCADE
        ON DELETE CASCADE
);

-- Table: eg_pension_register_audit

-- DROP TABLE eg_pension_register_audit;

CREATE TABLE eg_pension_register_audit
(
    uuid character varying(1024) NOT NULL,
    pension_register_id character varying(1024) NOT NULL,
    tenantid character varying(1024) NOT NULL,
    pensioner_id character varying(1024) NOT NULL,
    effective_year integer,
    effective_month integer,
    pension_arrear numeric(18,2),
    fma numeric(18,2),
    miscellaneous numeric(18,2),
    over_payment numeric(18,2),
    income_tax numeric(18,2),
    cess numeric(18,2),
    basic_pension numeric(18,2),
    additional_pension numeric(18,2),
    commuted_pension numeric(18,2),
    net_deductions numeric(18,2),
    final_calculated_pension numeric(18,2),
    interim_relief numeric(18,2),
    da numeric(18,2),
    total_pension numeric(18,2),
    pension_deductions numeric(18,2),
    active boolean NOT NULL,
    created_by character varying(1024) NOT NULL,
    last_modified_by character varying(1024) ,
    created_date bigint NOT NULL,
    last_modified_date bigint,
    wound_extraordinary_pension numeric(18,2),
    attendant_allowance numeric(18,2),
    CONSTRAINT pk_eg_pension_register_audit PRIMARY KEY (uuid),
    CONSTRAINT eg_pension_register_audit_pension_register_id_fkey FOREIGN KEY (pension_register_id)
        REFERENCES eg_pension_register (uuid) 
        ON UPDATE CASCADE
        ON DELETE CASCADE,
    CONSTRAINT eg_pension_register_audit_pensioner_id_fkey FOREIGN KEY (pensioner_id)
        REFERENCES eg_pension_pensioner (uuid) 
        ON UPDATE CASCADE
        ON DELETE CASCADE
);

-- Table: eg_pension_recomputation_register

-- DROP TABLE eg_pension_recomputation_register;

CREATE TABLE eg_pension_recomputation_register
(
    uuid character varying(1024) NOT NULL,
    tenantid character varying(1024) NOT NULL,
    closed_workflow_header_id character varying(1024) NOT NULL,
    new_workflow_header_id character varying(250) NOT NULL,
    active boolean NOT NULL,
    created_by character varying(1024) ,
    last_modified_by character varying(1024) ,
    created_date bigint,
    last_modified_date bigint,
    CONSTRAINT pk_eg_pension_recomputation_register PRIMARY KEY (uuid),
    CONSTRAINT eg_pension_recomputation_register_last_workflow_header_id_fkey FOREIGN KEY (closed_workflow_header_id)
        REFERENCES eg_pension_workflow_header (uuid) 
        ON UPDATE CASCADE
        ON DELETE CASCADE,
    CONSTRAINT eg_pension_recomputation_register_new_workflow_header_id_fkey FOREIGN KEY (new_workflow_header_id)
        REFERENCES eg_pension_workflow_header (uuid) 
        ON UPDATE CASCADE
        ON DELETE CASCADE
);