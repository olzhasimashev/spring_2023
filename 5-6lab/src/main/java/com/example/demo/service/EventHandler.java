package com.example.demo.service;

import com.example.demo.domain.event.AccountCreatedEvent;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.event.EventListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.example.demo.config.KafkaProducerConfig;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@Service
@RequiredArgsConstructor
public class EventHandler {

    private final KafkaTemplate<String, String> kafkaTemplate;

//    private final kafkaTemplate1<String,String> kafkaTemplate1;
    private final NewTopic topic1;

    @EventListener
    public void process(AccountCreatedEvent event) {
        Map<String,Integer> typePartition = new HashMap<String,Integer>();
        typePartition.put("Account created",0);
        typePartition.put("Account updated",1);
        typePartition.put("Account deleted",2);
        typePartition.put("Account failed to be deleted",2);
        log.info("event received: " + event);
        kafkaTemplate.send(
                topic1.name(),
                typePartition.get(event.getAggregateObjectType()),
                event.getAggregateObjectId(),
                event.getAggregateObjectType()
        );
    }
}
