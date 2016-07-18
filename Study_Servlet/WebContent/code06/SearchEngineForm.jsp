<%@page import="code06.SearchUtil"%>
<%@page import="code06.SearchSpec" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%
	SearchSpec[] searchSpecs = SearchUtil.getCommonSpecs();
%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body BGCOLOR="#FDF5E6">
	<form action="/study/search.do" method="get">
		Search keywords:<input type="text" name="searchString"/><br/>
		<%
			for(int i=0; i<searchSpecs.length; i++) {
				String searchEngineName = searchSpecs[i].getName();
				%>
				<%= searchEngineName %>: <input type="radio" name="searchEngine" value="<%= searchEngineName %>" />
				<br>
				<%
			}
		%>
		<input type="submit" value="搜索"/>
	</form>
</body>
</html>