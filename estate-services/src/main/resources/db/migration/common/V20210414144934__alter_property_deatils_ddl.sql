--Increasing area_sqft size
ALTER Table cs_ep_property_details_v1 ALTER COLUMN area_sqft TYPE numeric(17,2);

ALTER Table cs_ep_property_details_audit_v1 ALTER COLUMN area_sqft TYPE numeric(17,2);