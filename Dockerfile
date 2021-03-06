# Start with a base image containing Java runtime
FROM adoptopenjdk/openjdk11:alpine-jre

# Add Author info
LABEL maintainer="suhyun.p69@gmail.com"

# Add a volume to /tmp
VOLUME /tmp

# Make port 8080 available to the world outside this container
EXPOSE 8080

# The application's jar file
ARG JAR_FILE=target/api-0.0.1-SNAPSHOT.jar

# Add the application's jar to the container
ADD ${JAR_FILE} next-todo-api.jar

# Run the jar file
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/next-todo-api.jar"]

# docker build -t next-todo-api .
# docker run -p 5000:8080 next-todo-api