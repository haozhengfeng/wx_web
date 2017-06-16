package com.back.token.service;

import org.springframework.stereotype.Service;

import com.back.token.domain.AccessToken;
import com.common.WeiXinContext;
import com.common.utils.HttpClientUtils;

@Service
public class TokenService {
    
    public AccessToken token(){
        String url = WeiXinContext.ACCESS_TOKEN_URL;
        url = url.replaceAll("APPID", WeiXinContext.APPID);
        url = url.replaceAll("APPSECRET", WeiXinContext.APPSECRT);
        return HttpClientUtils.sendHttpGet(url,AccessToken.class);
    }

    public void retoken() {
        WeiXinContext.setAccessToken(token());
    }
    

}
