<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="/study/reg.do?method=show" method="post">
		firstName：<input type="text" name="firstName" value="${firstName }"/><br/>
		lastName： <input type="text" name="lastName" value="${lastName }"/><br/>
		emailAddress： <input type="text" name="emailAddress" value="${emailAddress }"/><br/>
		<input type="submit" value="register"/>
	</form>
</body>
</html>