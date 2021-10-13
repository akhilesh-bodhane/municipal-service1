--Adding payment from and to date for manimajra
ALTER TABLE cs_ep_offline_payment_detail
ADD COLUMN from_date CHARACTER VARYING (20);

ALTER TABLE cs_ep_offline_payment_detail
ADD COLUMN to_date CHARACTER VARYING (20);