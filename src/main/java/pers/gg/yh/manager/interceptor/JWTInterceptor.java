package pers.gg.yh.manager.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;

import pers.gg.yh.manager.common.util.JWTUtil;

public class JWTInterceptor implements HandlerInterceptor {
	private static final String AUTHORIZATION = "authorization";

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		String token = request.getHeader(AUTHORIZATION);
		JWTUtil.verify(token);
		return true;
	}

}
