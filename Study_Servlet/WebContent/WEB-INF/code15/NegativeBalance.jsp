<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>You Owe Us Money!</title>
<link href="/common/JSP-Styles.css" rel="stylesheet" type="text/css"/>
</head>
<body>
	<table border=5 align="center">
		<tr>
			<th class="TITLE"> We Know Where You Live!</th>
		</tr>
	</table>
	<p>
	<img src="/study/code15/Club.gif" align="left">
	<jsp:useBean id="badCustomer" type="code15.BankCustomer" scope="request" />
	Watch out,<jsp:getProperty property="firstName" name="badCustomer"/>
	we know where you live.
	<p>
	Pay us the $<jsp:getProperty property="balanceNoSign" name="badCustomer"/>
	you owe us before it is too late!
</body>
</html>