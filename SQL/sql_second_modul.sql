set global log_bin_trust_function_creators = 1;

CREATE TABLE BOOKS
(
    BOOK_ID int(11)      NOT NULL AUTO_INCREMENT,
    TITLE   varchar(225) NOT NULL,
    PUBYEAR int(4)       NOT NULL,
    PRIMARY KEY (BOOK_ID)
)

SELECT *
FROM BOOKS;

CREATE TABLE READERS
(
    READER_ID int(11)      NOT NULL AUTO_INCREMENT,
    FIRSTNAME varchar(222) NOT NULL,
    LASTNAME  varchar(255) NOT NULL,
    PESELID   varchar(11),
    PRIMARY KEY (READER_ID)
)

SELECT *
FROM READERS;

CREATE TABLE RENTS
(
    RENT_ID     int(11)  NOT NULL AUTO_INCREMENT,
    BOOK_ID     int(11)  NOT NULL,
    READER_ID   int(11)  NOT NULL,
    RENT_DATE   datetime NOT NULL,
    RETURN_DATE datetime,
    PRIMARY KEY (RENT_ID),
    FOREIGN KEY (BOOK_ID) REFERENCES BOOKS (BOOK_ID),
    FOREIGN KEY (READER_ID) REFERENCES READERS (READER_ID)
)

SELECT *
FROM RENTS;

USE kodilla_course;

INSERT INTO READERS(FIRSTNAME, LASTNAME, PESELID)
VALUES ('John', 'Smith', '83012217938');

INSERT INTO READERS(FIRSTNAME, LASTNAME, PESELID)
VALUES ('Curtis', 'Wilson', '75121002790');

INSERT INTO READERS(FIRSTNAME, LASTNAME, PESELID)
VALUES ('Cathy', 'Booker', '90112801727');

INSERT INTO READERS(FIRSTNAME, LASTNAME, PESELID)
VALUES ('Marissa', 'Cain', '84061908044');

INSERT INTO READERS(FIRSTNAME, LASTNAME, PESELID)
VALUES ('Muriel', 'Fulton', '76081409269');

COMMIT;

SELECT *
FROM READERS;

INSERT INTO BOOKS(TITLE, PUBYEAR)
VALUES ('The Stranger', 1942);

INSERT INTO BOOKS(TITLE, PUBYEAR)
VALUES ('In Search of Lost Time', 1927);

INSERT INTO BOOKS(TITLE, PUBYEAR)
VALUES ('In Search of Lost Time', 1925);

INSERT INTO BOOKS(TITLE, PUBYEAR)
VALUES ('The Little Prince', 1943);

INSERT INTO BOOKS(TITLE, PUBYEAR)
VALUES ('Mans Fate', 1933);

COMMIT;

SELECT *
FROM BOOKS;

INSERT INTO RENTS(BOOK_ID, READER_ID, RENT_DATE, RETURN_DATE)
VALUES (1, 1, DATE_SUB(CURDATE(), INTERVAL 10 DAY), null);

INSERT INTO RENTS(BOOK_ID, READER_ID, RENT_DATE, RETURN_DATE)
VALUES (2, 1, DATE_SUB(CURDATE(), INTERVAL 10 DAY), null);

INSERT INTO RENTS(BOOK_ID, READER_ID, RENT_DATE, RETURN_DATE)
VALUES (4, 1, DATE_SUB(CURDATE(), INTERVAL 10 DAY), DATE_SUB(CURDATE(), INTERVAL 5 DAY));

INSERT INTO RENTS(BOOK_ID, READER_ID, RENT_DATE, RETURN_DATE)
VALUES (1, 3, DATE_SUB(CURDATE(), INTERVAL 8 DAY), null);

INSERT INTO RENTS(BOOK_ID, READER_ID, RENT_DATE, RETURN_DATE)
VALUES (5, 3, DATE_SUB(CURDATE(), INTERVAL 4 DAY), DATE_SUB(CURDATE(), INTERVAL 2 DAY));

