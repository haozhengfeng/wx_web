package com.weixin.common.utils;

import java.io.IOException;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

public class XmlUtils {
    public static Map<String, String> msg2Map(String xml) throws IOException, DocumentException {
        System.out.println(xml);
        Map<String, String> maps = new HashMap<String, String>();
        Document document = DocumentHelper.parseText(xml);
        Element root = document.getRootElement();
        List<Element> eles = root.elements();
        for (Element e : eles) {
            maps.put(e.getName(), e.getTextTrim());
        }
        System.out.println(maps);
        return maps;
    }
    
    public static String map2xml(Map<String, String> map) throws IOException {
        Document d = DocumentHelper.createDocument();
        Element root = d.addElement("xml");
        
        Set<String> keys = map.keySet();
        for(String key:keys){
            root.addElement(key).addText(map.get(key));
        }
        StringWriter sw = new StringWriter();
        d.write(sw);
        
        return sw.toString();
    }
}
