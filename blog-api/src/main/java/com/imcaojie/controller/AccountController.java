package com.imcaojie.controller;

import com.imcaojie.service.IAccountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @author caojie
 * @className AccountController
 * @description
 **/
@RestController
@RequestMapping("/account")
@Slf4j
public class AccountController {

    @Autowired
    private IAccountService accountService;

    @GetMapping
    @RequestMapping("/getInfo")
    public Object getInfo(){
        return accountService.getInfo();
    }

    @GetMapping
    @RequestMapping("/login")
    public Object login(HttpServletRequest httpServletRequest){
        return accountService.getInfo();
    }
}
