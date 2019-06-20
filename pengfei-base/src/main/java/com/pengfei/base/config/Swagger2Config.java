package com.pengfei.base.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import javax.annotation.PostConstruct;

@Configuration
@EnableSwagger2
public class Swagger2Config {

    @PostConstruct
    public void init(){
        System.out.println("*************************************************************************");
        System.out.println();
        System.out.println("                            swagger2 init start                          ");
        System.out.println();
        System.out.println("*************************************************************************");
    }

    @Bean
    public Docket createRestApi(){
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo( apiInfo() )
                .select()
                .apis( RequestHandlerSelectors.basePackage("com.pengfei") )
                .paths( PathSelectors.any() )
                .build();
    }

    private ApiInfo apiInfo(){
        return new ApiInfoBuilder()
                .title("swagger-ui Restful Apis")
                .description("swagger-ui")
                .termsOfServiceUrl("http://localhost:8080/")
                .version("1.0.0")
                .build();
    }

}
