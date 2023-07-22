# Quarkus Java Template Repository

This project is a template to develop reactive microservices using Quarkus with Java language.

## Develop environment expected before start

- Operational system: macOS
- Package Manager: [Homebrew](https://brew.sh/)
- Automation tool: [GNU make](https://www.gnu.org/software/make/manual/make.html) 
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
- Java code formatting: [Google Java style](https://google.github.io/styleguide/javaguide.html) guaranteed by [Spotify format maven plugin](https://github.com/spotify/fmt-maven-plugin)
- XML formatting: guaranteed by [XML format maven plugin](https://acegi.github.io/xml-format-maven-plugin/)
- Git commit style: [Conventional Commits](https://www.conventionalcommits.org/)

### Best practices
- Project modularization: [Maven submodules](https://maven.apache.org/guides/mini/guide-multiple-modules.html)
  - module ``api-specification``: responsible for the definition of project APIs
  - module ``app``: responsible for the implementation of project APIs
- API-first strategy: API specification defined by [Swagger editor](https://swagger.io/tools/swagger-editor/) following [OpenAPI](https://www.openapis.org/) format
  - run ``$ make api-editor`` to open the current specification.yml file, from api-specification module, within the editor 
  - after changes download the file and replace the current one in the repository
  - run ``$ make build`` to generate the Java interfaces to be implemented in app module


## Roadmap

### Version 0.0.1
- Add lombok
- Add Swagger and OpenAPI
- Add reactive JPA with PostgreSQL
- Add liquibase
- Create simple CRUD as example
- Define structure standard for project
- Define type of unit tests
- add code coverage

### Version 1.0.0
- Add archunit
- Configure pipeline for Gitlab
- Add OWASP dependency checker
- Auto-Identify dependencies to update
- Auto-identify version to increase

### Version 2.0.0
- Add acceptance criteria tests
- Add Load and performance tests
- Have one profile per each type of test
- Add visual code evolution as DNA

### Version 3.0.0
- Add Sast tools
- Add cache
- Add commit rule checker
- Create smoke tests

### Future
- Use distroless for image
- Add tool for profiling
- Add Dast tools
- Implement a client with circuitbreaker for another service
- Implement monitoring

## Next repositories as examples
- Implement authentication using oauth
- Implement RabbitMQ
- Implement Kafka
- Implement RPC
