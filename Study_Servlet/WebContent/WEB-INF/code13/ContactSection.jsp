<%-- The following become fields in each servlet that
     results from a JSP page that includes this file. --%>
<%@page import="java.util.Date"%>
<%!
	private int accessCount = 0;
	private Date accessDate = new Date();
	private String accessHost = "<I>No previous access</I>";
%>
<p>
	<hr />
	This page &copy; 2003
	<A HREF="javascript:if(confirm('http://volume1.coreservlets.com/archive/Including-Files/WEB-INF/http//www.my-company.com/  \n\n该文件未被 Teleport Pro 下载，因为 服务器报告 - 无法找到该文件。  \n\n你想要从服务器打开它吗?'))window.location='http://volume1.coreservlets.com/archive/Including-Files/WEB-INF/http//www.my-company.com/'" tppabs="http://volume1.coreservlets.com/archive/Including-Files/WEB-INF/http//www.my-company.com/">my-company.com</A>.
	This page has been accessed <%= ++accessCount %>
	times since server reboot. It was most recently accessed from 
	<%= accessHost %> at <%= accessDate %>.
	<% accessHost = request.getRemoteHost(); %>
	<% accessDate = new Date(); %>
</p>