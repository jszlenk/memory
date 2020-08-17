#FROM adoptopenjdk/openjdk11:latest
#ARG JAR_FILE
#COPY ${JAR_FILE} app.jar
#ENTRYPOINT ["java","-jar","/app.jar"]
#EXPOSE 8080


FROM adoptopenjdk/openjdk11:latest
COPY build/libs/memory-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8080/tcp
ENTRYPOINT ["java","-jar","/app.jar"]
