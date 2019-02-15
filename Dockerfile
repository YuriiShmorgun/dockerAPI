FROM openjdk:8
COPY ./target /src
WORKDIR /src
#ADD target/spark-api.jar spark-api.jar
EXPOSE 4567
ENTRYPOINT ["java", "-jar", "spark-api.jar"]
