package com.core.aop;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.Configuration;

@Configuration
@Aspect
public class AOPConfiguration {

	
//	@Before(value="execution(* com.core.aop.*.*(..) )")
//	public void before(JoinPoint joinpoint) {
//		System.out.println("LOG :: before method called started");
//		Arrays.asList(joinpoint.getArgs()).forEach(S->{
//			
//			System.out.println("LOG :: Parameters ::"+S);
//		});
//		
//		System.out.println("LOG :: before method called end");
//	}
	
//	@After(value="execution(* com.core.aop.*.*(..) )")
//	public void after(JoinPoint joinpoint) {
//		System.out.println("LOG :: after :: Start");
//		Arrays.asList(joinpoint.getArgs()).forEach(S->{
//			System.out.println("LOG :: Parameters ::"+S);
//		});
//		System.out.println("LOG :: after :: end");
//	}

//		@AfterReturning(value="execution(* com.core.aop.*.*(..) )",returning ="result" )
//		public void afterReturn(JoinPoint joinpoint,Object result) {
//			System.out.println("LOG :: After return "+result);
//		}
	
	
//		@AfterThrowing(value="execution(* com.core.aop.*.*(..) )",throwing = "exception" )
//		public void afterthrow(JoinPoint point,Object exception) {
//			System.out.print("Log :: Exception :: "+exception);
//		}
	
//		@Around(value="execution(* com.core.aop.*.*(..) )")
//		public void around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
//			Long st=System.currentTimeMillis();
//			proceedingJoinPoint.proceed();
//			Long et=System.currentTimeMillis();
//			System.out.println("LOG :: "+proceedingJoinPoint+" time taken :: "+(et-st));
//		}
		
		
		@Around(value="com.core.aop.CommonJoinPointConfig.trackTimeAnnotation()")
		public void around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
			Long st=System.currentTimeMillis();
			proceedingJoinPoint.proceed();
			Long et=System.currentTimeMillis();
			System.out.println("LOG :: "+proceedingJoinPoint+" time taken :: "+(et-st));
		}
}
