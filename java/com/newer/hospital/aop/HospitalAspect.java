package com.newer.hospital.aop;

import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Component
@Aspect
@Order(4)
public class HospitalAspect {
	
	private static final Logger log = LoggerFactory.getLogger(HospitalAspect.class);

	@Pointcut( "execution(public * com.newer.*.controller.*.*(..))" )//自定义接口
	public void weblog() {
		
	}
//	
	@Before("weblog()")
	public void doBefore(JoinPoint jp) {
		log.info("前置通知...");
		RequestAttributes ras =RequestContextHolder.getRequestAttributes();
		ServletRequestAttributes sras =(ServletRequestAttributes) ras;
		HttpServletRequest req =sras.getRequest(); 
		log.info("URL:{}",req.getRequestURI().toString());
		log.info("HTTP_METHOD:{}",req.getMethod());
//		log.info("IP:{}",req.getRemoteAddr());
//		log.info("CLASS_METHOD:{}",jp.getSignature().getDeclaringTypeName());
//		log.info("ARGS:{}",Arrays.toString(jp.getArgs())); 
	}
	@AfterReturning(returning="rtn",pointcut="weblog()")//后置通知
	public void doAfter(Object rtn) {
		log.info("后置通知...");
		log.info("返回值:"+rtn);
	}
}
