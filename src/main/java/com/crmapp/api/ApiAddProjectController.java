package com.crmapp.api;

import java.io.IOException;
import java.io.PrintWriter;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.crmapp.model.ProjectModel;
import com.crmapp.pojo.Project;
import com.crmapp.pojo.ResponeData;
import com.google.gson.Gson;




@WebServlet("/api/addproject")
public class ApiAddProjectController extends HttpServlet {
	ProjectModel projectModel = new ProjectModel();
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Project project = new Project();
		project.setProjectName(req.getParameter("projectname"));
		project.setStartDay(req.getParameter("startday"));
		project.setEndDay(req.getParameter("endday"));
		project.setProjectDescription(req.getParameter("description"));
		
		
		boolean isSuccess =  projectModel.insertProject(project);
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
