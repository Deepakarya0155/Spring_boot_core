package com.core.profileBasedBeans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ExampleLoadBeanBasedOnProfiles {

	@Autowired
	ServiceInterface serviceObje;
	
	public void Test() {
		serviceObje.f1();
	}
}
