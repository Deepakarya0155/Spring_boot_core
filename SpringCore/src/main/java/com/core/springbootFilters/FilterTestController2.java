package com.core.springbootFilters;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("filtercontroller2")
public class FilterTestController2 {
	
	/*
	 * requestedURlfilter 
	 * IP filter call
	 * customefilter
	 */
	@GetMapping("test")
	public void test() {
		System.out.println("filter test ");
	}
}
