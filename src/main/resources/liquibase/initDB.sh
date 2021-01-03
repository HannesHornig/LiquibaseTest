#!/bin/bash

cd liquibase
tar -xzf liquibase-4.2.2.tar.gz
cd - || exit

./liquibase/liquibase --url=jdbc:mysql://localhost:3306/primetest?createDatabaseIfNotExist=true\
          --username=root \
          --password= \
          --classpath=/liquibase/mysql-connector-java-8.0.22.jar \
          --changeLogFile=/liquibase/config/changelog.xml \
          update