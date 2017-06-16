package com.weixin.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.common.utils.LoggerUtils;
import com.weixin.autho.domain.WXUserInfo;

public class WXInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
			Object handlar) throws Exception {
		WXUserInfo wxUserInfo =  (WXUserInfo)request.getSession().getAttribute("wxUserInfo");   
        if(wxUserInfo == null || wxUserInfo.getOpenid()==null){
        	String ua = request.getHeader("user-agent").toLowerCase();  
        	if (ua.indexOf("micromessenger") > 0) {// 是微信浏览器
        		LoggerUtils.debug(getClass(), "微信浏览器拦截：用户没有登录");
//                request.getRequestDispatcher("/towxautho").forward(request, response);
                response.sendRedirect(request.getContextPath()+"/towxautho");
        	}else{
        		LoggerUtils.debug(getClass(), "非微信浏览器拦截：用户没有登录");
                response.sendRedirect(request.getContextPath());
        	}
            return false;  
        }else  
            return true;    
	}
	

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response,
			Object handlar, ModelAndView arg3) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handlar, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
	}

}
