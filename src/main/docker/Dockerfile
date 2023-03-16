FROM openjdk:8-jdk-alpine3.9
VOLUME ["/tmp","/app"]
COPY static/ /home/app/static/
COPY db /home/app/db/
ADD navigation-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar","--spring.profiles.active=docker"]