package com.crmapp.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.crmapp.model.ProjectModel;
import com.crmapp.pojo.Project;

@WebServlet("/updateproject")
public class UpdateProjectController extends HttpServlet {
	ProjectModel projectModel = new ProjectModel();
	Project project = new Project();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("project", project);
		req.getRequestDispatcher("updateproject.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		long id = Long.parseLong(req.getParameter("id")) ;
		project = projectModel.getProjectByID(id);
	}
}
