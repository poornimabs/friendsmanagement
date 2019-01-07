#docker run --name fm-containar -e MYSQL_ROOT_PASSWORD=root -e MYSQL_DATABASE=friendsmanagement -e MYSQL_USER=root -e MYSQL_PASSWORD=root -d mysql:5.6
#docker build -t friendmanagement .
#docker run -p 8080:8080 --name friendmanagement --link fm-containar -d friendmanagement
#Docker Hub poornimabs.gs31@gmail.com/CgUser@123 UserName-ipoornimabs

FROM openjdk:8-jdk-alpine
LABEL maintainer="poornimabs.gs31@gmail.com"
VOLUME /tmp
EXPOSE 8080
ARG JAR_FILE=target/friendsmanagement-0.0.1-SNAPSHOT.jar
ADD ${JAR_FILE} friendmanagement.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/friendmanagement.jar"]