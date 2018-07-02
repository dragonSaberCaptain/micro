package com.jskj.micro.config.swagger;

import com.google.common.base.Predicate;
import com.jskj.micro.config.common.Global;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.async.DeferredResult;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static com.google.common.base.Predicates.or;
import static springfox.documentation.builders.PathSelectors.regex;

/**
 * Copyright © 2018 dragonSaberCaptain. All rights reserved.
 *
 * @author dragonSaberCaptain
 * @packageName com.jskj.smart.config
 * @description
 * @date 2018-05-03 10:16 星期四
 */

@Configuration
@EnableSwagger2//重要！
@ComponentScan("com.jskj.micro.controller")
public class SwaggerConfig {

    @Bean
    public Docket platformApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("platform")
                .genericModelSubstitutes(DeferredResult.class)
                .useDefaultResponseMessages(false)
                .forCodeGeneration(false)
                .pathMapping("/")
                .select()
                //过滤的接口
                .paths(apiPaths())
                .build()
                .apiInfo(platformApiInfo());
    }

    /**
     * @description 定义那些url需要生成swagger文档
     * @author dragonSaberCaptain
     * @date 2018-05-10 13:18:23
     */
    private Predicate<String> apiPaths() {
        return or(
                regex(Global.OPEN + "/.*"),
                regex("/home/.*"),
                regex("/user/.*"),
                regex("/picture/.*"),
                regex("/test/.*")
        );
    }

    private ApiInfo platformApiInfo() {
        return new ApiInfoBuilder()
                //大标题
                .title("micro API")
                //详细描述
                .description("micro exchange platform for API")
                //版本
                .version("1.0")
                //服务条款网址
                .termsOfServiceUrl("https://www.jskj.com/")
                //作者
                .contact(new Contact("dragonSaberCaptain", "https://www.jskj.com/", "749969369@qq.com"))
                //Apache许可证，版本2.0
                .license("The Apache License, Version 2.0")
                //Apache许可证Url
                .licenseUrl("http://www.apache.org/licenses/LICENSE-2.0.html")
                .build();
    }
}
