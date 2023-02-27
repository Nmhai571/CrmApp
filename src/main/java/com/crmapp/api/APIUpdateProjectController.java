package com.crmapp.api;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.crmapp.model.ProjectModel;
import com.crmapp.pojo.Project;


@WebServlet("/api/updateproject")
public class APIUpdateProjectController extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Project project = new Project();
		ProjectModel projectModel = new ProjectModel();
		long id = Long.parseLong(req.getParameter("uid")) ;
		String name = req.getParameter("uname");
		String startDay =req.getParameter("ustart");
		String endDay = req.getParameter("uend");
		String Des = req.getParameter("udes");
		projectModel.updateProject(id, name, Des, startDay, endDay);
	}
}
