package com.crmapp.api;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.crmapp.model.ProjectModel;

@WebServlet("/api/deleteproject")
public class ApiDeleteProjectController extends HttpServlet {
	ProjectModel projectModel = new ProjectModel();
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		long id = Long.parseLong(req.getParameter("id")) ;
		projectModel.deleteProject(id);
	}
}
