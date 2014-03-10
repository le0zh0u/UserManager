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
    
    <title>My JSP 'Delete.jsp' starting page</title>
    
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
    <%if( session.getAttribute("username")==null){ %>
    你没有登录<br>
    <a href="Login.jsp">请登录</a>
    <%}else{ %>
    <%=session.getAttribute("username").toString() %>
    	,确定删除本账号？
    	<br>
    	<s:form action="delete.action" method="post">
    		<s:password name="password" label="确认密码"></s:password>
    		<s:submit value="删除帐号"></s:submit>
    	</s:form>
    	<a href="LoginSuccess.jsp">返回</a>
    	<%} %>
    </center>
  </body>
</html>
