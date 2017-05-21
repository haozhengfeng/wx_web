package com.weixin.test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.junit.Test;

import com.alibaba.fastjson.JSONObject;
import com.weixin.common.WeiXinContext;
import com.weixin.common.utils.HttpClientUtils;
import com.weixin.media.MediaKit;
import com.weixin.menu.domain.Button;
import com.weixin.menu.domain.Menu;
import com.weixin.token.domain.AccessToken;

public class TestWerixin {

    @Test
    public void testHttpClient() {
        try {
            CloseableHttpClient client = HttpClients.createDefault();
            HttpGet get = new HttpGet("http://www.konghao.org");
            CloseableHttpResponse resp = client.execute(get);
            int statusCode = resp.getStatusLine().getStatusCode();
            if (statusCode >= 200 && statusCode < 300) {
                HttpEntity entity = resp.getEntity();
                String content = EntityUtils.toString(entity);
                System.out.println(content);
            }
        } catch (ClientProtocolException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @Test
    public void token() {
        
        String url = WeiXinContext.ACCESS_TOKEN_URL;
        url = url.replaceAll("APPID", WeiXinContext.APPID);
        url = url.replaceAll("APPSECRET", WeiXinContext.APPSECRT);
        
        System.out.println(HttpClientUtils.sendHttpGet(url,AccessToken.class));
        
//        CloseableHttpClient client = null;
//        HttpGet get = null;
//        CloseableHttpResponse resp = null;
//        try {
//            client = HttpClients.createDefault();
//            
//            get = new HttpGet(url);
//            resp = client.execute(get);
//            int statusCode = resp.getStatusLine().getStatusCode();
//            if (statusCode >= 200 && statusCode < 300) {
//                HttpEntity entity = resp.getEntity();
//                String content = EntityUtils.toString(entity);
//                System.out.println(content);
//                AccessToken accessToken = JSONObject.parseObject(content, AccessToken.class);
//                WeiXinContext.setAccessToken(accessToken);
//            }
//        } catch (ClientProtocolException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        } catch (ParseException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        } catch (IOException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        } finally {
//            if (resp != null) {
//                try {
//                    resp.close();
//                } catch (IOException e) {
//                    // TODO Auto-generated catch block
//                    e.printStackTrace();
//                }
//            }
//
//            if (client != null) {
//                try {
//                    client.close();
//                } catch (IOException e) {
//                    // TODO Auto-generated catch block
//                    e.printStackTrace();
//                }
//            }
//        }

    }

    @Test
    public void testMenu() {

        List<Button> bs = new ArrayList<Button>();

        Button b1 = new Button();
        b1.setName("学习");
        b1.setType("view");
        b1.setUrl("http://www.baidu.com");
        bs.add(b1);

        List<Button> b2Subs = new ArrayList<Button>();
        Button b2 = new Button();
        b2.setName("测试资源");

        Button b2Sub = new Button();
        b2Sub.setKey("A0001");
        b2Sub.setName("事件测试");
        b2Sub.setType("click");
        b2Subs.add(b2Sub);

        b2Sub = new Button();
        b2Sub.setKey("rselfmenu_0_0");
        b2Sub.setName("扫描测试");
        b2Sub.setType("scancode_waitmsg");
        b2Subs.add(b2Sub);
        b2.setSub_button(b2Subs);
        bs.add(b2);
        
        Menu menu = new Menu();
        menu.setButton(bs);

        String json = JSONObject.toJSONString(menu);

        System.out.println(json);
        
        try {
            
            CloseableHttpClient client = HttpClients.createDefault();
            String url = WeiXinContext.MENU_CREATE;
            url = url.replace("ACCESS_TOKEN","TRvSojurY2oWPq5D5Dp_ruxjkrYZ6dEq1fZRP4nxzlvXL8DE6a2R18uMBcJlbnmxLnauOJnp04oROeIthdCFSRr-9nE0El__AEtaBu20rZPdG2m8Vq00Ztw6i9z-rPSjQFIdADACRU");

            HttpPost post = new HttpPost(url);
            post.addHeader("Content-Type", "application/json");
            StringEntity entity = new StringEntity(json, ContentType.create("application/json", "utf-8"));
            post.setEntity(entity);
            CloseableHttpResponse response = client.execute(post);
            int sc = response.getStatusLine().getStatusCode();
            if (sc >= 200 && sc < 300) {
                System.out.println(EntityUtils.toString(response.getEntity()));
            }

        } catch (ClientProtocolException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
    
    @Test
    public void testPostMedia(){
        MediaKit.postMedia("d:/123.gif", "image");
    }
}
