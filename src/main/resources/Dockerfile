FROM mysql:8.0
ENV MYSQL_ALLOW_EMPTY_PASSWORD=true
RUN mkdir /liquibase
RUN mkdir /liquibase/config
RUN mkdir -p /usr/share/man/man1
COPY liquibase/changesets /liquibase/config
COPY liquibase/staticdata /liquibase/config
COPY liquibase/changelog.xml /liquibase/config

COPY liquibase-4.2.2.tar.gz /liquibase
COPY mysql-connector-java-8.0.22.jar /liquibase

RUN tar -xzf  /liquibase/liquibase-4.2.2.tar.gz && \
    export PATH=$PATH:/liquibase/ && \
    source ~/.bashrc

RUN apt update && \
    apt -y upgrade && \
    apt install openjdk-11-jdk

RUN liquibase --url=jdbc:mysql://localhost:3306\
              --username=root \
              --password= \
              --classpath=/liquibase/mysql-connector-java-8.0.22.jar \
              --changeLogFile=/liquibase/config/liquibase-outputChangeLog.xml \
              update
