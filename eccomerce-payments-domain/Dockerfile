

FROM openjdk:14-jdk-alpine
VOLUME /tmp
ADD target/*.jar app.jar
ENTRYPOINT [ "sh", "-c", "java -jar -Djava.security.egd=file:/dev/./urandom  /app.jar" ]


