FROM quay.io/wildfly/wildfly:latest-jdk17
COPY target/jakartaee-hello-world.war /opt/jboss/wildfly/standalone/deployments/
