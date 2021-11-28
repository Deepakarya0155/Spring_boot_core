package com.core.AsyncExample;

import java.util.concurrent.Executor;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

@Configuration
@EnableAsync
public class AsyncConfiguration {

	
	@Bean(name="test1")
	public Executor test1() {
		ThreadPoolTaskExecutor th=new ThreadPoolTaskExecutor();
		th.setCorePoolSize(2);
		th.setMaxPoolSize(2);
		th.setThreadNamePrefix("Test ");
		th.initialize();
		return th;
	}

}
