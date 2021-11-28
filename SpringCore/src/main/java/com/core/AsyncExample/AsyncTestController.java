package com.core.AsyncExample;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/async")
public class AsyncTestController {

	@Autowired
	AsyncService service;
	
	@GetMapping("test")
	public String  test() {
		Future<String> response=service.f1(10);
		
		if(!response.isDone()) {
			System.out.println("Running");
		}
		
		try {
			response.get(10, TimeUnit.MILLISECONDS);   // timout exception
		} catch (InterruptedException | ExecutionException | TimeoutException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "Succes";
	}
}
