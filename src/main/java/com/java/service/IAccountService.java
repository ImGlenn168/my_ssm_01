package com.java.service;

import com.java.domain.Account;

import java.util.List;

public interface IAccountService {

    List<Account> findAll();

    boolean addAccount(Account account);
}
