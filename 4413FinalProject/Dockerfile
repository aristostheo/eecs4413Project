# Use an official Tomcat base image
FROM tomcat:9.0-jdk11

# Maintainer information
LABEL maintainer="aristos@my.yorku.ca"

# Copy the WAR file to the webapps directory of Tomcat
COPY target/eStore.war /usr/local/tomcat/webapps/

# Expose the Tomcat port
EXPOSE 8080

# Start Tomcat server
CMD ["catalina.sh", "run"]
