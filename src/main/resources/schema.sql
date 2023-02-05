CREATE SCHEMA item_service;

CREATE TABLE item_service.items
(
    uuid              uuid              NOT NULL,
    dt_create         timestamp without time zone NOT NULL,
    dt_update         timestamp without time zone NOT NULL,
    title             character varying NOT NULL,
    description       character varying NOT NULL,
    CONSTRAINT collections_pk PRIMARY KEY (uuid)
);