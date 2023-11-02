package com.jusan.task.solidbank.service.impl;

import com.jusan.task.solidbank.repository.AccountRepository;
import com.jusan.task.solidbank.service.AccountListingService;
import com.jusan.task.solidbank.model.entities.Account;
import com.jusan.task.solidbank.model.enums.AccountType;
import com.jusan.task.solidbank.model.entities.AccountWithdraw;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountListingServiceImpl implements AccountListingService {

    private AccountRepository accountRepository;

    @Autowired
    public AccountListingServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public Account getClientAccount(String clientID, String accountID) {
        return accountRepository.findAccountByClientIdAndId(clientID, accountID);
    }

    @Override
    public Account getClientWithdrawAccount(String clientID, String accountID) {
        Account account = accountRepository.findByClientIdAndIdAndWithdrawAllowedTrue(clientID, accountID);
        return account;
    }

    @Override
    public List<Account> getClientAccounts(String clientID) {
        return accountRepository.findAccountsByClientId(clientID);
    }

    @Override
    public List<Account> getClientAccountsByType(String clientID, AccountType accountType) {
        return accountRepository.findAllByClientIdAndAccountType(clientID, accountType);
    }
}
