package com.roncoo.adminlte.util.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class SessionInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		String redirectUrl="/roncoo-adminlte-springmvc/login";
		HttpSession session = request.getSession();
		if (session == null) {
			response.sendRedirect(redirectUrl);
			return false;
		} else {
			Object obj = session.getAttribute("roncooNo");
			if (obj == null) {
				response.sendRedirect(redirectUrl);
				return false;
			} else {
				return true;
			}
		}
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {

	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {

	}

}
