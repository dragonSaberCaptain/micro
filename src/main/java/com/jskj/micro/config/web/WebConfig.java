package com.jskj.micro.config.web;

import com.jskj.micro.config.common.Global;
import com.jskj.micro.filter.ApiInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.HttpPutFormContentFilter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.ArrayList;
import java.util.List;

/**
 * Copyright © 2018 dragonSaberCaptain. All rights reserved.
 *
 * @author dragonSaberCaptain
 * @packageName com.jskj.wisdom
 * @description
 * @date 2018-05-07 13:47 星期一
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("swagger-ui.html")
                .addResourceLocations("classpath:/META-INF/resources/");

        registry.addResourceHandler("/webjars/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/");

        //允许访问静态资源
        registry.addResourceHandler("/static/**")
                .addResourceLocations("classpath:/static/");
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        List<String> stringList = new ArrayList<>();
        stringList.add("/open/**");
        stringList.add("/webjars/**");
        stringList.add("/swagger-resources/**");
        stringList.add("/swagger-ui.html");
        stringList.add("/static/**");
        stringList.add("/error");
        //拦截规则:排除上面的，其余的都拦截
        registry.addInterceptor(new ApiInterceptor()).addPathPatterns("/**").excludePathPatterns(stringList);
    }

    //允许跨域请求
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/").allowedOrigins(Global.HTTP_HOST_POST);
    }

    @Bean
    public HttpPutFormContentFilter httpPutFormContentFilter() {
        return new HttpPutFormContentFilter();
    }

}
