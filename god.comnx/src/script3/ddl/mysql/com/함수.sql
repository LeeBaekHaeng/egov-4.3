DELIMITER //

CREATE FUNCTION to_camel_case(input VARCHAR(255))
RETURNS VARCHAR(255)
DETERMINISTIC
BEGIN
    DECLARE i INT DEFAULT 1;
    DECLARE len INT;
    DECLARE ch CHAR(1);
    DECLARE result VARCHAR(255) DEFAULT '';
    DECLARE upper_next BOOLEAN DEFAULT FALSE;

    SET len = CHAR_LENGTH(input);

    WHILE i <= len DO
        SET ch = SUBSTRING(input, i, 1);

        IF ch = '_' THEN
            SET upper_next = TRUE;
        ELSE
            IF upper_next THEN
                SET result = CONCAT(result, UPPER(ch));
                SET upper_next = FALSE;
            ELSE
                SET result = CONCAT(result, LOWER(ch));
            END IF;
        END IF;

        SET i = i + 1;
    END WHILE;

    RETURN result;
END;
//

DELIMITER ;

GRANT EXECUTE ON com.* TO 'com'@'%';
