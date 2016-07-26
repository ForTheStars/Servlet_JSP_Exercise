<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<%
	request.setAttribute("furlongs", "20");
	request.setAttribute("fortnights", "xx");
%>
<body>
	<%@page errorPage="/WEB-INF/code12/SpeedErrors.jsp" %>
	<table border=5 align="center">
		<tr>
			<th>Computing Speed</th>
		</tr>
	</table>
	<%!
		private double toDouble(String value){
			return Double.parseDouble(value);
		}
	%>
	<%=request.getParameter("furlongs") %>
	<%
		double furlongs = toDouble((String)request.getAttribute("furlongs"));
		double fortnights = toDouble((String)request.getAttribute("fortnights"));
		double speed = furlongs/fortnights;
	%>
	<ul>
		<li>Distance: <%= furlongs %> furlongs.
		<li>Time: <%= fortnights %> fortnights.
		<li>Speed: <%= speed %> furlongs per fortnight.
	</ul>	
</body>
</html>