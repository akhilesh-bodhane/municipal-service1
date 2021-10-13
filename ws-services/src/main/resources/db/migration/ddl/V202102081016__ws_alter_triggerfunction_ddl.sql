
DROP TRIGGER IF EXISTS update_ws_bill_trigger ON eg_ws_savebilling;
CREATE TRIGGER update_ws_bill_trigger 
AFTER UPDATE ON eg_ws_savebilling
FOR EACH ROW 
EXECUTE PROCEDURE insert_ws_billing_audit_data();