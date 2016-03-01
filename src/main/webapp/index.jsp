<%@ page contentType="text/html; charset=utf-8"%>
<%
String ContextPath = request.getContextPath();
request.getRequestDispatcher("/user/auth/verify").forward(request, response);
%>
