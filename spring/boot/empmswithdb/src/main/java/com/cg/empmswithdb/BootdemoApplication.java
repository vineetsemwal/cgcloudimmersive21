package com.cg.empmswithdb;

import com.cg.empmswithdb.ui.AppFrontEnd;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @SpringBootAnnotation equivalent to these annotations
 * @Configuration
 * @ComponentScan
 * @AutoConfigure
 **/
@SpringBootApplication
public class BootdemoApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context=SpringApplication.run(BootdemoApplication.class, args);
		AppFrontEnd frontEnd=context.getBean(AppFrontEnd.class);
		frontEnd.start();
	}




}
