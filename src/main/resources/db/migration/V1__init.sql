CREATE SCHEMA IF NOT EXISTS util_sch;
CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

CREATE TABLE IF NOT EXISTS util_sch.reference_type
(
    id                        uuid DEFAULT uuid_generate_v4(),
    first_name                VARCHAR NOT NULL,
    last_name                 VARCHAR NOT NULL,
    age                       INT NOT NULL,
    phone_number              VARCHAR NOT NULL UNIQUE,
    nationality               VARCHAR NOT NULL,
    created_date              DATE NOT NULL,
    created_by                VARCHAR,
    updated_date              DATE NOT NULL,
    updated_by                VARCHAR,
    version                   INT NOT NULL,
    PRIMARY KEY (id)
);
