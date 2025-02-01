CREATE TABLE iso
(
    iso_id SMALLINT PRIMARY KEY,
    code   TEXT NOT NULL UNIQUE,
    name   TEXT NOT NULL
);

CREATE TABLE tdsp
(
    tdsp_id SMALLINT PRIMARY KEY,
    iso_id  SMALLINT REFERENCES iso (iso_id),
    code    TEXT NOT NULL UNIQUE,
    name    TEXT NOT NULL
);

CREATE TABLE meter
(
    meter_id      BIGSERIAL PRIMARY KEY,
    tdsp_id       SMALLINT REFERENCES tdsp (tdsp_id),
    tdsp_meter_id TEXT NOT NULL UNIQUE
);
CREATE INDEX idx_meter_tdsp_meter_id ON meter (tdsp_meter_id);
ALTER SEQUENCE meter_meter_id_seq RESTART 1000000000000000000;
