<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Baked Bean Values: request-based Sharing</title>
</head>
<body>
	<h1>Baked Bean Values: request-based Sharing</h1>
	<jsp:useBean id="requestBean" class="code14.BakedBean" scope="request" />
	<jsp:setProperty property="*" name="requestBean"/>
	<h2>
		Bean level: <jsp:getProperty property="level" name="requestBean"/>
	</h2>
	<h2>
		Dish bean goes with: <jsp:getProperty property="goesWith" name="requestBean"/>
	</h2>
	<br/><br/>
	<jsp:include page="BakedBeanDisplay-snippet.jsp" />
</body>
</html>