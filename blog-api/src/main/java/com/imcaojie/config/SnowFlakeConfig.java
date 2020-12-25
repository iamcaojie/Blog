package com.imcaojie.config;

import com.imcaojie.utils.SnowFlake;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author caojie
 * @className SnowFlakeConfig
 * @description
 **/
@Configuration
public class SnowFlakeConfig {

    @Bean
    public SnowFlake create(){
        return new SnowFlake(1L,1L);
    }
}
