package com.crmapp.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import com.crmapp.connection.MySqlConnection;
import com.crmapp.pojo.Project;
import com.crmapp.pojo.StatusTask;
import com.crmapp.pojo.Task;
import com.crmapp.pojo.Users;

public class TaskModel {
	public boolean insertTask(Task taskData) {
		Connection conn = MySqlConnection.getConnection();
		boolean isSuccess = false;
		String insertTask = "insert into task(task_name, task_description_task, srart_day, end_day, id_project, id_status, id_user) values (?,?,?,?,?,?,?)";
		try {
			PreparedStatement statement = conn.prepareStatement(insertTask);
			statement.setString(1, taskData.getTaskName());
			statement.setString(2, taskData.getTaskDes());
			String projectDateStart = taskData.getStartDay();
			DateFormat df = new SimpleDateFormat("dd/MM/yyyy"); 
			Date startDate = df.parse(projectDateStart);
			DateFormat df2 = new SimpleDateFormat("yyyy-MM-dd");
            String startDate2 = df2.format(startDate);
			statement.setString(3, startDate2);
			
			String projectDateEnd = taskData.getEndDay();
			DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy"); 
			Date EndDate = dateFormat.parse(projectDateEnd);
			DateFormat dateFormat1 = new SimpleDateFormat("yyyy-MM-dd");
            String endDate2 = df2.format(EndDate);
			statement.setString(4, endDate2);
			
			statement.setLong(5, taskData.getIdProject());
			statement.setLong(6, taskData.getIdStatus());
			statement.setLong(7, taskData.getIdUser());
			
			
			
			/*
			 * 05/08/2022 -> 2022-08-05
			 * myDate -> startDayString2
			 * */
			
			
			int result = statement.executeUpdate();
			
			if(result>0) {
				isSuccess = true;
			}
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return isSuccess;
	}
	
	public List<Task> getListTask() {
		List<Task> listTasks = new ArrayList<>();
		
		Connection conn = MySqlConnection.getConnection();
		String getTasks = "select * from task t join users u on t.id_user = u.id join status_task st on t.id_status = st.id join project p on p.id = t.id_project";
		
		try {
			PreparedStatement statement = conn.prepareStatement(getTasks);
			
			ResultSet result = statement.executeQuery();
			while(result.next()) {
				Task task = new Task();
				Project project = new Project();
				Users users = new Users();
				StatusTask statusTask = new StatusTask();
				task.setId(result.getLong("id"));
				task.setTaskName(result.getString("task_name"));
				task.setTaskDes(result.getString("task_description_task"));
				task.setStartDay(result.getString("srart_day"));
				task.setEndDay(result.getString("end_day"));
				project.setProjectName(result.getString("project_name"));
				task.setProject(project);
				users.setFullName(result.getString("full_name"));
				task.setUsers(users);
				statusTask.setStatusName(result.getString("status_name"));
				task.setStatusTask(statusTask);
				listTasks.add(task);
	
			}
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return listTasks;
	}
	
	
	public boolean deleteTask(Long id) {
		Connection con = MySqlConnection.getConnection();
		boolean rowDeleted = false;
		String deleteTask = "delete from task where id=?";
		try {
			PreparedStatement statement = con.prepareStatement(deleteTask);
			statement.setLong(1, id);
			rowDeleted = statement.executeUpdate() > 0;
			
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rowDeleted;
	}
	
	public boolean updateTask(long id,  String taskName, String taskDes, String startDay, String endDay, long idProject, long idStatus, long idUser) {
		Connection con = MySqlConnection.getConnection();
		String updateTask = "update task set task_name=?, task_description_task=?, srart_day=?, end_day=?, id_project=?, id_status=?, id_user=? where id=?;";
		boolean isSuccess = false;
		try {
			PreparedStatement statement = con.prepareStatement(updateTask);
			statement.setString(1, taskName);
			statement.setString(2, taskDes);
			statement.setString(3, startDay);
			statement.setString(4, endDay);
			statement.setLong(5, idProject);
			statement.setLong(6, idStatus);
			statement.setLong(7, idUser);
			statement.setLong(8, id);
			
			isSuccess = statement.executeUpdate()>0;
			
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return isSuccess;
	}
	
	public Task getTaskByID(long id) {
		Task task = null;
		Connection conn = MySqlConnection.getConnection();	
		String getTasks = "select * from task t join users u on t.id_user = u.id join status_task st on t.id_status = st.id join project p on p.id = t.id_project where t.id =?";
		try {
			PreparedStatement statement = conn.prepareStatement(getTasks);
			statement.setLong(1, id);
			ResultSet result = statement.executeQuery();
			while(result.next()) {
				task = new Task();
				Project project = new Project();
				Users users = new Users();
				StatusTask statusTask = new StatusTask();
				task.setId(result.getLong("id"));
				task.setTaskName(result.getString("task_name"));
				task.setTaskDes(result.getString("task_description_task"));
				task.setStartDay(result.getString("srart_day"));
				task.setEndDay(result.getString("end_day"));
				task.setIdProject(result.getLong("id_project"));
				project.setProjectName(result.getString("project_name"));
				task.setProject(project);
				task.setIdUser(result.getLong("id_user"));
				users.setFullName(result.getString("full_name"));
				task.setUsers(users);
				task.setIdStatus(result.getLong("id_status"));
				statusTask.setStatusName(result.getString("status_name"));
				task.setStatusTask(statusTask);
				
			}
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return task;
	}
}
