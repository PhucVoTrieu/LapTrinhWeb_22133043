package vn.iotstar.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import vn.iotstar.models.User;

import java.io.IOException;

@WebServlet(urlPatterns = "/waiting")
public class WaitingController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public WaitingController() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		if (session != null && session.getAttribute("account") != null) {
			User u = (User) session.getAttribute("account");
			request.setAttribute("fullname", u.getFullname());
			if (u.getRoleid() == 2) {
				response.sendRedirect(request.getContextPath() + "/admin/home");
			} else if (u.getRoleid() == 3) {
				response.sendRedirect(request.getContextPath() + "/manager/home");
			} else {
//				response.sendRedirect(request.getContextPath() + "/home");
				request.getRequestDispatcher("/home").forward(request, response);
			}
		} else {
			response.sendRedirect(request.getContextPath() + "/login");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
