package kafka;

import org.apache.kafka.clients.consumer.*;
import org.apache.kafka.clients.producer.*;
import org.apache.kafka.common.serialization.LongDeserializer;
import org.apache.kafka.common.serialization.LongSerializer;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.apache.kafka.common.serialization.StringSerializer;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.ExecutionException;

public class KafkaTest {

    public static Producer<Long, String> createProducer() {
        Properties props = new Properties();
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, IKafkaConstants.KAFKA_BROKERS);
        props.put(ProducerConfig.CLIENT_ID_CONFIG, IKafkaConstants.CLIENT_ID);
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, LongSerializer.class.getName());
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        List<String> list = new ArrayList<>();
        list.add(kafka.AvgLatencyProducerInterceptor.class.getCanonicalName());
        props.put(ProducerConfig.INTERCEPTOR_CLASSES_CONFIG,list);
        //props.put(ProducerConfig.PARTITIONER_CLASS_CONFIG, CustomPartitioner.class.getName());
        return new KafkaProducer<>(props);
    }

    public static Consumer<Long, String> createConsumer() {
        Properties props = new Properties();
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, IKafkaConstants.KAFKA_BROKERS);
        props.put(ConsumerConfig.GROUP_ID_CONFIG, IKafkaConstants.GROUP_ID_CONFIG);
        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, LongDeserializer.class.getName());
        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        props.put(ConsumerConfig.MAX_POLL_RECORDS_CONFIG, IKafkaConstants.MAX_POLL_RECORDS);
        props.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, "false");
        props.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, IKafkaConstants.OFFSET_RESET_EARLIER);

        Consumer<Long, String> consumer = new KafkaConsumer<>(props);
        consumer.subscribe(Collections.singletonList(IKafkaConstants.TOPIC_NAME));
        return consumer;
    }

    public static void producerTest() {
        Producer<Long,String> producer = KafkaTest.createProducer();

        for (int i = 0; i < IKafkaConstants.MESSAGE_COUNT; i++) {
            ProducerRecord producerRecord = new ProducerRecord<Long,String>(IKafkaConstants.TOPIC_NAME,"This is Record " + i );
            try {
                RecordMetadata metadata = (RecordMetadata) producer.send(producerRecord).get();
                System.out.println("Record sent with key " + i + " to partition " + metadata.partition()
                        + " with offset " + metadata.offset());
            }catch (Exception e){
                System.out.println("Error in sending record");
                System.out.println(e);
            }
        }
    }


    public static void runConsumer(){
        Consumer<Long, String> consumer = KafkaTest.createConsumer();
        int noMessageFound = 0;
        while (true){
            ConsumerRecords<Long,String> consumerRecord = consumer.poll(Duration.ofMillis(1000));
            if (consumerRecord.count() == 0) {
                noMessageFound++;
                if (noMessageFound > IKafkaConstants.MAX_NO_MESSAGE_FOUND_COUNT)
                    // If no message found count is reached to threshold exit loop.
                    break;
                else
                    continue;
            }
            consumerRecord.forEach(record -> {
                System.out.println("Record Key " + record.key() + "---Record value " + record.value() + "---Record partition " + record.partition() + "---Record offset " + record.offset());
            });
            consumer.commitAsync();
        }
        consumer.close();
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(()->{
            producerTest();
        });

        Thread t2 = new Thread(()->{
            runConsumer();
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();
        System.out.println("主线程结束");

    }
}
