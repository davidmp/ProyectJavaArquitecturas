<html>
<head>

</head>
<body>
<center>
<table cellpadding="100" border="0"><tr><td valign="middle">
<center>
<h3 style="color:red">Sesión cerrada, ...gracias</h3>
</center>
</td></tr></table>
<%
	HttpSession hs = request.getSession(false);
		hs.invalidate();
%>
</center>
<meta http-equiv='Refresh' content='0; URL=${pageContext.request.contextPath}/'>
</body>
</html>