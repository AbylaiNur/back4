package com.jusan.task.solidbank.service.impl;

import com.jusan.task.solidbank.repository.AccountRepository;
import com.jusan.task.solidbank.service.AccountCreationService;
import com.jusan.task.solidbank.model.entities.*;
import com.jusan.task.solidbank.model.enums.AccountType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountCreationServiceImpl implements AccountCreationService {
    private AccountRepository accountRepository;

    @Autowired
    public AccountCreationServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public void create(AccountType accountType, long bankID, String clientID, long accountID) {
        Account account;
        String accountNumber = String.format("%03d%06d", bankID, accountID);

        switch (accountType) {
            case SAVINGS:
            case CHECKING:
                account = new Account(accountType, accountNumber, clientID, 0.0, true);
                break;
            case FIXED:
                account = new Account(accountType, accountNumber, clientID, 0.0, false);
                break;
            default:
                throw new IllegalArgumentException("Invalid account type");
        }
        System.out.println(account);
        accountRepository.save(account);
    }
}
