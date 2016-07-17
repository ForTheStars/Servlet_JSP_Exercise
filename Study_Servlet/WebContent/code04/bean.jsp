<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="/study/bean.do" method="post">
		用户ID：<input type="text" name="id"/>
		用户名：<input type="text" name="username"/>
		密码： <input type="password" name="password"/>
		是否成年：<input type="checkbox" name="adult" />
		<input type="submit" value="登入"/>
	</form>
</body>
</html>