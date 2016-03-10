<%@ page contentType="text/html; charset=utf-8"%>

<%
String ContextPath = request.getContextPath();
Exception ex = (Exception)request.getAttribute("exception");
String refurl = request.getHeader("Referer");
if(refurl==null||refurl.length()==0) refurl = request.getContextPath()+"/index.jsp";
String msg = "";
String fullmsg = "";
if(ex != null) {
	msg = ex.getMessage();
	fullmsg = ex.toString();
}

%>



<!DOCTYPE html>
<html>
<head>
<title>亚信云温馨提示：您的浏览器需要更新才能访问哦^_^</title>
<meta charset="utf-8" />
<style>
body { text-align:center; padding-top:30px; }
img { border:none; }
h2,h3,h4 { color:#666; font-family:arial; }
strong { border-bottom:1px dotted #930; font-weight:normal; padding-bottom:2px; color:#930; }
p { padding:50px 0; letter-spacing:20px; }
h4 { font-weight:normal; }
</style>
</head>

<body>
<h2>亚信云温馨提示：<strong>您的浏览器需要更新才能访问哦 ^_^</strong></h2>
<h3>请使用 <strong>Chrome</strong>、<strong>Safari</strong>、<strong>firefox</strong>、<strong>opera</strong> 浏览器访问~</h3>
<p>
<a href="http://www.google.com/chrome" target="_blank"><img src="<%=ContextPath%>/frame/centaurus/img/chrome.png" alt="chrome" /></a>
<a href="http://www.apple.com/safari" target="_blank"><img src="<%=ContextPath%>/frame/centaurus/img/safari.png" alt="safari" /></a>
<a href="http://www.firefox.com/" target="_blank"><img src="<%=ContextPath%>/frame/centaurus/img/firefox.png" alt="safari" /></a>
<a href="http://www.opera.com/zh-cn" target="_blank"><img src="<%=ContextPath%>/frame/centaurus/img/opera.png" alt="safari" /></a>
</p>
</body>
</html>