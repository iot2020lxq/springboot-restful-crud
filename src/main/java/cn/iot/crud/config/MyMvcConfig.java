package cn.iot.crud.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import cn.iot.crud.component.MyErrorAttributes;
import cn.iot.crud.component.MyLocaleResolver;

@Configuration   //继承了WebMvcConfigurationSupport类后，自动配置类失效
public class MyMvcConfig implements WebMvcConfigurer {

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		// TODO Auto-generated method stub
		WebMvcConfigurer.super.addViewControllers(registry);
		registry.addViewController("/").setViewName("login");
		registry.addViewController("/index.html").setViewName("login");
		registry.addViewController("/main.html").setViewName("dashboard");
	}

		 
	 /**
	  *   继承了WebMvcConfigurationSupport类后
	  *   需要配置静态资源
	  */
/*	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		super.addResourceHandlers(registry);
		registry.addResourceHandler("/**")
		.addResourceLocations("classpath:/static/");
		
		//webjars，这个可配可不配
		registry.addResourceHandler("/webjars/**")
		.addResourceLocations("/webjars/");
	}*/

	/**
	 * 拦截器
	 */
	/* @Override
	public void addInterceptors(InterceptorRegistry registry) {
		super.addInterceptors(registry);
		registry.addInterceptor(new LoginHandlerInterecptor())
		.addPathPatterns("/**")//拦截所有
		//.excludePathPatterns("/","/index.html","/user/login");
		.excludePathPatterns("/","/index.html","/user/login","/asserts/**","/webjars/**");//这是你不拦截的部分
	}
	*/
	//国际化
	@Bean
	public MyLocaleResolver localeResolver() {
		return new MyLocaleResolver();
	}
	
	//异常
	@Bean
	public MyErrorAttributes myErrorAttributes() {
	
		return new MyErrorAttributes();
	}
}
