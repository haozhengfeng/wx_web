package com.web.user.service;

import com.web.user.domain.UserInfo;

/**
 * 用户基础接口
 * @author Administrator
 *
 */
public interface IUserService {
    
    public boolean check(String username,String password);
    
    /**
     * 获取当前用户
     */
    public UserInfo currentUser();
    
    /**
     * 用户登录
     */
    public void login(UserInfo userInfo);
    
    /**
     * 用户退出
     */
    public void logout();

}