INSERT INTO RENTS(BOOK_ID, READER_ID, RENT_DATE, RETURN_DATE)
VALUES (5, 4, DATE_SUB(CURDATE(), INTERVAL 10 DAY), DATE_SUB(CURDATE(), INTERVAL 8 DAY));

INSERT INTO RENTS(BOOK_ID, READER_ID, RENT_DATE, RETURN_DATE)
VALUES (5, 5, DATE_SUB(CURDATE(), INTERVAL 8 DAY), null);

COMMIT;

SELECT *
FROM RENTS;

DELIMITER $$
CREATE PROCEDURE listBooks()
BEGIN
    SELECT * FROM BOOKS;
end $$
DELIMITER ;
CALL listBooks();


DROP PROCEDURE IF EXISTS ListBooks;
DELIMITER $$
CREATE PROCEDURE ListBooks()
BEGIN
    SELECT BOOK_ID, TITLE, PUBYEAR FROM BOOKS;
end $$
DELIMITER ;
CALL ListBooks();


DROP FUNCTION IF EXISTS VipLevel;
DELIMITER $$
CREATE FUNCTION VipLevel() RETURNS VARCHAR(20)
    DETERMINISTIC
BEGIN
    RETURN 'Standard customer';
end $$
DELIMITER ;
SELECT VipLevel() AS LEVEL;


DROP FUNCTION IF EXISTS VipLevel;
DELIMITER $$
CREATE FUNCTION vipLevel() RETURNS VARCHAR(20)
    DETERMINISTIC
BEGIN
    DECLARE result VARCHAR(20) DEFAULT 'Standard Cust';
    RETURN result;
END $$
DELIMITER ;
SELECT VipLevel() AS LEVEL;


DROP FUNCTION IF EXISTS VipLevel;
DELIMITER $$
CREATE FUNCTION VipLevel(booksrented INT) RETURNS VARCHAR(20)
    DETERMINISTIC
BEGIN
    DECLARE result VARCHAR(20) DEFAULT 'Standard customer';
    IF booksrented >= 10 THEN
        SET result = 'Gold customer';
    ELSEIF booksrented >= 5 AND booksrented < 10 THEN
        SET result = 'Silver Customer';
    ELSEIF booksrented >= 2 AND booksrented < 5 THEN
        SET result = 'Bronze customer';
    ELSE
        SET result = 'Standard customer';
    END IF;
    RETURN result;
END $$
DELIMITER ;
SELECT VipLevel(12) AS LEVEL;

SELECT *
FROM READERS;

DROP FUNCTION IF EXISTS SelectReaderById;
DELIMITER $$
CREATE FUNCTION SelectReaderById(reader_id INT) RETURNS VARCHAR(255)
    DETERMINISTIC
BEGIN
    DECLARE result VARCHAR(255);
    IF reader_id <= 0 THEN
        SET result = 'Wrong Reader Id number';
    ELSEIF reader_id = 1 THEN
        SET result = 'John Smith';
    ELSEIF reader_id = 2 THEN
        SET result = 'Curtin Wilson';
    ELSEIF reader_id = 3 THEN
        SET result = 'Cathy Booker';
    ELSEIF reader_id = 4 THEN
        SET result = 'Marissa Cain';
    ELSEIF reader_id = 5 THEN
        SET result = 'Muriel Fulton';
    ELSE
        SET result = 'Wrong Reader Id number';
    END IF;
    RETURN result;
END $$
DELIMITER ;

SELECT SelectReaderById(5);

ALTER TABLE READERS
    ADD VIP_LEVEL VARCHAR(20);

SELECT *
FROM READERS;

SELECT *
FROM RENTS;


DROP PROCEDURE IF EXISTS UpdateVipLevels;
DELIMITER $$
CREATE PROCEDURE UpdateVipLevels()
BEGIN
    DECLARE BOOKSREAD INT;
    DECLARE DAYS INT;
    DECLARE BOOKSPERMONTH DECIMAL(5, 2);

    SELECT COUNT(*)
    FROM RENTS
    WHERE READER_ID = 3
    INTO BOOKSREAD;

    SELECT DATEDIFF(MAX(RENT_DATE), MIN(RENT_DATE))
    FROM RENTS
    WHERE READER_ID = 3
    INTO DAYS;

    SET BOOKSPERMONTH = BOOKSREAD / DAYS * 30;

    SELECT BOOKSREAD, DAYS, BOOKSPERMONTH;
