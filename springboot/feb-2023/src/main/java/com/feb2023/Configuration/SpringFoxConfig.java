package com.feb2023.Configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.function.Predicate;

import static springfox.documentation.builders.PathSelectors.regex;

@Configuration
@EnableSwagger2
public class SpringFoxConfig {

    @Bean
    public Docket postsApi() {

        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build();
    }
//
//    private Predicate<String> postPaths() {
//        return or(regex("/api/posts.*"), regex("/api/javainuse.*"));
//    }

//    private ApiInfo apiInfo() {
//        return new ApiInfoBuilder().title("test API")
//                .description("test API reference for developers")
//                .termsOfServiceUrl("http://test.com")
//                .contact("test@gmail.com").license("test License")
//                .licenseUrl("tes@gmail.com").version("1.0").build();
//    }
}
