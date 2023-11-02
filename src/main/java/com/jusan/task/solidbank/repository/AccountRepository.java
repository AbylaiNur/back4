package com.jusan.task.solidbank.repository;

import com.jusan.task.solidbank.model.entities.Account;
import com.jusan.task.solidbank.model.enums.AccountType;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountRepository extends CrudRepository<Account, Long> {
    Account findAccountByClientIdAndId(String clientID, String id);
    Account findByClientIdAndIdAndWithdrawAllowedTrue(String clientID, String accountID);
    List<Account> findAccountsByClientId(String clientID);
    List<Account> findAllByClientIdAndAccountType(String clientID, AccountType accountType);
}
