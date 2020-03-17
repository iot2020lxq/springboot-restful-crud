package cn.iot.crud.component;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.util.StringUtils;
import org.springframework.web.servlet.LocaleResolver;
/**
 * 国际化
 * @author Administrator
 *
 */
public class MyLocaleResolver implements LocaleResolver{

	@Override
	public Locale resolveLocale(HttpServletRequest request) {
		String l = request.getParameter("l");
		Locale locale = Locale.getDefault();
		if(!StringUtils.isEmpty(l)) {
			String[] split = l.split("_");
			locale = new Locale(split[0],split[1]);
			System.out.println(locale);
		}

		return locale;
	}

	@Override
	public void setLocale(HttpServletRequest arg0, HttpServletResponse arg1, Locale arg2) {
		// TODO Auto-generated method stub
		
	}

}
