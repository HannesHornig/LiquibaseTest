# TestingVariants

Used for testings different test-methods on a (more or less) minimal example. Currently we have:

* TDD developed Calculator for Prime Numbers
* Using Junit 5 for 
  * Property based Test (reading Test-Data from files in classpath)
  * Testing out Aggregator / Converter Interfaces 
  * Using assertThrows instead of Junit4 Rules for testing for exceptions
* Testing the occurence of log-messages through adding a custom log-appender (probably usefull if you use log-actions in Graylog etc.) 

## Things still to test

* Bulding a docker image with a pre-filled database (here MySql) in the build build-process. The structure should come from liquibase so 
  that I can use the same tool that gets executed while deploying is used to build the test-docker-images.
* Performance Testing (J-Meter, Gatling ...) 
* Integration Testing with Spring Boot
* Using Tools (Postman, SoapUi ...) to mock external API-Calls. Probably going to spin-up multiple Docker container for that.


