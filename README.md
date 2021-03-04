# kafka-consumer
Spring Boot Application using Kafka Consumer with Zookeeper

*Note: Java 11 is required.

## Zookeeper Setup

1. Download and Unzip Zookeeper.
2. Goto `conf` directory. Then `cp zoo_sample.cfgas zoo.cfg`
3. Optional: Change `dataDir` in the `zoo.cfg`, as default is pointed to `/tmp/data`.

## To start Zookeeper

1. Goto `bin` folder.
2. Execute `./zkServer.sh start`

## To stop Zookeeper

1. Goto `bin` folder.
2. Execute `./zkServer.sh stop`

## Kafka Setup

1. Download and Unzip Kafka.
2. Goto `config` folder and open `server.properties`.
3. Then uncomment `listeners=PLAINTEXT://:9092`. This will allow Kafka broker to listen on port 9092.
4. Optional: Change `log.dirs` in the `server.properties`.
5. Optional: `zookeeper.connect` in `server.properties` defines Zookeeper properties.

## To start Kafka

1. Goto `bin` folder.
2. Execute `./bin/kafka-server-start.sh config/server.properties`

## To stop Kafka

1. Goto `bin` folder.
2. Execute `./bin/kafka-server-stop.sh`

## To run Consumer

execute `./gradlew bootRun` 

*Consumer works with 