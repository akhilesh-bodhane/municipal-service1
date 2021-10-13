const kafka = require("kafka-node");
import envVariables from "../envVariables";

import logger from "../config/logger";

const Consumer = kafka.Consumer;
let client = new kafka.KafkaClient({
  kafkaHost: envVariables.KAFKA_BROKER_HOST
});

const consumer = new Consumer(client, [{ topic: "SMS", offset: 0 }], {
  autoCommit: false
});

consumer.on("message", function(message) {
  logger.debug(message.value);
});

consumer.on("error", function(err) {
  logger.error("Error:", err);
});

consumer.on("offsetOutOfRange", function(err) {
  logger.error("offsetOutOfRange:", err);
});
