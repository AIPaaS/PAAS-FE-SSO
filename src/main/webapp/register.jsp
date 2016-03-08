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
	<title>亚信云-PAAS平台-注册申请</title>
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

<form class="form-horizontal" role="form" id="form_register">
<div class="row" id="reg-error" style="display:none;">
<div class="pull-left">
&nbsp;&nbsp;&nbsp;&nbsp;<font id="fm_error_msg" color="red"></font>
</div>
</div>
<div class="input-group">
<span class="input-group-addon">&nbsp;&nbsp;租户代码：</span>
<input class="form-control" id="mntCode" name="mntCode" type="text" required maxLength="32" pattern="([0-9]|[a-zA-Z]){1,32}" placeholder="1-32位字母或数字组合">
</div>
<div class="input-group">
<span class="input-group-addon">&nbsp;&nbsp;租户名称：</span>
<input class="form-control" id="mntName" name="mntName" type="text" maxLength="20" placeholder="名称">
</div>
<div class="input-group">
<span class="input-group-addon">&nbsp;&nbsp;登录账号：</span>
<input class="form-control" id="loginCode" name="loginCode" type="text" readOnly value="admin">
</div>
<div class="input-group">
<span class="input-group-addon">&nbsp;&nbsp;登录密码：</span>
<input type="password" class="form-control" id="mntPwd" name="mntPwd" required maxLength="16" pattern=".{6,16}" placeholder="6-16位">
</div>
<div class="input-group">
<span class="input-group-addon">&nbsp;&nbsp;密码确认：</span>
<input type="password" class="form-control" id="mntPwd2" name="mntPwd2" required maxLength="16" pattern=".{6,16}" placeholder="6-16位">
</div>
<div class="input-group">
<span class="input-group-addon">&nbsp;&nbsp;邮箱地址：</span>
<input class="form-control" type="email" required id="contactEmail" name="contactEmail" required placeholder="example@asiainfo.com">
</div>
<div class="input-group">
<span class="input-group-addon">&nbsp;&nbsp;成本中心：</span>
<input class="form-control" id="ccCode" name="ccCode" type="text" required maxLength="20" placeholder="">
</div>
<div class="input-group">
<span class="input-group-addon">&nbsp;&nbsp;联系人员：</span>
<input class="form-control" id="contactName" name="contactName" type="text" required maxLength="20" placeholder="">
</div>
<div class="input-group">
<span class="input-group-addon">&nbsp;&nbsp;联系电话：</span>
<input class="form-control" id="contactPhone" name="contactPhone" type="text" pattern="(\d{11})|^((\d{7,8})|(\d{4}|\d{3})-(\d{7,8})|(\d{4}|\d{3})-(\d{7,8})-(\d{4}|\d{3}|\d{2}|\d{1})|(\d{7,8})-(\d{4}|\d{3}|\d{2}|\d{1}))$" required="required" maxLength="11" placeholder="">
</div>
<!-- <div class="input-group col-xs-7 pull-left">
<span class="input-group-addon"><i class="fa fa-qrcode"></i></span>
<input class="form-control" type="text" id="captchaCode" name="captchaCode" required pattern="([0-9]|[a-zA-Z]){4}" placeholder="验证码">
</div>
<div class="input-group col-xs-5 pull-left">
<img id="img_captcha" class="form-control" src="###" style="cursor:pointer">
</div> -->

<div id="remember-me-wrapper">
<div class="row">
&nbsp;
</div>
</div>
<div class="row">
<div class="col-xs-12">
<button type="submit" id="fm-reg-submit" name="fm-reg-submit" class="btn btn-success col-xs-12">注册</button>
</div>
</div>
</form>

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
	$("#fm-reg-submit").button("loading");
};
RS.onHideMsg = function() {
	$("#fm-reg-submit").button("reset");
};
RS.showErrMsg = function(errcode, errmsg) {
	setErrMsg(errmsg);
};

var setErrMsg = function(msg) {
	$("#reg-error").attr("style", "display:block");
	$("#fm_error_msg").html(msg); 
};
var hideErrMsg = function(msg) {
	$("#reg-error").attr("style", "display:none");
};


function getCaptchaImage() {
	var url = ContextPath+"/external/operation/getRegCaptchaImage?d="+new Date().getTime();
	$("#img_captcha").attr("src", url);
	$("#captchaCode").val("");
}

function register() {
	var els = $("#form_register").find("input");
	var form = {};
	for(var i=0; i<els.length; i++) {
		form[els[i].name] = els[i].value;
	}
	
	if(form.mntPwd != form.mntPwd2) {setErrMsg("登录密码与密码确认不一致"); return ;}
	
	RS.ajax({url:"/external/operation/register",ps:form,cb:function(rs) {
		if(!CU.isEmpty(rs)) {
			setErrMsg(rs);
			//getCaptchaImage();
			return ;
		}
		window.location = ContextPath + "/regsucc.jsp?mntCode="+form.mntCode+"&mntName="+encodeURIComponent(form.mntName)+"&email="+encodeURIComponent(form.contactEmail);
	}});
};


$(document).ready(function() {
	$("#form_register").submit(function(e){
	    e.preventDefault();
	    register();
	});
	/* $("#img_captcha").bind('click', getCaptchaImage);
	getCaptchaImage(); */
});

</script>
</html>