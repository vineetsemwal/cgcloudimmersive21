package com.cg.securitydemo;

import com.cg.securitydemo.userms.entities.Admin;
import com.cg.securitydemo.userms.entities.User;
import com.cg.securitydemo.userms.service.IAdminService;
import com.cg.securitydemo.userms.service.IUserService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.HashSet;
import java.util.Set;

@EnableSwagger2
@SpringBootApplication
public class SecurityDemoApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(SecurityDemoApplication.class, args);
        IAdminService adminService = context.getBean(IAdminService.class);
        IUserService userService = context.getBean(IUserService.class);
        Set<String> roles=new HashSet<>();
        roles.add("admin");
        User user=userService.add("raju","raju",roles);
        Admin admin = new Admin();
        admin.setUser(user);
        adminService.add(admin);
    }



    @Bean
    public Docket api(){
        Docket docket=new Docket(DocumentationType.SWAGGER_2).
                apiInfo(  apiInfo() )
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.cg.securitydemo"))
                .paths(PathSelectors.any())
                .build();
        return docket;
    }


    @Bean
    public ApiInfo apiInfo(){
        ApiInfo info=new ApiInfoBuilder()
                .title("user module demo")
                .description("rest api")
                .build();
        return info;
    }
}
