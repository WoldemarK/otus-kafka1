package com.example.otuskafka1;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.IntegerSerializer;

public class Ex2Producer {
    public static void main(String[] args) {
        KafkaProducer<Integer, String> producer = new KafkaProducer<>
                (
                        Utils.createProducerConfig(m ->
                                m.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, IntegerSerializer.class)
                        ));

        for (int i = 0; i < 200; i++) {
            Utils.log.info("Send {}", i);

            ProducerRecord<Integer, String> record = new ProducerRecord<>("topic1", i, Integer.toString(i));
            producer.send(record, (metadata, error) ->
                            Utils.log.info("Complete {}", record.key()));
        }

        producer.close();
    }
}
