package com.weixin.basic.service;

import org.springframework.stereotype.Service;

import com.weixin.basic.domain.WXServer;
import com.weixin.common.WeiXinContext;
import com.weixin.common.utils.HttpClientUtils;

@Service
public class WXServerService {

    public WXServer ip(){
        String url = WeiXinContext.WX_SERVER_IP;
        url = url.replaceAll("ACCESS_TOKEN", WeiXinContext.getAccessToken().getAccess_token());
        return HttpClientUtils.sendHttpGet(url, WXServer.class);
    }
    
}
