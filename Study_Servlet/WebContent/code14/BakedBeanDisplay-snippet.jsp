<html>
	<jsp:useBean id="requestBean" class="code14.BakedBean" scope="request" />
	<h1>Repeated Baked Bean Values: request-based Sharing</h1>
	<h2>Bean level: <jsp:getProperty name="requestBean" property="level" /></h2>
	<h2>Dish bean goes with: <jsp:getProperty name="requestBean" property="goesWith" /></h2>
</html>