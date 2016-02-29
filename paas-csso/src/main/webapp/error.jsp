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
<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0"/>
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>
	<title>亚信云-PAAS管理-异常</title>
	<link rel="shortcut icon" href="<%=ContextPath%>/img/favicon.png" type="image/x-png" />
 
<link rel="stylesheet" type="text/css" href="<%=ContextPath%>/frame/bootstrap/css/bootstrap.min.css"/>

<link rel="stylesheet" type="text/css" href="<%=ContextPath%>/frame/centaurus/css/libs/font-awesome.css"/>
<link rel="stylesheet" type="text/css" href="<%=ContextPath%>/frame/centaurus/css/libs/nanoscroller.css"/>
<link rel="stylesheet" type="text/css" href="<%=ContextPath%>/frame/centaurus/css/compiled/theme_styles.css"/>

</head>
<body id="error-page">
<div class="container">
<div class="row">
<div class="col-xs-12">
<div id="error-box">
<div class="row">
<div class="col-xs-12">
<div id="error-box-inner">
<img src="<%=ContextPath%>/frame/centaurus/img/error-500-v1.png" alt="Error 500"/>
</div>
<h1>ERROR 500</h1>
<p>
<font color='red'><%=msg%></font>
</p>
<p>
<a href="<%=refurl%>">返回</a>
</p>
</div>
</div>
</div>
</div>
</div>
</div>
<div style="display:none;">
<%=fullmsg%>
</div>
</body>
</html>