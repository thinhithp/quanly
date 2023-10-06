CREATE TABLE audit_log (
                           id SERIAL PRIMARY KEY,
                           table_name VARCHAR(255),
                           record_id UUID,
                           update_time TIMESTAMP,
                           updated_by VARCHAR(255),
                           update_details JSONB
);