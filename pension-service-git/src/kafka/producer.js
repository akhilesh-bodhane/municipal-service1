var kafka = require("kafka-node");
import envVariables from "../envVariables";
import logger from "../config/logger";



const Producer = kafka.Producer;
let client;

if (process.env.NODE_ENV === "development") {
  client = new kafka.Client();
  logger.debug("local - ");
} else {
  client = new kafka.KafkaClient({ kafkaHost: envVariables.KAFKA_BROKER_HOST });
  logger.debug("cloud - ");
}


const producer = new Producer(client);

producer.on("ready", function() {
  logger.debug("Producer is ready");
});

producer.on("error", function(err) {
  logger.error("Producer is in error state");
  logger.error(err);
});

export default producer;
