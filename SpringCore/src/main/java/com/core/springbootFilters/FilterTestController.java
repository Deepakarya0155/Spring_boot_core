package com.core.springbootFilters;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("filtercontroller")
public class FilterTestController {

	
	/*
	 * requestedURlfilter 
	 * IP filter call
	 * 
	 */
	@GetMapping("test")
	public void test() {
		System.out.println("filter test ");
	}
}
