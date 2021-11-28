package com.core.AsyncExample;

import java.util.concurrent.Future;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;

@Service
public class AsyncService {

	@Async("test1")
	public Future<String> f1(int i) {
		
		try {
			Thread.sleep(1000*i);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName()+" Completed");
		return new AsyncResult<String>(" Completed ");
	}
}
