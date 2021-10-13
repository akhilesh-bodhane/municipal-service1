FROM egovio/apline-jre:8u121

EXPOSE 9004

COPY /target/pm-refund-services-0.0.1-SNAPSHOT.jar /opt/egov/pm-refund-services-0.0.1-SNAPSHOT.jar

COPY start.sh /usr/bin/start.sh

RUN chmod +x /usr/bin/start.sh

CMD ["/usr/bin/start.sh"]

