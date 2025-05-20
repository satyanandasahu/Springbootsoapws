
This project is a Spring Boot SOAP API for learning purpose. Have the capabilities to run both on embedded tomcat and on external tomcat.

Dependencies: Maven will takecare of all the JAR/Library dependecies but you need to install MySQL DB for database. You can also change the configuration DB for other external or in memeory DB.

After installation of MySQL DB you need to have Person table on your DB.

Run this maven command to create a jar artifact mvn clean package -Pjar Run this maven command to create a war artifact mvn clean package -Pwar

To run the jar file navigate to the targat folder in command prompt then run this command java - jar springbootsoap-0.0.1-SNAPSHOT.jar Hit this URL http://localhost:24081/services/personServiceWsdl.wsdl after the successful start of embbeded tomcat. If everything goes well you will get WSDL loaded on the browser.

To run the war file, deploy it on the external tomcat. I used Tomcat Version 11

Hit this URL http://localhost:8081/springbootsoap-0.0.1-SNAPSHOT/services/personServiceWsdl.wsdl after the successful start of tomcat. If everything goes well you will get WSDL loaded on the browser. Here applicationcontext is springbootsoap-0.0.1-SNAPSHOT

war: Web Application Archive
jar: Java Archive

Use SOAP UI Tool to test the application. You can watch the video to learn this project. The video will also tell you to test the application. Video URL is given below in note.

Table Creation

CREATE TABLE Person (
PersonID varchar(255),
FirstName varchar(255) NOT NULL, MiddleName varchar(255),
LastName varchar(255) NOT NULL,
Age int NOT NULL,
Gender varchar(255) NOT NULL,
PRIMARY KEY (PersonID),
);

CREATE TABLE Address (
AddressId varchar(255),
PersonId Varchar(255) NOT NULL,
AddressLine1 varchar(255) NOT NULL,
AddressLine2 varchar(255),
PinZipcode varchar(255) NOT NULL,
Country varchar(255) NOT NULL,
City varchar(255) NOT NULL,
DistrictCounty varchar(255) NOT NULL,
AddressType varchar(255) NOT NULL,
PRIMARY KEY (AddressId),
CONSTRAINT FK_PersonTab FOREIGN KEY (PersonId)
REFERENCES Person(PersonId)
);

Note: To better understand the project watch this video on youtube link: 
1.  https://youtu.be/WRes9v3IZ1M
2.  https://youtu.be/yownS-BHaus
