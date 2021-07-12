# CapgeminiAssignment

<a href="https://opensource.org/licenses/MIT"><img src="https://img.shields.io/badge/License-MIT-blue.svg"></a>

## About

The main requirements that guided the design and implementation of the API to open new current accounts for existing customers:
•	Some customers already exist
•	When an endpoint is accessed with customerId of one of the existing customers and some initialCredit as parameters, a new Current account is created for that customer and if the initialCredit is greater than 0 then a credit transaction is initiated on this new account.
•	When an endpoint is accessed with customerId of one of the existing customers and an accountType as parameters, details of the account and all transactions performed on it should be returned.
•	Code should be readable, maintainable, and testable.
•	Javadoc is created and code is published in github.

## Architecture overview

#### Project structure
```
├── src
│   ├── main
│   │   ├── java
│   │   │   └── com
│   │   │       └── capgemini
│   │   │           └── managecustaccount
│   │   │               ├── controller
│   │   │               │   └── CustomerAccount.java
│   │   │               ├── DTO
│   │   │               │   ├── AccountDTO.java
│	│	│				│	├──	ContactDTO.java
│	│	│				│	├── CustomerDTO.java
│	│	│				│	└──	TransactionDTO.java
│   │   │               ├── entity
│   │   │               │   ├── Account.java
│	│	│				│	├──	Contact.java
│	│	│				│	├── Customer.java
│	│	│				│	└──	Transaction.java
│   │   │               ├── repository
│	│	│				│	├──	AccountRepository.java
│	│	│				│	├── CustomerRepository.java
│	│	│				│	└──	TransactionRepository.java
│   │   │               ├── service
│	│	│				│	├──	AccountService.java
│	│	│				│	├── CustomerService.java
│	│	│				│	└──	TransactionService.java
│	│	│				└── ManageCustAccountApplication.java
│   │   ├── resources
│   │   │   ├── static
│	│	│	│ 	└── index.html
│	│	│	└── templates
│   │   │       ├── application.properties
│   │   │       └── data.sql
│   ├── test
│   │   └── java
│   │       └── com
│   │           └── capgemini
│   │               └── managecustaccount
│   │                   ├── controller
│   │                   │   └── CustomerAccountTest.java
│   │                   ├── service
│	│					│	├──	AccountServiceTest.java
│	│					│	├── CustomerServiceTest.java
│	│					│	└──	TransactionServiceTest.java
│	│					└── ManageCustAccountApplication.java
│	└──	target(contains all class files)
│				
├── pom.xml(contains all the dependencies)
└── README.md

## Dependencies 

#### Tech stack
* Eclipse IDE with Java 8
* [Spring Boot](http://spring.io/projects/spring-boot) for creating the RESTful Web Services
* [MockMVC](https://spring.io/guides/gs/testing-web/) for testing the Web Layer
* [Mockito](https://site.mockito.org/) for testing the Services Layer
* [H2](https://www.h2database.com/) as in memory database
* [Maven](https://maven.apache.org/) for managing the project's build

## DataBase
Console : http://localhost:8080/h2-console/ 
Driver Class : org.h2.Driver
JDBC URL : jdbc:h2:mem:capgprjdb
User Name : sa
Password : capg

## Usage
Request Method | EndPoint | Parameters | Description |  
:---: | :--- | :---: | :--- |
GET | http://localhost:8080/AccountTxn | customerId & accountType | Find original url and redirect | 
POST | http://localhost:8080/currAccount | customerId & initialCredit | creates new current account for the customerId and if the initialCredit > 0 then creates a credit transaction | 

## License
MIT © [cssaranya](https://github.com/cssaranya).
