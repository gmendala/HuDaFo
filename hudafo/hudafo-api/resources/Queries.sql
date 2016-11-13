

--CREATION OF GENDERS TABLE
CREATE TABLE genders(gender_id BIGINT PRIMARY KEY AUTO_INCREMENT, gender_name VARCHAR(255));

--DESTRUCTION OF GENDERS TABLE
DROP TABLE genders;

--SELECT ALL FROM GENDERS TABLE
SELECT * FROM GENDERS;

--DOES GENDERS TABLE EXIST ?
SELECT  *
FROM    INFORMATION_SCHEMA.TABLES
WHERE   TABLE_NAME      = 'GENDERS'
    AND TABLE_SCHEMA    = 'PUBLIC'
    
--SIMPLE INSERT FOR GENDERS TABLE - WITH ID;
INSERT INTO genders(gender_id,gender_name) values(0,'UNDEFINED');

--SIMPLE INSERT FOR GENDERS TABLE - WITHOUT ID
INSERT INTO genders(gender_name) values('UNDEFINED2');

-------------------------------
----------	NAMES -------------
-------------------------------

-- DOES NAMES TABLE DOES EXIST ?
SELECT COUNT(*) FROM INFORMATION_SCHEMA.TABLES WHERE TABLE_NAME = 'NAMES' AND TABLE_SCHEMA = 'PUBLIC'

-- CREATE NAMES TABLE
CREATE TABLE names(names_id BIGINT PRIMARY KEY AUTO_INCREMENT, name_text VARCHAR(255));

--SELECT ALL FROM NAMES TABLE
SELECT * FROM NAMES;

--DESTRUCTION OF NAMES TABLE
DROP TABLE names;

-------------------------------
-------- SURNAMES -------------
-------------------------------

-- DOES NAMES TABLE DOES EXIST ?
SELECT COUNT(*) FROM INFORMATION_SCHEMA.TABLES WHERE TABLE_NAME = 'SURNAMES' AND TABLE_SCHEMA = 'PUBLIC'

-- CREATE NAMES TABLE
CREATE TABLE surnames(surname_id BIGINT PRIMARY KEY AUTO_INCREMENT, surname_name VARCHAR(255));

--SELECT ALL FROM NAMES TABLE
SELECT * FROM SURNAMES;

--DESTRUCTION OF NAMES TABLE
DROP TABLE surnames;




