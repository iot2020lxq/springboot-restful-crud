package cn.iot.crud.controller;

import java.util.Collection;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import cn.iot.crud.dao.EmployeeDao;
import cn.iot.crud.entities.Employee;

@Controller
public class LoginController {
	
	@Autowired
	EmployeeDao employeeDao;
	
	/**
	 * 查询所有员工
	 */
	@GetMapping("/emps")
	public String getEmps(Model model) {
		
		Collection<Employee> employees = employeeDao.getAll();
		model.addAttribute("emps", employees);
		
		return "emp/list";
	}
	
	
	/**
	 * 用户登录
	 * @param username
	 * @param password
	 * @param map
	 * @param session
	 * @return
	 */
	@PostMapping("/user/login")
	 public String login(@RequestParam("username") String username,
			 @RequestParam("password") String password,Map<String,Object> map,
			 HttpSession session) {
			
		if(!StringUtils.isEmpty(username) && "123456".equals(password)) {
			session.setAttribute("loginUser", username);
			return "redirect:/main.html";
		}else {
			map.put("error", "用户名或密码错误！");
			return "login";
		}
	 }
}
