package com.crmapp.api;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.crmapp.common.Constant;
import com.crmapp.model.UsersModel;
import com.crmapp.pojo.ResponeData;
import com.crmapp.pojo.Users;
import com.google.gson.Gson;


@WebServlet("/api/adduser")
public class ApiAdduserController extends HttpServlet{
	UsersModel usersModel = new UsersModel();
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Users users = new Users();
		
		users.setFullName(req.getParameter("fullname"));
		users.setEmail(req.getParameter("email"));
		users.setPassword(req.getParameter("password"));
		users.setPhoneNumber(req.getParameter("phonenumber"));
		users.setAddress(req.getParameter("address"));
		users.setRoleId(Constant.ROLE_USER);
		
		boolean isSuccess =  usersModel.insertUser(users);
		
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
