package com.core.MDCExample;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MDCConfiguration {

	
	@Bean
	public FilterRegistrationBean<MDCRequestFilter> loggingFilter(){
	    FilterRegistrationBean<MDCRequestFilter> registrationBean 
	      = new FilterRegistrationBean<>();
	        
	    registrationBean.setFilter(new MDCRequestFilter());
	    registrationBean.addUrlPatterns("/MDC/*");
	    registrationBean.setOrder(1);
	        
	    return registrationBean;    
	}
}
