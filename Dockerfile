FROM maven:3.8.4-openjdk-11-slim

VOLUME /tmp

COPY target/*.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java","-jar","app.jar"]

