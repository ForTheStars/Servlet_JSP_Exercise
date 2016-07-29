<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title> Accessing Collections</title>
<link href="/common/JSP-Styles.css" rel="stylesheet" type="text/css"/>
</head>
<body>
	<table border=5 align="center">
		<tr>
			<th class="TITLE"> Accessing Collections</th>
		</tr>
	</table>
	<p>
	<ul>
		<li>${first[0]} ${last[0]} (${company["Ellison"]})
  		<li>${first[1]} ${last[1]} (${company["Gates"]})
 		<li>${first[2]} ${last[2]} (${company["McNealy"]})
	</ul>
</body>
</html>