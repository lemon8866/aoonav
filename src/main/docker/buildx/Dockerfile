FROM alpine
RUN sed -i 's/dl-cdn.alpinelinux.org/mirrors.ustc.edu.cn/g' /etc/apk/repositories && \
    apk upgrade --update-cache && \
    apk add openjdk8 && \
    rm -rf /tmp/* /var/cache/apk/*
VOLUME ["/tmp","/app"]
COPY static/ /home/app/static/
COPY db /home/app/db/
RUN mkdir -p /app/upload
ADD navigation-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar","--spring.profiles.active=docker"]