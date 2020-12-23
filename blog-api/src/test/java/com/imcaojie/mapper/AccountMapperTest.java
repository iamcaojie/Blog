package com.imcaojie.mapper;

import com.imcaojie.BaseTest;
import com.imcaojie.pojo.Account;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author caojie
 * @className AccountMapperTest
 * @description
 **/
public class AccountMapperTest extends BaseTest {

    @Autowired
    private AccountMapper accountMapper;

    @Test
    public void testSelectOne(){
        Account account = accountMapper.selectByPrimaryKey(1L);
        System.out.println(account);
    }

}
