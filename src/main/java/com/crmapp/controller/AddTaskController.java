package com.crmapp.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.crmapp.model.ProjectModel;
import com.crmapp.model.UsersModel;
import com.crmapp.pojo.Project;
import com.crmapp.pojo.Users;

@WebServlet("/addtask")
public class AddTaskController extends HttpServlet {
	UsersModel usersModel = new UsersModel();
	ProjectModel projectModel = new ProjectModel();
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Users> listUser = usersModel.getListUsers();
		List<Project> listProject = projectModel.getListProject();
		req.setAttribute("listUser", listUser);
		req.setAttribute("listProject", listProject);
		req.getRequestDispatcher("addtask.jsp").forward(req, resp);
	}

}
