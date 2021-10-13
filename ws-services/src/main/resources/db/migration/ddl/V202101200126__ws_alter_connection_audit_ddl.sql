ALTER TABLE eg_ws_connection 
alter COLUMN cccode type varchar(8),
alter COLUMN ledger_no type varchar(8),
alter COLUMN subdiv type varchar(8),
alter COLUMN ledgergroup type varchar(8),
alter COLUMN div type  varchar(8);


ALTER TABLE eg_ws_service 
alter COLUMN metercount type varchar(64),
alter COLUMN meterrentcode type varchar,
alter COLUMN mfrcode type varchar(32),
alter COLUMN meterdigits type varchar(64),
alter COLUMN sanctionedcapacity type varchar(128),
alter COLUMN meterunit type  varchar(64);

ALTER TABLE eg_ws_connection_audit  
ADD COLUMN cccode character varying(8),
ADD COLUMN div character varying(8),
ADD COLUMN subdiv character varying(8),
ADD COLUMN ledger_no character varying(8),
ADD COLUMN ledgergroup character varying(8);


ALTER TABLE eg_ws_service_audit  
ADD COLUMN meterCount varchar(64),
ADD COLUMN meterRentCode varchar(64),
ADD COLUMN mfrCode varchar(32),
ADD COLUMN meterDigits varchar(64),
ADD COLUMN meterUnit varchar(64),   
ADD COLUMN sanctionedCapacity varchar(128) ;