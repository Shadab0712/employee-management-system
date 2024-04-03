FROM openjdk:8

WORKDIR /shadab

COPY target/employee-microservice-0.0.1-SNAPSHOT.jar employee-microservice-0.0.1-SNAPSHOT.jar

COPY docker-entrypoint.sh docker-entrypoint.sh

RUN chmod +x /shadab/docker-entrypoint.sh

EXPOSE 9095

ENTRYPOINT ["/shadab/docker-entrypoint.sh"]

CMD ["employee-microservice-0.0.1-SNAPSHOT.jar"]
