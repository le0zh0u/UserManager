<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'UserInfo.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
    <center>
    <%
		if (session.getAttribute("username") == null) {
	%>
	你没有登录
	<br>
	<a href="Login.jsp">请登录.</a>
	<%
		} else {
	%>
	
	<h3>查看个人信息</h3><br>
	<a href="Update.jsp">修改个人信息</a> | <a href="LoginSuccess.jsp">返回</a><br>
	<br>
	
	用户名：<%=session.getAttribute("username").toString()%><br>
	性 别：<%=session.getAttribute("sex").toString()%><br>
	电 话：<%=session.getAttribute("phone").toString()%><br>
	
	<br>
	<hr>
	<%
		}
	%>
    </center>
  </body>
</html>
