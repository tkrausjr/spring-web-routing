# spring-web-routing

Simple Spring Boot Web Application that will access a CSV file and make it available at /display-csv  for viewing and /download-csv for downloading.

Make sure port 8080 is open on your machine.

To run with Maven.
```
git clone https://github.com/tkrausjr/spring-web-routing.git
cd spring-web-routing
./mvnw spring-boot:run

```

To open and run in VSCode,
```
code .
OPEN the Spring Boot Dashboard and select the "webtk" APP. Click the RUN Arrow button.
```

To test the application access it on port 8080 at localhost

  - http://localhost:8080/actuator
  - http://localhost:8080/display-csv
  - http://localhost:8080/download-csv
  - 
