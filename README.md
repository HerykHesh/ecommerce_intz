# Xcale Challenger: E-Commerce
#### by Heryk Willians Simões


## Stack and dependencies:
- Development Language: [Java 17](https://openjdk.java.net)
- Main Framework: [Spring Boot Framework](https://spring.io/projects/spring-boot)
- Database: [H2 Database](https://www.h2database.com/)
- Project Management: [Maven](https://maven.apache.org)
- Java library: [Lombok](https://projectlombok.org/)
- Api documentation: [Swagger](https://swagger.io/)
- Testing: [Junit Jupiter](https://junit.org/)

## Application Initialization
To start the application, click on the option spring-boot:run.


## DataBase Config
To access the database, the developer needs to start the project and then click the link below.
- [H2 Access](http://localhost:8080/h2-console)

When accessing the link, you will need to add the following information:

JDBC URL: jdbc:h2:mem:ecdb
username: sa
Password: password

Click the 'Connect' button.


## Workflow:

#### 1. To initiate the process, the user should create a cart using the addCart POST request.
#### 2. Once the cart is created, the user can:
- Retrieve cart data using the getCart GET request.
- Add a product using the addProduct POST request.
- Delete a product using the deleteProduct DELETE request.

#### 3. All carts will automatically expire after 10 minutes, and they will be deleted accordingly.


## API documentation
[E-Commerce Api](http://localhost:8080/swagger-ui.html)


## Unit Testing:
- Click on the 'test' option, located under the 'Lifecycle' tab in Maven. 

## Postman Testing:
- Import the eCommerce.postman_collection.json file, located in the static resources folder into Postman.




