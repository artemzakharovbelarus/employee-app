FROM java:8

EXPOSE ${SERVER_PORT}

COPY ${JAR_FILE} /targsoft-app.jar

ENTRYPOINT ["java", "-jar", "targsoft-app.jar"]