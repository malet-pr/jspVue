FROM tomcat:10.0-jre11

# Remove the default Tomcat apps
RUN rm -rf /usr/local/tomcat/webapps/*

# Copy your Jakarta EE application WAR file to the Tomcat webapps directory
COPY mock.war /usr/local/tomcat/webapps/ROOT.war

EXPOSE 8080

CMD ["catalina.sh", "run"]

