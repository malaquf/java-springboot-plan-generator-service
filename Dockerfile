FROM openjdk:12-alpine
MAINTAINER Felipe Malaquias
ENV APP_FILE plan-generator-service-0.0.1-SNAPSHOT.jar
ENV APP_HOME /app
EXPOSE 8060
COPY target/$APP_FILE $APP_HOME/
WORKDIR $APP_HOME
ENTRYPOINT ["sh", "-c"]
CMD ["exec java -jar $APP_FILE"]