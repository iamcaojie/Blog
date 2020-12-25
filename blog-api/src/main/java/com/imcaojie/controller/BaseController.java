package com.imcaojie.controller;

import com.imcaojie.exception.ParamsException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

/**
 * @author caojie
 * @className BaseController
 * @description
 **/
public class BaseController {

    protected void throwError(BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            FieldError fieldError = bindingResult.getFieldError();
            String errorField = "未知字段";
            String errorMessage = "未知错误";
            if(fieldError != null){
                errorField = fieldError.getField();
                errorMessage = fieldError.getDefaultMessage();
            }
            throw new ParamsException(errorField+"-"+errorMessage);
        }
    }
}
