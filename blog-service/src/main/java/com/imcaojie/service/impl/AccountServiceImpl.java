package com.imcaojie.service.impl;

import com.imcaojie.mapper.AccountMapper;
import com.imcaojie.pojo.Account;
import com.imcaojie.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author caojie
 * @className AccountService
 * @description
 **/
@Service
public class AccountServiceImpl implements IAccountService {

    @Autowired
    private AccountMapper accountMapper;

    @Override
    public Account getInfo() {
        return accountMapper.selectByPrimaryKey(1L);
    }
}
