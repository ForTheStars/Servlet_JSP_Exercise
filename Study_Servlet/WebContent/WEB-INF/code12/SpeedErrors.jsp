<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@page isErrorPage="true" %>
	<table border=5 align="center">
		<tr>
			<th>Error Computing Speed</th>
		</tr>
	</table>
	<p>ComputeSpeed.jsp reported the following error:</p>
	<i><%= exception %></i>. This problem occurred in the following place:
	<pre>
		<%@page import="java.io.PrintWriter" %>
		<% exception.printStackTrace(new PrintWriter(out)); %>
	</pre>
</body>
</html>