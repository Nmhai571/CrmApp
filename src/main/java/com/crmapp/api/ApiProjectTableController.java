package com.crmapp.api;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.crmapp.model.ProjectModel;
import com.crmapp.pojo.Project;
import com.google.gson.Gson;

@WebServlet("/api/projecttable")
public class ApiProjectTableController extends HttpServlet{
	ProjectModel projectModel = new ProjectModel();
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Project> listRole =  projectModel.getListProject();
		
		Gson gson = new Gson();
		String json = gson.toJson(listRole);
		
		resp.setContentType("application/json");
		resp.setCharacterEncoding("UTF-8");
		
		PrintWriter writer = resp.getWriter();
		writer.write(json);
		writer.flush();
		writer.close();
	}
}
