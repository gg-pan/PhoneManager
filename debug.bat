@echo off
java -Xdebug -Xrunjdwp:server=y,transport=dt_socket,address=8000,suspend=n  -jar target/manager-0.0.1-SNAPSHOT.jar