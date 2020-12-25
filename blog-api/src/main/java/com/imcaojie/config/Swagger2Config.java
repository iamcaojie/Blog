package com.imcaojie.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
@Slf4j
public class Swagger2Config {

    @Value("${server.port}")
    private Integer port;

    @Bean
    public Docket createRestApi() {
        log.info("文档地址：http://127.0.0.1:{}/swagger-ui.html",port);
        log.info("文档地址：http://127.0.0.1:{}/doc.html",port);
        return new Docket(DocumentationType.SWAGGER_2)
                    .apiInfo(apiInfo())
                    .select()
                    .apis(RequestHandlerSelectors
                            .basePackage("com.imcaojie.controller"))
                    .paths(PathSelectors.any())
                    .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("blog")
                .contact(new Contact("caojie",
                        "https://www.imcaojie.com",
                        "10804842@qq.com"))
                .description("Api文档")
                .version("1.0.1")
                .termsOfServiceUrl("https://www.imcaojie.com")
                .build();
    }

}
