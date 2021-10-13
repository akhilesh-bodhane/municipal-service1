package org.egov.ec.config;

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

	@Before("execution(* org.egov.ec.service.*.*(..)) || execution(* org.egov.ec.web.controllers.*.*(..)) || execution(* org.egov.ec.repository.*.*(..))")
	public void beforeService(JoinPoint joinPoint) throws JsonProcessingException {
		log.info("Echallan-Services::Before::Method Name::{}, Executed Time::{}",
				joinPoint.getSignature().getDeclaringTypeName(), System.currentTimeMillis());
		log.debug("Echallan-Services::Before::Method Name::{}, Executed Time::{}, Request Parameters::{}",
				joinPoint.getSignature().getDeclaringTypeName(), System.currentTimeMillis(),
				joinPoint.getArgs().length > 0 ? mapper.writeValueAsString(joinPoint.getArgs()[0])
						: "No Request Parameters");
	}

	@After("execution(* org.egov.ec.service.*.*(..)) || execution(* org.egov.ec.web.controllers.*.*(..)) || execution(* org.egov.ec.repository.*.*(..))")
	public void afterService(JoinPoint joinPoint) throws JsonProcessingException {
		log.info("Echallan-Services::After::Method Name::{}, Executed Time::{}",
				joinPoint.getSignature().getDeclaringTypeName(), System.currentTimeMillis());
		log.debug("Echallan-Services::After::Method Name::{}, Executed Time::{}, Request Parameters::{}",
				joinPoint.getSignature().getDeclaringTypeName(), System.currentTimeMillis(),
				joinPoint.getArgs().length > 0 ? mapper.writeValueAsString(joinPoint.getArgs()[0])
						: "No Request Parameters");
	}

	@AfterReturning(value = "execution(* org.egov.ec.service.*.*(..)) || execution(* org.egov.ec.web.controllers.*.*(..)) || execution(* org.egov.ec.repository.*.*(..))", returning = "result")
	public void afterReturningService(JoinPoint joinPoint, Object result) throws JsonProcessingException {
		log.info("Echallan-Services::AfterReturning::Method Name::{}, Executed Time::{}",
				joinPoint.getSignature().getDeclaringTypeName(), System.currentTimeMillis());
		log.debug(
				"Echallan-Services::AfterReturning::Method Name::{}, Executed Time::{}, Request Parameters::{}, Response::{}",
				joinPoint.getSignature().getDeclaringTypeName(), System.currentTimeMillis(),
				joinPoint.getArgs().length > 0 ? mapper.writeValueAsString(joinPoint.getArgs()[0])
						: "No Request Parameters",
				result);

	}

	@AfterThrowing(value = "execution(* org.egov.ec.service.*.*(..)) || execution(* org.egov.ec.web.controllers.*.*(..)) || execution(* org.egov.ec.repository.*.*(..))", throwing = "exception")
	public void afterThrowingService(JoinPoint joinPoint, Throwable exception) throws JsonProcessingException {
		log.error(
				"Echallan-Services::AfterFailed::Method Name::{}, Executed Time::{}, Request Parameters::{}, Error Response::{}, Exception Details::{}",
				joinPoint.getSignature().getDeclaringTypeName(), System.currentTimeMillis(),
				joinPoint.getArgs().length > 0 ? mapper.writeValueAsString(joinPoint.getArgs()[0])
						: "No Request Parameters",
				exception.getMessage(), exception.getStackTrace());
	}

}