end $$
DELIMITER ;
CALL UpdateVipLevels();



DROP PROCEDURE IF EXISTS UpdateVipLevels;
DELIMITER $$
CREATE PROCEDURE UpdateVipLevels()
BEGIN
    DECLARE BOOKSREAD, DAYS, RDR_ID INT; -- [1]
    DECLARE BOOKSPERMONTH DECIMAL(5, 2); -- [2]
    DECLARE FINISHED INT DEFAULT 0; -- [3]
    DECLARE ALL_READERS CURSOR FOR SELECT READER_ID FROM READERS; -- [4]
    DECLARE CONTINUE HANDLER FOR NOT FOUND SET FINISHED = 1; -- [5]

    OPEN ALL_READERS; -- [6]
    WHILE (FINISHED = 0) DO -- [7]
    FETCH ALL_READERS INTO RDR_ID; -- [8]
    IF (FINISHED = 0) THEN -- [9]
        SELECT COUNT(*)
        FROM RENTS -- [10]
        WHERE READER_ID = RDR_ID -- [11]
        INTO BOOKSREAD; -- [12]

        SELECT DATEDIFF(MAX(RENT_DATE), MIN(RENT_DATE)) + 1
        FROM RENTS -- [13]
        WHERE READER_ID = RDR_ID -- [14]
        INTO DAYS; -- [15]

        SET BOOKSPERMONTH = BOOKSREAD / DAYS * 30; -- [16]

        UPDATE READERS
        SET VIP_LEVEL = VipLevel(BOOKSPERMONTH) -- [17]
        WHERE READER_ID = RDR_ID; -- [18]
        COMMIT; -- [19]
    END IF; -- [20]
        END WHILE; -- [21]

    CLOSE ALL_READERS; -- [22]
END $$

DELIMITER ;

CALL UpdateVipLevels();

SELECT * FROM READERS;



ALTER TABLE BOOKS ADD BESTSELLERS BOOLEAN;
ALTER TABLE books ADD IS_BESTSELLER VARCHAR(5);
ALTER TABLE BOOKS ADD BOOK_TIMES_RENTED INT;

DROP PROCEDURE IF EXISTS UpdateBestsellers;
DELIMITER $$
CREATE PROCEDURE UpdateBestsellers()
BEGIN
    DECLARE TIMES_RENTED INT DEFAULT 0;
    DECLARE BOOK_TEMP_ID INT;
    DECLARE FINISHED INT DEFAULT 0;
    DECLARE IS_BESTSELLER BOOLEAN;
    DECLARE ALL_BOOKS CURSOR FOR SELECT BOOK_ID FROM RENTS;
    DECLARE CONTINUE HANDLER FOR NOT FOUND SET FINISHED = 1;

    OPEN ALL_BOOKS;
    WHILE(FINISHED = 0)
        DO
            FETCH ALL_BOOKS INTO BOOK_TEMP_ID;
            IF (FINISHED = 0) THEN
                SELECT COUNT(*) FROM RENTS WHERE BOOK_ID = BOOK_TEMP_ID INTO TIMES_RENTED;

                IF TIMES_RENTED < 2 THEN SET IS_BESTSELLER = FALSE;
                ELSE SET IS_BESTSELLER = TRUE;
                END IF;

                UPDATE BOOKS SET books.BESTSELLERS = IS_BESTSELLER WHERE BOOK_ID = BOOK_TEMP_ID;
                UPDATE books SET BOOKS.IS_BESTSELLER = IF(books.BESTSELLERS = 1, 'true', 'false') WHERE BOOK_ID = BOOK_TEMP_ID;
                UPDATE books SET BOOKS.BOOK_TIMES_RENTED = TIMES_RENTED WHERE BOOK_ID = BOOK_TEMP_ID;

                COMMIT;
            END IF;
        END WHILE;
    CLOSE ALL_BOOKS;
