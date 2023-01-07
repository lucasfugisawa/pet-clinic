FROM openjdk:17
RUN mkdir /app
COPY pet-clinic-web/target/pet-clinic-web-0.0.3-SNAPSHOT.jar /app/pet-clinic-web.jar
EXPOSE 8080
WORKDIR /app
CMD ["java", "-jar", "pet-clinic-web.jar"]
