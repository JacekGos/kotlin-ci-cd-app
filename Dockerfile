FROM eclipse-temurin:21-jdk AS build
WORKDIR /app
COPY gradle gradle
COPY gradlew build.gradle.kts settings.gradle.kts ./
COPY src src
RUN chmod +x gradlew && ./gradlew bootJar --no-daemon

FROM eclipse-temurin:21-jre
WORKDIR /app
COPY --from=build /app/build/libs/*.jar app.jar
EXPOSE 9090
ENTRYPOINT ["java", "-jar", "app.jar"]

#FROM eclipse-temurin:21-jdk
#WORKDIR /app
#COPY gradle gradle
#COPY gradlew build.gradle.kts settings.gradle.kts ./
#COPY src src
#RUN chmod +x gradlew && ./gradlew bootJar --no-daemon
#EXPOSE 8080
#ENTRYPOINT ["java", "-jar", "build/libs/kotlin_test-0.0.1-SNAPSHOT.jar"]
