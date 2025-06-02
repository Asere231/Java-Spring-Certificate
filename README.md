# Java-Spring-Certificate Projects

This repository contains all my Java projects completed as part of a Java Certification course.  
Each folder represents a separate project, demonstrating key concepts and skills in Java programming.

## 📁 Directory Overview

- **QUIZ_CONSOLE_APP**  
  A very simple console-based quiz application — the first project in this course. It showcases the basics of Java programming, including object-oriented design, class creation, arrays, and user input using `Scanner`.  
  The program asks the user a series of multiple-choice questions, records their answers, and prints a score at the end. It's designed to reinforce fundamental Java concepts in a practical and interactive way.

- **DemoJDBC**  
  A standalone project built in IntelliJ to learn the fundamentals of **JDBC (Java Database Connectivity)**.  
  It demonstrates how to connect to a PostgreSQL database, run queries, insert records using `PreparedStatement`, and properly manage database resources.  
  The focus is on learning the basic steps: loading the driver, establishing a connection, executing SQL, and closing resources.

- **HibernateDemo**  
  A separate IntelliJ project designed to learn **Hibernate**, a powerful ORM (Object-Relational Mapping) framework.  
  This project includes examples using annotated entity classes like `Laptop`, `Alien`, and `Student`.  
  It covers configuration via `hibernate.cfg.xml` and `hibernate.properties`, session management, and how to perform CRUD operations using Hibernate's Session API.  
  Emphasis is placed on separating configuration from code for secure credential handling and scalable design.

- **SpringDemo**  
  A basic Spring project that introduces **Java-based configuration** using `@Configuration`, `@Bean`, and dependency injection through setters.  
  It demonstrates how to wire custom beans (`Alien`, `Laptop`, `Desktop`) using interfaces like `Computer`, and manage their interactions via Spring's ApplicationContext.  
  This project avoids component scanning and instead uses manual bean registration to reinforce foundational Spring IoC concepts.  
  Logs such as "Laptop created" and "Compiling..." help visualize bean instantiation and method execution.

- **SpringBootDemo**  
  A transition project from **SpringDemo** to **Spring Boot**, this application introduces Spring Boot's auto-configuration and simplified setup using `@SpringBootApplication`.  
  It demonstrates how to register beans like `Laptop`, `Desktop`, and `CPU` using `@Component` and how to inject dependencies automatically into the `Alien` class using `@Autowired`.  
  The project eliminates the need for manual configuration files (`@Configuration`, `@Bean`) and instead leverages component scanning and Spring Boot’s convention-over-configuration approach.  
  It serves as a foundation for building modern Spring Boot applications with clean code, better structure, and minimal boilerplate.

- **SpringJDBC**  
  A Spring Boot project focused on using **Spring JDBC** to perform database operations in a clean and layered architecture.  
  The project demonstrates how to connect to a PostgreSQL database using Spring Boot’s `application.properties`, load schema and data using `schema.sql` and `data.sql`, and define service and repository layers (`StudentService`, `StudentRepo`) to manage student records.  
  It uses `JdbcTemplate` for querying the database and maps results to Java objects like `Student`.  
  Environment-sensitive configuration (e.g. DB credentials) can be separated from Git-tracked files using a `local` profile or environment variables to ensure secure development practices.  
  This project serves as a hands-on introduction to working with relational databases in Spring Boot without using JPA or Hibernate.


