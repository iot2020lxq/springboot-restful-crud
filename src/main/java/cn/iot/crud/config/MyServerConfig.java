package cn.iot.crud.config;

import java.util.Arrays;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import cn.iot.crud.filter.MyFilter;
import cn.iot.crud.listener.MyListener;
import cn.iot.crud.servlet.MyServlet;

@Configuration
public class MyServerConfig {

	/**
	 * 注册servlet
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	@Bean
	public ServletRegistrationBean myServlet() {
		@SuppressWarnings("unchecked")
		ServletRegistrationBean resistBean = new ServletRegistrationBean(new MyServlet(),"/myServlet");
		return resistBean;
	}
	
	/**
	 * 注册filter
	 * @return
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Bean
	public FilterRegistrationBean myFilter(){
		FilterRegistrationBean registrationBean = new FilterRegistrationBean<>();
		registrationBean.setFilter(new MyFilter());
		registrationBean.setUrlPatterns(Arrays.asList("/myServlet","/myFilter"));
		return registrationBean;
	}
	
	/**
	 * 注册listner
	 * @return
	 */
	@Bean
	public ServletListenerRegistrationBean<MyListener> myListener(){
		ServletListenerRegistrationBean<MyListener> bean = new ServletListenerRegistrationBean<>(new MyListener());
		return bean;
	}
}
