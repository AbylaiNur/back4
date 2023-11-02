package com.jusan.task.solidbank.model.entities;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
@Builder
public class Transaction {
    private @Id String id;
    private String accountId;
    private double amount;
}
