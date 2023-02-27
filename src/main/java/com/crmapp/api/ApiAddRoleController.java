package com.crmapp.api;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.crmapp.model.RoleModel;
import com.crmapp.pojo.ResponeData;
import com.crmapp.pojo.Role;
import com.google.gson.Gson;


@WebServlet("/api/addrole")
public class ApiAddRoleController extends HttpServlet{
	
	RoleModel roleModel = new RoleModel();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Role role = new Role();
		role.setRoleName(req.getParameter("rolename"));
		role.setDescriptionRole(req.getParameter("descriptionname"));
		
		boolean isSuccess =  roleModel.insertRole(role);
		
		ResponeData responeData = new ResponeData();
		responeData.setSuccess(isSuccess);
		
		if(isSuccess) {
			responeData.setMessage("thanh cong");
		}
		else {
			responeData.setMessage("that bai");
		}
		
		Gson gson = new Gson();
		String json = gson.toJson(responeData);
		
		resp.setContentType("application/json");
		resp.setCharacterEncoding("UTF-8");
		PrintWriter writer = resp.getWriter();
		writer.write(json);
		writer.flush();
		writer.close();
		
		
	}
}
