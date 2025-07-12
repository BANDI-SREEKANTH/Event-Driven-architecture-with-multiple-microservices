package org.campusconnectecommerce.order_service.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfig {
    private static final Logger LOGGER= LoggerFactory.getLogger(KafkaTopicConfig.class);
    @Value("${spring.kafka.topic.name}")
    private String topic_name;

    // spring bean for kafka template
    @Bean
    public NewTopic topic()
    {
        //return TopicBuilder.name(topic_name).partitions(5).build();
        LOGGER.info(String.format("Kafka Topic created : %s",topic_name));
        return TopicBuilder.name(topic_name).build();

    }
}
