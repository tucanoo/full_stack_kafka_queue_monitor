package com.tucanoo.kafka_monitor_api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class KafkaMonitorApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(KafkaMonitorApiApplication.class, args);
    }

}
