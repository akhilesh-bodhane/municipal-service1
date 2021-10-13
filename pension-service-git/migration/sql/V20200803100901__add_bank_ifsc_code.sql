ALTER TABLE eg_pension_employee_other_details ADD bank_code varchar(50) NULL;
ALTER TABLE eg_pension_employee_other_details ADD bank_ifsc varchar(50) NULL;

ALTER TABLE eg_pension_employee_other_details_audit ADD bank_code varchar(50) NULL;
ALTER TABLE eg_pension_employee_other_details_audit ADD bank_ifsc varchar(50) NULL;

ALTER TABLE eg_pension_dependent ADD bank_code varchar(50) NULL;
ALTER TABLE eg_pension_dependent ADD bank_ifsc varchar(50) NULL;

ALTER TABLE eg_pension_dependent_audit ADD bank_code varchar(50) NULL;
ALTER TABLE eg_pension_dependent_audit ADD bank_ifsc varchar(50) NULL;

ALTER TABLE eg_pension_pensioner_application_details ADD bank_code varchar(50) NULL;
ALTER TABLE eg_pension_pensioner_application_details ADD bank_ifsc varchar(50) NULL;