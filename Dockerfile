FROM maven:3.8.7 as build
COPY . .
RUN mvn -B clean package -DskipTests

FROM openjdk:17
COPY --from=build target/*.jar Cloud-Watch.jar

RUN groupadd --system appgroup && useradd --system --gid appgroup appuser

USER appuser
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "-Dserver.port=8080
