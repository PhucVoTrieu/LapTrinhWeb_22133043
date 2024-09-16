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
<title>Đặt lại mật khẩu</title>
</head>

<body>
	<div class="bg-light py-3 py-md-5">
		<div class="container">
			<div class="row justify-content-md-center">
				<div class="col-12 col-md-11 col-lg-8 col-xl-7 col-xxl-6">
					<div class="bg-white p-4 p-md-5 rounded shadow-sm">
						<div class="row">
							<div class="col-12">
								<div class="mb-5" align="center">
									<h3>Reset Password</h3>
								</div>
							</div>
						</div>
						<!-- Form with client-side validation -->
						<form action="/LapTrinhWeb/resetpassword" method="post"
							class="needs-validation" id="resetPasswordForm" novalidate>
							<c:if test="${alert !=null}">
								<h5 class="alert alert-danger">${alert}</h5>
							</c:if>
							<div class="row gy-3 gy-md-4 overflow-hidden">
								<!-- Email Field -->
								<div class="col-12">
									<label for="username" class="form-label">User name <span
										class="text-danger">*</span></label> <input type="text"
										class="form-control" name="username" id="username" required>
								</div>

								<!-- New Password Field -->
								<div class="col-12">
									<label for="newPassword" class="form-label">Password <span
										class="text-danger">*</span></label> <input type="password"
										minlength="6" class="form-control" name="newPassword"
										id="newpassword" required>
									<div class="invalid-feedback">Password must be at least 6
										characters long.</div>
								</div>

								<!-- Confirm Password Field -->
								<div class="col-12">
									<label for="confirmPassword" class="form-label">Confirm
										Password<span class="text-danger">*</span>
									</label> <input type="password" class="form-control"
										name="confirmPassword" minlength="6" id="confirmPassword"
										required>
									<div class="invalid-feedback">Please confirm your
										password.</div>
									<div class="password-mismatch text-danger d-none">
										Passwords do not match. Please try again.</div>
								</div>

								<div class="col-12">
									<div class="d-grid">
										<button class="btn btn-lg btn-primary" type="submit">Confirm</button>
									</div>
								</div>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>

	<!-- Bootstrap and JS for validation -->
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"></script>
	<script>
		// Custom validation script for comparing passwords
		(function() {
			'use strict';

			// Fetch form and listen to submit event
			var form = document.getElementById('resetPasswordForm');

			form.addEventListener('submit', function(event) {
				// Check form validity and prevent submission if invalid
				if (!form.checkValidity()) {
					event.preventDefault();
					event.stopPropagation();
				}

				// Compare passwords
				var newPassword = document.getElementById('newpassword').value;
				var confirmPassword = document
						.getElementById('confirmPassword').value;

				if (newPassword !== confirmPassword) {
					// Show mismatch error and prevent form submission
					event.preventDefault();
					event.stopPropagation();
					document.querySelector('.password-mismatch').classList
							.remove('d-none');
					document.getElementById('confirmPassword').classList
							.add('is-invalid');
				} else {
					document.querySelector('.password-mismatch').classList
							.add('d-none');
					document.getElementById('confirmPassword').classList
							.remove('is-invalid');
				}

				// Add was-validated class to form for Bootstrap styling
				form.classList.add('was-validated');
			}, false);
		})();
	</script>
</body>
</html>
