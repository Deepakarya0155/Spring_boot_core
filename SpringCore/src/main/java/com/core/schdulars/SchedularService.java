package com.core.schdulars;

import java.util.Date;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class SchedularService {

	@Scheduled(fixedRate = 1000)
	public void f1() {
		try {
			Thread.sleep(1000*10);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Fixed rate "+ new Date());
	}
	
	@Scheduled(fixedRateString =  "${fixed.delay}")
	public void f2() {
		System.out.println("Fixed fixed.delay "+ new Date());
	}
}
