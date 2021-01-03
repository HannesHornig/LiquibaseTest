USE primetest;

create table DATABASECHANGELOG
(
    ID            varchar(255) not null,
    AUTHOR        varchar(255) not null,
    FILENAME      varchar(255) not null,
    DATEEXECUTED  datetime     not null,
    ORDEREXECUTED int          not null,
    EXECTYPE      varchar(10)  not null,
    MD5SUM        varchar(35)  null,
    DESCRIPTION   varchar(255) null,
    COMMENTS      varchar(255) null,
    TAG           varchar(255) null,
    LIQUIBASE     varchar(20)  null,
    CONTEXTS      varchar(255) null,
    LABELS        varchar(255) null,
    DEPLOYMENT_ID varchar(10)  null
);

create table DATABASECHANGELOGLOCK
(
    ID          int          not null
        primary key,
    LOCKED      bit          not null,
    LOCKGRANTED datetime     null,
    LOCKEDBY    varchar(255) null
);

