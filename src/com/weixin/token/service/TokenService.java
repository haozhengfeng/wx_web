package com.weixin.token.service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.weixin.common.WeiXinContext;
import com.weixin.common.utils.HttpClientUtils;
import com.weixin.token.domain.AccessToken;

@Service
public class TokenService {
    
    public AccessToken token(){
        String url = WeiXinContext.ACCESS_TOKEN_URL;
        url = url.replaceAll("APPID", WeiXinContext.APPID);
        url = url.replaceAll("APPSECRET", WeiXinContext.APPSECRT);
        return HttpClientUtils.sendHttpGet(url,AccessToken.class);
    }

    // 每5秒执行一次
    @Scheduled(fixedRate = 1000 * 7000)
    public void retoken() {
        WeiXinContext.setAccessToken(token());
    }

}
