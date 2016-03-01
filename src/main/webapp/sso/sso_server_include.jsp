<%@ page contentType="text/html; charset=utf-8"%>
<%@page import="com.binary.sso.server.Constant,com.binary.core.util.BinaryUtils,com.binary.core.http.URLResolver"%>

<%
String beforeUrl = (String)request.getAttribute(Constant.SSO_BEFORE_URL_KEY);
String callbackUrl = (String)request.getAttribute(Constant.SSO_CALLBACK_URL_KEY);
String noClientUrl = (String)request.getAttribute(Constant.SSO_NOCLIENT_URL_KEY);
String ContextPath = request.getContextPath();
boolean hascallback = !BinaryUtils.isEmpty(callbackUrl);
if(!BinaryUtils.isEmpty(beforeUrl) && beforeUrl.indexOf('/')>=0) {
	beforeUrl = URLResolver.encode(beforeUrl);
}

if(noClientUrl!=null && !(noClientUrl.startsWith("http://")||noClientUrl.startsWith("https://"))) {
	noClientUrl = ContextPath + noClientUrl;
}
%>

<script type="text/javascript">
var SSO = {
	/**
	 * 获取验证码图片链接地址 
	 */
	getCaptchaImgUrl : function() {
		return ContextPath+"/user/auth/getCaptchaImage";
	},
	
	/**
	 * 登录
	 * @param user : 登录用户名
	 * @param pwd : 登录密码
	 * @param captcha : 验证码
	 * @param errcb : 登录失败回法方法
	 */
	login : function(user, pwd, captcha, cb, errcb, connerr) {
		RS.ajax({url:"/user/auth/login", ps:{loginCode:user, password:pwd, captchaCode:captcha}, cb:function(rs) {
			//如果登录成功
			if(rs.success) {
				var url = "";
				if(<%=hascallback%>) {
					url = "<%=callbackUrl%>";
					if(url.indexOf("?") < 0) url += "?1=1";
					url += "&token="+rs.token+"&beforeUrl="+encodeURIComponent("<%=beforeUrl%>");
				}else {
					url = "<%=noClientUrl%>";
				}
				if(CU.isFunction(cb)) {
					cb(url);
				}else {
					window.location = url;
				}
			}else {
				if(CU.isFunction(errcb)) {
					errcb(rs);
				}else {
					switch(rs.code) {
						case "LOGIN_LOGINCODE_EMPTY": alert("登录代码不可以为空!"); break;
						case "LOGIN_PASSWORD_EMPTY": alert("登录密码不可以为空!"); break;
						case "LOGIN_CAPTCHA_CODE_EMPTY": alert("验证码不可以为空!"); break;
						case "LOGIN_CAPTCHA_IMG_EMPTY": alert("没有生成验证码!"); break;
						case "LOGIN_CAPTCHA_ERROR": alert("验证码输入错误!"); break;
						default: alert("登录失败!"); break;
					}
				}
			}
		}, errcb:connerr});
	}
};
</script>