FROM egovio/apline-jre:8u121

EXPOSE 8009

COPY /target/temporarystall-services-0.0.1-SNAPSHOT.jar /opt/egov/temporarystall-services.jar

COPY start.sh /usr/bin/start.sh

RUN chmod +x /usr/bin/start.sh

CMD ["/usr/bin/start.sh"]

