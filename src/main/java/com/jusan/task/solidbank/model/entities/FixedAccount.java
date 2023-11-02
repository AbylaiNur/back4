package com.jusan.task.solidbank.model.entities;

import com.jusan.task.solidbank.model.enums.AccountType;

public class FixedAccount extends AccountDeposit {
    public FixedAccount(AccountType accountType, String id, String clientId, double balance, boolean withdrawAllowed) {
        super(accountType, id, clientId, balance, withdrawAllowed);
    }
}
