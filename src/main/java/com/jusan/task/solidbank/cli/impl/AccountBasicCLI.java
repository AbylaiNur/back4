package com.jusan.task.solidbank.cli.impl;

import com.jusan.task.solidbank.cli.CreateAccountOperationUI;
import com.jusan.task.solidbank.model.enums.AccountType;
import com.jusan.task.solidbank.service.AccountListingService;
import com.jusan.task.solidbank.service.impl.BankCore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AccountBasicCLI {
    private CreateAccountOperationUI createAccountOperationUI;
    private BankCore bankCore;
    private AccountListingService accountListingService;

    @Autowired
    public AccountBasicCLI(CreateAccountOperationUI createAccountOperationUI,
                           BankCore bankCore,
                           AccountListingService accountListingService) {
        this.createAccountOperationUI = createAccountOperationUI;
        this.bankCore = bankCore;
        this.accountListingService = accountListingService;
    }

    public void createAccountRequest(String clientID) {
        AccountType accountType = createAccountOperationUI.requestAccountType();
        bankCore.createNewAccount(accountType, clientID);
        System.out.println("Bank account created");
    }

    public void getAccounts(String clientID) {
        System.out.println(accountListingService.getClientAccounts(clientID));
    }
}
