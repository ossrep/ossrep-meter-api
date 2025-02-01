insert into iso values (1, 'ERCOT', 'Electric Reliability Council of Texas');

insert into tdsp values (1, 1, 'ONCOR', 'Oncor');
insert into tdsp values (2, 1, 'CENTERPOINT', 'Centerpoint');

INSERT INTO meter (tdsp_id, tdsp_meter_id)
SELECT
    1, -- Constant tdsp_id
    'test-' || lpad((generate_series + 1000000)::text, 10, '0') -- Generates unique tdsp_meter_id
FROM generate_series(1, 2000000);