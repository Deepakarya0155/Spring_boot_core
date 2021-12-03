package com.core.readingConfiguration;

import java.util.Map;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
@ConfigurationProperties("spring.mail")
public class ReadConfigurationClass {

	
	
	String host;
	String port;
	String username;
	String password;
	Map<String,String> properties;
}
