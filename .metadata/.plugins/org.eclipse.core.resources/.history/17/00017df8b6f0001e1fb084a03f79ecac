FROM openjdk:8

WORKDIR /shadab

COPY target/email-microservice-0.0.1-SNAPSHOT.jar email-microservice-0.0.1-SNAPSHOT.jar

COPY docker-entrypoint.sh docker-entrypoint.sh

RUN chmod +x /shadab/docker-entrypoint.sh

EXPOSE 9096

ENTRYPOINT ["/shadab/docker-entrypoint.sh"]

CMD ["email-microservice-0.0.1-SNAPSHOT.jar"]
