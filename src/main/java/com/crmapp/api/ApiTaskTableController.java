package com.crmapp.api;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.crmapp.model.TaskModel;
import com.crmapp.pojo.Task;
import com.google.gson.Gson;

@WebServlet("/api/tasktable")
public class ApiTaskTableController extends HttpServlet {
	TaskModel taskModel = new TaskModel();
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Task> listTask = taskModel.getListTask();
		Gson gson = new Gson();
		String json = gson.toJson(listTask);

		resp.setContentType("application/json");
		resp.setCharacterEncoding("UTF-8");
		
		PrintWriter writer = resp.getWriter();
		writer.write(json);
		writer.flush();
		writer.close();
	}
}
