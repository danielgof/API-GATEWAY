FROM openjdk:18
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
EXPOSE 8083
ENTRYPOINT ["java","-jar","/order_register_new-0.0.1-SNAPSHOT.jar"]