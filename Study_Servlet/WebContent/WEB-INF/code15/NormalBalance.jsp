<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Your Balance</title>
<link href="/common/JSP-Styles.css" rel="stylesheet" type="text/css"/>
</head>
<body>
	<table border=5 align="center">
		<tr>
			<th class="TITLE">Your Balance</th>
		</tr>
	</table>
	<p>
	<img src="/study/code15/Money-Piles.gif" align="right">
	<jsp:useBean id="regularCustomer" type="code15.BankCustomer" scope="request" />
	<ul>
		<li>First name: <jsp:getProperty property="firstName" name="regularCustomer"/>
		<li>Last name: <jsp:getProperty property="lastName" name="regularCustomer"/>
		<li>ID: <jsp:getProperty property="id" name="regularCustomer"/>
		<li>Balance: $<jsp:getProperty property="balance" name="regularCustomer"/>
	</ul>
</body>
</html>