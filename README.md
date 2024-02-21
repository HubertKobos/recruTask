# Recruitment task
The goal of this project was to create an application allowing users to view user repositories from the GitHub, using a RESTful API. Application was built with Spring Boot 3 and Java 21.

# Requirements
* Java 21
* Spring Boot 3
* Maven

# Technologies
* Spring Boot
* RESTful API
* Swagger

# Installation
1. Clone the repository to your local computer.
2. Open a terminal and navigate to the project directory.
3. Run the command 
```bash
mvn clean install
``` 
to build the application

4. After the build is complete, run the application using the command
```bash
java -jar target/githubScrapp-0.0.1-SNAPSHOT.jar
```
# Using the API
After starting the application, you can access the API through Swagger. Simply open a web browser and go to the address http://localhost:8080/swagger-ui.html. There you will find API documentation and the ability to test the /repositories/{username} endpoint

# Unit test
The application includes one unit test that verifies the correctness of throwing a `UserNotFoundException`.
This test is located in the `GitHubApiServiceTest` class and ensured that the application behaves as expected when attempting to retrieve repositories for non-existing user from the GitHub API.
