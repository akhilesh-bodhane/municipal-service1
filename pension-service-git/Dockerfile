FROM node:10.19.0-slim
#LABEL maintainer="badri.nath.pathak@pwc.com"
#RUN useradd -m sunbird
#USER sunbird
RUN mkdir -p /home/pension-services
COPY . /home/pension-services/
WORKDIR /home/pension-services
RUN npm install

RUN npm run -s build

#RUN chmod +x /home/sunbird/mw/omr/src/start.sh
CMD ["npm","start" , "&"]