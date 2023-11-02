package com.jusan.task.solidbank.model.entities;

import com.jusan.task.solidbank.model.enums.AccountType;
import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class Account {
    @Id
    private Long __id;
    private AccountType accountType;
    private String id;
    private String clientId;
    private double balance;
    private boolean withdrawAllowed;

    public Account(AccountType accountType, String id, String clientId, double balance, boolean withdrawAllowed) {
        this.accountType = accountType;
        this.id = id;
        this.clientId = clientId;
        this.balance = balance;
        this.withdrawAllowed = withdrawAllowed;
    }

    @Override
    public String toString() {
        return "Account{" +
                "accountType=" + accountType +
                ", id='" + id + '\'' +
                ", clientId='" + clientId + '\'' +
                ", balance=" + balance +
                ", withdrawAllowed=" + withdrawAllowed +
                '}';
    }
}
