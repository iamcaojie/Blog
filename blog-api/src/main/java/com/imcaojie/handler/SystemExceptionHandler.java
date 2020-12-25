package com.imcaojie.handler;

import com.imcaojie.exception.DataBaseException;
import com.imcaojie.exception.DataNotFoundException;
import com.imcaojie.exception.ParamsException;
import com.imcaojie.pojo.vo.ExceptionVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author caojie
 * @className SystemExceptionHandler
 * @description
 **/
@ControllerAdvice
@Slf4j
public class SystemExceptionHandler {

//    @ExceptionHandler(Exception.class)
//    @ResponseBody
//    public ResponseEntity<ExceptionVO> handleException(Exception e){
//        log.error("Exception-"+ e.getMessage());
//        return new ResponseEntity<>(
//                new ExceptionVO(200,e.getMessage(),""),
//                HttpStatus.OK);
//    }

    @ExceptionHandler(ParamsException.class)
    @ResponseBody
    public ExceptionVO handleParamsException(ParamsException e){
        log.error("ParamsException-"+ e.getMessage());
        return new ExceptionVO(200,e.getMessage(),"ParamsException");
    }

    @ExceptionHandler(DataNotFoundException.class)
    @ResponseBody
    public ExceptionVO handleDataNotFoundException(DataNotFoundException e){
        log.error("DataNotFoundException-"+ e.getMessage());
        return new ExceptionVO(200,e.getMessage(),"DataNotFoundException");
    }

    @ExceptionHandler(DataBaseException.class)
    @ResponseBody
    public ExceptionVO handleDataBaseException(DataBaseException e){
        log.error("DataBaseException-"+ e.getMessage());
        return new ExceptionVO(200,e.getMessage(),"DataBaseException");
    }
}
