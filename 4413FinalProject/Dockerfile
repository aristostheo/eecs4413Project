# Build Stage

# Use an official Tomcat base image
FROM tomcat:9.0-jdk21 AS builder

RUN apt update && apt install maven -y

WORKDIR /app
ADD pom.xml .
ADD src ./src

RUN mvn install

# Runtime Stage
FROM tomcat:9.0.93-jre21

COPY --from=builder /app/target/4413FinalProject-*.war /usr/local/tomcat/webapps/eStore.war

WORKDIR /usr/local/tomcat

EXPOSE 8080

CMD [ "/usr/local/tomcat/bin/catalina.sh", "run"]
