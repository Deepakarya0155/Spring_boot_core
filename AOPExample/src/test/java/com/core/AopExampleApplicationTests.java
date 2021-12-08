package com.core;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.core.aop.AOPService;
import com.core.aop.RequestDO;

@SpringBootTest
class AopExampleApplicationTests {
	
	@Autowired
	AOPService service;

	@Test
	void contextLoads() {
		
		
		
		service.methodWithoutParam();
		service.methodWithStringParam("Deepak");
		
		RequestDO req=new RequestDO();
		req.setAge("21");
		req.setName("Deepu");
		
		service.methodwithCustomRequestDo(req);
		
		service.methodWithThrow(1, 0);
	}

}
