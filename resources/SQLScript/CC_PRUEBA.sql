.tables.data --------------------------------------------------CC_CEDULA---------------------------------------------
DROP TABLE CC_CEDULA;

CREATE TABLE
    CC_CEDULA (
        CAP VARCHAR(25),
        GEO VARCHAR(25),
        TIPO_ARSENAL VARCHAR(25)
    );

--1752760551 Cedula Jefferson Chileno

--1725924946 Cedula Luis Caiza

INSERT INTO
    CC_CEDULA (CAP, GEO, TIPO_ARSENAL)
VALUES ("1", "GPS1", "bc");

INSERT INTO
    CC_CEDULA (CAP, GEO, TIPO_ARSENAL)
VALUES ("5", "GPS5", "bct");

INSERT INTO
    CC_CEDULA (CAP, GEO, TIPO_ARSENAL)
VALUES ("5", "GPS5", "bct");

INSERT INTO
    CC_CEDULA (CAP, GEO, TIPO_ARSENAL)
VALUES ("0", "GPS0", "ab");

INSERT INTO
    CC_CEDULA (CAP, GEO, TIPO_ARSENAL)
VALUES ("6", "GPS6", "act");

INSERT INTO
    CC_CEDULA (CAP, GEO, TIPO_ARSENAL)
VALUES ("7", "GPS7", "aaabbct");

INSERT INTO
    CC_CEDULA (CAP, GEO, TIPO_ARSENAL)
VALUES ("2", "GPS2", "ac");

INSERT INTO
    CC_CEDULA (CAP, GEO, TIPO_ARSENAL)
VALUES ("5", "GPS5", "bct");

INSERT INTO
    CC_CEDULA (CAP, GEO, TIPO_ARSENAL)
VALUES ("7", "GPS7", "aaabbct");

INSERT INTO
    CC_CEDULA (CAP, GEO, TIPO_ARSENAL)
VALUES ("1", "GPS1", "bc");

INSERT INTO
    CC_CEDULA (CAP, GEO, TIPO_ARSENAL)
VALUES ("6", "GPS6", "act");

INSERT INTO
    CC_CEDULA (CAP, GEO, TIPO_ARSENAL)
VALUES ("4", "GPS4", "acd");

INSERT INTO
    CC_CEDULA (CAP, GEO, TIPO_ARSENAL)
VALUES ("9", "GPS9", "aaabbcd");

INSERT INTO
    CC_CEDULA (CAP, GEO, TIPO_ARSENAL)
VALUES ("4", "GPS4", "acd");

INSERT INTO
    CC_CEDULA (CAP, GEO, TIPO_ARSENAL)
VALUES ("2", "GPS2", "ac");

INSERT INTO
    CC_CEDULA (CAP, GEO, TIPO_ARSENAL)
VALUES ("9", "GPS9", "aaabbcd");

INSERT INTO
    CC_CEDULA (CAP, GEO, TIPO_ARSENAL)
VALUES ("5", "GPS5", "bct");

INSERT INTO
    CC_CEDULA (CAP, GEO, TIPO_ARSENAL)
VALUES ("2", "GPS2", "ac");

INSERT INTO
    CC_CEDULA (CAP, GEO, TIPO_ARSENAL)
VALUES ("7", "GPS7", "aaabbct");

INSERT INTO
    CC_CEDULA (CAP, GEO, TIPO_ARSENAL)
VALUES ("1", "GPS1", "bc");

SELECT * FROM CC_CEDULA;

--------------------------------------------------CREDENCIALES---------------------------------------------

DROP TABLE CREDENCIALES;

CREATE TABLE
    CREDENCIALES (
        USUARIO VARCHAR(25) UNIQUE,
        CONTRASENIA VARCHAR(25),
        NOMBRE VARCHAR(25) UNIQUE
    );

INSERT INTO
    CREDENCIALES (USUARIO, CONTRASENIA, NOMBRE)
VALUES (
        'Prof',
        '81dc9bdb52d04dc20036dbd8313ed055',
        'Profe'
    );

SELECT * FROM CREDENCIALES;