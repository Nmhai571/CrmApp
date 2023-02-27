package com.crmapp.api;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.crmapp.common.Constant;
import com.crmapp.model.ProjectModel;
import com.crmapp.model.TaskModel;
import com.crmapp.model.UsersModel;
import com.crmapp.pojo.Project;
import com.crmapp.pojo.ResponeData;
import com.crmapp.pojo.Task;
import com.crmapp.pojo.Users;
import com.google.gson.Gson;


@WebServlet("/api/addtask")
public class ApiAddTaskController extends HttpServlet {
	TaskModel taskModel = new TaskModel();
	ProjectModel projectModel = new ProjectModel();
	UsersModel usersModel = new UsersModel();
	List<Project> listProject = projectModel.getListProject();
	List<Users> listUser = usersModel.getListUsers();
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Task task = new Task();
		
		task.setTaskName(req.getParameter("taskname"));
		task.setTaskDes(req.getParameter("taskdes"));
		task.setStartDay(req.getParameter("startday"));
		task.setEndDay(req.getParameter("endday"));
		for(int i = 0; i< listProject.size(); i++) {
			if(listProject.get(i).getProjectName().equals(req.getParameter("project"))) {
				task.setIdProject(listProject.get(i).getId());
			}
		}
		task.setIdStatus(Constant.STATUS);
		for(int i = 0; i<listUser.size(); i++) {
			if(listUser.get(i).getFullName().equals(req.getParameter("user"))) {
				task.setIdUser(listUser.get(i).getId());
			}
		}
		
		boolean isSuccess =  taskModel.insertTask(task);
		
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

