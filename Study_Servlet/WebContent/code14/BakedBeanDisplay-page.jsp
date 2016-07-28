<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Baked Bean Values: page-based Sharing</title>
<link href="/common/JSP-Styles.css" rel="stylesheet" type="text/css"/>
</head>
<body>
	<h1>Baked Bean Values: page-based Sharing</h1>
	<jsp:useBean id="pageBean" class="code14.BakedBean" />
	<jsp:setProperty property="*" name="pageBean"/>
	<h2>
		Bean level: <jsp:getProperty property="level" name="pageBean"/>
	</h2>
	<h2>
		Dish bean goes with: <jsp:getProperty property="goesWith" name="pageBean"/>
	</h2>
</body>
</html>