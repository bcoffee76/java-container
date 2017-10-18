FROM openjdk:8
COPY ./restprj-1.jar /usr/src/myapp/
WORKDIR /usr/src/myapp
EXPOSE 8080
CMD java -XX:+UnlockExperimentalVMOptions -XX:+UseCGroupMemoryLimitForHeap -jar restprj-1.jar