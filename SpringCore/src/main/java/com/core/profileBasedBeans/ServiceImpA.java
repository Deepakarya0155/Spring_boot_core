package com.core.profileBasedBeans;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Profile({"DEV"})
@Component("Service")
public class ServiceImpA implements ServiceInterface {

	@Override
	public void f1() {
		
		System.out.println(this.getClass().getName());

	}

}
