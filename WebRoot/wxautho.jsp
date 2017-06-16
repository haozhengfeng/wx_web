<%@page import="com.weixin.autho.domain.WXUserInfo"%>
<%@page import="com.common.WeiXinContext"%>
<%@page import="java.net.URLEncoder"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>网页授权</title>
	<meta charset="UTF-8">
    <meta name="viewport" content="width=device-width,initial-scale=1,user-scalable=0">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	
	<script type="text/javascript" >
    	window.location.href="https://open.weixin.qq.com/connect/oauth2/authorize?appid=${appid}&redirect_uri=${url}&response_type=code&scope=snsapi_userinfo&state=123";
    </script>
  </head>
  
</html>
