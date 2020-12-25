package com.imcaojie.pojo.vo;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author caojie
 * @className ExceptionVo
 * @description
 **/
@Data
@AllArgsConstructor
public class ExceptionVO {

    private Integer status;

    private String msg;

    private String data;
}
