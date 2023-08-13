package com.tucanoo.kafka_monitor_api.services;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
public class KafkaProducerService {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    private static final String TOPIC = "my_kafka_topic";
    private static final Logger log = LoggerFactory.getLogger(KafkaProducerService.class);

    @Scheduled(fixedRate = 10000)
    public void sendMessage() {
        String message = "Hello world : the time is " + LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);
        kafkaTemplate.send(TOPIC, message).whenComplete((stringStringSendResult, throwable) -> log.info("Message resut {}", stringStringSendResult));
    }
}
