package com.imcaojie.service.impl;

import com.github.pagehelper.PageHelper;
import com.imcaojie.exception.DataBaseException;
import com.imcaojie.exception.DataNotFoundException;
import com.imcaojie.mapper.AccountMapper;
import com.imcaojie.pojo.Account;
import com.imcaojie.pojo.AccountExample;
import com.imcaojie.pojo.vo.AccountVO;
import com.imcaojie.service.BaseService;
import com.imcaojie.service.IAccountService;
import com.imcaojie.utils.PagedGrid;
import com.imcaojie.utils.SnowFlake;
import lombok.extern.slf4j.Slf4j;
import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author caojie
 * @className AccountService
 * @description
 **/
@Service
@Slf4j
public class AccountServiceImpl extends BaseService implements IAccountService {

    @Autowired
    private SnowFlake snowFlake;

    @Autowired
    private AccountMapper accountMapper;

    private Long setInsertDefault(Account account){
        Long id = snowFlake.nextId();
        account.setId(id);
        account.setUnionId("");
        account.setIsDeleted(0);
        account.setStatus(1);
        account.setCreatedTime(new Date());
        account.setUpdatedTime(new Date());
        return id;
    }

    private void setUpdateDefault(Account account, Account target){
        if(account.getName()!= null){
            target.setName(account.getName());
        }
        if(account.getPhone()!= null){
            target.setPhone(account.getPhone());
        }
        account.setUpdatedTime(new Date());
    }

    private void setQueryDefault(Account account, AccountExample.Criteria criteria){
        if(account.getId()!= null){
            criteria.andIdEqualTo(account.getId());
        }
        if(account.getName()!= null){
            criteria.andNameEqualTo(account.getName());
        }
        if(account.getPhone()!= null){
            criteria.andPhoneEqualTo(account.getPhone());
        }
    }

    private AccountVO formatAccountData(Account account){
        AccountVO accountVo = new AccountVO();
        BeanUtils.copyProperties(account, accountVo);
        if(account.getStatus() != null){
            accountVo.setStatusDesc("正常");
        }
        return accountVo;
    }

    private Account info(Account account){
        log.info(account.toString());
        AccountExample accountExample = new AccountExample();
        AccountExample.Criteria criteria = accountExample.createCriteria();
        setQueryDefault(account, criteria);
        PageHelper.startPage(1,1);
        List<Account> accounts = accountMapper.selectByExample(accountExample);
        if(accounts.size() < 1){
            throw new DataNotFoundException("账户不存在");
        }
        return accounts.get(0);
    }

    @Override
    @Transactional
    public AccountVO insert(Account account) {
        Long id = setInsertDefault(account);
        int insert = accountMapper.insert(account);
        if(insert != 1){
            throw new DataBaseException("保存账户失败");
        }
        Account accountResult = accountMapper.selectByPrimaryKey(id);
        if(null == accountResult){
            throw new DataBaseException("保存账户失败");
        }
        return formatAccountData(accountResult);
    }

    @Override
    @Transactional
    public AccountVO edit(Account account) {
        // 是否存在
        Account accountPrimaryKey = new Account();
        accountPrimaryKey.setId(account.getId());
        Account accountExist = this.info(accountPrimaryKey);
        setUpdateDefault(account,accountExist);
        int update = accountMapper.updateByPrimaryKey(accountExist);
        if(update != 1){
            throw new DataBaseException("更新账户失败");
        }
        Account accountResult = accountMapper.selectByPrimaryKey(account.getId());
        if(null == accountResult){
            throw new DataBaseException("账户查询失败");
        }
        return formatAccountData(accountResult);
    }

    @Override
    public AccountVO getInfo(Account account) {
        Account accountResult = this.info(account);
        return formatAccountData(accountResult);
    }

    @Override
    public int getListCount(Account account) {
        AccountExample accountExample = new AccountExample();
        AccountExample.Criteria criteria = accountExample.createCriteria();
        criteria.andIdEqualTo(account.getId());
        criteria.andNameEqualTo(account.getName());
        return accountMapper.countByExample(accountExample);
    }

    @Override
    public PagedGrid getList(Account account, int page, int pageSize, String orderBy) {
        AccountExample accountExample = new AccountExample();
        AccountExample.Criteria criteria = accountExample.createCriteria();
        setQueryDefault(account,criteria);
        PageHelper.startPage(page,pageSize);
        List<Account> accounts = accountMapper.selectByExample(accountExample);
        List<AccountVO> accountVoS = new ArrayList<>();
        for(Account accountInfo :accounts){
            accountVoS.add(formatAccountData(accountInfo));
        }
        return setPagedGrid(accountVoS, page, pageSize);
    }
}
