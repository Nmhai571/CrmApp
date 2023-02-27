package com.crmapp.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.crmapp.connection.MySqlConnection;
import com.crmapp.pojo.Role;
import com.crmapp.pojo.Users;

public class RoleModel {
	
	public boolean insertRole(Role rolesData) {
		Connection conn = MySqlConnection.getConnection();
		boolean isSuccess = false;
		String insertRole = "insert into roles(role_name, description_role) values (?,?)";
		try {
			PreparedStatement statement = conn.prepareStatement(insertRole);
			statement.setString(1, rolesData.getRoleName());
			statement.setString(2, rolesData.getDescriptionRole());
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
	
	
	public List<Role> getListRoles() {
		List<Role> listRoles = new ArrayList<>();
		Connection conn = MySqlConnection.getConnection();
		String getRoles = "select * from roles";
		
		try {
			PreparedStatement statement = conn.prepareStatement(getRoles);
			
			ResultSet result = statement.executeQuery();
			while(result.next()) {
				Role roles = new Role();
				roles.setId(result.getLong("id"));
				roles.setRoleName(result.getString("role_name"));
				roles.setDescriptionRole(result.getString("description_role"));
				listRoles.add(roles);
			}
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return listRoles;
	}
	
	public boolean deleteRole(Long id) {
		Connection con = MySqlConnection.getConnection();
		boolean rowDeleted = false;
		String deleteRole= "delete from roles where id=?";
		try {
			PreparedStatement statement = con.prepareStatement(deleteRole);
			statement.setLong(1, id);
			rowDeleted = statement.executeUpdate() > 0;
			
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rowDeleted;
	}
	
	public boolean updateRole(long id,  String roleName, String roleDes) {
		Connection con = MySqlConnection.getConnection();
		String updateRole = "update roles set role_name=?, description_role=? where id=?;";
		boolean isSuccess = false;
		try {
			PreparedStatement statement = con.prepareStatement(updateRole);
			statement.setString(1, roleName);
			statement.setString(2, roleDes);
			statement.setLong(3, id);
			
			isSuccess = statement.executeUpdate()>0;
			
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return isSuccess;
	}
	
	public Role getRoleByID(long id) {
		Role roles = null;
		Connection conn = MySqlConnection.getConnection();	
		String getRoles = "select * from roles where id =?";
		
		try {
			PreparedStatement statement = conn.prepareStatement(getRoles);
			statement.setLong(1, id);
			ResultSet result = statement.executeQuery();
			while(result.next()) {
				roles = new Role();
				roles.setId(result.getLong("id"));
				roles.setRoleName(result.getString("role_name"));
				roles.setDescriptionRole(result.getString("description_role"));	
			}
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return roles;
	}
}
