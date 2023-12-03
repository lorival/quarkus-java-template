.PHONY: help # = Generate list of targets with descriptions
help:
	@grep '^.PHONY: .* #' Makefile | sed 's/\.PHONY: \(.*\) # \(.*\)/\1 \2/' | expand -t20

.PHONY: install # = Install all dependencies to develop environment
install:
	brew install maven
	brew install curl 
	curl -s "https://get.sdkman.io" | bash
	bash -c 'source "$${HOME}/.sdkman/bin/sdkman-init.sh" && sdk selfupdate && sdk install java 17.0.8-tem'
	mvn clean install

.PHONY: build # = Build application
build:
	mvn clean install -DskipTests

.PHONY: runq # = Run the quarkus application in dev mode (press 'q' to quit)
runq: build
	docker-compose up -d pg pgadmin
	mvn -f infrastructure/adapters/drive/quarkus_pgsql_repository_adapter liquibase:update
	open http://localhost:5050 # pgadmin
	open http://localhost:8080/q/swagger-ui/ # swagger-ui
	open http://localhost:8080/q/dev/ # quarkus for developers
	mvn -f infrastructure/launcher/quarkus_launcher quarkus:dev -Dquarkus.swagger-ui.enable=true -Dquarkus.smallrye-openapi.enable=true

.PHONY: runs # = Run the spring application in dev mode (press 'ctrl + c' to quit)
runs: build
	docker-compose up -d pg pgadmin
	open http://localhost:5050 # pgadmin
	open http://localhost:8080/swagger-ui/index.html # swagger-ui
	mvn -f infrastructure/launcher/spring_launcher spring-boot:run -Dspring-boot.run.jvmArguments="-agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=*:5005"

.PHONY: debugs # = Run the spring application in dev mode (press 'ctrl + c' to quit)
debugs:
	mvn -f infrastructure/launcher/spring_launcher spring-boot:run -Dspring-boot.run.jvmArguments="-agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=*:5005"


.PHONY: docker # = Build docker image
docker:
	mvn clean package -DskipTests
	cd app && docker build -f src/main/docker/Dockerfile.jvm -t quarkus-java-template .

.PHONY: docker-native # = Build docker image with Quarkus native (no JVM)
docker-native:
	mvn clean package -Dnative -DskipTests -Dquarkus.native.container-build=true
	cd app && docker build -f src/main/docker/Dockerfile.native -t quarkus-java-template .

.PHONY: docker-run # = Run docker image built (press 'ctrl + c' to quit)
docker-run:
	open http://localhost:8080
	docker run -e "QUARKUS_SWAGGER_UI_ENABLE=true" -e "QUARKUS_SMALLRYE_OPENAPI_ENABLE=true" -i --rm -p 8080:8080 quarkus-java-template

docker-clean:
	docker-compose down --volumes --remove-orphans

.PHONY: format # = Format code (this step runs within the 'make build')
format:
	mvn com.spotify.fmt:fmt-maven-plugin:format

.PHONY: api-editor # = Run Swagger editor to support the development of openAPI specification files
api-editor:
	docker-compose down api-editor
	docker-compose up -d api-editor
	open http://localhost
