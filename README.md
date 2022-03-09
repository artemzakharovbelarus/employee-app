Managing application.

Architecture:
Domain driven design (application layer, flat services) + immutable domain objects

docker-compose.yml, .env in root directory are for local development
etc - directory with everything for deploying application in Docker.

Pull docker image command:
docker pull docker pull artemzakharovby/targsoft-app:latest

ATTENTION! Run docker image with .env file from etc directory