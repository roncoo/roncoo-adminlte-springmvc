package com.roncoo.adminlte.util.base;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.springframework.util.StringUtils;

/**
 * 参数工具
 * 
 * @author LYQ
 *
 */
public class ParamUtil {

	/**
	 * 获取所有参数
	 * 
	 * @param request
	 * @param prefix
	 * @return
	 */
	public static Map<String, Object> getParamsMap(HttpServletRequest request, String prefix) {
		if (request == null) {
			return null;
		}
		if (prefix == null || StringUtils.hasText(prefix)) {
			prefix = "";
		}
		Map<String, Object> params = new HashMap<String, Object>();
		Enumeration<String> paramNames = request.getParameterNames();
		while (paramNames.hasMoreElements()) {
			String paramName = (String) paramNames.nextElement();
			if ("".equals(prefix) || paramName.startsWith(prefix)) {
				String name = paramName.substring(prefix.length());
				String[] values = request.getParameterValues(paramName);
				System.out.println(name);
				System.out.println(values[0]);
				if (values.length > 1) {
					params.put(name, values);
				} else {
					params.put(name, values[0]);
				}
			}
		}
		return params;
	}

	/**
	 * 返回参数url
	 * 
	 * @param request
	 * @param params
	 * @param excludeKeys
	 * @return
	 */
	public static String getParamUrl(HttpServletRequest request, Map<String, Object> params, String... excludeKeys) {
		StringBuffer url = new StringBuffer();
		url.append("?");
		if (!params.isEmpty()) {
			for (String excludeKey : excludeKeys) {
				params.remove(excludeKey);
			}
			Set<String> keySet = params.keySet();
			for (String key : keySet) {
				if (params.get(key) != null && params.get(key) != "") {
					url.append(key).append("=").append(params.get(key)).append("&");
				}
			}
		}
		System.out.println(url.toString());
		return url.toString();
	}
}
