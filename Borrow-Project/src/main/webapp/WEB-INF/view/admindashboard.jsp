<%@ page language="java" contentType="text/html; charset=windows-1256"
	pageEncoding="windows-1256"%>
<%@page import="org.springframework.security.core.Authentication"%>
<%@page
	import="org.springframework.security.core.context.SecurityContextHolder"%>
<!DOCTYPE html >
<%
	response.setHeader("Cache-Control", "no-cache");
	response.setHeader("Cache-Control", "no-store");
	response.setHeader("Pragma", "no-cache");
	response.setDateHeader("Expires", 0);
	Authentication auth2 = SecurityContextHolder.getContext().getAuthentication();
	String userName = auth2.getName();
%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta http-equiv="Pragma" content="no-cache">
<meta http-equiv="Cache-Control" content="no-cache">
<meta http-equiv="Expires" content="sat, 01 Dec 2001 00:00:00 GMT">
<title>Admin Dashboard | Home</title>
<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css"
	rel="stylesheet">
</head>
<body>
	<nav class="navbar navbar-light" style="background-color: #d5d2f4;">
		<div class="container-fluid">
			<div class="navbar-header">
				<a class="navbar-brand" href="/admin/admin-dashboard">Admin Dashboard</a>
			</div>
			<ul class="nav navbar-nav">
				<li class="active"><a href="/welcome">Home</a></li>
				<li><a href="/admin/show-all-borrows">All Borrrow</a></li>
			</ul>
		</div>
	</nav>

	<h1>
		Welcome
		<%=userName%>
		And Your Role is
		<%=auth2.getAuthorities().toString()%>
	</h1>

	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
	<!-- Include all compiled plugins (below), or include individual files as needed -->
	<script
		src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.1/js/bootstrap.min.js"></script>
	<script type="text/javascript">
		$(document).ready(function() {

			window.setTimeout(function() {
				$(".alert").fadeTo(1000, 0).slideUp(1000, function() {
					$(this).remove();
				});
			}, 5000);

		});
	</script>

	<script type="text/javascript">
	#foo {
		  resize: none;
		}
	</script>

</body>
</html>