package com.crmapp.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.crmapp.model.UsersModel;
import com.crmapp.pojo.Users;


@WebServlet("/login")
public class LoginController extends HttpServlet{
	
	UsersModel usersModel = new UsersModel();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("login.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		
		Users users = usersModel.loginUser(email, password);
		String roleName = users.getRole().getRoleName();
		if (roleName.equals("ROLE_ADMIN")) {
			resp.sendRedirect(req.getContextPath() + "/admin");
		}
			
		else if (roleName.equals("ROLE_LEADER")){
			resp.sendRedirect(req.getContextPath() + "/project");
		}
			
		else if (roleName.equals("ROLE_MEMBER")) {
			resp.sendRedirect(req.getContextPath() + "/userdetail");
		}
			
	}
}
