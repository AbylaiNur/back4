package com.jusan.task.solidbank.model.entities;

import com.jusan.task.solidbank.model.enums.AccountType;

public class AccountWithdraw extends Account {
    public AccountWithdraw(AccountType accountType, String id, String clientId, double balance, boolean withdrawAllowed) {
        super(accountType, id, clientId, balance, withdrawAllowed);
    }
}
