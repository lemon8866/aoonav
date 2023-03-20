FROM --platform=linux/arm64 openjdk:21-slim-buster
VOLUME ["/tmp","/app"]
COPY static/ /home/app/static/
COPY db /home/app/db/
ADD navigation-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar","--spring.profiles.active=docker"]