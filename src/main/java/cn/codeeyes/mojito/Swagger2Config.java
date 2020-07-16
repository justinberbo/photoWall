package cn.codeeyes.mojito;

import io.swagger.annotations.ApiOperation;
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
 * @author zhuang
 */
@EnableSwagger2
@Configuration
public class Swagger2Config {
  @Bean
  public Docket createRestApi() {
    return new Docket(DocumentationType.SWAGGER_2)
        .apiInfo(apiInfo())
        .select()
//        .apis(RequestHandlerSelectors.withClassAnnotation(Api.class))
        .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
        //         方法需要有ApiOperation注解才能生存接口文档
        .paths(PathSelectors.any())
        .build();
  }

  private ApiInfo apiInfo() {
    return new ApiInfoBuilder()
        .title("swagger api文档")
        .contact(new Contact("zhuang", "http://www.codeeyes.cn/", "tmdsbtjjtds@foxmail"))
        .description("社区")
        .termsOfServiceUrl("http://localhost:8090/")
        .version("1.0")
        .build();
  }

}
