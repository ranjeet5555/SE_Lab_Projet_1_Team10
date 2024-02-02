package com.user.servlet;

import java.io.IOException;

import com.DAO.userDAOimpl;
import com.DB.DBconnect;
import com.entity.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			String name = req.getParameter("fname");
			String email = req.getParameter("email");
			String phone = req.getParameter("phone");
			String password = req.getParameter("password");
			String check = req.getParameter("check");
			
//			System.out.println(name+" "+email+" "+phone+" "+password+" "+check); 
			
			
			User us = new  User();
			us.setName(name);
			us.setEmail(email);
			us.setPhone(phone);
			us.setPassword(password);
			
			
			HttpSession session = req.getSession();
			
			if(check!=null) {
				userDAOimpl dao = new userDAOimpl(DBconnect.getConn());
				boolean f = dao.userRegister(us);
				
				if(f) {
//					System.out.println("User Register Success..");
					session.setAttribute("SuccMsg", "Registration Successfully...");
					resp.sendRedirect("register.jsp");
				}
				else {
//					System.out.println("Something wrong on Server..");
					session.setAttribute("failedMsg", "Something wrong on Server..");
					resp.sendRedirect("register.jsp");
				}
			}
			else {
//				System.out.println("Please check Agree & Terms Conditions");
				session.setAttribute("failedMsg", "Please check Agree & Terms Conditions");
				resp.sendRedirect("register.jsp");
			}
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
}
