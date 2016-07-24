<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- JSP表达式  页面载入后会显示不同值-->
	<ul>
		<li><%=code.author.RanUtilities.randomInt(10) %></li>
		<li><%=code.author.RanUtilities.randomInt(10) %></li>
	</ul>
	<!-- JSP scriptlet 页面载入后会显示不同值-->
	<!-- 中间不使用out.print输出(分段) 可将li元素暴露给Web程序员,使其可以更多操作-->
	<ul>
	<%
		int numEntries = code.author.RanUtilities.randomInt(10);
		for(int i=0;i<numEntries;i++){			
	%>
			<li><%=code.author.RanUtilities.randomInt(10) %></li>
	   <%} %>
	</ul>
	<!-- JSP声明  服务器重启前都显示相同值-->
	<!-- 原因：实例变量只在对象构建时初始化，且servlet只构建一次,然后保存于内存中处理不同的请求，并为每个请求分配新的实例 -->
	<%!
		int num1 = code.author.RanUtilities.randomInt(10);
		int num2 = code.author.RanUtilities.randomInt(10);
	%>
	<ul>
		<li><%=num1 %></li>
		<li><%=num2 %></li>
	</ul>
</body>
</html>