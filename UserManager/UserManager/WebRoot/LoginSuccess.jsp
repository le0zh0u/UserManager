<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'LoginSuccess.jsp' starting page</title>

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
	<!--  ${user.username }<br /> 
	<s:property value="user.username" /> -->
	<%
		if (session.getAttribute("username") == null) {
	%>
	你没有登录
	<br>
	<a href="Login.jsp">请登录.</a>
	<%
		} else {
	%>
	<%=session.getAttribute("username").toString()%>
	登录成功。
	<br />
	<br />
	<a href="userInfo.action">查看个人信息</a> | <a href="user.action">查看别的用户</a> | <a href="Delete.jsp">删除帐号</a> |<a href="Loginout.jsp">退出</a>
	<!-- ?user.username=<s:property value='user.username' /> -->

	<%
		}
	%>
	
</body>
</html>
