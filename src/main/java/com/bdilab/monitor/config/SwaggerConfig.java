package com.bdilab.monitor.config;

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

/**
 * Swagger配置文件
 *
 * @author Lian
 * @date 2021/2/18 22:56
 **/
@Configuration
@EnableSwagger2
public class SwaggerConfig {
    /**
     * 用户信息管理接口配置
     *
     * @return 用户信息管理接口配置
     */
    @Bean
    public Docket userInfoManagementApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .enable(true)
                .apiInfo(apiInfo())
                .groupName("用户信息管理API")
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.bdilab.monitor.business.userManagement.userInfoManagement.controller"))
                .paths(PathSelectors.any())
                .build();
    }

    /**
     * 组织信息管理接口配置
     *
     * @return 组织信息管理接口配置
     */
    @Bean
    public Docket organizationInfoManagement() {
        return new Docket(DocumentationType.SWAGGER_2)
                .enable(true)
                .apiInfo(apiInfo())
                .groupName("组织信息管理API")
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.bdilab.monitor.business.organizationManagement.organizationInfoManagement.controller"))
                .paths(PathSelectors.any())
                .build();
    }

    /**
     * 工区信息管理接口配置
     *
     * @return 工区信息管理接口配置
     */
    @Bean
    public Docket workSpaceInfoManagement() {
        return new Docket(DocumentationType.SWAGGER_2)
                .enable(true)
                .apiInfo(apiInfo())
                .groupName("工区信息管理API")
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.bdilab.monitor.business.workSpaceManagement.workSpaceInfoManagement.controller"))
                .paths(PathSelectors.any())
                .build();
    }

    /**
     * 角色信息管理接口配置
     *
     * @return 角色信息管理接口配置
     */
    @Bean
    public Docket roleInfoManagement() {
        return new Docket(DocumentationType.SWAGGER_2)
                .enable(true)
                .apiInfo(apiInfo())
                .groupName("角色信息管理API")
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.bdilab.monitor.business.authorityManagement.roleInfoManagement.controller"))
                .paths(PathSelectors.any())
                .build();
    }

    /**
     * 接口文档摘要信息
     *
     * @return 摘要信息
     */
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("展示样例接口文档")
                .contact(new Contact("bdilab", "", ""))
                .termsOfServiceUrl("http://47.105.158.179")
                .description("包含用户管理、组织管理、工区管理、权限管理。")
                .version("版本号 ： " + "1.0")
                .build();
    }
}
