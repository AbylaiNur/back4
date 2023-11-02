package com.jusan.task.solidbank.service.impl;

import com.jusan.task.solidbank.model.entities.Account;
import com.jusan.task.solidbank.repository.TransactionRepository;
import com.jusan.task.solidbank.service.AccountWithdrawService;
import com.jusan.task.solidbank.model.entities.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionWithdraw {
    private AccountWithdrawService accountWithdrawService;
    private TransactionRepository transactionRepository;

    @Autowired
    public TransactionWithdraw(AccountWithdrawService accountWithdrawService,
                               TransactionRepository transactionRepository) {
        this.accountWithdrawService = accountWithdrawService;
        this.transactionRepository = transactionRepository;
    }

    public void execute(Account accountWithdraw, double amount) {
        accountWithdrawService.withdraw(amount, accountWithdraw);
        Transaction transaction = Transaction.builder()
                .accountId(accountWithdraw.getId())
                .amount(amount)
                .build();
        transactionRepository.save(transaction);
    }
}
