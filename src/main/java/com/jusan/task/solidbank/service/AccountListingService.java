package com.jusan.task.solidbank.service;

import com.jusan.task.solidbank.model.entities.Account;
import com.jusan.task.solidbank.model.enums.AccountType;
import com.jusan.task.solidbank.model.entities.AccountWithdraw;

import java.util.List;

public interface AccountListingService {
    Account getClientAccount(String clientID, String accountID);
    // Spring Data JDBC не поддерживает наследование. Поэтому решил убрать AccountWithdraw
    Account getClientWithdrawAccount(String clientID, String accountID);
    List<Account> getClientAccounts(String clientID);
    List<Account> getClientAccountsByType(String clientID, AccountType accountType);
}
