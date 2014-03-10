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

<title>My JSP 'User.jsp' starting page</title>

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
		<h3>查看别的用户</h3>
		<hr>
		<table border="1">
			<tr>
				<td>id</td>
				<td>UserName</td>
				<td>sex</td>
				<td>phone</td>
			</tr>
			<s:iterator value="users" var="user">
				<tr>
					<td align="center"><s:property value="#user.id" /></td>
					<td align="center"><s:property value="#user.username" /></td>
					<td align="center"><s:property value="#user.sex" /></td>
					<td align="center"><s:property value="#user.phone" /></td>
				</tr>

			</s:iterator>

		</table>
		<a href="LoginSuccess.jsp">返回</a>
	</center>
</body>
</html>
