package com.web.user;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.common.utils.LoggerUtils;
import com.web.user.domain.UserInfo;
import com.web.user.service.IUserService;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    IUserService userService;
    
    @RequestMapping(value="/login",method=RequestMethod.GET)
    public String tologin(HttpServletRequest request){
        String ua = request.getHeader("user-agent").toLowerCase();  
        // 是微信浏览器
        if (ua.indexOf("micromessenger") > 0) {
            LoggerUtils.debug(getClass(), "访问登录页面，如果是微信浏览器，直接重定向到微信授权页面");
            return "redirect:/wxuser/towxautho";
        }
        return "login";
    }
    
    @RequestMapping(value="/logout",method=RequestMethod.GET)
    public String logout(){
        userService.logout();
        return "redirect:/";
    }
    
    @RequestMapping(value="/login",method=RequestMethod.POST)
    public String login(){
        UserInfo userInfo = new UserInfo();
        userInfo.setName("hao");
        userInfo.setPassword("123");
        userService.login(userInfo);
        return "redirect:/";
    }
    
}
