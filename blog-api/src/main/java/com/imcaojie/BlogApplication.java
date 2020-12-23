package com.imcaojie;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @author caojie
 * @className Application
 * @description
 **/
@SpringBootApplication()
@MapperScan(basePackages = "com.imcaojie.mapper")
@EnableScheduling
public class BlogApplication {

    public static void main(String[] args){
        SpringApplication.run(BlogApplication.class,args);
    }
}
