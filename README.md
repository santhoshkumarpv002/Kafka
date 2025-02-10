# Kafka

# Start the ZooKeeper service
$ bin/zookeeper-server-start.sh config/zookeeper.properties

# Start the Kafka broker service
$ bin/kafka-server-start.sh config/server.properties

$ bin/kafka-topics.sh --create --topic quickstart-events --bootstrap-server localhost:9092



$ bin/kafka-console-producer.sh --topic quickstart-events --bootstrap-server localhost:9092



$ bin/kafka-console-consumer.sh --topic quickstart-events --from-beginning --bootstrap-server localhost:9092
