package com.jusan.task.solidbank.cli.impl;

import com.jusan.task.solidbank.service.AccountListingService;
import com.jusan.task.solidbank.model.entities.Account;
import com.jusan.task.solidbank.service.impl.TransactionDeposit;
import com.jusan.task.solidbank.cli.WithdrawDepositOperationCLIUI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TransactionDepositCLI {
    private TransactionDeposit transactionDeposit;
    private WithdrawDepositOperationCLIUI withdrawDepositOperationCLIUI;
    private AccountListingService accountListing;

    @Autowired
    public TransactionDepositCLI(TransactionDeposit transactionDeposit,
                                 WithdrawDepositOperationCLIUI withdrawDepositOperationCLIUI,
                                 AccountListingService accountListing) {
        this.transactionDeposit = transactionDeposit;
        this.withdrawDepositOperationCLIUI = withdrawDepositOperationCLIUI;
        this.accountListing = accountListing;
    }

    public void depositMoney(String clientID) {
        String accountNumber = withdrawDepositOperationCLIUI.requestClientAccountNumber();
        double amount = withdrawDepositOperationCLIUI.requestClientAmount();

        Account account = accountListing.getClientAccount(clientID, accountNumber);
        if (account == null) {
            System.out.println(String.format(
                    "Failed. Account with ID %s not found.", accountNumber));
            return;
        } else if (amount <= 0) {
            System.out.println("Failed. Amount must be greater than 0.");
            return;
        }

        transactionDeposit.execute(account, amount);

        System.out.println(String.format(
                "%.2f$ transferred to %s account", amount, accountNumber));
    }
}