END $$
DELIMITER ;

CALL UpdateBestsellers();
SELECT *FROM BOOKS;

SELECT * FROM BOOKS;
SELECT * FROM RENTS;
SELECT * FROM READERS;


# 30.3. Procedury i funkcje – informacje uzupełniające ------------------------------------------------------------------

SHOW PROCEDURE STATUS;
SHOW FUNCTION STATUS;

SHOW CREATE PROCEDURE UpdateVipLevels;

# 30.4 30.4. Wyzwalacze ------------------------------------------------------------------------------------------------

DROP TRIGGER IF EXISTS RENTSCOUNTER;
SET @RENTSQTY = 0;
DELIMITER $$
CREATE TRIGGER RENTSCOUNTER BEFORE INSERT ON RENTS
    FOR EACH ROW
BEGIN
    SET @RENTSQTY = @RENTSQTY + 1;
end $$
DELIMITER ;

SELECT @RENTSQTY;

INSERT INTO RENTS(BOOK_ID, READER_ID, RENT_DATE, RETURN_DATE)
VALUES(1, 3, DATE_SUB(CURDATE(), INTERVAL 5 DAY), NULL);

INSERT INTO RENTS(BOOK_ID, READER_ID, RENT_DATE, RETURN_DATE)
VALUES(2, 3, DATE_SUB(CURDATE(), INTERVAL 2 DAY), NULL);

INSERT INTO RENTS(BOOK_ID, READER_ID, RENT_DATE, RETURN_DATE)
VALUES(3, 1, DATE_SUB(CURDATE(), INTERVAL 5 DAY), NULL);

INSERT INTO RENTS(BOOK_ID, READER_ID, RENT_DATE, RETURN_DATE)
VALUES(2, 4, DATE_SUB(CURDATE(), INTERVAL 3 DAY), NULL);

COMMIT;

DROP TRIGGER IF EXISTS RENTSCOUNTER;

CREATE TABLE RENTS_AUD (
                           EVENT_ID INT(11) NOT NULL AUTO_INCREMENT,
                           EVENT_DATE DATETIME NOT NULL,
                           EVENT_TYPE VARCHAR(10) DEFAULT NULL,
                           RENT_ID INT(11) NOT NULL,
                           OLD_BOOK_ID INT(11),
                           NEW_BOOK_ID INT(11),
                           OLD_READER_ID INT(11),
                           NEW_READER_ID INT(11),
                           OLD_RENT_DATE DATETIME,
                           NEW_RENT_DATE DATETIME,
                           OLD_RETURN_DATE DATETIME,
                           NEW_RETURN_DATE DATETIME,
                           PRIMARY KEY (EVENT_ID)
);



DELIMITER $$
CREATE TRIGGER RENTS_INSERT AFTER INSERT ON RENTS
    FOR EACH ROW
BEGIN
    INSERT INTO RENTS_AUD(EVENT_DATE, EVENT_TYPE, RENT_ID, NEW_BOOK_ID, NEW_READER_ID, NEW_RENT_DATE, NEW_RETURN_DATE)
        VALUE(CURTIME(), 'INSERT', NEW.RENT_ID, NEW.BOOK_ID, NEW.READER_ID, NEW.RENT_DATE, NEW.RETURN_DATE);
END $$
DELIMITER ;



INSERT INTO RENTS (BOOK_ID, READER_ID, RENT_DATE, RETURN_DATE)
VALUES (2, 4, DATE_SUB(CURDATE(), INTERVAL 5 DAY), NULL);
COMMIT;


DELIMITER $$
CREATE TRIGGER RENTS_DELETE AFTER DELETE ON RENTS
    FOR EACH ROW
BEGIN
    INSERT INTO RENTS_AUD(EVENT_DATE, EVENT_TYPE, RENT_ID)
        VALUE(CURTIME(), 'DELETE', OLD.RENT_ID);
END $$
DELIMITER ;

SELECT * FROM RENTS;
DELETE FROM RENTS WHERE RENT_ID = 12;
COMMIT;
SELECT * FROM rents_aud;


