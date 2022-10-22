FROM openjdk:17-alpine

COPY build/libs/ae-landfill.jar /ae-landfill.jar
COPY build/resources/main/application.properties /application.properties
COPY /docker /docker

COPY /docker /docker

RUN chmod +x /docker/*
RUN apk update && apk add curl docker openrc 
RUN rc-update add docker boot 

ENTRYPOINT ["./docker/entrypoint.sh"]

HEALTHCHECK --interval=1s --timeout=3s --retries=60 CMD curl --fail http://localhost:8100/health || exit 1

EXPOSE 8100