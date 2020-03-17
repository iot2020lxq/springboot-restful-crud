package cn.iot.crud.component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
/**
 * 配置拦截器
 * @author Administrator
 *
 */
public class LoginHandlerInterecptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		Object attribute = request.getSession().getAttribute("loginUser");
		if(attribute == null) {
			request.setAttribute("error", "你的权限不足！");
			request.getRequestDispatcher("/index.html").forward(request, response);
			//response.sendRedirect("/crud/index.html");
			return false;
		}else { 
			return true;
		}
	}
}
