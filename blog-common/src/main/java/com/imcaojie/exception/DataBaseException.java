package com.imcaojie.exception;

import lombok.AllArgsConstructor;

/**
 * @author caojie
 * @className DataBaseException
 * @description
 **/
@AllArgsConstructor
public class DataBaseException extends RuntimeException {

    private String message;

    @Override
    public String getMessage(){
        return message;
    }

}
