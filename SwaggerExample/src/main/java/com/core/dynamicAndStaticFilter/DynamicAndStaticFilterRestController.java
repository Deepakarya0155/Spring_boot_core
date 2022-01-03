package com.core.dynamicAndStaticFilter;

import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

@RestController
@RequestMapping("DandSFilter")
public class DynamicAndStaticFilterRestController {
	
	@GetMapping("static")
	public User staticFilter() {
		return new User("1", "Deepak", new Date());
	}
	
	@GetMapping("dynamic")
	public MappingJacksonValue dynamicFilter() {
		User u=new User("1", "Deepak", new Date());
		
		SimpleBeanPropertyFilter filter=SimpleBeanPropertyFilter.filterOutAllExcept(new HashSet(Arrays.asList("name","dob")));
		
		
		
		FilterProvider filterProvide=new SimpleFilterProvider().addFilter("someFilter", filter);
		
		
		MappingJacksonValue mapping=new MappingJacksonValue(u);
		mapping.setFilters(filterProvide);
		
		return mapping;
		
	}
}
