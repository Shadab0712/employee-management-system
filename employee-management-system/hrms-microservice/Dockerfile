FROM openjdk:8

WORKDIR /shadab

COPY target/hrms-microservice-0.0.1-SNAPSHOT.jar hrms-microservice-0.0.1-SNAPSHOT.jar

COPY docker-entrypoint.sh docker-entrypoint.sh

RUN chmod +x /shadab/docker-entrypoint.sh

EXPOSE 9097

ENTRYPOINT ["/shadab/docker-entrypoint.sh"]

CMD ["hrms-microservice-0.0.1-SNAPSHOT.jar"]
