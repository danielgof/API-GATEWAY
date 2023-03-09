FROM openjdk:18
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} eureka-server-0.0.1-SNAPSHOT.jar
EXPOSE 8083
ENTRYPOINT ["java","-jar","/eureka-server-0.0.1-SNAPSHOT.jar"]