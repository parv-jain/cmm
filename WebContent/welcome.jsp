<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="dao.User"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Welcome</title>
</head>
<body>
<% 
if(session.getAttribute("user")==null){
	out.println("No user session exists. <a href='index.html'>Login here</a>");
}
else{
	String user = (String) session.getAttribute("user");
	out.print("Welcome, " + user);
	out.print("<br>Zone, " + User.getZone(user));
	out.print("<br>Division, " + User.getDivision(user));
	out.print("<br>Depot, " + User.getDepot(user));
	%>
	<ul>
	<li><a href="Action?action=zone">Zone wise report</a></li>
	<li><a href="Action?action=division">Division wise report</a></li>
	<li><a href="Action?action=depot">Depot wise report</a></li>
	<li><a href="Action?action=logout">Logout</a></li>
	</ul>
	<%
}
%>

</body>
</html>