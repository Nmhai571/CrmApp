package com.crmapp.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.crmapp.common.Constant;
import com.crmapp.model.UsersModel;
import com.crmapp.pojo.Users;

@WebServlet("/adduser")
public class AddUserController extends HttpServlet{
	
	UsersModel usersModel = new UsersModel();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.getRequestDispatcher("adduser.jsp").forward(req, resp);
	}
	
	
}