DELIMITER $$
CREATE TRIGGER RENTS_UPDATE AFTER UPDATE ON RENTS
    FOR EACH ROW
BEGIN
    INSERT INTO RENTS_AUD (EVENT_DATE, EVENT_TYPE, RENT_ID, NEW_BOOK_ID, NEW_READER_ID,
                           NEW_RENT_DATE, NEW_RETURN_DATE, OLD_BOOK_ID, OLD_READER_ID,
                           OLD_RENT_DATE, OLD_RETURN_DATE)
        VALUE(CURTIME(), 'UPDATE', OLD.RENT_ID, NEW.BOOK_ID, NEW.READER_ID,
              NEW.RENT_DATE, NEW.RETURN_DATE, OLD.BOOK_ID, OLD.READER_ID,
              OLD.RENT_DATE, OLD.RETURN_DATE);
END $$
DELIMITER ;

UPDATE RENTS SET RETURN_DATE = CURDATE()
WHERE RENT_ID = 11;
COMMIT;
SELECT * FROM rents_aud;

# TASK 30.4 -----------------------------------------------------------------------------------------------------------

SELECT * FROM BOOKS;
SELECT * FROM READERS;
SELECT * FROM RENTS;

DROP TABLE IF EXISTS BOOKS_AUD;

CREATE TABLE BOOKS_AUD (
                           EVENT_ID INT(11) NOT NULL AUTO_INCREMENT,
                           EVENT_DATE DATETIME NOT NULL,
                           EVENT_TYPE VARCHAR(10) NOT NULL,
                           BOOK_ID INT(11),
                           OLD_TITLE VARCHAR(255),
                           NEW_TITLE VARCHAR(255),
                           OLD_PUBYEAR INT(4),
                           NEW_PUBYEAR INT(4),
                           OLD_BESTSELLERS BOOLEAN,
                           NEW_BESTSELLERS BOOLEAN,
                           OLD_IS_BESTSELLER BOOLEAN,
                           NEW_IS_BESTSELLER BOOLEAN,
                           OLD_BOOK_TIMES_RENTED INT,
                           NEW_BOOK_TIMES_RENTED INT,
                           PRIMARY KEY (EVENT_ID)
);

DELIMITER $$
CREATE TRIGGER BOOKS_INSERT AFTER INSERT ON BOOKS
    FOR EACH ROW
BEGIN
    INSERT INTO BOOKS_AUD(EVENT_DATE, EVENT_TYPE, BOOK_ID, NEW_TITLE, NEW_PUBYEAR)
        VALUE(CURTIME(), 'INSERT', NEW.BOOK_ID, NEW.TITLE, NEW.PUBYEAR);
END $$
DELIMITER ;

INSERT INTO BOOKS(TITLE, PUBYEAR, BESTSELLERS, IS_BESTSELLER, BOOK_TIMES_RENTED)
    VALUE ('THREE BODY PROBLEM', 2020, NULL, NULL, 0);
COMMIT;
SELECT * FROM BOOKS_AUD;


DELIMITER $$
CREATE TRIGGER BOOKS_DELETE AFTER DELETE ON BOOKS
    FOR EACH ROW
BEGIN
    INSERT INTO BOOKS_AUD(EVENT_DATE, EVENT_TYPE, BOOK_ID)
        VALUE(CURTIME(), 'DELETE', OLD.BOOK_ID);
END $$
DELIMITER ;

SELECT * FROM BOOKS;

DELETE FROM BOOKS WHERE BOOK_ID = 15;
COMMIT;

SELECT * FROM BOOKS_AUD;



DELIMITER $$
CREATE TRIGGER BOOKS_UPDATE AFTER UPDATE ON BOOKS
    FOR EACH ROW
