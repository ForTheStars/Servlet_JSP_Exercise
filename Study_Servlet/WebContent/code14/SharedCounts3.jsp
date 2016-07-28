<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Shared Access Counts: Page 3</title>
<link href="/common/JSP-Styles.css" rel="stylesheet" type="text/css"/>
</head>
<body>
	<table border=5 align="center">
		<tr>
			<th class="TITLE">Shared Access Counts: Page 3</th>
		</tr>
	</table>
	<p>
	<jsp:useBean id="counter" class="code14.AccessCountBean" scope="application">
		<jsp:setProperty name="counter" property="firstPage" value="ShareCounts3.jsp" />
	</jsp:useBean>
	Of SharedCounts3.jsp (this page), 
	<a href="SharedCounts1.jsp">SharedCounts1.jsp</a>,and
	<a href="SharedCounts2.jsp">SharedCounts2.jsp</a>,
	<jsp:getProperty name="counter" property="firstPage" />was the first page accessed.
	<p>
	Collectively, the three pages have been accessed <jsp:getProperty name="counter" property="accessCount" />times. 
	<jsp:setProperty name="counter" property="accessCountIncrement" value="1" />
</body>
</html>