package team.wsfp.project.service;

import team.wsfp.project.domain.Account;

import java.util.List;

public interface AccountService {
    List<Account> findAll();

    Boolean checkAccountByUser(String userName, String password);

    Boolean registerAccount(String userName, String password);

    Boolean havingAccount(String userName);
}
