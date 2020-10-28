# Load image
FROM maven:3.6.0-jdk-11-slim AS build
# Copy src to /home/app/src
COPY src /home/app/src
# Copy pom.xml to /home/app
COPY pom.xml /home/app
# Build maven project
RUN mvn -B package --file /home/app/pom.xml

# Load image
FROM openjdk:11-jre-slim
# Copy the generated jar to /usr/local/lib/demo.jar
COPY --from=build /home/app/target/backend-1.0-jar-with-dependencies.jar /usr/local/lib/backend.jar
# Expose docker port to 5000
EXPOSE 5000
# Start java system
ENTRYPOINT ["java","-jar","/usr/local/lib/backend.jar"]