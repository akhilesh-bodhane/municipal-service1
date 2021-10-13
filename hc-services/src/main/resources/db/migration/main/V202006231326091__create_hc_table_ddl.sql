
CREATE TABLE eg_hc_service_request(
    service_request_uuid CHARACTER VARYING(64) NOT NULL,
    owner_name CHARACTER VARYING(255) NOT NULL,
    tenant_id CHARACTER VARYING(128),
    location CHARACTER VARYING(257),
    latitude CHARACTER VARYING(257) NOT NULL,
    longitude CHARACTER VARYING(257) NOT NULL,
    locality CHARACTER VARYING(257) NOT NULL,
    street_name CHARACTER VARYING(256) NOT NULL,
    landmark CHARACTER VARYING(259),
    contact_number CHARACTER VARYING(50) NOT NULL,
    email_id CHARACTER VARYING(255) NOT NULL,
    tree_count INTEGER NOT NULL,
    service_request_document JSONB,
    service_request_status CHARACTER VARYING(255),
    service_request_id CHARACTER VARYING(256) NOT NULL,
    service_type CHARACTER VARYING(64) NOT NULL,
    description CHARACTER VARYING(256),
    current_assignee CHARACTER VARYING(256),
    history_service_request_id CHARACTER VARYING(256),
    servicerequest_lang CHARACTER VARYING(256),
    createdby CHARACTER VARYING(64),
    createdtime BIGINT,
    lastmodifiedby CHARACTER VARYING(64),
    lastmodifiedtime BIGINT,
    
    CONSTRAINT pk_eg_hc_service_request PRIMARY KEY (service_request_uuid)
   );
   
