<%@ page language="java" contentType="text/html; charset=windows-1256"
	pageEncoding="windows-1256"%>
<!DOCTYPE html>

<%@ page import="com.lernia.spring.borrow.api.model.Borrow"%>
<%@ page
	import="com.lernia.spring.borrow.api.repository.BorrowRepository"%>
<%@ page import="com.lernia.spring.borrow.api.service.BorrowService"%>
<%@ page import="org.springframework.beans.factory.annotation.Autowired"%>

<%
	response.setHeader("Cache-Control", "no-cache");
	response.setHeader("Cache-Control", "no-store");
	response.setHeader("Pragma", "no-cache");
	response.setDateHeader("Expires", 0);

	BorrowService userService;
%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta http-equiv="Pragma" content="no-cache">
<meta http-equiv="Cache-Control" content="no-cache">
<meta http-equiv="Expires" content="sat, 01 Dec 2001 00:00:00 GMT">
<title>Ghaiath</title>
<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css"
	rel="stylesheet">
</head>
<body>
	<nav class="navbar navbar-light" style="background-color: #d5d2f4;">
		<div class="container-fluid">
			<div class="navbar-header">
				<a class="navbar-brand" href="/admin/admin-dashboard">Admin
					Dashboard</a>
			</div>
			<ul class="nav navbar-nav">
				<li class="active"><a href="/welcome">Home</a></li>
				<li><a href="/admin/show-all-users">All Users</a></li>
				<li><a href="/admin/show-all-borrows">All Borrrow</a></li>
			</ul>
			<ul class="nav navbar-nav navbar-right">
				<li><a href="/register"><span
						class="glyphicon glyphicon-user"></span> Sign Up</a></li>
				<li><a href="/login"><span
						class="glyphicon glyphicon-log-in"></span> Login</a></li>
			</ul>
		</div>
	</nav>

	<div class="container text-center" id="tasksDiv">
		<h3>All Borrows Requests</h3>
		<hr>
		<div class="table-responsive">
			<table class="table table-striped table-bordered">
				<thead>
					<tr>
						<th>Borrow Id</th>
						<th>User Id</th>
						<th>UserName</th>
						<th>Email</th>
						<th>Rating</th>
						<th>Active</th>
						<th>Requested Amount</th>
						<th>Reason</th>
						<th>Status</th>
						<th>Requested Date</th>
						<th>Approve</th>
						<th>Reject</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="borrow" items="${borrows}">
						<tr>
							<td>${borrow.borrow_id}</td>
							<td>${user.user_id}</td>
							<td>${borrow.user_name}</td>
							<td>${user.email}</td>
							<td>${user.rating}</td>
							<td>${user.active}</td>
							<td>${borrow.requested_amount}</td>
							<td>${borrow.reason}</td>
							<td>${borrow.status}</td>
							<td>${borrow.requested_date}</td>

							<td><a href="/admin/approve-borrow?id=${borrow.borrow_id}"><span
									class="glyphicon glyphicon-ok"></span></a></td>
							<td><a href="/admin/reject-borrow?id=${borrow.borrow_id}"><span
									class="glyphicon glyphicon-remove"></span></a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>

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

</body>
</html>