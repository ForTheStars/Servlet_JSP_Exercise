<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>EL Operators</title>
<link href="/common/JSP-Styles.css" rel="stylesheet" type="text/css" />
</head>
<body>
	<table border=5 align="center">
		<tr>
			<th class="TITLE">EL Operators</th>
		</tr>
	</table>
	<p>
	<TABLE BORDER=1 ALIGN="CENTER">
		<TR>
			<TH CLASS="COLORED" COLSPAN=2>Arithmetic Operators
			<TH CLASS="COLORED" COLSPAN=2>Relational Operators
		<TR>
			<TH>Expression
			<TH>Result
			<TH>Expression
			<TH>Result
		<TR ALIGN="CENTER">
			<TD>\${3+2-1}
			<TD>${3+2-1}<%-- Addition/Subtraction --%>
			<TD>\${1&lt;2}
			<TD>${1<2}<%-- Numerical comparison --%>
		<TR ALIGN="CENTER">
			<TD>\${"1"+2}
			<TD>${"1"+2}<%-- String conversion --%>
			<TD>\${"a"&lt;"b"}
			<TD>${"a"<"b"}<%-- Lexical comparison --%>
		<TR ALIGN="CENTER">
			<TD>\${1 + 2*3 + 3/4}
			<TD>${1 + 2*3 + 3/4}<%-- Mult/Div --%>
			<TD>\${2/3 &gt;= 3/2}
			<TD>${2/3 >= 3/2}<%-- >= --%>
		<TR ALIGN="CENTER">
			<TD>\${3%2}
			<TD>${3%2}<%-- Modulo --%>
			<TD>\${3/4 == 0.75}
			<TD>${3/4 == 0.75}<%-- Numeric = --%>
		<TR ALIGN="CENTER">
			<%-- div and mod are alternatives to / and % --%>
			<TD>\${(8 div 2) mod 3}
			<TD>${(8 div 2) mod 3}	<%-- Compares with "equals" but returns false for null --%>
			<TD>\${null == "test"}
			<TD>${null == "test"}
		<TR>
			<TH CLASS="COLORED" COLSPAN=2>Logical Operators
			<TH CLASS="COLORED" COLSPAN=2><CODE>empty</CODE> Operator
		<TR>
			<TH>Expression
			<TH>Result
			<TH>Expression
			<TH>Result
		<TR ALIGN="CENTER">
			<TD>\${(1&lt;2) && (4&lt;3)}
			<TD>${(1<2) && (4<3)}<%--AND--%>
			<TD>\${empty ""}
			<TD>${empty ""}<%-- Empty string --%>
		<TR ALIGN="CENTER">
			<TD>\${(1&lt;2) || (4&lt;3)}
			<TD>${(1<2) || (4<3)}<%--OR--%>
			<TD>\${empty null}
			<TD>${empty null}<%-- null --%>
		<TR ALIGN="CENTER">
			<TD>\${!(1&lt;2)}
			<TD>${!(1<2)}<%-- NOT -%>
    <%-- Handles null or empty string in request param --%>
			<TD>\${empty param.blah}
			<TD>${empty param.blah}
	</TABLE>
</body>
</html>