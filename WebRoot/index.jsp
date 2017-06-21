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
	    <div class="weui-flex__item"><div class="placeholder"></div></div>
	    <div class="weui-flex__item"><div class="placeholder">微信平台</div></div>
	    <div class="weui-flex__item"><div class="placeholder"></div></div>
	</div>	
    
    <c:choose>
    	<c:when test="${empty sessionScope.userinfo }">
	    	<div class="weui-flex" style="margin:40px 40px;padding: 0 20px;">
		    	<div class="weui-flex__item"><div class="placeholder"><a href="user/login" class="weui-btn weui-btn_primary" id="btn1">登录</a></div></div>
		    </div>
    	</c:when>
    	<c:otherwise>
	    	<div class="weui-flex" style="margin:40px 40px;padding: 0 20px;">
		   		<div class="weui-flex__item"><div class="placeholder"><a href="user/logout" class="weui-btn weui-btn_primary" id="btn2">退出</a></div></div>
		   	</div>	
    	</c:otherwise>
    </c:choose>
  </body>
</html>
