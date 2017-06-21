package com.weixin.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.common.utils.LoggerUtils;
import com.web.user.domain.UserInfo;
import com.web.user.service.IUserService;
import com.weixin.autho.domain.WXUserInfo;
/**
 * 微信浏览器  拦截器
 * @author Administrator
 *
 */
public class WXInterceptor implements HandlerInterceptor {

    @Autowired
    IUserService userService;
    
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
			Object handlar) throws Exception {
	    WXUserInfo userInfo = (WXUserInfo)userService.currentUser();
        if(userInfo == null || userInfo.getOpenid()==null){
        	String ua = request.getHeader("user-agent").toLowerCase();  
        	// 是微信浏览器
        	if (ua.indexOf("micromessenger") > 0) {
        		LoggerUtils.debug(getClass(), "微信浏览器拦截：用户没有登录");
                response.sendRedirect(request.getContextPath()+"/wxuser/towxautho");
        	}else{
        		LoggerUtils.debug(getClass(), "非微信浏览器拦截：用户没有登录");
                response.sendRedirect(request.getContextPath());
        	}
            return false;  
        }
        
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
