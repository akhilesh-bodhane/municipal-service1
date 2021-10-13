package org.egov.pm.util;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.Configuration;

import lombok.extern.slf4j.Slf4j;

@Aspect
@Configuration
@Slf4j
public class ApplicationAspectLogs {

	// Controller
	@Before("execution(* org.egov.pm.web.controller.*.*(..))")
	public void beforeController(JoinPoint joinPoint) {
		long startTime = System.currentTimeMillis();
		log.info("pm-services logs :: beforeController = Method::{}, Execution Time::{}", joinPoint.getSignature(),
				startTime);
	}

	@After("execution(* org.egov.pm.web.controller.*.*(..))")
	public void afterController(JoinPoint joinPoint) {
		long startTime = System.currentTimeMillis();
		log.info("pm-services logs :: afterController = Method::{}, Execution Time::{}", joinPoint.getSignature(),
				startTime);
	}

	@AfterReturning(value = "execution(* org.egov.pm.web.controller.*.*(..))", returning = "result")
	public void afterReturningController(JoinPoint joinPoint, Object result) {
		long startTime = System.currentTimeMillis();
		log.info("pm-services logs :: afterReturningController = Method::{}, Execution Time::{}, Results::{}",
				joinPoint.getSignature(), startTime, result);
	}

	@AfterThrowing(value = "execution(* org.egov.pm.web.controller.*.*(..))", throwing = "exception")
	public void afterThrowingController(JoinPoint joinPoint, Throwable exception) {
		long startTime = System.currentTimeMillis();
		log.info("pm-services logs :: afterThrowingController = Method::{}, Execution Time::{}, Exception::{}",
				joinPoint.getSignature(), startTime, exception.getMessage());
	}

	// Service
	@Before("execution(* org.egov.pm.service.*.*(..))")
	public void beforeService(JoinPoint joinPoint) {
		long startTime = System.currentTimeMillis();
		log.info("pm-services logs :: beforeService = Method::{}, Execution Time::{}", joinPoint.getSignature(),
				startTime);
	}

	@After("execution(* org.egov.pm.service.*.*(..))")
	public void afterService(JoinPoint joinPoint) {
		long startTime = System.currentTimeMillis();
		log.info("pm-services logs :: afterService = Method::{}, Execution Time::{}", joinPoint.getSignature(),
				startTime);
	}

	@AfterReturning(value = "execution(* org.egov.pm.service.*.*(..))", returning = "result")
	public void afterReturningService(JoinPoint joinPoint, Object result) {
		long startTime = System.currentTimeMillis();
		log.info("pm-services logs :: afterReturningService = Method::{}, Execution Time::{}, Results::{}",
				joinPoint.getSignature(), startTime, result);
	}

	@AfterThrowing(value = "execution(* org.egov.pm.service.*.*(..))", throwing = "exception")
	public void afterThrowingService(JoinPoint joinPoint, Throwable exception) {
		long startTime = System.currentTimeMillis();
		log.info("pm-services logs :: afterThrowingService = Method::{}, Execution Time::{}, Exception::{}",
				joinPoint.getSignature(), startTime, exception.getMessage());
	}

	// Repository
	@Before("execution(* org.egov.pm.repository.*.*(..))")
	public void beforeRepository(JoinPoint joinPoint) {
		long startTime = System.currentTimeMillis();
		log.info("pm-services logs :: beforeRepository = Method::{}, Execution Time::{}", joinPoint.getSignature(),
				startTime);
	}

	@After("execution(* org.egov.pm.repository.*.*(..))")
	public void afterRepository(JoinPoint joinPoint) {
		long startTime = System.currentTimeMillis();
		log.info("pm-services logs :: afterRepository = Method::{}, Execution Time::{}", joinPoint.getSignature(),
				startTime);
	}

	@AfterReturning(value = "execution(* org.egov.pm.repository.*.*(..))", returning = "result")
	public void afterReturningRepository(JoinPoint joinPoint, Object result) {
		long startTime = System.currentTimeMillis();
		log.info("pm-services logs :: afterReturningRepository = Method::{}, Execution Time::{}, Results::{}",
				joinPoint.getSignature(), startTime, result);
	}

	@AfterThrowing(value = "execution(* org.egov.pm.repository.*.*(..))", throwing = "exception")
	public void afterThrowingRepository(JoinPoint joinPoint, Throwable exception) {
		long startTime = System.currentTimeMillis();
		log.info("pm-services logs :: afterThrowingRepository = Method::{}, Execution Time::{}, Exception::{}",
				joinPoint.getSignature(), startTime, exception.getMessage());
	}
}
