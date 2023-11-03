ALTER TABLE tag
    ADD COLUMN id_new SERIAL PRIMARY KEY ;
------
UPDATE tag
SET id_new = id;
------
ALTER TABLE tag
    DROP COLUMN id CASCADE;
-----
ALTER TABLE tag
    RENAME COLUMN id_new TO id;
