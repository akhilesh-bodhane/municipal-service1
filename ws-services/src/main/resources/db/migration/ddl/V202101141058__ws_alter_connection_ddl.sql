alter table eg_ws_savebilling  add constraint eg_ws_savebilling_uniquekey UNIQUE (consumercode);

ALTER TABLE eg_ws_connection  
ADD COLUMN ledgerGroup varchar;


ALTER TABLE eg_ws_service  
ADD COLUMN meterCount varchar,
ADD COLUMN meterRentCode varchar,
ADD COLUMN mfrCode varchar,
ADD COLUMN meterDigits varchar,
ADD COLUMN meterUnit varchar,   
ADD COLUMN sanctionedCapacity varchar ;