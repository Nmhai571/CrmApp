package com.crmapp.api;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.crmapp.model.TaskModel;

@WebServlet("/api/daletetask")
public class ApiDeleteTaskController extends HttpServlet{
	TaskModel taskModel = new TaskModel();
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		long id = Long.parseLong(req.getParameter("id")) ;
		taskModel.deleteTask(id);
	}
}
