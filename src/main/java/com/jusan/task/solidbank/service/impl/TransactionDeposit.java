package com.jusan.task.solidbank.service.impl;

import com.jusan.task.solidbank.repository.TransactionRepository;
import com.jusan.task.solidbank.service.AccountDepositService;
import com.jusan.task.solidbank.model.entities.Account;
import com.jusan.task.solidbank.model.entities.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionDeposit {
    private AccountDepositService accountDepositService;
    private TransactionRepository transactionRepository;

    @Autowired
    public TransactionDeposit(AccountDepositService accountDepositService,
                              TransactionRepository transactionRepository) {
        this.accountDepositService = accountDepositService;
        this.transactionRepository = transactionRepository;
    }

    public void execute(Account account, double amount) {
        accountDepositService.deposit(amount, account);
        Transaction transaction = Transaction.builder()
                .accountId(account.getId())
                .amount(amount)
                .build();
        transactionRepository.save(transaction);
    }
}
