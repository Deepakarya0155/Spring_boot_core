package com.core.headers;

import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("header")
public class HeaderTestController {

	@GetMapping("test")
	public void test(@RequestHeader Map mp) {
		mp.forEach((K,V)->System.out.println(K+" : "+V));;
	}
}
