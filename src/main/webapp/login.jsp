<%@ page contentType="text/html; charset=utf-8"%>

<%
String ContextPath = request.getContextPath();
%>

<!DOCTYPE html>
<html>

<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0"/>
	<title>亚信云-PAAS平台-登录</title>
	<link rel="shortcut icon" href="<%=ContextPath%>/img/favicon.png" type="image/x-png" />

<link rel="stylesheet" type="text/css" href="<%=ContextPath%>/frame/bootstrap/css/bootstrap.min.css"/>

<link rel="stylesheet" type="text/css" href="<%=ContextPath%>/frame/centaurus/css/libs/font-awesome.css"/>
<link rel="stylesheet" type="text/css" href="<%=ContextPath%>/frame/centaurus/css/libs/nanoscroller.css"/>
<link rel="stylesheet" type="text/css" href="<%=ContextPath%>/frame/centaurus/css/compiled/theme_styles.css"/>

<link rel="stylesheet" href="<%=ContextPath%>/frame/centaurus/css/libs/fullcalendar.css" type="text/css"/>
<link rel="stylesheet" href="<%=ContextPath%>/frame/centaurus/css/compiled/calendar.css" type="text/css" media="screen"/>
<link rel="stylesheet" href="<%=ContextPath%>/frame/centaurus/css/libs/morris.css" type="text/css"/>
<link rel="stylesheet" href="<%=ContextPath%>/frame/centaurus/css/libs/daterangepicker.css" type="text/css"/>
<link rel="stylesheet" href="<%=ContextPath%>/frame/centaurus/css/libs/jquery-jvectormap-1.2.2.css" type="text/css"/>
<!--[if lt IE 9]><script>window.location = '<%=ContextPath%>/error2.jsp';</script><![endif]-->
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
<div class="row" id="login-error" style="display:none;">
<div class="pull-left">
&nbsp;&nbsp;&nbsp;&nbsp;<font id="fm_error_msg" color="red"></font>
</div>
</div>
<div class="input-group">
<span class="input-group-addon"><i class="fa fa-users"></i></span>
<input class="form-control" id="mntCode" name="mntCode" type="text" placeholder="租户名">
</div>
<div class="lg_ht"></div>
<div class="input-group">
<span class="input-group-addon"><i class="fa fa-user"></i></span>
<input class="form-control" id="loginCode" name="loginCode" type="text" placeholder="用户名">
</div>
<div class="lg_ht"></div>
<div class="input-group">
<span class="input-group-addon"><i class="fa fa-key"></i></span>
<input type="password" class="form-control" id="loginPwd" name="loginPwd" placeholder="登录密码">
</div>
<div class="lg_ht"></div>
<div class="input-group col-xs-7 pull-left">
<span class="input-group-addon"><i class="fa fa-qrcode"></i></span>
<input class="form-control" type="text" id="captchaCode" name="captchaCode" placeholder="验证码">
</div>
<div class="input-group col-xs-5 pull-left">
<img id="img_captcha" class="form-control" src="###" style="cursor:pointer">
</div>

<div id="remember-me-wrapper">
<div class="row">
<div class="pull-right">
<div class="lg_ht"></div>
<a href="<%=ContextPath%>/register.jsp">注册申请</a>&nbsp;&nbsp;&nbsp;&nbsp;
</div>
</div>
</div>
<div class="row">
<div class="col-xs-12">
<button type="submit" id="fm-login-submit" name="fm-login-submit" class="btn btn-success col-xs-12">登录</button>
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
<script type="text/javascript">
var ContextPath = "<%=ContextPath%>";
RS.onShowMsg = function() {
	$("#fm-login-submit").button("loading");
};
RS.onHideMsg = function() {
	$("#fm-login-submit").button("reset");
};
RS.showErrMsg = function(errcode, errmsg) {
	setErrMsg(errmsg);
};

var setErrMsg = function(msg) {
	$("#login-error").attr("style", "display:block");
	$("#fm_error_msg").html(msg); 
};
var hideErrMsg = function(msg) {
	$("#login-error").attr("style", "display:none");
};


var onKeyUpHandler = function(e) {
	if(e.keyCode == 13) login();
};

function getCaptchaImage() {
	var url = SSO.getCaptchaImgUrl()+"?d="+new Date().getTime();
	$("#img_captcha").attr("src", url);
	$("#captchaCode").val("");
}

var login = function() {
	var mntCode = $("#mntCode").val();
	var loginCode = $("#loginCode").val();
	var loginPwd = $("#loginPwd").val();
	var captchaCode = $("#captchaCode").val();
	
	if(CU.isEmpty(mntCode)) {setErrMsg("租户名不可以为空"); return ;}
	if(CU.isEmpty(loginCode)) {setErrMsg("用户名不可以为空"); return ;}
	if(CU.isEmpty(loginPwd)) {setErrMsg("登录密码不可以为空"); return ;}
	if(CU.isEmpty(captchaCode)) {setErrMsg("验证码不可以为空"); return ;}
	
	SSO.login(mntCode+"|"+loginCode, loginPwd, captchaCode, function(url) {
		window.location = url;
	}, function(rs) {
		switch(rs.code) {
			case "LOGIN_LOGINCODE_EMPTY": setErrMsg("用户名不可以为空"); break;
			case "LOGIN_PASSWORD_EMPTY": setErrMsg("登录密码不可以为空"); break;
			case "LOGIN_CAPTCHA_CODE_EMPTY": setErrMsg("验证码不可以为空"); break;
			case "LOGIN_CAPTCHA_IMG_EMPTY": setErrMsg("没有生成验证码"); break;
			case "LOGIN_CAPTCHA_ERROR": setErrMsg("验证码输入错误"); break;
			default: setErrMsg(rs.message); break;
		}
		getCaptchaImage();
	});
};

window.onload = function() {
	$("#mntCode").bind('keyup', onKeyUpHandler);
	$("#loginCode").bind('keyup', onKeyUpHandler);
	$("#loginPwd").bind('keyup', onKeyUpHandler);
	$("#captchaCode").bind('keyup', onKeyUpHandler);
	$("#fm-login-submit").bind('click', login);
	$("#img_captcha").bind('click', getCaptchaImage);
	getCaptchaImage();
};
</script>
</html>