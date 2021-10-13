ALTER TABLE eg_ws_savebilling
ADD COLUMN fromDate bigInt,
add column toDate bigInt;

ALTER TABLE eg_ws_savebilling_audit
ADD COLUMN fromDate bigInt,
add column toDate bigInt;

CREATE OR REPLACE FUNCTION insert_ws_billing_audit_data()
  RETURNS trigger
  LANGUAGE plpgsql
AS
$$
BEGIN
    INSERT INTO eg_ws_savebilling_audit ( id, cccode, divsdiv, consumercode, billcycle, billgroup, subgroup, billtype, name, address, cesscharge, netamount, grossamount, surcharge, totalnetamount, totalsurcharge, totalgrossamount, fixchargecode, fixcharge, duedatecash, duedatecheque, status, billid, paymentid, paymentstatus,totalAmount_paid,paymentMode,isFileGenerated, createdby, createdtime,lastmodifiedby,lastmodifiedtime,fromDate,toDate )
         VALUES(OLD.id,OLD.cccode,OLD.divsdiv,OLD.consumercode,OLD.billcycle,OLD.billgroup,OLD.subgroup,OLD.billtype,OLD.name,OLD.address,OLD.cesscharge,OLD.netamount,OLD.grossamount,OLD.surcharge,OLD.totalnetamount,OLD.totalsurcharge,OLD.totalgrossamount,OLD.fixchargecode,OLD.fixcharge,OLD.duedatecash,OLD.duedatecheque,OLD.status,OLD.billid,OLD.paymentid,OLD.paymentstatus,old.totalAmount_paid,old.paymentMode,old.isFileGenerated, old.createdby,old.createdtime,old.lastmodifiedby,old.lastmodifiedtime,old.fromDate,old.toDate);

RETURN OLD;
END;
$$;