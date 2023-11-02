package com.jusan.task.solidbank.service.impl;

import com.jusan.task.solidbank.model.entities.Account;
import com.jusan.task.solidbank.repository.AccountRepository;
import com.jusan.task.solidbank.service.AccountWithdrawService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountWithdrawServiceImpl implements AccountWithdrawService {
    private AccountRepository accountRepository;

    @Autowired
    public AccountWithdrawServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public void withdraw(double amount, Account account) {
        account.setBalance(account.getBalance() - amount);
        accountRepository.save(account);
    }
}
