package com.jusan.task.solidbank.service.impl;

import com.jusan.task.solidbank.repository.AccountRepository;
import com.jusan.task.solidbank.service.AccountDepositService;
import com.jusan.task.solidbank.model.entities.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountDepositServiceImpl implements AccountDepositService {
    private AccountRepository accountRepository;

    @Autowired
    public AccountDepositServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }
    @Override
    public void deposit(double amount, Account account) {
        account.setBalance(account.getBalance() + amount);
        accountRepository.save(account);
    }
}
