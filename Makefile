.PHONY: help # = Generate list of targets with descriptions
help:
	@grep '^.PHONY: .* #' Makefile | sed 's/\.PHONY: \(.*\) # \(.*\)/\1 \2/' | expand -t20

.PHONY: install # = Install all dependencies to develop environment
install:
	brew install maven
	brew install curl 
	curl -s "https://get.sdkman.io" | bash
	bash -c 'source "$${HOME}/.sdkman/bin/sdkman-init.sh" && sdk selfupdate && sdk install java 17.0.8-zulu'
	mvn clean install

.PHONY: build # = Build application
build:
	mvn clean install -DskipTests

.PHONY: run # = Run the application in dev mode (press 'q' to quit)
run:
	open http://localhost:8080
	open http://localhost:8080/q/dev/
	mvn -f app quarkus:dev

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
	docker run -i --rm -p 8080:8080 quarkus-java-template

.PHONY: format # = Format code (this step runs within the 'make build')
format:
	mvn com.spotify.fmt:fmt-maven-plugin:format
