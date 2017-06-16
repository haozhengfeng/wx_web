<%@page import="com.weixin.autho.domain.WXUserInfo"%>
<%@page import="com.common.WeiXinContext"%>
<%@page import="java.net.URLEncoder"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>微信管理平台</title>
	<meta charset="UTF-8">
    <meta name="viewport" content="width=device-width,initial-scale=1,user-scalable=0">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet" type="text/css" href="css/weui.css">
	<script type="text/javascript" src="js/jquery/jquery-1.8.3.js"></script>
  </head>
  
  <body>
    <div class="weui-flex" style="margin-top: 40px;">
    	<div class="weui-flex__item"><div class="placeholder">
    	<div class="weui-cells__title">表单</div>
		<div class="weui-cells weui-cells_form">
		    <div class="weui-cell">
		        <div class="weui-cell__hd"><label class="weui-label">qq</label></div>
		        <div class="weui-cell__bd">
		            <input class="weui-input" type="number" pattern="[0-9]*" placeholder="请输入qq号">
		        </div>
		    </div>
		    <div class="weui-cell weui-cell_vcode">
		        <div class="weui-cell__hd">
		            <label class="weui-label">手机号</label>
		        </div>
		        <div class="weui-cell__bd">
		            <input class="weui-input" type="tel" placeholder="请输入手机号">
		        </div>
		        <div class="weui-cell__ft">
		            <button class="weui-vcode-btn">获取验证码</button>
		        </div>
		    </div>
		    <div class="weui-cell weui-cell_vcode">
		        <div class="weui-cell__hd"><label class="weui-label">验证码</label></div>
		        <div class="weui-cell__bd">
		            <input class="weui-input" type="number" placeholder="请输入验证码">
		        </div>
		        <div class="weui-cell__ft">
		            <img class="weui-vcode-img" src="./images/vcode.jpg">
		        </div>
		    </div>
		    </div>
		    </div>
		</div>
    </div>
    
    <div class="weui-flex" style="margin:40px 40px;padding: 0 20px;">
    	<div class="weui-flex__item"><div class="placeholder"><a href="javascript:;" class="weui-btn weui-btn_primary" id="btn1">登录</a></div></div>
    </div>	
		    
  </body>
</html>
