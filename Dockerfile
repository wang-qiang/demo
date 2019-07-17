FROM openjdk:8-jdk-alpine
VOLUME /tmp
COPY target/dependency/BOOT-INF/lib /app/lib
COPY target/dependency/META-INF /app/META-INF
COPY target/classes /app
ENTRYPOINT ["java","-cp","app:app/lib/*","com.wq.demo.DemoApplication"]