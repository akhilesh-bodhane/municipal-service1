ALTER TABLE eg_ws_service   
 
add column lastmeterreading     numeric(12,3),  
add column proposed_lastmeterreading     numeric(12,3);
 
ALTER TABLE eg_ws_service_audit   
add column lastmeterreading     numeric(12,3),  
add column proposed_lastmeterreading     numeric(12,3);
 
 
 
ALTER TABLE eg_ws_application   
add column additionalCharges     numeric,  
add column constructionCharges     numeric, 
add column outstandingCharges     numeric, 
add column paymentMode     varchar;