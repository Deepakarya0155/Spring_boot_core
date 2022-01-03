package com.core.locale;

import java.util.Locale;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;

@Configuration
public class LocaleConfigClass {

	
	@Bean
	public LocaleResolver loaclResolver() {
		AcceptHeaderLocaleResolver localeRes=new AcceptHeaderLocaleResolver();
		localeRes.setDefaultLocale(Locale.US);
		return localeRes;
	}
	
	@Bean
	@Primary
	public ResourceBundleMessageSource bundleMessageSource() {
		ResourceBundleMessageSource resourceBundleMessageSourceObj=new ResourceBundleMessageSource();
		resourceBundleMessageSourceObj.setBasename("Welcome");
		return resourceBundleMessageSourceObj;
	}


}
