package com.eprogrammerz.examples;

import com.google.common.base.Predicates;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Created by 542596.
 */
@Configuration
@Profile("!production")
@EnableSwagger2
public class SwaggerConfiguration {

    @Bean
    public Docket contentDetailApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("content-api")
                .apiInfo(this.contentDetailApiInfo())
                .select()
                .paths(PathSelectors.any())
                .apis(Predicates.not(RequestHandlerSelectors.basePackage("org.springframework.boot")))
                .build();

    }

    private ApiInfo contentDetailApiInfo() {
        return new ApiInfoBuilder()
                .title("Content Delivery API - build # 1.0")
                .description("Enter the IDs in order to look for the content")
                .version("0.1")
                .build();
    }
}
