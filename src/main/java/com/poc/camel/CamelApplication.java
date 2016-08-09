package com.poc.camel;

import org.apache.camel.spring.SpringCamelContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.poc.camel")
@EnableAutoConfiguration
public class CamelApplication {

	public static void main(String[] args) {
		SpringApplication.run(CamelApplication.class, args);
	}

	@Bean
	public SpringCamelContext camelContext(ApplicationContext applicationContext)
			throws Exception {
		SpringCamelContext camelContext = new SpringCamelContext(
				applicationContext);
		Logger logger = LoggerFactory.getLogger(getClass());
		logger.info("Spring-Camel context configured" + camelContext.toString());
		return camelContext;
	}

	
}
