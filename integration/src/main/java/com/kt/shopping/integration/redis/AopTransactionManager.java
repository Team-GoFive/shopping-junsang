package com.kt.shopping.integration.redis;

import org.aspectj.lang.ProceedingJoinPoint;

public interface AopTransactionManager {
	Object proceed(ProceedingJoinPoint joinPoint) throws Throwable;
}
