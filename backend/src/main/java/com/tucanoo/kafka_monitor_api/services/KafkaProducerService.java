package com.tucanoo.kafka_monitor_api.services;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
@Slf4j
public class KafkaProducerService {
    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    private static final String TOPIC = "my_kafka_topic";

    @Scheduled(fixedRate = 10000)
    public void sendMessage() {
        String message = "Hello world : the time is " + LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);
        kafkaTemplate.send(TOPIC, message).whenComplete((stringStringSendResult, throwable) -> log.info("Message resut {}", stringStringSendResult));
    }
}
