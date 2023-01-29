FROM openjdk:17.0.2-jdk

COPY build/libs/restfull-api-0.0.1-SNAPSHOT.jar /app/application.jar

CMD ["java", "-jar", "/app/application.jar"]