package com.core.swagger;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.service.Contact;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	public static final Contact DEFAULT_CONTACT
    = new Contact(
    "Deepak",
    ".com	",
    "asdafs");

	public static final ApiInfo API_INFO=new ApiInfo("First API",
			"Learning Microservice ", "1.0", "nothing", DEFAULT_CONTACT, "Genernal", "nothing",new ArrayList());
	
	public static final Set<String> PRODUCER_AND_CONSUMER=new HashSet<>(Arrays.asList("Application/JSON"));
	
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).apiInfo(API_INFO)
				.consumes(PRODUCER_AND_CONSUMER).produces(PRODUCER_AND_CONSUMER);
	}
	
	


}
