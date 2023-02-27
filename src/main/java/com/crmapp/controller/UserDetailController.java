package com.crmapp.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.crmapp.model.UsersModel;
import com.crmapp.pojo.UserDetail;
import com.google.gson.Gson;

@WebServlet("/userdetail")
public class UserDetailController extends HttpServlet{
	UsersModel usersModel = new UsersModel();
	UserDetail userDetail = new UserDetail();
	List<UserDetail> listUser = new ArrayList<>();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setAttribute("listuserdetail", listUser);
		req.getRequestDispatcher("userdetail.jsp").forward(req, resp);
		
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		long id = Long.parseLong(req.getParameter("id")) ; 
		listUser = usersModel.getUserDetail(id);
	}
}	
