
docker-build:
	docker build -t eshurupov/em23-routes:1.0 -t eshurupov/em23-routes:latest .

docker-login:
	docker login

docker-push:
	docker push --all-tags eshurupov/em23-routes

docker-build-push: docker-build docker-push

build:
	./mvnw clean package -DskipTests

docker-fast-build: build
	docker build -f DockerfileFast -t eshurupov/em23-routes:1.0 -t eshurupov/em23-routes:latest .

docker-fast-build-push: docker-fast-build docker-push