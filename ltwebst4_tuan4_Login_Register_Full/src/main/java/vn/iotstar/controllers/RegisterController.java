package vn.iotstar.controllers;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import vn.iotstar.dao.impl.UserDao;
import vn.iotstar.models.User;
import vn.iotstar.services.IUserService;
import vn.iotstar.services.impl.UserServiceImpl;
import vn.iotstar.utils.Constant;

import java.io.IOException;
import java.sql.Date;

@WebServlet(urlPatterns = { "/register" })
public class RegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public RegisterController() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		if (session != null && session.getAttribute("username") != null) {
			response.sendRedirect(request.getContextPath() + "/admin");
			return;
		}
		// Check cookie
		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				if (cookie.getName().equals("username")) {
					session = request.getSession(true);
					session.setAttribute("username", cookie.getValue());
					response.sendRedirect(request.getContextPath() + "/admin");
					return;
				}
			}
		}
		request.getRequestDispatcher(Constant.REGISTER).forward(request, response);
	}

	@SuppressWarnings("static-access")
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		String fullname = request.getParameter("fullname");
		String phone = request.getParameter("phone");
		String images = request.getParameter("images");
		
		IUserService service = new UserServiceImpl();
		String alertMsg = "";
		if (service.checkExistEmail(email)) {
			alertMsg = "Email đã tồn tại!";
			request.setAttribute("alert", alertMsg);
			request.getRequestDispatcher(Constant.REGISTER).forward(request, response);
			return;
		}
		if (service.checkExistUsername(username)) {
			alertMsg = "Tài khoản đã tồn tại!";
			request.setAttribute("alert", alertMsg);
			request.getRequestDispatcher(Constant.REGISTER).forward(request, response);
			return;
		}
		boolean isSuccess = service.register(username, email, fullname, images ,password,phone);
		if (isSuccess) {
			// SendMail sm = new SendMail();
			// sm.sendMail(email, "Shopping.iotstar.vn", "Welcome to Shopping. Please Login
			// to use
			// service. Thanks !");
			request.setAttribute("alert", alertMsg);
			response.sendRedirect(request.getContextPath() + "/login");
		} else {
			alertMsg = "System error!";
			request.setAttribute("alert", alertMsg);
			request.getRequestDispatcher(Constant.REGISTER).forward(request, response);

		}
	}
}
