package com.jusan.task.solidbank.service.impl;

import com.jusan.task.solidbank.service.AccountCreationService;
import com.jusan.task.solidbank.model.enums.AccountType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BankCore {
    private static long id = 1;
    private long lastAccountNumber = 1;
    private AccountCreationService accountCreationService;

    @Autowired
    public BankCore(AccountCreationService accountCreationService) {
        this.accountCreationService = accountCreationService;
    }

    public void createNewAccount(AccountType accountType, String clientID) {
        accountCreationService.create(accountType, id, clientID, lastAccountNumber);
        incrementLastAccountNumber();
    }

    private void incrementLastAccountNumber() {
        lastAccountNumber++;
    }
}
