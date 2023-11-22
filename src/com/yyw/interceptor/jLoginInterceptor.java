package com.yyw.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class jLoginInterceptor implements HandlerInterceptor{

	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// 在拦截点执行前拦截，如果返回true则不执行拦截点后的操作（拦截成功）
		// 返回false则不执行拦截
		HttpSession session = request.getSession();

		if (session.getAttribute("judge") != null) {
			// 登录成功不拦截
			return true;
		} else {
			// 拦截后进入登录页面
			System.out.println("评委尚未登录，请先进行登录");
			System.out.println("<script> alert('评委尚未登录，即将跳到评委登录页面')</script>");
			request.getRequestDispatcher("/WEB-INF/jsp/jLogin.jsp").forward(request, response);
			return false;
		}
	}

}
