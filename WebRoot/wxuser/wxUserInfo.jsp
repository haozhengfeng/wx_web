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
	<script type="text/javascript" src="http://res.wx.qq.com/open/js/jweixin-1.2.0.js"></script>
	<script type="text/javascript" src="js/jquery/jquery-1.8.3.js"></script>
  </head>
  
  <body>
	        
   		<div class="weui-flex" style="margin-top: 40px;">
            <div class="weui-flex__item"><div class="placeholder"></div></div>
            <div class="weui-flex__item"><div class="placeholder"><img class="weui-media-box__thumb" alt="头像" src="${sessionScope.userinfo.headimgurl }" style="width:100%;"></img></div></div>
            <div class="weui-flex__item"><div class="placeholder"></div></div>
       	</div>	
   			
	    <div class="weui-form-preview" style="margin-top: 40px;">
            <div class="weui-form-preview__hd">
                <div class="weui-form-preview__item">
                    <label class="weui-form-preview__label">用户信息</label>
                </div>
            </div>
            <div class="weui-form-preview__bd">
                <div class="weui-form-preview__item">
                    <label class="weui-form-preview__label">openid</label>
                    <span class="weui-form-preview__value">${sessionScope.userinfo.openid }</span>
                </div>
                <div class="weui-form-preview__item">
                    <label class="weui-form-preview__label">nickname</label>
                    <span class="weui-form-preview__value">${sessionScope.userinfo.nickname }</span>
                </div>
                <div class="weui-form-preview__item">
                    <label class="weui-form-preview__label">sex</label>
                    <span class="weui-form-preview__value">${sessionScope.userinfo.sex }</span>
                </div>
                <div class="weui-form-preview__item">
                    <label class="weui-form-preview__label">province</label>
                    <span class="weui-form-preview__value">${sessionScope.userinfo.province }</span>
                </div>
                <div class="weui-form-preview__item">
                    <label class="weui-form-preview__label">city</label>
                    <span class="weui-form-preview__value">${sessionScope.userinfo.city }</span>
                </div>
                 <div class="weui-form-preview__item">
                    <label class="weui-form-preview__label">country</label>
                    <span class="weui-form-preview__value">${sessionScope.userinfo.country }</span>
                </div>
                <div class="weui-form-preview__item">
                    <label class="weui-form-preview__label">privilege</label>
                    <span class="weui-form-preview__value">${sessionScope.userinfo.privilege }</span>
                </div>
                <div class="weui-form-preview__item">
                    <label class="weui-form-preview__label">unionid</label>
                    <span class="weui-form-preview__value">${sessionScope.userinfo.unionid }</span>
                </div>
            </div>
        </div>
	    
	    <div class="weui-flex" style="margin:40px 40px;padding: 0 20px;">
	    	<div class="weui-flex__item"><div class="placeholder"><a href="javascript:;" class="weui-btn weui-btn_primary" id="btn1">获取地理位置</a></div></div>
       	</div>	
       	
       	<div class="weui-flex" style="margin:40px 40px;padding: 0 20px;">
	    	<div class="weui-flex__item"><div class="placeholder"><a href="user/logout" class="weui-btn weui-btn_primary" id="btn2">退出</a></div></div>
       	</div>	
		    
    
    <script type="text/javascript">
    $(document).ready(function() {
        $.ajax({
            type : "post",
            url : "ticket/config",
            dataType : "json",
            success : function(data) {
                wx.config({
                    debug: false, // 开启调试模式,调用的所有api的返回值会在客户端alert出来，若要查看传入的参数，可以在pc端打开，参数信息会通过log打出，仅在pc端时才会打印。
                    appId: data.appId, // 必填，公众号的唯一标识
                    timestamp: data.timestamp, // 必填，生成签名的时间戳
                    nonceStr: data.nonceStr, // 必填，生成签名的随机串
                    signature: data.signature,// 必填，签名，见附录1
                    jsApiList: ["getLocation","onMenuShareAppMessage"] // 必填，需要使用的JS接口列表，所有JS接口列表见附录2
                });
                
                wx.ready(function(){
                    // config信息验证后会执行ready方法，所有接口调用都必须在config接口获得结果之后，config是一个客户端的异步操作，所以如果需要在页面加载时就调用相关接口，则须把相关接口放在ready函数中调用来确保正确执行。对于用户触发时才调用的接口，则可以直接调用，不需要放在ready函数中。
                    
                	/* wx.checkJsApi({
                	    jsApiList: ['getLocation','onMenuShareAppMessage'], // 需要检测的JS接口列表，所有JS接口列表见附录2,
                	    success: function(res) {
                	        // 以键值对的形式返回，可用的api值true，不可用为false
                	        // 如：{"checkResult":{"chooseImage":true},"errMsg":"checkJsApi:ok"}
                	        if(res.checkResult.getLocation){
                	        	alert("支持获取位置信息接口"+res);
                	        }
                	    }
                	}); */
                    
                    
                	wx.onMenuShareAppMessage({
                        title: '分享给朋友', // 分享标题
                        desc: '分享给朋友', // 分享描述
                        link: ''+window.location.href, // 分享链接，该链接域名或路径必须与当前页面对应的公众号JS安全域名一致
                        imgUrl: 'http://images.cnitblog.com/i/340216/201404/301756448922305.jpg',
                        success: function () { 
                            // 用户确认分享后执行的回调函数
                            alert("分享给朋友成功");
                        },
                        cancel: function () { 
                            // 用户取消分享后执行的回调函数
                        	alert('已取消');
                        },
                        fail: function (res) {
                          	alert(JSON.stringify(res));
                        }
                    });
                    
                });
                
                wx.error(function(res){
                    // config信息验证失败会执行error函数，如签名过期导致验证失败，具体错误信息可以打开config的debug模式查看，也可以在返回的res参数中查看，对于SPA可以在这里更新签名。
                    alert("请求失败");
                });
            }
        });
        

        $(function(){
            $('#btn1').on('click', function(){
            	wx.getLocation({
                    type: 'wgs84', // 默认为wgs84的gps坐标，如果要返回直接给openLocation用的火星坐标，可传入'gcj02'
                    success: function (res) {
                        var latitude = res.latitude; // 纬度，浮点数，范围为90 ~ -90
                        var longitude = res.longitude; // 经度，浮点数，范围为180 ~ -180。
                        var speed = res.speed; // 速度，以米/每秒计
                        var accuracy = res.accuracy; // 位置精度
                        alert("纬度："+latitude+"经度："+longitude);
                    }
                });
            });
            
        });
    });
    
    </script>
  </body>
</html>
