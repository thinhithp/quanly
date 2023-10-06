-- ROLE
ALTER TABLE users
    ADD role_temp VARCHAR(100);
UPDATE users
SET role_temp = role
WHERE users.user_id IS NOT NULL;

      UPDATE users
SET role = NULL
    WHERE users.user_id IS NOT NULL;

ALTER TABLE users
    ALTER COLUMN role TYPE NUMERIC(2);

UPDATE users HSTT
SET role = (SELECT C2.MA
                  FROM THAM_SO_HE_THONG C2
                  WHERE C2.LOAI = 'ROLE'
                    AND C2.TEN = HSTT.role_temp)
WHERE user_id IS NOT NULL;

ALTER TABLE users
    DROP COLUMN role_temp;
-----------------------------------