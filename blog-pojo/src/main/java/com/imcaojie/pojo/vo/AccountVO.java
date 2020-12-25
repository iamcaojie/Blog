package com.imcaojie.pojo.vo;

import lombok.Data;

import java.util.Date;

/**
 * @author caojie
 * @className AccountVo
 * @description
 **/
@Data
public class AccountVO {

    private Long id;

    private String name;

    private Integer phone;

    private String unionId;

    private Integer isDeleted;

    private Integer status;

    private Date createdTime;

    private Date updatedTime;

    private String statusDesc;

}
