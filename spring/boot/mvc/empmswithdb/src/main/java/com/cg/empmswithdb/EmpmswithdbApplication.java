package com.cg.empmswithdb;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EmpmswithdbApplication {

	private static final Logger Log= LoggerFactory.getLogger(EmpmswithdbApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(EmpmswithdbApplication.class, args);

		Log.debug("i am logged with debug level");
		Log.info("i am logged with info level");
		Log.error("i am logged with error level");
	}

}
