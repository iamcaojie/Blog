package com.imcaojie.service;

import com.imcaojie.pojo.Account;
import com.imcaojie.pojo.vo.AccountVO;
import com.imcaojie.utils.PagedGrid;

/**
 * @author caojie
 * @className IAccountService
 * @description
 **/
public interface IAccountService {
    AccountVO insert(Account account);

    AccountVO edit(Account account);

    AccountVO getInfo(Account account);

    int getListCount(Account account);

    PagedGrid getList(Account account, int page, int pageSize, String orderBy);
}
