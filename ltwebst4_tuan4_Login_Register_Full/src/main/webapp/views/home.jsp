<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- Bootstrap CSS -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet">
<title>Trang chủ</title>
</head>
<body class="d-flex flex-column min-vh-100">
	<!-- Navbar -->
	<nav class="navbar navbar-expand-lg navbar-light bg-light">
		<div class="container-fluid">
			<a class="navbar-brand" href="#">Quản lý</a>
			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarNav"
				aria-controls="navbarNav" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarNav">
				<ul class="navbar-nav ms-auto">
					<li class="nav-item"><a class="nav-link active" href="#">Home</a>
					</li>
					<li class="nav-item"><a class="nav-link active" href="#">Privacy</a>
					</li>
					<li class="nav-item"><a
						href="${pageContext.request.contextPath }/logout" class="nav-link">Đăng
							xuất</a></li>
				</ul>
			</div>
		</div>
	</nav>

	<!-- Main Content -->
	<div class="container text-center mt-5 flex-grow-1">
		<h2>Welcome, ${fullname}</h2>
	</div>

	<!-- Footer -->
	<footer class="bg-light py-3 mt-auto">
		<div class="container text-center">
			<span class="text-muted">&copy; 2024 - QuanLy - <a href="#"
				class="text-muted">Privacy</a></span>
		</div>
	</footer>
</body>
</html>
