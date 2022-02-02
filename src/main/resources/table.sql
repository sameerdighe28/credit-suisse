DROP TABLE LOG IF EXISTS;
CREATE TABLE LOG (
    ID varchar(20),
    DURATION varchar(20) not null,
    TYPE varchar(50),
    HOST varchar(20),
    ALERT varchar(20) not null
);
