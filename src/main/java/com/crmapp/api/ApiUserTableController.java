package com.crmapp.api;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.crmapp.model.UsersModel;
import com.crmapp.pojo.Users;
import com.google.gson.Gson;

@WebServlet("/api/usertable")
public class ApiUserTableController extends HttpServlet{
	UsersModel usersModel = new UsersModel();
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Users> listUser =  usersModel.getListUsers();
		Gson gson = new Gson();
		String json = gson.toJson(listUser);

		resp.setContentType("application/json");
		resp.setCharacterEncoding("UTF-8");
		
		PrintWriter writer = resp.getWriter();
		writer.write(json);
		writer.flush();
		writer.close();
	}
}
