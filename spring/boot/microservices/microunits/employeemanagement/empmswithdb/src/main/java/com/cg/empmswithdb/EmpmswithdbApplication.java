package com.cg.empmswithdb;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@SpringBootApplication
public class EmpmswithdbApplication {

	private static final Logger Log= LoggerFactory.getLogger(EmpmswithdbApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(EmpmswithdbApplication.class, args);

		Log.debug("i am logged with debug level");
		Log.info("i am logged with info level");
		Log.error("i am logged with error level");
	}


	@Bean
	public Docket api(){
		Docket docket=new Docket(DocumentationType.SWAGGER_2).
				apiInfo(  apiInfo() )
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.cg.empmswithdb"))
				.paths(PathSelectors.any())
				.build();
		return docket;
	}


	@Bean
	public ApiInfo apiInfo(){
		ApiInfo info=new ApiInfoBuilder()
				 .title("Employee management application")
				.description("rest api for employee management")
				.build();
		return info;
	}


}
