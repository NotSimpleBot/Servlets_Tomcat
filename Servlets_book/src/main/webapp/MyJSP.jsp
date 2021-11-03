<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>First JSP</title>
    <head>

    <body>
		<h1>Testing JSP</h1>
		<p>
			<% java.util.Date now = new java.util.Date();
			String someStr = "Now Date:   " + now;%>
			<%= someStr  %>
		</p>
    </body>
</html>