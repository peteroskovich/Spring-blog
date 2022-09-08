# Spring blog
## _and book showcase_

![download](https://user-images.githubusercontent.com/79411486/189002023-4d8a0530-1f49-4f08-b701-1a06fd661a8d.png)




# Idea

This is a web application developed with Java, Thyemeleaf and Spring Boot Framework. 
The main idea is a web blog and book showcase that provides user authentication with the possibility to  post and edit  blog massages and book showcase. 


## Installation



To build and run this web application, first install [MAMP](https://www.mamp.info/) database from the official website.

Open MAMP press Open WebStart page, check the section MySQL have the Port **3306** .
If is different,  change in the file  `application.properties` the section 
`spring.datasource.url` write your own port instead  **3306** 


In MAMP press Start Server 


### How to Build

The project can be build using the maven command `mvn package`. This will create  runnable jar
in the `target` directory:
* `target/shop-0.0.1-SNAPSHOT.jar` when executed it will launch the spring server

The Java version of the project is 17.


### How to Run

Now you can open the  browser  http://localhost:8080/
The login credential are inside the classes  `WebSecurity`  and  `MvcConfig`

admin : dim

user : nim

See that the capabilities  of the webservice are different and depend on each user's privilege.

## Implementation

This project is  developed with the following technologies:
- Java, Maven, JUnit testing
- Spring Framefork (Spring Boot, Spring MVC, Spring data JPA, Spring Security)
- Hibernate framework
- Thymeleaf (template engine)
- Frontend tools and languages (HTML, CSS, Bootstrap)
- Backend (MySQL database, MAMP)

The Java programming techniques that we used are:
- **Collection Framework:**  For Optional to store Post , Book ropository 
- **Interfaces** Used for Book and Post Repository
- **Lambda:** method refference to add for ArrayList in BlogController
- **HTTP** Different web pages
- **Exception handling:** RuntimeException in  WebSecurityConfig
- **Method overriding:** Overriden methods from Spring classes
- **Streams:** Used in WebSecurityConfig
- **Optionals:** Used to find entities in the database 
- **File I/O:** Img upload to database
- **Design patterns :** 
- MVC ( using contollers and models design );
- Fabric pattern (use interface for create instance of repository); 
- CRUD (Create , read ,update delete data from database);


## My experience
The development of at first look small project  , at the end  it took me a some  time to understand how the beans work in Spring, how the GET and POST methods are called, how thyemleaf works in bundles with Spring , Hibernate and DataBase.Even do I feel that the project can be improved endlessly ,I am satisfied.



## License

Copyright © 2022 Petr Silukov.
