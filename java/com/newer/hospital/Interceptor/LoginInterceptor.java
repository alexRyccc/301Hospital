package com.newer.hospital.Interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.newer.hostipal.pojo.ManagerInfo;

@Component
public class LoginInterceptor implements HandlerInterceptor{
	
	private static final Logger log = LoggerFactory.getLogger(LoginInterceptor.class);

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		log.info("调用了preHandle......");
		ManagerInfo user =(ManagerInfo) request.getSession().getAttribute("user");
		System.out.println("URL:"+request.getRequestURI());
		if(request.getRequestURI().equals("/img")||request.getRequestURI().equals("/register")) {
			return true;
		} 
		if(request.getRequestURI().equals("/index.html") || request.getRequestURI().equals("/changepwd.html")||
				request.getRequestURI().endsWith(".css")||request.getRequestURI().endsWith(".js")
				||request.getRequestURI().endsWith(".jpg")||request.getRequestURI().endsWith(".png")||
				request.getRequestURI().endsWith(".woff"))
        {
			
			log.info("通过");
            return true;
        }
		
		if(user==null) {
			log.info("权限不足，无法访问，请登录");
			response.sendRedirect(request.getContextPath()+"/index.html");
			return false;
		}
			log.info("权限验证通过");
		
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		log.info("调用了postHandle方法...");
		HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		log.info("调用了afterCompletion方法...");
		HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
	}
		

}
