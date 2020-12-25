package com.imcaojie.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author caojie
 * @className DataNotFoundException
 * @description
 **/
@AllArgsConstructor
public class DataNotFoundException extends RuntimeException {

    private String message;

    @Override
    public String getMessage(){
        return message;
    }

}
