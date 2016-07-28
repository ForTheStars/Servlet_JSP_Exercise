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
			<th class="TITLE"> Your Balance</th>
		</tr>
	</table>
	<p>
	<center>
		<img src="/study/code15/Sailing.gif" align="left">
	</center>
	<br clear="all">
	<jsp:useBean id="eliteCustomer" type="code15.BankCustomer" scope="request" />
	It is an honor to serve you,
	<jsp:getProperty property="firstName" name="eliteCustomer"/>
	<jsp:getProperty property="lastName" name="eliteCustomer"/>!
	<p>
	Since you are one of our most valued customers, we would like
	to offer you the opportunity to spend a mere fraction of your
	$<jsp:getProperty property="balance" name="eliteCustomer"/>
	on a boat worthy of your status. Please visit our boat store for 
	more information.
</body>
</html>