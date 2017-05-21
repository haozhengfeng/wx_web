package com.weixin.basic;

import java.io.IOException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.dom4j.DocumentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.weixin.basic.domain.Signature;
import com.weixin.basic.service.WXServerService;
import com.weixin.menu.service.MenuService;
import com.weixin.message.MessageHander;
import com.weixin.message.MessageXmlHander;
import com.weixin.token.service.TokenService;

@Controller
public class WeiXinController {

    @Autowired
    private TokenService tokenService;
    
    @Autowired
    private WXServerService wxServerService;
    
    @Autowired
    private MenuService menuService;
    
    @RequestMapping(value = "/wget", method = RequestMethod.GET)
    public void init(Signature signature,HttpServletRequest req, HttpServletResponse resp) throws IOException {
        if (signature.sha1().equals(signature.getSignature())) {
            resp.getWriter().println(signature.getEchostr());
        }
    }

    @RequestMapping(value = "/wget", method = RequestMethod.POST)
    public void getInfo(HttpServletRequest req, HttpServletResponse resp) throws IOException, DocumentException {
        Map<String, String> msg = MessageXmlHander.msg2Map(req);
        String respcon = MessageHander.handerMap(msg);
        resp.setContentType("application/xml;chartset=UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.getWriter().write(respcon);
    }

    @RequestMapping("/ips")
    public void ips(HttpServletResponse resp) throws IOException {
        resp.getWriter().println(wxServerService.ip().getIp_list());
    }

}
