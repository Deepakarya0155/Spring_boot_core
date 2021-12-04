package com.core.cache;

import java.util.Arrays;
import java.util.List;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

@Component
public class CacheService {

	List<String> nameList=Arrays.asList("Deepak","Tarun","Vicky");
	
	@Cacheable("namecache")
	public List<String> getNames() {
		try {
			Thread.sleep(1000*10);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return nameList;
	}
	
	
	// you can clear multiple cache  @CacheEvict({"namecache","namecache2"})  
	@CacheEvict({"namecache"})
	public void cacheClear() {
		
	}
	
	
	
}
