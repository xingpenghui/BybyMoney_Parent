package com.feri.byby.app.config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
/**
 *@Author feri
 *@Date Created in 2018/11/28 15:35
 */
@EnableSwagger2  //使用Swagger
@Configuration   //标记位配置文件
public class SwaggerConfig {
    //生成站点信息
    public ApiInfo apiInfo(){
        return new ApiInfoBuilder().title("BybyMoney在线接口文档")
                .description("主要实现开发中的BybyMoney项目的在线接口描述信息")
                .contact(new Contact("Feri","http://www.1000phone.com","1805@163.com")).
                        build();
    }
    @Bean   //类似<bean> 创建对象 IOC
    public Docket createDocket(){
        return new Docket(DocumentationType.SWAGGER_2).//文档的类型
                apiInfo(apiInfo()).select().//整个在线接口文档的设置
                apis(RequestHandlerSelectors.basePackage("com.feri.byby.app")).//需要生成接口文档的包 使用Swagger的包
                build();
    }
}
