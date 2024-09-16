package vn.iotstar.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vn.iotstar.services.IUserService;
import vn.iotstar.services.impl.UserServiceImpl;
import vn.iotstar.utils.Constant;

import java.io.IOException;

@WebServlet(urlPatterns = {"/resetpassword"})
public class ResetPasswordController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ResetPasswordController() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("/views/resetpassword.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");

		String username = request.getParameter("username");
		String newPassword = request.getParameter("newPassword");
		String confirmPassword = request.getParameter("confirmPassword");

		String alertMsg = "";
		IUserService service = new UserServiceImpl();
		if (!service.checkExistUsername(username)) {
			alertMsg = "Tài khoản không tồn tại!";
			request.setAttribute("alert", alertMsg);
			request.getRequestDispatcher(Constant.RESETPASSWORD).forward(request, response);
			return;
		}
		boolean isSuccess = service.updatePassword(username, newPassword);
		if (isSuccess) {
			request.setAttribute("alert", alertMsg);
			response.sendRedirect(request.getContextPath() + "/login");
		} else {
			alertMsg = "System error!";
			request.setAttribute("alert", alertMsg);
			request.getRequestDispatcher(Constant.RESETPASSWORD).forward(request, response);

		}
	}

}
