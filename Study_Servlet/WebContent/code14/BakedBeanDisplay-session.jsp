<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Baked Bean Values: session-based Sharing</title>
<link href="/common/JSP-Styles.css" rel="stylesheet" type="text/css"/>
</head>
<body>
	<h1>Baked Bean Values: session-based Sharing</h1>
	<jsp:useBean id="sessionBean" class="code14.BakedBean" scope="session" />
	<jsp:setProperty property="*" name="sessionBean"/>
	<h2>
		Bean level: <jsp:getProperty property="level" name="sessionBean"/>
	</h2>
	<h2>
		Dish bean goes with: <jsp:getProperty property="goesWith" name="sessionBean"/>
	</h2>
</body>
</html>