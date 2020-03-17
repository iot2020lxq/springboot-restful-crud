package cn.iot.crud.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import cn.iot.crud.component.LoginHandlerInterecptor;
import cn.iot.crud.component.MyLocaleResolver;

//@Configuration
public class MyConfig extends WebMvcConfigurerAdapter {

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		super.addViewControllers(registry);
		registry.addViewController("/iot").setViewName("success");
	}
	
	//所有的WebMvcConfigurerAdapter组件都会一起起作用，所以要加一个bean
	@Bean
	public WebMvcConfigurerAdapter webMvcConfigurerAdapter() {
		@SuppressWarnings("deprecation")
		WebMvcConfigurerAdapter adapter = new WebMvcConfigurerAdapter() {
			@Override
			public void addViewControllers(ViewControllerRegistry registry) {
				super.addViewControllers(registry);
				registry.addViewController("/").setViewName("login");
				registry.addViewController("/index.html").setViewName("login");
				registry.addViewController("/main.html").setViewName("dashboard");
			}
			
		/*	@Override
			public void addResourceHandlers(ResourceHandlerRegistry registry) {
				//super.addResourceHandlers(registry);
				
			}*/
			
			//配置拦截器
		/*	@Override
			public void addInterceptors(InterceptorRegistry registry) {
				super.addInterceptors(registry);
				registry.addInterceptor(new LoginHandlerInterecptor())
				.addPathPatterns("/**")//拦截所有
				.excludePathPatterns("/","/index.html","/user/login");//这是你不拦截的部分
			}*/
		};
		return adapter;
	}
	
	//国际化
	@Bean
	public LocaleResolver localeResolver() {
		return new MyLocaleResolver();
	}
}
