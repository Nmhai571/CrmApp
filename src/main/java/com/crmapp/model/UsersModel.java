package com.crmapp.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.crmapp.connection.MySqlConnection;
import com.crmapp.pojo.Role;
import com.crmapp.pojo.UserDetail;
import com.crmapp.pojo.Users;

public class UsersModel {
	
	public boolean insertUser(Users usersData) {
		Connection conn = MySqlConnection.getConnection();
		boolean isSuccess = false;
		String insertUser = "insert into users(full_name, email, pass, address, phone_number, role_id) values (?,?,?,?,?,?)";
		try {
			PreparedStatement statement = conn.prepareStatement(insertUser);
			statement.setString(1, usersData.getFullName());
			statement.setString(2, usersData.getEmail());
			statement.setString(3, usersData.getPassword());
			statement.setString(4, usersData.getAddress());
			statement.setString(5, usersData.getPhoneNumber());
			statement.setInt(6, usersData.getRoleId());
			
			int result = statement.executeUpdate();
			
			if(result>0) {
				isSuccess = true;
			}
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return isSuccess;
	}
	
	public Users loginUser(String email, String password) {
		Users users = null;
		Connection conn = MySqlConnection.getConnection();
		String getUsers = "select * from users u join roles r on r.id = u.role_id where email = ? and pass = ?";
		
		try {
			PreparedStatement statement = conn.prepareStatement(getUsers);
			statement.setString(1, email);
			statement.setString(2, password);
			
			ResultSet result = statement.executeQuery();
			while(result.next()) {
				Role role = new Role();
				users = new Users();
				users.setId(result.getLong("id"));
				users.setFullName(result.getString("full_name"));
				users.setEmail(result.getString("email"));
				users.setAddress(result.getString("address"));
				users.setPhoneNumber(result.getString("phone_number"));
				role.setRoleName(result.getString("role_name"));
				users.setRole(role);
				users.setRoleId(result.getInt("role_id"));
			}
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return users;
	}
	
	public List<Users> getListUsers() {
		List<Users> listUser = new ArrayList<>();
		Connection conn = MySqlConnection.getConnection();
		String getUsers = "select * from users u join roles r on r.id = u.role_id";
		
		try {
			PreparedStatement statement = conn.prepareStatement(getUsers);
			
			ResultSet result = statement.executeQuery();
			while(result.next()) {
				Users users = new Users();
				Role role = new Role();
				users.setId(result.getLong("id"));
				users.setFullName(result.getString("full_name"));
				users.setEmail(result.getString("email"));
				users.setAddress(result.getString("address"));
				users.setPhoneNumber(result.getString("phone_number"));
				users.setRoleId(result.getInt("role_id"));
				role.setRoleName(result.getString("role_name"));
				role.setRoleName(result.getString("role_name"));
				users.setRole(role);
				listUser.add(users);
			}
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return listUser;
	}
	
	public boolean deleteUser(Long id) {
		Connection con = MySqlConnection.getConnection();
		boolean rowDeleted = false;
		String deleteUser = "delete from users where id=?";
		try {
			PreparedStatement statement = con.prepareStatement(deleteUser);
			statement.setLong(1, id);
			rowDeleted = statement.executeUpdate() > 0;
			
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rowDeleted;
	}
	
	public boolean updateUser(long id,  String name, String email, String password, String address, String phone) {
		Connection con = MySqlConnection.getConnection();
		String updateUser = "update users set full_name=?, email=?, pass=?, address=?, phone_number=? where id=?;";
		boolean isSuccess = false;
		try {
			PreparedStatement statement = con.prepareStatement(updateUser);
			statement.setString(1, name);
			statement.setString(2, email);
			statement.setString(3, password);
			statement.setString(4, address);
			statement.setString(5, phone);
			statement.setLong(6, id);
			
			isSuccess = statement.executeUpdate()>0;
			
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return isSuccess;
	}
	
	
	
	public Users getUserByID(long id) {
		Users users = null;
		Connection conn = MySqlConnection.getConnection();	
		String getUsers = "select * from users where id =?";
		
		try {
			PreparedStatement statement = conn.prepareStatement(getUsers);
			statement.setLong(1, id);
			ResultSet result = statement.executeQuery();
			while(result.next()) {
				users = new Users();
				users.setId(result.getLong("id"));
				users.setFullName(result.getString("full_name"));
				users.setEmail(result.getString("email"));
				users.setPassword(result.getString("pass"));
				users.setAddress(result.getString("address"));
				users.setPhoneNumber(result.getString("phone_number"));
				users.setRoleId(result.getInt("role_id"));
			}
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return users;
	}
	
	public List<UserDetail> getUserDetail(long id) {
		Connection conn = MySqlConnection.getConnection();	
		List<UserDetail> listUserDetail= new ArrayList<>();
		UserDetail userDetail = null;
		String getUserDetail = "select * from users u  join task t on u.id = t.id_user join status_task st on st.id = t.id_status join project p on t.id_project = p.id where u.id = ?";
		try {
			PreparedStatement statement = conn.prepareStatement(getUserDetail);
			statement.setLong(1, id);
			ResultSet result = statement.executeQuery();
			while(result.next()) {
				userDetail = new UserDetail();
				userDetail.setId(result.getLong("id"));
				userDetail.setFullName(result.getString("full_name"));
				userDetail.setEmail(result.getString("email"));
				userDetail.setStatusTask(result.getString("status_name"));
				userDetail.setStartDay(result.getString("srart_day"));
				userDetail.setEndDay(result.getString("end_day"));
				userDetail.setTaskName(result.getString("task_name"));
				userDetail.setProjectName(result.getString("project_name"));
				listUserDetail.add(userDetail);
			}
			conn.close();
		} catch (SQLException e) {
		}
		
		return listUserDetail;
	}
}
