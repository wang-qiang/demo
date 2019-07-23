FROM openjdk:8-jdk-alpine
VOLUME /tmp
COPY target/classes /app
COPY target/dependency/BOOT-INF/lib /app/lib
COPY target/dependency/META-INF /app/META-INF
COPY dumb-init /app/dumb-init
COPY startup.sh /app/startup.sh

# RUN wget -O /app/dumb-init https://github.com/Yelp/dumb-init/releases/download/v1.2.2/dumb-init_1.2.2_amd64
RUN chmod 755 /app/dumb-init
RUN chmod 755 /app/startup.sh

ENTRYPOINT ["/app/dumb-init", "--"]
CMD ["/app/startup.sh"]