package com.jusan.task.solidbank.model.entities;

import com.jusan.task.solidbank.model.enums.AccountType;

public class SavingAccount extends AccountWithdraw {
    public SavingAccount(AccountType accountType, String id, String clientId, double balance, boolean withdrawAllowed) {
        super(accountType, id, clientId, balance, withdrawAllowed);
    }
}
