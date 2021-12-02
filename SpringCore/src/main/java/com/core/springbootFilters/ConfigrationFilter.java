package com.core.springbootFilters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;





@Configuration
public class ConfigrationFilter {

	@Bean
	 public FilterRegistrationBean <CustomURLFilter> filterRegistrationBean() {
	  FilterRegistrationBean < CustomURLFilter > registrationBean = new FilterRegistrationBean();
	  CustomURLFilter customURLFilter = new CustomURLFilter();

	  registrationBean.setFilter(customURLFilter);
	  registrationBean.addUrlPatterns("/filtercontroller2/*");
	  registrationBean.setOrder(3); //set precedence
	  return registrationBean;
	 }

}
