package com.core.aop;

import org.springframework.stereotype.Service;

@Service
public class AOPService {

	
	@TrackTime
	public String methodWithStringParam(String name) {
		System.out.println(name);
		return name;
	}
	
	@TrackTime
	public void methodWithoutParam() {
		System.out.println("without param");
	}
	
	public RequestDO methodwithCustomRequestDo(RequestDO request) {
		System.out.println(request);
		return request;
	}
	
	
	public void methodWithThrow(int a,int b) {
		System.out.println(a/b);
	}
}
