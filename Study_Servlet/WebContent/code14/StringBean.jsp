<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Using JavaBeans with JSP</title>
<link href="/common/JSP-Styles.css" rel="stylesheet" type="text/css"/>
</head>
<body>
	<table border=5 align="center">
		<tr>
			<th class="TITLE">Using JavaBeans with JSP</th>
		</tr>
	</table>
	<jsp:useBean id="stringBean" class="code14.StringBean" />
		<ol>
			<li>Initial value (from jsp:getProperty):<i><jsp:getProperty name="stringBean" property="message" /></i></li>
			<li>Initial value (from JSP expression):<i><%=stringBean.getMessage() %></i></li>
			
			<li>
				<jsp:setProperty name="stringBean" property="message" value="Best string bean: Fortex"/>
				Value after setting property with jsp:setProperty:<i><jsp:getProperty name="stringBean" property="message" /></i>
			</li>
			<li>
				<%stringBean.setMessage("My favorite: Kentucky Wonder"); %>
				Value after setting property with scriptlet:<i><%=stringBean.getMessage() %></i>
			</li>
		</ol>	
</body>
</html>