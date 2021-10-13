FROM egovio/apline-jre:8u121

EXPOSE 8086

COPY /target/pm-calculator.jar /opt/egov/pm-calculator.jar

COPY start.sh /usr/bin/start.sh

RUN chmod +x /usr/bin/start.sh

CMD ["/usr/bin/start.sh"]

