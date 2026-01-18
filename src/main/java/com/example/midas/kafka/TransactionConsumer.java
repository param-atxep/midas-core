package com.example.midas.kafka;

import com.example.midas.model.Transaction;
import com.example.midas.service.TransactionService;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class TransactionConsumer {

    private final TransactionService service;

    public TransactionConsumer(TransactionService service) {
        this.service = service;
    }

    @KafkaListener(topics = "transactions", groupId = "midas-group")
    public void consume(Transaction transaction) {
        service.save(transaction);
    }
}
