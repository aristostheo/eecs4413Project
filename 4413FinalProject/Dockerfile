# Build Stage

# Use an official Tomcat base image
FROM tomcat:9.0-jdk21 as builder

RUN apt update && apt install maven -y

WORKDIR /app
ADD pom.xml .
ADD src ./src

RUN mvn install

# Runtime Stage
FROM tomcat:9.0.93-jre21

COPY --from=builder /app/target/4413FinalProject-1.0.0.war /usr/local/tomcat/webapps/eStore.war
