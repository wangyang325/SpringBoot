package wangyang.kafka;

import org.apache.kafka.clients.producer.Callback;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.apache.kafka.common.header.Header;

public class Producer {
    public static void main(String[] args) {
        while (true) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            // Create producer
            org.apache.kafka.clients.producer.Producer<String, String> producer = ProducerCreator.createProducer();
            // prepare data
            ProducerRecord<String, String> producerRecord = new ProducerRecord<String, String>(ProducerCreator.TOPIC_NAME, "hello world");

            producer.send(producerRecord, new Callback() {
                @Override
                public void onCompletion(RecordMetadata recordMetadata, Exception e) {
                    System.out.println("Send Ok partition: " + recordMetadata.partition());
                }
            });

            producer.close();
        }
    }
}
