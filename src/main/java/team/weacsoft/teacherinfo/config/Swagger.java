package team.weacsoft.teacherinfo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * swagger2基本信息配置
 * @author GreenHatHG
 */

@EnableSwagger2
@Profile({"dev"})
@Configuration
public class Swagger{

    private ApiInfo userApiInfo() {
        return new ApiInfoBuilder()
                .title("教师信息表API文档")
                .description("Mysql中教师信息表的增删改查操作")
                .termsOfServiceUrl("http://localhost:8080")
                .contact(new Contact("GreenHatHG",
                        "https://greenhathg.github.io/",
                        "1239776759@qq.com"))
                .license("Apache 2.0")
                .licenseUrl("http://www.apache.org/licenses/LICENSE-2.0.html")
                .build();
    }

    @Bean
    Docket docket(){
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("team.weacsoft.importTeacherInfo.controller"))
                .build()
                .enableUrlTemplating(true)
                .apiInfo(userApiInfo());
    }

}