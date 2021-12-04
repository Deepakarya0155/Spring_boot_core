package com.core.cache;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
public class CacheServiceTest {

	@Autowired
	CacheService cacheService;
	
	@Test
	@Order(1)
	public void test() {
		Long start=System.currentTimeMillis();
		cacheService.getNames();
		Long end=System.currentTimeMillis();
		Long time = end-start;
		
		Assertions.assertTrue(time>10*1000);
	}
	
	@Test
	@Order(2)
	public void test2() {
		Long start=System.currentTimeMillis();
		cacheService.getNames();
		Long end=System.currentTimeMillis();
		Long time = end-start;
		
		Assertions.assertTrue(time<1000);
	}
	
	@Test
	@Order(3)
	public void test3() {
		Long start=System.currentTimeMillis();
		cacheService.cacheClear();
		cacheService.getNames();
		Long end=System.currentTimeMillis();
		Long time = end-start;
		
		Assertions.assertFalse(time<1000);
	}
}
