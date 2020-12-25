package com.imcaojie.pojo.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;

/**
 * @author caojie
 * @className ResponseVo
 * @description
 **/
@Data
@AllArgsConstructor
public class ResponseVO<E> {

    private Integer status;

    private String msg;

    private E data;

    public ResponseVO (E data){
        this(200,"success",data);
    }
}
