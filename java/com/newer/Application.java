package com.newer;

import java.util.HashMap;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.Servlet;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.newer.hospital.Interceptor.LoginInterceptor;
@EnableCaching
@SpringBootApplication
@MapperScan(basePackages = { "com.newer" })
public class Application implements WebMvcConfigurer{

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		HandlerInterceptor handle =new LoginInterceptor();
		registry.addInterceptor(handle);
		//excludePathPatterns("changepwd.html", "index.html");
	}
//	@Bean
//	public ServletRegistrationBean<Servlet> createServler(){
//		ServletRegistrationBean<Servlet>  srb =new ServletRegistrationBean<Servlet>();
//		//设置Servlet相关的参数
//		Servlets se =new Servlets();
//		srb.setServlet(se);
//		srb.addUrlMappings("/hi","/hello");
//		return srb;
//		
//	}
//	@Bean
//	public FilterRegistrationBean<Filter> createFilter(){
//		FilterRegistrationBean<Filter>  frb =FilterRegistrationBean<Filter>();
//		frb.setFilter(filter);
//		List<String> url =new ArrayList<>();
//		url.add("/*");
//		frb.setUrlPatterns(urlPatterns);
//		return null;
//		
//	}

}
