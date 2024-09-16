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
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/
bootstrap.min.css"
	rel="stylesheet">
<title>Đăng nhập tài khoản</title>
</head>
<%
String username = "";
Cookie[] cookies = request.getCookies();
if (cookies != null) {
	for (Cookie cookie : cookies) {
		if (cookie.getName().equals("username")) {
	username = cookie.getValue();
		}
	}
}
%>
<body>
	<header class="row">
		<div class="col">
			<div class="alert alert-primary col" align="center">
				<h1>Đăng nhập tài khoản</h1>
			</div>
		</div>
	</header>
	<div class="container">
		<div class="row justify-content-center">
			<div class="col-12 col-md-5">
				<form action="/LapTrinhWeb/login" method="post">
					<c:if test="${alert !=null}">
						<h3 class="alert alert-danger">${alert}</h3>
					</c:if>
					<div class="form-group">
						<label for="username">Tên người dùng:</label> <input type="text"
							id="username" name="username" class="form-control"
							value="<%=username%>" />
					</div>
					<div class="form-group">
						<label for="password">Mật khẩu: </label> <input type="password"
							id="password" name="password" class="form-control" />
					</div>
					<div class="form-group">
						<div class="row mb-4">
							<div class="col d-flex justify-content-center">
								<!-- Checkbox -->
								<div class="form-check">
									<input class="form-check-input" type="checkbox" id="rememberme"
										name="remember" /> <label class="form-check-label"
										for="rememberme"> Remember me </label>
								</div>
							</div>

							<div class="col">
								<a
									href="${pageContext.request.contextPath }/views/resetpassword.jsp"
									class="text-decoration-none">Forgot password?</a>
							</div>
						</div>

						<div class="form-group mt-3" align="center">
							<button type="submit" class="btn btn-primary">Đăng nhập</button>
						</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>