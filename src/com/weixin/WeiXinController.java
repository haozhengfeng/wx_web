package com.weixin;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.common.utils.LoggerUtils;

@Controller
public class WeiXinController {

    
    @RequestMapping(value = "/")
    public String index(HttpServletRequest request,HttpServletResponse response){
//    	String ua = request.getHeader("user-agent").toLowerCase();  
//    	if (ua.indexOf("micromessenger") > 0) {// 是微信浏览器
//    		LoggerUtils.debug(getClass(), "访问登录页面，如果是微信浏览器，直接重定向到微信授权页面");
//            return "redirect:/wxuser/towxautho";
//    	}
        return "index";
    }

}
