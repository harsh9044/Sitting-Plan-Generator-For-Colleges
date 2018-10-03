<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<H1>Download Notes Here<H1>
</head>
<body>
<%
//allow access only if session exists
String user = null;
if(session.getAttribute("user") == null)
{
	response.sendRedirect("login.jsp");
}
else 
	
System.out.print("Session True");
	
%>
<br>

<form action="Transmit" method="post">
Enter your CRcode Here
<input type="text" value="t1" name="tablename" ><br>
<input type="submit" value="GO" ><br>

<br><br><br><br>


<a href="logout.jsp">Logout</a>
</form>
</body>
</html>