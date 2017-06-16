package com.back.basic.service;

import org.springframework.stereotype.Service;

import com.back.basic.domain.WXServer;
import com.common.WeiXinContext;
import com.common.utils.HttpClientUtils;

@Service
public class WXServerService {

    public WXServer ip(){
        String url = WeiXinContext.WX_SERVER_IP;
        url = url.replaceAll("ACCESS_TOKEN", WeiXinContext.getAccessToken().getAccess_token());
        return HttpClientUtils.sendHttpGet(url, WXServer.class);
    }
    
}
