package com.crmapp.api;

import java.io.IOException;
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

@WebServlet("/api/updatetask")
public class ApiUpdateTaskController extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Task task = new Task();
		TaskModel taskModel = new TaskModel();
		ProjectModel projectModel = new ProjectModel();
		UsersModel usersModel = new UsersModel();
		StatusTaskModel statusTaskModel = new StatusTaskModel();
		List<Project> listProject = projectModel.getListProject();
		List<Users> listUser = usersModel.getListUsers();
		List<StatusTask> listStatus = statusTaskModel.getListStatus();
		long id = Long.parseLong(req.getParameter("idTask")) ;
		String taskName = req.getParameter("taskname");
		String taskDes = req.getParameter("taskdes");
		String startDay = req.getParameter("startday");
		String endDay = req.getParameter("endday");
		long idProject = 0;
		long idStatus = 0;
		long idUser = 0;
		for(int i = 0; i<listProject.size(); i++) {
			if(listProject.get(i).getProjectName().equals(req.getParameter("project"))) {
				idProject = listProject.get(i).getId();
			}
		}
		for(int i = 0; i<listUser.size(); i++) {
			if(listUser.get(i).getFullName().equals(req.getParameter("user"))) {
				idUser = listUser.get(i).getId();
			}
		}
		for(int i = 0; i<listStatus.size(); i++) {
			if(listStatus.get(i).getStatusName().equals(req.getParameter("status"))) {
				idStatus = listStatus.get(i).getId();
			}
		}
		
		
		taskModel.updateTask(id, taskName, taskDes, startDay, endDay, idProject, idStatus, idUser);
		
	}

}
