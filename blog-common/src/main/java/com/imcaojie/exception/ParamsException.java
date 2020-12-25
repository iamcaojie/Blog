package com.imcaojie.exception;

import lombok.AllArgsConstructor;

/**
 * @author caojie
 * @className SystemException
 * @description
 **/
@AllArgsConstructor
public class ParamsException extends RuntimeException {

    private String message;

    @Override
    public String getMessage(){
        return message;
    }

}
