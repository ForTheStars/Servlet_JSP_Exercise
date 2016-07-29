<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Using Implicit Objects</title>
<link href="/common/JSP-Styles.css" rel="stylesheet" type="text/css"/>
</head>
<body>
	<table border=5 align="center">
		<tr>
			<th class="TITLE">Using Implicit Objects</th>
		</tr>
	</table>
	<p>
	<ul>
		<li><b>test Request Parameter:</b> ${param.test}
  		<li><b>User-Agent Header:</b> ${header["User-Agent"]}
 		<li><b>JSESSIONID Cookie Value:</b> ${cookie.JSESSIONID.value}
 		<li><b>Server:</b> ${pageContext.servletContext.serverInfo}
	</ul>
</body>
</html>