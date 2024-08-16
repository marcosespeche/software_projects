FROM alpine:latest as build

RUN apk update
RUN apk add openjdk17

COPY . .
RUN chmod +x ./gradlew
RUN ./gradlew bootJar --no-daemon

FROM openjdk:17-alpine
EXPOSE 8081
COPY --from=build ./build/libs/teams-0.0.1-SNAPSHOT.jar ./app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]