package com.core.readingConfiguration;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;

@SpringBootTest
public class ReadConfigurationClassTest {

	@Autowired
	ReadConfigurationClass readConfigurationClass;
	
	@Autowired
	Environment env;
	
	@Test
	public void test1() {
		System.out.println(readConfigurationClass);
		System.out.println(readConfigurationClass.getProperties().get("mail.smtp.starttls.enable"));
		System.out.println(env.getProperty("spring.mail.properties.mail.smtp.starttls.enable"));
	}
}
