package com.weixin.menu.service;


import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.weixin.common.RespBody;
import com.weixin.common.WeiXinContext;
import com.weixin.common.utils.HttpClientUtils;
import com.weixin.menu.domain.Button;
import com.weixin.menu.domain.Matchrule;
import com.weixin.menu.domain.Menu;

@Service
public class MenuService {
    
    public RespBody createMenu(Menu menu){
        String json = JSONObject.toJSONString(menu);
        String url = WeiXinContext.MENU_CREATE;
        url = url.replace("ACCESS_TOKEN",WeiXinContext.getAccessToken().getAccess_token());
        RespBody resp =  HttpClientUtils.sendHttpPost(url, json,RespBody.class);
        
        return resp;
    }
    
    
    public Menu getMenu(){
        String url = WeiXinContext.MENU_GET;
        url = url.replace("ACCESS_TOKEN",WeiXinContext.getAccessToken().getAccess_token());
        System.out.println(HttpClientUtils.sendHttpGet(url));
        Menu menu = HttpClientUtils.sendHttpGet(url, Menu.class);
        return menu;
    }
    
    public RespBody deleteMenu(){
        String url = WeiXinContext.MENU_DELETE;
        url = url.replace("ACCESS_TOKEN",WeiXinContext.getAccessToken().getAccess_token());
        RespBody resp =  HttpClientUtils.sendHttpGet(url,RespBody.class);
        return resp;
    }
    
    
    public String addConditional(Menu menu){
        String json = JSONObject.toJSONString(menu);
        String url = WeiXinContext.MENU_ADDCONDITIONAL;
        url = url.replace("ACCESS_TOKEN",WeiXinContext.getAccessToken().getAccess_token());
        return HttpClientUtils.sendHttpPost(url, json);
    }
    
    public RespBody delConditional(){
        String url = WeiXinContext.MENU_DELCONDITIONAL;
        url = url.replace("ACCESS_TOKEN",WeiXinContext.getAccessToken().getAccess_token());
        RespBody resp =  HttpClientUtils.sendHttpPost(url,null,RespBody.class);
        return resp;
    }
    
    public RespBody trymatch(){
        String url = WeiXinContext.MENU_TRYMATCH;
        url = url.replace("ACCESS_TOKEN",WeiXinContext.getAccessToken().getAccess_token());
        RespBody resp =  HttpClientUtils.sendHttpPost(url,"",RespBody.class);
        return resp;
    }

}
