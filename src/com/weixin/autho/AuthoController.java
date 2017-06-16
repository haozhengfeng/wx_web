package com.weixin.autho;

import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.common.WeiXinContext;
import com.common.utils.HttpClientUtils;
import com.common.utils.LoggerUtils;
import com.weixin.autho.domain.AccessToken;
import com.weixin.autho.domain.WXUserInfo;

@Controller
public class AuthoController {
	
	@RequestMapping(value="/wxuser/wxUserInfo",method=RequestMethod.GET)
	public String wxUserInfo(Model model){
		return "wxUserInfo";
	}
	
	@RequestMapping(value="/towxautho",method=RequestMethod.GET)
	public String autho(Model model){
		try {
			String url = URLEncoder.encode(WeiXinContext.WX_AUTHO_URL, "UTF-8");
			String appid = WeiXinContext.APPID;
			
			model.addAttribute("url", url);
			model.addAttribute("appid", appid);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "wxautho";
	}
	
	@RequestMapping(value="/wxautho",method=RequestMethod.GET)
	public String autho(String code,String state,HttpServletRequest request,HttpServletResponse response){
		try {
			String appid = WeiXinContext.APPID;
			String secret = WeiXinContext.APPSECRT;
				AccessToken accessToken = HttpClientUtils.sendHttpGet("https://api.weixin.qq.com/sns/oauth2/access_token?appid="+appid+"&secret="+secret+"&code="+code+"&grant_type=authorization_code",AccessToken.class);
				WXUserInfo wxUserInfo = HttpClientUtils.sendHttpGet("https://api.weixin.qq.com/sns/userinfo?access_token="+accessToken.getAccess_token()+"&openid="+accessToken.getOpenid()+"&lang=zh_CN",WXUserInfo.class);
				if(wxUserInfo!=null&&wxUserInfo.getOpenid()!=null){
				    request.getSession().setAttribute("wxUserInfo", wxUserInfo);
				    request.setAttribute("wxUserInfo", wxUserInfo);
				}
				LoggerUtils.debug(AuthoController.class, "wxautho_openid:"+wxUserInfo.getOpenid());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "redirect:wxuser/wxUserInfo";
	}
	

}
