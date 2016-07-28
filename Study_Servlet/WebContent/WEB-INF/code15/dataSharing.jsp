<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>data exchange</title>
</head>
<body>
	<h1 align="center">Data Exchange</h1><br><br>
	<table border=1 align="center">
		<tr>
			<td>数据名</td><td>数据值</td>
		</tr>
		<tr>
			<jsp:useBean id="dateBean1" type="code15.DateBean"  scope="request"/>
			<td>
				<jsp:getProperty property="name" name="dateBean1"/>
			</td>
			<td>
				<jsp:getProperty property="value" name="dateBean1"/>
			</td>
		</tr>
		<tr>
			<jsp:useBean id="dateBean2" type="code15.DateBean"  scope="session"/>
			<td>
				<jsp:getProperty property="name" name="dateBean2"/>
			</td>
			<td>
				<jsp:getProperty property="value" name="dateBean2"/>
			</td>
		</tr>
		<tr>
			<jsp:useBean id="dateBean3" type="code15.DateBean"  scope="application"/>
			<td>
				<jsp:getProperty property="name" name="dateBean3"/>
			</td>
			<td>
				<jsp:getProperty property="value" name="dateBean3"/>
			</td>
		</tr>
	</table>
</body>
</html>