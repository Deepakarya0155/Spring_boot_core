package com.core.readingConfiguration;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ExternalreadingConfigurationTest {

	@Autowired
	ReadPropertiesFromExternalFile readPropertiesFromExternalFile ;
	
	@Test
	public void test1() {
		System.out.println(readPropertiesFromExternalFile);
	}
}
