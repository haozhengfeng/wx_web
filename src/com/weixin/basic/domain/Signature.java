package com.weixin.basic.domain;

import java.util.Arrays;

import com.weixin.common.WeiXinContext;
import com.weixin.common.utils.SecurtityUtils;


//signature 微信加密签名，signature结合了开发者填写的token参数和请求中的timestamp参数、nonce参数。
// timestamp 时间戳
// nonce 随机数
// echostr 随机字符串

// 1）将token、timestamp、nonce三个参数进行字典序排序
// 2）将三个参数字符串拼接成一个字符串进行sha1加密
// 3）开发者获得加密后的字符串可与signature对比，标识该请求来源于微信

// 若确认此次GET请求来自微信服务器，请原样返回echostr参数内容，则接入生效，成为开发者成功，否则接入失败。
public class Signature {
    private String signature;

    private String timestamp;
    
    private String nonce;

    private String echostr;

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getNonce() {
        return nonce;
    }

    public void setNonce(String nonce) {
        this.nonce = nonce;
    }

    public String getEchostr() {
        return echostr;
    }

    public void setEchostr(String echostr) {
        this.echostr = echostr;
    }
    
    public String sha1(){
        String[] arrs = { WeiXinContext.TOKEN, getTimestamp(), getNonce() };
        Arrays.sort(arrs);

        StringBuffer sb = new StringBuffer();
        for (String s : arrs) {
            sb.append(s);
        }
        return SecurtityUtils.sha1(sb.toString());
    }
}
