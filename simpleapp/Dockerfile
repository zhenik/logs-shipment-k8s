FROM openjdk:15-jdk-slim
VOLUME /tmp
ARG JAR_FILE
COPY target/simple-0.0.1-SNAPSHOT.jar app.jar
# Entrypoint is used for local startup, it will be overridden by Kubernetes.
ENTRYPOINT ["java", "-jar", "/app.jar"]
EXPOSE 8080
