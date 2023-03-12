.tables
.data

--------------------------------------------------USUARIO CAIZA---------------------------------------------
DROP TABLE CEDULACAIZA;
CREATE TABLE CEDULACAIZA
(
    CAP             VARCHAR(25)
    ,GEO            VARCHAR(25)
    ,TIPO_ARSENAL   VARCHAR(25)
);

--1725924946
INSERT INTO CEDULACAIZA (CAP, GEO, TIPO_ARSENAL) VALUES ("6", "GPS6", "act");
INSERT INTO CEDULACAIZA (CAP, GEO, TIPO_ARSENAL) VALUES ("4", "GPS4", "acd");
INSERT INTO CEDULACAIZA (CAP, GEO, TIPO_ARSENAL) VALUES ("9", "GPS9", "aaabbcd");
INSERT INTO CEDULACAIZA (CAP, GEO, TIPO_ARSENAL) VALUES ("4", "GPS4", "acd");
INSERT INTO CEDULACAIZA (CAP, GEO, TIPO_ARSENAL) VALUES ("2", "GPS2", "ac");
INSERT INTO CEDULACAIZA (CAP, GEO, TIPO_ARSENAL) VALUES ("9", "GPS9", "aaabbcd");
INSERT INTO CEDULACAIZA (CAP, GEO, TIPO_ARSENAL) VALUES ("5", "GPS5", "bct");
INSERT INTO CEDULACAIZA (CAP, GEO, TIPO_ARSENAL) VALUES ("2", "GPS2", "ac");
INSERT INTO CEDULACAIZA (CAP, GEO, TIPO_ARSENAL) VALUES ("7", "GPS7", "aaabbct");
INSERT INTO CEDULACAIZA (CAP, GEO, TIPO_ARSENAL) VALUES ("1", "GPS1", "bc");
SELECT * FROM CEDULACAIZA;

--------------------------------------------------USUARIO CHILENO---------------------------------------------
DROP TABLE CEDULACHILENO;
CREATE TABLE CEDULACHILENO
(
    CAP             VARCHAR(25)
    ,GEO            VARCHAR(25)
    ,TIPO_ARSENAL   VARCHAR(25)
);

--1752760551
INSERT INTO CEDULACHILENO (CAP, GEO, TIPO_ARSENAL) VALUES ("1", "GPS1", "bc");
INSERT INTO CEDULACHILENO (CAP, GEO, TIPO_ARSENAL) VALUES ("5", "GPS5", "bct");
INSERT INTO CEDULACHILENO (CAP, GEO, TIPO_ARSENAL) VALUES ("5", "GPS5", "bct");
INSERT INTO CEDULACHILENO (CAP, GEO, TIPO_ARSENAL) VALUES ("0", "GPS0", "ab");
INSERT INTO CEDULACHILENO (CAP, GEO, TIPO_ARSENAL) VALUES ("6", "GPS6", "act");
INSERT INTO CEDULACHILENO (CAP, GEO, TIPO_ARSENAL) VALUES ("7", "GPS7", "aaabbct");
INSERT INTO CEDULACHILENO (CAP, GEO, TIPO_ARSENAL) VALUES ("2", "GPS2", "ac");
INSERT INTO CEDULACHILENO (CAP, GEO, TIPO_ARSENAL) VALUES ("5", "GPS5", "bct");
INSERT INTO CEDULACHILENO (CAP, GEO, TIPO_ARSENAL) VALUES ("7", "GPS7", "aaabbct");
INSERT INTO CEDULACHILENO (CAP, GEO, TIPO_ARSENAL) VALUES ("1", "GPS1", "bc");
SELECT * FROM CEDULACHILENO;

--------------------------------------------------CREDENCIALES---------------------------------------------
DROP TABLE CREDENCIALES;
CREATE TABLE CREDENCIALES
(
    USUARIO     VARCHAR(25);
    CONTRASEÑA  VARCHAR(25);
);

INSERT INTO CREDENCIALES (USUARIO, CONTRASEÑA) VALUES ("Profe", "81dc9bdb52d04dc20036dbd8313ed055");
SELECT * FROM CREDENCIALES;