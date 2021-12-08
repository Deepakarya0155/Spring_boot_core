package com.core.aop;

import org.aspectj.lang.annotation.Pointcut;

public class CommonJoinPointConfig {

//	
//	@Pointcut("execution(* com.core.aop.*.*(..) )")
//	public void dataLayerExecution(){}
//	
//	@Pointcut("execution(* com.core.aop.*.*(..))")
//	public void businessLayerExecution(){}
//	
//	@Pointcut("dataLayerExecution() && businessLayerExecution()")
//	public void allLayerExecution(){}
//	
//	@Pointcut("bean(*dao*)")
//	public void beanContainingDao(){}
//	
//	@Pointcut("within(com.in28minutes.spring.aop.springaop.data..*)")
//	public void dataLayerExecutionWithWithin(){}
//
	@Pointcut("@annotation(com.core.aop.TrackTime)")
	public void trackTimeAnnotation(){}
}
