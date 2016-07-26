<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="content-Type" content="text/html; charset=UTF-8">
<meta name="author" content="J. Random Hacker">
<meta name="keywords" content="foo,bar,baz,quux">
<meta name="description" content="Some random Web page.">
<link href="JSP-Styles.css" rel="stylesheet" type="text/css"/>
<title>Insert title here</title>
</head>
<!-- 
此页面使用了include(当被包含页面中既无此页面字段方法,也未设置报头)
原因是ContactSection.jsp此页面需要被许多页面当做页脚使用，此页脚里有访问量
当然每个页面的访问量都需独立的，所以需要include进来是它成为该jsp的一部分
 -->
<body>
	<table border=5 align="center">
		<tr>
			<th class="TITLE">
				Some Random Page
			</th>
		</tr>
	</table>
	<p>Information about our products and services.</p>
	<p>Blah, blah, blah.</p>
	<P>Yadda, yadda, yadda.</P>
	<%@include file="/WEB-INF/code13/ContactSection.jsp" %>
</body>
</html>