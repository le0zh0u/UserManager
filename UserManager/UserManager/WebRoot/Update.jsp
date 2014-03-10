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

<title>My JSP 'Update.jsp' starting page</title>

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
		你没有登录 <br> <a href="Login.jsp">请登录.</a>
		<%
			} else {
		%>
		<h3>修改个人信息</h3>
		<hr>
		用户名：<%=session.getAttribute("username").toString()%><br>
		<h4>
			修改密码：<br>
		</h4>
		<s:form action="updatepass.action" method="post">
			<s:password name="old_pass" label="原密码"></s:password>
			<s:password name="new_pass1" label="新密码"></s:password>
			<s:password name="new_pass2" label="确认新密码"></s:password>
			<s:submit value="确认修改"></s:submit>
		</s:form>
		<h4>修改详细信息:</h4>
		<br>
		<s:form action="updateelse.action" method="post">
			<s:textfield name="sex" label="性别"></s:textfield>
			<s:textfield name="phone" label="电话"></s:textfield>
			<s:submit value="确认修改"></s:submit>
		</s:form>
		<a href="UserInfo.jsp">返回</a>
	</center>

	<!-- <s:property value="user.username" /> -->

	<br>
	<%
		}
	%>

</body>
</html>
