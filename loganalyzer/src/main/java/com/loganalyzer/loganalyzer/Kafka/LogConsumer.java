package com.loganalyzer.loganalyzer.Kafka;

import com.loganalyzer.service.LogService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LogConsumer {

    @Autowired
    private LogService logService;

    @KafkaListener(topics = "logs-topic")
    public void consume(String log) {

        logService.processAsync(List.of(log));
    }
}