<%@page import="java.math.BigInteger"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1 style="text-align:center;">Some ${numDigits }-Digit Prime Numbers</h1><br><br>
	<h3>Primes found with: ${numDigits } </h3><br>
	<h3>or more digits: ${numCurrentPrimes }</h3><br><br>
	<c:choose>
		<c:when test="${isLastResult}" >
			<B>Done searching.</B><br>
		</c:when>
		<c:otherwise>
			<B>Still looking for ${numPrimesRemaining} more<BLINK>...</BLINK></B><br>
		</c:otherwise>
	</c:choose>
	<ol>
		<%
		for(int i=0; i<(Integer)request.getAttribute("numCurrentPrimes"); i++) {
		    %>
		    <li style="text-align:center;">
		    	<%=
		    	((ArrayList<BigInteger>)request.getAttribute("currentPrimes")).get(i)
		    	%>
		    </li>
		    <%
		}
		%>
	</ol>
</body>
</html>