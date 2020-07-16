#
# Build stage
#
# FROM maven:3.6.3-jdk-8 AS build
# COPY . /home/spring-application
# WORKDIR /home/spring-application
# RUN ls -la
# RUN mvn --version
# RUN mvn -f pom.xml clean install
# RUN mvn clean package
# RUN ls target

# #
# Package stage
#
FROM openjdk:8-jdk-alpine
RUN addgroup -S spring && adduser -S spring -G spring
USER spring:spring
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} /usr/local/lib/app.jar

EXPOSE 8088
ENTRYPOINT ["java","-jar","/usr/local/lib/app.jar"]
