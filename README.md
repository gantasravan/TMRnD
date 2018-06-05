# Spring Boot Oracle Example

* To run this example you will need to download and install the Oracle JDBC driver.
* You can install the Oracle Jar into your local Maven repsository using this command: `mvn install:install-file -Dfile=ojdbc7.jar -DgroupId=com.oracle -DartifactId=ojdbc7 -Dversion=12.1.0.2 -Dpackaging=jar`


Used the following tech:-
Oracle Database
Spring Boot Framework


Details:-
1) Clone the project
2) Oracle details of username:mahbois and password: mahbois
3) Start the project spring-boot:run
4) If we place any file in the directory "D:\workspace\TMRnD\csv_files\csv_files" then file scanner pick up the files and insert the data into the 3 tables created.
5) We can change the location of the base directory in Global.java
final static String BASE_DIRECTORY ="D:\\workspace\\TMRnD\\csv_files\\csv_files\\";


Rest URL:-
http://localhost:8080
