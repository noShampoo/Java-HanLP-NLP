package team.wsfp.project.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import team.wsfp.project.dao.AccountDao;
import team.wsfp.project.domain.Account;
import team.wsfp.project.service.AccountService;
import team.wsfp.project.utils.GenerateUserID;

import java.util.ArrayList;
import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {
    private static Account nowAccount;

    public static Account getNowAccount() {
        return nowAccount;
    }

    @Autowired
    private AccountDao accountDao;

    @Override
    public List<Account> findAll() {
        return accountDao.findAll();
    }

    @Override
    public Boolean checkAccountByUser(String userName, String password) {
        Account account = accountDao.findAccountByUser(userName);
        System.out.println(account.toString());
        if (account != null) {
            if (account.getPassword().equals(password)) {
                nowAccount = accountDao.findAccountByUser(userName);
//                System.out.println("333");
                return true;
            } else {
//                System.out.println("111");
                return false;
            }
        }
//        System.out.println("222");
        return false;
    }

    @Override
    public Boolean registerAccount(String userName, String password) {
        Account account = new Account();
        account.setUserName(userName);
        account.setPassword(password);
        account.setUserId(GenerateUserID.generateUUID());
//        System.out.println(account.toString());
        try {
            accountDao.insertAccount(account);
            return true;
        } catch (Exception e) {
//            System.out.println("exception");
            return false;
        }
    }

    @Override
    public Boolean havingAccount(String userName) {
        if (!accountDao.findAlluserName().isEmpty()) {
            List<String> list = accountDao.findAlluserName();
            return list.contains(userName);
        } else return false;
    }

}
