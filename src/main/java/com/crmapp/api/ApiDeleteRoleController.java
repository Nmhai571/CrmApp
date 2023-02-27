package com.crmapp.api;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.crmapp.model.RoleModel;

@WebServlet("/api/deleterole")
public class ApiDeleteRoleController extends HttpServlet {
	RoleModel roleModel = new RoleModel();
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		long id = Long.parseLong(req.getParameter("id")) ;
		roleModel.deleteRole(id);
	}
}
