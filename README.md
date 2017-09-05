## Building and running using Eventuate Local

First, build the application

```
./gradlew assemble
```

Next, launch the services using [Docker Compose](https://docs.docker.com/compose/):

```
export DOCKER_HOST_IP=...
docker-compose build
docker-compose up -d
```

Note: You need to set `DOCKER_HOST_IP` before running Docker Compose.
This must be an IP address or resolvable hostname.
It cannot be `localhost`.
See this [guide to setting `DOCKER_HOST_IP`](http://eventuate.io/docs/usingdocker.html) for more information.

# Using the application

Once the application has started, you can use the application via the Swagger UI.

* `http://${DOCKER_HOST_IP}:8081/swagger-ui.html`
* `http://${DOCKER_HOST_IP}:8082/swagger-ui.html`

# Using the Eventuate Local console

You can also use the Eventuate Local console to view aggregates and watch the stream of events.
Visit the URL `http://${DOCKER_HOST_IP}:8085`

