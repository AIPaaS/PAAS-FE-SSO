<%@ page contentType="text/html; charset=utf-8"%>

<%
String ContextPath = request.getContextPath();
%>

<!DOCTYPE html>
<html>

<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0"/>
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>
	<title>亚信云-PAAS管理-登录</title>
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
<img src="<%=ContextPath%>/img/ddp_logo.png" alt=""/>
</div>
</header>
<div id="login-box-inner">
<div class="row" id="login-error" style="display:none;">
<div class="pull-left">
&nbsp;&nbsp;&nbsp;&nbsp;<font id="fm_error_msg" color="red"></font>
</div>
</div>
<div class="input-group">
<span class="input-group-addon"><i class="fa fa-user"></i></span>
<input class="form-control" id="fm-login-id" name="fm-login-id" type="text" placeholder="登录名">
</div>
<div class="input-group">
<span class="input-group-addon"><i class="fa fa-key"></i></span>
<input type="password" class="form-control" id="fm-login-password" name="fm-login-password" placeholder="登录密码">
</div>

<div class="input-group col-xs-7 pull-left">
<span class="input-group-addon"><i class="fa fa-qrcode"></i></span>
<input class="form-control" type="text" id="captchaCode" name="captchaCode" placeholder="验证码">
</div>
<div class="input-group col-xs-5 pull-left">
<img id="img_captcha" class="form-control" src="###" style="cursor:pointer">
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
	var loginCode = $("#fm-login-id").val();
	var password = $("#fm-login-password").val();
	var captchaCode = $("#captchaCode").val();
	
	if(CU.isEmpty(loginCode)) {setErrMsg("登录名不可以为空"); return ;}
	if(CU.isEmpty(password)) {setErrMsg("登录密码不可以为空"); return ;}
	if(CU.isEmpty(captchaCode)) {setErrMsg("验证码不可以为空"); return ;}
	
	SSO.login(loginCode, password, captchaCode, function(url) {
		window.location = url;
	}, function(rs) {
		switch(rs.code) {
			case "LOGIN_LOGINCODE_EMPTY": setErrMsg("登录名不可以为空"); break;
			case "LOGIN_PASSWORD_EMPTY": setErrMsg("登录密码不可以为空"); break;
			case "LOGIN_CAPTCHA_CODE_EMPTY": setErrMsg("验证码不可以为空"); break;
			case "LOGIN_CAPTCHA_IMG_EMPTY": setErrMsg("没有生成验证码"); break;
			case "LOGIN_CAPTCHA_ERROR": setErrMsg("验证码输入错误"); break;
			case "LOGIN_OP_INVALID": setErrMsg("用户未<a href='<%=ContextPath%>/external/operation/sendEmail2ActiveUser?loginCode="+loginCode+"'>激活</a>!"); break;
			default: setErrMsg(rs.message); break;
		}
		getCaptchaImage();
	});
};

window.onload = function() {
	$("#fm-login-id").bind('keyup', onKeyUpHandler);
	$("#fm-login-password").bind('keyup', onKeyUpHandler);
	$("#captchaCode").bind('keyup', onKeyUpHandler);
	$("#fm-login-submit").bind('click', login);
	$("#img_captcha").bind('click', getCaptchaImage);
	getCaptchaImage();
};
</script>
</html>