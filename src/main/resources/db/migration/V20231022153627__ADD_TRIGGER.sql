CREATE SEQUENCE san_pham_id_seq;

CREATE OR REPLACE FUNCTION increment_san_pham_id()
    RETURNS TRIGGER AS $$
BEGIN
    -- Tăng giá trị ID từ trình tự san_pham_id_seq và gán cho NEW.id
    NEW.id := nextval('san_pham_id_seq');
    RETURN NEW;
END;
$$ LANGUAGE plpgsql;

CREATE TRIGGER trigger_increment_san_pham_id
    BEFORE INSERT ON san_pham
    FOR EACH ROW
EXECUTE FUNCTION increment_san_pham_id();

--------
