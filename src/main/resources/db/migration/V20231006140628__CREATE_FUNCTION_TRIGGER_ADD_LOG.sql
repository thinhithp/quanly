CREATE OR REPLACE FUNCTION audit_table_changes()
    RETURNS TRIGGER AS $$
BEGIN
    INSERT INTO audit_log (table_name, record_id, update_time, updated_by, update_details)
    VALUES (TG_TABLE_NAME, NEW.user_id, NOW(), CURRENT_USER, to_jsonb(NEW));
    RETURN NEW;
END;
$$ LANGUAGE plpgsql;

CREATE TRIGGER table_audit_trigger
    AFTER INSERT OR UPDATE OR DELETE ON users
    FOR EACH ROW
EXECUTE FUNCTION audit_table_changes();