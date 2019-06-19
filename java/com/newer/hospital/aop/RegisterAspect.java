//package com.newer.hospital.aop;
//
//import java.io.IOException;
//import java.util.Arrays;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//
//import org.aspectj.lang.JoinPoint;
//
//import org.aspectj.lang.annotation.Aspect;
//import org.aspectj.lang.annotation.Before;
//import org.aspectj.lang.annotation.Pointcut;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.core.annotation.Order;
//import org.springframework.stereotype.Component;
//import org.springframework.web.context.request.RequestAttributes;
//import org.springframework.web.context.request.RequestContextHolder;
//import org.springframework.web.context.request.ServletRequestAttributes;
//
//import com.newer.hostipal.pojo.ManagerInfo;
//
//@Component
//@Aspect
//@Order(1)
//public class RegisterAspect {
//	
//	private static final Logger log = LoggerFactory.getLogger(RegisterAspect.class);
//
//	@Pointcut( "execution(public * com.newer.*.controller.ArrangeController.*(..))" )//自定义接口
//	public void weblogs() {
//		
//	}
//	
//	@Before("weblogs()")
//	public void  doBefore(JoinPoint jp) throws IOException {
//		log.info("权限验证...");
//		RequestAttributes ras =RequestContextHolder.getRequestAttributes();
//		HttpServletRequest request =((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest(); 
//
//        HttpSession session =request.getSession();  
//
//		ManagerInfo user = (ManagerInfo) session.getAttribute("user"); 
//		  HttpServletResponse response = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getResponse();
//		     
//		System.out.println("user--------------------:"+user);
//		
//	
//	
//		if(user==null) {
//			log.info("权限不足，无法排班，请登录");
//			response.sendRedirect(request.getContextPath()+"/index.html");
//	
//		}else {
//			log.info("登录成功");
//		}
//		
//	}
//	
//}
