FROM openjdk:11
WORKDIR /
EXPOSE 8080
COPY build/libs/OgongSii_BackEnd_V2-0.0.1.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]