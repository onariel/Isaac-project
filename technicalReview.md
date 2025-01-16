# Project Technical Document

## Introduction
This document provides a technical overview of the collaborative task management application. We had for objective to design and implement a collaborative task management application.

The main features of the application are: personnel management, task management, project management, project monitoring, user interface and report generation.

This document provides an overview of the project structure, technologies used, dependencies, and other relevant information.

## Technologies Used
- **Programming Language:** Java
- **Build Tool:** Maven
- **Frameworks and Libraries:** JavaFX, Spring Boot, Logback, Jupiter, Gson, Itextpdf, Cassandra, Lombok.

## Project Structure
The project follows a standard Maven directory structure:
```
project-root/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── isaac.isep.isaacproject/
│   │   │       ├── Apiconnector/
│   │   │       │   ├── PostgresqlManager
│   │   │       │   └── RequestLogin
│   │   │       ├── Backend/
│   │   │       │   ├── Employee
│   │   │       │   ├── Project
│   │   │       │   └── Task
│   │   │       ├── Controllers/
│   │   │       │   ├── AccountCreationPageController
│   │   │       │   ├── KanbanViewController
│   │   │       │   ├── LoginPageController
│   │   │       │   ├── MainPageController
│   │   │       │   └── ProjectCreationPageController
│   │   │       ├── DataBaseManager
│   │   │       ├── Initializer
│   │   │       ├── Report
│   │   │       └── RunApplication
│   └── resources/
│       └── isaac.isep.isaacproject/
│       │   ├── Account-creation-page.fxml
│       │   ├── Kanban-view.fxml
│       │   ├── Login-page.fxml
│       │   ├── Main-Page.fxml
│       │   └── Project-creation-page.fxml
│       └── data.json
├── module-info.java
├── docker-compose.yml
└── pom.xml
```


- **src/main/java:** Contains the main source code
- **src/main/resources:** Contains configuration files and resources
- **pom.xml:** Maven configuration file



## Dependencies
The project uses the following Maven dependencies:
```xml
<dependencies>
        <dependency>
            <groupId>org.openjfx</groupId>
            <artifactId>javafx-controls</artifactId>
            <version>17.0.6</version>
        </dependency>
        
        <dependency>
            <groupId>org.openjfx</groupId>
            <artifactId>javafx-fxml</artifactId>
            <version>17.0.6</version>
        </dependency>
        
        <!-- https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-web -->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
            <version>3.4.1</version>
        </dependency>
        
        <dependency>
            <groupId>ch.qos.logback</groupId>
            <artifactId>logback-classic</artifactId>
        </dependency>

        <dependency>
            <groupId>org.junit.jupiter</groupId>
            <artifactId>junit-jupiter-api</artifactId>
            <version>${junit.version}</version>
            <scope>test</scope>
        </dependency>
        
        <dependency>
            <groupId>org.junit.jupiter</groupId>
            <artifactId>junit-jupiter-engine</artifactId>
            <version>${junit.version}</version>
            <scope>test</scope>
        </dependency>

        <dependency>
            <groupId>com.google.code.gson</groupId>
            <artifactId>gson</artifactId>
            <version>2.8.9</version>
        </dependency>
        
        <dependency>
            <groupId>com.itextpdf</groupId>
            <artifactId>itext7-core</artifactId>
            <version>7.1.19</version>
        </dependency>

        <dependency>
            <groupId> org.apache.cassandra</groupId>
            <artifactId>cassandra-all</artifactId>
            <version>0.8.1</version>

            <exclusions>
                <exclusion>
                    <groupId>org.slf4j</groupId>
                    <artifactId>slf4j-log4j12</artifactId>
                </exclusion>
                
                <exclusion>
                    <groupId>log4j</groupId>
                    <artifactId>log4j</artifactId>
                </exclusion>
            </exclusions>

        </dependency>
        
        <dependency>
            <groupId>org.projectlombok</groupId>
            <artifactId>lombok</artifactId>
            <scope>annotationProcessor</scope>
        </dependency>
    </dependencies>
```

## Database 

## Conclusion

