package com.example.midas.service;

import com.example.midas.model.Transaction;
import com.example.midas.repository.TransactionRepository;
import org.springframework.stereotype.Service;

@Service
public class TransactionService {

    private final TransactionRepository repository;

    public TransactionService(TransactionRepository repository) {
        this.repository = repository;
    }

    public Transaction save(Transaction transaction) {
        transaction.setStatus("PROCESSED");
        return repository.save(transaction);
    }
}
