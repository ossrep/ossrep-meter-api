CREATE TYPE state_us AS ENUM (
    'AL', 'AK', 'AZ', 'AR', 'CA', 'CO', 'CT', 'DE', 'FL', 'GA', 'HI', 'ID', 'IL', 'IN', 'IA', 'KS', 'KY', 'LA', 'ME',
    'MD', 'MA', 'MI', 'MN', 'MS', 'MO', 'MT', 'NE', 'NV', 'NH', 'NJ', 'NM', 'NY', 'NC', 'ND', 'OH', 'OK', 'OR', 'PA',
    'RI', 'SC', 'SD', 'TN', 'TX', 'UT', 'VT', 'VA', 'WA', 'WV', 'WI', 'WY'
    );


CREATE TYPE iso_us AS ENUM ('CAISO', 'ERCOT', 'ISONE', 'MISO', 'NYISO', 'PJM', 'SPP');

CREATE TABLE tdsp
(
    tdsp_id SMALLSERIAL PRIMARY KEY,
    iso     iso_us NOT NULL,
    code    TEXT   NOT NULL,
    name    TEXT   NOT NULL
);

INSERT INTO tdsp (iso, code, name)
VALUES ('ERCOT', 'ONCOR', 'Oncor Electric Delivery'),
       ('ERCOT', 'CNP', 'CenterPoint Energy'),
       ('ERCOT', 'TNMP', 'Texas-New Mexico Power (TNMP)'),
       ('ERCOT', 'AEP-TX', 'AEP Texas'),
       ('ERCOT', 'SHARY', 'Sharyland Utilities'),
       ('ERCOT', 'AE', 'Austin Energy'),
       ('ERCOT', 'CPS', 'CPS Energy');


CREATE TABLE meter
(
    meter_id       BIGSERIAL PRIMARY KEY,
    tdsp_id        SMALLINT REFERENCES tdsp (tdsp_id),
    tdsp_meter_id  TEXT NOT NULL,
    address_line_1 TEXT NOT NULL,
    address_line_2 TEXT,
    city           TEXT NOT NULL,
    state          state_us NOT NULL,
    zip_code       CHAR(5) NOT NULL
);
ALTER SEQUENCE meter_meter_id_seq RESTART 1000000000000000000;