package com.crmapp.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.crmapp.model.ProjectModel;
import com.crmapp.model.StatusTaskModel;
import com.crmapp.model.TaskModel;
import com.crmapp.model.UsersModel;
import com.crmapp.pojo.Project;
import com.crmapp.pojo.StatusTask;
import com.crmapp.pojo.Task;
import com.crmapp.pojo.Users;


@WebServlet("/updatetask")
public class UpdateTaskController extends HttpServlet{
	Task task = new Task();
	TaskModel taskModel = new TaskModel();
	UsersModel usersModel = new UsersModel();
	ProjectModel projectModel = new ProjectModel();
	StatusTaskModel statusTaskModel = new StatusTaskModel();
	List<Users> listUser = usersModel.getListUsers();
	List<Project> listProjects = projectModel.getListProject();
	List<StatusTask> listStatus = statusTaskModel.getListStatus();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("task", task);
		req.setAttribute("listuser", listUser);
		req.setAttribute("listpro", listProjects);
		req.setAttribute("liststatus", listStatus);
		req.getRequestDispatcher("updatetask.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		long id = Long.parseLong(req.getParameter("id")) ;
		task = taskModel.getTaskByID(id);
		
	}
}
