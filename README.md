# Quarkus Java Template Repository

This project is a template to develop reactive microservices using [Quarkus](https://quarkus.io/) with [Java](https://docs.oracle.com/en/java/javase/index.html) language and [GitLab CI/CD](https://docs.gitlab.com/ee/ci/).

## Local develop environment expected before start

- Operational system: Linux or macOS (For Windows we can use WSL with some Linux flavour)
- Package Manager: [Homebrew](https://brew.sh/)
- Automation tool: [GNU make](https://www.gnu.org/software/make/manual/make.html) 
- IDE: [IntelliJ IDEA Community Edition](https://www.jetbrains.com/idea/download/?section=mac)
- Code version control: [Git](https://git-scm.com/)
- Container platform: [Docker](https://www.docker.com/)

## Getting started

View all CLI available commands:
```shell script
make
```

Install all dependencies to local develop environment:
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
  - Reason: Version 17 is the latest LTS and will be supported until at least 2029 
- Java SDK manager: [SDKMan](https://sdkman.io/) (installed by make install)
  - Reason: This manager support us to download, configure and change different Java SDKs easily using CLI
- Java SDK: [Eclipse Adoptium Temurin](https://adoptium.net/) (installed by make install)
  - Reason: Open-source SDK for personal and enterprise development
- Library to improve Java development: [Lombok](https://projectlombok.org/)
  - Reason: To not spend time coding getters, setters, builders and constructors 

### Core Tools and Frameworks
- Microservice framework: [Quarkus](https://quarkus.io/)
  - Reason: Faster way to develop a reactive application based in market standards  
- Dependency management tool: [Maven](https://maven.apache.org/) (Portable embeeded in this project)
  - Reason: Most used dependency management tool in the market
- Reactive toolkit: [Vert.x](https://vertx.io/) (Quarkus integrated)
  - Reason: Easy to learn, comprehensive end-to-end reactive toolkit already integrated with Quarkus 

### Development
- RESTful Web service framework: [RESTEasy reactive](https://jakarta.ee/specifications/restful-ws/3.1/jakarta-restful-ws-spec-3.1.html) for Quarkus (manage by Maven)
  - Reason: It is an implementation of the Eclipse Foundation specification for RESTful WEB application for Java.

### Database
- RDBMS: [PostgreSQL](https://www.postgresql.org/) as Docker
  - Reason: Powerful database used in the market
- RDBMS Console: [PGAdmin](https://www.pgadmin.org/) as Docker
  - Reason: Default administration tool for PostgreSQL
- Reactive RDBMS client: [Quarkus PostgreSQL reactive](https://quarkus.io/extensions/io.quarkus/quarkus-reactive-pg-client)
  - Reason: To be possible build a reactive connection with PostgreSQL

### Tests
- Test framework: [Junit5](https://junit.org/junit5/) for Quarkus (manage by Maven)
  - Reason: The open-source framework for write tests for Java
- Tool to test REST endpoints: [RESTAssured](https://rest-assured.io/) (manage by Maven)
  - Reason: Powerful testing and validation library to test REST APIs in a fluent and simple way

### Conventions
- Java code formatting: [Google Java style](https://google.github.io/styleguide/javaguide.html) guaranteed by [Spotify format maven plugin](https://github.com/spotify/fmt-maven-plugin)
- XML formatting: guaranteed by [XML format maven plugin](https://acegi.github.io/xml-format-maven-plugin/)
- Git commit style: [Conventional Commits](https://www.conventionalcommits.org/)
- Project layers standard: [Ports and adapter structure](https://en.wikipedia.org/wiki/Hexagonal_architecture_(software))
- Domain modeling standard: [Domain Driven Design](https://en.wikipedia.org/wiki/Domain-driven_design) 
- Unit test type: [Sociable tests](https://martinfowler.com/bliki/UnitTest.html)

### Best practices
- Project modularization: [Maven submodules](https://maven.apache.org/guides/mini/guide-multiple-modules.html)
  - module ``api-specification``: responsible for the definition of project APIs
  - module ``app``: responsible for the implementation of project APIs
- API-first strategy: REST API specification defined by [Swagger editor](https://swagger.io/tools/swagger-editor/) following [OpenAPI](https://www.openapis.org/) format
  - run ``$ make api-editor`` to open the current specification.yml file, from api-specification module, within the editor 
  - after changes download the file and replace the current one in the repository
  - run ``$ make build`` to generate the Java interfaces to be implemented in app module
- Make REST API available via Swagger-ui only for development environment and never for production

## Roadmap

### Current step - project
- Add liquibase
- Standard readme
- Have one profile per each type of test
- Add visual code evolution as DNA
- Add commit rule checker
- Add archunit
- REST third level of maturity
- Implement metrics

### Next step - tests
- Add acceptance criteria tests
- Add Load and performance tests

### Next step - pipeline
- Configure pipeline for Gitlab
- add code coverage
- Auto-Identify dependencies to update
- Auto-identify version to increase

### Next step - security
- Add Dast tools
- Add Sast tools (OWASP dependency checker)
- Use distroless for image

### Final step - deploy
- Implement monitoring 
- Create smoke tests