BEGIN
    INSERT INTO BOOKS_AUD(EVENT_DATE, EVENT_TYPE, BOOK_ID, OLD_TITLE, NEW_TITLE, OLD_PUBYEAR, NEW_PUBYEAR,
                          OLD_BESTSELLERS, NEW_BESTSELLERS, OLD_IS_BESTSELLER, NEW_IS_BESTSELLER,
                          OLD_BOOK_TIMES_RENTED, NEW_BOOK_TIMES_RENTED)
        VALUE(CURTIME(), 'UPDATE', OLD.BOOK_ID, OLD.TITLE, NEW.TITLE, OLD.PUBYEAR, NEW.PUBYEAR,
              OLD.BESTSELLERS, NEW.BESTSELLERS, OLD.IS_BESTSELLER, NEW.IS_BESTSELLER,
              OLD.BOOK_TIMES_RENTED, NEW.BOOK_TIMES_RENTED);
END $$
DELIMITER ;

UPDATE BOOKS SET TITLE = 'UPDATED TITLE', PUBYEAR = 2024
WHERE BOOK_ID = 11;
COMMIT;
SELECT * FROM BOOKS_AUD;

# -------------------

SELECT * FROM READERS;

DROP TABLE IF EXISTS READERS_AUD;

CREATE TABLE READERS_AUD(
                            EVENT_ID INT(11) NOT NULL AUTO_INCREMENT,
                            EVENT_DATE DATETIME NOT NULL,
                            EVENT_TYPE VARCHAR(10) NOT NULL,
                            READER_ID INT(11) NOT NULL,
                            OLD_FIRSTNAME VARCHAR(255),
                            NEW_FIRSTNAME VARCHAR(255),
                            OLD_LASTNAME VARCHAR(255),
                            NEW_LASTNAME VARCHAR(255),
                            OLD_PESELID VARCHAR(11),
                            NEW_PESELID VARCHAR(11),
                            PRIMARY KEY (EVENT_ID)
);

DROP TRIGGER IF EXISTS READERS_INSERT;
DELIMITER $$
CREATE TRIGGER READERS_INSERT AFTER INSERT ON READERS
    FOR EACH ROW
BEGIN
    INSERT INTO READERS_AUD(EVENT_DATE, EVENT_TYPE, READER_ID, NEW_FIRSTNAME, NEW_LASTNAME, NEW_PESELID)
        VALUE(CURTIME(), 'INSERT', NEW.READER_ID, NEW.FIRSTNAME, NEW.LASTNAME, NEW.PESELID);
END $$
DELIMITER ;

INSERT INTO READERS (FIRSTNAME, LASTNAME, PESELID)
VALUES ('New Reader Name', 'New Reader Last Name', '12345678911');
COMMIT;

SELECT * FROM READERS_AUD;
SELECT * FROM READERS;

DELIMITER $$
CREATE TRIGGER READERS_DELETE AFTER DELETE ON READERS
    FOR EACH ROW
BEGIN
    INSERT INTO READERS_AUD(EVENT_DATE, EVENT_TYPE, READER_ID)
        VALUE(CURTIME(), 'DELETE', OLD.READER_ID);
END $$
DELIMITER ;

SELECT * FROM READERS;
DELETE FROM READERS WHERE READER_ID = 11;
COMMIT;
SELECT * FROM READERS;
SELECT * FROM READERS_AUD;



DELIMITER $$
CREATE TRIGGER READERS_UPDATE AFTER UPDATE ON READERS
    FOR EACH ROW
BEGIN
    INSERT INTO READERS_AUD(EVENT_DATE, EVENT_TYPE, READER_ID, NEW_FIRSTNAME, NEW_LASTNAME, NEW_PESELID,
                            OLD_FIRSTNAME, OLD_LASTNAME, OLD_PESELID)
        VALUE(CURTIME(), 'UPDATE', OLD.READER_ID, NEW.FIRSTNAME, NEW.LASTNAME, NEW.PESELID,
              OLD.FIRSTNAME, OLD.LASTNAME, OLD.PESELID);
END $$
DELIMITER ;

SELECT * FROM READERS;

UPDATE READERS SET FIRSTNAME = 'Updated name', LASTNAME = 'Updated Last Name', PESELID = '11111111111'
WHERE READER_ID = 1;
COMMIT;

SELECT * FROM READERS_AUD;

# 30.5. Widoki i zdarzenia ---------------------------------------------------------------------------------------------

