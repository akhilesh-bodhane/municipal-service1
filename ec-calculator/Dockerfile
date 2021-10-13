FROM egovio/apline-jre:8u121

EXPOSE 8086

COPY /target/ec-calculator.jar /opt/egov/ec-calculator.jar

COPY start.sh /usr/bin/start.sh

RUN chmod +x /usr/bin/start.sh

CMD ["/usr/bin/start.sh"]

