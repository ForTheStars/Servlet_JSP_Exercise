<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Invoking SaleEntry.jsp</title>
<link href="/common/JSP-Styles.css" rel="stylesheet" type="text/css"/>
</head>
<body>
	<table border=5 align="center">
		<tr>
			<th class="TITLE">Invoking SaleEntry.jsp</th>
		</tr>
	</table>
	<form action="/study/code14/SaleEntry.jsp">
		Item ID: <INPUT TYPE="TEXT" NAME="itemID"><BR> 
		Number of Items: <INPUT TYPE="TEXT" NAME="numItems"><BR> 
		Discount Code: <INPUT TYPE="TEXT" NAME="discountCode"><P>
		<INPUT TYPE="SUBMIT" VALUE="Show Price">
	</form>
</body>
</html>