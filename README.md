
# Friends Management

This is an application with a need to build its own social network, "Friends Management" is a common requirement 
which usually starts off simple but can grow in complexity depending on the application's use case.
Usually, applications would start with features like "Friend", "Unfriend", "Block","Receive Updates" etc.

## Getting Started

This project is used to develop an API server that does simple "Friends Management" based on the User Stories

### Prerequisites

You are expected to have a basic knowledge of how Spring Framework works, what is, and why, Spring Boot is now preferred more than ever.

* Java 8
* Maven
* IDE IntelliJ or Eclipse
* Mysql

## Built With

### Spring Boot
* Spring Boot makes it easy to create stand-alone, production-grade Spring based Applications that you can "just run".
* Provide opinionated 'starter' dependencies to simplify your build configuration. 
* Automatically configure Spring and 3rd party libraries whenever possible

### Spring Data JPA
* Spring Data JPA provides repository support for the Java Persistence API (JPA). 
* It eases development of applications that need to access JPA data sources.

### Spring MVC Exception Handling
*  Spring Exception Handling using @ExceptionHandler, @ControllerAdvice with Global Exception Handler Class

### Hibernate Validators
Hibernate Validator is implementations of the Bean Validation API

### Swagger
* Design is the foundation of your API development. Swagger makes API design a breeze,
 with easy-to-use tools for developers, architects, and product owners.
 #### Swagger UI
 * git clone the project 
 * Build the project and find API documentation 

### Steps to Setup

**1. Clone the application**

```
git clone https://github.com/poornimabs/friendsmanagement.git
```

**2. Create Mysql database**

```
create database friendsmanagement
```

**3. Change mysql username and password as per your installation**

+ open `src/main/resources/application.properties`

+ change `spring.datasource.username` and `spring.datasource.password` as per your mysql installation

**4. Build and run the app using maven**

```
mvn package
java -jar target/friendsmanagement.jar
```

Alternatively, you can run the app without packaging it using -

```
mvn spring-boot:run
```

The app will start running at <http://localhost:8090>.

**5. Change the port in application.properties if port already in use**

### Explore API Endpoints

API to create a user account 
```
POST /friendsmanagement/account
```
API to create a friend connection between two email addresses.
```
POST /friendsmanagement/friendconnection
```
    
API to retrieve the friends list for an email address.    
```
POST /friendsmanagement/friends
```
    
API to retrieve the common friends list between two email addresses.  
```
POST /friendsmanagement/common
``` 

API to subscribe to updates from an email address. 
```
POST /friendsmanagement/subscribe
``` 

API to block updates from an email address.  
```
POST /friendsmanagement/blockupdate
```  

API to retrieve all email addresses that can receive updates from an email address.   
```
POST /friendsmanagement/notify
```  
    
    
## Database
Below is the simple ER Diagram used for the application.

![DB Diagram](https://github.com/poornimabs/friendsmanagement/DB_DESIGN.svg)

