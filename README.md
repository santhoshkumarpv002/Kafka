# Kafka

# GroupId used to group the consumer



# Start the ZooKeeper service
$ bin/zookeeper-server-start.sh config/zookeeper.properties

# Start the Kafka broker service
$ bin/kafka-server-start.sh config/server.properties

$ bin/kafka-topics.sh --create --topic quickstart-events --bootstrap-server localhost:9092



$ bin/kafka-console-producer.sh --topic quickstart-events --bootstrap-server localhost:9092



$ bin/kafka-console-consumer.sh --topic quickstart-events --from-beginning --bootstrap-server localhost:9092


# we can only send data as byte[] serilization/de  - convert object into byte stream


spring.application.name=helloworld

# Config for consumer
spring.kafka.consumer.bootstrap-servers=localhost:9092
spring.kafka.consumer.group-id=mygroup
# --from-beginning consume all data from producer even though it started mid
spring.kafka.consumer.auto-offset-reset=earliest   
spring.kafka.consumer.key-deserializer=org.apache.kafka.common.serialization.StringDeserializer
spring.kafka.consumer.value-deserializer=org.springframework.kafka.support.serializer.JsonDeserializer
spring.kafka.consumer.properties.spring.json.trusted.packages=*

# Config for producer
spring.kafka.producer.bootstrap-servers=localhost:9092
spring.kafka.producer.key-serializer=org.apache.kafka.common.serialization.StringSerializer
spring.kafka.producer.value-serializer=org.springframework.kafka.support.serializer.JsonSerializer


