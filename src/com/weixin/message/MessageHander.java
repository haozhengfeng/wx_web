package com.weixin.message;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.weixin.common.WeiXinContext;
import com.weixin.common.utils.XmlUtils;

public class MessageHander {

    private static Map<String, String> replyMsgs = new HashMap<String, String>();

    static {

        replyMsgs.put("你好", "您好！");
    }

    public static String handerMap(Map<String, String> msg) throws IOException {
        String mapType = msg.get("MsgType");
        if (mapType.equals(WeiXinContext.MSG_EVENT_TYPE)) {
            return textTypeHandler(msg);
        } else if (mapType.equals(WeiXinContext.MSG_TEXT_TYPE)) {
            return textTypeHandler(msg);
        }

        return null;
    }

    private static String textTypeHandler(Map<String, String> msg) throws IOException {
        Map<String, String> map = new HashMap<String, String>();
        map.put("ToUserName", msg.get("FromUserName"));
        map.put("FromUserName", msg.get("ToUserName"));
        map.put("CreateTime", new Date().getTime()+"");
        map.put("MsgType", "text");
        String replyContent = "你请求的消息不正确"; 
        
        String content = msg.get("Content");
        if(replyMsgs.containsKey(content)){
            replyContent = replyMsgs.get(content);
        }
        map.put("Content", replyContent);
        return XmlUtils.map2xml(map);
    }

}
