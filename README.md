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


## Native Docker Build / Deployment



## Native Kubernetes Deployment

(Optionally) Update the image location in deployment manifest
```
kubectl apply -f ./kubernetes/spring-csv-deploy-working.yaml 
kubectl get po -w
kubectl apply -f ./kubernetes/spring-csv-service-working.yaml 
kubectl get svc
```




## TPK8s Deployment
To deploy in a TPK8s Space
NOTE: This will compile the java application, build the docker image, create Kubernetes packages and a ContainerApp and HTTPRoute to run the application in a Space.
```
tanzu project use
  # Choose your project
tanzu space use
  # Choose your Space
tanzu app init
  # Follow the prompts. Use defaults to create an HTTPRoute
  # This ends up creating an HTTPRoute and Containerapp YAML files in the .tanzu/config folder.
  # Now just make sure that the entrypoint in the .tanzu/config/httproute-<app-name>.yaml file is identical to the value you configured in the Spaces Domain Binding Advanced Configuration.
tanzu build config --containerapp-registry harbor.mbentley.net/tkraus/spring-api-csv
tanzu app config build non-secret-env set BP_JVM_VERSION=17                            
    # This ends up updating our containerapp YAML - spring-api-csv.yml in the .tanzu/config folder. 
tanzu deploy -y

```

