
## Docker Commands

To build the docker image, run the following command at the top level folder:

```
docker build -t docker.io/aristostheo/estore:v1.0.0 .
```

Push image to docker:
```
docker push docker.io/aristostheo/estore:v1.0.0
```

To run the docker compose:
```
docker-compose up
```

Press `CTRL-C` to exit the running applications