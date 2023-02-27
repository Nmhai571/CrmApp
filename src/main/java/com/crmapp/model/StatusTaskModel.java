package com.crmapp.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.crmapp.connection.MySqlConnection;
import com.crmapp.pojo.StatusTask;

public class StatusTaskModel {
	public List<StatusTask> getListStatus() {
		List<StatusTask> listStatus = new ArrayList<>();
		Connection conn = MySqlConnection.getConnection();
		String getStatus= "select * from status_task";
		
		try {
			PreparedStatement statement = conn.prepareStatement(getStatus);
			
			ResultSet result = statement.executeQuery();
			while(result.next()) {
				StatusTask statusTask = new StatusTask();
				statusTask.setId(result.getLong("id"));
				statusTask.setStatusName(result.getString("status_name"));
				listStatus.add(statusTask);
			}
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return listStatus;
	}
}
