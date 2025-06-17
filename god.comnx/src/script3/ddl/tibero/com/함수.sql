CREATE OR REPLACE FUNCTION TO_CAMEL_CASE(p_str VARCHAR2)
RETURN VARCHAR2
IS
    v_result   VARCHAR2(4000) := '';
    v_upper    BOOLEAN := FALSE;
    v_char     CHAR;
BEGIN
    FOR i IN 1..LENGTH(p_str) LOOP
        v_char := SUBSTR(p_str, i, 1);

        IF v_char = '_' THEN
            v_upper := TRUE;
        ELSE
            IF v_upper THEN
                v_result := v_result || UPPER(v_char);
                v_upper := FALSE;
            ELSE
                v_result := v_result || LOWER(v_char);
            END IF;
        END IF;
    END LOOP;

    RETURN v_result;
END;
/
