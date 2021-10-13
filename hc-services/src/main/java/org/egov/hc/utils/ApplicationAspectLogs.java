package org.egov.hc.utils;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.slf4j.Slf4j;

@Aspect
@Configuration
@Slf4j
public class ApplicationAspectLogs {

	@Autowired
	private ObjectMapper mapper;

	@Before("execution(* org.egov.hc.service.*.*(..)) || execution(* org.egov.hc.controller.*.*(..)) || execution(* org.egov.hc.repository.*.*(..))")
	public void beforeService(JoinPoint joinPoint) throws JsonProcessingException {
		log.info("Hc-Services::Before::Method Name::{}, Executed Time::{}",
				joinPoint.getSignature().getDeclaringTypeName(), System.currentTimeMillis());
		log.debug("Hc-Services::Before::Method Name::{}, Executed Time::{}, Request Parameters::{}",
				joinPoint.getSignature().getDeclaringTypeName(), System.currentTimeMillis(),
				joinPoint.getArgs().length > 0 ? mapper.writeValueAsString(joinPoint.getArgs()[0])
						: "No Request Parameters");
	}

	@After("execution(* org.egov.hc.service.*.*(..)) || execution(* org.egov.hc.controller.*.*(..)) || execution(* org.egov.hc.repository.*.*(..))")
	public void afterService(JoinPoint joinPoint) throws JsonProcessingException {
		log.info("Hc-Services::After::Method Name::{}, Executed Time::{}",
				joinPoint.getSignature().getDeclaringTypeName(), System.currentTimeMillis());
		log.debug("Hc-Services::After::Method Name::{}, Executed Time::{}, Request Parameters::{}",
				joinPoint.getSignature().getDeclaringTypeName(), System.currentTimeMillis(),
				joinPoint.getArgs().length > 0 ? mapper.writeValueAsString(joinPoint.getArgs()[0])
						: "No Request Parameters");
	}

	@AfterReturning(value = "execution(* org.egov.hc.service.*.*(..)) || execution(* org.egov.hc.controller.*.*(..)) || execution(* org.egov.hc.repository.*.*(..))", returning = "result")
	public void afterReturningService(JoinPoint joinPoint, Object result) throws JsonProcessingException {
		log.info("Hc-Services::AfterReturning::Method Name::{}, Executed Time::{}",
				joinPoint.getSignature().getDeclaringTypeName(), System.currentTimeMillis());
		log.debug(
				"Hc-Services::AfterReturning::Method Name::{}, Executed Time::{}, Request Parameters::{}, Response::{}",
				joinPoint.getSignature().getDeclaringTypeName(), System.currentTimeMillis(),
				joinPoint.getArgs().length > 0 ? mapper.writeValueAsString(joinPoint.getArgs()[0])
						: "No Request Parameters",
				result);

	}

	@AfterThrowing(value = "execution(* org.egov.hc.service.*.*(..)) || execution(* org.egov.hc.controller.*.*(..)) || execution(* org.egov.hc.repository.*.*(..))", throwing = "exception")
	public void afterThrowingService(JoinPoint joinPoint, Throwable exception) throws JsonProcessingException {
		log.error(
				"Hc-Services::AfterFailed::Method Name::{}, Executed Time::{}, Request Parameters::{}, Error Response::{}, Exception Details::{}",
				joinPoint.getSignature().getDeclaringTypeName(), System.currentTimeMillis(),
				joinPoint.getArgs().length > 0 ? mapper.writeValueAsString(joinPoint.getArgs()[0])
						: "No Request Parameters",
				exception.getMessage(), exception.getStackTrace());
	}

}
