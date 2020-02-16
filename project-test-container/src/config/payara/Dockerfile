FROM payara/micro:latest

RUN mkdir -p /opt/payara/libs

COPY jar/ojdbc7.jar /opt/payara/libs/ojdbc7.jar

COPY war/project-main.war /opt/payara/deployments/project-main.war

EXPOSE 8080 8443 6900

ENTRYPOINT ["java","-jar", "/opt/payara/payara-micro.jar", "--addJars", "/opt/payara/libs/ojdbc7.jar", "--deploymentDir", "/opt/payara/deployments"]
