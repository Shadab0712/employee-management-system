# Employee Management System

## Overview
This project is a multi-module web application built using Spring Boot. It consists of three modules: `employee-microservice`, `email-microservice`, and `hrms-microservice`. 
These modules communicate with each other via RESTful APIs and are containerized using Docker for easy deployment and scalability.

# Modules
1. **employee-microservice**: This module handles CRUD operations for employees. SQL queries are written manually without using Spring Data JPA for auto-work. Upon employee creation, it makes a REST call to `email-microservice` to send an email notification.

2. **email-microservice**: Responsible for sending email notifications to employees using RestTemplate. It also makes a REST call to `hrms-microservice` for related data retrieval.

3. **hrms-microservice**: Provides related data such as the number of leaves for an employee on a monthly basis. It responds to REST calls made by `email-microservice` upon employee registration.

# Docker Integration
- Each module has a Dockerfile for containerization.
- Docker images are created for each module using the Dockerfile.
- Containers are created from these images and run in the same network to allow communication between modules.

# Logging Integration
- SLF4J is implemented for logging in all microservices.
- Logback configuration is used to define appenders, log levels, and formatting.

---
<br><br>

# Docker Overview

## Introduction
Docker is a containerization platform that allows you to package applications and their dependencies into lightweight containers.

## Docker Concepts
- **Containers**: Lightweight, portable, and self-sufficient units that encapsulate application code and dependencies.
- **Images**: Immutable templates used to create containers. Images contain the application code, runtime, libraries, and dependencies.
- **Dockerfile**: A text file containing instructions to build a Docker image. It specifies the base image, dependencies, environment variables, and commands to run.
- **Docker Hub**: A cloud-based registry for storing and sharing Docker images. It provides public and private repositories for managing images.

## Docker Basic Commands

```bash
docker image ls                         -->  to get images of docker
docker container ls                     -->  to get running containers
docker container ls -a                  -->  to get all containers
docker --version                        -->  Shows the Docker version installed
docker container prune                  -->  Removes all stopped containers
docker inspect CONTAINER_ID             -->  Provides detailed information about a container
docker stop CONTAINER_ID                -->  Stops a running container
docker rm CONTAINER_ID                  -->  Removes a stopped container
docker run -it IMAGE_NAME               -->  Runs a container in interactive mode with a terminal
docker inspect CONTAINER_ID             -->  Provides detailed information about a container
docker push IMAGE_NAME:TAG              -->  Pushes an image to a Docker registry (e.g., Docker Hub)
```

- **To build a docker image using Dockerfile**

```bash
docker image build -t image-name
```

- **To build and run a docker container using docker image**

```bash
docker container run -d --name=container-name -p 0000:0000 --network "network-name" image-name

-d (run container in detach mode and Docker container runs in the background of your terminal )
-p (port expose)

```

- **To build and run a docker container of SQL**

```bash
docker run -d --name sql -p 3306:3306 -e MYSQL_ROOT_PASSWORD=abc1234 -v --network "my-network-name" mysql-data:/var/lib/mysql mysql:latest

-e (passing the neccessary environment variable)
path is given so that the data gets permanently stored in the table at that particular storage path 
```

---
<br><br>

## Logging Concepts and Best Practices
- SLF4J is implemented for logging in all microservices.
- Logback configuration is used to define appenders, log levels, and formatting.

## Introduction
Logging is a crucial aspect of software development, providing insights into the behavior and performance of an application during runtime. This README covers logging concepts, benefits, best practices, and implementation guidelines.

## Logging Basics
- **Logging Levels**: Understand different logging levels such as DEBUG, INFO, WARN, ERROR, etc., and when to use each level based on the severity of the message.
- **Loggers and Log Entries**: Familiarize yourself with loggers and how log entries are created and written to log files or other destinations.
- **Log Formats**: Learn about log formats and standards like JSON, XML, or plain text, and choose a format that suits your application and logging needs.

## Benefits of Logging
- **Debugging**: Logging helps in identifying and diagnosing issues during development and testing phases.
- **Monitoring and Performance Analysis**: Log data can be used to monitor application performance and identify bottlenecks.
- **Security and Compliance**: Logging security-related events aids in intrusion detection, compliance, and audit trail creation.
- **Historical Analysis**: Historical logs provide insights into application behavior, trends, and patterns for analysis and improvement.

## Best Practices
- **Use Appropriate Logging Levels**: Use the appropriate logging level for each log message based on its severity and relevance.
- **Secure Logging**: Ensure that sensitive information is not logged in plain text and implement secure logging practices.

