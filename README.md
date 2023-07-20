# Quarkus Java Template Repository

This project is a template to develop reactive microservices using Quarkus with Java language.

## Develop environment expected before start

- Operational system: macOS
- Package Manager: [Homebrew](https://brew.sh/)
- IDE: [IntelliJ IDEA Community Edition](https://www.jetbrains.com/idea/download/?section=mac)
- Code version control: [Git](https://git-scm.com/)
- Container platform: [Docker](https://www.docker.com/)
- CI/CD platform: [GitLab CI/CD](https://docs.gitlab.com/ee/ci/)

## Getting started

View all CLI available commands:
```shell script
make
```

Install all dependencies to develop environment:
```shell script
make install
```

Run the application in dev mode:
```shell script
make run
```

## Template structure, tools, patterns and good practices

### Java 
- Java version: [Java 17](https://jdk.java.net/17/)
- Java SDK manager: [SDKMan](https://sdkman.io/) (installed by make install)
- Java OpenJDK: [17.0.8-zulu](https://www.azul.com/downloads/?package=jdk#zulu) (installed by make install)

### Core Tools and Frameworks
- Microservice framework: [Quarkus](https://quarkus.io/)
- Dependency management tool: [Maven](https://maven.apache.org/) (Portable embeeded in this project)
- Reactive toolkit: [Vert.x](https://vertx.io/) (Quarkus integrated)

### Development
- RESTful Web service framework: [RESTEasy reactive](https://jakarta.ee/specifications/restful-ws/3.1/jakarta-restful-ws-spec-3.1.html) for Quarkus (manage by Maven)

### Tests
- Test framework: [Junit5](https://junit.org/junit5/) for Quarkus (manage by Maven)
- Tool to test REST endpoints: [RESTAssured](https://rest-assured.io/) (manage by Maven)

### Conventions
- Git commit style: [Conventional Commits](https://www.conventionalcommits.org/)

## Next steps, not ordered
- Add lombok
- Add Swagger and OpenAPI
- Add reactive JPA with Oracle
- Add liquibase
- Create simple CRUD as example
- Add Code formatter
- Add acceptance criteria tests
- Add Load and performance tests
- Add OWASP dependency checker
- Define structure standard for project
- Use distroless for image
- Define type of unit tests
- Create smoke tests
- Implement authentication using oauth
- Configure pipeline for Gitlab
- Add archunit
- Add cache
- Add tool for profiling
- Add commit rule checker
- Have one profile per each type of test
- Add Sast tools
- Add Dast tools
- Auto-Identify dependencies to update
- Auto-identify version to increase
- Add visual code evolution as DNA
- add code coverage
- Implement a client with circuitbreaker for another service
- Implement monitoring

## Next repositories as examples
- Implement RabbitMQ
- Implement Kafka
- Implement RPC

