package com.jusan.task.solidbank.repository;

import com.jusan.task.solidbank.model.entities.Transaction;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends CrudRepository<Transaction, String> {
}
