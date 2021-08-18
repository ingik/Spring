package com.mvc.upgrade.common.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class LoginInterceptor implements HandlerInterceptor{
	private Logger logger = LoggerFactory.getLogger(LoginInterceptor.class);
	//controller 실행 요청 전에 수행되는 메소드
	//return 값으로 boolean값을 전달, false인 경우 controller를 실행 시키지 않고 요청 종료
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		if(request.getRequestURI().contains("/loginform.do")
			||request.getRequestURI().contains("/ajaxlogin.do")
			||request.getSession().getAttribute("login")!=null 
			||request.getRequestURI().contains("/test.do")
			||request.getRequestURI().contains("/registerform.do")
			||request.getRequestURI().contains("/register.do")) {
			return true;
		}
		if(request.getSession().getAttribute("login")==null) {
			response.sendRedirect("loginform.do");
			return false;
		}
		return false;
	}
	//view단에서 forward되기 전에 수행
	//controller 단에서 에러 발생시 해당 메소드는 수행되지 않는다
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		logger.info("[interceptor] : postHandle");
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		logger.info("[interceptor] : afterCompletion");
	}

}
