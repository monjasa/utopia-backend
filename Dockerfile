FROM maven:3.8.5-openjdk-17 as build
WORKDIR /usr/src/app
COPY ./pom.xml ./pom.xml
RUN mvn -B dependency:resolve-plugins dependency:resolve
COPY ./src ./src
RUN mvn package -DskipTests

FROM openjdk:17.0.2
COPY --from=build /usr/src/app/target/*.jar /usr/bin/app.jar
ENTRYPOINT ["java", "-jar", "/usr/bin/app.jar"]
