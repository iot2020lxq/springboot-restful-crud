package cn.iot.crud.component;

import java.util.Map;

import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.WebRequest;
/**
 * 自定义解析异常处理器
 * @author Administrator
 *
 */
@Component
public class MyErrorAttributes extends DefaultErrorAttributes {


	@Override
	public Map<String, Object> getErrorAttributes(WebRequest webRequest, boolean includeStackTrace) {
		Map<String, Object> map = super.getErrorAttributes(webRequest, includeStackTrace);
		map.put("company", "iot");
		@SuppressWarnings("unchecked")
		//0代表request域，1代表session域
		Map<String,Object> ext = (Map<String, Object>) webRequest.getAttribute("ext", 0);
		map.put("ext", ext);
		return map;
	}
}
