package com.jusan.task.solidbank.cli.impl;

import com.jusan.task.solidbank.model.entities.Account;
import com.jusan.task.solidbank.service.AccountListingService;
import com.jusan.task.solidbank.model.entities.AccountWithdraw;
import com.jusan.task.solidbank.service.impl.TransactionWithdraw;
import com.jusan.task.solidbank.cli.WithdrawDepositOperationCLIUI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TransactionWithdrawCLI {
    private TransactionWithdraw transactionWithdraw;
    private WithdrawDepositOperationCLIUI withdrawDepositOperationCLIUI;
    private AccountListingService accountListing;

    @Autowired
    public TransactionWithdrawCLI(TransactionWithdraw transactionWithdraw,
                                  WithdrawDepositOperationCLIUI withdrawDepositOperationCLIUI,
                                  AccountListingService accountListing) {
        this.transactionWithdraw = transactionWithdraw;
        this.withdrawDepositOperationCLIUI = withdrawDepositOperationCLIUI;
        this.accountListing = accountListing;
    }

    public void withdrawMoney(String clientID) {
        String accountNumber = withdrawDepositOperationCLIUI.requestClientAccountNumber();
        double amount = withdrawDepositOperationCLIUI.requestClientAmount();

        Account accountWithdraw = accountListing.getClientWithdrawAccount(clientID, accountNumber);
        Account account = accountListing.getClientAccount(clientID, accountNumber);

        if (account == null) {
            System.out.println(String.format(
                    "Failed. Account with ID %s not found.", accountNumber));
            return;
        } else if (accountWithdraw == null) {
            System.out.println(String.format(
                    "Failed. Account with ID %s is FIXED. You cannot withdraw money.", accountNumber));
            return;
        } else if (amount <= 0) {
            System.out.println("Failed. Amount must be greater than 0.");
            return;
        } else if (accountWithdraw.getBalance() < amount) {
            System.out.println("Failed. Not enough money.");
            return;
        }

        transactionWithdraw.execute(accountWithdraw, amount);

        System.out.println(String.format(
                "%.2f$ transferred from %s account%n", amount, accountNumber));
    }
}
