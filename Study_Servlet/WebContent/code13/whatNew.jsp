<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="JSP-Styles.css" rel="stylesheet" type="text/css"/>
<title>Insert title here</title>
</head>
<body>
	<table border=5 align="center">
		<tr>
			<th class="TITLE">
				What's New at JspNews.com
			</th>
		</tr>
	</table>
	<p>Here is a summary of our three most recent news stories:</p>
	<ol>
		<li><jsp:include page="/WEB-INF/code13/Item1.html" /></li>
		<li><jsp:include page="/WEB-INF/code13/Item2.html" /></li>
		<li><jsp:include page="/WEB-INF/code13/Item3.html" /></li>
	</ol>
</body>
</html>