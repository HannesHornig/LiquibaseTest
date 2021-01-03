FROM mysql:8.0
ENV MYSQL_ALLOW_EMPTY_PASSWORD=true
RUN mkdir /liquibase
RUN mkdir /liquibase/config
#Necessary since without it openjdk-11 will crash at installation
RUN mkdir -p /usr/share/man/man1
COPY liquibase/changes /liquibase/config/changes
COPY liquibase/staticdata /liquibase/config/staticdata
COPY liquibase/changelog.xml /liquibase/config
COPY liquibase/initDB.sh /
COPY liquibase-4.2.2.tar.gz /liquibase
COPY mysql-connector-java-8.0.22.jar /liquibase

RUN apt update &&\
    apt -y upgrade && \
    apt -y install openjdk-11-jdk && \
    apt -y install vim

RUN chmod +x initDB.sh
RUN /initDB.sh