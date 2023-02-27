package com.crmapp.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.crmapp.model.RoleModel;
import com.crmapp.pojo.Role;

@WebServlet("/updaterole")
public class UpdateRoleController extends HttpServlet {
	Role role = new Role();
	RoleModel roleModel = new RoleModel();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("role", role);
		req.getRequestDispatcher("updaterole.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		long id = Long.parseLong(req.getParameter("id")) ;
		role = roleModel.getRoleByID(id);
	}
}
