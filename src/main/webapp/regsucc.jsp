<%@ page contentType="text/html; charset=utf-8"%>
<%@page import="com.binary.core.util.BinaryUtils,com.binary.core.http.URLResolver"%>


<%
String ContextPath = request.getContextPath();
String mntCode = request.getParameter("mntCode");
String mntName = request.getParameter("mntName");
String email = request.getParameter("email");

if(BinaryUtils.isEmpty(mntCode) || BinaryUtils.isEmpty(mntName) || BinaryUtils.isEmpty(email)) {
	response.sendRedirect(ContextPath+"/external/operation/login");
	return ;
}

if(mntName.indexOf('%')>-1) {
	mntName = URLResolver.decode(mntName);
}
if(email.indexOf('%')>-1) {
	email = URLResolver.decode(email);
}

if(email.indexOf('@') > 2) {
	String s = email.substring(0, email.indexOf('@'));
	s = s.substring(0, 1) + "**" + s.substring(3);
	email = s + email.substring(email.indexOf('@'));
}

String title = "Hi ["+mntCode+"]"+mntName+"：恭喜，注册成功!";

%>


<!DOCTYPE html>
<html>

<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0"/>
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>
	<title>亚信云-PAAS平台-注册成功</title>
	<link rel="shortcut icon" href="<%=ContextPath%>/img/favicon.png" type="image/x-png" />

<link rel="stylesheet" type="text/css" href="<%=ContextPath%>/frame/bootstrap/css/bootstrap.min.css"/>

<link rel="stylesheet" type="text/css" href="<%=ContextPath%>/frame/centaurus/css/libs/font-awesome.css"/>
<link rel="stylesheet" type="text/css" href="<%=ContextPath%>/frame/centaurus/css/libs/nanoscroller.css"/>
<link rel="stylesheet" type="text/css" href="<%=ContextPath%>/frame/centaurus/css/compiled/theme_styles.css"/>

<link rel="stylesheet" href="<%=ContextPath%>/frame/centaurus/css/libs/fullcalendar.css" type="text/css"/>
<link rel="stylesheet" href="<%=ContextPath%>/frame/centaurus/css/compiled/calendar.css" type="text/css" media="screen"/>
<link rel="stylesheet" href="<%=ContextPath%>/frame/centaurus/css/libs/morris.css" type="text/css"/>
<link rel="stylesheet" href="<%=ContextPath%>/frame/centaurus/css/libs/daterangepicker.css" type="text/css"/>
<!-- <link rel="stylesheet" href="<%=ContextPath%>/frame/centaurus/css/libs/jquery-jvectormap-1.2.2.css" type="text/css"/> -->

<script src="<%=ContextPath%>/frame/jquery/jquery-1.11.3.min.js"></script>
<script src="<%=ContextPath%>/frame/bootstrap/js/bootstrap.min.js"></script>
<script src="<%=ContextPath%>/frame/centaurus/js/scripts.js"></script>
<script src="<%=ContextPath%>/frame/centaurus/js/pace.min.js"></script>
<script src="<%=ContextPath%>/frame/centaurus/js/jquery.nanoscroller.min.js"></script>

<script src="<%=ContextPath%>/frame/js/util/CommonUtils.js"></script>
<script src="<%=ContextPath%>/frame/js/util/json2.js"></script>
<script src="<%=ContextPath%>/frame/js/util/RemoteService.js"></script>
<jsp:include page="/sso/sso_server_include.jsp"></jsp:include>
</head>

<body id="login-page">
<div class="container">
<div class="row">
<div class="col-xs-12">
<div id="login-box">
<div id="login-box-holder">
<div class="row">
<div class="col-xs-12">
<header id="login-header">
<div id="login-logo">
<img src="<%=ContextPath%>/img/paas_web_log.png" alt=""/>
</div>
</header>

<div id="login-box-inner">
<h4><%=title%></h4>
<p>
请等待PAAS平台管理员的审核，审核结果将会以邮件方式发送至您的注册邮箱：
<br>
<%=email%>
<br>
<br>
届时您可以通过账号<font color='blue'>admin</font>登录平台，请耐心等待。
</p>

<div class="row">
<div class="col-xs-12">
<br/>
<a href="<%=ContextPath%>/external/operation/login" id="login-forget-link" class="forgot-link col-xs-12">返回登录</a>
</div>
</div>

</div>
</div>
</div>
</div>

</div>
</div>
</div>
</div>

</body>

</html>