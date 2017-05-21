package com.weixin.message;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import com.weixin.common.utils.XmlUtils;


public class MessageXmlHander {

    public static Map<String, String> msg2Map(HttpServletRequest req) throws IOException, DocumentException {
        String xml = getMsg(req);
        return XmlUtils.msg2Map(xml);
    }

    public static String getMsg(HttpServletRequest req) throws IOException {
        BufferedReader br = null;
        br = new BufferedReader(new InputStreamReader(req.getInputStream(), "utf-8"));

        String str = null;
        StringBuffer sb = new StringBuffer();
        while ((str = br.readLine()) != null) {
            sb.append(str);
        }

        return sb.toString();
    }
    
    
    
    
}
