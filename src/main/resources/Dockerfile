FROM mysql:8.0
ENV MYSQL_ALLOW_EMPTY_PASSWORD=true

COPY liquibase/sql/A_createSchema.sql /docker-entrypoint-initdb.d/
COPY liquibase/sql/B_liquibaseTables.sql /docker-entrypoint-initdb.d/
COPY liquibase/sql/C_dockerTestData.sql /docker-entrypoint-initdb.d/
