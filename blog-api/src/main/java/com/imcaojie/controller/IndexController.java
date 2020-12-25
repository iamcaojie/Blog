package com.imcaojie.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author caojie
 * @className HelloController
 * @description
 **/
@RestController
@RequestMapping("/")
@Api(value = "首页", tags = {"首页"})
public class IndexController extends BaseController {

    @GetMapping("/")
    @ApiOperation(value = "首页", notes = "首页", httpMethod = "GET")
    public String index(){
        return "HELLO WORLD";
    }
}
