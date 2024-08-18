# Software Projects Management System using Microservices

**Objective:** The main objective of this project is to learn the basics of microservices architecture communication and put in practice some design and architecture patterns. 

**Brief business description:** This project is designed for a software factory company that offers customizable base software products to meet the specific needs of their clients. When a client engages the company, a suitable software product is selected for the project. A 'project leader' can claim an unassigned project, after which a team is automatically chosen using an algorithm. Once the project is underway, requirements can be uploaded, and team members can update their status and log tasks associated with each requirement. When all requirements are completed, the project can be marked as finished.

**Disclaimer:** The technologies used are not intended to be optimal nor for a production environment, I tried to keep it simple in order to accomplish the main objective of the project.

## Index

-  [Description](#description)

-  [Architecture](#architecture)

-  [Requirements](#requirements)

-  [Instalation](#instalation)

-  [Usage](#usage)

-  [Configuration](#configuration)

-  [Testing](#testing)

-  [Author](#author)


## Description

**Limitations:**

Does not include any payment module.

## Architecture

### Architecture Diagram

![Architecture Diagram](./overall_architecture.png)

### Entities Class Diagram

![Entities Class Diagram](./class_diagram.jpg)

### Architecture Description

Springboot was the choice for every microservice because it's the programming language that I'm more familiar with, not for any particular requirement. If I had chosen any other language, it would've taken much more time and I wouldn't be able to focus on learning microservices.

Since I wanted to try the most vanilla microservice development experience, I decided not to use Spring Cloud despite its compatibility with Spring microservices. I believe this approach allows me to learn later other technologies, like Spring Cloud or Kubernetes and not be attached to a specific one.

For the same reason, I decided not to include a Gateway API. There're a lot of Cloud Gateway API, and it's not relevant for what I'm most interested about: the async/sync communication between microservices. How the application will be consumed, it's out of the scope of this project.

### Spring microservices architecture

![Spring Microservices Architecture](./spring_architecture.png)

## Requirements

The only requirement needed to execute the API is Docker, each container has its own dependencies so there's no need to install Java, Gradle, Apache Kafka, etc.


## Instalation



## Usage

**Ports used by default**

If any of these ports are used by other service on your local machine, the application won't start. You must kill any process listening on the following ports:

- Zookeper: 2181
- Apache Kafka: 9092
- MySQL: 3306
- Projects microservice: 8080
- Teams microservice: 8081
- Members microservice: 8082
- Auth microservice: 8083
- Products microservice: 8084

Alternatively, you can change the ports on the docker-compose.yml file

## Configuration



## Testing



## Author

- **Marcos Espeche** - [LinkedIn](http://www.linkedin.com/in/marcos-espeche-villalón-962821208)