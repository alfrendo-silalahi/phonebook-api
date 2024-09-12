FROM openjdk:17-jdk-slim

WORKDIR /app

COPY build/libs/phonebook-be-springboot-0.0.1-SNAPSHOT.jar phonebook-be-springboot-0.0.1-SNAPSHOT.jar

EXPOSE 8080

CMD ["java", "-jar", "phonebook-be-springboot-0.0.1-SNAPSHOT.jar"]