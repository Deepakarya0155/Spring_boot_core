package com.core.MDCExample;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;


@Slf4j
@RestController
@RequestMapping("MDC")
public class MDCRestController {

	@GetMapping("test")
	public void testMethod() {
		log.info("Hello world");
	}
}
