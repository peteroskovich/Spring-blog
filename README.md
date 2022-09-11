# Spring blog

## _and book showcase_



![download](https://user-images.githubusercontent.com/79411486/189002023-4d8a0530-1f49-4f08-b701-1a06fd661a8d.png)









# Idea



This is a web application developed with Java, Thyemeleaf and Spring Boot Framework. 
The main idea is a web blog and book showcase that provides user authentication with the possibility to  post and edit  blog massages and book showcase. 





##  1# Installation







 To build and run this web application, first install [MAMP](https://www.mamp.info/) database on the official website.



1) Open MAMP.exe on your desktop (Make sure __NOT__  MAMP PRO icon)

2) Press __Start Server__ ( make sure the icon turns green )

3) Press __Open WebStart page__ button (it will redirect you to the webpage http://localhost/MAMP/ )

4) Please check the section  __MySQL__   on the webpage , it should look like this :

Host    localhost

Port    3306

User    root

Password    root



5) If you see that the  __Port__ is different, please change  the file  `application.properties`      (you find it at    `Spring-blog-main\src\main\resources` ) 
at  the line `spring.datasource.url=jdbc:mysql://${MYSQL_HOST:localhost}:3306/.....`  write the port that you see   instead  **3306** 











###  2# How to Build



Now the project can be build using the maven command `mvn package` 

1) Open the command line in the directory where you downloaded __Spring-blog-main__ folder . 

2) This will create  runnable jar in the `target` directory:

* `target/shop-0.0.1-SNAPSHOT.jar` launch and it will start the spring application



The Java version of the project is 17.





###  3# How to Run
Now you should be able to open  http://localhost:8080/

If the page won't load  it is  probably because your port 8080 is already used,  please try this [instruction](https://stackoverflow.com/questions/39632667/how-do-i-kill-the-process-currently-using-a-port-on-localhost-in-windows)

Double check that MAMP server is started

If the page is loaded, you can enter one of those credentials:

 username : __admin__     
 password :  __dim__

username : __user__

password : __nim__





Please  try to enter with both.
You will see that the capabilities  of the webservice are different and depend on each user's privilege.
__User__ cannot add , edit and delete posts and books.
__Admin__ can add, edit and delete posts and books.
You can find login credential  inside the classes  `WebSecurity`  and  `MvcConfig`



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
- **Lambda:** method reference to add for ArrayList in BlogController
- **HTTP** Different web pages
- **Exception handling:** RuntimeException in  WebSecurityConfig
- **Method overriding:** Overridden methods from Spring classes
- **Streams:** Used in WebSecurityConfig
- **Optionals:** Used to find entities in the database 
- **File I/O:** Img upload to database
- **Design patterns :** 
- MVC ( using controllers and models design );
- Fabric pattern (use interface for create instance of repository); 
- CRUD (Create , read ,update delete data from database);





## My experience

The project seems small, but during development It took me some  time to understand how the beans work in Spring, how the GET and POST methods are called, how thyemleaf works in bundles with Spring , Hibernate and DataBase.Even if I feel that the project can be improved endlessly ,I am satisfied.







## License



Copyright © 2022 Petr Silukov.
