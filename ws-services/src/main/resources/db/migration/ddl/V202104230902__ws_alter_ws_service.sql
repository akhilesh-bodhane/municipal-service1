ALTER TABLE eg_ws_service   
add column proposed_meterid   character varying(64), 
add column proposed_meterinstallationdate   bigint, 
add column proposed_initialmeterreading     numeric(12,3), 
add COLUMN proposed_metercount   varchar(64),
add COLUMN proposed_meterrentcode   varchar,
add COLUMN proposed_mfrcode   varchar(32),
add COLUMN proposed_meterdigits   varchar(64),
add COLUMN proposed_sanctionedcapacity   varchar(128),
add COLUMN proposed_meterunit    varchar(64);
 


ALTER TABLE eg_ws_service_audit   
add column proposed_meterid   character varying(64), 
add column proposed_meterinstallationdate   bigint, 
add column proposed_initialmeterreading     numeric(12,3), 
add COLUMN proposed_metercount   varchar(64),
add COLUMN proposed_meterrentcode   varchar,
add COLUMN proposed_mfrcode   varchar(32),
add COLUMN proposed_meterdigits   varchar(64),
add COLUMN proposed_sanctionedcapacity   varchar(128),
add COLUMN proposed_meterunit    varchar(64);
 