


CREATE TABLE CFM_TIRI.ROLE (
    id_role   NUMBER(10,0)
        NOT NULL ENABLE,
    name      VARCHAR2(255 CHAR),
    version   NUMBER(10,0),
    PRIMARY KEY ( id_role )
);

CREATE TABLE CFM_TIRI.SQUAD (
    id_squad        NUMBER(10,0)
        NOT NULL ENABLE,
    active          NUMBER(1,0),
    creation_date   TIMESTAMP(6),
    version         NUMBER(10,0),
    id_truck        NUMBER(10,0),
    PRIMARY KEY ( id_squad )
);

CREATE TABLE CFM_TIRI.TIRI_USER (
    ID_USER         NUMBER(10,0)
        NOT NULL ENABLE,
    ACTIVE          NUMBER(1,0),
    CREATION_DATE   TIMESTAMP(6),
    EMAIL           VARCHAR2(255 CHAR),
    FIRST_NAME      VARCHAR2(50 CHAR)
        NOT NULL ENABLE,
    LAST_NAME       VARCHAR2(100 CHAR)
        NOT NULL ENABLE,
    LOGIN           VARCHAR2(255 CHAR),
    MOBILE_PHONE    VARCHAR2(20 CHAR)
        NOT NULL ENABLE,
    PASSWORD        VARCHAR2(255 CHAR),
    VERSION         NUMBER(10,0),
    ID_ROLE         NUMBER(10,0),
    PRIMARY KEY ( ID_USER )
);

CREATE TABLE CFM_TIRI.TRAILER (
    ID_TRAILER            NUMBER(10,0)
        NOT NULL ENABLE,
    ACTIVE                NUMBER(1,0),
    CREATION_DATE         TIMESTAMP(6),
    MODEL                 VARCHAR2(255 CHAR),
    PRODUCER              VARCHAR2(255 CHAR),
    PRODUCTION_YEAR       NUMBER(10,0)
        NOT NULL ENABLE,
    REGISTRATION_NUMBER   VARCHAR2(15 CHAR)
        NOT NULL ENABLE,
    VERSION               NUMBER(10,0),
    ID_TRAILER_TYPE       NUMBER(10,0),
    CHECK (
            production_year <= 2100
        AND
            production_year >= 1985
    ) ENABLE,
    PRIMARY KEY ( ID_TRAILER )
);

CREATE TABLE CFM_TIRI.TRAILER_TYPE (
    ID_TRAILER_TYPE   NUMBER(10,0)
        NOT NULL ENABLE,
    NAME              VARCHAR2(255 CHAR),
    VERSION           NUMBER(10,0),
    PRIMARY KEY ( ID_TRAILER_TYPE )
);

CREATE TABLE CFM_TIRI.TRUCK (
    ID_TRUCK              NUMBER(10,0)
        NOT NULL ENABLE,
    ACTIVE                NUMBER(1,0)
        NOT NULL ENABLE,
    CREATION_DATE         TIMESTAMP(6),
    EURO_STANDARD         VARCHAR2(10 CHAR)
        NOT NULL ENABLE,
    HORSE_POWER           NUMBER(10,0)
        NOT NULL ENABLE,
    MODEL                 VARCHAR2(255 CHAR),
    PRODUCER              VARCHAR2(255 CHAR),
    PRODUCTION_YEAR       NUMBER(10,0)
        NOT NULL ENABLE,
    REGISTRATION_NUMBER   VARCHAR2(15 CHAR)
        NOT NULL ENABLE,
    VERSION               NUMBER(10,0),
    CHECK (
            production_year <= 2100
        AND
            production_year >= 1985
    ) ENABLE,
    PRIMARY KEY ( ID_TRUCK )
);