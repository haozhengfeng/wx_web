package com.weixin.menu;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.weixin.common.RespBody;
import com.weixin.menu.domain.Button;
import com.weixin.menu.domain.Matchrule;
import com.weixin.menu.domain.Menu;
import com.weixin.menu.service.MenuService;

@Controller
@RequestMapping("/menu")
public class MenuController {

    @Autowired
    private MenuService menuService;
    
    @RequestMapping("/create")
    @ResponseBody
    public String update(HttpServletResponse resp) throws IOException{
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
        return JSONObject.toJSONString(menuService.createMenu(menu));
    }
    
    @RequestMapping("/get")
    @ResponseBody
    public Menu get(HttpServletResponse resp) throws IOException{
        return menuService.getMenu();
    }
    
    @RequestMapping("/delete")
    @ResponseBody
    public String delete(HttpServletResponse resp) throws IOException{
        return JSONObject.toJSONString(menuService.deleteMenu());
    }
    
    
    @RequestMapping("/addConditional")
    @ResponseBody
    public String addConditional(HttpServletResponse resp) throws IOException{
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
        
        Matchrule matchrule = new Matchrule();
        matchrule.setSex("1");
        
        Menu menu = new Menu();
        menu.setButton(bs);
        menu.setMatchrule(matchrule);
        return menuService.addConditional(menu);
    }

    @RequestMapping("/delConditional")
    @ResponseBody
    public RespBody delConditional(HttpServletResponse resp) throws IOException{
        return menuService.delConditional();
    }
    
    @RequestMapping("/trymatch")
    @ResponseBody
    public RespBody trymatch(HttpServletResponse resp) throws IOException{
        return menuService.trymatch();
    }
}
