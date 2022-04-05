FROM adoptopenjdk/openjdk11:alpine-jre
ARG JAR_FILE=target/ms-wallet-holder-*-SNAPSHOT.jar
COPY ${JAR_FILE} ms-wallet-holder.jar
RUN addgroup -S bootcampgroup && adduser -S bootcampuser -G bootcampgroup
RUN mkdir -p /opt/logs/ms-wallet-holder
RUN chown -R bootcampuser:bootcampgroup /opt/logs/ms-wallet-holder
USER bootcampuser:bootcampgroup
ENTRYPOINT ["java", "-jar", "/ms-wallet-holder.jar"]