DROP VIEW IF EXISTS BOOKS_AND_READERS;

CREATE VIEW BOOKS_AND_READERS AS
SELECT RD.READER_ID, RD.FIRSTNAME, RD.LASTNAME, BK.TITLE, RT.RENT_DATE, RT.RETURN_DATE
FROM READERS RD, BOOKS BK, RENTS RT
WHERE RT.BOOK_ID = BK.BOOK_ID
  AND RT.READER_ID = RD.READER_ID
ORDER BY RT.RENT_DATE;

SELECT * FROM BOOKS_AND_READERS;

SELECT * FROM BOOKS_AND_READERS
WHERE RENT_DATE > DATE_SUB(CURDATE(), INTERVAL 5 DAY)
ORDER BY LASTNAME;

SHOW PROCESSLIST;

SET GLOBAL EVENT_SCHEDULER=ON;

USE kodilla_course;

CREATE EVENT UPDATE_VIPS
    ON SCHEDULE EVERY 1 MINUTE
    DO CALL UpdateVipLevels();

SELECT * FROM READERS;

UPDATE READERS
SET READERS.VIP_LEVEL='NOT SET'
WHERE READER_ID = 1;

DROP EVENT UPDATE_VIPS;

# TEST:
UPDATE BOOKS
SET PUBYEAR=1111
WHERE BOOK_ID=1;

# tASK 30.5 -----------------------------------------------------------------------------------------------------
CREATE TABLE STATS(
                      STAT_ID INT(11) AUTO_INCREMENT PRIMARY KEY,
                      STAT_DATE DATETIME NOT NULL,
                      STAT VARCHAR(20) NOT NULL,
                      VALUE INT(11) NOT NULL
);

CREATE VIEW BESTSELLERS_COUNT AS
SELECT COUNT(*) AS COUNT_BESTSELLERS
FROM BOOKS
WHERE BESTSELLERS > 0;

DELIMITER $$

CREATE EVENT UPDATE_BESTSELLERS
    ON SCHEDULE EVERY 5 SECOND
    DO
    BEGIN
        CALL UpdateBestsellers();
        INSERT INTO STATS(STAT_DATE, STAT, VALUE)
        VALUES (CURTIME(), 'BESTSELLERS', (SELECT COUNT_BESTSELLERS FROM BESTSELLERS_COUNT));
    END $$

DELIMITER ;


SET GLOBAL EVENT_SCHEDULER=ON;
SHOW VARIABLES LIKE 'event_scheduler';
SHOW PROCESSLIST;

SELECT * FROM BOOKS;
SELECT * FROM BESTSELLERS_COUNT;
SELECT * FROM STATS;

# 30.6. Indeksy i plany zapytań-----------------------------------------------------------------------------------

CREATE TABLE PHONES (
    PHONE_ID INT(11) NOT NULL AUTO_INCREMENT PRIMARY KEY,
    PHONENUM INT(9),
    FIRSTNAME VARCHAR(50),
    LASTNAME VARCHAR(50)
);

SELECT * FROM PHONES;

DELIMITER $$

CREATE PROCEDURE FillTestData()
BEGIN
    DECLARE K INT DEFAULT 0;
    WHILE (K < 100000) DO
            INSERT INTO PHONES (PHONENUM, FIRSTNAME, LASTNAME)
            VALUES(ROUND(RAND()*1000000000), CONCAT('Firstname number ', K), CONCAT('Lastname number ', K));
            IF (MOD(K, 5000) = 0) THEN
                COMMIT;
            END IF;
            SET K = K + 1;
        END WHILE;
    COMMIT;
END $$

DELIMITER ;

CALL FillTestData();

SELECT * FROM PHONES;

CREATE TABLE PHONESTATS (
                            ID INT(11) NOT NULL AUTO_INCREMENT PRIMARY KEY,
                            RANGE_FROM INT(11),
                            RANGE_TO INT(11),
                            QUANTITY INT(11)
);

select * from PHONESTATS;

DELIMITER $$

