---adding dummy proeprty flag

ALTER TABLE cs_ep_property_v1
ADD COLUMN is_dummy_property boolean;

ALTER TABLE cs_ep_property_audit_v1
ADD COLUMN is_dummy_property boolean;

