INSERT INTO id_generator(
	idname, tenantid, format, sequencenumber)
	VALUES ('pension.rrp.application.number', 'ch', 'CH-RR-[cy:yyyy-MM-dd]-[SEQ_EG_PENSION_RR_APL]', 1);
	
INSERT INTO id_generator(
	idname, tenantid, format, sequencenumber)
	VALUES ('pension.doe.application.number', 'ch', 'CH-DE-[cy:yyyy-MM-dd]-[SEQ_EG_PENSION_DE_APL]', 1);
	
INSERT INTO id_generator(
	idname, tenantid, format, sequencenumber)
	VALUES ('pension.dop.application.number', 'ch', 'CH-DP-[cy:yyyy-MM-dd]-[SEQ_EG_PENSION_DP_APL]', 1);
	
INSERT INTO id_generator(
	idname, tenantid, format, sequencenumber)
	VALUES ('pension.pensioner.number', 'ch', 'CH-PN-[SEQ_EG_PENSION_PN_APL]', 1);