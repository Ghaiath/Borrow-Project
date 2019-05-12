<%@ page language="java" contentType="text/html; charset=windows-1256"
	pageEncoding="windows-1256"%>
<!DOCTYPE html >
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
	<nav class="navbar navbar-inverse">
		<div class="container-fluid">
			<div class="navbar-header">
				<a class="navbar-brand" href="/welcome">Lernia</a>
			</div>
			<ul class="nav navbar-nav">
				<li class="active"><a href="/welcome">Home</a></li>
			</ul>
			<ul class="nav navbar-nav navbar-right">
				<li><a href="/register"><span
						class="glyphicon glyphicon-user"></span> Sign Up</a></li>
				<li><a href="/login"><span
						class="glyphicon glyphicon-log-in"></span> Login</a></li>
				<li><a href="/admin/admin-dashboard"><span
						class="glyphicon glyphicon-tower"></span> Admin Dashboard</a></li>
			</ul>
		</div>
	</nav>

	<c:choose>
		<c:when test="${mode=='MODE_HOME'}">
			<div class="container" id="homediv">
				<div class="jumbotron text-center">
					<h2>Welcome to Lernia auto borrowing system</h2>
					<h3>Click on the option you want on the navbar</h3>
				</div>

				<div id="myCarousel" class="carousel slide" data-ride="carousel">
					<!-- Indicators -->
					<ol class="carousel-indicators">
						<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
						<li data-target="#myCarousel" data-slide-to="1"></li>
						<li data-target="#myCarousel" data-slide-to="2"></li>
					</ol>

					<!-- Wrapper for slides -->
					<div class="carousel-inner">
						<div class="item active">
							<img
								src="https://www.naturespicsonline.com/system/carousel_image/file/212/61.jpg"
								alt="Los Angeles">
						</div>

						<div class="item">
							<img
								src="https://www.naturespicsonline.com/system/carousel_image/file/209/58.jpg"
								alt="Chicago">
						</div>

						<div class="item">
							<img
								src="https://www.naturespicsonline.com/system/carousel_image/file/214/63.jpg"
								alt="New York">
						</div>
					</div>

					<!-- Left and right controls -->
					<a class="left carousel-control" href="#myCarousel"
						data-slide="prev"> <span
						class="glyphicon glyphicon-chevron-left"></span> <span
						class="sr-only">Previous</span>
					</a> <a class="right carousel-control" href="#myCarousel"
						data-slide="next"> <span
						class="glyphicon glyphicon-chevron-right"></span> <span
						class="sr-only">Next</span>
					</a>
				</div>
			</div>
		</c:when>

		<c:when test="${mode=='MODE_UPDATE'}">
			<div class="container text-center">
				<h3>Update User</h3>
				<hr>
				<form class="form-horizontal" method="POST" action="update-user">
					<input type="hidden" name="id" value="${user.user_id}" />

					<div class="form-group">
						<label class="control-label col-md-3">Personal Number</label>
						<div class="col-md-7">
							<input type="text" class="form-control" name="personalNumber"
								title="Please enter exactly 12 digits"
								pattern="^(19|20)?[0-9]{6}[- ]?[0-9]{4}$"
								value="${user.personalNumber}" required maxlength="12" readonly />
						</div>
					</div>

					<div class="form-group">
						<label class="control-label col-md-3">Username</label>
						<div class="col-md-7">
							<input type="text" class="form-control" name="userName"
								value="${user.userName}" readonly />
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-md-3">First Name</label>
						<div class="col-md-7">
							<input type="text" class="form-control" name="firstName"
								value="${user.firstName}" />
						</div>
					</div>

					<div class="form-group">
						<label class="control-label col-md-3">Last Name</label>
						<div class="col-md-7">
							<input type="text" class="form-control" name="lastName"
								value="${user.lastName}" />
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-md-3">Address</label>
						<div class="col-md-7">
							<input type="text" class="form-control" name="address"
								value="${user.address}" />
						</div>
					</div>

					<div class="form-group">
						<label class="control-label col-md-3">Email</label>
						<div class="col-md-7">
							<input type="email" class="form-control" name="email"
								value="${user.email}" readonly />
						</div>
					</div>

					<div class="form-group">
						<label class="control-label col-md-3">Phone Number</label>
						<div class="col-md-7">
							<input type="text" class="form-control" name="phone"
								value="${user.phone}" />
						</div>
					</div>

					<div class="form-group">
						<label class="control-label col-md-3">Password</label>
						<div class="col-md-7">
							<input type="password" class="form-control" name="password"
								value="" />
						</div>
					</div>

					<div class="form-group ">
						<input type="submit" class="btn btn-primary" value="Update" />
					</div>
				</form>
			</div>
		</c:when>
	</c:choose>

	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
	<!-- Include all compiled plugins (below), or include individual files as needed -->
	<script
		src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.1/js/bootstrap.min.js"></script>
</body>
</html>