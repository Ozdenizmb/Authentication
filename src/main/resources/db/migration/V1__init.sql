CREATE SCHEMA IF NOT EXISTS util_sch;
CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

CREATE TABLE IF NOT EXISTS util_sch.users
(
    id                        uuid DEFAULT uuid_generate_v4(),
    first_name                VARCHAR NOT NULL,
    last_name                 VARCHAR NOT NULL,
    email                     VARCHAR NOT NULL,
    password                  VARCHAR NOT NULL UNIQUE,
    age                       INT NOT NULL,
    phone_number              VARCHAR NOT NULL UNIQUE,
    nationality               VARCHAR NOT NULL,
    created_date              DATE NOT NULL,
    updated_date              DATE NOT NULL,
    version                   INT NOT NULL,
    PRIMARY KEY (id)
);
