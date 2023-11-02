package com.jusan.task.solidbank.service;

import com.jusan.task.solidbank.model.entities.Account;

public interface AccountDepositService {
    void deposit(double amount, Account account);
}
