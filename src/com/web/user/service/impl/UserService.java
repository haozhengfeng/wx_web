package com.web.user.service.impl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.user.domain.UserInfo;
import com.web.user.service.IUserService;

/**
 * 用户基础实现类 
 * 基于拦截器 session
 * @author Administrator
 *
 */
@Service("userService")
public class UserService implements IUserService{
    
    public static final String SESSION_USER="userinfo";
    
    @Autowired  
    private HttpSession session;  
      
    @Autowired  
    private HttpServletRequest request;  
    
    @Override
    public UserInfo currentUser() {
        return (UserInfo)session.getAttribute(SESSION_USER);
    }

    @Override
    public void login(UserInfo userInfo) {
        if(check("hao", "123")){
            session.setAttribute(SESSION_USER,userInfo);
        }
    }

    @Override
    public void logout() {
        session.removeAttribute(SESSION_USER);
    }

    @Override
    public boolean check(String username, String password) {
        // TODO Auto-generated method stub
        return true;
    }
    
   
}
