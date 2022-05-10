

```java
# Required connection configs for Kafka producer, consumer, and admin
bootstrap.servers=pkc-ymrq7.us-east-2.aws.confluent.cloud:9092
security.protocol=SASL_SSL
sasl.jaas.config=org.apache.kafka.common.security.plain.PlainLoginModule   required username='ABUYVNY36MQUCRFV'   password='wt4EjxrmIbYQPpU4WboDrgEtwL2mJ5HqECxEAoEtQVvJrRnGoZ8FU1k/QaXpDFQ5';
sasl.mechanism=PLAIN
# Required for correctness in Apache Kafka clients prior to 2.6
client.dns.lookup=use_all_dns_ips

# Best practice for higher availability in Apache Kafka clients prior to 3.0
session.timeout.ms=45000

# Best practice for Kafka producer to prevent data loss
acks=all

# Required connection configs for Confluent Cloud Schema Registry
schema.registry.url=https://psrc-q25x7.us-east-2.aws.confluent.cloud
basic.auth.credentials.source=USER_INFO
basic.auth.user.info=ICT3Q2TRNO3E2AS4:3FV82GI9dfF1TAeq9iqkb3o8Xs+b0cZpYSA8wE2Rw0t72kOVOt4v0SO0Bm/Az+Yh

```