package com.crmapp.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.crmapp.model.UsersModel;
import com.crmapp.pojo.Users;
import com.google.gson.Gson;

@WebServlet("/updateuser")
public class UpdateUserController extends HttpServlet {
	UsersModel usersModel = new UsersModel();
	Users users = new Users();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("user", users);
		req.getRequestDispatcher("updateuser.jsp").forward(req, resp);
		
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		long id = Long.parseLong(req.getParameter("id")) ;
		users = usersModel.getUserByID(id);
		
	}
	
}