CREATE PROCEDURE CalcPhoneStats()
BEGIN
    DECLARE K INT(11) DEFAULT 0;
    DECLARE QTY INT(11);
    DELETE FROM PHONESTATS WHERE ID > 0;                                    -- [1]
    COMMIT;
    WHILE (K < 100000000) DO
            SELECT COUNT(*)                                         -- [2]
            FROM PHONES                                         -- [3]
            WHERE PHONENUM BETWEEN K-99999 AND K                    -- [4]
            INTO QTY;                                           -- [5]
            INSERT INTO PHONESTATS (RANGE_FROM, RANGE_TO, QUANTITY) -- [6]
            VALUES (K-99999, K, QTY);                           -- [7]
            COMMIT;
            SET K = K + 100000;                                     -- [8]
        END WHILE;
END $$

DELIMITER ;

CALL CalcPhoneStats();

select * from PHONESTATS;

EXPLAIN SELECT COUNT(*)
FROM PHONES
WHERE PHONENUM BETWEEN 1 AND 100000;

DROP INDEX PHONENO ON PHONES;

CREATE INDEX PHONENO ON PHONES (PHONENUM);

CALL CalcPhoneStats();

# Zadanie: indeksy dla biblioteki ------------------------------------------------------------------------------------

SELECT * FROM BOOKS;
SELECT * FROM READERS;

CREATE INDEX BOOKSNO ON BOOKS (TITLE);
CREATE INDEX FIRSTNAMENO ON READERS (FIRSTNAME);
CREATE INDEX LASTNAMENO ON READERS (LASTNAME);


# Zadanie: indeksy dla biblioteki ------------------------------------------------------------------------------------

SELECT * FROM BOOKS;

DELIMITER $$

CREATE PROCEDURE FillBooksTestData()
BEGIN
    DECLARE K INT DEFAULT 1000001;
    WHILE (K < 1000000) DO
            INSERT INTO BOOKS (TITLE, PUBYEAR)
            VALUES(CONCAT('BOOK TITLE_', K), 2024);
            IF (MOD(K, 5000) = 0) THEN
                COMMIT;
            END IF;
            SET K = K + 1;
        END WHILE;
    COMMIT;
END $$

DELIMITER ;

CALL FillBooksTestData();

CREATE INDEX BOOKSNO ON BOOKS (TITLE);

DROP INDEX BOOKSNO ON BOOKS;

SELECT * FROM BOOKS;

SELECT BOOK_ID, PUBYEAR
FROM BOOKS
WHERE TITLE = 'BOOK TITLE_991487';

# Readers: -------------------------------------------------------

SELECT *
FROM READERS;

DELIMITER $$

CREATE PROCEDURE FillReadersData()
BEGIN
    DECLARE K INT DEFAULT 0;
    WHILE (K < 1000000)
        DO
            INSERT INTO READERS (FIRSTNAME, LASTNAME, PESELID, VIP_LEVEL)
            VALUES (CASE
                        WHEN (MOD(K, 3) = 0) THEN 'Curtis'
                        WHEN (MOD(K, 5) = 0) THEN 'John'
                        WHEN (MOD(K, 7) = 0) THEN 'Marissa'
                        ELSE 'Muriel'
                        END,
                    CASE
                        WHEN (MOD(K, 3) = 0) THEN 'Wilson'
                        WHEN (MOD(K, 5) = 0) THEN 'Cain'
                        WHEN (MOD(K, 7) = 0) THEN 'Booker'
                        ELSE 'Fulton'
                        END,
                    ROUND(RAND() * 1000000000),
                    'Gold customer');
            IF (MOD(K, 5000) = 0) THEN
                COMMIT;
            END IF;
            SET K = K + 1;
        END WHILE;
    COMMIT;
END $$

DELIMITER ;

CALL FillReadersData();

DROP INDEX FIRSTNAMENO ON READERS;

CREATE INDEX FIRSTNAMENO ON READERS (FIRSTNAME);
CREATE INDEX LASTNAMENO ON READERS (LASTNAME);

SELECT FIRSTNAME, LASTNAME, PESELID, VIP_LEVEL FROM readers
WHERE FIRSTNAME = 'John';




















