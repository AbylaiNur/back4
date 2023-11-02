package com.jusan.task.solidbank.service;

import com.jusan.task.solidbank.model.enums.AccountType;

public interface AccountCreationService {
    void create(AccountType accountType, long bankID, String clientID, long accountID);
}
