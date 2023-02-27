package com.crmapp.api;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.crmapp.model.UsersModel;
import com.crmapp.pojo.Users;

@WebServlet("/api/updateuser")
public class ApiUpdateUserController extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Users users = new Users();
		UsersModel usersModel = new UsersModel();
		long id = Long.parseLong(req.getParameter("iduser")) ;
		String name = req.getParameter("ufullname");
		String email =req.getParameter("uemail");
		String password = req.getParameter("upassword");
		String address = req.getParameter("uaddress");
		String phoneNumber = req.getParameter("uphone");
		usersModel.updateUser(id, name, email,password, address, phoneNumber);
	}
	
}
