##1. Maven clean plugin
    mvn clean package

##2. Create Image:
    docker build -t customer-service-repository:1.0 .
##3. Run Image:
    docker run -d -p 8080:8080 -t customer-service-repository:1.0
##4. List Images:
    docker image ls
##5. Docker tag
    docker tag customer-service-repository:1.0 orgcompany/customer-service-repository:1.0
##6. Docker push to hub
    docker push orgcompany/customer-service-repository:1.0
