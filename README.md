# Spring Boot 3.0.1 Client Rest API
This is a Client Rest API that allows for creating, updating and searching for a client.

## Technologies
* Spring Boot 3.0.1
* Maven
* JUnit

## Overview
This API creates a USER and does validation in a REST API using Spring Boot 3.

The API does not persiste to any database but uses the structure of MVC.
Where the Model is (User), Controller (UserController), View (JSON).

This project uses the ObjectMapper to save data to a JSON file (clientList.json).

## Getting Started
To get started with this project, you will need to have the following installed on your local machine:

* JDK 17+
* Maven 3+


To build and run the project, follow these steps:

* Clone the repository: `git clone https://github.com/Thami747/UserAPI.git`
* Navigate to the project directory: cd UserAPI
* Build the project: mvn clean install
* Run the project: mvn spring-boot:run 

-> The application will be available at http://localhost:8080.



