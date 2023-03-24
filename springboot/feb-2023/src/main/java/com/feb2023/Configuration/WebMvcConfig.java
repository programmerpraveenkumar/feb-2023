package com.feb2023.Configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
//    @Autowired
//    TokenInterceptor tokenInterceptor;
//
//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(tokenInterceptor);
//    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        System.out.println("inside cors mapping..");
        registry.addMapping("/**").
                allowedOrigins("*").allowedHeaders("*");
    }
}
