package com.jusan.task.solidbank.service;

import com.jusan.task.solidbank.model.entities.Account;

public interface AccountWithdrawService {
    void withdraw(double amount, Account account);
}