## Logging Implementation
- **Choose a Logging Framework**: Select a suitable logging framework such as SLF4J with Logback for Java applications.
- **Configuration**: Configure logging levels, formats, appenders, and log rotation settings based on your application's requirements.
- **Integration with Monitoring Tools**: Integrate logging with monitoring and log management tools (e.g., SPring Actuator) for centralized log aggregation and analysis.

# Logback Configuration README

## Introduction
The below explains the configuration of the Logback logging framework using the provided logback.xml file. Logback is a popular logging framework for Java applications, offering features like log file rolling, console logging, and customizable logging levels.

## Configuration Overview
The logback.xml file contains configurations for two appenders (`FILE-ROLLING` and `CONSOLE`) and logger settings for specific packages.

### Appenders
 **FILE-ROLLING Appender**:
   - **This appender is a RollingFileAppender configured to write log messages to a file (`logs/app.log`) and roll over log files based on size and time**.
   - **fileNamePattern**: Specifies the pattern for naming rolled over log files.
   - **maxFileSize**: Limits the size of each archived log file to the size provided by you.
   - **totalSizeCap**: Specifies the total size limit for all archived log files to the size provided by you. Older archived files are deleted if this limit is exceeded.
   - **maxHistory**: Defines the number of days to keep archived log files (60 days in this case).
   - **encoder**: Configures the log message format.

 **CONSOLE Appender**:
   - This appender is a ConsoleAppender configured to log messages to the console.
   - Uses a PatternLayout to format log messages with a timestamp, thread ID, log level, logger name, and message.

### Loggers

```bash
  - com.qtechlabs.employeemanagement.controller` Logger:
  - Configured at the INFO level with additivity set to false, meaning it won't inherit appenders from parent loggers.
  - Logs messages from the specified package to the FILE-ROLLING appender.
  ```

- **Root Logger (`<root>`)**:
  - Configured at the INFO level with an appender-ref to the CONSOLE appender.
  - Logs messages from all packages to the CONSOLE appender.

## Usage
- Clone or download the logback.xml file to your project's resource directory (e.g., `src/main/resources`).
- Customize the configurations as needed for your application's logging requirements.
- Start your Spring Boot or Java application, and log messages will be directed to the configured appenders based on the logger levels and packages.


---
<br><br><br>


# Spring Boot Actuator Monitoring


## Introduction
```bash
Spring Boot Actuator is a module that provides production-ready features to monitor and manage your Spring Boot application. 
It offers various endpoints and metrics that can be used for monitoring, health checks, auditing, and managing your application.
```

Provide step-by-step instructions on how to set up Actuator in a Spring Boot project:

```bash
- Adding Actuator dependency
- Configuring Actuator endpoints in `application.properties` or `application.yml`
- Starting the Spring Boot application to access Actuator endpoints
```

## Actuator Endpoints
Describe the available Actuator endpoints and their functionalities:

```bash
- `/actuator/info`: Application information
- `/actuator/health`: Health status
- `/actuator/metrics`: Metrics and statistics
- `/actuator/beans`: Spring beans information
```
---
<br><br>

## Git Overview
- **Git is a VCS → version control system.**

```bash
Basically Git is a software where any programming code is stored in the form of versions and if in future we have to use
that code again or if we have to modify it we use Git which helps us to store it in the form of different versions.
```
- **Git Hub:** also known as Remote Repository (a place where we can store things)

- **Branch in Git**
Branch is an essential feature or a mechanism which is used to work on tasks by developers, allowing them to make changes & modifications in the code. It consists of two things :-

```bash
- master or main 
- develop 
```
 
**For example** 
<br>
whenever we are pushing our code to our Git Repository to ek branch ban jaygi **main or master branch** jisme hamara poora 
updated code rahega or fir hm main branch me se ek **develop** branch banayenge which will consist of same code which is in 
main branch or ye dono branch hamesha sync me hogi , so now agar hmae koi work karna hai apne code me to develop branch
me se ham ek new branch nikaalenge which will be known as **feature** branch and is branch me ham apna poora work karenge
and new version of code ban jane ke bad we have to **commit the code** and generate a merge request and apna code develop 
branch m merge ho jayga (after testing and deployment) aur poora kaam ho jaane k baad hm feature branch ko delete kar denge.


**Master and Develop (are known as main branches) and the other branch where we will modify code is known as Feature Branch.**

**Aur feature branch hamesha develop branch me se hi ayegi and there will not be any change in the main branch directly and we have to make another feature branch for further modification.**

**Git commands**

```bash
git init
git add
git Status
git commit
git push
git checkout
git log
git merge
```
<br>

**Terms in Git we will use and face**
- pull request merge request
- conflict

---Note---
( jab bhi feature branch me se code, main branch me merge karenge to kabhi kabhi conflict/ problems aati hai merge karne mein so it is known as conflicts. )

---
<br><br>

