package com.weixin.menu.domain;

import java.util.List;


public class Menu {
    
    private String menuid;
    
    private List<Button> button;
    
    private Matchrule matchrule;
    
    private Menu menu;
    
    public List<Button> getButton() {
        return button;
    }
    
    public void setButton(List<Button> button) {
        this.button = button;
    }
    
    public Menu getMenu() {
        return menu;
    }
    
    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    public Matchrule getMatchrule() {
        return matchrule;
    }

    public void setMatchrule(Matchrule matchrule) {
        this.matchrule = matchrule;
    }

    public String getMenuid() {
        return menuid;
    }

    public void setMenuid(String menuid) {
        this.menuid = menuid;
    }
    
}
