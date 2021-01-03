USE primetest;
--  *********************************************************************
--  Update Database Script
--  *********************************************************************
--  Change Log: src/main/resources/liquibase/changelog.xml
--  Ran at: 1/3/21, 5:20 PM
--  Against: root@172.17.0.1@jdbc:mysql://localhost:3306/primetest?createDatabaseIfNotExist=true
--  Liquibase version: 4.2.2
--  *********************************************************************

--  Lock Database
UPDATE DATABASECHANGELOGLOCK
SET `LOCKED`    = 1,
    LOCKEDBY    = '172.17.0.1 (172.17.0.1)',
    LOCKGRANTED = '2021-01-03 17:20:57.071'
WHERE ID = 1
  AND `LOCKED` = 0;

--  Changeset src/main/resources/liquibase/changes/generateTable.xml::2::Dev1
CREATE TABLE primenumbers
(
    id    INT AUTO_INCREMENT NOT NULL,
    prime INT                NULL,
    CONSTRAINT PK_PRIMENUMBERS PRIMARY KEY (id),
    UNIQUE (prime)
);

INSERT INTO DATABASECHANGELOG (ID, AUTHOR, FILENAME, DATEEXECUTED, ORDEREXECUTED, MD5SUM, `DESCRIPTION`, COMMENTS,
                               EXECTYPE, CONTEXTS, LABELS, LIQUIBASE, DEPLOYMENT_ID)
VALUES ('2', 'Dev1', 'src/main/resources/liquibase/changes/generateTable.xml', NOW(), 5,
        '8:44b7556b6430d03423ee618943433237', 'createTable tableName=primenumbers', '', 'EXECUTED', NULL, NULL, '4.2.2',
        '9690858100');

--  Changeset src/main/resources/liquibase/changes/fillTableWithStaticData.xml::2::Dev1
--  WARNING The following SQL may change each run and therefore is possibly incorrect and/or invalid:
INSERT INTO primenumbers (id, prime)
VALUES (1, 2),
       (2, 3),
       (3, 5),
       (4, 7);

INSERT INTO DATABASECHANGELOG (ID, AUTHOR, FILENAME, DATEEXECUTED, ORDEREXECUTED, MD5SUM, `DESCRIPTION`, COMMENTS,
                               EXECTYPE, CONTEXTS, LABELS, LIQUIBASE, DEPLOYMENT_ID)
VALUES ('2', 'Dev1', 'src/main/resources/liquibase/changes/fillTableWithStaticData.xml', NOW(), 6,
        '8:beca6761baeea74d7c59748e9c79c3c4', 'loadData tableName=primenumbers', '', 'EXECUTED', NULL, NULL, '4.2.2',
        '9690858100');

--  Release Database Lock
UPDATE DATABASECHANGELOGLOCK
SET `LOCKED`    = 0,
    LOCKEDBY    = NULL,
    LOCKGRANTED = NULL
WHERE ID = 1;

