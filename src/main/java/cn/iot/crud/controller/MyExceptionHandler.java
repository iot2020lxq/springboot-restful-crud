package cn.iot.crud.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import cn.iot.crud.exception.UserNoExistException;

/**
 * 自定义异常处理器
 * @author Administrator
 *
 */
@ControllerAdvice
public class MyExceptionHandler {

	@ExceptionHandler(UserNoExistException.class)
	public String exceptionHandler(Exception e,HttpServletRequest request) {
		Map<String,Object> map = new HashMap<String,Object>();
		request.setAttribute("javax.servlet.error.status_code", 500);//修改错误状态为500，
		map.put("code", "user.noexist");
		map.put("message","你错了，打错特错！");
		map.put("exception",e.getClass());
		request.setAttribute("ext", map);
		return "forward:/error";
	}
}
