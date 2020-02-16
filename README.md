# java-demo-testcontainers-jpql-criteria-querydsl-with-custom-image

Project based one **java-demo-testcontainers-jpql-criteria-querydsl** but using Docker files to work with customize image

Original project: [java-demo-testcontainers-jpql-criteria-querydsl](https://github.com/acsdev/java-demo-testcontainers-jpql-criteria-querydsl)

In the src/config directory of project-test-container module there are to sub dirs:
- oracle
    - files to create a oracle container with previous data
- payara
    - files to create a payara container with application to test and **ojdbc7.jar** to provide database connection
    

### Running
After run tests on **project-test-container** is necessary to run "mvn clean compile package" in **project-main** to generate war file in **src/config/payara/war**.