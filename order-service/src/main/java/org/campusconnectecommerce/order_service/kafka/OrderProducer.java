package org.campusconnectecommerce.order_service.kafka;

import org.apache.kafka.clients.admin.NewTopic;
import org.campusconnectecommerce.base_domains.dto.OrderEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
public class OrderProducer
{
    private static final Logger LOGGER= LoggerFactory.getLogger(OrderProducer.class);
    private NewTopic kafkaTopic;
    private KafkaTemplate<String, OrderEvent> kafkaTemplate;

    public OrderProducer(NewTopic kafkaTopic, KafkaTemplate<String, OrderEvent> kafkaTemplate) {
        this.kafkaTopic = kafkaTopic;
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendmessage(OrderEvent orderEvent)
    {
        LOGGER.info(String.format("Order event => %s",orderEvent.toString()));

        Message<OrderEvent> message= MessageBuilder.withPayload(orderEvent).
                setHeader(KafkaHeaders.TOPIC, kafkaTopic.name()).build();
        kafkaTemplate.send(message);
    }
}
