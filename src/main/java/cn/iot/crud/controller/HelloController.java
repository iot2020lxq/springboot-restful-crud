package cn.iot.crud.controller;

import java.util.Arrays;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.iot.crud.exception.UserNoExistException;

@Controller
public class HelloController {
	
/*	@RequestMapping({"/","/index.html"})
	public String index() {
		
		return "login";
	}
	*/
	@ResponseBody
	@RequestMapping("/test")
	public String test(@RequestParam("str") String str) {
		if(str.equals("aaa")) {
			throw new UserNoExistException();
		}
		return "hello word";
	}
	

	@RequestMapping("hello")
	public String test(Map<String,Object> map) {
		
		map.put("hello", "<h1>你好</h1>");
		map.put("users", Arrays.asList("张三","lisi","wangwu"));
		return "success";
	}
}
