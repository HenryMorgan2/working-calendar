FROM openjdk:17-alpine

ARG JAR_FILE=target/working-calendar.jar

WORKDIR /app

COPY ${JAR_FILE} app.jar

CMD exec java -jar app.jar
