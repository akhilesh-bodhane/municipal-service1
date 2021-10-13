
ALTER TABLE eg_device_source_detail
DROP COLUMN referance_id;

ALTER TABLE eg_device_source_detail
ADD referance_uuid varchar(256);