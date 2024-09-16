<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- Bootstrap CSS -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/
bootstrap.min.css"
	rel="stylesheet"">
<title>Insert title here</title>
</head>
<body>
	<nav class="navbar navbar-custom">
		<div class="container-fluid">
			<c:choose>
				<c:when test="${sessionScope.account == null}">
					<div class="d-flex justify-content-end">
						<ul class="navbar-nav d-flex flex-row align-items-center">
							<!-- Register and Login Links -->
							<li class="nav-item"><a
								href="${pageContext.request.contextPath }/login"
								class="nav-link">Đăng nhập</a></li>
							<li class="nav-item"><a
								href="${pageContext.request.contextPath }/register"
								class="nav-link">Đăng ký</a></li>
							<!-- Search Icon -->
							<li class="nav-item"><i class="fas fa-search search-button"></i>
							</li>
						</ul>
					</div>
				</c:when>
				<c:otherwise>
					<div class="d-flex justify-content-start">
						<ul class="navbar-nav d-flex flex-row align-items-start">
							<!-- User Account and Logout -->
							<li class="nav-item"><a
								href="${pageContext.request.contextPath }/member/myaccount"
								class="nav-link"> ${sessionScope.account.fullName} </a></li>
							<li class="nav-item"><a
								href="${pageContext.request.contextPath }/logout"
								class="nav-link">Đăng xuất</a></li>
							<!-- Search Icon -->
							<li class="nav-item"><i class="fas fa-search search-button"></i>
							</li>
						</ul>
					</div>
				</c:otherwise>
			</c:choose>
		</div>
	</nav>
	
</body>
</html>