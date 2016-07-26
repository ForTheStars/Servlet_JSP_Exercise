<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Using jsp:plugin</title>
<link href="JSP-Styles.css" rel="stylesheet" type="text/css"/>
</head>
<body>
	<table border=5 align="center">
		<tr>
			<th class="TITLE">
				Using jsp:plugin
			</th>
		</tr>
	</table>
	<p>
		<jsp:plugin code="applet" codebase="/WEB-INF/classes/PluginApplet.class" width="370" height="420" type="applet">
		</jsp:plugin>
	</p>
</body>
</html>