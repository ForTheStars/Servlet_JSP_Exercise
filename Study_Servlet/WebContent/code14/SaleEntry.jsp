<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Using jsp:setProperty</title>
<link href="/common/JSP-Styles.css" rel="stylesheet" type="text/css"/>
</head>
<body>
	<!-- 实现方案一 -->
	<table border=5 align="center">
		<tr>
			<th class="TITLE"> Using jsp:setProperty -- 1</th>
		</tr>
	</table>
	<jsp:useBean id="entry1" class="code14.SaleEntry" />
	<jsp:setProperty property="itemID" name="entry1" value='<%=request.getParameter("itemID") %>'/>
	<%
	int numItemsOrdered;
	try{
		numItemsOrdered = Integer.parseInt(request.getParameter("numItems"));
	}catch(NumberFormatException nfe){
		numItemsOrdered = 1;
	}
	%>
	<jsp:setProperty property="numItems" name="entry1" value="<%= numItemsOrdered %>"/>
	<%
	double discountCode;
	try{
		discountCode = Double.parseDouble(request.getParameter("discountCode"));
	}catch(NumberFormatException nfe){
		discountCode = 1;
	}
	%>
	<jsp:setProperty property="discountCode" name="entry1" value="<%=discountCode %>"/>
	<table border=1>
		<tr class="COLORED">
			<TH>Item ID<TH>Unit Price<TH>Number Ordered<TH>Total Price
		</tr>
		<tr>
			<td><jsp:getProperty property="itemID" name="entry1"/></td>
			<td>$<jsp:getProperty property="itemCost" name="entry1"/></td>
			<td><jsp:getProperty property="numItems" name="entry1"/></td>
			<td>$<jsp:getProperty property="totalCost" name="entry1"/></td>
		</tr>
	</table>
	
	<br><br>
	<!-- 实现方案二 -->
	<table border=5 align="center">
		<tr>
			<th class="TITLE"> Using jsp:setProperty -- 2</th>
		</tr>
	</table>
	<jsp:useBean id="entry2" class="code14.SaleEntry" />
	<jsp:setProperty property="itemID" name="entry2" param="itemID"/>
	<jsp:setProperty property="numItems" name="entry2" param="numItems"/>
	<jsp:setProperty property="discountCode" name="entry2" param="discountCode"/>
	<table border=1>
		<tr class="COLORED">
			<TH>Item ID<TH>Unit Price<TH>Number Ordered<TH>Total Price
		</tr>
		<tr>
			<td><jsp:getProperty property="itemID" name="entry2"/></td>
			<td>$<jsp:getProperty property="itemCost" name="entry2"/></td>
			<td><jsp:getProperty property="numItems" name="entry2"/></td>
			<td>$<jsp:getProperty property="totalCost" name="entry2"/></td>
		</tr>
	</table>
	
	<br><br>
	<!-- 实现方案三 -->
	<table border=5 align="center">
		<tr>
			<th class="TITLE"> Using jsp:setProperty -- 3</th>
		</tr>
	</table>
	<jsp:useBean id="entry3" class="code14.SaleEntry" />
	<jsp:setProperty name="entry3" property="*" />
	<table border=1>
		<tr class="COLORED">
			<TH>Item ID<TH>Unit Price<TH>Number Ordered<TH>Total Price
		</tr>
		<tr>
			<td><jsp:getProperty property="itemID" name="entry3"/></td>
			<td>$<jsp:getProperty property="itemCost" name="entry3"/></td>
			<td><jsp:getProperty property="numItems" name="entry3"/></td>
			<td>$<jsp:getProperty property="totalCost" name="entry3"/></td>
		</tr>
	</table>
</body>
</html>