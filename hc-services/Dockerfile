FROM egovio/apline-jre:8u121

EXPOSE 8079

COPY /target/rainmaker-hc-0.0.2-SNAPSHOT.jar /opt/egov/rainmaker-hc-0.0.2-SNAPSHOT.jar

COPY start.sh /usr/bin/start.sh

RUN chmod +x /usr/bin/start.sh

CMD ["/usr/bin/start.sh"]

