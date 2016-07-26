<!-- import 导入对应文件 -->
<%@page import="java.util.HashMap"%>
<%@page import="code.author.BeanUtilities"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 需import -->
	<%BeanUtilities.populateBean(new Object(), new HashMap()); %>
	
	<!-- session 默认 true -->
	<%@page session="false" %>
	
	<!-- isELlgnored false表示执行EL表达式 -->
	<%@page isELIgnored="false" %>
	
	<!-- buffer 值为none时表示不使用缓冲区 -->
	<%@page buffer="8kb" %>
	
	<!-- autoFlush 自动清空输出缓冲区(默认true) 上述值为none时 该值为false是错误的 -->
	<%@page autoFlush="true" %>
	
	<!-- info 在生成的servlet中会生成getServletInfo(),其返回的值为下述值 -->
	<%@page info="Some Message" %>
	
	<!--errorPage指定该页面专用的错误页面     isErrorPage 可以当前页面是否可以作为其他jsp页面的错误页面  -->
	<%@page errorPage="xxx.jsp" %>
	<%@page isErrorPage="true" %>
	
	<!--isThreadSafe 是否允许同一时间多个请求访问单个servlet实例 尽量避免使用(不安全)  -->
	<%@page isThreadSafe="false" %>

	<!-- extends 避免使用 为开发人员或提供商保留的 -->
	<%-- <%@page extends="xxx.class" %> --%>
		
</body>
</html>