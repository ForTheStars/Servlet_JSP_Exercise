<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="control.do?method=login" method="post">
		用户ID：<input type="text" name="id" value="${bean.id }" />${errors.id}<br/>
		用户名：<input type="text" name="username" value="${bean.username }" />${errors.username}<br/>
		密码： <input type="password" name="password" value="${bean.password }"/>${errors.password}<br/>
		是否成年：<input type="checkbox" name="adult" />${errors.adult}<br/>
		<input type="submit" value="登入"/>
	</form>
</body>
</html>