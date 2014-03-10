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

<title>My JSP 'Regist.jsp' starting page</title>

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
		<h3>欢迎注册</h3>
		<s:form action="regist.action" method="post">
			<s:textfield name="user.username" label="用户名"></s:textfield>
			<s:password name="user.password" label="密码"></s:password>
			<s:password name="password2" label="确认密码"></s:password>
			<s:textfield name="user.sex" label="性别" ></s:textfield>
			<s:textfield name="user.phone" label="号码"></s:textfield>
			<s:submit value="注册"></s:submit>

		</s:form>
		<s:property value="error"/><br>
		<a href="Login.jsp">已有账户，请登录。</a>
	</center>
</body>
</html>
