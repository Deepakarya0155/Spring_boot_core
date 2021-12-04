package com.core.AsyncExample;

import java.util.concurrent.Future;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
public class AsyncServiceTest {

	@Autowired
	AsyncService asyncService;
	
	@BeforeAll
	public static void beforeALL(){
		System.out.println("Before ALL");
	}
	
	@BeforeEach
	public void beforeEach() {
		System.out.println("Before each");
	}
	
	@AfterAll
	public static void AfterALL(){
		System.out.println("After ALL");
	}
	
	@AfterEach
	public void AfterEach() {
		System.out.println("After each");
	}
	
	
	
	@Test
	@Order(2)
	public void test1() {
		
		Future<String> respone=asyncService.f1(1);
		Assertions.assertFalse(respone.isDone());
		System.out.println("Test1"+asyncService.hashCode());
	}
	
	@Test
	@Order(1)
	public void test2() {
		Future<String> respone=asyncService.f1(1);
		try {
			Thread.sleep(1000*2);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Assertions.assertTrue(respone.isDone());
		System.out.println("Test2"+asyncService.hashCode());
	}
}
