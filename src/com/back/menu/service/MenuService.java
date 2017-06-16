package com.back.menu.service;

import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.back.menu.domain.Menu;
import com.common.WeiXinError;
import com.common.WeiXinContext;
import com.common.utils.HttpClientUtils;
import com.common.utils.LoggerUtils;

@Service
public class MenuService {
    
    public WeiXinError createMenu(Menu menu){
        String json = JSONObject.toJSONString(menu);
        String url = WeiXinContext.MENU_CREATE;
        url = url.replace("ACCESS_TOKEN",WeiXinContext.getAccessToken().getAccess_token());
        WeiXinError resp =  HttpClientUtils.sendHttpPost(url, json,WeiXinError.class);
        
        return resp;
    }
    
    
    public Menu getMenu(){
        String url = WeiXinContext.MENU_GET;
        url = url.replace("ACCESS_TOKEN",WeiXinContext.getAccessToken().getAccess_token());
        LoggerUtils.debug(MenuService.class, "menu:"+HttpClientUtils.sendHttpGet(url));
        Menu menu = HttpClientUtils.sendHttpGet(url, Menu.class);
        return menu;
    }
    
    public WeiXinError deleteMenu(){
        String url = WeiXinContext.MENU_DELETE;
        url = url.replace("ACCESS_TOKEN",WeiXinContext.getAccessToken().getAccess_token());
        WeiXinError resp =  HttpClientUtils.sendHttpGet(url,WeiXinError.class);
        return resp;
    }
    
    
    public String addConditional(Menu menu){
        String json = JSONObject.toJSONString(menu);
        String url = WeiXinContext.MENU_ADDCONDITIONAL;
        url = url.replace("ACCESS_TOKEN",WeiXinContext.getAccessToken().getAccess_token());
        return HttpClientUtils.sendHttpPost(url, json);
    }
    
    public WeiXinError delConditional(){
        String url = WeiXinContext.MENU_DELCONDITIONAL;
        url = url.replace("ACCESS_TOKEN",WeiXinContext.getAccessToken().getAccess_token());
        WeiXinError resp =  HttpClientUtils.sendHttpPost(url,null,WeiXinError.class);
        return resp;
    }
    
    public WeiXinError trymatch(){
        String url = WeiXinContext.MENU_TRYMATCH;
        url = url.replace("ACCESS_TOKEN",WeiXinContext.getAccessToken().getAccess_token());
        WeiXinError resp =  HttpClientUtils.sendHttpPost(url,"",WeiXinError.class);
        return resp;
    }

}
