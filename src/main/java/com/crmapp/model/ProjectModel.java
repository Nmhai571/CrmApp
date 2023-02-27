package com.crmapp.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import com.crmapp.connection.MySqlConnection;
import com.crmapp.pojo.Project;
import com.crmapp.pojo.Users;

public class ProjectModel {
	public boolean insertProject(Project projectData) {
		Connection conn = MySqlConnection.getConnection();
		boolean isSuccess = false;
		String insertProject = "insert into project(project_name, start_day, end_day, project_description) values (?,?,?,?)";
		try {
			PreparedStatement statement = conn.prepareStatement(insertProject);
			statement.setString(1, projectData.getProjectName());
			String projectDateStart = projectData.getStartDay();
			DateFormat df = new SimpleDateFormat("dd/MM/yyyy"); 
			Date startDate = df.parse(projectDateStart);
			DateFormat df2 = new SimpleDateFormat("yyyy-MM-dd");
            String startDate2 = df2.format(startDate);
			statement.setString(2, startDate2);
			
			String projectDateEnd = projectData.getEndDay();
			DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy"); 
			Date EndDate = dateFormat.parse(projectDateEnd);
			DateFormat dateFormat1 = new SimpleDateFormat("yyyy-MM-dd");
            String endDate2 = dateFormat1.format(EndDate);
			statement.setString(3, endDate2);
			statement.setString(4, projectData.getProjectDescription());
			
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
	
	
	
	public List<Project> getListProject() {
		List<Project> listProject = new ArrayList<>();
		Connection conn = MySqlConnection.getConnection();
		String getProject = "select * from project";
		
		try {
			PreparedStatement statement = conn.prepareStatement(getProject);
			

			ResultSet result = statement.executeQuery();
			while(result.next()) {
				Project project = new Project();
				project.setId(result.getLong("id"));
				project.setProjectName(result.getString("project_name"));
				project.setProjectDescription(result.getString("project_description"));
				project.setStartDay(result.getString("start_day"));
				project.setEndDay(result.getString("end_day"));
				listProject.add(project);
			}
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		
		}
		return listProject;
	}
	
	public boolean deleteProject(Long id) {
		Connection con = MySqlConnection.getConnection();
		boolean rowDeleted = false;
		String deleteProject = "delete from project where id=?";
		try {
			PreparedStatement statement = con.prepareStatement(deleteProject);
			statement.setLong(1, id);
			rowDeleted = statement.executeUpdate() > 0;
			
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rowDeleted;
	}
	
	public boolean updateProject(long id,  String name, String des, String startDay, String endDay) {
		Connection con = MySqlConnection.getConnection();
		String updateProject = "update project set project_name=?, project_description=?, start_day=?, end_day=? where id=?;";
		boolean isSuccess = false;
		try {
			PreparedStatement statement = con.prepareStatement(updateProject);
			statement.setString(1, name);
			statement.setString(2, des);
			statement.setString(3, startDay);
			statement.setString(4, endDay);
			statement.setLong(5, id);
			
			isSuccess = statement.executeUpdate()>0;
			
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return isSuccess;
	}
	
	public Project getProjectByID(long id) {
		Project project = null;
		Connection conn = MySqlConnection.getConnection();	
		String getProject = "select * from project where id =?";
		
		try {
			PreparedStatement statement = conn.prepareStatement(getProject);
			statement.setLong(1, id);
			ResultSet result = statement.executeQuery();
			while(result.next()) {
				project = new Project();
				project.setId(result.getLong("id"));
				project.setProjectName(result.getString("project_name"));
				project.setProjectDescription(result.getString("project_description"));
				project.setStartDay(result.getString("start_day"));
				project.setEndDay(result.getString("end_day"));
				
			}
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return project;
	}
}

