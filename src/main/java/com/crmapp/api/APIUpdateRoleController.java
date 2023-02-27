package com.crmapp.api;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.crmapp.model.RoleModel;
import com.crmapp.pojo.Role;

@WebServlet("/api/updaterole")
public class APIUpdateRoleController extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Role role = new Role();
		RoleModel roleModel = new RoleModel();
		long id = Long.parseLong(req.getParameter("idrole")) ;
		String roleName = req.getParameter("urolename");
		String roleDes =req.getParameter("udescription");
		roleModel.updateRole(id, roleName, roleDes);

	}
}
