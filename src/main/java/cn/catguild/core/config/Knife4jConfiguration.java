package cn.catguild.core.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author zhi.liu
 * @date 2021-07-02 18:51
 */
@Configuration
@EnableSwagger2
public class Knife4jConfiguration {

	@Bean(value = "defaultApi2")
	public Docket defaultApi2() {
		Docket docket=new Docket(DocumentationType.SWAGGER_2)
			.apiInfo(new ApiInfoBuilder()
				//.title("swagger-bootstrap-ui-demo RESTful APIs")
				.description("# swagger-bootstrap-ui-demo RESTful APIs")
				.termsOfServiceUrl("http://localhost:20000/")
				.contact(new Contact("kiro", "", "xx@gmail.com"))
				.version("1.0")
				.build())
			//分组名称
			.groupName("1.0版本")
			.select()
			//这里指定Controller扫描包路径
			.apis(RequestHandlerSelectors.basePackage("cn.catguild.core.controller"))
			.paths(PathSelectors.any())
			.build();
		return docket;
	}
}