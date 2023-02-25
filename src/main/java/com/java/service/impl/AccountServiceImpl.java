package com.java.service.impl;

import com.java.dao.IAccountDao;
import com.java.domain.Account;
import com.java.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("accountService")
public class AccountServiceImpl implements IAccountService {

    @Autowired
    private IAccountDao iAccountDao;

    @Override
    public List<Account> findAll() {
        System.out.println("Service业务层：查询所有账户...");
        return iAccountDao.findAll();
    }

    @Override
    public boolean addAccount(Account account) {
        System.out.println("Service业务层：保存帐户...");
        return iAccountDao.addAccount(account)>0;
    }
}
