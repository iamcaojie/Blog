package com.imcaojie.controller;

import com.imcaojie.pojo.Account;
import com.imcaojie.pojo.bo.AccountCreateBO;
import com.imcaojie.pojo.bo.AccountUpdateBO;
import com.imcaojie.pojo.vo.AccountVO;
import com.imcaojie.pojo.vo.ResponseVO;
import com.imcaojie.service.IAccountService;
import com.imcaojie.utils.PagedGrid;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @author caojie
 * @className AccountController
 * @description
 **/
@Api(value = "账户", tags = {"账户"})
@RestController
@RequestMapping("/account")
@Slf4j
public class AccountController extends BaseController {

    @Autowired
    private IAccountService accountService;

    @ApiOperation("创建账户")
    @PostMapping("/create")
    public ResponseVO<AccountVO> create(
            @RequestBody @Valid AccountCreateBO accountCreateBO,
            BindingResult bindingResult
    ){
        throwError(bindingResult);
        Account account = new Account();
        account.setName(accountCreateBO.getName());
        account.setPhone(accountCreateBO.getPhone());
        AccountVO accountVO = accountService.insert(account);
        return new ResponseVO<>(accountVO);
    }

    @ApiOperation("编辑账户")
    @PostMapping("/edit")
    public ResponseVO<AccountVO> edit(
            @RequestBody @Valid AccountUpdateBO accountUpdateBO,
            BindingResult bindingResult
    ){
        throwError(bindingResult);
        Account account = new Account();
        account.setId(accountUpdateBO.getId());
        account.setName(accountUpdateBO.getName());
        account.setPhone(accountUpdateBO.getPhone());
        AccountVO accountVO = accountService.edit(account);
        return new ResponseVO<>(accountVO);
    }

    @ApiOperation("获取账户详情")
    @GetMapping("/info")
    public ResponseVO<AccountVO> getInfo(
            @RequestParam("id") Long id
    ){
        Account account = new Account();
        account.setId(id);
        AccountVO accountVO = accountService.getInfo(account);
        return new ResponseVO<>(accountVO);
    }

    @ApiOperation("获取账户列表")
    @GetMapping("/list")
    public ResponseVO<PagedGrid> getList(
            @ApiParam(name="id",value = "账户id",defaultValue = "",required = false)
            @RequestParam(value = "id",required = false) Long id,

            @ApiParam(name="name",value = "",defaultValue = "",required = false)
            @RequestParam(value = "name",required = false) String name,

            @ApiParam(name="page",value = "页码",defaultValue = "1",required = false)
            @RequestParam(value = "page",required = false,defaultValue = "1") Integer page,

            @ApiParam(name="",value = "每页数量",defaultValue = "10",required = false)
            @RequestParam(value = "pageSize",required = false, defaultValue = "10") Integer pageSize
    ){
        Account account = new Account();
        account.setId(id);
        account.setName(name);
        PagedGrid pagedGrid = accountService.getList(account, page, pageSize, "id");
        return new ResponseVO<>(pagedGrid);
    }

    @ApiOperation("删除账户")
    @PostMapping("/delete")
    public ResponseVO<Boolean> delete(
            @RequestBody @Valid AccountUpdateBO accountUpdateBO,
            BindingResult bindingResult
    ){
        throwError(bindingResult);
        Account account = new Account();
        account.setId(accountUpdateBO.getId());
        account.setIsDeleted(1);
        accountService.edit(account);
        return new ResponseVO<>(true);
    }

}
