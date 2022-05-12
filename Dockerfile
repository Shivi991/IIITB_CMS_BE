FROM openjdk:11
ADD target/IIITB_CMS_BE-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8050
ENTRYPOINT ["java","-jar","/app.jar"]