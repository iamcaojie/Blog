package com.imcaojie.utils;

/**
 * @author caojie
 * @className ResponseUtil
 * @description
 **/
public class ResponseUtil<E> {

    private Integer status;

    private String msg;

    private Object data;

    public ResponseUtil<E> jsonSuccess(){
        return this;
    }

    public ResponseUtil<E> jsonError(){
        return this;
    }

}
