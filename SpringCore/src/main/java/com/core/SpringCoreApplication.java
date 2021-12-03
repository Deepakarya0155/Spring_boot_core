package com.core;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.core.emailservice.EmailService;
import com.core.emailservice.EmailServiceRequest;
import com.core.profileBasedBeans.ExampleLoadBeanBasedOnProfiles;
import com.core.readingConfiguration.ReadConfigurationClass;

@SpringBootApplication
public class SpringCoreApplication implements CommandLineRunner {

	@Autowired
	ExampleLoadBeanBasedOnProfiles exampleLoadBeanBasedOnProfiles;
	
	@Autowired
	EmailService emailservice;
	
	@Autowired
	ReadConfigurationClass readConfigurationClass;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringCoreApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
//		emailservice.test();
//		EmailServiceRequest obj=new EmailServiceRequest();
//		obj.addNewFile("C:\\Users\\Deepa\\learning\\git_repositoris\\Spring_boot_core\\SpringCore\\src\\main\\resources\\application.properties");
		
		
		System.out.println(readConfigurationClass);
		System.out.println();
	}

	
	
}
